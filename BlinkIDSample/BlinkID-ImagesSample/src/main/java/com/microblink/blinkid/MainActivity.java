package com.microblink.blinkid;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.microblink.BaseMenuActivity;
import com.microblink.MenuListItem;
import com.microblink.activity.DocumentScanActivity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.image.Image;
import com.microblink.result.ResultActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// in this example MRTD documents will be scanned and during scan multiple document images will be stored on external storage
public class MainActivity extends BaseMenuActivity {

    private static final String LOG_TAG = "MainActivity";
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 123;
    private static final int SCAN_ACTIVITY_REQ_CODE = 234;
    private RecognizerBundle recognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

        items.add(new MenuListItem(getString(R.string.scanMRTD), new Runnable() {
            @Override
            public void run() {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    // request write permission
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORAGE);
                } else {
                    startScanning();
                }
            }
        }));
        return items;
    }

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

    private void startScanning() {
        // create MRTD (Machine Readable Travel Document) recognizer
        MrtdRecognizer mrtdRecognizer = new MrtdRecognizer();
        // set to true to obtain images containing full document
        mrtdRecognizer.setReturnFullDocumentImage(true);
        // if you want to obtain dewarped(cropped) images of MRZ zone, enable this
        mrtdRecognizer.setReturnMrzImage(true);

        // other recognizers might also support returning face and signature images

        // wrap recognizer in SuccessFrameGrabberRecognizer to obtain successful frames (full last frame on which scan has succeeded)
        SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = new SuccessFrameGrabberRecognizer(mrtdRecognizer);

        // use provided ScanCard activity to scan machine readable travel documents
        Intent intent = new Intent(this, DocumentScanActivity.class);
        recognizerBundle = new RecognizerBundle(successFrameGrabberRecognizer);
        recognizerBundle.saveToIntent(intent);
        startActivityForResult(intent, SCAN_ACTIVITY_REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // onActivityResult is called whenever we are returned from activity started
        // with startActivityForResult. We need to check request code to determine
        // that we have really returned from BlinkID activity.
        if (requestCode != SCAN_ACTIVITY_REQ_CODE) {
            return;
        }

        // make sure BlinkID activity returned result
        if (resultCode == DocumentScanActivity.RESULT_OK && data != null) {
            // get images from recognizers and store them
            Recognizer firstRecognizer = recognizerBundle.getRecognizers()[0];
            SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = (SuccessFrameGrabberRecognizer) firstRecognizer;
            storeImage("successImage", successFrameGrabberRecognizer.getResult().getSuccessFrame());

            //get wrapped recognizer
            MrtdRecognizer mrtdRecognizer = (MrtdRecognizer) successFrameGrabberRecognizer.getSlaveRecognizer();
            storeImage("fullDocumentImage", mrtdRecognizer.getResult().getFullDocumentImage());
            storeImage("mrzImage", mrtdRecognizer.getResult().getMrzImage());

            // set intent's component to ResultActivity and pass its contents
            // to ResultActivity. ResultActivity will show how to extract data from result.
            data.setComponent(new ComponentName(this, ResultActivity.class));
            startActivity(data);
        } else {
            // if BlinkID activity did not return result, user has probably
            // pressed Back button and cancelled scanning
            Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
        }
    }

    private void storeImage(String imageName, Image image) {
        // we will save images to 'myImages' folder on external storage
        // image filenames will be 'imageType - currentTimestamp.jpg'
        String output = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myImages";
        File f = new File(output);
        if (!f.exists()) {
            f.mkdirs();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateString = dateFormat.format(new Date());
        String filename = null;
        switch (image.getImageFormat()) {
            case ALPHA_8: {
                filename = output + "/alpha_8 - " + imageName + " - " + dateString + ".jpg";
                break;
            }
            case BGRA_8888: {
                filename = output + "/bgra - " + imageName + " - " + dateString + ".jpg";
                break;
            }
            case YUV_NV21: {
                filename = output + "/yuv - " + imageName + " - " + dateString + ".jpg";
                break;
            }
        }
        Bitmap bitmap = image.convertToBitmap();
        if (bitmap == null) {
            Log.e(LOG_TAG, "Bitmap is null");
            return;
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            boolean success = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            if (!success) {
                Log.e(LOG_TAG, "Failed to compress bitmap!");
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ignored) {
                    } finally {
                        fos = null;
                    }
                    new File(filename).delete();
                }
            }
        } catch (FileNotFoundException e) {
            Log.e(LOG_TAG, "Failed to save image " + e.toString());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                }
            }
        }
        // after this line, image gets disposed. If you want to save it
        // for later, you need to clone it with image.clone()
    }

}
