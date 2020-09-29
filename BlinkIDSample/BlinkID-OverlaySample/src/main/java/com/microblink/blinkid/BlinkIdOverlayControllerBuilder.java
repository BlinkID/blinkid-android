package com.microblink.blinkid;

import android.content.Context;

import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayController;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlaySettings;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayStrings;
import com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView;
import com.microblink.view.recognition.ScanResultListener;

class BlinkIdOverlayControllerBuilder {

    static BlinkIdOverlayController build(Context context, RecognizerBundle recognizerBundle, ScanResultListener scanResultListener) {

        BlinkIdOverlaySettings overlaySettings = new BlinkIdOverlaySettings.Builder(recognizerBundle)
                // customise overlay controller here
                .build();

        ReticleOverlayStrings overlayStrings = new ReticleOverlayStrings.Builder(context)
                // you can override all default strings here
                .build();

        // you can override icons, colors and text appearances by setting your custom style
        // supported attributes depend on overlay view you're using,
        // for ReticleOverlayView check attributes in R.styleable.BlinkIdReticleOverlay
        int customStyle = R.style.BluePulseStyle;

        BlinkIdOverlayView overlayView = new ReticleOverlayView(true, true, overlayStrings, customStyle);
        return new BlinkIdOverlayController(overlaySettings, scanResultListener, overlayView);
    }

}
