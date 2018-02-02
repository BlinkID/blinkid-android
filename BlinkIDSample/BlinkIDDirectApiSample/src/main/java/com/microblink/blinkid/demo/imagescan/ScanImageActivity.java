package com.microblink.blinkid.demo.imagescan;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.microblink.activity.BaseScanActivity;
import com.microblink.blinkid.demo.R;
import com.microblink.directApi.DirectApiErrorListener;
import com.microblink.directApi.Recognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.view.recognition.ScanResultListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ScanImageActivity extends Activity {

    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    private static final String ASSETS_BITMAP_NAME = "croID.jpg";
    /** Request code for built-in camera activity. */
    public static final int CAMERA_REQUEST_CODE = 0x101;
    /** File that will hold the image taken from camera. */
    private String mCameraFile = Environment.getExternalStorageDirectory().getPath() + "/my-photo.jpg";
    /** Tag for logcat. */
    public static final String TAG = "BlinkIDDemo";

    private Button mScanButton;
    private Button mTakePhotoButton;

    /** Image view which shows current image that will be scanned. */
    private ImageView mImgView;

    /** Recognizer instance */
    private Recognizer mRecognizer = null;
    /** Recognition settings instance. */
    private RecognitionSettings mSettings;
    private String mLicenseKey;

    /** Current bitmap for recognition. */
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_image);

        mScanButton = (Button) findViewById(R.id.btnScan);
        mTakePhotoButton = (Button) findViewById(R.id.btnTakePhoto);
        mImgView = (ImageView) findViewById(R.id.imgImage);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mSettings = extras.getParcelable(BaseScanActivity.EXTRAS_RECOGNITION_SETTINGS);
            mLicenseKey = extras.getString(BaseScanActivity.EXTRAS_LICENSE_KEY);
        }

        // initial bitmap is loaded from assets
        AssetManager assets = getAssets();
        InputStream istr = null;
        try {
            istr = assets.open(ASSETS_BITMAP_NAME);
            // load inital bitmap from assets
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = BITMAP_CONFIG;
            mBitmap = BitmapFactory.decodeStream(istr, null, options);
        } catch (IOException e) {
            // handle exception
            Log.e(TAG, "Failed to load image from assets!");
            Toast.makeText(this, "Failed to load image from assets!", Toast.LENGTH_LONG).show();
            finish();
            return;
        } finally {
            try {
                istr.close();
            } catch (IOException ignorable) { }
        }

        // show loaded bitmap
        mImgView.setImageBitmap(mBitmap);
    }

    @Override
    protected void onStart() {
        super.onStart();

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
            mRecognizer.setLicenseKey(this, mLicenseKey);
        } catch (InvalidLicenceKeyException exc) {
            Toast.makeText(this, "License key check failed! Reason: " + exc.getMessage(), Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // initialize recognizer singleton
        mRecognizer.initialize(this, mSettings, new DirectApiErrorListener() {
            @Override
            public void onRecognizerError(Throwable t) {
                Log.e(TAG, "Failed to initialize recognizer.", t);
                Toast.makeText(ScanImageActivity.this, "Failed to initialize recognizer. Reason: "
                        + t.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    /**
     * Starts built-in camera intent for taking scan images.
     */
    private void startCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(mCameraFile)));
        startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
    }

    /**
     * Handler for button "Take Photo"
     */
    public void takePhotoHandler(View view) {
        startCamera();
    }

    /**
     * Handler for button "Scan"
     */
    public void scanButtonHandler(View view) {
        if (mBitmap != null) {
            // disable button
            mScanButton.setEnabled(false);
            // show progress dialog
            final ProgressDialog pd = new ProgressDialog(this);
            pd.setIndeterminate(true);
            pd.setMessage("Performing recognition");
            pd.setCancelable(false);
            pd.show();

            // recognize image
            mRecognizer.recognizeBitmap(mBitmap, Orientation.ORIENTATION_LANDSCAPE_RIGHT, new ScanResultListener() {
                @Override
                public void onScanningDone(RecognitionResults results) {
                    // check if results contain valid data
                    BaseRecognitionResult[] brrs = results.getRecognitionResults();
                    boolean haveSomething = false;
                    if (brrs != null) {
                        for (BaseRecognitionResult brr : brrs) {
                            if (!brr.isEmpty() && brr.isValid()) {
                                haveSomething = true;
                                break;
                            }
                        }
                    }

                    if (haveSomething) {
                        // return results
                        Intent intent = new Intent();
                        intent.putExtra(BaseScanActivity.EXTRAS_RECOGNITION_RESULTS, results);
                        setResult(BaseScanActivity.RESULT_OK, intent);
                        finish();
                    } else {
                        Toast.makeText(ScanImageActivity.this, "Nothing scanned!", Toast.LENGTH_SHORT).show();
                        // enable button again
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mScanButton.setEnabled(true);
                                pd.dismiss();
                            }
                        });
                    }
                }
            });
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mRecognizer != null) {
            // terminate the native library
            mRecognizer.terminate();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // obtain image that was saved to external storage by camera activity
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = BITMAP_CONFIG;
                    mBitmap = BitmapFactory.decodeFile(mCameraFile, options);
                    new File(mCameraFile).delete();
                    // show camera image
                    mImgView.setImageBitmap(mBitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }

}
