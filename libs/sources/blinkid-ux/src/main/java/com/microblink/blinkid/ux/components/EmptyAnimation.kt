package com.microblink.blinkid.ux.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import kotlin.time.Duration

@Composable
fun EmptyAnimation(animationDuration: Duration, onAnimationCompleted: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(animationDuration.inWholeMilliseconds)
        onAnimationCompleted()
    }
}