/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.camera.compose

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import com.microblink.ux.R
import com.microblink.ux.theme.Black
import com.microblink.ux.theme.Cobalt
import com.microblink.ux.theme.White
import androidx.core.net.toUri

/**
 * Composable function that displays a screen to inform the user that camera
 * permission is denied and provides options to request or enable it.
 *
 * This composable displays an informative screen with an image and text
 * indicating that camera permission is required. It provides a button to
 * request camera permission again or, if the user has permanently denied the
 * permission, shows an alert dialog with instructions to enable the
 * permission manually in the device settings.
 *
 * This screen is used as a part of the SDK and may be modified if necessary.
 *
 * @param requestCameraPermission A lambda function to be invoked when the user
 *                                clicks the button to request camera
 *                                permission.
 *
 */
@Composable
fun CameraPermissionDeniedScreen(requestCameraPermission: () -> Unit) {
    val shouldShowDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.mb_camera_denied),
                contentDescription = stringResource(id = R.string.mb_camera_permission_required),
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.mb_camera_permission_required),
                color = Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(colors = ButtonDefaults.buttonColors().copy(containerColor = Cobalt), onClick = {
                val shouldShowRequestPermissionRationale = (context as? Activity)?.let {
                    shouldShowRequestPermissionRationale(it, Manifest.permission.CAMERA)
                } ?: false
                if (shouldShowRequestPermissionRationale) {
                    requestCameraPermission()
                } else {
                    shouldShowDialog.value = true
                }
            }) {
                Text(text = stringResource(id = R.string.mb_enable_camera))
            }
        }

        if (shouldShowDialog.value) {
            AlertDialog(
                onDismissRequest = { shouldShowDialog.value = false },
                title = { Text(text = stringResource(R.string.mb_warning_dialog_title)) },
                text = { Text(text = stringResource(R.string.mb_enable_permission_help)) },
                containerColor = White,
                confirmButton = {
                    Button(
                        colors = ButtonDefaults.buttonColors().copy(containerColor = Cobalt),
                        onClick = {
                            shouldShowDialog.value = false
                            context.startActivity(
                                Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    ("package:" + context.packageName).toUri()
                                )
                            )
                        }
                    ) {
                        Text(
                            text = stringResource(R.string.mb_ok),
                        )
                    }
                }
            )
        }

    }
}