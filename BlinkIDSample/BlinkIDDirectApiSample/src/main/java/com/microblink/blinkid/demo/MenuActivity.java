package com.microblink.blinkid.demo;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.microblink.Config;
import com.microblink.activity.BaseScanActivity;
import com.microblink.blinkid.demo.customcamera.Camera1Activity;
import com.microblink.blinkid.demo.customcamera.camera2.Camera2Activity;
import com.microblink.blinkid.demo.imagescan.ScanImageActivity;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognitionResult;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognizerSettings;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;

import java.util.ArrayList;
import java.util.List;


public class MenuActivity extends Activity {

    private static final int MY_REQUEST_CODE = 1337;
    private static final String TAG = "DirectApiDemo";

    private static final int PERMISSION_REQUEST_CODE = 0x123;

    /**
     * Recognition settings instance, same recognition settings are used for all examples.
     */
    private RecognitionSettings mRecognitionSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buildRecognitionSettings();

        // Request permissions if not granted, we need CAMERA permission and
        // WRITE_EXTERNAL_STORAGE permission because images that are taken by camera
        // will be stored on external storage and used in recognition process
        List<String> requiredPermissions = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requiredPermissions.add(Manifest.permission.CAMERA);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requiredPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (requiredPermissions.size() > 0) {
            String[] permArray = new String[requiredPermissions.size()];
            permArray = requiredPermissions.toArray(permArray);
            ActivityCompat.requestPermissions(this, permArray, PERMISSION_REQUEST_CODE);
        }
    }

    private void buildRecognitionSettings() {
        // prepare recognition settings
        mRecognitionSettings = new RecognitionSettings();
        // set recognizer settings array that is used to configure recognition
        // MRTDRecognizer will be used in the recognition process
        mRecognitionSettings.setRecognizerSettingsArray(new RecognizerSettings[]{new MRTDRecognizerSettings()});
    }

    /**
     * Handler for "Scan Image" button
     */
    public void onScanImageClick(View v) {
        Intent intent = new Intent(this, ScanImageActivity.class);
        // send license key over intent to scan activity
        intent.putExtra(BaseScanActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);
        // send settings over intent to scan activity
        intent.putExtra(BaseScanActivity.EXTRAS_RECOGNITION_SETTINGS, mRecognitionSettings);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    /**
     * Handler for "Camera 1 Activity" and "Camera 2 Activity" buttons
     */
    public void onCameraScanClick(View view) {
        Class<?> targetActivity = null;
        switch (view.getId()) {
            case R.id.btn_camera1:
                targetActivity = Camera1Activity.class;
                break;
            case R.id.btn_camera2:
                if (Build.VERSION.SDK_INT >= 21) {
                    targetActivity = Camera2Activity.class;
                } else {
                    Toast.makeText(this, "Camera2 API requires Android 5.0 or newer. Camera1 direct API will be used", Toast.LENGTH_SHORT).show();
                    targetActivity = Camera1Activity.class;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown button clicked!");
        }

        Intent intent = new Intent(this, targetActivity);
        // send license key over intent to scan activity
        intent.putExtra(BaseScanActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);
        // send settings over intent to scan activity
        intent.putExtra(BaseScanActivity.EXTRAS_RECOGNITION_SETTINGS, mRecognitionSettings);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    public void showResults(RecognitionResults results) {
        // Get scan results array. If scan was successful, array will contain at least one element.
        // Multiple element may be in array if multiple scan results from single image were allowed in settings.
        BaseRecognitionResult[] resultArray = results.getRecognitionResults();
        if (resultArray != null && resultArray.length > 0) {
            if (resultArray[0] instanceof MRTDRecognitionResult) {
                MRTDRecognitionResult result = (MRTDRecognitionResult) resultArray[0];
                StringBuilder sb = new StringBuilder();
                sb.append('\n');
                sb.append("First name: ");
                sb.append(result.getSecondaryId());
                sb.append('\n');
                sb.append("Last name: ");
                sb.append(result.getPrimaryId());

                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Scan result")
                        .setMessage(sb.toString())
                        .setCancelable(false)
                        .setPositiveButton("OK", null)
                        .create();
                dialog.show();
            }
        } else {
            Toast.makeText(MenuActivity.this, "Nothing scanned!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_REQUEST_CODE && resultCode == BaseScanActivity.RESULT_OK) {
            // First, obtain recognition result
            RecognitionResults results = data.getParcelableExtra(BaseScanActivity.EXTRAS_RECOGNITION_RESULTS);
            showResults(results);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                new AlertDialog.Builder(this)
                        .setTitle("Exiting")
                        .setMessage("Exiting app, permission(s) not granted.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
                return;
            }
        }
    }

}
