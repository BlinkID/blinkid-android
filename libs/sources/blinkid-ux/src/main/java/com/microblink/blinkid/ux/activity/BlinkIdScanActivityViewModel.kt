package com.microblink.blinkid.ux.activity

import android.content.Context
import androidx.lifecycle.ViewModel
import com.microblink.blinkid.core.BlinkIdSdk
import com.microblink.blinkid.core.BlinkIdSdkSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BlinkIdScanActivityViewModel : ViewModel() {

    private val _displayLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var displayLoading = _displayLoading.asStateFlow()

    var localSdk: BlinkIdSdk? = null
        private set

    suspend fun initializeLocalSdk(
        context: Context,
        blinkIdSdkSettings: BlinkIdSdkSettings,
        onInitFailed: (exception: Throwable?) -> Unit
    ) {
        _displayLoading.update {
            true
        }

        val maybeInstance = BlinkIdSdk.initializeSdk(
            context,
            blinkIdSdkSettings
        )
        when {
            maybeInstance.isSuccess -> {
                localSdk = maybeInstance.getOrNull()
                _displayLoading.update {
                    false
                }
            }

            maybeInstance.isFailure -> {
                onInitFailed(maybeInstance.exceptionOrNull())
            }
        }
    }

    fun unloadSdk() {
        try {
            localSdk?.close()
        } catch (_: Exception) {
        }
        localSdk = null
    }

    fun unloadSdkAndDeleteCachedAssets() {
        try {
            localSdk?.closeAndDeleteCachedAssets()
        } catch (_: Exception) {
        }
        localSdk = null
    }

}