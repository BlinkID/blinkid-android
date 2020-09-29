package com.microblink.blinkid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.microblink.blinkid.demo.R;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.FailedDetectionCallback;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.detection.points.PointsDetectionCallback;
import com.microblink.metadata.detection.points.PointsType;
import com.microblink.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.OnActivityFlipListener;
import com.microblink.view.OnSizeChangedListener;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.ocrResult.OcrResultDotsView;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.view.viewfinder.points.PointSetView;
import com.microblink.view.viewfinder.quadview.QuadViewManager;
import com.microblink.view.viewfinder.quadview.QuadViewManagerFactory;
import com.microblink.view.viewfinder.quadview.QuadViewPreset;

import androidx.annotation.NonNull;

public class MyScanActivity extends Activity implements ScanResultListener, CameraEventsListener, OnSizeChangedListener, OnActivityFlipListener {

    public static final String TAG = "MyScanActivity";

    private int mScansDone = 0;
    private Handler mHandler = new Handler();

    private RecognizerBundle recognizerBundle;

    /**
     * This is a RecognizerView - it contains camera view and can contain camera overlays
     */
    RecognizerRunnerView mRecognizerView;
    /**
     * CameraPermissionManager is provided helper class that can be used to obtain the permission to use camera.
     * It is used on Android 6.0 (API level 23) or newer.
     */
    private CameraPermissionManager mCameraPermissionManager;
    /**
     * This is a back button
     */
    private ImageButton mBackButton = null;
    /**
     * This is a torch control button
     */
    private ImageButton mTorchButton = null;
    /**
     * Is torch enabled?
     */
    private boolean mTorchEnabled = false;
    /**
     * This is a text field that contains status messages
     */
    private TextView mStatusTextView = null;
    /**
     * This is BlinkID's built-in helper for built-in view that draws detection location
     */
    QuadViewManager mQvManager = null;
    /**
     * MediaPlayer will be used for beep sound
     */
    private MediaPlayer mMediaPlayer = null;
    /**
     * MRZPointSetView is used for displaying dots when MRZ is detected
     */
    private PointSetView mMrzPointSetView;
    /**
     * mOcrView is used for displaying dots for OCR
     */
    private OcrResultDotsView mOcrView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scan);
        mRecognizerView = findViewById(R.id.recognizerView);

        recognizerBundle = new RecognizerBundle(createRecognizers());
        mRecognizerView.setRecognizerBundle(recognizerBundle);

        // scan result listener will be notified when scan result gets available
        mRecognizerView.setScanResultListener(this);
        // camera events listener receives events such as when camera preview has started
        // or there was an error while starting the camera
        mRecognizerView.setCameraEventsListener(this);
        // orientation allowed listener is asked if orientation is allowed when device orientation
        // changes - if orientation is allowed, rotatable views will be rotated to that orientation
        mRecognizerView.setOrientationAllowedListener(new OrientationAllowedListener() {
            @Override
            public boolean isOrientationAllowed(@NonNull Orientation orientation) {
                // allow all orientations
                return true;
            }
        });
        // on size changed listener is notified whenever the size of the view is changed (for example
        // when transforming the view from portrait to landscape or vice versa)
        mRecognizerView.setOnSizeChangedListener(this);

        setupMetadataCallbacks();

        // set initial orientation
        mRecognizerView.setInitialOrientation(Orientation.ORIENTATION_PORTRAIT);

        // set camera aspect mode to FILL - this will use the entire surface
        // for camera preview, instead of letterboxing it
        mRecognizerView.setAspectMode(CameraAspectMode.ASPECT_FILL);

        // instantiate the camera permission manager
        mCameraPermissionManager = new CameraPermissionManager(this);
        // get the built in layout that should be displayed when camera permission is not given
        View v = mCameraPermissionManager.getAskPermissionOverlay();
        if (v != null) {
            // add it to the current layout that contains the recognizer view
            ViewGroup vg = findViewById(R.id.my_scan_root);
            vg.addView(v);
        }

        // create scanner (make sure scan settings and listeners were set prior calling create)
        mRecognizerView.create();

        // after scanner is created, you can add your views to it

        // Use provided factory method from QuadViewManagerFactory that can instantiate the
        // QuadViewManager based on several presets defined in QuadViewPreset enum. Details about
        // each of them can be found in javadoc. This method automatically adds the QuadView as a
        // child of RecognizerView.
        // Here we use preset which sets up quad view in the same style as used in built-in BlinkID DocumentScan activity.
        mQvManager = QuadViewManagerFactory.createQuadViewFromPreset(mRecognizerView, QuadViewPreset.DEFAULT_FROM_DOCUMENT_SCAN_ACTIVITY);

        // initialize buttons and status view
        View view = getLayoutInflater().inflate(R.layout.default_blinkid_viewfinder, null);

        mBackButton = view.findViewById(R.id.defaultBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        mTorchButton = view.findViewById(R.id.defaultTorchButton);
        mTorchButton.setVisibility(View.GONE);

        mStatusTextView = view.findViewById(R.id.defaultStatusTextView);
        mStatusTextView.setVisibility(View.INVISIBLE);

        // add buttons and status view as rotatable view to BlinkIdView (it will be rotated even if activity remains in portrait/landscape)
        // allowed orientations are controlled via OrientationAllowedListener
        mRecognizerView.addChildView(view, true);

        // add dots that appear when MRZ characters are detected
        mMrzPointSetView = new PointSetView(this, null, mRecognizerView.getHostScreenOrientation(),
                7, getResources().getColor(R.color.mb_mrz_point_color));
        mRecognizerView.addChildView(mMrzPointSetView, false);

        // add dots that appear when OCR characters are detected
        mOcrView = new OcrResultDotsView(this, mRecognizerView.getHostScreenOrientation(), mRecognizerView.getInitialOrientation());
        mRecognizerView.addOrientationChangeListener(mOcrView);
        mRecognizerView.addChildView(mOcrView.getView(), false);
    }

    private void setupMetadataCallbacks() {
        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        // add callback for each metadata type you're interested in
        metadataCallbacks.setQuadDetectionCallback(new QuadDetectionCallback() {
            @Override
            public void onQuadDetection(@NonNull DisplayableQuadDetection displayableQuadDetection) {
                // begin quadrilateral animation to detected quadrilateral
                // mQvManager.animateQuadToDetectionPosition(displayableQuadDetection);
                DetectionStatus detectionStatus = displayableQuadDetection.getDetectionStatus();

                // displays message about detection status to the user
                if (detectionStatus == DetectionStatus.SUCCESS) {
                    displayText(R.string.msg_processing);
                } else if (detectionStatus == DetectionStatus.FAIL) {
                    displayText(R.string.msg_align);
                } else if (detectionStatus == DetectionStatus.CAMERA_TOO_HIGH) {
                    displayText(R.string.msg_camera_too_high);
                } else if (detectionStatus == DetectionStatus.PARTIAL_OBJECT) {
                    displayText(R.string.msg_partial_detected);
                }
            }
        });

        metadataCallbacks.setPointsDetectionCallback(new PointsAndFailedDetectionCallback());

        mRecognizerView.setMetadataCallbacks(metadataCallbacks);
    }

    private Recognizer[] createRecognizers() {
        MrtdRecognizer mrtdRecognizer = new MrtdRecognizer();
        mrtdRecognizer.setReturnFullDocumentImage(true);

        UsdlRecognizer usdlRecognizer = new UsdlRecognizer();

        return new Recognizer[]{mrtdRecognizer, usdlRecognizer};
    }

    @Override
    protected void onResume() {
        super.onResume();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.resume();
        }
        mMediaPlayer = MediaPlayer.create(this, R.raw.beep);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.pause();
        }
        if (mMediaPlayer != null) {
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // all activity lifecycle events must be passed on to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.destroy();
        }
    }

    /**
     * Plays beep sound.
     */
    private void soundNotification() {
        if (mMediaPlayer != null) {
            Log.d(TAG, "Playing beep sound");
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (mMediaPlayer == null) {
                        mp.release();
                    }
                }
            });
        }
    }

    @Override
    public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                soundNotification();
            }
        });

        mScansDone++;
        mRecognizerView.pauseScanning();
        if (mScansDone >= 3) {
            // after 3 successful scans, show results
            Intent resultIntent = new Intent();
            recognizerBundle.saveToIntent(resultIntent);
            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            Toast.makeText(this, "Scans done: " + mScansDone, Toast.LENGTH_SHORT).show();
            // resume scanning after two seconds
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mRecognizerView.resumeScanning(true);
                }
            }, 2000);
        }
    }

    @Override
    public void onUnrecoverableError(@NonNull Throwable throwable) {
        Toast.makeText(this, throwable.toString(), Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onCameraPreviewStarted() {
        // this method is called just after camera preview has started
        enableTorchButtonIfPossible();
    }

    @Override
    public void onCameraPreviewStopped() {
        // this method is called just after camera preview has stopped
    }

    private void enableTorchButtonIfPossible() {
        if (!mRecognizerView.isCameraTorchSupported() || mTorchButton == null) {
            return;
        }

        mTorchButton.setVisibility(View.VISIBLE);
        mTorchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTorchBtnClick();
            }
        });
    }

    private void onTorchBtnClick() {
        mRecognizerView.setTorchState(!mTorchEnabled, new SuccessCallback() {
            @Override
            public void onOperationDone(final boolean success) {
                if (!success) {
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTorchEnabled = !mTorchEnabled;
                        if (mTorchEnabled) {
                            mTorchButton.setImageResource(R.drawable.mb_ic_flash_on_24dp);
                        } else {
                            mTorchButton.setImageResource(R.drawable.mb_ic_flash_off_24dp);
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onError(Throwable ex) {
        // This method will be called when opening of camera resulted in exception or
        // recognition process encountered an error.
        // The error details will be given in ex parameter.
        com.microblink.util.Log.e(this, ex, "Error");
        handleError();
    }

    @SuppressWarnings("deprecation")
    private void handleError() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.error));
        alertDialog.setMessage(getString(R.string.errorDesc));

        alertDialog.setButton(getString(R.string.blinkidOK), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {
                    dialog.dismiss();
                }
                setResult(Activity.RESULT_CANCELED, null);
                finish();
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void displayText(final int textId) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mStatusTextView.setText(textId);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // important for drawing dots in the right direction
        if (mOcrView != null) {
            mOcrView.setHostActivityOrientation(mRecognizerView.getHostScreenOrientation());
        }
    }

    @Override
    public void onAutofocusFailed() {
        // this method is called if camera cannot perform autofocus
        // this method is called from background (focusing) thread
        // so make sure you post UI actions on UI thread
        displayText(R.string.mb_autofocus_fail);

        if (mOcrView != null) {
            mOcrView.clearDisplayedContent();
        }
    }

    @Override
    public void onAutofocusStarted(Rect[] rects) {
        if (rects == null) {
            Log.i(TAG, "Autofocus started with focusing areas being null");
        } else {
            Log.i(TAG, "Autofocus started");
            for (Rect rect : rects) {
                Log.d(TAG, "Focus area: " + rect.toString());
            }
        }
    }

    @Override
    public void onAutofocusStopped(Rect[] rects) {
        if (rects == null) {
            Log.i(TAG, "Autofocus stopped with focusing areas being null");
        } else {
            Log.i(TAG, "Autofocus stopped");
            for (Rect rect : rects) {
                Log.d(TAG, "Focus area: " + rect.toString());
            }
        }
    }

    @Override
    public void onSizeChanged(int width, int height) {
        // this is called whenever size of the BlinkIDView changes
        // we will use this callback in this example to adjust the margins of buttons
        int horizontalMargin = (int) (width * 0.07);
        int verticalMargin = (int) (height * 0.07);

        // set margins for text view
        FrameLayout.LayoutParams statusViewParams = (FrameLayout.LayoutParams) mStatusTextView.getLayoutParams();
        if (statusViewParams.bottomMargin != verticalMargin) {
            statusViewParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin);
            mStatusTextView.setLayoutParams(statusViewParams);
        }
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
        // this method is called on Android 6.0 and newer if camera permission was not given by user

        // ask user to give a camera permission. Provided manager asks for
        // permission only if it has not been already granted.
        // on API level < 23, this method does nothing
        mCameraPermissionManager.askForCameraPermission();
    }

    @Override
    public void onActivityFlip() {
        // important for drawing dots in the right direction
        if (mOcrView != null) {
            mOcrView.setHostActivityOrientation(mRecognizerView.getHostScreenOrientation());
        }
    }

    private class PointsAndFailedDetectionCallback implements PointsDetectionCallback, FailedDetectionCallback {

        @Override
        public void onPointsDetection(@NonNull DisplayablePointsDetection displayablePointsDetection) {
            if (mMrzPointSetView != null) {
                if (displayablePointsDetection.getPointsType() == PointsType.MRTD_DETECTION) {
                    mMrzPointSetView.setDisplayablePointsDetection(displayablePointsDetection);
                } else {
                    mMrzPointSetView.clearDisplayedContent();
                }
            }

            if (mOcrView != null) {
                if (displayablePointsDetection.getPointsType() == PointsType.OCR_RESULT) {
                    mOcrView.addDisplayablePointsDetection(displayablePointsDetection);
                } else {
                    mOcrView.clearDisplayedContent();
                }
            }
        }

        @Override
        public void onDetectionFailed() {
            mMrzPointSetView.clearDisplayedContent();
            mOcrView.clearDisplayedContent();
        }
    }
}