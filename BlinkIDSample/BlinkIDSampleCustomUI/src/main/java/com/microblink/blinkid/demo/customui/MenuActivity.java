package com.microblink.blinkid.demo.customui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.microblink.blinkid.demo.R;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
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
        Button btnScan = findViewById(R.id.btnScan);

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
                RecognizerBundle recognizerBundle = data.getParcelableExtra(MyScanActivity.EXTRA_RECOGNIZER_BUNDLE);
                Recognizer[] recognizers = recognizerBundle.getRecognizers();
                //TODO start results activity
                //data.setComponent(new ComponentName(this, ResultActivity.class));
                //startActivity(data);
            }
        }
    }
}