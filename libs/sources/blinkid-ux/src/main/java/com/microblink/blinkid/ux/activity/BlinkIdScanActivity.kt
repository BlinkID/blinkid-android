package com.microblink.blinkid.ux.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.microblink.blinkid.ux.BlinkIdCameraScanningScreen
import com.microblink.blinkid.ux.contract.BlinkIdScanActivitySettings
import com.microblink.blinkid.ux.contract.BlinkIdScanningResultHolder
import com.microblink.blinkid.ux.contract.MbBlinkIdScan
import com.microblink.blinkid.ux.theme.BlinkIdSdkTheme
import com.microblink.core.ping.util.PingletTracker
import com.microblink.ux.UiSettings
import com.microblink.ux.components.LoadingScreen
import com.microblink.ux.theme.DarkColorScheme
import com.microblink.ux.theme.LightColorScheme
import com.microblink.ux.theme.LocalBaseUiColors
import com.microblink.ux.theme.LocalTheme
import com.microblink.ux.theme.UiColors
import com.microblink.ux.utils.toUiTypography
import kotlinx.coroutines.launch

private const val TAG = "BlinkIdScanActivity"

class BlinkIdScanActivity : AppCompatActivity() {

    private val activityViewModel: BlinkIdScanActivityViewModel by viewModels()
    private lateinit var blinkIdScanActivitySettings: BlinkIdScanActivitySettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blinkIdScanActivitySettings = BlinkIdScanActivitySettings.loadFromIntent(intent)
        if (blinkIdScanActivitySettings.enableEdgeToEdge) enableEdgeToEdge()

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onCancel(MbBlinkIdScan.CancelReason.UserRequested)
            }
        })

        activityViewModel.viewModelScope.launch {
            activityViewModel.initializeLocalSdk(
                context = this@BlinkIdScanActivity,
                blinkIdSdkSettings = blinkIdScanActivitySettings.sdkSettings,
                onInitFailed = { exception ->
                    Log.e(TAG, "SDK initialization failed", exception)
                    onCancel(MbBlinkIdScan.CancelReason.ErrorSdkInit)
                }
            )
        }

        PingletTracker.Log.trackInfo(
            context = this,
            logMessage = "Using BlinkIdScanActivity"
        )

        setContent {

            val uiSettings = createUiSettings(blinkIdScanActivitySettings)

            BlinkIdSdkTheme(uiSettings) {
                val displayLoading = activityViewModel.displayLoading.collectAsStateWithLifecycle()
                if (displayLoading.value) {
                    LoadingScreen()
                } else {
                    activityViewModel.localSdk?.let {
                        BlinkIdCameraScanningScreen(
                            blinkIdSdk = it,
                            uxSettings = blinkIdScanActivitySettings.uxSettings,
                            uiSettings = uiSettings,
                            cameraSettings = blinkIdScanActivitySettings.cameraSettings,
                            sessionSettings = blinkIdScanActivitySettings.scanningSessionSettings,
                            onScanningSuccess = { result ->
                                BlinkIdScanningResultHolder.blinkIdScanningResult = result
                                this.setResult(RESULT_OK)
                                this.finish()
                            },
                            onScanningCanceled = {
                                onCancel(MbBlinkIdScan.CancelReason.UserRequested)
                            }
                        )
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        if (blinkIdScanActivitySettings.deleteCachedAssetsAfterUse) {
            activityViewModel.unloadSdkAndDeleteCachedAssets()
        } else {
            activityViewModel.unloadSdk()
        }
        super.onDestroy()
    }

    fun onCancel(cancelReason: MbBlinkIdScan.CancelReason) {
        val extras = Intent()
        extras.putExtra(MbBlinkIdScan.EXTRA_CANCEL_REASON, cancelReason)
        this.setResult(RESULT_CANCELED, extras)
        this.finish()

    }

    @Composable
    fun createUiSettings(blinkIdActivitySettings: BlinkIdScanActivitySettings): UiSettings {
        val primaryColor =
            if (blinkIdScanActivitySettings.scanActivityUiColors?.primary != null) Color(
                blinkIdScanActivitySettings.scanActivityUiColors!!.primary!!
            ) else if (isSystemInDarkTheme()) DarkColorScheme.primary else LightColorScheme.primary
        val backgroundColor =
            if (blinkIdScanActivitySettings.scanActivityUiColors?.background != null) Color(
                blinkIdScanActivitySettings.scanActivityUiColors!!.background!!
            ) else if (isSystemInDarkTheme()) DarkColorScheme.background else LightColorScheme.background
        val onBackgroundColor =
            if (blinkIdScanActivitySettings.scanActivityUiColors?.onBackground != null) Color(
                blinkIdScanActivitySettings.scanActivityUiColors!!.onBackground!!
            ) else if (isSystemInDarkTheme()) DarkColorScheme.onBackground else LightColorScheme.onBackground

        val colorScheme = LocalTheme.current.copy(
            primary = primaryColor,
            background = backgroundColor,
            onBackground = onBackgroundColor
        )

        val helpButtonColor =
            if (blinkIdScanActivitySettings.scanActivityUiColors?.helpButton != null) Color(
                blinkIdScanActivitySettings.scanActivityUiColors!!.helpButton!!
            ) else if (isSystemInDarkTheme()) UiColors.DefaultDark.helpButton else UiColors.Default.helpButton
        val helpButtonBackgroundColor =
            if (blinkIdScanActivitySettings.scanActivityUiColors?.helpButtonBackground != null) Color(
                blinkIdScanActivitySettings.scanActivityUiColors!!.helpButtonBackground!!
            ) else if (isSystemInDarkTheme()) UiColors.DefaultDark.helpButtonBackground else UiColors.Default.helpButtonBackground
        val helpTooltipTextColor =
            if (blinkIdScanActivitySettings.scanActivityUiColors?.helpTooltipText != null) Color(
                blinkIdScanActivitySettings.scanActivityUiColors!!.helpTooltipText!!
            ) else if (isSystemInDarkTheme()) UiColors.DefaultDark.helpTooltipText else UiColors.Default.helpTooltipText
        val helpTooltipBackgroundColor =
            if (blinkIdScanActivitySettings.scanActivityUiColors?.helpTooltipBackground != null) Color(
                blinkIdScanActivitySettings.scanActivityUiColors!!.helpTooltipBackground!!
            ) else if (isSystemInDarkTheme()) UiColors.DefaultDark.helpTooltipBackground else UiColors.Default.helpTooltipBackground

        val uiColors = LocalBaseUiColors.current.copy(
            helpButton = helpButtonColor,
            helpButtonBackground = helpButtonBackgroundColor,
            helpTooltipText = helpTooltipTextColor,
            helpTooltipBackground = helpTooltipBackgroundColor
        )

        val uiTypography = blinkIdScanActivitySettings.scanActivityTypography.toUiTypography()

        return UiSettings(
            typography = uiTypography,
            colorScheme = colorScheme,
            uiColors = uiColors,
            sdkStrings = blinkIdScanActivitySettings.scanActivityUiStrings,
            showOnboardingDialog = blinkIdScanActivitySettings.showOnboardingDialog,
            showHelpButton = blinkIdScanActivitySettings.showHelpButton
        )
    }
}