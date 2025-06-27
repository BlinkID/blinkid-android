package com.microblink.blinkid.ux

/**
 * Copyright (c) Microblink. Modifications are allowed under the terms of the
 * license for files located in the UX/UI lib folder.
 */

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.microblink.blinkid.core.BlinkIdSdk
import com.microblink.blinkid.core.session.BlinkIdScanningResult
import com.microblink.blinkid.core.session.BlinkIdSessionSettings
import com.microblink.blinkid.ux.settings.BlinkIdUxSettings
import com.microblink.blinkid.ux.theme.BlinkIdSdkTheme
import com.microblink.blinkid.ux.theme.BlinkIdTheme
import com.microblink.ux.ScanningUx
import com.microblink.ux.UiSettings
import com.microblink.ux.camera.compose.CameraScreen
import com.microblink.ux.state.MbTorchState
import com.microblink.ux.state.ProcessingState
import com.microblink.ux.utils.DeviceOrientationListener
import kotlinx.coroutines.launch

private const val TAG = "BlinkIdCameraScanningScreen"

/**
 * Composable function that provides a complete camera scanning screen using
 * the BlinkID SDK.
 *
 * This composable function sets up and manages the entire camera scanning
 * process, including UI elements, camera interaction, and result handling. It
 * uses the provided [blinkIdSdk] and [BlinkIdSessionSettings] to
 * configure the scanning session and provides callbacks for handling
 * successful capture and cancellation.
 *
 * @param blinkIdSdk The [BlinkIdSdk] instance used for document scanning.
 * @param uxSettings The [BlinkIdUxSettings] used to customize the UX.
 * @param uiSettings The [UiSettings] used to customize the UI.
 *                         Defaults to [UiSettings] with default values.
 * @param sessionSettings The [BlinkIdSessionSettings] used to configure
 *                        the capture session. Defaults to [BlinkIdSessionSettings] with default values.
 * @param onScanningSuccess A callback function invoked when a document is
 *                         successfully captured. Receives the
 *                         [BlinkIdScanningResult] as a parameter.
 * @param onScanningCanceled A callback function invoked when the user cancels
 *                          the scanning process.
 *
 */
@Composable
fun BlinkIdCameraScanningScreen(
    blinkIdSdk: BlinkIdSdk,
    uxSettings: BlinkIdUxSettings = BlinkIdUxSettings(),
    uiSettings: UiSettings = UiSettings(),
    sessionSettings: BlinkIdSessionSettings = BlinkIdSessionSettings(),
    onScanningSuccess: (BlinkIdScanningResult) -> Unit,
    onScanningCanceled: () -> Unit,
) {
    val viewModel: BlinkIdUxViewModel = viewModel(
        factory = BlinkIdUxViewModel.Factory,
        extras = MutableCreationExtras().apply {
            set(
                BlinkIdUxViewModel.BLINKID_SDK,
                blinkIdSdk
            )
            set(
                BlinkIdUxViewModel.BLINKID_SESSION_SETTINGS,
                sessionSettings
            )
            set(
                BlinkIdUxViewModel.BLINKID_UX_SETTINGS,
                uxSettings
            )
        }
    )

    val applicationContext = LocalContext.current.applicationContext

    DeviceOrientationListener(applicationContext) {
        viewModel.setScreenOrientation(it)
    }

    var initialUiStateSet by rememberSaveable { mutableStateOf(false) }
    if (!initialUiStateSet) {
        viewModel.setInitialUiStateFromUiSettings(uiSettings)
        initialUiStateSet = true
    }

    val snackbarHostState = remember { SnackbarHostState() }

    BlinkIdSdkTheme(uiSettings) {
        val app = applicationContext as? Application
        app?.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(
                activity: Activity,
                savedInstanceState: Bundle?
            ) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
                viewModel.lifecycleResumeAnalysis()
            }

            override fun onActivityPaused(activity: Activity) {
                viewModel.lifecyclePauseAnalysis()
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(
                activity: Activity,
                outState: Bundle
            ) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

        })
        val snackbarWarningMessage =
            stringResource(BlinkIdTheme.sdkStrings.scanningStrings.snackbarFlashlightWarning)
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { paddingValues ->
            CameraScreen(
                cameraViewModel = viewModel,
                onCameraScreenLongPress = { viewModel.changeHelpTooltipVisibility(true) },
            ) {
                val overlayUiState = viewModel.uiState.collectAsStateWithLifecycle()

                if (overlayUiState.value.processingState == ProcessingState.Success) {
                    overlayUiState.value.blinkIdScanningResult?.let {
                        onScanningSuccess(it)
                    }
                }
                BackHandler {
                    onScanningCanceled()
                }
                ScanningUx(
                    Modifier.padding(paddingValues),
                    overlayUiState.value,
                    onScanningCanceled,
                    uiSettings,
                    uxSettings.allowHapticFeedback,
                    showProductionOverlay = !blinkIdSdk.getLicenseToken().licenseRights.allowRemoveProductionOverlay,
                    showDemoOverlay = !blinkIdSdk.getLicenseToken().licenseRights.allowRemoveDemoOverlay,
                    {
                        viewModel.changeTorchState()
                        viewModel.viewModelScope.launch {
                            if (viewModel.uiState.value.torchState == MbTorchState.On) {
                                snackbarHostState.showSnackbar(
                                    snackbarWarningMessage,
                                    null,
                                    false,
                                    SnackbarDuration.Short
                                )
                            }
                        }
                    },
                    viewModel::onFlipAnimationCompleted,
                    viewModel::onReticleSuccessAnimationCompleted,
                    viewModel::onHapticFeedbackCompleted,
                    viewModel::changeOnboardingDialogVisibility,
                    viewModel::changeHelpScreensVisibility,
                    viewModel::changeHelpTooltipVisibility,
                    viewModel::onRetryTimeout,
                    onScanningCanceled
                )
            }
        }
    }
}