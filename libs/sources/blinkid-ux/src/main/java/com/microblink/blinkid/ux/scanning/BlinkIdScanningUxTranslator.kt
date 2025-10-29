/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.blinkid.ux.scanning

import com.microblink.blinkid.core.result.ImageAnalysisDetectionStatus
import com.microblink.blinkid.core.result.ImageAnalysisLightingStatus
import com.microblink.blinkid.core.result.ImageExtractionType
import com.microblink.blinkid.core.result.ProcessingStatus
import com.microblink.blinkid.core.result.ScanningSide
import com.microblink.blinkid.core.result.ScanningStatus
import com.microblink.blinkid.core.result.classinfo.Country
import com.microblink.blinkid.core.result.classinfo.Type
import com.microblink.blinkid.core.session.BlinkIdProcessResult
import com.microblink.blinkid.core.session.BlinkIdScanningSession
import com.microblink.blinkid.ux.state.PassportPage
import com.microblink.blinkid.ux.state.PassportType
import com.microblink.core.image.InputImage
import com.microblink.core.session.DetectionStatus
import com.microblink.ux.ScanningUxEvent
import com.microblink.ux.state.DocumentSide
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Translates [BlinkIdProcessResult] and other scanning session information into a
 * list of [ScanningUxEvent] objects.
 *
 * This class is responsible for interpreting the results of the document
 * scanning process and generating user experience-related events that can be
 * used to update the UI or provide feedback to the user. It handles logic
 * related to document sides, timeouts, and various detection statuses.
 *
 */
class BlinkIdScanningUxTranslator : BlinkIdUxTranslator {

    private val backToBarcodeTimeout = 3.seconds
    private var barcodeDispatched = false

    private var passportType: PassportType? = null

    private var currentSide = DocumentSide.Front

    private var firstBackRequestedTimestamp: Long? = null

    /**
     * Translates the given [BlinkIdProcessResult], [InputImage], and [BlinkIdScanningSession]
     * into a list of [ScanningUxEvent] objects.
     *
     * This function analyzes the current state of the scanning session and the
     * results of the last image processing step to determine which UX events
     * should be generated.
     *
     * @param processResult The [BlinkIdProcessResult] from the scanning session.
     * @param inputImage The [InputImage] used for the process. Can be `null`.
     * @param session The [BlinkIdScanningSession] that was used for the process.
     * @return A list of [ScanningUxEvent] objects representing the user
     *         experience events that should be dispatched.
     */
    override suspend fun translate(
        processResult: BlinkIdProcessResult,
        inputImage: InputImage?,
        session: BlinkIdScanningSession,
    ): List<ScanningUxEvent> {
        val events = mutableListOf<ScanningUxEvent>()

        val imageAnalysisResult = processResult.inputImageAnalysisResult

        if (processResult.resultCompleteness.isComplete()) {
            events.add(ScanningUxEvent.ScanningDone)
            return events
        }

        imageAnalysisResult.documentClassInfo.type?.takeIf { it == Type.Passport }?.let {
            passportType = if (
                imageAnalysisResult.documentClassInfo.country == Country.Usa ||
                imageAnalysisResult.documentClassInfo.country == Country.India
            ) {
                PassportType.BackSideBarcode
            } else {
                PassportType.Regular
            }
        }

        if (currentSide == DocumentSide.Front) {
            if (processResult.resultCompleteness.scanningStatus == ScanningStatus.SideScanned) {
                currentSide = DocumentSide.Back
                if (passportType != null) {
                    events.add(
                        RequestPassportPage(
                            documentRotation = imageAnalysisResult.documentRotation,
                            isBarcodePageRequested = passportType == PassportType.BackSideBarcode
                        )
                    )
                } else {
                    events.add(ScanningUxEvent.RequestDocumentSide(DocumentSide.Back))
                }
            }
        } else if (currentSide == DocumentSide.Back) {
            if (processResult.inputImageAnalysisResult.scanningSide != ScanningSide.Second) {
                currentSide = DocumentSide.Front
            } else if (firstBackRequestedTimestamp == null) {
                firstBackRequestedTimestamp = System.nanoTime()
            } else {
                if (shouldRequestBarcode(processResult)) {
                    barcodeDispatched = true
                    session.setAllowBarcodeStep()
                    events.add(ScanningUxEvent.RequestDocumentSide(DocumentSide.Barcode))
                }
            }
        }
        if (events.isNotEmpty()) return events

        if (imageAnalysisResult.documentLocation != null) {
            events.add(
                if (inputImage != null) {
                    BlinkIdDocumentLocatedLocation(
                        location = imageAnalysisResult.documentLocation!!,
                        inputImage = inputImage
                    )
                } else {
                    ScanningUxEvent.DocumentLocated
                }
            )
        } else {
            events.add(ScanningUxEvent.DocumentNotFound)
        }

        // below just one event can be generated, by following priorities
        var hasEvents = false

        when (imageAnalysisResult.processingStatus) {

            ProcessingStatus.AwaitingOtherSide -> {
                when (passportType) {
                    PassportType.Regular -> events.add(
                        RequestPassportPage(
                            documentRotation = imageAnalysisResult.documentRotation,
                            isBarcodePageRequested = false
                        )
                    )

                    PassportType.BackSideBarcode -> events.add(
                        RequestPassportPage(
                            documentRotation = imageAnalysisResult.documentRotation,
                            isBarcodePageRequested = true
                        )
                    )

                    null -> events.add(ScanningUxEvent.RequestDocumentSide(side = currentSide))
                }
                hasEvents = true
            }

            ProcessingStatus.ScanningWrongSide -> {
                val isScanningDataPage = currentSide == DocumentSide.Front
                events.add(
                    when (passportType) {
                        PassportType.Regular -> ScanningWrongPassportPage(
                            activePassportPage = if (isScanningDataPage) PassportPage.Data else null,
                            documentRotation = imageAnalysisResult.documentRotation
                        )

                        PassportType.BackSideBarcode -> ScanningWrongPassportPage(
                            activePassportPage = if (isScanningDataPage) PassportPage.Data else PassportPage.Barcode,
                            documentRotation = imageAnalysisResult.documentRotation
                        )

                        else -> ScanningUxEvent.ScanningWrongSide
                    }
                )
                hasEvents = true
            }

            ProcessingStatus.ImageReturnFailed -> {
                if (processResult.inputImageAnalysisResult.imageExtractionFailures.contains(
                        ImageExtractionType.Face
                    )
                ) {
                    events.add(ScanningUxEvent.FaceImageNotFound)
                    hasEvents = true
                }

            }

            ProcessingStatus.MandatoryFieldMissing, ProcessingStatus.MrzParsingFailed, ProcessingStatus.InvalidCharactersFound -> {
                events.add(
                    ScanningUxEvent.DocumentNotFullyVisible
                )
                hasEvents = true
            }

            else -> {}
        }

        if (hasEvents) {
            events.add(DocumentImageAnalysisResult(imageAnalysisResult = imageAnalysisResult))
            return events
        }

        hasEvents = true

        when (imageAnalysisResult.documentDetectionStatus) {
            DetectionStatus.CameraTooFar -> events.add(ScanningUxEvent.DocumentTooFar)
            DetectionStatus.CameraTooClose -> events.add(ScanningUxEvent.DocumentTooClose)
            DetectionStatus.DocumentPartiallyVisible -> events.add(ScanningUxEvent.DocumentNotFullyVisible)
            DetectionStatus.DocumentTooCloseToCameraEdge -> events.add(ScanningUxEvent.DocumentTooCloseToCameraEdge)
            DetectionStatus.CameraAngleTooSteep -> events.add(ScanningUxEvent.DocumentTooTilted)
            else -> {
                hasEvents = false
            }
        }

        if (hasEvents) {
            events.add(DocumentImageAnalysisResult(imageAnalysisResult = imageAnalysisResult))
            return events
        }

        hasEvents = true

        if (imageAnalysisResult.glareDetectionStatus == ImageAnalysisDetectionStatus.Detected) {
            events.add(
                ScanningUxEvent.GlareDetected
            )
        } else if (imageAnalysisResult.blurDetectionStatus == ImageAnalysisDetectionStatus.Detected) {
            events.add(
                ScanningUxEvent.BlurDetected
            )
        } else if (imageAnalysisResult.documentHandOcclusionStatus == ImageAnalysisDetectionStatus.Detected) {
            events.add(
                ScanningUxEvent.DocumentNotFullyVisible
            )
        } else if (imageAnalysisResult.documentLightingStatus == ImageAnalysisLightingStatus.TooBright) {
            events.add(
                ScanningUxEvent.DocumentTooBright
            )
        } else if (imageAnalysisResult.documentLightingStatus == ImageAnalysisLightingStatus.TooDark) {
            events.add(
                ScanningUxEvent.DocumentTooDark
            )
        } else {
            hasEvents = false
        }

        if (hasEvents) {
            events.add(DocumentImageAnalysisResult(imageAnalysisResult = imageAnalysisResult))
            return events
        }

        events.add(ScanningUxEvent.DocumentNotFound)
        events.add(ScanningUxEvent.RequestDocumentSide(side = currentSide))
        events.add(DocumentImageAnalysisResult(imageAnalysisResult = imageAnalysisResult))
        return events
    }

    fun resetSession() {
        firstBackRequestedTimestamp = null
        barcodeDispatched = false
        passportType = null
    }

    private fun shouldRequestBarcode(processResult: BlinkIdProcessResult): Boolean {
        return (System.nanoTime() - firstBackRequestedTimestamp!!).nanoseconds > backToBarcodeTimeout && processResult.inputImageAnalysisResult.processingStatus == ProcessingStatus.BarcodeRecognitionFailed && !barcodeDispatched
    }
}