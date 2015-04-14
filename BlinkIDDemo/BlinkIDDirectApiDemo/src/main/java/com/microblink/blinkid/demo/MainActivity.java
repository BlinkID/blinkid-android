package com.microblink.blinkid.demo;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.microblink.blinkid.demo.config.Config;
import com.microblink.directApi.Recognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.recognizers.ocr.mrtd.MRTDRecognitionResult;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.view.recognition.RecognitionType;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity {

    private static final String TAG = "DirectApiDemo";

    private Recognizer mRecognizer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mRecognizer = Recognizer.getSingletonInstance();

        // set license key
        boolean success = mRecognizer.setLicenseKey(this, "RQQO6OZ2-GK6MFNGS-UVWVK2JA-P5TRPIYK-S4JFOYPW-ZDXIA2SU-J2V2Y5O5-HORDTOL2");
        if (!success) {
            Log.e(TAG, "Failed to set licence key!");
            Toast.makeText(this, "Failed to set licence key!", Toast.LENGTH_LONG).show();
            return;
        }

        // initialize recognizer singleton
        mRecognizer.initialize(this, null, Config.getRecognizerSettings());
    }

    public void onScanAssetClick(View v) {
        if(mRecognizer.getCurrentState() != Recognizer.State.READY) {
            Log.e(TAG, "Recognizer not ready!");
            return;
        }
        // load Bitmap from assets
        AssetManager assets = getAssets();
        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assets.open("croID.jpg");
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            // handle exception
            Log.e(TAG, "Failed to load image from assets!");
            Toast.makeText(this, "Failed to load image from assets!", Toast.LENGTH_LONG).show();
            return;
        }

        if(bitmap != null) {
            mRecognizer.setOrientation(Orientation.ORIENTATION_LANDSCAPE_RIGHT);
            // recognize image
            mRecognizer.recognize(bitmap, new ScanResultListener() {
                @Override
                public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {

                    if (dataArray != null && dataArray.length > 0) {
                        if (dataArray[0] instanceof MRTDRecognitionResult) {
                            MRTDRecognitionResult result = (MRTDRecognitionResult) dataArray[0];
                            StringBuilder resultStr = new StringBuilder(result.getMRZText());
                            resultStr.append('\n');
                            resultStr.append("First name: ");
                            resultStr.append(result.getSecondaryId());
                            resultStr.append('\n');
                            resultStr.append("Last name: ");
                            resultStr.append(result.getPrimaryId());
                            Toast.makeText(MainActivity.this, resultStr.toString(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Nothing scanned!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRecognizer.terminate();
        mRecognizer = null;
    }
}
