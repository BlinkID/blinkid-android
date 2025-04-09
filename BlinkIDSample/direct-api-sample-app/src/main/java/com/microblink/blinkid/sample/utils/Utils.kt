package com.microblink.blinkid.sample.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

fun getBitmapFromAsset(context: Context, filePath: String): Bitmap? {
    try {
        context.assets.open(filePath).use {
            return BitmapFactory.decodeStream(it)
        }
    } catch (ex: java.lang.Exception) {
        return null
    }
}