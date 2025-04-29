/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.blinkid.ux.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.microblink.blinkid.core.session.BlinkIdScanningResult
import com.microblink.blinkid.ux.components.PassportPageAnimation
import com.microblink.blinkid.ux.theme.BlinkIdTheme
import com.microblink.ux.DefaultShowHelpButton
import com.microblink.ux.DefaultShowOnboardingDialog
import com.microblink.ux.state.BaseUiState
import com.microblink.ux.state.CancelRequestState
import com.microblink.ux.state.CardAnimationState
import com.microblink.ux.state.CommonStatusMessage
import com.microblink.ux.state.DocumentSide
import com.microblink.ux.state.ErrorState
import com.microblink.ux.state.HapticFeedbackState
import com.microblink.ux.state.MbTorchState
import com.microblink.ux.state.ProcessingState
import com.microblink.ux.state.ReticleState
import com.microblink.ux.state.StatusMessage
import com.microblink.ux.utils.ScreenOrientation

data class BlinkIdUiState(
    val blinkIdScanningResult: BlinkIdScanningResult? = null,
    override val reticleState: ReticleState = ReticleState.Hidden,
    override val processingState: ProcessingState = ProcessingState.Sensing,
    override val cardAnimationState: CardAnimationState = CardAnimationState.Hidden,
    override val statusMessage: StatusMessage = CommonStatusMessage.ScanFrontSide,
    override val currentSide: DocumentSide = DocumentSide.Front,
    override val torchState: MbTorchState = MbTorchState.Off,
    override val cancelRequestState: CancelRequestState = CancelRequestState.CancelNotRequested,
    override val helpButtonDisplayed: Boolean = DefaultShowHelpButton,
    override val helpDisplayed: Boolean = false,
    override val helpTooltipDisplayed: Boolean = false,
    override val onboardingDialogDisplayed: Boolean = DefaultShowOnboardingDialog,
    override val errorState: ErrorState = ErrorState.NoError,
    override val hapticFeedbackState: HapticFeedbackState = HapticFeedbackState.VibrationOff,
    val screenOrientation: ScreenOrientation = ScreenOrientation.Unknown,
    val activePassportPage: PassportPage? = null
) : BaseUiState

/**
 * Represents all the instruction messages that may be shown
 * during the BlinkID scanning session.
 *
 * This enum class defines the various status messages that can be displayed to the
 * user during the BlinkID document scanning process. Each enum value corresponds to a
 * specific instruction or feedback message.
 */
enum class BlinkIdStatusMessage : StatusMessage {
    ScanPassportDataPage,
    PassportMoveToTop,
    PassportMoveToRight,
    PassportMoveToLeft,
    PassportWrongPageTop,
    PassportWrongPageRight,
    PassportWrongPageLeft,
    PassportScanTopPage,
    PassportScanRightPage,
    PassportScanLeftPage;

    @Composable
    override fun statusMessageToStringRes(): Int? {
        val strings = BlinkIdTheme.sdkStrings.blinkIdScanningStrings
        return when (this) {
            ScanPassportDataPage -> strings.instructionsPassportDataPage
            PassportMoveToTop -> strings.instructionsPassportMoveToTopPage
            PassportMoveToRight -> strings.instructionsPassportMoveToRightPage
            PassportMoveToLeft -> strings.instructionsPassportMoveToLeftPage
            PassportWrongPageTop -> strings.instructionsPassportWrongPageTop
            PassportWrongPageRight -> strings.instructionsPassportWrongPageRight
            PassportWrongPageLeft -> strings.instructionsPassportWrongPageLeft
            PassportScanTopPage -> strings.instructionsPassportScanTopPage
            PassportScanRightPage -> strings.instructionsPassportScanRightPage
            PassportScanLeftPage -> strings.instructionsPassportScanLeftPage
        }
    }
}

enum class PassportPage {
    Data,
    Top,
    Left,
    Right
}

object ShowPassportMoveToTop : CardAnimationState {
    @Composable
    override fun Animate(screenDimensionMin: Dp, onAnimationCompleted: () -> Unit) {
        PassportPageAnimation(PassportPage.Top, screenDimensionMin, onAnimationCompleted)
    }
}

object ShowPassportMoveToRight : CardAnimationState {
    @Composable
    override fun Animate(screenDimensionMin: Dp, onAnimationCompleted: () -> Unit) {
        PassportPageAnimation(PassportPage.Right, screenDimensionMin, onAnimationCompleted)
    }
}

object ShowPassportMoveToLeft : CardAnimationState {
    @Composable
    override fun Animate(screenDimensionMin: Dp, onAnimationCompleted: () -> Unit) {
        PassportPageAnimation(PassportPage.Left, screenDimensionMin, onAnimationCompleted)
    }
}