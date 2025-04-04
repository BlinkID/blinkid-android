/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.theme

import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.microblink.ux.R
import kotlinx.parcelize.Parcelize


/**
 * Data class contains all the strings used throughout the SDK.
 * [Default] can be used to keep the original strings if only some of the elements are to be changed.
 *
 * This class shouldn't be modified, but rather a new instance should be
 * created and used in [com.microblink.ux.UiSettings.sdkStrings].
 *
 * @property scanningStrings Strings that appear as instruction messages during the scanning session.
 *                           These instructions are triggered by specific UX events and will appear
 *                           on screen accordingly.
 * @property helpDialogsStrings Strings used in onboarding and help dialogs. These strings shouldn't
 *                              be customized as they provide adequate instructions tailored specifically
 *                              to our scanning experience. However, if the scanning experience is changed
 *                              in any way, onboarding and help screen instructions may also be adjusted.
 *
 */
@Immutable
@Parcelize
public data class SdkStrings(
    val scanningStrings: ScanningStrings,
    val helpDialogsStrings: HelpDialogsStrings
): Parcelable {
    companion object {
        val Default: SdkStrings =
            SdkStrings(
                scanningStrings = ScanningStrings.Default,
                helpDialogsStrings = HelpDialogsStrings.Default
            )
    }
}

/**
 * @see com.microblink.ux.theme.SdkStrings
 */
@Immutable
@Parcelize
data class ScanningStrings(
    @StringRes val instructionsFrontSide: Int,
    @StringRes val instructionsBackSide: Int,
    @StringRes val instructionsBarcode: Int,
    @StringRes val instructionsFlipDocument: Int,
    @StringRes val instructionsDocumentTooCloseToEdge: Int,
    @StringRes val instructionsDocumentNotFullyVisible: Int,
    @StringRes val instructionsDocumentTilted: Int,
    @StringRes val instructionsFacePhotoNotFullyVisible: Int,
    @StringRes val instructionsScanningWrongSide: Int,
    @StringRes val instructionsBlurDetected: Int,
    @StringRes val instructionsGlareDetected: Int,
    @StringRes val instructionsMoveFarther: Int,
    @StringRes val instructionsMoveCloser: Int,
    @StringRes val snackbarFlashlightWarning: Int
): Parcelable {
    companion object {
        val Default: ScanningStrings =
            ScanningStrings(
                instructionsFrontSide = R.string.mb_front_instructions,
                instructionsBackSide = R.string.mb_back_instructions,
                instructionsBarcode = R.string.mb_back_instructions_barcode,
                instructionsFlipDocument = R.string.mb_camera_flip_document,
                instructionsDocumentTooCloseToEdge = R.string.mb_document_too_close_to_edge,
                instructionsDocumentNotFullyVisible = R.string.mb_document_not_fully_visible,
                instructionsDocumentTilted = R.string.mb_keep_document_parallel,
                instructionsFacePhotoNotFullyVisible = R.string.mb_face_photo_not_fully_visible,
                instructionsScanningWrongSide = R.string.mb_scanning_wrong_side,
                instructionsBlurDetected = R.string.mb_blur_detected,
                instructionsGlareDetected = R.string.mb_glare_detected,
                instructionsMoveFarther = R.string.mb_move_farther,
                instructionsMoveCloser = R.string.mb_move_closer,
                snackbarFlashlightWarning = R.string.mb_flashlight_warning_message
            )
    }
}

/**
 * @see com.microblink.ux.theme.SdkStrings
 */
@Immutable
@Parcelize
data class HelpDialogsStrings(
    @StringRes val onboardingTitle: Int,
    @StringRes val onboardingBarcodeTitle: Int,
    @StringRes val onboardingMrzTitle: Int,
    @StringRes val onboardingMessage: Int,
    @StringRes val onboardingBarcodeMessage: Int,
    @StringRes val onboardingMrzMessage: Int,
    @StringRes val helpTitle1: Int,
    @StringRes val helpBarcodeTitle1: Int,
    @StringRes val helpMrzTitle1: Int,
    @StringRes val helpTitle2: Int,
    @StringRes val helpTitle3: Int,
    @StringRes val helpMessage1: Int,
    @StringRes val helpBarcodeMessage1: Int,
    @StringRes val helpMrzMessage1: Int,
    @StringRes val helpMessage2: Int,
    @StringRes val helpMessage3: Int,
): Parcelable {
    companion object {
        val Default: HelpDialogsStrings =
            HelpDialogsStrings(
                onboardingTitle = R.string.mb_onboarding_dialog_title,
                onboardingBarcodeTitle = 0,
                onboardingMrzTitle = 0,
                onboardingMessage = R.string.mb_onboarding_dialog_message,
                onboardingBarcodeMessage = 0,
                onboardingMrzMessage = 0,
                helpTitle1 = R.string.mb_help_screen_title1,
                helpBarcodeTitle1 = 0,
                helpMrzTitle1 = 0,
                helpTitle2 = R.string.mb_help_screen_title2,
                helpTitle3 = R.string.mb_help_screen_title3,
                helpMessage1 = R.string.mb_help_screen_msg1,
                helpBarcodeMessage1 = 0,
                helpMrzMessage1 = 0,
                helpMessage2 = R.string.mb_help_screen_msg2,
                helpMessage3 = R.string.mb_help_screen_msg3
            )
    }
}


var LocalBaseSdkStrings = staticCompositionLocalOf {
    SdkStrings.Default
}