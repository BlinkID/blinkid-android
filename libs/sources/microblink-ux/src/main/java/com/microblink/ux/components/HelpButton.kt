/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.microblink.ux.R
import com.microblink.ux.theme.SdkTheme

@Composable
fun HelpButton(
    modifier: Modifier = Modifier,
    onChangeOnboardingDialogState: (Boolean) -> Unit
) {
    val helpButtonBackgroundColor = SdkTheme.uiColors.helpButtonBackground
    val helpButtonColor = SdkTheme.uiColors.helpButton

    Box(
        modifier = modifier
            .size(uiButtonRadiusDp)
            .clip(CircleShape)
            .background(helpButtonBackgroundColor)
            .clickable {
                onChangeOnboardingDialogState(true)
            }
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.mb_icon_help),
            contentDescription = "",
            tint = helpButtonColor
        )
    }
}