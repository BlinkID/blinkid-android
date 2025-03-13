/**
 * Copyright (c) Microblink. All rights reserved. This code is provided for
 * use as-is and may not be copied, modified, or redistributed.
 */

package com.microblink.blinkid.ux.scanning

import com.microblink.blinkid.core.session.BlinkIdProcessResult
import com.microblink.blinkid.core.session.BlinkIdScanningSession
import com.microblink.ux.ScanningUxEvent
import com.microblink.core.image.InputImage

/**
 * An interface that represents the translation process from [ScanningUxEvent] to the UX.
 */
interface BlinkIdUxTranslator {
    suspend fun translate(
        processResult: BlinkIdProcessResult,
        inputImage: InputImage?,
        session: BlinkIdScanningSession,
    ): List<ScanningUxEvent>
}