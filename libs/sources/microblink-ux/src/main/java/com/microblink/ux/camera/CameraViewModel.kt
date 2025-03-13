/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.ux.camera

import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class CameraViewModel: ViewModel() {

    /**
     * Updating this value will turn the torch on or off.
     */
    val _torchOn: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val torchOn: StateFlow<Boolean> = _torchOn.asStateFlow()

    /**
     * Analyzes an image to produce a result.
     *
     * This method is called once for each image from the camera, and called at the
     * frame rate of the camera. Each analyze call is executed sequentially.
     *
     * It is the responsibility of the application to close the image once done with it.
     *
     * @see [androidx.camera.core.ImageAnalysis.Analyzer.analyze]
     *
     * @param image input image to process.
     */
    abstract fun analyzeImage(image: ImageProxy)

}