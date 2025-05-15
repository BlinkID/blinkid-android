package com.microblink.blinkid.ux.settings

import android.os.Parcelable
import com.microblink.blinkid.core.result.classinfo.Country
import com.microblink.blinkid.core.result.classinfo.Region
import com.microblink.blinkid.core.result.classinfo.Type
import kotlinx.parcelize.Parcelize
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

/**
 * Configuration settings for the scanning UX.
 *
 * @param stepTimeoutDuration Duration of the scanning session before a timeout is triggered.
 * Resets every time the scanning is paused (dialogs, side change). Defaults to 15 seconds.
 * @param classFilter Defines which specific document classes are allowed during scanning.
 * Each document class is defined by the trio of [Country], [Region], and [Type].
 * @param
 */
@Parcelize
data class BlinkIdUxSettings constructor(
    val stepTimeoutDuration: Duration = 15000.milliseconds,
    val classFilter: ClassFilter? = null
) : Parcelable {
    /**
     * Constructor for easier Java implementation.
     *
     * This secondary constructor allows Java developers to create a [BlinkIdUxSettings]
     * instance by providing the `stepTimeoutDuration` as an `Int` in milliseconds.
     *
     * @param stepTimeoutDurationMs Duration of the scanning session before a timeout is triggered
     * in milliseconds. Resets every time the scanning is paused (dialogs, side change).
     * @param classFilter Defines which specific document classes are allowed during scanning.
     * Each document class is defined by the trio of [Country], [Region], and [Type].
     */
    @JvmOverloads constructor(stepTimeoutDurationMs: Int, classFilter: ClassFilter? = null) : this(stepTimeoutDuration = stepTimeoutDurationMs.milliseconds, classFilter)
}