package com.microblink.blinkid;

import android.content.Intent;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.fragment.overlay.DocumentOverlayController;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.view.recognition.ScanResultListener;

class ScanUtil {

    static final int REQUEST_CODE = 137;

    private static RecognizerBundle bundle;

    static DocumentUISettings createUISettings() {
        Recognizer recognizer = new MrtdRecognizer();
        bundle = new RecognizerBundle(recognizer);

        DocumentUISettings uiSettings = new DocumentUISettings(bundle);
        uiSettings.setBeepSoundResourceID(R.raw.beep);

        return uiSettings;
    }

    static DocumentOverlayController createOverlayController(DocumentUISettings uiSettings, ScanResultListener scanResultListener) {
        return new DocumentOverlayController(uiSettings, scanResultListener);
    }

    static Intent extractResult() {
        Intent data = new Intent();
        bundle.saveToIntent(data);
        return data;
    }

}
