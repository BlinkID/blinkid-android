package com.microblink.blinkid;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.blinkid.customcamera.Camera1Activity;
import com.microblink.blinkid.customcamera.camera2.Camera2Activity;
import com.microblink.blinkid.demo.R;
import com.microblink.blinkid.imagescan.CombinedScanImageActivity;
import com.microblink.blinkid.imagescan.ScanImageActivity;
import com.microblink.blinkid.entities.Entity;
import com.microblink.blinkid.entities.recognizers.Recognizer;
import com.microblink.blinkid.entities.recognizers.RecognizerBundle;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.blinkid.menu.BaseMenuActivity;
import com.microblink.blinkid.menu.MenuListItem;

import java.util.ArrayList;
import java.util.List;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MenuActivity extends BaseMenuActivity {

    private static final int MY_REQUEST_CODE = 1337;
    private static final int PERMISSION_REQUEST_CODE = 235;

    /**
     * Recognition bundle instance, same recognition settings are used for all examples.
     */
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildRecognizerBundle();

        // Request permissions if not granted, we need CAMERA permission and
        // WRITE_EXTERNAL_STORAGE permission because images that are taken by camera
        // will be stored on external storage and used in recognition process
        List<String> requiredPermissions = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requiredPermissions.add(Manifest.permission.CAMERA);
        }
        if (requiredPermissions.size() > 0) {
            String[] permArray = new String[requiredPermissions.size()];
            permArray = requiredPermissions.toArray(permArray);
            ActivityCompat.requestPermissions(this, permArray, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

        items.add(new MenuListItem("Scan image", new Runnable() {
            @Override
            public void run() {
                startScanActivityForResult(ScanImageActivity.class);
            }
        }));

        items.add(new MenuListItem("Scan with combined recognizer", new Runnable() {
            @Override
            public void run() {
                startScanActivityForResult(CombinedScanImageActivity.class);
            }
        }));

        items.add(new MenuListItem("Camera 1 activity", new Runnable() {
            @Override
            public void run() {
                startScanActivityForResult(Camera1Activity.class);
            }
        }));

        items.add(new MenuListItem("Camera 2 activity", new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= 21) {
                    startScanActivityForResult(Camera2Activity.class);
                } else {
                    Toast.makeText(MenuActivity.this, "Camera2 API requires Android 5.0 or newer. Camera1 direct API will be used", Toast.LENGTH_SHORT).show();
                    startScanActivityForResult(Camera1Activity.class);
                }
            }
        }));

        return items;
    }

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }


    private void buildRecognizerBundle() {
        MrtdRecognizer mrtdRecognizer = new MrtdRecognizer();
        mRecognizerBundle = new RecognizerBundle(mrtdRecognizer);
    }

    private void startScanActivityForResult(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        // send settings over intent to scan activity
        mRecognizerBundle.saveToIntent(intent);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            mRecognizerBundle.loadFromIntent(data);
            Recognizer recognizer = mRecognizerBundle.getRecognizers()[0];
            Entity.Result result = recognizer.getResult();
            if (!(result instanceof MrtdRecognizer.Result)) {
                Toast.makeText(this, "Nothing scanned!", Toast.LENGTH_SHORT).show();
                return;
            }

            MrzResult mrzResult = ((MrtdRecognizer.Result)result).getMrzResult();
            String scanResults =
                    "First name: " + mrzResult.getSecondaryId() +
                    "\nLast name: " + mrzResult.getPrimaryId();

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
