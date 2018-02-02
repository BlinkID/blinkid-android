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
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.microblink.detectors.DetectorResult;
import com.microblink.detectors.DetectorSettings;
import com.microblink.detectors.multi.MultiDetectorSettings;
import com.microblink.detectors.quad.QuadDetectorResult;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.metadata.DetectionMetadata;
import com.microblink.metadata.ImageMetadata;
import com.microblink.metadata.Metadata;
import com.microblink.metadata.MetadataListener;
import com.microblink.metadata.MetadataSettings;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.recognizers.detector.DetectorRecognizerSettings;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraView;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.OnSizeChangedListener;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.recognition.RecognizerView;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.view.viewfinder.quadview.QuadViewAnimationListener;
import com.microblink.view.viewfinder.quadview.QuadViewManager;
import com.microblink.view.viewfinder.quadview.QuadViewManagerFactory;
import com.microblink.view.viewfinder.quadview.QuadViewPreset;

public class DetectorActivity extends Activity implements CameraEventsListener, ScanResultListener, MetadataListener, OnSizeChangedListener {

    /** Key for setting the array of {@link DetectorSettings} */
    public static final String EXTRAS_DETECTOR_SETTINGS = "EXTRAS_DETECTOR_SETTINGS";
    /** Key for setting the license key */
    public static final String EXTRAS_LICENSE_KEY = "EXTRAS_LICENSE_KEY";

    private final int MY_STORAGE_REQUEST_CODE = 6969;

    /** RecognizerView is the builtin view that controls camera and recognition */
    private RecognizerView mRecognizerView;
    /** View which holds scan result. */
    private View mResultView;
    /** Shows result image. */
    private ImageView mImageView;
    /** This is BlinkID's built-in helper for built-in view that draws detection location */
    private QuadViewManager mQuadViewManager;
    /** Last dewarped image. */
    private Image mLastDewarpedImg;
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
        mRecognizerView = (RecognizerView) findViewById(R.id.rec_view);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

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
            mRecognizerView.setLicenseKey(extras.getString(EXTRAS_LICENSE_KEY));
        } catch (InvalidLicenceKeyException e) {
            e.printStackTrace();
            showErrorDialog(getString(R.string.err_license));
            mRecognizerView.create();
            mRecognizerView = null;
            return;
        }

        // obtain detector settings from intent
        Parcelable[] settParc = extras.getParcelableArray(EXTRAS_DETECTOR_SETTINGS);
        if (settParc == null || settParc.length == 0) {
            throw new NullPointerException("EXTRAS_DETECTOR_SETTINGS not set."
                    + " Please set detector settings intent extra!");
        }
        DetectorSettings[] detSett = new DetectorSettings[settParc.length];
        for (int i = 0; i < settParc.length; i++) {
            detSett[i] = (DetectorSettings)settParc[i];
        }

        // Prepare detector recognizer settings, this recognizer is used to detect the
        // desired objects.
        DetectorRecognizerSettings drs = null;

        if (detSett.length == 1) {
            // if only one detector settings was sent via intent, use it directly
            drs = new DetectorRecognizerSettings(detSett[0]);
        } else {
            // Otherwise, prepare settings for multi detector that returns the first successful result from one of the
            // given detectors, here we use detector settings passed by intent.
            MultiDetectorSettings mds = new MultiDetectorSettings(detSett);

            drs = new DetectorRecognizerSettings(mds);
        }

        // Finally, prepare settings for recognition.
        RecognitionSettings settings = new RecognitionSettings();
        // Set recognizer settings array that is used to configure recognition,
        // detector recognizer will be used.
        settings.setRecognizerSettingsArray(new RecognizerSettings[]{drs});

        mRecognizerView.setRecognitionSettings(settings);

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

        // define which metadata will be available in MetadataListener (onMetadataAvailable method)
        MetadataSettings ms = new MetadataSettings();
        // detection metadata should be available in MetadataListener
        // detection metadata are all metadata objects from com.microblink.metadata.detection package
        ms.setDetectionMetadataAllowed(true);
        // define which images should be available in MetadataListener
        MetadataSettings.ImageMetadataSettings ims = new MetadataSettings.ImageMetadataSettings();
        // enable dewarped images
        ims.setDewarpedImageEnabled(true);

        ms.setImageMetadataSettings(ims);

        // set metadata listener and defined metadata settings
        // metadata listener will obtain selected metadata
        mRecognizerView.setMetadataListener(this, ms);

        // instantiate the camera permission manager
        mCameraPermissionManager = new CameraPermissionManager(this);
        // get the built in layout that should be displayed when camera permission is not given
        View v = mCameraPermissionManager.getAskPermissionOverlay();
        if (v != null) {
            // add it to the current layout that contains the recognizer view
            ViewGroup vg = (ViewGroup) findViewById(R.id.main_root);
            vg.addView(v);
        }

        // create scanner (make sure scan settings and listeners were set prior calling create)
        mRecognizerView.create();


        // initialize the view that is used to show scan results
        mResultView = getLayoutInflater().inflate(R.layout.detector_detection_result, null);
        mResultView.setVisibility(View.INVISIBLE);
        mImageView = (ImageView) mResultView.findViewById(R.id.imgDewarped);

        // setup button listeners
        Button btnCancel = (Button) mResultView.findViewById(R.id.btnCancel);
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

        mBtnSave = (Button) mResultView.findViewById(R.id.btnSave);
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
        View overlay = getLayoutInflater().inflate(R.layout.default_barcode_camera_overlay, null);

        mTorchButton = (Button) overlay.findViewById(R.id.defaultTorchButton);
        mBackButton = (Button) overlay.findViewById(R.id.defaultBackButton);
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
        // Here we use preset which sets up quad view in the same style as used in built-in BlinkID ScanActivity.
        mQuadViewManager = QuadViewManagerFactory.createQuadViewFromPreset(mRecognizerView, QuadViewPreset.DEFAULT_CORNERS_FROM_SCAN_ACTIVITY);

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
            mTorchButton.setText(com.microblink.library.R.string.mbLightOff);
            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(com.microblink.library.R.drawable.lightoff, 0, 0, 0);
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
                                            mTorchButton.setText(com.microblink.library.R.string.mbLightOn);
                                            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(com.microblink.library.R.drawable.lighton, 0, 0, 0);
                                        } else {
                                            mTorchButton.setText(com.microblink.library.R.string.mbLightOff);
                                            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(com.microblink.library.R.drawable.lightoff, 0, 0, 0);
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

    private void showErrorDialog(String message) {
        if (mActivityBooting) {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            }).setTitle("Problem").setMessage(message).setCancelable(false).create().show();
        } else {
            Log.w(this, "Cannot show dialog because activity is exiting!");
        }
    }

    @Override
    public void onError(Throwable exc) {
        // This method will be called when opening of camera resulted in exception or
        // recognition process encountered an error.
        // The error details will be given in ex parameter.
        showErrorDialog(exc.getMessage());
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
        if(mLastDewarpedImg != null) {
            // create bitmap out of last dewarped image
            mShownBitmap = mLastDewarpedImg.convertToBitmap();
            // dispose image
            mLastDewarpedImg = null;
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
                    requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_STORAGE_REQUEST_CODE);
                }
            }
        }
    }

    @Override
    public void onScanningDone(RecognitionResults results) {
        mRecognizerView.pauseScanning();
        if(!mQuadViewManager.isAnimationInProgress()) {
            // if animation has ended, show result
            showResult();
        } else {
            // else result will be shown when animation ends (animation listener)
            mHaveResult = true;
        }
    }

    @Override
    public void onMetadataAvailable(Metadata metadata) {
        // This method will be called when metadata becomes available during recognition process.
        // Here, for every metadata type that is allowed through metadata settings,
        // desired actions can be performed.
        if (metadata instanceof DetectionMetadata) {
            // detection location is written inside DetectorResult
            DetectorResult detectorResult = ((DetectionMetadata) metadata).getDetectionResult();
            // DetectorResult can be null - this means that detection has failed
            if (detectorResult == null) {
                if (mQuadViewManager != null) {
                    // begin quadrilateral animation to its default position
                    // (internally displays FAIL status)
                    mQuadViewManager.animateQuadToDefaultPosition();
                }
                // when points of interested have been detected (e.g. QR code), this will be returned as PointsDetectorResult
            } else if (detectorResult instanceof QuadDetectorResult) {
                // begin quadrilateral animation to detected quadrilateral
                mQuadViewManager.animateQuadToDetectionPosition((QuadDetectorResult) detectorResult);
            }
        } else if (metadata instanceof ImageMetadata) {
            // here we will get dewarped image
            mLastDewarpedImg = ((ImageMetadata) metadata).getImage().clone();
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
}
