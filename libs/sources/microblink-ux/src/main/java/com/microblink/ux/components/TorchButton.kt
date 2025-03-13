/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.components

import android.content.res.Resources
import com.microblink.ux.R
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.microblink.ux.state.MbTorchState
import com.microblink.ux.theme.Gray
import com.microblink.ux.theme.White

@Composable
fun TorchButton(
    modifier: Modifier,
    torchState: MbTorchState,
    onTorchStateChange: () -> Unit
) {
//    TODO: if (torchState != MbTorchState.NOT_SUPPORTED_BY_CAMERA) {
    val torchButtonBackgroundColor =
        if (torchState == MbTorchState.On) White else Gray.copy(alpha = 0.6f)
    val torchButtonColor =
        if (torchState == MbTorchState.On) Gray.copy(alpha = 0.6f) else White
    val icon =
        if (torchState == MbTorchState.On) painterResource(R.drawable.mb_icon_torch_on) else painterResource(
            R.drawable.mb_icon_torch_off
        )
    Box(
        modifier = modifier
            .size(uiButtonRadiusDp)
            .clip(CircleShape)
            .background(torchButtonBackgroundColor)
            .clickable {
                onTorchStateChange()
            }
    ) {
        Image(
            modifier = Modifier.fillMaxSize(), painter = icon, contentDescription = "",
            colorFilter = ColorFilter.tint(torchButtonColor)
        )
    }
}