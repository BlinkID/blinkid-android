/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.blinkid.ux.state

import com.microblink.blinkid.core.session.BlinkIdScanningResult
import com.microblink.ux.DefaultShowHelpButton
import com.microblink.ux.DefaultShowOnboardingDialog
import com.microblink.ux.state.BaseUiState
import com.microblink.ux.state.CancelRequestState
import com.microblink.ux.state.CardAnimationState
import com.microblink.ux.state.DocumentSide
import com.microblink.ux.state.HapticFeedbackState
import com.microblink.ux.state.MbTorchState
import com.microblink.ux.state.ProcessingState
import com.microblink.ux.state.ReticleState
import com.microblink.ux.state.StatusMessage
import com.microblink.ux.state.ErrorState

data class BlinkIdUiState(
    val blinkIdScanningResult: BlinkIdScanningResult? = null,
    override val reticleState: ReticleState = ReticleState.Hidden,
    override val processingState: ProcessingState = ProcessingState.Sensing,
    override val cardAnimationState: CardAnimationState = CardAnimationState.Hidden,
    override val statusMessage: StatusMessage = StatusMessage.ScanFrontSide,
    override val currentSide: DocumentSide = DocumentSide.Front,
    override val torchState: MbTorchState = MbTorchState.Off,
    override val cancelRequestState: CancelRequestState = CancelRequestState.CancelNotRequested,
    override val helpButtonDisplayed: Boolean = DefaultShowHelpButton,
    override val helpDisplayed: Boolean = false,
    override val helpTooltipDisplayed: Boolean = false,
    override val onboardingDialogDisplayed: Boolean = DefaultShowOnboardingDialog,
    override val errorState: ErrorState = ErrorState.NoError,
    override val hapticFeedbackState: HapticFeedbackState = HapticFeedbackState.VibrationOff
) : BaseUiState
