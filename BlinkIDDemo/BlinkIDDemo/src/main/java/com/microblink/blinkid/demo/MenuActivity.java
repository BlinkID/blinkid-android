package com.microblink.blinkid.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.microblink.activity.ScanCard;
import com.microblink.blinkid.demo.config.Config;
import com.microblink.blinkid.demo.result.ResultActivity;
import com.microblink.locale.LanguageUtils;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

public class MenuActivity extends Activity {

    public static final int MY_BLINK_ID_REQUEST_CODE = 0x101;

    public static final String TAG = "BlinkIDDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LanguageUtils.setLanguage(Config.LANGUAGE, this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (Config.IS_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        // check if BlinkID is supported on the device
        Button btnScan = (Button) findViewById(R.id.btnScan);
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus == RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            btnScan.setEnabled(true);
        } else {
            btnScan.setEnabled(false);
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // define BlinkID language
        LanguageUtils.setLanguage(Config.LANGUAGE, this);
    }

    public void myClickHandler(View view) {
        // Intent for ScanId Activity
        final Intent intent = new Intent(this, ScanCard.class);

        /**
         * If you want sound to be played after the scanning process ends, put
         * here the resource ID of your sound file.
         */
        intent.putExtra(ScanCard.EXTRAS_BEEP_RESOURCE, R.raw.beep);

        /**
         * If you want to disable moving of camera viewfinder to detected
         * position of slip, set this parameter to false (default is true;
         * applies only to default BlinkID camera UI).
         */
        intent.putExtra(ScanCard.EXTRAS_VIEWFINDER_MOVEABLE, Config.VIEWFINDER_MOVEABLE);

        /**
         * Prepare settings for recognition.
         */
        RecognizerSettings[] settArray = Config.getRecognizerSettings();
        if (settArray != null) {
            intent.putExtra(ScanCard.EXTRAS_RECOGNIZER_SETTINGS_ARRAY, settArray);
        }

        /** set the license key (for commercial versions only) - obtain your key at
         *  https://microblink.com/idscan
         */
        intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, "TIS6J3KZ-JDJLDMNR-WGYDQF5D-BKLREV3B-63EO5ADK-KRHKXLDV-3U52ETVL-VR22VLU3"); // demo license key for package com.microblink.blinkid.demo

        /**
         * if you want, you can enable pinch to zoom feature
         */
        intent.putExtra(ScanCard.EXTRAS_ALLOW_PINCH_TO_ZOOM, true);

        intent.putExtra(ScanCard.EXTRAS_SHOW_FOCUS_RECTANGLE, true);

        /**
         * Start activity for result.
         */
        startActivityForResult(intent, MY_BLINK_ID_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_BLINK_ID_REQUEST_CODE) {
            if (resultCode == ScanCard.RESULT_OK && data != null) {

                // dump Recognition data list
                Parcelable[] multiData = data.getParcelableArrayExtra(ScanCard.EXTRAS_RECOGNITION_RESULT_LIST);
                if(multiData != null) {
                    Log.i(TAG, "Data count: " + multiData.length);
                    int i = 1;
                    for(Parcelable parc : multiData) {
                        Log.i(TAG, "Data #" + Integer.valueOf(i++).toString());
                        BaseRecognitionResult rd = (BaseRecognitionResult)parc;
                        rd.log();
                    }
                } else {
                    Log.e(TAG, "Unable to retrieve list of recognition data!");
                }

                data.setComponent(new ComponentName(this, ResultActivity.class));
                startActivity(data);
            }
        }
    }
}