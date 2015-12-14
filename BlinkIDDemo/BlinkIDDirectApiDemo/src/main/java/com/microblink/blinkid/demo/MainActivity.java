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

import com.microblink.directApi.DirectApiErrorListener;
import com.microblink.directApi.Recognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognitionResult;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognizerSettings;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.view.recognition.ScanResultListener;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity {

    // obtain your licence key at http://microblink.com/login or
    // contact us at http://help.microblink.com
    private static final String LICENSE = "UF57DWJN-MCIEASQR-3FUVQU2V-WQ2YBMT4-SH4UTH2I-Z6MDB6FO-36NHEV7P-CZYI7I5N";

    private static final String TAG = "DirectApiDemo";

    /** Recognizer instance. */
    private Recognizer mRecognizer = null;
    /** Button which starts the recognition. */
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

        // get the recognizer instance
        try {
            mRecognizer = Recognizer.getSingletonInstance();
        } catch (FeatureNotSupportedException e) {
            Toast.makeText(this, "Feature not supported! Reason: " + e.getReason().getDescription(), Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // In order for scanning to work, you must enter a valid licence key. Without licence key,
        // scanning will not work. Licence key is bound the the package name of your app, so when
        // obtaining your licence key from Microblink make sure you give us the correct package name
        // of your app. You can obtain your licence key at http://microblink.com/login or contact us
        // at http://help.microblink.com.
        // Licence key also defines which recognizers are enabled and which are not. Since the licence
        // key validation is performed on image processing thread in native code, all enabled recognizers
        // that are disallowed by licence key will be turned off without any error and information
        // about turning them off will be logged to ADB logcat.
        try {
            mRecognizer.setLicenseKey(this, LICENSE);
        } catch (InvalidLicenceKeyException e) {
            Log.e(TAG, "Failed to set licence key!");
            Toast.makeText(this, "Failed to set licence key!", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // prepare recognition settings
        RecognitionSettings settings = new RecognitionSettings();
        // set recognizer settings array that is used to configure recognition
        // MRTDRecognizer will be used in the recognition process
        settings.setRecognizerSettingsArray(new RecognizerSettings[] {new MRTDRecognizerSettings()});

        // initialize recognizer singleton
        mRecognizer.initialize(this, settings, new DirectApiErrorListener() {
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
            // disable button
            mScanAssetBtn.setEnabled(false);
            // show progress dialog
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setIndeterminate(true);
            pd.setMessage("Performing recognition");
            pd.setCancelable(false);
            pd.show();
            // recognize image
            mRecognizer.recognizeBitmap(bitmap, Orientation.ORIENTATION_LANDSCAPE_RIGHT, new ScanResultListener() {
                @Override
                public void onScanningDone(RecognitionResults results) {
                    // get results array
                    BaseRecognitionResult[] dataArray = results.getRecognitionResults();
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
        // terminate the native library and free unnecessary resources
        mRecognizer.terminate();
        // for further use, recognizer must be initialized again
        mRecognizer = null;
    }
}
