package com.microblink.blinkid.ux.utils

import androidx.compose.runtime.Composable
import com.microblink.blinkid.ux.theme.BlinkIdTheme
import com.microblink.ux.R
import com.microblink.ux.components.ErrorDialog
import com.microblink.ux.components.HelpScreenPage
import com.microblink.ux.components.HelpScreens
import com.microblink.ux.state.ErrorState

@Composable
fun fillHelpScreens(): HelpScreens {
    return HelpScreens(
        onboardingDialogPage = HelpScreenPage(
            pageImage = R.drawable.mb_blinkid_onboarding_id,
            pageTitle = BlinkIdTheme.sdkStrings.helpDialogsStrings.onboardingTitle,
            pageMessage = BlinkIdTheme.sdkStrings.helpDialogsStrings.onboardingMessage,
        ),
        helpDialogPages = listOf(
            HelpScreenPage(
                pageImage = R.drawable.mb_blinkid_help_id_page_one,
                pageTitle = BlinkIdTheme.sdkStrings.helpDialogsStrings.helpTitles[0],
                pageMessage = BlinkIdTheme.sdkStrings.helpDialogsStrings.helpMessages[0]
            ), HelpScreenPage(
                pageImage = R.drawable.mb_blinkid_help_id_page_two,
                pageTitle = BlinkIdTheme.sdkStrings.helpDialogsStrings.helpTitles[1],
                pageMessage = BlinkIdTheme.sdkStrings.helpDialogsStrings.helpMessages[1]
            ), HelpScreenPage(
                pageImage = R.drawable.mb_blinkid_help_id_page_three,
                pageTitle = BlinkIdTheme.sdkStrings.helpDialogsStrings.helpTitles[2],
                pageMessage = BlinkIdTheme.sdkStrings.helpDialogsStrings.helpMessages[2]
            )
        )
    )
}

@Composable
fun fillErrorDialogs(
    onRetry: () -> Unit,
    onDoneError: () -> Unit
): Map<ErrorState, @Composable () -> Unit> {
    return mapOf(
        ErrorState.NoError to {},
        ErrorState.ErrorInvalidLicense to
                {
                    ErrorDialog(
                        com.microblink.ux.R.string.mb_license_locked,
                        null,
                        com.microblink.ux.R.string.mb_close,
                        onButtonClick = onDoneError
                    )
                },

        ErrorState.ErrorNetworkError to
                {
                    ErrorDialog(
                        com.microblink.ux.R.string.mb_license_locked,
                        null,
                        com.microblink.ux.R.string.mb_close,
                        onButtonClick = onDoneError
                    )
                },

        ErrorState.ErrorTimeoutExpired to
                {
                    ErrorDialog(
                        com.microblink.ux.R.string.mb_recognition_timeout_dialog_title,
                        com.microblink.ux.R.string.mb_recognition_timeout_dialog_message,
                        com.microblink.ux.R.string.mb_recognition_timeout_dialog_retry_button,
                        onButtonClick = onRetry
                    )
                },

        ErrorState.ErrorDocumentClassFiltered to
                {
                    ErrorDialog(
                        com.microblink.ux.R.string.mb_document_class_filtered_dialog_title,
                        com.microblink.ux.R.string.mb_document_class_filtered_dialog_message,
                        com.microblink.ux.R.string.mb_recognition_timeout_dialog_retry_button,
                        onButtonClick = onRetry
                    )
                }
    )
}