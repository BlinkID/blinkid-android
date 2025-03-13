/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import com.microblink.ux.theme.SdkStrings
import com.microblink.ux.theme.UiColors
import com.microblink.ux.theme.UiTypography

const val DefaultShowOnboardingDialog = true
const val DefaultShowHelpButton = true

/**
 * Configuration settings for the scanning UI.
 *
 * Allows customization of various aspects of the UI used
 * during the scanning process, such as typography, color schemes,
 * reticle colors, string resources, and dialogs.
 *
 * @property typography             The [Typography] to be used in the scanning UI.
 *                                  Defaults to [com.microblink.ux.theme.UiTypography] which uses default OS font.
 *                                  Defaults to `null`.
 * @property colorScheme            The [ColorScheme] to be used in the scanning UI.
 *                                  If left `null`, the theme will be applied based on the device settings (dark or light mode).
 *                                  Setting this value will overwrite the default behavior and the user
 *                                  will be responsible for handling theming based on device settings. Defaults to `null`.
 * @property uiColors               The [UiColors] to be used for graphical elements of scanning the UI.
 *                                  If left `null`, the theme will be applied based on the
 *                                  device settings (dark or light mode). Setting this value will overwrite the
 *                                  default behavior and the user will be responsible for handling theming based
 *                                  on device settings. Defaults to `null`.
 * @property sdkStrings             The [SdkStrings] containing text strings for the scanning UI, such as scanning strings
 *                                  and help dialog strings. Defaults to [com.microblink.ux.theme.SdkStrings.Default].
 * @property showOnboardingDialog   A boolean indicating whether to show an onboarding dialog at the beginning
 *                                  of the scanning session. Defaults to [DefaultShowOnboardingDialog].
 * @property showHelpButton         A boolean indicating whether to show a help button and enable help screens
 *                                  during the scanning session. Defaults to [DefaultShowHelpButton].
 *
 */
public data class UiSettings(
    val typography: UiTypography? = null,
    val colorScheme: ColorScheme? = null,
    val uiColors: UiColors? = null,
    val sdkStrings: SdkStrings? = null,
    val showOnboardingDialog: Boolean = DefaultShowOnboardingDialog,
    val showHelpButton: Boolean = DefaultShowHelpButton
)