/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.blinkid.ux.theme

import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.microblink.blinkid.ux.theme.BlinkIdSdkStrings.Companion.Default
import com.microblink.ux.R
import com.microblink.ux.theme.AccessibilityStrings
import com.microblink.ux.theme.HelpDialogsStrings
import com.microblink.ux.theme.LocalBaseSdkStrings
import com.microblink.ux.theme.ScanningStrings
import com.microblink.ux.theme.SdkStrings
import kotlinx.parcelize.Parcelize

/**
 * Data class contains all the strings used throughout the SDK.
 * [Default] can be used to keep the original strings if only some of the elements are to be changed.
 *
 * This class shouldn't be modified, but rather a new instance should be
 * created and used in [com.microblink.ux.UiSettings.sdkStrings].
 *
 * @property blinkIdScanningStrings Strings that appear as instruction messages during the scanning session.
 *           These instructions are triggered by specific UX events and will appear on screen accordingly.
 *           Includes both BlinkID specific and common SDK strings.
 * @property blinkIdHelpDialogsStrings Strings used in onboarding and help dialogs. These strings shouldn't
 *           be customized as they provide adequate instructions tailored specifically to our scanning experience.
 *           However, if the scanning experience is changed in any way, onboarding and help screen instructions
 *           may also be adjusted.
 * @property blinkIdAccessibilityStrings Strings that are used by accessibility TalkBack service for specific
 *           buttons, labels, and actions.
 */
@Immutable
@Parcelize
data class BlinkIdSdkStrings(
    val blinkIdScanningStrings: BlinkIdScanningStrings,
    val blinkIdHelpDialogsStrings: HelpDialogsStrings,
    val blinkIdAccessibilityStrings: AccessibilityStrings
) : Parcelable, SdkStrings(
    ScanningStrings(
        blinkIdScanningStrings.instructionsFirstSide,
        blinkIdScanningStrings.instructionsSecondSide,
        blinkIdScanningStrings.instructionsFlip,
        blinkIdScanningStrings.instructionsNotFullyVisible,
        blinkIdScanningStrings.instructionsTilted,
        blinkIdScanningStrings.instructionsScanningWrongSide,
        blinkIdScanningStrings.instructionsBlurDetected,
        blinkIdScanningStrings.instructionsMoveFarther,
        blinkIdScanningStrings.instructionsMoveCloser,
        blinkIdScanningStrings.snackbarFlashlightWarning
    ),
    blinkIdHelpDialogsStrings,
    blinkIdAccessibilityStrings
) {
    companion object {
        @JvmStatic
        val Default: BlinkIdSdkStrings =
            BlinkIdSdkStrings(
                blinkIdScanningStrings = BlinkIdScanningStrings.Default,
                blinkIdHelpDialogsStrings = HelpDialogsStrings.BlinkIdDefaults,
                blinkIdAccessibilityStrings = AccessibilityStrings.Default
            )
    }

    init {
        LocalBaseSdkStrings = staticCompositionLocalOf {
            BlinkIdSdkStrings.Default
        }
    }
}

val HelpDialogsStrings.Companion.BlinkIdDefaults: HelpDialogsStrings
    get() = HelpDialogsStrings(
        onboardingTitle = R.string.mb_onboarding_dialog_title,
        onboardingMessage = R.string.mb_onboarding_dialog_message,
        helpTitles = listOf(
            R.string.mb_help_screen_title1,
            R.string.mb_help_screen_title2,
            R.string.mb_help_screen_title3
        ),
        helpMessages = listOf(
            R.string.mb_help_screen_msg1,
            R.string.mb_help_screen_msg2,
            R.string.mb_help_screen_msg3,
        )
    )

/**
 * Includes common SDK strings from [ScanningStrings] and BlinkID specific strings.
 */
@Immutable
@Parcelize
data class BlinkIdScanningStrings(
    @StringRes override val instructionsFirstSide: Int,
    @StringRes override val instructionsSecondSide: Int,
    @StringRes val instructionsBarcode: Int,
    @StringRes override val instructionsFlip: Int,
    @StringRes override val instructionsNotFullyVisible: Int,
    @StringRes override val instructionsTilted: Int,
    @StringRes val instructionsFacePhotoNotFullyVisible: Int,
    @StringRes override val instructionsScanningWrongSide: Int,
    @StringRes override val instructionsBlurDetected: Int,
    @StringRes val instructionsGlareDetected: Int,
    @StringRes override val instructionsMoveFarther: Int,
    @StringRes override val instructionsMoveCloser: Int,
    @StringRes val instructionsIncreaseLight: Int,
    @StringRes val instructionsDecreaseLight: Int,
    @StringRes override val snackbarFlashlightWarning: Int,
    @StringRes val instructionsPassportDataPage: Int,
    @StringRes val instructionsPassportMoveToTopPage: Int,
    @StringRes val instructionsPassportMoveToRightPage: Int,
    @StringRes val instructionsPassportMoveToLeftPage: Int,
    @StringRes val instructionsPassportMoveToBarcodePage: Int,
    @StringRes val instructionsPassportWrongPageTop: Int,
    @StringRes val instructionsPassportWrongPageRight: Int,
    @StringRes val instructionsPassportWrongPageLeft: Int,
    @StringRes val instructionsPassportWrongPageBarcode: Int,
    @StringRes val instructionsPassportScanTopPage: Int,
    @StringRes val instructionsPassportScanRightPage: Int,
    @StringRes val instructionsPassportScanLeftPage: Int,
    @StringRes val instructionsPassportScanBarcodePage: Int
) : Parcelable, ScanningStrings(
    instructionsFirstSide,
    instructionsSecondSide,
    instructionsFlip,
    instructionsNotFullyVisible,
    instructionsTilted,
    instructionsScanningWrongSide,
    instructionsBlurDetected,
    instructionsMoveFarther,
    instructionsMoveCloser,
    snackbarFlashlightWarning
) {
    companion object {
        @JvmStatic
        val Default: BlinkIdScanningStrings =
            BlinkIdScanningStrings(
                instructionsFirstSide = R.string.mb_front_instructions,
                instructionsSecondSide = R.string.mb_back_instructions,
                instructionsBarcode = R.string.mb_back_instructions_barcode,
                instructionsFlip = R.string.mb_camera_flip_document,
                instructionsNotFullyVisible = R.string.mb_document_not_fully_visible,
                instructionsTilted = R.string.mb_keep_document_parallel,
                instructionsFacePhotoNotFullyVisible = R.string.mb_face_photo_not_fully_visible,
                instructionsScanningWrongSide = R.string.mb_scanning_wrong_side,
                instructionsBlurDetected = R.string.mb_blur_detected,
                instructionsGlareDetected = R.string.mb_glare_detected,
                instructionsMoveFarther = R.string.mb_move_farther,
                instructionsMoveCloser = R.string.mb_move_closer,
                instructionsIncreaseLight = R.string.mb_increase_lighting_intensity,
                instructionsDecreaseLight = R.string.mb_decrease_lighting_intensity,
                snackbarFlashlightWarning = R.string.mb_flashlight_warning_message,
                instructionsPassportDataPage = R.string.mb_passport_scan_data_page_instructions,
                instructionsPassportMoveToTopPage = R.string.mb_instructions_turn_page_top,
                instructionsPassportMoveToRightPage = R.string.mb_instructions_turn_page_right,
                instructionsPassportMoveToLeftPage = R.string.mb_instructions_turn_page_left,
                instructionsPassportMoveToBarcodePage = R.string.mb_instructions_scan_barcode_last_page,
                instructionsPassportWrongPageTop = R.string.mb_scanning_wrong_page_top,
                instructionsPassportWrongPageRight = R.string.mb_scanning_wrong_page_right,
                instructionsPassportWrongPageLeft = R.string.mb_scanning_wrong_page_left,
                instructionsPassportWrongPageBarcode = R.string.mb_instructions_scan_barcode_last_page,
                instructionsPassportScanTopPage = R.string.mb_top_page_instructions,
                instructionsPassportScanRightPage = R.string.mb_right_page_instructions,
                instructionsPassportScanLeftPage = R.string.mb_left_page_instructions,
                instructionsPassportScanBarcodePage = R.string.mb_instructions_scan_barcode_last_page
            )
    }
}

var LocalBaseBlinkIdSdkStrings = staticCompositionLocalOf {
    BlinkIdSdkStrings.Default
}