/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.blinkid.ux

import android.os.CountDownTimer
import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.microblink.blinkid.core.BlinkIdSdk
import com.microblink.blinkid.core.session.BlinkIdScanningResult
import com.microblink.blinkid.core.session.BlinkIdSessionSettings
import com.microblink.blinkid.ux.scanning.BlinkIdAnalyzer
import com.microblink.blinkid.ux.scanning.BlinkIdDocumentLocatedLocation
import com.microblink.blinkid.ux.scanning.BlinkIdScanningDoneHandler
import com.microblink.blinkid.ux.scanning.DocumentImageAnalysisResult
import com.microblink.blinkid.ux.scanning.RequestPassportPage
import com.microblink.blinkid.ux.scanning.ScanningWrongPassportPage
import com.microblink.blinkid.ux.settings.BlinkIdUxSettings
import com.microblink.blinkid.ux.state.BlinkIdStatusMessage
import com.microblink.blinkid.ux.state.BlinkIdUiState
import com.microblink.blinkid.ux.state.PassportPage
import com.microblink.blinkid.ux.state.ShowPassportMoveToLeft
import com.microblink.blinkid.ux.state.ShowPassportMoveToRight
import com.microblink.blinkid.ux.state.ShowPassportMoveToTop
import com.microblink.blinkid.ux.utils.getCorrectedDocumentRotation
import com.microblink.blinkid.ux.utils.getPassportPageFromRotation
import com.microblink.ux.ScanningUxEvent
import com.microblink.ux.ScanningUxEventHandler
import com.microblink.ux.UiSettings
import com.microblink.ux.camera.CameraViewModel
import com.microblink.ux.camera.ImageAnalyzer
import com.microblink.ux.state.CardAnimationState
import com.microblink.ux.state.CardAnimationState.ShowFlipLandscape
import com.microblink.ux.state.CommonStatusMessage
import com.microblink.ux.state.DocumentSide
import com.microblink.ux.state.DocumentSide.Back
import com.microblink.ux.state.DocumentSide.Barcode
import com.microblink.ux.state.DocumentSide.Front
import com.microblink.ux.state.ErrorState
import com.microblink.ux.state.MbTorchState
import com.microblink.ux.state.ProcessingState
import com.microblink.ux.state.ReticleState
import com.microblink.ux.state.StatusMessage
import com.microblink.ux.utils.ErrorReason
import com.microblink.ux.utils.ScreenOrientation
import com.microblink.ux.utils.toErrorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.DurationUnit
import kotlin.time.toDuration

internal class BlinkIdUxViewModel(
    blinkIdSdkInstance: BlinkIdSdk,
    sessionSettings: BlinkIdSessionSettings,
    uxSettings: BlinkIdUxSettings
) :
    CameraViewModel() {
    private var imageAnalyzer: ImageAnalyzer? = null

    private val _uiState = MutableStateFlow(BlinkIdUiState())
    val uiState: StateFlow<BlinkIdUiState> = _uiState.asStateFlow()

    var uiStateStartTime: Duration = Duration.ZERO
    lateinit var lastEvent: ScanningUxEvent
    var isScanningDone: Boolean = false

    private val helpTooltipTimer = object : CountDownTimer(8000, 8000) {
        override fun onTick(millisUntilFinished: Long) {
        }

        override fun onFinish() {
            changeHelpTooltipVisibility(true)
        }

    }

    init {
        viewModelScope.launch {
            imageAnalyzer = BlinkIdAnalyzer(
                blinkIdSdk = blinkIdSdkInstance,
                sessionSettings = sessionSettings,
                uxSettings = uxSettings,
                scanningDoneHandler = object : BlinkIdScanningDoneHandler {
                    override fun onScanningFinished(result: BlinkIdScanningResult) {
                        _uiState.update {
                            it.copy(blinkIdScanningResult = result)
                        }
                    }

                    override fun onError(error: ErrorReason) {
                        _uiState.update {
                            it.copy(
                                errorState = error.toErrorState(),
                                processingState = ProcessingState.ErrorDialog
                            )
                        }
                    }

                    override fun onScanningCanceled() {}
                },
                uxEventHandler = object : ScanningUxEventHandler {
                    override fun onUxEvents(events: List<ScanningUxEvent>) {
                        for (event in events) {
                            when (event) {
                                is ScanningUxEvent.ScanningDone -> {
                                    isScanningDone = true
                                    imageAnalyzer?.pauseAnalysis()

                                    _uiState.update {
                                        it.copy(
                                            statusMessage = CommonStatusMessage.Empty,
                                            processingState = ProcessingState.SuccessAnimation,
                                            reticleState = ReticleState.Success
                                        )
                                    }
                                    break
                                }

                                is ScanningUxEvent.DocumentNotFound -> {
                                    val newProcessingState = ProcessingState.Sensing

                                    if (!shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        _uiState.update {
                                            it.copy(
                                                processingState = newProcessingState,
                                                statusMessage =
                                                    if (it.activePassportPage != null) {
                                                        when (it.activePassportPage) {
                                                            PassportPage.Top -> BlinkIdStatusMessage.PassportScanTopPage
                                                            PassportPage.Right -> BlinkIdStatusMessage.PassportScanRightPage
                                                            PassportPage.Left -> BlinkIdStatusMessage.PassportScanLeftPage
                                                            else -> BlinkIdStatusMessage.PassportScanTopPage
                                                        }
                                                    } else
                                                        when (it.currentSide) {
                                                            Front -> CommonStatusMessage.ScanFrontSide
                                                            Back -> CommonStatusMessage.ScanBackSide
                                                            else -> CommonStatusMessage.ScanBarcode
                                                        }
                                            )
                                        }
                                        updateStateStartTime()
                                    }

                                }

                                is ScanningUxEvent.DocumentLocated, is BlinkIdDocumentLocatedLocation -> {
                                    val newProcessingState = ProcessingState.Processing
                                    if (!shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        _uiState.update {
                                            it.copy(
                                                processingState = newProcessingState,
                                                statusMessage = CommonStatusMessage.Empty
                                            )
                                        }
                                        updateStateStartTime()
                                    }
                                }


                                is ScanningUxEvent.BlurDetected -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        break
                                    }
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.EliminateBlur
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.DocumentNotFullyVisible -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        break
                                    }
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.KeepDocumentVisible
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.FaceImageNotFound -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) break
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.KeepFacePhotoVisible
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.DocumentTooBright -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) break
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.DecreaseLightingIntensity
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.DocumentTooDark -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) break
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.IncreaseLightingIntensity
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.DocumentTooClose -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        break
                                    }
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.MoveFarther
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.DocumentTooCloseToCameraEdge -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            ProcessingState.Error
                                        )
                                    ) {
                                        break
                                    }
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.MoveDocumentFromEdge
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.DocumentTooFar -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        break
                                    }
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.MoveCloser
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.DocumentTooTilted -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        break
                                    }
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.AlignDocument
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.GlareDetected -> {
                                    val newProcessingState = ProcessingState.Error
                                    if (shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            newProcessingState
                                        )
                                    ) {
                                        break
                                    }
                                    _uiState.update {
                                        it.copy(
                                            processingState = newProcessingState,
                                            statusMessage = CommonStatusMessage.EliminateGlare
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningUxEvent.ScanningWrongSide -> {
                                    _uiState.update {
                                        it.copy(
                                            processingState = ProcessingState.Error,
                                            statusMessage = CommonStatusMessage.ScanningWrongSide
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is ScanningWrongPassportPage -> {
                                    val page =
                                        if (event.isScanningDataPage == true) {
                                            PassportPage.Data
                                        } else {
                                            getPassportPageFromRotation(
                                                getCorrectedDocumentRotation(
                                                    event.documentRotation,
                                                    uiState.value.screenOrientation
                                                )
                                            )
                                        }
                                    _uiState.update {
                                        it.copy(
                                            processingState = ProcessingState.Error,
                                            statusMessage = when (page) {
                                                PassportPage.Top -> BlinkIdStatusMessage.PassportWrongPageTop
                                                PassportPage.Right -> BlinkIdStatusMessage.PassportWrongPageRight
                                                PassportPage.Left -> BlinkIdStatusMessage.PassportWrongPageLeft
                                                PassportPage.Data -> BlinkIdStatusMessage.ScanPassportDataPage
                                            },
                                            activePassportPage = page
                                        )
                                    }
                                    updateStateStartTime()
                                }

                                is RequestPassportPage -> {
                                    imageAnalyzer?.pauseAnalysis()
                                    val page =
                                        getPassportPageFromRotation(
                                            getCorrectedDocumentRotation(
                                                event.documentRotation,
                                                uiState.value.screenOrientation
                                            )
                                        )
                                    _uiState.update {
                                        it.copy(
                                            processingState = ProcessingState.SuccessAnimation,
                                            statusMessage = CommonStatusMessage.Empty,
                                            activePassportPage = page
                                        )
                                    }
                                }

                                is ScanningUxEvent.RequestDocumentSide -> {
                                    var currentSide: DocumentSide = uiState.value.currentSide
                                    var statusMessage: StatusMessage =
                                        uiState.value.statusMessage
                                    var cardAnimationState: CardAnimationState =
                                        uiState.value.cardAnimationState
                                    var processingState: ProcessingState =
                                        uiState.value.processingState

                                    when (uiState.value.currentSide) {
                                        Front -> {
                                            when (event.side) {
                                                Front -> {
                                                }

                                                Back -> {
                                                    // TODO: support for portrait animations
                                                    processingState =
                                                        ProcessingState.SuccessAnimation
                                                    statusMessage = CommonStatusMessage.Empty
                                                    imageAnalyzer?.pauseAnalysis()
                                                }

                                                Barcode -> {
                                                    processingState = ProcessingState.Sensing
                                                    statusMessage =
                                                        CommonStatusMessage.ScanBarcode
                                                    currentSide = Barcode
                                                }
                                            }
                                        }

                                        Back -> {
                                            when (event.side) {
                                                Front -> {}

                                                Back -> {}

                                                Barcode -> {
                                                    // TODO: add should stay in processing state
                                                    processingState = ProcessingState.Sensing
                                                    statusMessage =
                                                        CommonStatusMessage.ScanBarcode
                                                    currentSide = Barcode
                                                }
                                            }
                                        }

                                        Barcode -> {
                                            // impossible to reach anything else other than barcode
                                            statusMessage = CommonStatusMessage.ScanBarcode
                                        }
                                    }

                                    if (!shouldStayInCurrentState(
                                            uiState.value.processingState,
                                            processingState
                                        )
                                    ) {
                                        _uiState.update {
                                            it.copy(
                                                processingState = processingState,
                                                statusMessage = statusMessage,
                                                currentSide = currentSide,
                                                cardAnimationState = cardAnimationState
                                            )
                                        }
                                    }


                                }

                                is DocumentImageAnalysisResult -> {
                                    // Not used in this UI implementation.
                                    // Can be used for additional frame debugging.
                                }
                            }
                            lastEvent = event
                        }
                    }
                }
            )
        }
    }

    fun setInitialUiStateFromUiSettings(uiSettings: UiSettings) {
        _uiState.update {
            it.copy(
                helpButtonDisplayed = uiSettings.showHelpButton,
                onboardingDialogDisplayed = uiSettings.showOnboardingDialog
            )
        }
        if (_uiState.value.onboardingDialogDisplayed) {
            changeOnboardingDialogVisibility(true)
        } else {
            changeOnboardingDialogVisibility(false)
        }
    }

    fun setScreenOrientation(screenOrientation: ScreenOrientation) {
        _uiState.update {
            it.copy(
                screenOrientation = screenOrientation
            )
        }
    }


    override fun analyzeImage(image: ImageProxy) {
        image.use {
            imageAnalyzer?.analyze(it)
        }
    }

    fun shouldStayInCurrentState(
        currentState: ProcessingState,
        newState: ProcessingState,
    ): Boolean {
        return if (currentState == newState) true
        else if (newState.reticleState == ReticleState.Success) false
        else if (_uiState.value.cardAnimationState != CardAnimationState.Hidden) true
        else if (currentState.reticleState == ReticleState.IndefiniteProgress && newState.reticleState == ReticleState.Error) false
        else if ((System.nanoTime().nanoseconds - uiStateStartTime) < currentState.minDuration) true
        else false
    }

    fun onFlipAnimationCompleted() {
        _uiState.update {
            it.copy(
                cardAnimationState = CardAnimationState.Hidden
            )
        }
        if (!_uiState.value.onboardingDialogDisplayed && !_uiState.value.helpDisplayed) {
            imageAnalyzer?.resumeAnalysis()
            helpTooltipTimer.start()
        }
    }

    private fun updateStateStartTime() {
        uiStateStartTime =
            System.nanoTime()
                .toDuration(DurationUnit.NANOSECONDS)
    }

    fun changeTorchState() {
        when (_uiState.value.torchState) {
            MbTorchState.On -> {
                _torchOn.value = false
                _uiState.update {
                    it.copy(torchState = MbTorchState.Off)
                }
            }

            MbTorchState.Off -> {
                _torchOn.value = true
                _uiState.update {
                    it.copy(torchState = MbTorchState.On)
                }
            }

            MbTorchState.NotSupportedByCamera -> {}
        }
    }

    fun changeHelpTooltipVisibility(show: Boolean) {
        if (_uiState.value.helpButtonDisplayed) {
            _uiState.update {
                it.copy(helpTooltipDisplayed = show)
            }
        }
    }

    fun changeOnboardingDialogVisibility(show: Boolean) {
        if (show) {
            imageAnalyzer?.pauseAnalysis()
            helpTooltipTimer.cancel()
        } else {
            imageAnalyzer?.resumeAnalysis()
            helpTooltipTimer.start()
        }
        _uiState.update {
            it.copy(onboardingDialogDisplayed = show)
        }
    }

    fun changeHelpScreensVisibility(show: Boolean) {
        if (show) {
            imageAnalyzer?.pauseAnalysis()
            helpTooltipTimer.cancel()
        } else {
            imageAnalyzer?.resumeAnalysis()
            helpTooltipTimer.start()
        }
        _uiState.update {
            it.copy(helpDisplayed = show)
        }
    }

    fun onRetryTimeout() {
        helpTooltipTimer.cancel()
        _uiState.update {
            it.copy(
                errorState = ErrorState.NoError,
                processingState = ProcessingState.Sensing,
                statusMessage = CommonStatusMessage.ScanFrontSide,
                currentSide = Front,
                activePassportPage = null
            )
        }
        updateStateStartTime()
        imageAnalyzer?.restartAnalysis()
        helpTooltipTimer.start()
    }

    fun onReticleSuccessAnimationCompleted() {
        // TODO: update to work with barcode
        if (!isScanningDone) {
            if (_uiState.value.activePassportPage != null) {
                _uiState.update {
                    it.copy(
                        processingState = ProcessingState.CardAnimation,
                        statusMessage = when (it.activePassportPage) {
                            PassportPage.Top -> BlinkIdStatusMessage.PassportMoveToTop
                            PassportPage.Right -> BlinkIdStatusMessage.PassportMoveToRight
                            PassportPage.Left -> BlinkIdStatusMessage.PassportMoveToLeft
                            else -> BlinkIdStatusMessage.ScanPassportDataPage
                        },
                        currentSide = Back,
                        cardAnimationState =
                            when (it.activePassportPage) {
                                PassportPage.Top -> ShowPassportMoveToTop
                                PassportPage.Right -> ShowPassportMoveToRight
                                PassportPage.Left -> ShowPassportMoveToLeft
                                else -> ShowPassportMoveToTop
                            }
                    )
                }
            } else {
                _uiState.update {
                    it.copy(
                        processingState =
                            ProcessingState.CardAnimation,
                        statusMessage = CommonStatusMessage.FlipDocument,
                        currentSide = Back,
                        cardAnimationState =
                            ShowFlipLandscape
                    )
                }

            }
        } else {
            _uiState.update {
                it.copy(
                    processingState = ProcessingState.Success
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        imageAnalyzer?.cancel()
        imageAnalyzer?.close()
    }

    companion object {
        private const val TAG = "BlinkIdUxViewModel"

        // Define a custom key for your dependency
        val BLINKID_SDK =
            object : CreationExtras.Key<BlinkIdSdk> {}
        val BLINKID_SESSION_SETTINGS =
            object : CreationExtras.Key<BlinkIdSessionSettings> {}
        val BLINKID_UX_SETTINGS =
            object : CreationExtras.Key<BlinkIdUxSettings> {}
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                BlinkIdUxViewModel(
                    this[BLINKID_SDK] as BlinkIdSdk,
                    this[BLINKID_SESSION_SETTINGS] as BlinkIdSessionSettings,
                    this[BLINKID_UX_SETTINGS] as BlinkIdUxSettings
                )
            }
        }
    }
}