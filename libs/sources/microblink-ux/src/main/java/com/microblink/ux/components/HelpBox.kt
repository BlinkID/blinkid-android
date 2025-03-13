/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HelpBox(
    modifier: Modifier,
    helpScreensButtonDisplayed: Boolean,
    helpTooltipDisplayed: Boolean,
    onChangeOnboardingDialogState: (Boolean) -> Unit,
    onChangeHelpTooltipState: (Boolean) -> Unit
) {
    var _helpScreensButtonDisplayed by rememberSaveable {
        mutableStateOf(helpScreensButtonDisplayed)
    }

    LaunchedEffect(helpScreensButtonDisplayed) {
        _helpScreensButtonDisplayed = helpScreensButtonDisplayed
    }

    if (helpScreensButtonDisplayed) {

        Column(modifier = modifier.padding(10.dp)) {
            AnimatedVisibility(helpTooltipDisplayed) { NeedHelpTooltip(onChangeHelpTooltipState) }
            HelpButton(
                modifier = Modifier.align(Alignment.End),
                onChangeOnboardingDialogState = onChangeOnboardingDialogState
            )
        }
    }
}