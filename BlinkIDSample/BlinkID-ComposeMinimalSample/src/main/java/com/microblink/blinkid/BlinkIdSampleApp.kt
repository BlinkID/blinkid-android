package com.microblink.blinkid

import android.app.Application
import com.microblink.blinkid.intent.IntentDataTransferMode

class BlinkIdSampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // obtain your licence at http://microblink.com/login or contact us at http://help.microblink.com
        MicroblinkSDK.setLicenseFile("com.microblink.blinkid.mblic", this)

        // use optimised way for transferring RecognizerBundle between activities, while ensuring
        // data does not get lost when Android restarts the scanning activity
        MicroblinkSDK.setIntentDataTransferMode(IntentDataTransferMode.PERSISTED_OPTIMISED)
    }

}