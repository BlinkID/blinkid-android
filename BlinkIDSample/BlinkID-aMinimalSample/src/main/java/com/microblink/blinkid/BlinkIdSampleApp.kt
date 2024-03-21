package com.microblink.blinkid

import android.app.Application
import com.microblink.blinkid.intent.IntentDataTransferMode

class BlinkIdSampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // obtain your licence at http://microblink.com/login or contact us at http://help.microblink.com
        MicroblinkSDK.setLicenseKey("sRwCABZjb20ubWljcm9ibGluay5ibGlua2lkAGxleUpEY21WaGRHVmtUMjRpT2pFM01URXdNamd4TnpVeU5qQXNJa055WldGMFpXUkdiM0lpT2lKa1pHUXdOalpsWmkwMU9ESXpMVFF3TURndE9UUTRNQzAxTkRVNFlqQXhZVFUyWWpnaWZRPT0XQSGw4MlSYFI4GLBuTrvzIIXpisl+k7h/R9V8iUNw+edq0mlVNOnFqeHImrWXu8UbaKaxqggm6j+lxv818EBLdZ3EaqbZnHZxvOJ2r6SmLdfH8BKXU8OQkyr0VLU4be2TM2DmktEjagaIbkikp96uNyEKCx/3ag==", this)

        // use optimised way for transferring RecognizerBundle between activities, while ensuring
        // data does not get lost when Android restarts the scanning activity
        MicroblinkSDK.setIntentDataTransferMode(IntentDataTransferMode.PERSISTED_OPTIMISED)
    }
}