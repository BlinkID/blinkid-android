/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.microblink.ux.R
import com.microblink.ux.theme.SdkTheme
import kotlinx.coroutines.delay

@Composable
fun NeedHelpTooltip(
    onChangeHelpTooltipState: (Boolean) -> Unit
) {
    val helpTooltipBackgroundColor = SdkTheme.uiColors.helpTooltipBackground
    val helpTooltipTextColor = SdkTheme.uiColors.helpTooltipText

    LaunchedEffect(Unit) {
        delay(5000)
        onChangeHelpTooltipState(false)
    }

    Column {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(color = helpTooltipBackgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(6.dp),
                text = stringResource(R.string.mb_need_help_tooltip),
                style = SdkTheme.sdkTypography.helpTooltip,
                color = helpTooltipTextColor
            )
        }
        Canvas(Modifier.size(16.dp).align(Alignment.End)) {
            val path = Path().apply {
                moveTo(-12f, -1f)
                lineTo(12f, -1f)
                lineTo(0f, 20f)
                close()
            }
            drawPath(path = path, color = helpTooltipBackgroundColor)
        }
    }
}