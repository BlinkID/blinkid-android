/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.blinkid.ux

import android.content.Context
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
import com.microblink.blinkid.core.utils.ping.sendPingletsIfAllowed
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
import com.microblink.blinkid.ux.utils.UxPingletTracker
import com.microblink.blinkid.ux.utils.getCorrectedDocumentRotation
import com.microblink.blinkid.ux.utils.getPassportPageFromRotation
import com.microblink.core.ping.config.PingSendTriggerPoint
import com.microblink.core.ping.pinglets.UxEvent
import com.microblink.ux.ScanningUxEvent
import com.microblink.ux.ScanningUxEventHandler
import com.microblink.ux.UiSettings
import com.microblink.ux.camera.CameraHardwareInfoHelper
import com.microblink.ux.camera.CameraInputDetails
import com.microblink.ux.camera.CameraViewModel
import com.microblink.ux.components.needHelpTooltipDefaultTimeToAppearMs
import com.microblink.ux.components.uiCountingWindowDurationMs
import com.microblink.ux.state.CardAnimationState
import com.microblink.ux.state.CardAnimationState.ShowFlipLandscape
import com.microblink.ux.state.CommonStatusMessage
import com.microblink.ux.state.DocumentSide
import com.microblink.ux.state.DocumentSide.Back
import com.microblink.ux.state.DocumentSide.Barcode
import com.microblink.ux.state.DocumentSide.Front
import com.microblink.ux.state.ErrorState
import com.microblink.ux.state.HapticFeedbackState
import com.microblink.ux.state.MbTorchState
import com.microblink.ux.state.ProcessingState
import com.microblink.ux.state.ReticleState
import com.microblink.ux.state.StatusMessage
import com.microblink.ux.state.StatusMessageCounter
import com.microblink.ux.utils.ErrorReason
import com.microblink.ux.utils.ScreenOrientation
import com.microblink.ux.utils.toErrorState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.DurationUnit
import kotlin.time.toDuration

internal class BlinkIdUxViewModel(
    blinkIdSdkInstance: BlinkIdSdk,
    sessionSettings: BlinkIdSessionSettings,
    uxSettings: BlinkIdUxSettings
) : CameraViewModel() {
    private var imageAnalyzer: BlinkIdAnalyzer? = null

    private val _uiState = MutableStateFlow(BlinkIdUiState())
    val uiState: StateFlow<BlinkIdUiState> = _uiState.asStateFlow()

    var uiStateStartTime: Duration = Duration.ZERO
    val countingWindowDuration: Duration = uiCountingWindowDurationMs.milliseconds

    private val statusCounter: StatusMessageCounter = StatusMessageCounter()
    private val appearanceCounter: StatusMessageCounter = StatusMessageCounter()

    private var isCountingActive: Boolean = true

    private var currentScreenOrientation: ScreenOrientation? = null

    private var lastTrackedErrorType: UxEvent.ErrorMessageType? = null

    private var cameraHardwareInfoReported = false

    val helpTooltipTimeToDisplayInMs =
        if (uxSettings.stepTimeoutDuration.inWholeMilliseconds == 0L) {
            needHelpTooltipDefaultTimeToAppearMs
        } else {
            uxSettings.stepTimeoutDuration.inWholeMilliseconds / 2
        }

    private
    val helpTooltipTimer =
        object : CountDownTimer(helpTooltipTimeToDisplayInMs, helpTooltipTimeToDisplayInMs) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                UxPingletTracker.UxEvent.trackSimpleEvent(
                    UxPingletTracker.UxEvent.SimpleUxEventType.HelpTooltipDisplayed,
                    getSessionNumber()
                )
                changeHelpTooltipVisibility(true)
            }

        }

    init {
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
                    lifecyclePauseAnalysis()
                    appearanceCounter.reset()
                    UxPingletTracker.UxEvent.trackAlertDisplayedEvent(
                        alertType = when (error) {
                            ErrorReason.ErrorInvalidLicense -> UxEvent.AlertType.INVALIDLICENSEKEY
                            ErrorReason.ErrorTimeoutExpired -> UxEvent.AlertType.STEPTIMEOUT
                            ErrorReason.ErrorNetworkError -> UxEvent.AlertType.NETWORKERROR
                            ErrorReason.ErrorDocumentClassFiltered -> UxEvent.AlertType.DOCUMENTCLASSNOTALLOWED

                        },
                        sessionNumber = getSessionNumber()
                    )
                    _uiState.update {
                        it.copy(
                            errorState = error.toErrorState(),
                            processingState = ProcessingState.ErrorDialog,
                            hapticFeedbackState = HapticFeedbackState.VibrationOneTimeLong,
                            activePassportPage = null
                        )
                    }
                }

                override fun onScanningCanceled() {}
            },
            uxEventHandler = object : ScanningUxEventHandler {
                override fun onUxEvents(events: List<ScanningUxEvent>) {
                    var newStatusMessage: StatusMessage? = null
                    var newProcessingState: ProcessingState? = null
                    var newActivePassportPage: PassportPage? = null
                    var newCurrentSide: DocumentSide? = null
                    for (event in events) {
                        when (event) {
                            is ScanningUxEvent.ScanningDone -> {
                                lifecyclePauseAnalysis()
                                newStatusMessage = CommonStatusMessage.Empty
                                newProcessingState = ProcessingState.SuccessAnimation(false)
                            }

                            is ScanningUxEvent.DocumentNotFound -> {
                                newProcessingState = ProcessingState.Sensing

                                newStatusMessage =
                                    if (uiState.value.activePassportPage != null) {
                                        when (uiState.value.activePassportPage) {
                                            PassportPage.Top -> BlinkIdStatusMessage.PassportScanTopPage
                                            PassportPage.Right -> BlinkIdStatusMessage.PassportScanRightPage
                                            PassportPage.Left -> BlinkIdStatusMessage.PassportScanLeftPage
                                            else -> BlinkIdStatusMessage.PassportScanTopPage
                                        }
                                    } else {
                                        when (uiState.value.currentSide) {
                                            Front -> CommonStatusMessage.ScanFrontSide
                                            Back -> CommonStatusMessage.ScanBackSide
                                            else -> CommonStatusMessage.ScanBarcode
                                        }
                                    }

                            }

                            is ScanningUxEvent.DocumentLocated, is BlinkIdDocumentLocatedLocation -> {
                                // newProcessingState = ProcessingState.Processing
                                // Not used in this UI implementation.
                                // Can be used for processing state.
                            }

                            is ScanningUxEvent.BlurDetected -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.EliminateBlur
                            }

                            is ScanningUxEvent.DocumentNotFullyVisible -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.KeepDocumentVisible
                            }

                            is ScanningUxEvent.FaceImageNotFound -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.KeepFacePhotoVisible
                            }

                            is ScanningUxEvent.DocumentTooBright -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.DecreaseLightingIntensity
                            }

                            is ScanningUxEvent.DocumentTooDark -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.IncreaseLightingIntensity
                            }

                            is ScanningUxEvent.DocumentTooClose -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.MoveFarther
                            }

                            is ScanningUxEvent.DocumentTooCloseToCameraEdge -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.MoveDocumentFromEdge
                            }

                            is ScanningUxEvent.DocumentTooFar -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.MoveCloser
                            }

                            is ScanningUxEvent.DocumentTooTilted -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.RotateDocument
                            }

                            is ScanningUxEvent.GlareDetected -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.EliminateGlare
                            }

                            is ScanningUxEvent.ScanningWrongSide -> {
                                newProcessingState = ProcessingState.Error
                                newStatusMessage = CommonStatusMessage.ScanningWrongSide
                            }

                            is ScanningWrongPassportPage -> {
                                val page =
                                    if (event.isScanningDataPage) {
                                        PassportPage.Data
                                    } else {
                                        getPassportPageFromRotation(
                                            getCorrectedDocumentRotation(
                                                event.documentRotation,
                                                uiState.value.screenOrientation
                                            )
                                        )
                                    }
                                newStatusMessage =
                                    when (page) {
                                        PassportPage.Top -> BlinkIdStatusMessage.PassportWrongPageTop
                                        PassportPage.Right -> BlinkIdStatusMessage.PassportWrongPageRight
                                        PassportPage.Left -> BlinkIdStatusMessage.PassportWrongPageLeft
                                        PassportPage.Data -> BlinkIdStatusMessage.ScanPassportDataPage
                                    }
                                newProcessingState = ProcessingState.Error
                                newActivePassportPage = page
                            }

                            is RequestPassportPage -> {
                                lifecyclePauseAnalysis()
                                newActivePassportPage =
                                    getPassportPageFromRotation(
                                        getCorrectedDocumentRotation(
                                            event.documentRotation,
                                            uiState.value.screenOrientation
                                        )
                                    )
                                newProcessingState =
                                    ProcessingState.SuccessAnimation(true)
                                newStatusMessage = CommonStatusMessage.Empty
                            }

                            is ScanningUxEvent.RequestDocumentSide -> {
                                var currentSide: DocumentSide = uiState.value.currentSide
                                when (uiState.value.currentSide) {
                                    Front -> {
                                        when (event.side) {
                                            Front -> {
                                            }

                                            Back -> {
                                                // TODO: support for portrait animations
                                                newProcessingState =
                                                    ProcessingState.SuccessAnimation(true)
                                                newStatusMessage = CommonStatusMessage.Empty
                                                lifecyclePauseAnalysis()
                                            }

                                            Barcode -> {
                                                newProcessingState = ProcessingState.Sensing
                                                newStatusMessage =
                                                    CommonStatusMessage.ScanBarcode
                                                newCurrentSide = Barcode
                                                isCountingActive = false
                                                imageAnalyzer?.pauseAnalysis()
                                                imageAnalyzer?.resumeAnalysis()
                                            }
                                        }
                                    }

                                    Back -> {
                                        when (event.side) {
                                            Front -> {}

                                            Back -> {}

                                            Barcode -> {
                                                newProcessingState = ProcessingState.Sensing
                                                newStatusMessage =
                                                    CommonStatusMessage.ScanBarcode
                                                newCurrentSide = Barcode
                                                isCountingActive = false
                                                imageAnalyzer?.pauseAnalysis()
                                                imageAnalyzer?.resumeAnalysis()
                                            }
                                        }
                                    }

                                    Barcode -> {
                                        // Impossible to reach anything else other than barcode.
                                        currentSide = Barcode
                                        newStatusMessage = CommonStatusMessage.ScanBarcode
                                    }
                                }

                            }

                            is DocumentImageAnalysisResult -> {
                                // Not used in this UI implementation.
                                // Can be used for additional frame debugging.
                            }

                        }
                    }

                    updateUiState(
                        newProcessingState,
                        newStatusMessage,
                        newActivePassportPage,
                        newCurrentSide
                    )
                }
            }
        )
    }

    private fun updateUiState(
        newProcessingState: ProcessingState?,
        newStatusMessage: StatusMessage?,
        newActivePassportPage: PassportPage?,
        newCurrentSide: DocumentSide?
    ) {
        newProcessingState?.let {
            if (newProcessingState is ProcessingState.SuccessAnimation || newStatusMessage == CommonStatusMessage.ScanBarcode) {
                isCountingActive = false
                runBlocking {
                    waitForMinimumStateDuration(newProcessingState)
                }
            } else if (isCountingActive || shouldStartCounting(uiState.value.processingState)) {
                newStatusMessage?.let {
                    statusCounter.increment(it)
                }
            }

            newStatusMessage?.let {
                val stateRemDur = remainingStateDuration(
                    uiState.value.processingState,
                    newProcessingState,
                    newStatusMessage
                )
                if (stateRemDur <= Duration.ZERO || newProcessingState is ProcessingState.SuccessAnimation || newStatusMessage == CommonStatusMessage.ScanBarcode) {
                    val (selectedProcessingState, selectedStatusMessage) =
                        if (newProcessingState.reticleState == ReticleState.Success || newProcessingState.reticleState == ReticleState.SuccessFirstSide || newStatusMessage == CommonStatusMessage.ScanBarcode) {
                            Pair(
                                newProcessingState,
                                newStatusMessage
                            )
                        } else if (uiState.value.statusMessage == CommonStatusMessage.ScanBarcode) {
                            Pair(
                                null,
                                null
                            )
                        } else pickNewState()
                    selectedProcessingState?.let {
                        val newHapticFeedbackState = when (selectedProcessingState) {
                            ProcessingState.Error -> HapticFeedbackState.VibrationOneTimeShort
                            is ProcessingState.SuccessAnimation -> {
                                if (selectedProcessingState.isFirstSide) {
                                    HapticFeedbackState.VibrationOneTimeShort
                                } else {
                                    HapticFeedbackState.VibrationOneTimeLong
                                }
                            }

                            else -> null
                        }
                        selectedStatusMessage?.let {
                            if (selectedProcessingState == ProcessingState.Error) {
                                val errorType: UxEvent.ErrorMessageType? =
                                    when (selectedStatusMessage) {
                                        is CommonStatusMessage -> when (selectedStatusMessage) {
                                            CommonStatusMessage.MoveCloser -> UxEvent.ErrorMessageType.MOVECLOSER
                                            CommonStatusMessage.MoveFarther -> UxEvent.ErrorMessageType.MOVEFARTHER
                                            CommonStatusMessage.KeepDocumentVisible, CommonStatusMessage.KeepFacePhotoVisible
                                                -> UxEvent.ErrorMessageType.KEEPVISIBLE

                                            CommonStatusMessage.ScanningWrongSide -> UxEvent.ErrorMessageType.FLIPSIDE
                                            CommonStatusMessage.AlignDocument -> UxEvent.ErrorMessageType.ALIGNDOCUMENT
                                            CommonStatusMessage.MoveDocumentFromEdge -> UxEvent.ErrorMessageType.MOVEFROMEDGE
                                            CommonStatusMessage.IncreaseLightingIntensity -> UxEvent.ErrorMessageType.INCREASELIGHTING
                                            CommonStatusMessage.DecreaseLightingIntensity -> UxEvent.ErrorMessageType.DECREASELIGHTING
                                            CommonStatusMessage.EliminateBlur -> UxEvent.ErrorMessageType.ELIMINATEBLUR
                                            CommonStatusMessage.EliminateGlare -> UxEvent.ErrorMessageType.ELIMINATEGLARE
                                            else -> null
                                        }

                                        else -> null
                                    }
                                errorType?.let {
                                    // We track error message event only when the errorMessageType changes
                                    if (errorType != lastTrackedErrorType) {
                                        lastTrackedErrorType = errorType
                                        UxPingletTracker.UxEvent.trackErrorMessageEvent(
                                            it,
                                            getSessionNumber()
                                        )
                                    }
                                }
                            }
                            _uiState.update {
                                it.copy(
                                    reticleState = selectedProcessingState.reticleState,
                                    processingState = selectedProcessingState,
                                    statusMessage = selectedStatusMessage,
                                    hapticFeedbackState = newHapticFeedbackState
                                        ?: it.hapticFeedbackState,
                                    activePassportPage = newActivePassportPage
                                        ?: it.activePassportPage,
                                    currentSide = newCurrentSide ?: it.currentSide
                                )
                            }

                            appearanceCounter.incrementIfNotPresent(selectedStatusMessage)
                            updateStateStartTime()
                        }
                    }
                }
            }
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

    fun pickNewState(): Pair<ProcessingState?, StatusMessage?> {
        val max = statusCounter.getAllCounts().values.maxOrNull()
        val mostFrequent = statusCounter.getAllCounts().filterValues { it == max }.keys.toList()
        statusCounter.reset()
        return if (mostFrequent.isNotEmpty()) {
            when (mostFrequent[0]) {
                CommonStatusMessage.RotateDocument, CommonStatusMessage.ScanFrontSide, CommonStatusMessage.ScanBackSide, CommonStatusMessage.ScanBarcode, BlinkIdStatusMessage.PassportScanTopPage, BlinkIdStatusMessage.PassportScanLeftPage, BlinkIdStatusMessage.PassportScanRightPage -> {
                    Pair(ProcessingState.Sensing, mostFrequent[0])
                }

                else -> {
                    Pair(ProcessingState.Error, mostFrequent[0])
                }

            }
        } else Pair(null, null)
    }

    fun setScreenOrientation(screenOrientation: ScreenOrientation) {
        if (currentScreenOrientation != screenOrientation) {
            currentScreenOrientation = screenOrientation
            // track pinglet only when screen orientation changes
            UxPingletTracker.ScanningConditions.trackScreenOrientationChange(
                screenOrientation = screenOrientation,
                sessionNumber = getSessionNumber()
            )
        }
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

    fun lifecyclePauseAnalysis() {
        imageAnalyzer?.pauseAnalysis()
        helpTooltipTimer.cancel()
        statusCounter.reset()
        isCountingActive = false
    }

    fun lifecycleResumeAnalysis() {
        imageAnalyzer?.resumeAnalysis()
        helpTooltipTimer.start()
    }

    suspend fun waitForMinimumStateDuration(newProcessingState: ProcessingState) {
        var remainingDuration: Duration
        do {
            remainingDuration = remainingStateDuration(
                uiState.value.processingState,
                newProcessingState,
                uiState.value.statusMessage
            )
            if (remainingDuration > Duration.ZERO) {
                delay(remainingDuration.inWholeMilliseconds)
            }
        } while (remainingDuration > Duration.ZERO)
    }

    fun remainingStateDuration(
        currentState: ProcessingState,
        newState: ProcessingState,
        newStatusMessage: StatusMessage
    ): Duration {
        if ((newState.reticleState == ReticleState.Success || newState.reticleState == ReticleState.SuccessFirstSide) && appearanceCounter.getAllCounts()
                .contains(newStatusMessage)
        ) {
            val remainingDuration =
                System.nanoTime().nanoseconds - uiStateStartTime - currentState.minDuration
            return -remainingDuration
        } else {
            val remainingDuration =
                System.nanoTime().nanoseconds - uiStateStartTime - currentState.duration
            return -remainingDuration
        }
    }

    fun shouldStartCounting(currentState: ProcessingState): Boolean {
        if ((System.nanoTime().nanoseconds - uiStateStartTime + countingWindowDuration) >= currentState.duration) {
            isCountingActive =
                true
            return true
        } else {
            return false
        }
    }

    fun onFlipAnimationCompleted() {
        _uiState.update {
            it.copy(
                processingState = ProcessingState.Sensing,
                cardAnimationState = CardAnimationState.Hidden,
                statusMessage =
                    if (uiState.value.activePassportPage != null) {
                        when (uiState.value.activePassportPage) {
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
        if (!_uiState.value.onboardingDialogDisplayed && !_uiState.value.helpDisplayed) {
            lifecycleResumeAnalysis()
        }
    }

    private fun updateStateStartTime() {
        uiStateStartTime =
            System.nanoTime()
                .toDuration(DurationUnit.NANOSECONDS)
    }

    fun changeTorchState() {
        val (newTorchState, hapticState) = when (_uiState.value.torchState) {
            MbTorchState.On -> MbTorchState.Off to HapticFeedbackState.VibrationOff
            MbTorchState.Off -> MbTorchState.On to HapticFeedbackState.VibrationOneTimeShort
            MbTorchState.NotSupportedByCamera -> return
        }
        _torchOn.value = newTorchState == MbTorchState.On
        _uiState.update {
            it.copy(
                torchState = newTorchState,
                hapticFeedbackState = hapticState
            )
        }
        UxPingletTracker.ScanningConditions.trackTorchStateUpdate(
            newTorchState == MbTorchState.On,
            getSessionNumber()
        )
    }

    fun changeHelpTooltipVisibility(show: Boolean) {
        if (_uiState.value.helpButtonDisplayed) {
            if (show) {
                helpTooltipTimer.cancel()
            } else {
                helpTooltipTimer.start()
            }
            _uiState.update {
                it.copy(helpTooltipDisplayed = show)
            }
        }
    }

    fun changeOnboardingDialogVisibility(show: Boolean) {
        if (show) {
            UxPingletTracker.UxEvent.trackSimpleEvent(
                UxPingletTracker.UxEvent.SimpleUxEventType.OnboardingInfoDisplayed,
                getSessionNumber()
            )
            lifecyclePauseAnalysis()
        } else {
            lifecycleResumeAnalysis()
        }
        _uiState.update {
            it.copy(onboardingDialogDisplayed = show)
        }
    }

    fun onHelpScreensDisplayRequested() {
        UxPingletTracker.UxEvent.trackSimpleEvent(
            UxPingletTracker.UxEvent.SimpleUxEventType.HelpOpened,
            getSessionNumber()
        )
        lifecyclePauseAnalysis()
        _uiState.update {
            it.copy(helpDisplayed = true)
        }
    }

    fun onHelpScreensCloseRequested(allPagesVisited: Boolean) {
        UxPingletTracker.UxEvent.trackHelpCloseEvent(
            helpCloseType = if (allPagesVisited) {
                UxEvent.HelpCloseType.CONTENTFULLYVIEWED
            } else {
                UxEvent.HelpCloseType.CONTENTSKIPPED
            },
            sessionNumber = getSessionNumber()
        )
        lifecycleResumeAnalysis()
        _uiState.update {
            it.copy(helpDisplayed = false)
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

    fun onHapticFeedbackCompleted() {
        _uiState.update {
            it.copy(
                hapticFeedbackState = HapticFeedbackState.VibrationOff
            )
        }
    }

    fun onReticleSuccessAnimationCompleted() {
        if (_uiState.value.processingState is ProcessingState.SuccessAnimation && (_uiState.value.processingState as ProcessingState.SuccessAnimation).isFirstSide) {
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

    fun onCameraPermissionCheck() {
        UxPingletTracker.CameraPermission.trackCameraPermissionCheck(getSessionNumber())
        BlinkIdSdk.sendPingletsIfAllowed(PingSendTriggerPoint.CameraPermissionCheck)
    }

    fun onCameraPermissionRequest() {
        UxPingletTracker.CameraPermission.trackCameraPermissionRequest(getSessionNumber())
    }

    fun onCameraPermissionUserResponse(cameraPermissionGranted: Boolean) {
        UxPingletTracker.CameraPermission.trackCameraPermissionUserResponse(
            cameraPermissionGranted,
            getSessionNumber()
        )
    }

    fun onCameraPreviewStarted() {
        UxPingletTracker.UxEvent.trackSimpleEvent(
            UxPingletTracker.UxEvent.SimpleUxEventType.CameraStarted,
            getSessionNumber()
        )
        BlinkIdSdk.sendPingletsIfAllowed(PingSendTriggerPoint.CameraStarted)
    }

    fun onCameraPreviewStopped() {
        UxPingletTracker.UxEvent.trackSimpleEvent(
            UxPingletTracker.UxEvent.SimpleUxEventType.CameraClosed,
            getSessionNumber()
        )
    }

    fun onCameraInputInfoAvailable(context: Context, cameraInputDetails: CameraInputDetails) {
        UxPingletTracker.CameraInfo.trackCameraInputInfo(cameraInputDetails, getSessionNumber())
        if (!cameraHardwareInfoReported) {
            cameraHardwareInfoReported = true
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    val cameraDetailsList = CameraHardwareInfoHelper.getCameraHardwareInfo(context)
                    UxPingletTracker.CameraInfo.trackCameraHardwareInfo(cameraDetailsList)
                }
            }
        }

    }

    fun onCloseButtonClicked() {
        UxPingletTracker.UxEvent.trackSimpleEvent(
            UxPingletTracker.UxEvent.SimpleUxEventType.CloseButtonClicked,
            getSessionNumber()
        )
    }

    fun onAppMovedToBackground() {
        UxPingletTracker.UxEvent.trackSimpleEvent(
            UxPingletTracker.UxEvent.SimpleUxEventType.AppMovedToBackground,
            getSessionNumber()
        )
    }

    private fun getSessionNumber(): Int = imageAnalyzer?.getSessionNumber() ?: 0

    override fun onCleared() {
        super.onCleared()
        BlinkIdSdk.sendPingletsIfAllowed(PingSendTriggerPoint.CameraScreenClosed)
        lifecyclePauseAnalysis()
        imageAnalyzer?.cancel()
        imageAnalyzer?.close()
        imageAnalyzer = null
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