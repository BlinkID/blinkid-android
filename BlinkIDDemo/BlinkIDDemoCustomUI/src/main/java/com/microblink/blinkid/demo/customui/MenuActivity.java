package com.microblink.blinkid.demo.customui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.microblink.activity.ScanActivity;
import com.microblink.blinkid.demo.R;
import com.microblink.libresult.ResultActivity;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

public class MenuActivity extends Activity {

    public static final int MY_BLINK_ID_REQUEST_CODE = 0x101;

    public static final String TAG = "BlinkIDDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // check if BlinkID is supported on the device
        Button btnScan = (Button) findViewById(R.id.btnScan);

        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus == RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            btnScan.setEnabled(true);
        } else {
            btnScan.setEnabled(false);
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
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

        // onActivityResult is called whenever we are returned from activity started
        // with startActivityForResult. We need to check request code to determine
        // that we have really returned from BlinkID activity.
        if (requestCode == MY_BLINK_ID_REQUEST_CODE) {
            if (resultCode == MyScanActivity.RESULT_OK && data != null) {

                // depending on settings, we may have multiple scan results.
                // we first need to obtain recognition results
                RecognitionResults results = data.getParcelableExtra(ScanActivity.EXTRAS_RECOGNITION_RESULTS);
                BaseRecognitionResult[] resArray = null;
                if (results != null) {
                    // get array of recognition results
                    resArray = results.getRecognitionResults();
                }
                if (resArray != null) {
                    Log.i(TAG, "Data count: " + resArray.length);
                    int i = 1;

                    for(BaseRecognitionResult res : resArray) {
                        Log.i(TAG, "Data #" + Integer.valueOf(i++).toString());

                        // Each element in resultArray inherits BaseRecognitionResult class and
                        // represents the scan result of one of activated recognizers that have
                        // been set up.

                        res.log();
                    }

                } else {
                    Log.e(TAG, "Unable to retrieve recognition data!");
                }

                data.setComponent(new ComponentName(this, ResultActivity.class));
                startActivity(data);
            }
        }
    }
}