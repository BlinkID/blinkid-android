/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.blinkid.ux.scanning

import com.microblink.blinkid.core.session.BlinkIdProcessResult
import com.microblink.blinkid.core.settings.ScanningSettings
import com.microblink.core.image.InputImage
import com.microblink.ux.ScanningUxEvent

/**
 * An interface that represents the translation process from [BlinkIdProcessResult] to [ScanningUxEvent].
 *
 * The translator converts scanning results into UX events based on the provided settings.
 */
interface BlinkIdUxTranslator {
    suspend fun translate(
        processResult: BlinkIdProcessResult,
        inputImage: InputImage?,
        scanningSettings: ScanningSettings,
    ): List<ScanningUxEvent>
}