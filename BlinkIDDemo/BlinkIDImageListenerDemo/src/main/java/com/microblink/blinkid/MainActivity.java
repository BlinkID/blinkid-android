package com.microblink.blinkid;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.microblink.Config;
import com.microblink.activity.ScanActivity;
import com.microblink.activity.ScanCard;
import com.microblink.libresult.ResultActivity;
import com.microblink.metadata.MetadataSettings;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognizerSettings;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 123;
    private static final int SCAN_ACTIVITY_REQ_CODE = 234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onScanClick(View view) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // request write permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_EXTERNAL_STORAGE);

        } else {
            startScanning();
        }

    }

    private void startScanning() {
        // in this example MRTD documents will be scanned and during scan multiple document
        // images will be stored in external storage

        // use provided ScanCard activity to scan machine readable travel documents
        Intent intent = new Intent(this, ScanCard.class);

        // prepare recognition settings
        RecognitionSettings settings = new RecognitionSettings();

        // create settings for MRTD (Machine Readable Travel Document) recognizer
        MRTDRecognizerSettings mrtdSett = new MRTDRecognizerSettings();
        // set to true to obtain images containing full document
        mrtdSett.setShowFullDocument(true);
        // if you want to obtain dewarped(cropped) images of MRZ zone, enable this
//        mrtdSett.setShowMRZ(true);

        // set array of recognizers that will be used
        settings.setRecognizerSettingsArray(new RecognizerSettings[]{mrtdSett});

        MetadataSettings.ImageMetadataSettings ims = new MetadataSettings.ImageMetadataSettings();
        // enable obtaining of dewarped(cropped) images
        ims.setDewarpedImageEnabled(true);
        // obtain successful frames (full last frame on which scan has succeeded)
        // if you want to obtain only dewarped(cropped) images do not enable successful scan frames
        ims.setSuccessfulScanFrameEnabled(true);


        // In order for scanning to work, you must enter a valid licence key. Without licence key,
        // scanning will not work. Licence key is bound the the package name of your app, so when
        // obtaining your licence key from Microblink make sure you give us the correct package name
        // of your app. You can obtain your licence key at http://microblink.com/login or contact us
        // at http://help.microblink.com.
        // Licence key also defines which recognizers are enabled and which are not. Since the licence
        // key validation is performed on image processing thread in native code, all enabled recognizers
        // that are disallowed by licence key will be turned off without any error and information
        // about turning them off will be logged to ADB logcat.
        intent.putExtra(ScanCard.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);
        intent.putExtra(ScanCard.EXTRAS_RECOGNITION_SETTINGS, settings);
        // pass implementation of image listener that will obtain document images
        intent.putExtra(ScanCard.EXTRAS_IMAGE_LISTENER, new MyImageListener());
        // pass image metadata settings that specifies which images will be obtained
        intent.putExtra(ScanCard.EXTRAS_IMAGE_METADATA_SETTINGS, ims);

        startActivityForResult(intent, SCAN_ACTIVITY_REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_WRITE_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
                    startScanning();
                } else {
                    // permission denied
                    Toast.makeText(this, "Write external storage permission is required!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // onActivityResult is called whenever we are returned from activity started
        // with startActivityForResult. We need to check request code to determine
        // that we have really returned from BlinkID activity.
        if (requestCode == SCAN_ACTIVITY_REQ_CODE) {

            // make sure BlinkID activity returned result
            if (resultCode == ScanActivity.RESULT_OK && data != null) {
                // set intent's component to ResultActivity and pass its contents
                // to ResultActivity. ResultActivity will show how to extract
                // data from result.
                data.setComponent(new ComponentName(this, ResultActivity.class));
                startActivity(data);
            } else {
                // if BlinkID activity did not return result, user has probably
                // pressed Back button and cancelled scanning
                Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
