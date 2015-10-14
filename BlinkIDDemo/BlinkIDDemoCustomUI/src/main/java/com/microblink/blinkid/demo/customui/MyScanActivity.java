package com.microblink.blinkid.demo.customui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.microblink.activity.ScanActivity;
import com.microblink.blinkid.demo.R;
import com.microblink.blinkid.demo.config.Config;
import com.microblink.geometry.Point;
import com.microblink.geometry.Quadrilateral;
import com.microblink.geometry.quadDrawers.IdQuadDrawer;
import com.microblink.geometry.quadTransform.IdQuadTransformer;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.hardware.orientation.OrientationChangeListener;
import com.microblink.locale.LanguageUtils;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.NotSupportedReason;
import com.microblink.view.OnSizeChangedListener;
import com.microblink.view.OrientationAllowedListener;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.recognition.RecognitionType;
import com.microblink.view.recognition.RecognizerView;
import com.microblink.view.recognition.RecognizerViewEventListener;
import com.microblink.view.recognition.ScanResultListener;
import com.microblink.view.viewfinder.QuadView;

import java.util.List;

public class MyScanActivity extends Activity implements ScanResultListener, CameraEventsListener, OnSizeChangedListener, OrientationAllowedListener, RecognizerViewEventListener, OrientationChangeListener {

    public static final String TAG = "MyScanActivity";

    final double mMarginsLandscape[] = new double[]{0.3, 0.3};
    final double mMarginsPortrait[] = new double[]{0.0, 0.6};

    private int mScansDone = 0;
    private Handler mHandler = new Handler();

    /** This is a RecognizerView - it contains camera view and can contain camera overlays */
    RecognizerView mRecognizerView;

    /** This is a back button */
    private Button mBackButton = null;
    /** This is a torch control button */
    private Button mTorchButton = null;
    /** Is torch enabled? */
    private boolean mTorchEnabled = false;
    /** This is a text field that contains status messages */
    private TextView mStatusTextView = null;
    /** This is BlinkID's built-in view that draws detection location */
    private QuadView mQuadView = null;
    /** MediaPlayer will be used for beep sound */
    private MediaPlayer mMediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LanguageUtils.setLanguage(Config.LANGUAGE, this);
        super.onCreate(savedInstanceState);

        // create recognizer view
        mRecognizerView = new RecognizerView(this);

        /*
         * Prepare settings for recognition.
         */
        RecognizerSettings[] settArray = Config.getRecognizerSettings();
        if (settArray != null) {
            mRecognizerView.setRecognitionSettings(settArray);
        }

        /* add license that allows creating custom camera overlay - obtain your key at
         * https://microblink.com/idscan
         */
        try {
            mRecognizerView.setLicenseKey("UF57DWJN-MCIEASQR-3FUVQU2V-WQ2YBMT4-SH4UTH2I-Z6MDB6FO-36NHEV7P-CZYI7I5N"); // demo license key for package com.microblink.blinkid
        } catch (InvalidLicenceKeyException e) {
            e.printStackTrace();
            Log.e(TAG, "Invalid licence key!");
            Toast.makeText(this, "Invalid licence key!", Toast.LENGTH_SHORT).show();
            finish();
        }

        // scan result listener will be notified when scan result gets available
        mRecognizerView.setScanResultListener(this);
        // camera events listener receives events such as when camera preview has started
        // or there was an error while starting the camera
        mRecognizerView.setCameraEventsListener(this);
        // orientation allowed listener is asked if orientation is allowed when device orientation
        // changes - if orientation is allowed, rotatable views will be rotated to that orientation
        mRecognizerView.setOrientationAllowedListener(this);
        // on size changed listener is notified whenever the size of the view is changed (for example
        // when transforming the view from portrait to landscape or vice versa)
        mRecognizerView.setOnSizeChangedListener(this);

        // recognizer view events listener gets notified when recognizer did not detect anything
        // or has detected an object represented with quadrilateral or points of interest
        // it also gets notified when camera cannot perform focusing
        mRecognizerView.setRecognizerViewEventListener(this);
        // orientation change listener is notified when device orientation changes, regardless
        // of underlying activity's configuration settings
        mRecognizerView.setOrientationChangeListener(this);

        // set initial orientation
        if (Config.IS_LANDSCAPE) {
            mRecognizerView.setInitialOrientation(Orientation.ORIENTATION_LANDSCAPE_RIGHT);
        } else {
            mRecognizerView.setInitialOrientation(Orientation.ORIENTATION_PORTRAIT);
        }

        // initialize QuadView
        mQuadView = new QuadView(this, null, new IdQuadDrawer(new IdQuadTransformer(0.45f, Orientation.ORIENTATION_PORTRAIT)), 0.0, 0.6,
               mRecognizerView.getHostScreenOrientation());
        mQuadView.setMovable(Config.VIEWFINDER_MOVEABLE);

        // add quadView to BlinkIdView as non-rotatable (fixed) view
        mRecognizerView.addChildView(mQuadView, false);

        // initialize buttons and status view
        View view = getLayoutInflater().inflate(R.layout.default_photopay_viewfinder, null);

        /** setup back button */
        mBackButton = (Button) view.findViewById(R.id.defaultBackButton);
        mBackButton.setText(getString(R.string.photopayHome));

        mBackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        mTorchButton = (Button) view.findViewById(R.id.defaultTorchButton);
        mTorchButton.setVisibility(View.GONE);

        mStatusTextView = (TextView) view.findViewById(R.id.defaultStatusTextView);
        // hide status text
        mStatusTextView.setVisibility(View.INVISIBLE);

        // you need to pass all activity's lifecycle methods to RecognizerView
        // make sure you've called create after you've set all settings to RecognizerView
        mRecognizerView.create();
        setContentView(mRecognizerView);

        // add buttons and status view as rotatable view to BlinkIdView (it will be rotated even if activity remains in portrait/landscape)
        // allowed orientations are controlled via OrientationAllowedListener
        mRecognizerView.addChildView(view, true);
    }

    @Override
    protected void onResume() {
        LanguageUtils.setLanguage(Config.LANGUAGE, this);
        super.onResume();
        mRecognizerView.resume();
        mMediaPlayer = MediaPlayer.create(this, R.raw.beep);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRecognizerView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRecognizerView.pause();
        if (mMediaPlayer != null) {
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRecognizerView.stop();
    }

    @Override
    protected void onDestroy() {
        mRecognizerView.destroy();
        super.onDestroy();
    }

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
    public void onScanningDone(BaseRecognitionResult[] dataArray, RecognitionType recognitionType) {
        soundNotification();
        mScansDone++;
        if(mScansDone>=3) {
            // after 3 successful scans, return the last result
            Intent resultIntent = new Intent();
            resultIntent.putExtra(ScanActivity.EXTRAS_RECOGNITION_RESULT_LIST, dataArray);
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
    public boolean isOrientationAllowed(Orientation orientation) {
        if (Config.IS_LANDSCAPE) {
            return orientation == Orientation.ORIENTATION_LANDSCAPE_RIGHT
                    || orientation == Orientation.ORIENTATION_LANDSCAPE_LEFT;
        } else {
            return true;
        }
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
        if (mRecognizerView.isCameraTorchSupported() && mTorchButton != null) {
            mTorchButton.setVisibility(View.VISIBLE);
            mTorchButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mRecognizerView.setTorchState(!mTorchEnabled, new SuccessCallback() {
                        @Override
                        public void onOperationDone(final boolean success) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (success) {
                                        mTorchEnabled = !mTorchEnabled;
                                        if (mTorchEnabled) {
                                            mTorchButton.setText(R.string.photopayLightOn);
                                            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lighton, 0, 0, 0);
                                        } else {
                                            mTorchButton.setText(R.string.photopayLightOff);
                                            mTorchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightoff, 0, 0, 0);
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
    public void onStartupError(Throwable throwable) {
        // this method is called if there was an error while starting the camera or recognizer
        handleError();
    }

    @Override
    public void onNotSupported(NotSupportedReason notSupportedReason) {
        // this method is called if scanning is not supported, notSupportedReason describes why
        // scanning is not supported
        handleError();
    }

    @SuppressWarnings("deprecation")
    private void handleError() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.error));
        alertDialog.setMessage(getString(R.string.errorDesc));

        alertDialog.setButton(getString(R.string.photopayOK), new DialogInterface.OnClickListener() {

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
    public void onAutofocusFailed() {
        // this method is called if camera cannot perform autofocus
        // this method is called from background (focusing) thread
        // so make sure you post UI actions on UI thread
        displayText(R.string.AutofocusFail);
    }

    @Override
    public void onAutofocusStarted(Rect[] rects) {
        if(rects == null) {
            Log.i(TAG, "Autofocus started with focusing areas being null");
        } else {
            Log.i(TAG, "Autofocus started");
            for(int i = 0; i < rects.length; ++i) {
                Log.d(TAG, "Focus area: " + rects[i].toString());
            }
        }
    }

    @Override
    public void onAutofocusStopped(Rect[] rects) {
        if(rects == null) {
            Log.i(TAG, "Autofocus stopped with focusing areas being null");
        } else {
            Log.i(TAG, "Autofocus stopped");
            for(int i = 0; i < rects.length; ++i) {
                Log.d(TAG, "Focus area: " + rects[i].toString());
            }
        }
    }

    @Override
    public void onSizeChanged(int width, int height) {
        // this is called whenever size of the BlinkIDView changes
        // we will use this callback in this example to adjust the margins of buttons
        int horizontalMargin = (int) (width * 0.07);
        int verticalMargin = (int) (height * 0.07);
        // set margins for back button
        FrameLayout.LayoutParams backButtonParams = (FrameLayout.LayoutParams) mBackButton.getLayoutParams();
        if (backButtonParams.leftMargin != horizontalMargin && backButtonParams.topMargin != verticalMargin) {
            backButtonParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin);
            mBackButton.setLayoutParams(backButtonParams);
        }
        // set margins for torch button
        FrameLayout.LayoutParams torchButtonParams = (FrameLayout.LayoutParams) mTorchButton.getLayoutParams();
        if (torchButtonParams.leftMargin != horizontalMargin && torchButtonParams.topMargin != verticalMargin) {
            torchButtonParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin);
            mTorchButton.setLayoutParams(torchButtonParams);
        }
        // set margins for text view
        FrameLayout.LayoutParams statusViewParams = (FrameLayout.LayoutParams) mStatusTextView.getLayoutParams();
        if (statusViewParams.bottomMargin != verticalMargin) {
            if (android.os.Build.VERSION.SDK_INT <= 7) {
                statusViewParams.setMargins(0, verticalMargin, 0, verticalMargin);
            } else {
                statusViewParams.setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin);
            }
            mStatusTextView.setLayoutParams(statusViewParams);
        }
    }

    private void displayDetectionStatus(DetectionStatus detectionStatus) {
        if (detectionStatus == DetectionStatus.SUCCESS) {
            displayText(R.string.Processing);
        } else if (detectionStatus == DetectionStatus.FAIL) {
            displayText(R.string.AlignBill);
        } else if (detectionStatus == DetectionStatus.CAMERA_TOO_HIGH) {
            displayText(R.string.CameraTooHigh);
        } else if (detectionStatus == DetectionStatus.PARTIAL_OBJECT) {
            displayText(R.string.PartialSlipDetected);
        }
    }

    @Override
    public void onNothingDetected() {
        // this method is called when recognizer did not detect anything on image
        // this method is called from background (processing) thread
        // so make sure you post UI actions on UI thread
        displayDetectionStatus(DetectionStatus.FAIL);
    }

    @Override
    public void onDisplayPointsOfInterest(List<Point> points, DetectionStatus detectionStatus) {
        // this method is called when recognizer detects an object that is represented by
        // points of interest (e.g. QR code)
        // this method is called from background (processing) thread
        // so make sure you post UI actions on UI thread
    }

    @Override
    public void onDisplayQuadrilateralObject(Quadrilateral quadrilateral, DetectionStatus detectionStatus) {
        // this method is called when recognizer detects an object that is represented by quadrilateral
        // this method is called from background (processing) thread
        // so make sure you post UI actions on UI thread
    }

    @Override
    public void onOrientationChange(Orientation orientation) {
        ((IdQuadTransformer) ((IdQuadDrawer) mQuadView.getQuadDrawer()).getQuadTransformer()).setOrientation(orientation);
        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (orientation.isVertical()) {
                mQuadView.animateToNewDefault(mMarginsPortrait[1], mMarginsPortrait[0]);
            } else {
                mQuadView.animateToNewDefault(mMarginsLandscape[1], mMarginsLandscape[0]);
            }
        } else {
            if (orientation.isVertical()) {
                mQuadView.animateToNewDefault(mMarginsPortrait[0], mMarginsPortrait[1]);
            } else {
                mQuadView.animateToNewDefault(mMarginsLandscape[0], mMarginsLandscape[1]);
            }
        }
    }
}
