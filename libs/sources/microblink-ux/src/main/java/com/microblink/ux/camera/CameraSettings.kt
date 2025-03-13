/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.ux.camera

/**
 * Enum representing the camera resolution that is being used.
 */
enum class Resolution(val width: Int, val height: Int) {
    Resolution720p(1280, 720),
    Resolution1080p(1920, 1080),
    Resolution2160p(3840, 2160),
    Resolution4320p(7680, 4320);
}

/**
 * Enum representing whether the front or the back camera is being used.
 */
enum class CameraLensFacing {
    LensFacingBack,
    LensFacingFront
}

/**
 * Configuration settings for the camera used in the verification process.
 *
 * This data class allows you to specify the preferred camera lens facing and
 * the desired resolution for the camera.
 *
 * @property lensFacing The preferred [CameraLensFacing] for the camera.
 *                      Defaults to [CameraLensFacing.LensFacingBack].
 * @property desiredResolution The desired [Resolution] for the camera.
 *                            Defaults to [Resolution.Resolution2160p].
 *
 */
data class CameraSettings(
    val lensFacing: CameraLensFacing = CameraLensFacing.LensFacingBack,
    val desiredResolution: Resolution = Resolution.Resolution2160p
)