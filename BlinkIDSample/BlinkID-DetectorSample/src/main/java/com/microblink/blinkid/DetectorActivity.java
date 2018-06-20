package com.microblink.blinkid;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.microblink.entities.detectors.quad.QuadWithSizeDetector;
import com.microblink.entities.processors.imageReturn.ImageReturnProcessor;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.entities.recognizers.templating.ProcessorGroup;
import com.microblink.entities.recognizers.templating.TemplatingClass;
import com.microblink.entities.recognizers.templating.dewarpPolicies.DPIBasedDewarpPolicy;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.FailedDetectionCallback;
import com.microblink.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraView;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.OnSizeChangedListener;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.view.viewfinder.quadview.QuadViewAnimationListener;
import com.microblink.view.viewfinder.quadview.QuadViewManager;
import com.microblink.view.viewfinder.quadview.QuadViewManagerFactory;
import com.microblink.view.viewfinder.quadview.QuadViewPreset;

public class DetectorActivity extends Activity implements CameraEventsListener, ScanResultListener, OnSizeChangedListener {

    public static final String EXTRAS_DETECTOR = "EXTRAS_DETECTOR";
    private final int MY_STORAGE_REQUEST_CODE = 6969;

    /** RecognizerView is the builtin view that controls camera and recognition */
    private RecognizerRunnerView mRecognizerView;
    /** View which holds scan result. */
    private View mResultView;
    /** Shows result image. */
    private ImageView mImageView;
    /** This is BlinkID's built-in helper for built-in view that draws detection location */
    private QuadViewManager mQuadViewManager;
    /** Currently shown bitmap created from dewarped image. */
    private Bitmap mShownBitmap;
    /** This is a torch control button */
    private Button mTorchButton;
    /** Is torch enabled? */
    private boolean mTorchEnabled = false;
    /** Back button from recognizer overlay */
    private Button mBackButton;
    /** Save button in result view */
    private Button mBtnSave;

    private boolean mActivityBooting = true;
    /** Indicates whether the new result should be shown */
    private boolean mHaveResult = false;
    /** CameraPermissionManager is provided helper class that can be used to obtain the permission to use camera.
     * It is used on Android 6.0 (API level 23) or newer.
     */
    private CameraPermissionManager mCameraPermissionManager;

    /**
     * Processor that is used to obtain images of the detected document.
     */
    private ImageReturnProcessor mImageReturnProcessor;

    private enum ActivityState {
        DESTROYED,
        CREATED,
        STARTED,
        RESUMED
    }

    private ActivityState mActivityState = ActivityState.DESTROYED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detector_activity);
        mActivityState = ActivityState.CREATED;

        // obtain reference to RecognizerView
        mRecognizerView = findViewById(R.id.rec_view);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        QuadWithSizeDetector detector = null;

        if (extras != null) {
            detector = extras.getParcelable(EXTRAS_DETECTOR);
        }

        if (detector == null) {
            Toast.makeText(this, "EXTRAS_DETECTOR intent extra not set! Please set " +
                    "detector that you want to to use.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // setup detector recognizer
        DetectorRecognizer detectorRecognizer = new DetectorRecognizer(detector);
        // processor that will simply save obtained image
        mImageReturnProcessor = new ImageReturnProcessor();
        // processor group that will be executed on the detected document location
        ProcessorGroup processorGroup = new ProcessorGroup(
                // process entire detected location
                new Rectangle(0.f, 0.f, 1.f, 1.f),
                // dewarp height will be calculated based on actual physical size of detected
                // location and requested DPI
                new DPIBasedDewarpPolicy(200),
                // only image is needed
                mImageReturnProcessor
        );

        // Templating class is used to define how specific document type should be processed.
        // Only image should be returned, which means that classification of the document
        // based on the processed data is not needed, so only one document class is defined.
        TemplatingClass documentClass = new TemplatingClass();
        // prepared processor group is added to classification processor groups because
        // they are executed before classification
        documentClass.setClassificationProcessorGroups(processorGroup);
        detectorRecognizer.setTemplatingClasses(documentClass);

        mRecognizerView.setRecognizerBundle(new RecognizerBundle(detectorRecognizer));

        // camera events listener receives events such as when camera preview has started
        // or there was an error while starting the camera
        mRecognizerView.setCameraEventsListener(this);
        // scan result listener will be notified when scan result gets available
        mRecognizerView.setScanResultListener(this);
        // allow pinch to zoom
        mRecognizerView.setPinchToZoomAllowed(true);
        // on size changed listener will be notified when camera view changes the size of itself
        // and its children.
        mRecognizerView.setOnSizeChangedListener(this);
        // set allow orientation listener that will allow all orientations
        mRecognizerView.setOrientationAllowedListener(new OrientationAllowedListener() {
            @Override
            public boolean isOrientationAllowed(Orientation orientation) {
                return true;
            }
        });

        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        metadataCallbacks.setFailedDetectionCallback(mFailedDetectionCallback);
        metadataCallbacks.setQuadDetectionCallback(mQuadDetectionCallback);
        mRecognizerView.setMetadataCallbacks(metadataCallbacks);

        // instantiate the camera permission manager
        mCameraPermissionManager = new CameraPermissionManager(this);
        // get the built in layout that should be displayed when camera permission is not given
        View v = mCameraPermissionManager.getAskPermissionOverlay();
        if (v != null) {
            // add it to the current layout that contains the recognizer view
            ViewGroup vg = findViewById(R.id.main_root);
            vg.addView(v);
        }

        // create scanner (make sure scan settings and listeners were set prior calling create)
        mRecognizerView.create();

        // initialize the view that is used to show scan results
        mResultView = getLayoutInflater().inflate(R.layout.detector_detection_result, null);
        mResultView.setVisibility(View.INVISIBLE);
        mImageView = mResultView.findViewById(R.id.imgDewarped);

        // setup button listeners
        Button btnCancel = mResultView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // release Bitmap
                mImageView.setImageResource(android.R.color.transparent);
                mShownBitmap = null;
                // hide resultView
                mResultView.setVisibility(View.INVISIBLE);
                mRecognizerView.invalidate();

                // resume scanning
                if (mRecognizerView != null && mActivityState == ActivityState.RESUMED && mRecognizerView.getCameraViewState() == BaseCameraView.CameraViewState.RESUMED) {
                    mRecognizerView.resumeScanning(true);
                }
            }
        });

        mBtnSave = mResultView.findViewById(R.id.btnSave);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save image to gallery
                String url = MediaStore.Images.Media.insertImage(DetectorActivity.this.getContentResolver(), mShownBitmap, "Detected Image", "");
                Log.i(DetectorActivity.this, "Image saved to URL {}", url);

                // release Bitmap
                mImageView.setImageResource(android.R.color.transparent);
                mShownBitmap = null;
                // hide resultView
                mResultView.setVisibility(View.INVISIBLE);
                mRecognizerView.invalidate();

                // resume scanning
                if (mRecognizerView != null && mActivityState == ActivityState.RESUMED && mRecognizerView.getCameraViewState() == BaseCameraView.CameraViewState.RESUMED) {
                    mRecognizerView.resumeScanning(true);
                }
            }
        });

        // camera overlay
        View overlay = getLayoutInflater().inflate(R.layout.mb_default_barcode_camera_overlay, null);

        mTorchButton = overlay.findViewById(R.id.defaultTorchButton);
        mBackButton = overlay.findViewById(R.id.defaultBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });


        // initialize QuadViewManager
        // Use provided factory method from QuadViewManagerFactory that can instantiate the
        // QuadViewManager based on several presets defined in QuadViewPreset enum. Details about
        // each of them can be found in javadoc. This method automatically adds the QuadView as a
        // child of RecognizerView.
        // Here we use preset which sets up quad view in the same style as used in built-in document scan activity.
        mQuadViewManager = QuadViewManagerFactory.createQuadViewFromPreset(mRecognizerView, QuadViewPreset.DEFAULT_CORNERS_FROM_PHOTOPAY_ACTIVITY);

        // set animation listener to quad view manager that will show result when animation ends
        mQuadViewManager.setAnimationListener(new QuadViewAnimationListener() {
            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationEnd() {
                if(mHaveResult) {
                    showResult();
                }
            }
        });

        ((ViewGroup) overlay).addView(mResultView);
        mRecognizerView.addChildView(overlay, true);
        mActivityBooting = true;
    }

    @Override
    protected void onStart() {
        mActivityState = ActivityState.STARTED;
        // all activity lifecycle events must be passed to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.start();
        }
        mActivityBooting = true;
        super.onStart();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onResume() {
        mActivityState = ActivityState.RESUMED;
        // all activity lifecycle events must be passed to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.resume();
        }
        mActivityBooting = true;
        super.onResume();
    }

    @Override
    protected void onPause() {
        mActivityState = ActivityState.STARTED;
        // all activity lifecycle events must be passed to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.pause();
        }
        mActivityBooting = false;
        super.onPause();
    }

    @Override
    protected void onStop() {
        mActivityState = ActivityState.CREATED;
        // all activity lifecycle events must be passed to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.stop();
        }
        mActivityBooting = false;
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mActivityState = ActivityState.DESTROYED;
        // all activity lifecycle events must be passed to RecognizerView
        if (mRecognizerView != null) {
            mRecognizerView.destroy();
        }
        mActivityBooting = false;
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // change configuration of scanner's internal views
        if (mRecognizerView != null) {
            mRecognizerView.changeConfiguration(newConfig);
        }
    }

    /**
     * Enable torch button if possible.
     */
    private void enableTorchButtonIfPossible() {
        if (mRecognizerView.isCameraTorchSupported() && mTorchButton != null) {
            mTorchButton.setVisibility(View.VISIBLE);
            mTorchButton.setText(com.microblink.library.R.string.mb_light_off);
            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(com.microblink.library.R.drawable.mb_lightoff, 0, 0, 0);
            mTorchEnabled = false;
            mTorchButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mRecognizerView.setTorchState(!mTorchEnabled, new SuccessCallback() {
                        @Override
                        public void onOperationDone(final boolean success) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d(DetectorActivity.this, "Setting torch to {}. Success: {}", !mTorchEnabled, success);
                                    if (success) {
                                        mTorchEnabled = !mTorchEnabled;
                                        if (mTorchEnabled) {
                                            mTorchButton.setText(com.microblink.library.R.string.mb_light_on);
                                            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(com.microblink.library.R.drawable.mb_lighton, 0, 0, 0);
                                        } else {
                                            mTorchButton.setText(com.microblink.library.R.string.mb_light_off);
                                            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(com.microblink.library.R.drawable.mb_lightoff, 0, 0, 0);
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    @Override
    public void onCameraPreviewStarted() {
        if (mActivityState == ActivityState.RESUMED) {
            enableTorchButtonIfPossible();
        }
    }

    @Override
    public void onCameraPreviewStopped() {
        // nothing to do
    }


    @Override
    public void onError(Throwable exc) {
        // This method will be called when opening of camera resulted in exception or
        // recognition process encountered an error.
        // The error details will be given in ex parameter.
        if (mActivityBooting) {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            }).setTitle("Problem").setMessage(exc.getMessage()).setCancelable(false).create().show();
        } else {
            Log.w(this, "Cannot show dialog because activity is exiting!");
        }
    }

    @Override
    public void onCameraPermissionDenied() {
        // this method is called on Android 6.0 and newer if camera permission was not given
        // by user

        // ask user to give a camera permission. Provided manager asks for
        // permission only if it has not been already granted.
        // on API level < 23, this method does nothing
        mCameraPermissionManager.askForCameraPermission();
    }

    @Override
    public void onAutofocusFailed() {
        // this method is called if camera cannot perform autofocus
        // this method is called from background (focusing) thread
        // so make sure you post UI actions on UI thread
        Toast.makeText(this, R.string.autofocus_fail, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAutofocusStarted(Rect[] focusAreas) {

    }

    @Override
    public void onAutofocusStopped(Rect[] focusAreas) {

    }

    /**
     * Shows the view with result image.
     */
    private void showResult() {
        Image detectedImage = mImageReturnProcessor.getResult().getRawImage();
        if (detectedImage == null) {
            return;
        }

        // create bitmap out of last dewarped image
        mShownBitmap = detectedImage.convertToBitmap();
        // display bitmap
        mImageView.setImageBitmap(mShownBitmap);
        // display overlay
        mResultView.setVisibility(View.VISIBLE);
        // reset result state which is used in animation listener
        mHaveResult = false;

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                // if write permission is not granted don't show save button
                mBtnSave.setVisibility(View.INVISIBLE);
                // request write permission
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_STORAGE_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
        mRecognizerView.pauseScanning();
        if(!mQuadViewManager.isAnimationInProgress()) {
            // if animation has ended, show result
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showResult();
                }
            });
        } else {
            // else result will be shown when animation ends (animation listener)
            mHaveResult = true;
        }
    }

    @Override
    public void onSizeChanged(int width, int height) {
        Log.d(this, "[onSizeChanged] Width:{}, Height:{}", width, height);
        int horizontalMargin = (int) (width * 0.07);
        int verticalMargin = (int) (height * 0.07);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            int tmp = horizontalMargin;
            horizontalMargin = verticalMargin;
            verticalMargin = tmp;
        }

        if (mBackButton != null) {
            // set margins for back button
            FrameLayout.LayoutParams backButtonParams = (FrameLayout.LayoutParams) mBackButton.getLayoutParams();
            if (backButtonParams.leftMargin != horizontalMargin || backButtonParams.topMargin != verticalMargin) {
                backButtonParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin);
                mBackButton.setLayoutParams(backButtonParams);
            }
        }

        if (mTorchButton != null) {
            // set margins for torch button
            FrameLayout.LayoutParams torchButtonParams = (FrameLayout.LayoutParams) mTorchButton.getLayoutParams();
            if (torchButtonParams.leftMargin != horizontalMargin || torchButtonParams.topMargin != verticalMargin) {
                torchButtonParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin);
                mTorchButton.setLayoutParams(torchButtonParams);
            }
        }
    }

    @Override
    @TargetApi(23)
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_STORAGE_REQUEST_CODE) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mBtnSave.setVisibility(View.VISIBLE);
            }
        } else {
            // on API level 23, result of camera permission request should be passed to camera permission manager
            mCameraPermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private final QuadDetectionCallback mQuadDetectionCallback = new QuadDetectionCallback() {
        @Override
        public void onQuadDetection(@NonNull DisplayableQuadDetection quadDetection) {
            mQuadViewManager.animateQuadToDetectionPosition(quadDetection);
        }
    };

    private final FailedDetectionCallback mFailedDetectionCallback = new FailedDetectionCallback() {
        @Override
        public void onDetectionFailed() {
            mQuadViewManager.animateQuadToDefaultPosition();
        }
    };
}
