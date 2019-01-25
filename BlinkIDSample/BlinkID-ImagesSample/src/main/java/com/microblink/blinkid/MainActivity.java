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
import com.microblink.entities.recognizers.HighResImagesBundle;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.image.Image;
import com.microblink.image.highres.HighResImageWrapper;
import com.microblink.result.ResultActivity;
import com.microblink.uisettings.ActivityRunner;
import com.microblink.uisettings.DocumentUISettings;

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

        // create MRTD (Machine Readable Travel Document) recognizer
        MrtdRecognizer mrtdRecognizer = new MrtdRecognizer();
        // set to true to obtain images containing full document
        mrtdRecognizer.setReturnFullDocumentImage(true);
        // if you want to obtain dewarped(cropped) images of MRZ zone, enable this
        mrtdRecognizer.setReturnMrzImage(true);

        // other recognizers might also support returning face and signature images

        // wrap recognizer in SuccessFrameGrabberRecognizer to obtain successful frames (full last frame on which scan has succeeded)
        SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = new SuccessFrameGrabberRecognizer(mrtdRecognizer);
        recognizerBundle = new RecognizerBundle(successFrameGrabberRecognizer);
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
        DocumentUISettings documentUISettings = new DocumentUISettings(recognizerBundle);
        //enable capturing success frame in full camera resolution
        documentUISettings.enableHighResSuccessFrameCapture(true);
        ActivityRunner.startActivityForResult(this, SCAN_ACTIVITY_REQ_CODE, documentUISettings);
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
            recognizerBundle.loadFromIntent(data);

            storeHighResImage(data);

            // get images from recognizers and store them
            Recognizer firstRecognizer = recognizerBundle.getRecognizers()[0];
            SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = (SuccessFrameGrabberRecognizer) firstRecognizer;
            storeImage("successImage", successFrameGrabberRecognizer.getResult().getSuccessFrame());

            //get wrapped recognizer
            MrtdRecognizer mrtdRecognizer = (MrtdRecognizer) successFrameGrabberRecognizer.getSlaveRecognizer();
            storeImage("fullDocumentImage", mrtdRecognizer.getResult().getFullDocumentImage());
            storeImage("mrzImage", mrtdRecognizer.getResult().getMrzImage());

            Intent resultScreenIntent = new Intent(this, ResultActivity.class);
            recognizerBundle.saveToIntent(resultScreenIntent);
            startActivity(resultScreenIntent);
        } else {
            // if BlinkID activity did not return result, user has probably
            // pressed Back button and cancelled scanning
            Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
        }
    }

    private void storeHighResImage(Intent resultIntent) {
        // load high res image from result intent
        HighResImagesBundle highResImagesBundle = new HighResImagesBundle(resultIntent);

        // if high res image capture is disabled, images list will be empty
        // otherwise, we'll get 1 image per scanned document side
        List<HighResImageWrapper> highResImageWrappers = highResImagesBundle.getImages();
        if (highResImageWrappers.isEmpty()) {
            return;
        }

        HighResImageWrapper highResImageWrapper = highResImageWrappers.get(0);

        String imagesFolderPath = createImagesFolder();
        String imagePath = imagesFolderPath + "/highRes.jpg";
        try {
            // optimal way to save high res image to file,
            // alternatively, you could get bitmap using highResImageWrapper.getImage().convertToBitmap()
            highResImageWrapper.saveToFile(new File(imagePath));
        } catch (IOException e) {
            Log.e(LOG_TAG, "Failed to save image " + e.toString());
        }

        // dispose image once you're done with it
        highResImageWrapper.dispose();
    }

    private void storeImage(String imageName, Image image) {
        // image filenames will be 'imageType - currentTimestamp.jpg'
        String output = createImagesFolder();
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

    @NonNull
    private String createImagesFolder() {
        // we will save images to 'myImages' folder on external storage
        String imagesDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myImages";
        File f = new File(imagesDirPath);
        if (!f.exists()) {
            f.mkdirs();
        }
        return imagesDirPath;
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

}
