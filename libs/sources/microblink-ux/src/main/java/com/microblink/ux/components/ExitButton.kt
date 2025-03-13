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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.microblink.ux.R
import com.microblink.ux.theme.Gray
import com.microblink.ux.theme.White

@Composable
fun ExitButton(
    modifier: Modifier,
    onExit: () -> Unit
) {
    val exitButtonBackgroundColor = Gray.copy(alpha = 0.6f)
    val exitButtonColor = White

    Box(
        modifier = modifier
            .size(uiButtonRadiusDp)
            .clip(CircleShape)
            .background(exitButtonBackgroundColor)
            .clickable {
                onExit()
            }
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.mb_icon_exit),
            contentDescription = "",
            colorFilter = ColorFilter.tint(exitButtonColor)
        )
    }
}