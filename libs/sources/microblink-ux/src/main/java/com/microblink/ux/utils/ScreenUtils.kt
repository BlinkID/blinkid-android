package com.microblink.ux.utils

import android.content.Context
import android.view.OrientationEventListener
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Represents the possible orientations of a screen.
 */
enum class ScreenOrientation {
    /**
     * Indicates that the screen orientation is unknown.
     */
    Unknown,

    /**
     * Indicates that the screen is in portrait orientation.
     */
    Portrait,

    /**
     * Indicates that the screen is in landscape orientation with the right side of the device up.
     */
    LandscapeRight,

    /**
     * Indicates that the screen is in landscape orientation with the left side of the device up.
     */
    ReversePortrait,

    /**
     * Indicates that the screen is upside-down.
     */
    LandscapeLeft
}

@Composable
fun DeviceOrientationListener(
    applicationContext: Context,
    onOrientationChange: (ScreenOrientation) -> Unit
) {

    var currentOrientation: ScreenOrientation by remember { mutableStateOf(ScreenOrientation.Unknown) }

    DisposableEffect(Unit) {

        val orientationEventListener = object : OrientationEventListener(applicationContext) {
            override fun onOrientationChanged(orientation: Int) {
                if (orientation >= 350 || orientation < 10) {
                    if (currentOrientation != ScreenOrientation.Portrait) {
                        onOrientationChange(ScreenOrientation.Portrait)
                        currentOrientation = ScreenOrientation.Portrait
                    }
                } else if (orientation in 80..149) {
                    if (currentOrientation != ScreenOrientation.LandscapeLeft) {
                        onOrientationChange(ScreenOrientation.LandscapeLeft)
                        currentOrientation = ScreenOrientation.LandscapeLeft
                    }
                } else if (orientation in 210..289) {
                    if (currentOrientation != ScreenOrientation.LandscapeRight) {
                        onOrientationChange(ScreenOrientation.LandscapeRight)
                        currentOrientation = ScreenOrientation.LandscapeRight
                    }
                } else if (orientation in 150..209) {
                    if (currentOrientation != ScreenOrientation.ReversePortrait) {
                        onOrientationChange(ScreenOrientation.ReversePortrait)
                        currentOrientation = ScreenOrientation.ReversePortrait
                    }
                }
            }
        }

        orientationEventListener.enable()

        onDispose {
            orientationEventListener.disable()
        }

    }
}