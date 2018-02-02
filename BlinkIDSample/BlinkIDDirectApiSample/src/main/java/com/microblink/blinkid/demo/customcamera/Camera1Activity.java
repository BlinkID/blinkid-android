package com.microblink.blinkid.demo.customcamera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.microblink.activity.BaseScanActivity;
import com.microblink.blinkid.demo.R;
import com.microblink.directApi.DirectApiErrorListener;
import com.microblink.directApi.Recognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.util.Log;
import com.microblink.view.recognition.ScanResultListener;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("deprecation")
public class Camera1Activity extends Activity implements ScanResultListener, SurfaceHolder.Callback, Camera.PreviewCallback {

    private SurfaceView mSurfaceView;
    private Camera mCamera;
    private boolean mHaveSurfaceView = false;
    private byte[] mPixelBuffer;
    private int mFrameWidth;
    private int mFrameHeight;

    /** Recognizer instance */
    private Recognizer mRecognizer;
    /** Recognition settings instance. */
    private RecognitionSettings mSettings;
    private String mLicenseKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera1);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mSettings = extras.getParcelable(BaseScanActivity.EXTRAS_RECOGNITION_SETTINGS);
            mLicenseKey = extras.getString(BaseScanActivity.EXTRAS_LICENSE_KEY);
        }

        // setup camera view
        mSurfaceView = (SurfaceView) findViewById(R.id.camera1SurfaceView);
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
                Toast.makeText(Camera1Activity.this, "There was an error in Recognizer: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mSurfaceView.getHolder().addCallback(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mHaveSurfaceView) {
            startCamera();
        }

    }

    private void startCamera() {
        try {
            mCamera = Camera.open();
            Camera.Parameters params = mCamera.getParameters();
            List<String> supportedFocusModes = params.getSupportedFocusModes();
            if (supportedFocusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
                params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            } else {
                params.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            }

            List<Camera.Size> sizes = params.getSupportedPreviewSizes();
            Camera.Size bestSize = null;
            int bestDiff = Integer.MAX_VALUE;
            for (Camera.Size size : sizes) {
                int diff = size.width * size.height - 1920 * 1080;
                if (Math.abs(diff) < Math.abs(bestDiff)) {
                    bestDiff = diff;
                    bestSize = size;
                }
            }
            params.setPreviewFormat(ImageFormat.NV21);
            params.setPreviewSize(bestSize.width, bestSize.height);
            mFrameWidth = bestSize.width;
            mFrameHeight = bestSize.height;

            mCamera.setParameters(params);

            mPixelBuffer = new byte[bestSize.width * bestSize.height * ImageFormat.getBitsPerPixel(ImageFormat.NV21) / 8];
            mCamera.addCallbackBuffer(mPixelBuffer);
            mCamera.setPreviewCallbackWithBuffer(this);

            mCamera.setPreviewDisplay(mSurfaceView.getHolder());

            mCamera.startPreview();

        } catch (RuntimeException exc) {
            Log.e(this, exc, "Failed to open camera");
            finish();
        } catch (IOException e) {
            Log.e(this, e, "Failed to set preview display!");
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mRecognizer != null) {
            mRecognizer.terminate();
        }
        mSurfaceView.getHolder().removeCallback(this);
    }

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
            if (mCamera != null) {
                mCamera.addCallbackBuffer(mPixelBuffer);
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mHaveSurfaceView = true;
        startCamera();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mHaveSurfaceView = false;
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        if (mRecognizer.getCurrentState() == Recognizer.State.READY) {
            // create image
            Image img = ImageBuilder.buildImageFromCamera1NV21Frame(data, mFrameWidth, mFrameHeight, Orientation.ORIENTATION_LANDSCAPE_RIGHT, null);
            mRecognizer.recognizeImage(img, this);
        } else {
            // just ask for another frame
            camera.addCallbackBuffer(data);
        }
    }
}
