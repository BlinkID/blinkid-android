/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.microblink.ux.components.DocumentFlipAnimation
import com.microblink.ux.components.flipAnimationDurationMs
import com.microblink.ux.components.successAnimationDurationMs
import com.microblink.ux.theme.SdkTheme
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

/**
 * Represents the different states of the reticle and UI elements during the scanning process.
 *
 * This sealed class defines the various states that the UI can be in
 * while a document is being captured and processed. Each state is associated with
 * a specific [ReticleState] and a minimum duration.
 *
 * @property reticleState The [ReticleState] associated with this processing state.
 * @property duration The regular duration for which this state should last.
 * @property minDuration The minimum duration that this state should last, should the following
 *                       state be of higher priority.
 */
sealed class ProcessingState(
    val reticleState: ReticleState,
    val duration: Duration,
    val minDuration: Duration
) {
    object Sensing : ProcessingState(ReticleState.Sensing, 2000.milliseconds, 1000.milliseconds)
    object Processing : ProcessingState(ReticleState.IndefiniteProgress, 1500.milliseconds, 1000.milliseconds)
    object CardAnimation : ProcessingState(ReticleState.Hidden, flipAnimationDurationMs.milliseconds, flipAnimationDurationMs.milliseconds)
    object Success : ProcessingState(ReticleState.Hidden, 0.milliseconds, 0.milliseconds)
    object Error : ProcessingState(ReticleState.Error, 3000.milliseconds, 1000.milliseconds)
    object ErrorDialog : ProcessingState(ReticleState.Hidden, 0.milliseconds, 0.milliseconds)

    class SuccessAnimation(
        val isFirstSide: Boolean
    ) : ProcessingState(
        if (isFirstSide) ReticleState.SuccessFirstSide else ReticleState.Success,
        successAnimationDurationMs.milliseconds,
        successAnimationDurationMs.milliseconds
    )
}

/**
 * Represents the different states of the reticle elements during the scanning process.
 */
enum class ReticleState {
    Hidden,
    Sensing,
    IndefiniteProgress,
    SuccessFirstSide,
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
fun interface CardAnimationState {

    companion object {
        val Hidden = CardAnimationState { _, _ -> }
    }

    @Composable
    fun Animate(
        screenDimensionMin: Dp,
        onAnimationCompleted: () -> Unit
    )

    object ShowFlipLandscape : CardAnimationState {
        @Composable
        override fun Animate(screenDimensionMin: Dp, onAnimationCompleted: () -> Unit) {
            DocumentFlipAnimation(screenDimensionMin, onAnimationCompleted)
        }
    }
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
 * Interface that represents the status messages that may be shown
 * during the scanning session.
 */
interface StatusMessage {
    @Composable
    fun statusMessageToStringRes(): Int?
}

/**
 * Represents all the instruction messages that may be shown
 * during the scanning session.
 *
 * This enum class defines the various status messages that can be displayed to the
 * user during the document scanning process. Each enum value corresponds to a
 * specific instruction or feedback message.
 */
enum class CommonStatusMessage : StatusMessage {
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
    KeepFacePhotoVisible,
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
    override fun statusMessageToStringRes(): Int? {
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
            KeepFacePhotoVisible -> strings.instructionsFacePhotoNotFullyVisible
            AlignDocument -> strings.instructionsDocumentTilted
            MoveDocumentFromEdge -> strings.instructionsDocumentTooCloseToEdge
            IncreaseLightingIntensity -> strings.instructionsIncreaseLight
            DecreaseLightingIntensity -> strings.instructionsDecreaseLight
            EliminateBlur -> strings.instructionsBlurDetected
            EliminateGlare -> strings.instructionsGlareDetected
            FilterSpecificMessage -> null
            ScanningWrongSide -> strings.instructionsScanningWrongSide
        }
    }
}

/**
 * A class responsible for counting the occurrences of different `CommonStatusMessage` types.
 *
 * This class provides a way to track how many times each specific status message
 * has been encountered. It uses a mutable map internally to store the counts.
 */
class StatusMessageCounter {
    private val counts = mutableMapOf<StatusMessage, Int>()

    fun increment(message: StatusMessage) {
        counts[message] = (counts[message] ?: 0) + 1
    }

    fun incrementIfNotPresent(message: StatusMessage) {
        if ((counts[message] ?: 0) == 0) {
            counts[message] = 1
        }
    }

    fun getCount(message: StatusMessage): Int = counts[message] ?: 0

    fun getAllCounts(): Map<StatusMessage, Int> = counts.toMap()

    fun reset() {
        counts.clear()
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