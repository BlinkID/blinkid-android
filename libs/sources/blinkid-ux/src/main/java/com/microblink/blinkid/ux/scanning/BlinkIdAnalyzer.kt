/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.blinkid.ux.scanning

import android.util.Log
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageProxy
import com.microblink.blinkid.core.BlinkIdSdk
import com.microblink.blinkid.core.session.BlinkIdScanningSession
import com.microblink.blinkid.core.session.BlinkIdSessionSettings
import com.microblink.blinkid.ux.settings.BlinkIdUxSettings
import com.microblink.core.RemoteLicenseCheckException
import com.microblink.core.image.InputImage
import com.microblink.ux.ScanningUxEventHandler
import com.microblink.ux.camera.ImageAnalyzer
import com.microblink.ux.utils.ErrorReason
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Analyzes images from the camera and processes them using the BlinkID SDK.
 *
 * This class implements the [ImageAnalyzer] interface and is responsible for
 * receiving image frames from the camera, sending them to the BlinkID
 * SDK for processing and results handling. It also manages the scanning
 * session, timeouts, and dispatches UI events.
 *
 * @param blinkIdSdk An instance of the [BlinkIdSdk] used for processing images.
 * @param sessionSettings The [BlinkIdSessionSettings] used to configure the capture session.
 * @property uxSettings The [BlinkIdUxSettings] used to customize the UX.
 * @property scanningDoneHandler A [BlinkIdScanningDoneHandler] to handle the completion
 *                                of the scanning process.
 * @property uxEventHandler An optional [ScanningUxEventHandler] to handle UI events.
 *
 */
class BlinkIdAnalyzer(
    blinkIdSdk: BlinkIdSdk,
    sessionSettings: BlinkIdSessionSettings,
    private val uxSettings: BlinkIdUxSettings,
    private val scanningDoneHandler: BlinkIdScanningDoneHandler,
    private val uxEventHandler: ScanningUxEventHandler? = null,
) : ImageAnalyzer {
    private val TAG = "BlinkIdAnalyzer"

    private var session: BlinkIdScanningSession? = null
    private var analysisPaused = false
    private var firstImageTimestamp: Long? = null
    private val scanningUxTranslator = BlinkIdScanningUxTranslator()
    private val stepTimeoutDuration: Duration? =
        if (uxSettings.stepTimeoutDuration == Duration.ZERO) null else uxSettings.stepTimeoutDuration

    init {
        CoroutineScope(Default).launch {
            session = blinkIdSdk.createScanningSession(sessionSettings)
        }
    }

    /**
     * Analyzes an image from the camera.
     *
     * This function is called for each frame captured by the camera. It sends the
     * image to the BlinkID SDK for processing and handles the results,
     * timeouts and cancellations.
     *
     * Current implementation of the analyzer cancels the session if the timeout occurs.
     * The timeout timer restarts every time the scanning is paused (onboarding dialog,
     * help dialog, card flip animation). Default timeout value can be checked at
     * [BlinkIdUxSettings.stepTimeoutDuration].
     *
     * @param image The [ImageProxy] containing the image to be analyzed.
     *
     */
    @OptIn(ExperimentalGetImage::class)
    override fun analyze(image: ImageProxy) {
        if (analysisPaused) return
        if (firstImageTimestamp == null && stepTimeoutDuration != null) {
            firstImageTimestamp = System.nanoTime()
        }
        runBlocking {
            val inputImage = InputImage.createFromCameraXImageProxy(image)
            inputImage.use {
                session?.let { session ->
                    try {
                        val sessionProcessResult = session.process(inputImage)
                        if (session.isCanceled) {
                            Log.w(TAG, "processing has been canceled")
                        } else {
                            sessionProcessResult.getOrNull()?.let { processResult ->

                                uxSettings.classFilter?.let {
                                    if (!processResult.inputImageAnalysisResult.documentClassInfo.isEmpty()
                                        && !it.classAllowed(
                                            processResult.inputImageAnalysisResult.documentClassInfo
                                        )
                                    ) {
                                        pauseAnalysis()
                                        scanningUxTranslator.resetSession()
                                        scanningDoneHandler.onError(ErrorReason.ErrorDocumentClassFiltered)
                                        return@runBlocking
                                    }
                                }

                                uxEventHandler?.dispatchBlinkIdEvents(
                                    scanningUxTranslator,
                                    processResult,
                                    inputImage,
                                    session
                                )

                                if (processResult.resultCompleteness.isComplete()) {
                                    val sessionResult = session.getResult()
                                    pauseAnalysis()
                                    scanningDoneHandler.onScanningFinished(sessionResult)
                                } else if (stepTimeoutDuration != null) {
                                    firstImageTimestamp?.let { timestamp ->
                                        val currentDuration =
                                            (System.nanoTime() - timestamp).toDuration(DurationUnit.NANOSECONDS)
                                        if (currentDuration > stepTimeoutDuration) {
                                            Log.w(TAG, "processing timeout occurred")
                                            pauseAnalysis()
                                            scanningUxTranslator.resetSession()
                                            scanningDoneHandler.onError(ErrorReason.ErrorTimeoutExpired)
                                            // finish with whatever result we have
                                        } else {
                                            Log.v(TAG, "continuing processing...")
                                        }
                                    }
                                } else {
                                    Log.v(TAG, "Neither complete nor timeout, continuing...")
                                }
                            }
                        }
                    } catch (e: RemoteLicenseCheckException) {
                        scanningDoneHandler.onError(ErrorReason.ErrorInvalidLicense)
                    }
                }
            }
        }
    }

    override fun pauseAnalysis() {
        analysisPaused = true
        firstImageTimestamp = null
    }

    override fun resumeAnalysis() {
        analysisPaused = false
    }

    override fun cancel() {
        session?.cancelActiveProcess()
        scanningDoneHandler.onScanningCanceled()
    }

    override fun restartAnalysis() {
        CoroutineScope(Default).launch {
            session?.restartSession()
        }
        analysisPaused = false
    }

    override fun close() {
        val s = session
        session = null
        s?.close()
    }
}
