package com.microblink.blinkid.demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.microblink.blinkid.demo.config.Config;
import com.microblink.directApi.DirectApiErrorListener;
import com.microblink.directApi.Recognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.ocr.mrtd.MRTDRecognitionResult;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.view.recognition.RecognitionType;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity {

    private static final String TAG = "DirectApiDemo";

    private Recognizer mRecognizer = null;
    private Button mScanAssetBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScanAssetBtn = (Button)findViewById(R.id.button);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mRecognizer = Recognizer.getSingletonInstance();

        // set license key
        try {
            mRecognizer.setLicenseKey(this, "TIS6J3KZ-JDJLDMNR-WGYDQF5D-BKLREV3B-63EO5ADK-KRHKXLDV-3U52ETVL-VR22VLU3");
        } catch (InvalidLicenceKeyException e) {
            Log.e(TAG, "Failed to set licence key!");
            Toast.makeText(this, "Failed to set licence key!", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // initialize recognizer singleton
        mRecognizer.initialize(this, null, Config.getRecognizerSettings(), new DirectApiErrorListener() {
            @Override
            public void onRecognizerError(Throwable throwable) {
                Log.e(TAG, "Failed to initialize recognizer.", throwable);
                Toast.makeText(MainActivity.this, "Failed to initialize recognizer. Reason: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        });
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
            // disable button
            mScanAssetBtn.setEnabled(false);
            // show progress dialog
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setIndeterminate(true);
            pd.setMessage("Performing recognition");
            pd.setCancelable(false);
            pd.show();
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
                            Toast.makeText(MainActivity.this, resultStr.toString(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Nothing scanned!", Toast.LENGTH_SHORT).show();
                    }

                    // enable button again
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mScanAssetBtn.setEnabled(true);
                            pd.dismiss();
                        }
                    });
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
