/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.state

import androidx.compose.runtime.Composable
import com.microblink.ux.components.flipAnimationDurationMs
import com.microblink.ux.components.successAnimationDurationMs
import com.microblink.ux.theme.SdkTheme
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

/**
 * Represents the different states of the reticle and UI elements during the scanning process.
 *
 * This enum class defines the various states that the UI can be in
 * while a document is being captured and processed. Each state is associated with
 * a specific [ReticleState] and a minimum duration.
 *
 * @property reticleState The [ReticleState] associated with this processing state.
 * @property minDuration The minimum duration that this state should last, it is
 *                      in milliseconds.
 *
 */
enum class ProcessingState(
    val reticleState: ReticleState,
    val minDuration: Duration
) {
    Sensing(ReticleState.Sensing, 1000.milliseconds),
    Processing(ReticleState.IndefiniteProgress, 1000.milliseconds),
    CardAnimation(ReticleState.Hidden, flipAnimationDurationMs.milliseconds),
    SuccessAnimation(ReticleState.Success, successAnimationDurationMs.milliseconds),
    Success(ReticleState.Hidden, 0.milliseconds),
    Error(ReticleState.Error, 1500.milliseconds),
    ErrorDialog(ReticleState.Hidden, 0.milliseconds)
}

/**
 * Represents the different states of the reticle elements during the scanning process.
 */
enum class ReticleState {
    Hidden,
    Sensing,
    IndefiniteProgress,
    Success,
    Error
}

/**
 * Current state of the torch (flashlight) as shown by the icon
 * on the UI.
 */
enum class MbTorchState {
    NotSupportedByCamera,
    Off,
    On
}

/**
 * Current state of the flip-card animation shown after the first side
 * has been successfully scanned.
 */
enum class CardAnimationState(val isPortrait: Boolean) {
    Hidden(false),
    ShowFlipLandscape(false),
    ShowFlipPortrait(true),
    ShowRotationToPortrait(true),
    ShowRotationToLandscape(false)
}

/**
 * Represents the reason of the cancel request.
 * Currently not used.
 */
enum class CancelRequestState {
    CancelNotRequested,
    CancelByUser,
    CancelLicenseError,
    CancelAnalyzerSettingsUnsuitable,
    CancelUnknownError
}

/**
 * Represents the state of the error.
 */
enum class ErrorState {
    NoError,
    ErrorInvalidLicense,
    ErrorNetworkError,
    ErrorTimeoutExpired,
    ErrorDocumentClassFiltered
}

/**
 * Current state of the haptic (vibration) feedback that
 * activates during the scanning session.
 */
enum class HapticFeedbackState {
    VibrationOff,
    VibrationOneTimeShort,
    VibrationOneTimeLong
}

/**
 * Represents all the instruction messages that may be shown
 * during the scanning session.
 *
 * This enum class defines the various status messages that can be displayed to the
 * user during the document scanning process. Each enum value corresponds to a
 * specific instruction or feedback message.
 *
 */
enum class StatusMessage {
    Empty,
    ScanFrontSide,
    ScanBackSide,
    ScanBarcode,
    FlipDocument,
    RotateDocument,
    RotateDocumentShort,
    MoveFarther,
    MoveCloser,
    KeepDocumentVisible,
    AlignDocument,
    MoveDocumentFromEdge,
    IncreaseLightingIntensity,
    DecreaseLightingIntensity,
    EliminateBlur,
    EliminateGlare,
    FilterSpecificMessage,
    ScanningWrongSide;

    /**
     * Returns the string resource ID associated with this status message.
     *
     * This function is used to get the string resource that should be
     * displayed to the user for this status message. Status messages
     * that are mapped to `null` are not possible to happen, but might
     * become available in the future releases.
     *
     * @return The string resource ID, or `null` if there is no associated
     *         string resource.
     *
     */
    @Composable
    fun statusMessageToStringRes(): Int? {
        val strings = SdkTheme.sdkStrings.scanningStrings
        return when (this) {
            Empty -> null
            ScanFrontSide -> strings.instructionsFrontSide
            ScanBackSide -> strings.instructionsBackSide
            ScanBarcode -> strings.instructionsBarcode
            FlipDocument -> strings.instructionsFlipDocument
            RotateDocument -> null
            RotateDocumentShort -> null
            MoveFarther -> strings.instructionsMoveFarther
            MoveCloser -> strings.instructionsMoveCloser
            KeepDocumentVisible -> strings.instructionsDocumentNotFullyVisible
            AlignDocument -> strings.instructionsDocumentTilted
            MoveDocumentFromEdge -> strings.instructionsDocumentTooCloseToEdge
            IncreaseLightingIntensity -> null
            DecreaseLightingIntensity -> null
            EliminateBlur -> strings.instructionsBlurDetected
            EliminateGlare -> strings.instructionsGlareDetected
            FilterSpecificMessage -> null
            ScanningWrongSide -> strings.instructionsScanningWrongSide
        }
    }
}

/**
 * Specifies the current document side.
 */
enum class DocumentSide {
    Front,
    Back,
    Barcode
}
