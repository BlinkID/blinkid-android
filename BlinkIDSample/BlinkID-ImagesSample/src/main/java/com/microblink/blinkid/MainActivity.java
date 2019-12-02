package com.microblink.blinkid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.microblink.BaseMenuActivity;
import com.microblink.MenuListItem;
import com.microblink.activity.DocumentScanActivity;
import com.microblink.entities.recognizers.HighResImagesBundle;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.image.Image;
import com.microblink.image.highres.HighResImageWrapper;
import com.microblink.result.ResultActivity;
import com.microblink.uisettings.ActivityRunner;
import com.microblink.uisettings.BlinkIdUISettings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

// in this example documents will be scanned and during scan multiple document images will be stored on external storage
public class MainActivity extends BaseMenuActivity {

    private static final String LOG_TAG = "MainActivity";
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 123;
    private static final int SCAN_ACTIVITY_REQ_CODE = 234;
    private RecognizerBundle recognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create recognizer
        BlinkIdCombinedRecognizer blinkIdRecognizer = new BlinkIdCombinedRecognizer();
        // set to true to obtain images containing full document
        blinkIdRecognizer.setReturnFullDocumentImage(true);

        // wrap recognizer in SuccessFrameGrabberRecognizer to obtain successful frames (full last frame on which scan has succeeded)
        SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = new SuccessFrameGrabberRecognizer(blinkIdRecognizer);
        recognizerBundle = new RecognizerBundle(successFrameGrabberRecognizer);
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        return Collections.singletonList(
                new MenuListItem("Scan document", new Runnable() {
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
                })
        );
    }

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

    private void startScanning() {
        BlinkIdUISettings uiSettings = new BlinkIdUISettings(recognizerBundle);
        //enable capturing success frame in full camera resolution
        uiSettings.enableHighResSuccessFrameCapture(true);
        ActivityRunner.startActivityForResult(this, SCAN_ACTIVITY_REQ_CODE, uiSettings);
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

        if (resultCode != DocumentScanActivity.RESULT_OK || data == null) {
            // if BlinkID activity did not return result, user has probably
            // pressed Back button and cancelled scanning
            Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
            return;
        }

        recognizerBundle.loadFromIntent(data);

        Recognizer firstRecognizer = recognizerBundle.getRecognizers()[0];
        SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = (SuccessFrameGrabberRecognizer) firstRecognizer;
        //get wrapped recognizer
        BlinkIdCombinedRecognizer blinkIdRecognizer = (BlinkIdCombinedRecognizer) successFrameGrabberRecognizer.getSlaveRecognizer();

        storeImage("successImage", successFrameGrabberRecognizer.getResult().getSuccessFrame());
        storeImage("fullDocumentImageFront", blinkIdRecognizer.getResult().getFullDocumentFrontImage());
        storeImage("fullDocumentImageBack", blinkIdRecognizer.getResult().getFullDocumentBackImage());
        storeHighResImage(data);

        Intent resultScreenIntent = new Intent(this, ResultActivity.class);
        recognizerBundle.saveToIntent(resultScreenIntent);
        startActivity(resultScreenIntent);
    }

    private void storeHighResImage(Intent resultIntent) {
        // load high res image from result intent
        HighResImagesBundle highResImagesBundle = new HighResImagesBundle(resultIntent);

        // if high res image capture is disabled, images list will be empty
        // otherwise, we'll get 1 image per scanned document side
        List<HighResImageWrapper> highResImageWrappers = highResImagesBundle.getImages();
        for (int i = 0; i < highResImageWrappers.size(); i++) {
            HighResImageWrapper highResImageWrapper = highResImageWrappers.get(i);
            String imagesFolderPath = createImagesFolder();
            String imagePath = imagesFolderPath + "/highRes" + i + ".jpg";
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
    }

    private void storeImage(String imageName, @Nullable Image image) {
        if (image == null) {
            return;
        }

        String output = createImagesFolder();
        String filename = output + "/" + imageName + ".jpg";
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
                try {
                    fos.close();
                } catch (IOException ignored) {
                } finally {
                    fos = null;
                }
                new File(filename).delete();
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
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
