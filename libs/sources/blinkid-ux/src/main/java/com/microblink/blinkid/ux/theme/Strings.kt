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
        blinkIdScanningStrings.instructionsFrontSide,
        blinkIdScanningStrings.instructionsBackSide,
        blinkIdScanningStrings.instructionsBarcode,
        blinkIdScanningStrings.instructionsFlipDocument,
        blinkIdScanningStrings.instructionsDocumentTooCloseToEdge,
        blinkIdScanningStrings.instructionsDocumentNotFullyVisible,
        blinkIdScanningStrings.instructionsDocumentTilted,
        blinkIdScanningStrings.instructionsFacePhotoNotFullyVisible,
        blinkIdScanningStrings.instructionsScanningWrongSide,
        blinkIdScanningStrings.instructionsBlurDetected,
        blinkIdScanningStrings.instructionsGlareDetected,
        blinkIdScanningStrings.instructionsMoveFarther,
        blinkIdScanningStrings.instructionsMoveCloser,
        blinkIdScanningStrings.instructionsIncreaseLight,
        blinkIdScanningStrings.instructionsDecreaseLight,
        blinkIdScanningStrings.snackbarFlashlightWarning
    ),
    blinkIdHelpDialogsStrings,
    blinkIdAccessibilityStrings
) {
    companion object {
        @JvmStatic val Default: BlinkIdSdkStrings =
            BlinkIdSdkStrings(
                blinkIdScanningStrings = BlinkIdScanningStrings.Default,
                blinkIdHelpDialogsStrings = HelpDialogsStrings.Default,
                blinkIdAccessibilityStrings = AccessibilityStrings.Default
            )
    }
}

/**
 * Includes common SDK strings from [ScanningStrings] and BlinkID specific strings.
 */
@Immutable
@Parcelize
data class BlinkIdScanningStrings(
    @StringRes override val instructionsFrontSide: Int,
    @StringRes override val instructionsBackSide: Int,
    @StringRes override val instructionsBarcode: Int,
    @StringRes override val instructionsFlipDocument: Int,
    @StringRes override val instructionsDocumentTooCloseToEdge: Int,
    @StringRes override val instructionsDocumentNotFullyVisible: Int,
    @StringRes override val instructionsDocumentTilted: Int,
    @StringRes override val instructionsFacePhotoNotFullyVisible: Int,
    @StringRes override val instructionsScanningWrongSide: Int,
    @StringRes override val instructionsBlurDetected: Int,
    @StringRes override val instructionsGlareDetected: Int,
    @StringRes override val instructionsMoveFarther: Int,
    @StringRes override val instructionsMoveCloser: Int,
    @StringRes override val instructionsIncreaseLight: Int,
    @StringRes override val instructionsDecreaseLight: Int,
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
    instructionsFrontSide,
    instructionsBackSide,
    instructionsBarcode,
    instructionsFlipDocument,
    instructionsDocumentTooCloseToEdge,
    instructionsDocumentNotFullyVisible,
    instructionsDocumentTilted,
    instructionsFacePhotoNotFullyVisible,
    instructionsScanningWrongSide,
    instructionsBlurDetected,
    instructionsGlareDetected,
    instructionsMoveFarther,
    instructionsMoveCloser,
    instructionsIncreaseLight,
    instructionsDecreaseLight,
    snackbarFlashlightWarning
) {
    companion object {
        val Default: BlinkIdScanningStrings =
            BlinkIdScanningStrings(
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