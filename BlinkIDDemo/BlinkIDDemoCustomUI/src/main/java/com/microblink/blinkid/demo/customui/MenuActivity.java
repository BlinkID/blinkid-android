package com.microblink.blinkid.demo.customui;

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

import com.microblink.activity.ScanActivity;
import com.microblink.blinkid.demo.R;
import com.microblink.blinkid.demo.config.Config;
import com.microblink.blinkid.demo.result.ResultActivity;
import com.microblink.locale.LanguageUtils;
import com.microblink.recognizers.BaseRecognitionResult;
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
        LanguageUtils.setLanguage(Config.LANGUAGE, this);
        super.onResume();
    }

    public void myClickHandler(View view) {
        // Intent for MyScanActivity
        final Intent intent = new Intent(this, MyScanActivity.class);
        startActivityForResult(intent, MY_BLINK_ID_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_BLINK_ID_REQUEST_CODE) {
            if (resultCode == MyScanActivity.RESULT_OK && data != null) {

                // dump Recognition data list
                Parcelable[] multiData = data.getParcelableArrayExtra(ScanActivity.EXTRAS_RECOGNITION_RESULT_LIST);
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