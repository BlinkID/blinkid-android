/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.ux.camera.compose

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.util.Size
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraControl
import androidx.camera.core.CameraSelector
import androidx.camera.core.FocusMeteringAction
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.core.UseCaseGroup
import androidx.camera.core.resolutionselector.AspectRatioStrategy
import androidx.camera.core.resolutionselector.ResolutionSelector
import androidx.camera.core.resolutionselector.ResolutionStrategy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LifecycleStartEffect
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.microblink.ux.camera.CameraLensFacing
import com.microblink.ux.camera.CameraSettings
import com.microblink.ux.camera.CameraViewModel
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Composable function that displays the camera preview and handles camera-related
 * permissions and image analysis.
 *
 * This composable provides a screen for capturing images using the device's
 * camera. It handles camera permission requests and displays the camera
 * preview if permission is granted. It also provides a content slot for
 * overlaying additional UI elements on top of the camera preview.
 *
 * @param cameraViewModel The [CameraViewModel] used to interact with the camera
 *                        and perform image analysis.
 * @param cameraSettings The [CameraSettings] used to configure the camera.
 *                       Defaults to [CameraSettings] with default values.
 * @param content A composable lambda for adding UI content on top of the camera
 *                preview.
 *
 */
@Composable
fun CameraScreen(
    cameraViewModel: CameraViewModel,
    cameraSettings: CameraSettings = CameraSettings(),
    onCameraScreenLongPress: () -> Unit = { },
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val cameraPermissionGranted = remember { mutableStateOf(isCameraPermissionGranted(context)) }
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        cameraPermissionGranted.value = isGranted
    }
    val torchOn = cameraViewModel.torchOn.collectAsStateWithLifecycle()

    LifecycleStartEffect(Unit) {
        cameraPermissionGranted.value = isCameraPermissionGranted(context)
        onStopOrDispose { }
    }
    if (cameraPermissionGranted.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = {
                            onCameraScreenLongPress()
                        }
                    )
                }
        ) {
            CameraPreview(
                cameraSettings,
                torchOn.value
            ) { imageProxy -> cameraViewModel.analyzeImage(imageProxy) }
            content()
        }

    } else {
        LaunchedEffect(Unit) {
            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
        CameraPermissionDeniedScreen {
            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }
}

@Composable
private fun CameraPreview(
    cameraSettings: CameraSettings = CameraSettings(),
    torchOn: Boolean,
    imageAnalyzer: (ImageProxy) -> Unit,
) {
    val lensFacing = when (cameraSettings.lensFacing) {
        CameraLensFacing.LensFacingBack -> CameraSelector.LENS_FACING_BACK
        CameraLensFacing.LensFacingFront -> CameraSelector.LENS_FACING_FRONT
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    val previewView = remember {
        PreviewView(context)
    }
    val cameraExecutor = remember {
        Executors.newSingleThreadExecutor()
    }
    val cameraControl = remember { mutableStateOf<CameraControl?>(null) }

    LaunchedEffect(lensFacing) {
        val cameraxSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
        val resolutionSelector = ResolutionSelector.Builder()
            .setResolutionStrategy(
                ResolutionStrategy(
                    Size(
                        cameraSettings.desiredResolution.width,
                        cameraSettings.desiredResolution.height
                    ),
                    ResolutionStrategy.FALLBACK_RULE_CLOSEST_HIGHER_THEN_LOWER
                )
            )
            .setAspectRatioStrategy(AspectRatioStrategy.RATIO_16_9_FALLBACK_AUTO_STRATEGY)
            .build()

        val cameraProvider = context.getCameraProvider()

        val previewUseCase = Preview.Builder()
            .setResolutionSelector(resolutionSelector)
            .build()
        val imageAnalysisUseCase = ImageAnalysis.Builder().apply {
            setResolutionSelector(resolutionSelector)
        }.build()
        imageAnalysisUseCase.setAnalyzer(
            cameraExecutor
        ) { imageProxy ->
            imageAnalyzer(imageProxy)
        }

        val useCaseGroup = UseCaseGroup.Builder().apply {
            previewView.viewPort?.let {
                setViewPort(it)
            }
            addUseCase(previewUseCase)
            addUseCase(imageAnalysisUseCase)
        }.build()

        cameraProvider.unbindAll()
        val camera = cameraProvider.bindToLifecycle(lifecycleOwner, cameraxSelector, useCaseGroup)
        previewUseCase.surfaceProvider = previewView.surfaceProvider
        enableTapToFocus(previewView, camera.cameraControl)
        camera.cameraControl.enableTorch(torchOn)
        cameraControl.value = camera.cameraControl
    }

    LaunchedEffect(torchOn) {
        cameraControl.value?.enableTorch(torchOn)
    }

    AndroidView(
        factory = { previewView },
        modifier = Modifier
            .fillMaxSize()
    )
}

private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                @Suppress("BlockingMethodInNonBlockingContext")
                continuation.resume(cameraProvider.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }

@SuppressLint("ClickableViewAccessibility")
private fun enableTapToFocus(previewView: PreviewView, cameraControl: CameraControl) {
    previewView.setOnTouchListener { view, motionEvent ->
        val meteringPoint = previewView.meteringPointFactory
            .createPoint(motionEvent.x, motionEvent.y)
        val action = FocusMeteringAction.Builder(meteringPoint) // default AF|AE|AWB
            // The action is canceled in 3 seconds (if not set, default is 5s).
            .setAutoCancelDuration(3, TimeUnit.SECONDS)
            .build()
        cameraControl.startFocusAndMetering(action)
        view.performClick()
        false
    }
}

private fun isCameraPermissionGranted(context: Context) =
    ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
