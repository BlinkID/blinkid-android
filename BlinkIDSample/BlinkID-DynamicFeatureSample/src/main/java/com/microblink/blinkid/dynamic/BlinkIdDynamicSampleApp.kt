package com.microblink.blinkid.dynamic

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitcompat.SplitCompatApplication

class BlinkIdDynamicSampleApp : SplitCompatApplication() {

    /**
     *  If you don't want to extend the App as SplitCompatApplication
     *  you can use the regular Application and then override attachBaseContext
     *  with SplitCompat.install(this) method call
     */

    override fun onCreate() {
        super.onCreate()
    }

    //  uncomment this if using Application() extension
    //
    //    override fun attachBaseContext(base: Context) {
    //        super.attachBaseContext(base)
    //
    //        SplitCompat.install(this)
    //    }

}