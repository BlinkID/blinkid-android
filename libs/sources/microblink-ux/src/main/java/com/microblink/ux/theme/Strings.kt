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
import com.microblink.ux.theme.SdkStrings.Companion.Default
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize


/**
 * Data class contains all the strings used throughout the SDK.
 * [Default] can be used to keep the original strings if only some of the elements are to be changed.
 *
 * This class shouldn't be modified, but rather a new instance should be
 * created and used in [com.microblink.ux.UiSettings.sdkStrings].
 *
 * @property scanningStrings Strings that appear as instruction messages during the scanning session.
 * These instructions are triggered by specific UX events and will appear on screen accordingly.
 * @property helpDialogsStrings Strings used in onboarding and help dialogs. These strings shouldn't
 * be customized as they provide adequate instructions tailored specifically to our scanning experience.
 * However, if the scanning experience is changed in any way, onboarding and help screen instructions may also be adjusted.
 * @property accessibilityStrings Strings that are used by accessibility TalkBack service for specific
 * buttons, labels, and actions.
 */
@Immutable
@Parcelize
open class SdkStrings(
    val scanningStrings: ScanningStrings,
    val helpDialogsStrings: HelpDialogsStrings,
    val accessibilityStrings: AccessibilityStrings
) : Parcelable {
    companion object {
        val Default: SdkStrings =
            SdkStrings(
                scanningStrings = ScanningStrings.Empty,
                helpDialogsStrings = HelpDialogsStrings.Empty,
                accessibilityStrings = AccessibilityStrings.Default
            )
    }
}

/**
 * @see com.microblink.ux.theme.SdkStrings
 */
@Immutable
@Parcelize
open class ScanningStrings(
    @StringRes open val instructionsFirstSide: Int,
    @StringRes open val instructionsSecondSide: Int,
    @StringRes open val instructionsFlip: Int,
    @StringRes open val instructionsNotFullyVisible: Int,
    @StringRes open val instructionsTilted: Int,
    @StringRes open val instructionsScanningWrongSide: Int,
    @StringRes open val instructionsBlurDetected: Int,
    @StringRes open val instructionsMoveFarther: Int,
    @StringRes open val instructionsMoveCloser: Int,
    @StringRes open val snackbarFlashlightWarning: Int
) : Parcelable {
    companion object {
        @JvmStatic val Empty = ScanningStrings(
            instructionsFirstSide = 0,
            instructionsSecondSide = 0,
            instructionsFlip = 0,
            instructionsNotFullyVisible = 0,
            instructionsTilted = 0,
            instructionsScanningWrongSide = 0,
            instructionsBlurDetected = 0,
            instructionsMoveFarther = 0,
            instructionsMoveCloser = 0,
            snackbarFlashlightWarning = 0
        )
    }
}

/**
 * @see com.microblink.ux.theme.SdkStrings
 */
@Immutable
@Parcelize
open class HelpDialogsStrings(
    @StringRes val onboardingTitle: Int,
    @StringRes val onboardingMessage: Int,
    @StringRes val helpTitles: List<Int>,
    @StringRes val helpMessages: List<Int>
) : Parcelable {
    companion object {
        @JvmStatic val Empty = HelpDialogsStrings(
            onboardingTitle = 0,
            onboardingMessage = 0,
            helpTitles = emptyList(),
            helpMessages = emptyList()
        )
    }
}

/**
 * @see com.microblink.ux.theme.SdkStrings
 */
@Immutable
@Parcelize
data class AccessibilityStrings(
    @StringRes val scanCompleted: Int,
    @StringRes val firstSideScanned: Int,
    @StringRes val previousPage: Int,
    @StringRes val nextPage: Int,
    @StringRes val showHelpScreens: Int,
    @StringRes val turnFlashlightOff: Int,
    @StringRes val turnFlashlightOn: Int,
    @StringRes val exitScanning: Int,
    @StringRes val flashlightOff: Int,
    @StringRes val flashlightOn: Int
) : Parcelable {
    companion object {
        @JvmStatic val Default: AccessibilityStrings = AccessibilityStrings(
            scanCompleted = R.string.mb_accessibility_success_document_scanned,
            firstSideScanned = R.string.mb_accessibility_success_first_side_scanned,
            previousPage = R.string.mb_accessibility_previous_page,
            nextPage = R.string.mb_accessibility_next_page,
            showHelpScreens = R.string.mb_accessibility_show_help_screens,
            turnFlashlightOff = R.string.mb_accessibility_turn_flashlight_off,
            turnFlashlightOn = R.string.mb_accessibility_turn_flashlight_on,
            exitScanning = R.string.mb_accessibility_exit_scanning,
            flashlightOff = R.string.mb_accessibility_flashlight_off,
            flashlightOn = R.string.mb_accessibility_flashlight_on
        )
    }
}

var LocalBaseSdkStrings = staticCompositionLocalOf {
    SdkStrings.Default
}