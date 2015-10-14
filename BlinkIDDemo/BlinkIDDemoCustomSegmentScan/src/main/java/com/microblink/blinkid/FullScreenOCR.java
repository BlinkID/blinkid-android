package com.microblink.blinkid;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.geometry.Point;
import com.microblink.geometry.PointSet;
import com.microblink.geometry.Quadrilateral;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.barcode.bardecoder.BarDecoderRecognizerSettings;
import com.microblink.recognizers.barcode.bardecoder.BarDecoderScanResult;
import com.microblink.recognizers.ocr.blinkocr.BlinkOCRRecognitionResult;
import com.microblink.recognizers.ocr.blinkocr.BlinkOCRRecognizerSettings;
import com.microblink.recognizers.ocr.blinkocr.parser.generic.RawParserSettings;
import com.microblink.recognizers.settings.GenericRecognizerSettings;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.results.ocr.OcrResult;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.NotSupportedReason;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.ocrResult.OcrResultCharsView;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.OcrRecognizerViewEventListener;
import com.microblink.view.recognition.RecognitionType;
import com.microblink.view.recognition.RecognizerView;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.view.viewfinder.PointSetView;

import java.util.List;

public class FullScreenOCR extends Activity implements OcrRecognizerViewEventListener, CameraEventsListener, ScanResultListener {

    // RecognizerView is the view that controls camera and recognition
    private RecognizerView mRecognizerView;
    // OcrResultCharsView is builtin view that can display OCR result on top of camera
    private OcrResultCharsView mOcrResultView;
    // PoinSetView is builtin view that can display points of interest on top of camera
    private PointSetView mPointSetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_ocr);

        mRecognizerView = (RecognizerView) findViewById(R.id.recognizerView);

        // initialize BlinkOCR recognizer with only raw parser
        BlinkOCRRecognizerSettings ocrSett = new BlinkOCRRecognizerSettings();
        RawParserSettings rawSett = new RawParserSettings();

        ocrSett.addParser("Raw", rawSett);

        // initialize 1D barcode recognizer and set it to scan Code39 and Code128 barcodes
        BarDecoderRecognizerSettings barSett = new BarDecoderRecognizerSettings();
        barSett.setScanCode128(true);
        barSett.setScanCode39(true);

        mRecognizerView.setRecognitionSettings(new RecognizerSettings[]{ocrSett, barSett});

        // we want each frame to be scanned for both OCR and barcodes so we must
        // allow multiple scan results on single image.
        // If this is not allowed (default), the first recognizer that finds its object
        // of interest stops the recognition chain (for example in that case if barcode is found
        // OCR will not be performed - we do not want this, so we allow multiple scan results
        // on single image).
        GenericRecognizerSettings genSett =  new GenericRecognizerSettings();
        genSett.setAllowMultipleScanResultsOnSingleImage(true);

        mRecognizerView.setGenericRecognizerSettings(genSett);

        try {
            mRecognizerView.setLicenseKey("UF57DWJN-MCIEASQR-3FUVQU2V-WQ2YBMT4-SH4UTH2I-Z6MDB6FO-36NHEV7P-CZYI7I5N");
        } catch (InvalidLicenceKeyException e) {
            e.printStackTrace();
            Toast.makeText(this, "Invalid licence key", Toast.LENGTH_SHORT).show();
            finish();
            mRecognizerView = null;
            return;
        }

        // use all available view area for displaying camera, possibly cropping the camera frame
        mRecognizerView.setAspectMode(CameraAspectMode.ASPECT_FILL);
        // OcrRecognizerViewEventListener is subclass of RecognizerViewEventsListener and besides
        // being able to receive detection location it can also receive OCR results prepared for
        // drawing on screen
        mRecognizerView.setRecognizerViewEventListener(this);
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

        // all activity lifecycle events must be passed on to RecognizerView
        mRecognizerView.create();

        // create OCR result view
        mOcrResultView = new OcrResultCharsView(this, null, mRecognizerView.getHostScreenOrientation());

        // OCR result view will be added as child of recognizer view. This makes sure that if
        // recognizer view letter-boxes the camera preview (ASPECT_FIT camera mode), the OCR
        // result view will be layed out exactly above camera preview
        // Note that we can add child views to RecognizerView only after we called create on it.
        // The boolean parameter defines whether added view will be rotated with device. Allowed
        // orientations are defined with OrientationAllowedListener.
        mRecognizerView.addChildView(mOcrResultView, false);

        // we do the same with PointSetView
        mPointSetView = new PointSetView(this, null);
        mRecognizerView.addChildView(mPointSetView, false);

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
        // all activity lifecycle events must be passed on to RecognizerView
        if(mRecognizerView != null) {
            mRecognizerView.changeConfiguration(newConfig);
        }
    }

    @Override
    public void onDisplayOcrResult(OcrResult ocrResult) {
        // This method is called when recognition thread wants to display its OCR result
        // This method is called on recognition thread, not on UI thread, so if you plan
        // to use your own implementation for drawing OcrResult, make sure you do not change
        // view hierarchy without posting to UI thread first.
        mOcrResultView.setOcrResult(ocrResult);
    }

    @Override
    public void onNothingDetected() {
        // This method is called when no recognizer has been able to detect anything on camera frame.
    }

    @Override
    public void onDisplayPointsOfInterest(List<Point> points, DetectionStatus detectionStatus) {
        // This method is called when some recognizer has detected some points of interest and
        // wants to display those points. In this demo, this method will be called when 1D barcode
        // is detected.
        mPointSetView.setPointSet(new PointSet(points));
    }

    @Override
    public void onDisplayQuadrilateralObject(Quadrilateral quad, DetectionStatus detectionStatus) {
        // This method is called when some recognizer has detected some quadrilateral object and
        // wants to display its location. In this demo, no recognizer can call this method, but
        // if you add PDF417 barcode recognizer to recognizer array in onCreate method, then
        // when PDF417 barcode is detected, this method will be called with its location.
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
    public void onStartupError(Throwable exc) {
        // called when unrecoverable exception occurs on initialization
        // possible errors are: camera is unavailable; native library wasn't loaded
        Log.e(this, exc, "Startup error");
        Toast.makeText(this, "Startup error: " + exc.getMessage(), Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onNotSupported(NotSupportedReason reason) {
        // called when recognition is attempted on unsupported device.
        // You can use this method to inform the user that its device is not supported.
        Log.e(this, "Not supported reason: {}", reason);
        Toast.makeText(this, "Not supported reason: " + reason.name(), Toast.LENGTH_LONG).show();
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
    public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {
        // called when scanning completes. In this example, we first check if dataArray contains
        // barcode result and display a barcode contents in the Toast.
        // We also check if dataArray contains raw parser result and log it to ADB.

        for (BaseRecognitionResult r : dataArray) {
            if (r instanceof BarDecoderScanResult) { // r is barcode scan result
                BarDecoderScanResult bdsr = (BarDecoderScanResult) r;

                // create toast with contents: Barcode type: barcode contents

                StringBuilder sb = new StringBuilder();
                sb.append(bdsr.getBarcodeType().name());
                sb.append(": ");
                sb.append(bdsr.getStringData());

                Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
            } else if (r instanceof BlinkOCRRecognitionResult) {
                BlinkOCRRecognitionResult bocrRes = (BlinkOCRRecognitionResult) r;

                // obtain parse result of parser named "Raw"
                String rawParsed = bocrRes.getParsedResult("Raw");
                Log.i("Parsed", rawParsed);

                // obtain OCR result that was used for parsing
                OcrResult ocrResult = bocrRes.getOcrResult();
                Log.i("OcrResult", ocrResult.toString());
            }
        }

        // Finally, we resume scanning and reset internal state. If you want OCR to reuse
        // results from previous scan to make current scan of better quality, call
        // resumeScanning(false). Note that preserving state preserves state of all
        // recognizers, including barcode recognizers (if enabled).
        mRecognizerView.resumeScanning(true);
    }
}
