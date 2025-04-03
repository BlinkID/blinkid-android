package com.microblink.ux.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.microblink.ux.R
import com.microblink.ux.theme.SdkTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeedHelpTooltip(
    modifier: Modifier,
    onChangeHelpTooltipState: (Boolean) -> Unit,
    onChangeOnboardingDialogState: (Boolean) -> Unit,
    helpTooltipDisplayed: Boolean
) {
    val tooltipState = rememberTooltipState(isPersistent = true)
    val scope = rememberCoroutineScope()

    val tooltipText = stringResource(R.string.mb_need_help_tooltip)
    val helpTooltipBackgroundColor = SdkTheme.uiColors.helpTooltipBackground
    val helpTooltipTextColor = SdkTheme.uiColors.helpTooltipText

    LaunchedEffect(helpTooltipDisplayed) {
        if (helpTooltipDisplayed) {
            scope.launch {
                tooltipState.show()
            }
            delay(5000)
            scope.launch {
                tooltipState.dismiss()
            }
            onChangeHelpTooltipState(false)
        }
    }
    Column(modifier, horizontalAlignment = Alignment.End) {
        TooltipBox(
            modifier = modifier,
            positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(
                SpacingBetweenTooltipAndAnchor
            ),
            enableUserInput = false,
            tooltip = {
                RichTooltip(
                    shape = RoundedCornerShape(8.dp),
                    colors = TooltipDefaults.richTooltipColors()
                        .copy(containerColor = helpTooltipBackgroundColor),
                    caretSize = DpSize(
                        10.dp,
                        10.dp
                    )
                ) { Text(text = tooltipText, color = helpTooltipTextColor) }
            },
            state = tooltipState,
        ) {
            HelpButton(
                onChangeOnboardingDialogState = onChangeOnboardingDialogState
            )
        }
    }
}

internal val SpacingBetweenTooltipAndAnchor = 16.dp