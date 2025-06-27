/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.microblink.ux.theme.SdkTheme

@Composable
fun MessageContainer(
    modifier: Modifier = Modifier,
    @StringRes textRes: Int,
    backgroundColor: Color
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp
    val maxWidth = if (screenHeight > screenWidth) screenWidth * 0.8f else screenWidth * 0.4f

    Box(
        modifier = modifier
            .widthIn(0.dp, maxWidth.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(textRes),
            textAlign = TextAlign.Center,
            color = White,
            style = SdkTheme.sdkTypography.scanningInstructions
        )
    }

}