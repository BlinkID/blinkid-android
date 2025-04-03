package com.microblink.blinkid.ux.settings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import com.microblink.blinkid.core.result.classinfo.Country
import com.microblink.blinkid.core.result.classinfo.Region
import com.microblink.blinkid.core.result.classinfo.Type

/**
 * Configuration settings for the scanning UX.
 *
 * @param stepTimeoutDuration Duration of the scanning timeout for each scanning step
 * (document side) in milliseconds. When timeout occurs, scanning starts from the beginning.
 * @param classFilter Defines which specific document classes are allowed during scanning.
 * Each document class is defined by the trio of [Country], [Region], and [Type].
 */
@Parcelize
data class BlinkIdUxSettings(
    val stepTimeoutDuration: Duration = 15000.milliseconds,
    val classFilter: ClassFilter? = null
) : Parcelable
