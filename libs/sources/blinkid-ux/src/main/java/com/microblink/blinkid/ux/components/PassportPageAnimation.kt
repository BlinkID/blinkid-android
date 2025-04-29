package com.microblink.blinkid.ux.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.microblink.blinkid.ux.state.PassportPage
import com.microblink.blinkid.ux.utils.passportMovePageAnimationDurationMs
import com.microblink.ux.R
import com.microblink.ux.components.DocumentDrawable
import kotlinx.coroutines.launch

@Composable
fun PassportPageAnimation(
    pageDirection: PassportPage,
    screenDimensionMin: Dp,
    onAnimationCompleted: () -> Unit
) {
    var isTransparent by remember {
        mutableStateOf(true)
    }
    val passportDrawable =
        DocumentDrawable(R.drawable.mb_passport_bottom, R.drawable.mb_passport_top)
    val targetOffset by remember {
        mutableStateOf(DpOffset(0.dp, -((screenDimensionMin / 8))))
    }
    val animatedOffset = remember { Animatable(DpOffset(0.dp, 0.dp), DpOffset.VectorConverter) }
    val animatedAlpha = remember {
        Animatable(if (isTransparent) 0.3f else 1f)
    }
    val reverseAnimatedAlpha = remember {
        Animatable(if (isTransparent) 1f else 0.3f)
    }
    LaunchedEffect(Unit) {
        launch {
            animatedOffset.animateTo(
                targetValue = targetOffset,
                animationSpec = tween(
                    passportMovePageAnimationDurationMs
                )
            )
            onAnimationCompleted()
        }
        launch {
            isTransparent = false
            animatedAlpha.animateTo(
                targetValue = if (isTransparent) 0.3f else 1f,
                animationSpec = tween(passportMovePageAnimationDurationMs)
            )
        }
        launch {
            reverseAnimatedAlpha.animateTo(
                targetValue = if (isTransparent) 1f else 0.3f,
                animationSpec = tween(passportMovePageAnimationDurationMs)
            )
        }
    }
    Box(
        modifier = Modifier
            .width((screenDimensionMin / 2))
            .height((screenDimensionMin / 4))
    ) {
        Column(
            modifier = Modifier.rotate(
                if (pageDirection == PassportPage.Top) 0f
                else if (pageDirection == PassportPage.Right) 90f
                else -90f
            )
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(0.5f)
            ) {
                Image(
                    painter = painterResource(passportDrawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .alpha(animatedAlpha.value)
                        .fillMaxSize(0.90f)
                        .align(Alignment.CenterVertically)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(0.5f)
            ) {
                Image(
                    painter = painterResource(passportDrawable.front),
                    contentDescription = null,
                    modifier = Modifier
                        .alpha(reverseAnimatedAlpha.value)
                        .fillMaxSize(0.90f)
                        .align(Alignment.Center)
                )
                Image(
                    painter = painterResource(R.drawable.mb_passport_page_highlight),
                    contentDescription = "",
                    modifier = Modifier
                        .offset(animatedOffset.value.x, animatedOffset.value.y)
                        .fillMaxSize()
                )
            }
        }
    }
}