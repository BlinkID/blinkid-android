/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.blinkid.ux.scanning

import com.microblink.blinkid.core.result.DocumentRotation
import com.microblink.blinkid.core.result.InputImageAnalysisResult
import com.microblink.blinkid.core.session.BlinkIdProcessResult
import com.microblink.blinkid.core.session.BlinkIdScanningResult
import com.microblink.blinkid.core.session.BlinkIdScanningSession
import com.microblink.blinkid.ux.state.PassportPage
import com.microblink.core.geometry.Quadrilateral
import com.microblink.core.image.InputImage
import com.microblink.ux.ScanningUxEvent
import com.microblink.ux.ScanningUxEventHandler
import com.microblink.ux.utils.ErrorReason

interface BlinkIdScanningDoneHandler {
    fun onScanningFinished(result: BlinkIdScanningResult)

    fun onScanningCanceled()

    fun onError(error: ErrorReason)
}

/**
 * The document has been located by the recognizer.
 *
 * @property location Specified the exact coordinates of the document.
 * @property inputImage Image of the located document.
 */
data class BlinkIdDocumentLocatedLocation(
    val location: Quadrilateral,
    val inputImage: InputImage
) : ScanningUxEvent

/**
 * Event that holds all the information about the currently scan.
 *
 * @property imageAnalysisResult Represents the result of a scan analysis during document processing.
 */
data class DocumentImageAnalysisResult(
    val imageAnalysisResult: InputImageAnalysisResult
) : ScanningUxEvent

/**
 * Event that holds information about the passport page that needs
 * to be presented in order to continue the scanning process.
 *
 * @property isBarcodePageRequested Indicates whether the requested page is the barcode page.
 * @property documentRotation Represents the information of the passport page rotation.
 * This data should be corrected based on the rotation of the device by using [com.microblink.blinkid.ux.utils.getCorrectedDocumentRotation] function.
 */
data class RequestPassportPage(
    val isBarcodePageRequested: Boolean,
    val documentRotation: DocumentRotation
): ScanningUxEvent

/**
 * Event that holds information about the incorrect passport page that is
 * currently being scanned.
 *
 * @property activePassportPage Represents the current passport page that is being scanned.
 * Used only for [PassportPage.Barcode] and [PassportPage.Data] since screen orientation is also required to determine other page orientations.
 * @property documentRotation Represents the information of the passport page rotation.
 * This data should be corrected based on the rotation of the device by using [com.microblink.blinkid.ux.utils.getCorrectedDocumentRotation] function.
 */
data class ScanningWrongPassportPage(
    val activePassportPage: PassportPage?,
    val documentRotation: DocumentRotation
): ScanningUxEvent

/**
 * Dispatches user experience events to the [ScanningUxEventHandler] after translating
 * the process results.
 *
 * This extension function simplifies the process of translating [BlinkIdProcessResult] from
 * the scanning session into a list of [ScanningUxEvent] objects and then
 * dispatching these events to the [ScanningUxEventHandler].
 *
 * @receiver The [ScanningUxEventHandler] to which the translated events will be dispatched.
 * @param translator The [BlinkIdUxTranslator] used to translate the process result into
 *                   [ScanningUxEvent] objects.
 * @param processResult The [BlinkIdProcessResult] from the scanning session.
 * @param inputImage The [InputImage] used for the process. Can be `null`.
 * @param session The [BlinkIdScanningSession] that was used for the process.
 */
suspend fun ScanningUxEventHandler.dispatchBlinkIdEvents(
    translator: BlinkIdUxTranslator,
    processResult: BlinkIdProcessResult,
    inputImage: InputImage?,
    session: BlinkIdScanningSession
) {
    onUxEvents(translator.translate(processResult, inputImage, session))
}