package com.microblink.blinkid.ux.contract

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Parcelable
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.ColorInt
import androidx.core.os.BundleCompat
import com.microblink.blinkid.core.BlinkIdSdkSettings
import com.microblink.blinkid.core.session.BlinkIdScanningResult
import com.microblink.blinkid.core.session.BlinkIdSessionSettings
import com.microblink.blinkid.ux.activity.BlinkIdScanActivity
import com.microblink.blinkid.ux.contract.BlinkIdScanActivityResultStatus.Canceled
import com.microblink.blinkid.ux.contract.BlinkIdScanActivityResultStatus.DocumentScanned
import com.microblink.blinkid.ux.contract.BlinkIdScanActivityResultStatus.ErrorSdkInit
import com.microblink.blinkid.ux.settings.BlinkIdUxSettings
import com.microblink.ux.DefaultShowHelpButton
import com.microblink.ux.DefaultShowOnboardingDialog
import com.microblink.ux.theme.SdkStrings
import com.microblink.ux.utils.ParcelableUiTypography
import kotlinx.parcelize.Parcelize

class MbBlinkIdScan : ActivityResultContract<BlinkIdScanActivitySettings, BlinkIdScanActivityResult>() {
    override fun createIntent(context: Context, input: BlinkIdScanActivitySettings): Intent {
        return Intent(context, BlinkIdScanActivity::class.java).also {
            input.saveToIntent(it)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): BlinkIdScanActivityResult {
        if (resultCode == Activity.RESULT_OK) {
            BlinkIdScanningResultHolder.blinkIdScanningResult?.let { result ->
                return BlinkIdScanActivityResult(
                    status = BlinkIdScanActivityResultStatus.DocumentScanned,
                    result = result
                )
            }
            throw IllegalStateException("Activity was completed successfully, but the result is empty!")
        } else {
            val cancelReason = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent?.getSerializableExtra(EXTRA_CANCEL_REASON, CancelReason::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent?.getSerializableExtra(EXTRA_CANCEL_REASON) as? CancelReason
            }
            return when (cancelReason) {
                CancelReason.ErrorSdkInit ->
                    BlinkIdScanActivityResult(
                        status = BlinkIdScanActivityResultStatus.ErrorSdkInit,
                        result = null
                    )

                CancelReason.UserRequested -> BlinkIdScanActivityResult(
                    status = BlinkIdScanActivityResultStatus.Canceled,
                    result = null
                )

                else -> BlinkIdScanActivityResult(
                    status = BlinkIdScanActivityResultStatus.Canceled,
                    result = null
                )
            }
        }
    }

    companion object {
        const val EXTRA_CANCEL_REASON = "ExtraCancelReason"
    }

    enum class CancelReason {
        UserRequested,
        ErrorSdkInit
    }
}

@Parcelize
data class BlinkIdScanActivityColors(
    @ColorInt val primary: Int?,
    @ColorInt val background: Int?,
    @ColorInt val onBackground: Int?,
    @ColorInt val helpButtonBackground: Int?,
    @ColorInt val helpButton: Int?,
    @ColorInt val helpTooltipBackground: Int?,
    @ColorInt val helpTooltipText: Int?,
) : Parcelable

/**
 * Configuration settings for the [BlinkIdScanActivity].
 *
 * This data class encapsulates the various settings that control the behavior and appearance of
 * the [BlinkIdScanActivity], including the SDK settings, scanning session configurations,
 * UI customization options, and other miscellaneous preferences.
 *
 * @property sdkSettings The core SDK settings required for initializing and
 *           running the BlinkID SDK. This is a mandatory parameter.
 * @property scanningSessionSettings Configuration options for the document scanning session. This
 *           allows you to customize aspects of the scanning process, such as certain visual check strictness
 *           and timeout duration. Defaults to `BlinkIdSessionSettings()`.
 * @property uxSettings The [BlinkIdUxSettings] used to customize the UX.
 * @property scanActivityUiColors Custom colors for the `BlinkIdScanActivity` user interface.
 *           If set to `null`, the default colors will be used. Defaults to `null`.
 * @property scanActivityUiStrings Custom strings for the `BlinkIdScanActivity` user
 *           interface. Defaults to [SdkStrings.Default].
 * @property scanActivityTypography Custom typography for the `BlinkIdScanActivity` user
 *           interface. Due to a limitation of [Typography] class, [ParcelableUiTypography] mimics
 *           [com.microblink.ux.theme.UiTypography] by allowing the customization of all the elements to a lesser extent.
 *           The most important [TextStyle] and [Font] customizations are still available through this class.
 *           Defaults to [ParcelableUiTypography.Default].
 * @property showOnboardingDialog Determines whether an onboarding dialog should be displayed to
 *           the user when the activity is first launched. Defaults to [DefaultShowOnboardingDialog].
 * @property showHelpButton Determines whether a help button should be displayed in the activity.
 *           The button allows the user to open help screens during scanning. Defaults to [DefaultShowHelpButton].
 * @property enableEdgeToEdge Enables edge-to-edge display for the activity. This is the default behavior for
 *           all Android 15 devices (and above) and cannot be changed by this setting. In order to have this behavior
 *           on older OS versions, this setting should be set to `true`. Padding and window insets are
 *           handled automatically. Defaults to `true`.
 * @property deleteCachedAssetsAfterUse Indicates whether cached SDK assets should be deleted after
 *           they are used. If the scanning session is used only once (e.g. for user onboarding), the setting
 *           should be set to `true`. Otherwise, the setting should be set to `true` to avoid assets being re-downloaded.
 *           This only applies if `DOWNLOAD_RESOURCES` variant of the SDK is used. Defaults to `false`.
 *
 */
@Parcelize
data class BlinkIdScanActivitySettings(
    val sdkSettings: BlinkIdSdkSettings,
    val scanningSessionSettings: BlinkIdSessionSettings = BlinkIdSessionSettings(),
    val uxSettings: BlinkIdUxSettings = BlinkIdUxSettings(),
    val scanActivityUiColors: BlinkIdScanActivityColors? = null,
    val scanActivityUiStrings: SdkStrings = SdkStrings.Default,
    val scanActivityTypography: ParcelableUiTypography = ParcelableUiTypography.Default(null),
    val showOnboardingDialog: Boolean = DefaultShowOnboardingDialog,
    val showHelpButton: Boolean = DefaultShowHelpButton,
    val enableEdgeToEdge: Boolean = true,
    val deleteCachedAssetsAfterUse: Boolean = false
) : Parcelable {
    internal fun saveToIntent(intent: Intent) {
        intent.putExtra(INTENT_EXTRAS_BLINKID_SETTINGS, this)
    }

    override fun describeContents(): Int {
        return 0
    }

    internal companion object {
        internal fun loadFromIntent(intent: Intent): BlinkIdScanActivitySettings {
            return intent.extras?.let {
                BundleCompat.getParcelable(
                    it, INTENT_EXTRAS_BLINKID_SETTINGS,
                    BlinkIdScanActivitySettings::class.java
                )
            }
                ?: throw java.lang.IllegalStateException("Intent does not contain expected BlinkIdScanActivitySettings!")
        }

        private const val INTENT_EXTRAS_BLINKID_SETTINGS = "MbBlinkIdSettings"
    }
}

/**
 * @property DocumentScanned Document has been successfully scanned.
 * @property Canceled Scanning process has been canceled by the user, or because of any other unexpected error.
 * @property ErrorSdkInit Scanning process has been canceled because of the license check error. This happens
 *        if you use license which is online activated, and activation fails.
 *
 */
public enum class BlinkIdScanActivityResultStatus {
    DocumentScanned,
    Canceled,
    ErrorSdkInit
}

/**
 * Class containing results of the BlinkID Scanning activity.
 *
 * @property status Represents the status of the activity result and shows whether the activity completed
 *                  successfully or what caused it not to complete.
 * @property result Result of the document scanning session activity.
 *                  Result is present only if [status] is [ActivityResultStatus.DocumentScanned], otherwise it is null.
 *
 */
public data class BlinkIdScanActivityResult(
    val status: BlinkIdScanActivityResultStatus,
    val result: BlinkIdScanningResult?
)