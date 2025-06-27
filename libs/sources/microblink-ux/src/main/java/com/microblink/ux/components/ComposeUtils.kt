/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

package com.microblink.ux.components

import android.os.Build
import android.os.VibrationEffect
import androidx.annotation.RequiresApi
import androidx.compose.ui.unit.dp

internal val uiButtonRadiusDp = 36.dp

internal const val flipAnimationDurationMs = 2000
internal const val successAnimationDurationMs = 750

internal const val reticleDashRotationAnimationDurationMs = 550
internal const val reticleDashAppearAnimationDurationMs = 1000
internal const val reticleDashAppearDelayDurationMs = 550

internal const val needHelpTooltipDurationMs = 5000L
const val needHelpTooltipDefaultTimeToAppearMs = 8000L
const val uiCountingWindowDurationMs = 1500L

internal const val shortHapticFeedbackDurationMs = 100L
internal const val shortHapticFeedbackAmplitude = 50
internal const val longHapticFeedbackDurationMs = 300L
internal const val longHapticFeedbackAmplitude = 80

@RequiresApi(Build.VERSION_CODES.O)
fun shortHapticFeedback(): VibrationEffect {
    return VibrationEffect.createOneShot(
        shortHapticFeedbackDurationMs,
        shortHapticFeedbackAmplitude
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun longHapticFeedback(): VibrationEffect {
    return VibrationEffect.createOneShot(
        longHapticFeedbackDurationMs,
        longHapticFeedbackAmplitude
    )
}