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

import com.microblink.activity.BaseScanActivity;
import com.microblink.blinkid.demo.customcamera.Camera1Activity;
import com.microblink.blinkid.demo.customcamera.camera2.Camera2Activity;
import com.microblink.blinkid.demo.imagescan.ScanImageActivity;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDRecognizer;

import java.util.ArrayList;
import java.util.List;


public class MenuActivity extends Activity {

    private static final int MY_REQUEST_CODE = 1337;
    private static final int PERMISSION_REQUEST_CODE = 0x123;

    /**
     * Recognition bundle instance, same recognition settings are used for all examples.
     */
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buildRecognizerBundle();

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

    private void buildRecognizerBundle() {
        MRTDRecognizer mrtdRecognizer = new MRTDRecognizer();
        mRecognizerBundle = new RecognizerBundle(mrtdRecognizer);
    }

    /**
     * Handler for "Scan Image" button
     */
    public void onScanImageClick(View v) {
        Intent intent = new Intent(this, ScanImageActivity.class);
        // send settings over intent to scan activity
        mRecognizerBundle.saveToIntent(intent);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    /**
     * Handler for "Camera 1 Activity" and "Camera 2 Activity" buttons
     */
    public void onCameraScanClick(View view) {
        Class<?> targetActivity;
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
        // send settings over intent to scan activity
        mRecognizerBundle.saveToIntent(intent);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_REQUEST_CODE && resultCode == BaseScanActivity.RESULT_OK) {
            Recognizer recognizer = mRecognizerBundle.getRecognizers()[0];
            Entity.Result result = recognizer.getResult();
            if (result.isEmpty() || !(result instanceof MRTDRecognizer.Result)) {
                Toast.makeText(this, "Nothing scanned!", Toast.LENGTH_SHORT).show();
                return;
            }

            MRTDRecognizer.Result mrtdResult = (MRTDRecognizer.Result) result;
            String scanResults =
                    "First name: " + mrtdResult.getMRZResult().getSecondaryId() +
                    "\nLast name: " + mrtdResult.getMRZResult().getPrimaryId();

            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Scan result")
                    .setMessage(scanResults)
                    .setCancelable(false)
                    .setPositiveButton("OK", null)
                    .create();
            dialog.show();
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
