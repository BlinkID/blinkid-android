package com.microblink.blinkid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.microblink.entities.parsers.raw.RawParser;
import com.microblink.entities.processors.parserGroup.ParserGroupProcessor;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.entities.recognizers.blinkinput.BlinkInputRecognizer;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.FailedDetectionCallback;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.detection.points.PointsDetectionCallback;
import com.microblink.metadata.ocr.DisplayableOcrResult;
import com.microblink.metadata.ocr.OcrCallback;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.ocrResult.OcrResultCharsView;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.view.viewfinder.points.PointSetView;

public class FullScreenOcrActivity extends Activity implements CameraEventsListener, ScanResultListener {

    /** RecognizerView is the built-in view that controls camera and recognition */
    private RecognizerRunnerView mRecognizerView;
    /**  OcrResultCharsView is built-in view that can display OCR result on top of camera */
    private OcrResultCharsView mOcrResultView;
    /**  PoinSetView is built-in view that can display points of interest on top of camera */
    private PointSetView mPointSetView;
    /** CameraPermissionManager is provided helper class that can be used to obtain the permission to use camera.
     * It is used on Android 6.0 (API level 23) or newer.
     */
    private CameraPermissionManager mCameraPermissionManager;

    private RecognizerBundle mRecognizerBundle;
    private RawParser mRawParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_ocr);
        // obtain reference to RecognizerView
        mRecognizerView = findViewById(R.id.recognizerView);

        // set log level to information because ocr results will be passed to Log (information level)
        Log.setLogLevel(Log.LogLevel.LOG_INFORMATION);

        // initialize BlinkInput recognizer with only raw parser
        mRawParser = new RawParser();
        BlinkInputRecognizer blinkInputRecognizer = new BlinkInputRecognizer(new ParserGroupProcessor(mRawParser));

        // initialize barcode recognizer and set it to scan Code39 and Code128 barcodes
        BarcodeRecognizer barcodeRecognizer = new BarcodeRecognizer();
        barcodeRecognizer.setScanCode128(true);
        barcodeRecognizer.setScanCode39(true);

        // BlinkInput and BarcodeRecognizer will be used in the recognition process
        mRecognizerBundle = new RecognizerBundle(blinkInputRecognizer, barcodeRecognizer);
        mRecognizerView.setRecognizerBundle(mRecognizerBundle);

        // we want each frame to be scanned for both OCR and barcodes so we must
        // allow multiple scan results on single image.
        // If this is not allowed (default), the first recognizer that finds its object
        // of interest stops the recognition chain (for example in that case if barcode is found
        // OCR will not be performed - we do not want this, so we allow multiple scan results
        // on single image).
        mRecognizerBundle.setAllowMultipleScanResultsOnSingleImage(true);

        // use all available view area for displaying camera, possibly cropping the camera frame
        mRecognizerView.setAspectMode(CameraAspectMode.ASPECT_FILL);

        // set 720p resolution (if available) - this will work much faster than default 1080p resolution
        mRecognizerView.setVideoResolutionPreset(VideoResolutionPreset.VIDEO_RESOLUTION_720p);

        setupMetadataCallbacks();

        // camera events listener receives camera events, like when camera preview has started, stopped
        // or if camera error happened
        mRecognizerView.setCameraEventsListener(this);
        // scan result listener receives scan result once it becomes available
        mRecognizerView.setScanResultListener(this);

        // orientation allowed listener is asked whether given orientation
        // is allowed in UI. We keep activity always in portrait, but allow
        // scanning in all orientations.
        mRecognizerView.setOrientationAllowedListener(new OrientationAllowedListener() {
            @Override
            public boolean isOrientationAllowed(Orientation orientation) {
                return true;
            }
        });

        // instantiate the camera permission manager
        mCameraPermissionManager = new CameraPermissionManager(this);
        // get the built-in overlay that should be displayed when camera permission is not given
        View v = mCameraPermissionManager.getAskPermissionOverlay();
        if (v != null) {
            // add it to the current layout that contains the recognizer view
            ViewGroup vg = findViewById(R.id.full_screen_root);
            vg.addView(v);
        }

        // create scanner (make sure scan settings and listeners were set prior calling create)
        mRecognizerView.create();

        // create OCR result view
        mOcrResultView = new OcrResultCharsView(this, null, mRecognizerView.getHostScreenOrientation());

        // OCR result view will be added as child of recognizer view. This makes sure that if
        // recognizer view letter-boxes the camera preview (ASPECT_FIT camera mode), the OCR
        // result view will be laid out exactly above camera preview
        // Note that we can add child views to RecognizerView only after we called create on it.
        // The boolean parameter defines whether added view will be rotated with device. Allowed
        // orientations are defined with OrientationAllowedListener.
        mRecognizerView.addChildView(mOcrResultView, false);

        // we do the same with PointSetView
        mPointSetView = new PointSetView(this, null, mRecognizerView.getHostScreenOrientation());
        mRecognizerView.addChildView(mPointSetView, false);

    }

    private void setupMetadataCallbacks() {
        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        metadataCallbacks.setFailedDetectionCallback(new FailedDetectionCallback() {
            @Override
            public void onDetectionFailed() {
                mPointSetView.clearDisplayedContent();
            }
        });
        metadataCallbacks.setPointsDetectionCallback(new PointsDetectionCallback() {
            @Override
            public void onPointsDetection(@NonNull DisplayablePointsDetection displayablePointsDetection) {
                mPointSetView.setDisplayablePointsDetection(displayablePointsDetection);

            }
        });
        metadataCallbacks.setOcrCallback(new OcrCallback() {
            @Override
            public void onOcrResult(@NonNull DisplayableOcrResult displayableOcrResult) {
                mOcrResultView.setOcrResult(displayableOcrResult);
            }
        });
        mRecognizerView.setMetadataCallbacks(metadataCallbacks);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // all activity lifecycle events must be passed on to RecognizerView
        if(mRecognizerView != null) {
            mRecognizerView.start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // all activity lifecycle events must be passed on to RecognizerView
        if(mRecognizerView != null) {
            mRecognizerView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // all activity lifecycle events must be passed on to RecognizerView
        if(mRecognizerView != null) {
            mRecognizerView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // all activity lifecycle events must be passed on to RecognizerView
        if(mRecognizerView != null) {
            mRecognizerView.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // all activity lifecycle events must be passed on to RecognizerView
        if(mRecognizerView != null) {
            mRecognizerView.destroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // change configuration of scanner's internal views
        if(mRecognizerView != null) {
            mRecognizerView.changeConfiguration(newConfig);
        }
    }

    @Override
    public void onCameraPreviewStarted() {
        // called immediately after camera preview has been started. This is useful
        // if you display splash screen in your app while loading camera. In this method
        // you should then remove the splash screen.
    }

    @Override
    public void onCameraPreviewStopped() {
        // called immediately after camera preview has been stopped. This is useful
        // if you want to release some resources that are required only while camera preview
        // is active.
    }

    @Override
    public void onError(Throwable ex) {
        // This method will be called when opening of camera resulted in exception or
        // recognition process encountered an error.
        // The error details will be given in exc parameter.
        Log.e(this, ex, "Error");
        Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onAutofocusFailed() {
        // called when camera cannot obtain a sharp focus on text, even after several retries.
        // You should inform the user to attempt scanning under better light conditions.
    }

    @Override
    public void onAutofocusStarted(Rect[] focusAreas) {
        // called when camera starts focusing. The given array of rectangles are positions on
        // RecognizerView's camera preview that camera uses for focus measurements. If you want,
        // you can display those positions.
    }

    @Override
    public void onAutofocusStopped(Rect[] focusAreas) {
        // called when camera stops focusing. The given array of rectangles are positions on
        // RecognizerView's camera preview that camera uses for focus measurements. If you want,
        // you can display those positions.
    }

    @Override
    @TargetApi(23)
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // on API level 23, request permission result should be passed to camera permission manager
        mCameraPermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    @TargetApi(23)
    public void onCameraPermissionDenied() {
        // this method is called on Android 6.0 and newer if camera permission was not given
        // by user

        // ask user to give a camera permission. Provided manager asks for
        // permission only if it has not been already granted.
        // on API level < 23, this method does nothing
        mCameraPermissionManager.askForCameraPermission();
    }

    @Override
    public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
        for (Recognizer recognizer : mRecognizerBundle.getRecognizers()) {
            if (recognizer instanceof BarcodeRecognizer) {
                BarcodeRecognizer barcodeRecognizer = (BarcodeRecognizer) recognizer;
                BarcodeRecognizer.Result barcodeResult = barcodeRecognizer.getResult();
                String resultString = barcodeResult.getBarcodeFormat().name() +
                        ": " +
                        barcodeResult.getStringData();
                Toast.makeText(this, resultString, Toast.LENGTH_SHORT).show();
            }
        }

        // obtain parse result from raw parser
        String rawParsed = mRawParser.getResult().getRawText();
        Log.i("Parsed", rawParsed);
    }


}
