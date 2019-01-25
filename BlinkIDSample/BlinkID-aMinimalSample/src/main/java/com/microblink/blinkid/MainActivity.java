package com.microblink.blinkid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.uisettings.ActivityRunner;
import com.microblink.uisettings.DocumentUISettings;

public class MainActivity extends AppCompatActivity {

    public static final int MY_BLINKID_REQUEST_CODE = 123;

    private MrtdRecognizer mMRTDRecognizer;
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we'll use Machine Readable Travel Document recognizer
        mMRTDRecognizer = new MrtdRecognizer();

        // put our recognizer in bundle so that it can be sent via intent
        mRecognizerBundle = new RecognizerBundle(mMRTDRecognizer);
    }

    public void onScanButtonClick(View view) {
        // use default UI for scanning documents
        DocumentUISettings documentUISettings = new DocumentUISettings(mRecognizerBundle);

        // start scan activity based on UI settings
        ActivityRunner.startActivityForResult(this, MY_BLINKID_REQUEST_CODE, documentUISettings);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // onActivityResult is called whenever we returned from activity started with startActivityForResult
        // We need to check request code to determine that we have really returned from BlinkID activity
        if (requestCode != MY_BLINKID_REQUEST_CODE) {
            return;
        }

        if (resultCode == Activity.RESULT_OK) {
            // OK result code means scan was successful
            onScanSuccess(data);
        } else {
            // user probably pressed Back button and cancelled scanning
            onScanCanceled();
        }
    }

    private void onScanSuccess(Intent data) {
        // update recognizer results with scanned data
        mRecognizerBundle.loadFromIntent(data);

        // you can now extract any scanned data from result, we'll just get primary id
        MrtdRecognizer.Result mrtdResult = mMRTDRecognizer.getResult();
        MrzResult mrzResult = mrtdResult.getMrzResult();
        String scannedPrimaryId = mrzResult.getPrimaryId();
        Toast.makeText(this, "Scanned primary id: " + scannedPrimaryId, Toast.LENGTH_LONG).show();
    }

    private void onScanCanceled() {
        Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
    }

}
