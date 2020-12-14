package com.microblink.blinkid;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.microblink.blinkid.managers.DocumentViewfinderManager;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult;
import com.microblink.entities.recognizers.blinkid.CombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.DataMatchResult;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.hardware.camera.CameraResolutionTooSmallException;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.FailedDetectionCallback;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.detection.points.PointsDetectionCallback;
import com.microblink.metadata.glare.GlareCallback;
import com.microblink.metadata.recognition.FirstSideRecognitionCallback;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.recognition.RecognizerError;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.NotSupportedReason;
import com.microblink.view.OnActivityFlipListener;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.exception.NonLandscapeOrientationNotSupportedException;
import com.microblink.view.ocrResult.OcrResultDotsView;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.view.viewfinder.ViewfinderShapeView;
import com.microblink.view.viewfinder.points.PointSetView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * Scan activity designed for scanning documents by using combined recognizers
 * ({@link CombinedRecognizer}). Scanning is performed
 * in multiple steps, in each step single side/part of the document is being scanned.
 */
public class CustomVerificationFlowActivity extends AppCompatActivity implements CameraEventsListener, ScanResultListener, OnActivityFlipListener {

    /**
     * Expected value type is {@link CameraType} - type of camera to be used for document scan
     * (back facing, front facing, default)
     */
    public static final String EXTRAS_COMBINED_CAMERA_TYPE = "EXTRAS_CAMERA_TYPE";

    /**
     * Resource ID of sound which is to be played after finishing the scan
     * procedure.
     */
    public static final String EXTRAS_BEEP_RESOURCE = "EXTRAS_BEEP_RESOURCE";

    /**
     * Force using legacy Camera API even on Lollipop devices that support new Camera2 API.
     * Use this only if you have problems with camera management on Lollipop devices.
     */
    public static final String EXTRAS_USE_LEGACY_CAMERA_API = "EXTRAS_USE_LEGACY_CAMERA_API";

    /**
     * Resource ID of the string that will be shown above document scan viewfinder when scanning of the first side of the document
     * is starting.
     */
    public static final String EXTRAS_SPLASH_MSG_RES_DOCUMENT_FIRST_SIDE = "EXTRAS_SPLASH_MSG_RES_DOCUMENT_FIRST_SIDE";
    /**
     * Drawable resource id of the image that will be shown above document scan viewfinder when scanning of the
     * first side of the document is starting.
     */
    public static final String EXTRAS_SPLASH_ICON_RES_DOCUMENT_FIRST_SIDE = "EXTRAS_SPLASH_ICON_RES_DOCUMENT_FIRST_SIDE";

    /**
     * Resource ID of the string that will be shown above document scan viewfinder when scanning of the second side of the document
     * is starting.
     */
    public static final String EXTRAS_SPLASH_MSG_RES_DOCUMENT_SECOND_SIDE = "EXTRAS_SPLASH_MSG_RES_DOCUMENT_SECOND_SIDE";
    /**
     * Drawable resource id of the image that will be shown above document scan viewfinder when scanning of the
     * second side of the document is starting.
     */
    public static final String EXTRAS_SPLASH_ICON_RES_DOCUMENT_SECOND_SIDE = "EXTRAS_SPLASH_ICON_RES_DOCUMENT_SECOND_SIDE";

    /**
     * String resource ID of the scan instructions that will be shown to the user as camera overlay during recognition
     * of the first side of the document.
     */
    public static final String EXTRAS_INSTRUCTIONS_DOCUMENT_FIRST_SIDE = "EXTRAS_INSTRUCTIONS_DOCUMENT_FIRST_SIDE";

    /**
     * String resource ID of the scan instructions that will be shown to the user as camera overlay during recognition
     * of the second side of the document.
     */
    public static final String EXTRAS_INSTRUCTIONS_DOCUMENT_SECOND_SIDE = "EXTRAS_INSTRUCTIONS_DOCUMENT_SECOND_SIDE";

    /**
     * Duration of the glare message in milliseconds
     */
    private static final long GLARE_MESSAGE_DURATION = 1500;
    /**
     * Duration of the splash screen when camera is starting (after the camera preview has started)
     */
    private static final long SPLASH_DURATION_CAMERA_STARTING = 500;
    /**
     * Duration of the splash screen when next side of the document should be scanned
     */
    private static final long SPLASH_DURATION_NEXT_SIDE = 1000;
    /**
     * Duration of the alpha animation on splash screen in milliseconds
     */
    private static final long SPLASH_FADE_ANIMATION_DURATION = 500;

    private static final int TORCH_ID = 0x25;

    /**
     * Handler associated withe the main thread.
     */
    protected Handler mHandler = new Handler(Looper.getMainLooper());

    /**
     * Flag which indicates whether torch(flashlight) is on or off.
     */
    private boolean mTorchOn = false;

    /**
     * Status overlay container, part of the screen where message (user instructions)
     * and document icon (indicates document side) is shown.
     */
    private View mStatusOverlay;
    /**
     * Icon of the current document (document side) that is being scanned.
     */
    private ImageView mStatusImage;
    /**
     * Message (user instructions) for the current document (document side).
     */
    private TextView mStatusMsg;
    /**
     * Text view where messages about glare status are printed.
     */
    private TextView mGlareMsg;

    /**
     * Torch menu item from the action bar, if the action bar is hidden, it will be {@code null}
     */
    private MenuItem mTorchItem = null;
    /**
     * Torch image button from the camera overlay, if the action bar is shown, it will be {@code null}
     * because torch button from the action bar will be used.
     */
    private ImageButton mIbTorch = null;

    /**
     * Document viewfinder manager that is used for showing the splash screens over the viewfinder
     */
    private DocumentViewfinderManager mDocumentViewfinderManager;

    private RecognizerBundle mRecognizerBundle;

    @StringRes
    private int mSplashMsgDocFirstSide;

    @StringRes
    private int mSplashMsgDocSecondSide;

    @StringRes
    private int mInstructionsDocFirstSide;

    @StringRes
    private int mInstructionsDocSecondSide;

    @DrawableRes
    private int mSplashIconDocFirstSide = R.drawable.mb_frontid_white;

    @DrawableRes
    private int mSplashIconDocSecondSide = R.drawable.mb_backid_white;

    private static final int MRZ_DETECTION_POINT_RADIUS = 7;
    private static final int NUM_MS_BEFORE_TIMEOUT_DEFAULT = 30_000;

    protected RecognizerRunnerView mRecognizerView;

    private SoundPool mSoundPool;
    private int mSoundId;

    /**
     * CameraPermissionManager is provided helper class that can be used to obtain the permission to use camera.
     * It is used on Android 6.0 (API level 23) or newer.
     */
    private CameraPermissionManager mCameraPermissionManager;

    /**
     * View which shows OCR result over the camera preview.
     */
    private OcrResultDotsView mOcrView;
    /**
     * View which shows MRZ detection points.
     */
    private PointSetView mMrzPointsView = null;

    private CombinedSide mCurrentCombinedSide = CombinedSide.FIRST_SIDE;
    private CameraType mCombinedCameraType = CameraType.CAMERA_BACKFACE;

    /**
     * Camera overlay container.
     */
    private FrameLayout mCameraOverlayRoot;

    protected enum ActivityState {
        DESTROYED,
        CREATED,
        STARTED,
        RESUMED
    }

    private enum CombinedSide {
        FIRST_SIDE,
        SECOND_SIDE
    }

    private ActivityState mActivityState = ActivityState.DESTROYED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // show back icon in the app bar
            ab.setDisplayHomeAsUpEnabled(true);
        }
        // initially torch is turned off
        mTorchOn = false;
        try {
            setContentView(R.layout.activity_custom_verification_flow);
        } catch (InflateException ie) {
            Throwable cause = ie.getCause();
            while (cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause instanceof NonLandscapeOrientationNotSupportedException) {
                Log.e(this, "NonLandscapeOrientationNotSupported");
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                return;
            } else {
                throw ie;
            }
        }

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            throw new NullPointerException("CustomVerificationFlowActivity requires recognizer bundle");
        }

        CameraType cameraType = extras.getParcelable(EXTRAS_COMBINED_CAMERA_TYPE);
        if (cameraType != null) {
            mCombinedCameraType = cameraType;
        }

        boolean useLegacyCamera = extras.getBoolean(EXTRAS_USE_LEGACY_CAMERA_API, false);

        mInstructionsDocFirstSide = extras.getInt(EXTRAS_INSTRUCTIONS_DOCUMENT_FIRST_SIDE, R.string.mb_tooltip_front_id);
        mInstructionsDocSecondSide = extras.getInt(EXTRAS_INSTRUCTIONS_DOCUMENT_SECOND_SIDE, R.string.mb_tooltip_back_id);
        mSplashMsgDocFirstSide = extras.getInt(EXTRAS_SPLASH_MSG_RES_DOCUMENT_FIRST_SIDE, R.string.mb_splash_msg_id_front);
        mSplashMsgDocSecondSide = extras.getInt(EXTRAS_SPLASH_MSG_RES_DOCUMENT_SECOND_SIDE, R.string.mb_splash_msg_id_back);
        mSplashIconDocFirstSide = extras.getInt(EXTRAS_SPLASH_ICON_RES_DOCUMENT_FIRST_SIDE, R.drawable.mb_frontid_white);
        mSplashIconDocSecondSide = extras.getInt(EXTRAS_SPLASH_ICON_RES_DOCUMENT_SECOND_SIDE, R.drawable.mb_backid_white);

        initRecognizerView(useLegacyCamera);

        ViewGroup vgRoot = findViewById(R.id.rootRecognizerView);

        mCameraPermissionManager = new CameraPermissionManager(this);
        View permissionOverlay = mCameraPermissionManager.getAskPermissionOverlay();
        if (permissionOverlay != null) {
            vgRoot.addView(permissionOverlay);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttrs = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            mSoundPool = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(audioAttrs).build();
        } else {
            mSoundPool = createOldSoundPool();
        }

        int soundResourceId = extras.getInt(EXTRAS_BEEP_RESOURCE, 0);
        if (soundResourceId > 0) {
            mSoundId = mSoundPool.load(this, soundResourceId, 1);
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
        }

    }

    private void initRecognizerView(boolean forceUseLegacyCamera) {
        mRecognizerView = findViewById(R.id.recognizerView);

        mRecognizerView.setForceUseLegacyCamera(forceUseLegacyCamera);

        mRecognizerBundle = new RecognizerBundle();
        mRecognizerBundle.loadFromIntent(getIntent());
        mRecognizerView.setRecognizerBundle(mRecognizerBundle);

        mRecognizerView.setCameraType(mCombinedCameraType);
        // set camera aspect mode to FILL - this will use the entire surface
        // for camera preview, instead of letterboxing it
        mRecognizerView.setAspectMode(CameraAspectMode.ASPECT_FILL);
        // scan result listener will be notified when scan result gets available
        mRecognizerView.setScanResultListener(this);
        // camera events listener receives events such as when camera preview has started
        // or there was an error while starting the camera
        mRecognizerView.setCameraEventsListener(this);
        mRecognizerView.setInitialOrientation(Orientation.ORIENTATION_PORTRAIT);
        mRecognizerView.setPinchToZoomAllowed(false);

        // orientation allowed listener is asked if orientation is allowed when device orientation
        // changes - if orientation is allowed, rotatable views will be rotated to that orientation
        mRecognizerView.setOrientationAllowedListener(new OrientationAllowedListener() {
            @Override
            public boolean isOrientationAllowed(Orientation orientation) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    // if in multi window mode, all orientations are allowed
                    return isInMultiWindowMode();
                }
                // only initial portrait orientation is allowed if not in multi window mode
                return false;
            }
        });

        mRecognizerBundle.setNumMsBeforeTimeout(NUM_MS_BEFORE_TIMEOUT_DEFAULT);

        // all activity lifecycle events must be passed on to RecognizerView, this method is called
        // from activity onCreate
        mRecognizerView.create();

        mMrzPointsView = new PointSetView(this, null, mRecognizerView.getHostScreenOrientation(), MRZ_DETECTION_POINT_RADIUS, ContextCompat.getColor(this, R.color.mb_mrz_point_color));
        mRecognizerView.addChildView(mMrzPointsView, false);
        mOcrView = new OcrResultDotsView(this, mRecognizerView.getHostScreenOrientation(), mRecognizerView.getInitialOrientation());
        mRecognizerView.addChildView(mOcrView.getView(), false);

        mCameraOverlayRoot = new FrameLayout(this);
        mCameraOverlayRoot.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mCameraOverlayRoot.addView(createCombinedStepCameraOverlay());
        // camera overlay is rotatable = true
        mRecognizerView.addChildView(mCameraOverlayRoot, true);

        setupMetadataCallbacks();
    }

    private void setupMetadataCallbacks() {
        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        metadataCallbacks.setFailedDetectionCallback(new FailedDetectionCallback() {
            @Override
            public void onDetectionFailed() {
                clearScanIndicatorViews();
            }
        });

        metadataCallbacks.setGlareCallback(new GlareCallback() {
            @Override
            public void onGlare(boolean isGlareDetected) {
                onGlareStatus(isGlareDetected);
            }
        });

        metadataCallbacks.setPointsDetectionCallback(new PointsDetectionCallback() {
            @Override
            public void onPointsDetection(@NonNull DisplayablePointsDetection displayablePointsDetection) {
                mOcrView.addDisplayablePointsDetection(displayablePointsDetection);
                if (mMrzPointsView != null) {
                    // clear MRZ detection points
                    mMrzPointsView.clearDisplayedContent();
                }
            }
        });

        metadataCallbacks.setFirstSideRecognitionCallback(new FirstSideRecognitionCallback() {
            @Override
            public void onFirstSideRecognitionFinished() {
                // prepare UI and activity for the second part/side of the document
                soundNotification();
                mCurrentCombinedSide = CombinedSide.SECOND_SIDE;
                clearScanIndicatorViews();
                reportStepStart(true);
            }
        });
        mRecognizerView.setMetadataCallbacks(metadataCallbacks);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityState = ActivityState.STARTED;
        if (mRecognizerView != null) {
            // all activity lifecycle events must be passed on to RecognizerView
            mRecognizerView.start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityState = ActivityState.RESUMED;
        onGlareStatus(false);
        clearScanIndicatorViews();
        if (mCurrentCombinedSide == CombinedSide.SECOND_SIDE) {
            // when resume() on recognizer view is called, hard reset is called which resets the combined recognizer to scan first
            // side again and appropriate UI changes should be performed if the combined recognizer is not
            // in the initial state
            mCurrentCombinedSide = CombinedSide.FIRST_SIDE;
            initStep(false);
        } else {
            reportStepStart(false);
        }
        if (mRecognizerView != null) {
            // all activity lifecycle events must be passed on to RecognizerView
            mRecognizerView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActivityState = ActivityState.STARTED;
        if (mRecognizerView != null) {
            // all activity lifecycle events must be passed on to RecognizerView
            mRecognizerView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mActivityState = ActivityState.CREATED;
        if (mRecognizerView != null) {
            // all activity lifecycle events must be passed on to RecognizerView
            mRecognizerView.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityState = ActivityState.DESTROYED;
        if (mRecognizerView != null) {
            // all activity lifecycle events must be passed on to RecognizerView
            mRecognizerView.destroy();
        }
        if (mSoundPool != null) {
            try {
                mSoundPool.release();
            } catch (IllegalStateException ignorable) {

            }
            mSoundPool = null;
            mSoundId = -1;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (mRecognizerView == null) {
            return;
        }
        // update recognizer view configuration
        mRecognizerView.changeConfiguration(newConfig);
        // update orientation on OCR result views
        if (mOcrView != null) {
            mOcrView.setHostActivityOrientation(mRecognizerView.getHostScreenOrientation());
        }
        if (mMrzPointsView != null) {
            mMrzPointsView.setHostActivityOrientation(mRecognizerView.getHostScreenOrientation());
        }
    }


    @Override
    public void onCameraPreviewStarted() {
        // pause scanning until the splash screen is cleared
        // splash screen has been shown in onStartCombinedFirstSide or in onStartCombinedSecondSide
        // that has been called before
        pauseScanning();

        if (!mRecognizerView.isCameraTorchSupported()) {
            // if application bar is hidden mIbTorch is used, otherwise
            // menu item mTorchItem is used
            if (mTorchItem != null) {
                mTorchItem.setVisible(false);
            }
            if (mIbTorch != null) {
                mIbTorch.setVisibility(View.INVISIBLE);
            }
        }

        if (mActivityState == ActivityState.RESUMED) {
            mRecognizerView.setMeteringAreas(new RectF[]{new Rectangle(0.33f, 0.33f, 0.33f, 0.33f).toRectF()}, true);
        }

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // clear splash screen and resume scanning (true)
                clearSplashScreen(true);
            }
        }, SPLASH_DURATION_CAMERA_STARTING);
    }

    @Override
    public void onCameraPreviewStopped() {
        // do nothing
    }

    @Override
    public void onError(Throwable ex) {
        String defaultDialogTitle = getString(R.string.mb_warning_title);
        if (ex instanceof CameraResolutionTooSmallException) {
            Log.e(this, ex, "Camera resolution too low!");
            handleError(defaultDialogTitle, getString(R.string.mb_feature_unsupported_device));
        } else if (ex instanceof RecognizerError) {
            Log.e(this, ex, "There was an error starting a native recognizer. Reason: {}", ex.getMessage());
            handleError(defaultDialogTitle, getString(R.string.mb_error_initializing));
        } else if (ex instanceof UnsatisfiedLinkError) {
            Log.e(this, ex, "Native library not loaded!");
            handleError(defaultDialogTitle, getString(R.string.mb_error_initializing));
        } else if (ex instanceof AutoFocusRequiredButNotSupportedException) {
            Log.e(this, ex, "Autofocus required, but not supported!");
            handleError(defaultDialogTitle, getString(R.string.mb_feature_unsupported_autofocus));
        } else if (ex instanceof FeatureNotSupportedException) {
            handleError(defaultDialogTitle, getNotSupportedReasonDescription(((FeatureNotSupportedException) ex).getReason()));
        } else if (ex instanceof SecurityException) {
            Log.e(this, ex, "Camera permission not given!");
            handleError(defaultDialogTitle, getString(R.string.mb_camera_not_allowed));
        } else {
            handleError(defaultDialogTitle, getString(R.string.mb_camera_not_ready));
        }
    }

    private void handleError(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setNeutralButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setResult(RESULT_CANCELED);
                        finish();
                    }

                }).setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String getNotSupportedReasonDescription(NotSupportedReason reason) {
        switch (reason) {
            case CUSTOM_UI_FORBIDDEN:
                return getString(R.string.mb_custom_ui_forbidden);
            case UNSUPPORTED_ANDROID_VERSION:
                return getString(R.string.mb_feature_unsupported_android_version);
            case BLACKLISTED_DEVICE:
            case NO_CAMERA:
            case UNSUPPORTED_PROCESSOR_ARCHITECTURE:
                return getString(R.string.mb_feature_unsupported_device);
        }
        return null;
    }

    @Override
    @TargetApi(23)
    public void onCameraPermissionDenied() {
        // use camera permission manager to ask for camera permission
        mCameraPermissionManager.askForCameraPermission();
    }

    @Override
    @TargetApi(23)
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // use camera permission manager to handle request permission result
        mCameraPermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onAutofocusFailed() {
        clearScanIndicatorViews();
    }

    @Override
    public void onAutofocusStarted(Rect[] focusAreas) {
        // do nothing
    }

    @Override
    public void onAutofocusStopped(Rect[] focusAreas) {
        // do nothing
    }

    /**
     * Clears OCR scan indicator view and MRZ detection points view.
     */
    private void clearScanIndicatorViews() {
        if (mOcrView != null) {
            mOcrView.clearDisplayedContent();
        }
        if (mMrzPointsView != null) {
            mMrzPointsView.clearDisplayedContent();
        }
    }

    @Override
    public void onActivityFlip() {
        if (mRecognizerView != null) {
            if (mOcrView != null) {
                mOcrView.setHostActivityOrientation(mRecognizerView.getHostScreenOrientation());
            }
            if (mMrzPointsView != null) {
                mMrzPointsView.setHostActivityOrientation(mRecognizerView.getHostScreenOrientation());
            }
        }
    }

    @Override
    public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
        if (recognitionSuccessType == RecognitionSuccessType.UNSUCCESSFUL) {
            return;
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onScanDoneWithSuccess();
            }
        });
    }

    @Override
    public void onUnrecoverableError(@NonNull Throwable throwable) {
        Toast.makeText(this, throwable.toString(), Toast.LENGTH_LONG).show();
        finish();
    }

    private void onScanDoneWithSuccess() {
        Recognizer.Result recognizerResult = mRecognizerBundle.getRecognizers()[0].getResult();
        if (recognizerResult instanceof CombinedDataMatchResult) {
            CombinedDataMatchResult combinedDataMatchResult = (CombinedDataMatchResult) recognizerResult;
            if (combinedDataMatchResult.getDocumentDataMatch() != DataMatchResult.Failed) {
                finishWithResults();
            } else {
                // handle case when scanned sides were from different documents
                onDocumentSidesNotMatching();
            }
        }
    }

    private void onDocumentSidesNotMatching() {
        // scan again and show scan again dialog to the user
        pauseScanning();
        new AlertDialog.Builder(this)
                .setTitle(R.string.mb_data_not_match_title)
                .setMessage(R.string.mb_data_not_match_msg)
                .setCancelable(false)
                .setPositiveButton(R.string.mb_data_not_match_retry_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restartVerification();
                        resumeScanning();
                    }
                })
                .create()
                .show();
    }

    /**
     * Finishes the activity (with scan results if scan result listener is not set).
     */
    private void finishWithResults() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        mRecognizerBundle.saveToIntent(intent);
        finish();
    }

    /**
     * Restarts verification flow and clears all previously stored data
     */
    private void restartVerification() {
        if (mCurrentCombinedSide != null) {
            mCurrentCombinedSide = CombinedSide.FIRST_SIDE;
        }
        initStep(true);
    }

    private void initStep(boolean isCameraPreviewStarted) {
        clearScanIndicatorViews();
        mCameraOverlayRoot.removeAllViews();
        mCameraOverlayRoot.addView(createCombinedStepCameraOverlay());

        //RecognitionSettings settings = buildRecognizerBundle();
        reportStepStart(isCameraPreviewStarted);
    }

    private void reportStepStart(boolean isCameraPreviewStarted) {
        switch (mCurrentCombinedSide) {
            case FIRST_SIDE:
                onStartCombinedFirstSide(isCameraPreviewStarted);
                break;
            case SECOND_SIDE:
                onStartCombinedSecondSide(isCameraPreviewStarted);
                break;
        }
    }

    private void soundNotification() {
        if (mSoundPool != null && mSoundId != -1) {
            mSoundPool.play(mSoundId, 1.f, 1.f, 1, 0, 1.f);
        }
    }

    @SuppressWarnings("deprecation")
    private SoundPool createOldSoundPool() {
        return new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
    }

    private void resumeScanning() {
        if (mRecognizerView == null) {
            return;
        }
        if (mCurrentCombinedSide == CombinedSide.SECOND_SIDE) {
            // do not reset the internal state of the combined recognizer because it will scan the first
            // part/side again
            mRecognizerView.resumeScanning(false);
        } else {
            // if first part/side is being scanned, reset internal recognition state
            mRecognizerView.resumeScanning(true);
        }
    }

    private void pauseScanning() {
        if (mRecognizerView != null) {
            mRecognizerView.pauseScanning();
        }
    }

    /**
     * Creates and returns camera overlay view for the combined verification step.
     *
     * @return created camera overlay view.
     */
    @NonNull
    private View createCombinedStepCameraOverlay() {
        View documentOverlay = getLayoutInflater().inflate(R.layout.id_card_camera_overlay, mRecognizerView, false);

        mStatusOverlay = documentOverlay.findViewById(R.id.statusOverlay);
        mGlareMsg = documentOverlay.findViewById(R.id.tvGlareMessage);
        mStatusImage = mStatusOverlay.findViewById(R.id.ivStatusImg);
        mStatusMsg = mStatusOverlay.findViewById(R.id.tvStatusMsg);

        View torchContainer = documentOverlay.findViewById(R.id.torchContainer);
        if (getSupportActionBar() != null) {
            // if action bar is shown, torch button from action bar is used
            torchContainer.setVisibility(View.GONE);
        } else {
            // when action bar is hidden, viewfinder top margin is not needed because
            // torch button layout is used which has appropriate margins
            View viewfinderMargin = documentOverlay.findViewById(R.id.viewfinderMarginTop);
            if (viewfinderMargin != null) {
                viewfinderMargin.setVisibility(View.GONE);
            }
            mIbTorch = torchContainer.findViewById(R.id.torchButton);
            setTorchButtonIcon(mTorchOn);
            mIbTorch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRecognizerView.setTorchState(!mTorchOn, new SuccessCallback() {
                        @Override
                        public void onOperationDone(boolean success) {
                            if (success) {
                                mTorchOn = !mTorchOn;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        setTorchButtonIcon(mTorchOn);
                                    }
                                });
                            }
                        }
                    });
                }
            });
        }

        mDocumentViewfinderManager = new DocumentViewfinderManager(
                (ViewfinderShapeView) documentOverlay.findViewById(R.id.viewfinderRectangle),
                (TextView) documentOverlay.findViewById(R.id.tvCardMessage),
                (ImageView) documentOverlay.findViewById(R.id.ivCardIcon)
        );

        return documentOverlay;
    }

    private void setTorchButtonIcon(final boolean torchOn) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mIbTorch == null) {
                    return;
                }
                if (torchOn) {
                    mIbTorch.setImageResource(R.drawable.mb_ic_flash_on_24dp);
                } else {
                    mIbTorch.setImageResource(R.drawable.mb_ic_flash_off_24dp);
                }
            }
        });
    }

    /**
     * Method that is called when combined recognizer is set to scan first side and recognition
     * is started.
     *
     * @param isCameraPreviewStarted whether camera preview has been already started or not. If the
     *                               camera preview has not been started yet (value is {@code false}),
     *                               method {@link #onCameraPreviewStarted()} will be called when/if
     *                               the camera is successfully started.
     */
    private void onStartCombinedFirstSide(boolean isCameraPreviewStarted) {
        // do not pause scanning if the camera preview has not been started yet because this
        // method can be called multiple times when camera permission is not granted which
        // will cause that scanning will not be properly resumed later (pause is counted)
        if (isCameraPreviewStarted) {
            pauseScanning();
        }
        showDocumentSplashScreen(mSplashMsgDocFirstSide, mSplashIconDocFirstSide);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStatusMsg.setText(getText(mInstructionsDocFirstSide));
                mStatusImage.setImageResource(R.drawable.mb_frontid_white);
                String title = getString(R.string.mb_activity_title_step_front_side);
                setActivityTitle(title);
            }
        });
        if (isCameraPreviewStarted) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clearSplashScreen(true);
                }
            }, SPLASH_DURATION_NEXT_SIDE);
        }
    }

    /**
     * Method that is called when combined recognizer is set to scan second part/side
     * (only if it exists) and recognition is started.
     *
     * @param isCameraPreviewStarted whether camera preview has been already started or not. If the
     *                               camera preview has not been started yet (value is {@code false}),
     *                               method {@link #onCameraPreviewStarted()} will be called when/if
     *                               the camera is successfully started.
     */
    private void onStartCombinedSecondSide(boolean isCameraPreviewStarted) {
        // do not pause scanning if the camera preview has not been started yet because this
        // method can be called multiple times when camera permission is not granted which
        // will cause that scanning will not be properly resumed later (pause is counted)
        if (isCameraPreviewStarted) {
            pauseScanning();
        }
        showDocumentSplashScreen(mSplashMsgDocSecondSide, mSplashIconDocSecondSide);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStatusMsg.setText(getText(mInstructionsDocSecondSide));
                mStatusImage.setImageResource(R.drawable.mb_backid_white);
                String title = getString(R.string.mb_activity_title_step_back_side);
                setActivityTitle(title);
            }
        });
        if (isCameraPreviewStarted) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clearSplashScreen(true);
                }
            }, SPLASH_DURATION_NEXT_SIDE);
        }
    }

    /**
     * Sets the activity title in the action bar.
     *
     * @param title activity title.
     */
    protected void setActivityTitle(String title) {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }
    }

    /**
     * Method that is called during recognition process when/if the glare is detected on the
     * scanned document.
     *
     * @param glareDetected whether glare is detected or not.
     */
    private void onGlareStatus(boolean glareDetected) {
        if (mGlareMsg != null) {
            if (glareDetected) {
                mGlareCountDownTimer.cancel();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mGlareMsg.setVisibility(View.VISIBLE);

                    }
                });
                mGlareCountDownTimer.start();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mTorchItem = menu.add(Menu.NONE, TORCH_ID, Menu.NONE, R.string.mb_light);
        mTorchItem.setIcon(R.drawable.mb_ic_flash_off_24dp);
        mTorchItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        if (id == TORCH_ID) {
            mRecognizerView.setTorchState(!mTorchOn, new SuccessCallback() {
                @Override
                public void onOperationDone(boolean success) {
                    if (success) {
                        mTorchOn = !mTorchOn;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (mTorchOn) {
                                    item.setIcon(R.drawable.mb_ic_flash_on_24dp);
                                } else {
                                    item.setIcon(R.drawable.mb_ic_flash_off_24dp);
                                }
                            }
                        });
                    }
                }
            });
            return true;
        } else if (id == android.R.id.home) {
            setResult(RESULT_CANCELED);
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDocumentSplashScreen(@StringRes int splashMessage, @DrawableRes int splashImageResID) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStatusOverlay.setVisibility(View.INVISIBLE);
            }
        });
        // show splash screen on document viewfinder manager
        if (mDocumentViewfinderManager != null) {
            mDocumentViewfinderManager.showSplashScreen(
                    getString(splashMessage),
                    splashImageResID,
                    R.color.mb_viewfinder_inner_splash
            );
        }
    }

    /**
     * Clears currently shown splash screen and resumes scanning if requested.
     *
     * @param resumeScanning whether resume scanning will be called or not.
     */
    protected void clearSplashScreen(final boolean resumeScanning) {
        if (mDocumentViewfinderManager != null) {
            mDocumentViewfinderManager.clearSplashScreen(0, SPLASH_FADE_ANIMATION_DURATION, new Runnable() {
                @Override
                public void run() {
                    if (mStatusOverlay != null) {
                        mStatusOverlay.setVisibility(View.VISIBLE);
                    }
                    if (resumeScanning) {
                        resumeScanning();
                    }
                }
            });
        }
    }

    /**
     * Timer that is used for implementing minimal duration of the glare message.
     */
    private CountDownTimer mGlareCountDownTimer = new CountDownTimer(GLARE_MESSAGE_DURATION, GLARE_MESSAGE_DURATION) {
        @Override
        public void onTick(long l) {
            // do nothing
        }

        @Override
        public void onFinish() {
            if (mActivityState == ActivityState.RESUMED && mGlareMsg != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mGlareMsg.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }
    };

}
