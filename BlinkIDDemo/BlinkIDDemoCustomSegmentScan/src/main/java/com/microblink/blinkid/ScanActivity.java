package com.microblink.blinkid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.microblink.Config;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.SuccessCallback;
import com.microblink.help.HelpActivity;
import com.microblink.ocr.ScanConfiguration;
import com.microblink.ocr.SlidingTabLayout;
import com.microblink.recognition.InvalidLicenceKeyException;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.recognizers.blinkocr.BlinkOCRRecognitionResult;
import com.microblink.recognizers.blinkocr.BlinkOCRRecognizerSettings;
import com.microblink.recognizers.settings.RecognitionSettings;
import com.microblink.recognizers.settings.RecognizerSettings;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.recognition.RecognizerView;
import com.microblink.view.recognition.ScanResultListener;


public class ScanActivity extends Activity implements CameraEventsListener, ScanResultListener {

    /** RecognizerView is the builtin view that controls camera and recognition */
    private RecognizerView mRecognizerView;
    /** CameraPermissionManager is provided helper class that can be used to obtain the permission to use camera.
     * It is used on Android 6.0 (API level 23) or newer.
     */
    private CameraPermissionManager mCameraPermissionManager;
    /** Button that controls flashlight state. */
    private ImageButton mFlashButton;
    /** View which holds scan result. */
    private View mResultView;
    /** Shows scan result string. */
    private EditText mResult;
    /** Flashlight state. */
    private boolean mTorchOn = false;
    /** Shows the message of current scan configuration to user. */
    private TextView mMessage;
    /** Shows the title of current scan configuration to user. */
    private SlidingTabLayout mTitleIndicator;
    /** Array of scan configurations. */
    private ScanConfiguration[] mConfiguration = Configurator.createScanConfigurations();
    /** Index of selected configuration. */
    private int mSelectedConfiguration = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scan);

        // obtain references to needed member variables
        mRecognizerView = (RecognizerView) findViewById(R.id.rec_view);
        mFlashButton = (ImageButton) findViewById(R.id.btnFlash);
        mResultView = findViewById(R.id.layResult);
        mMessage = (TextView) findViewById(R.id.txtMessage);
        mResult = (EditText) findViewById(R.id.txtResult);
        mTitleIndicator = (SlidingTabLayout) findViewById(R.id.indicator);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SamplePagerAdapter());

        mTitleIndicator = (SlidingTabLayout) findViewById(R.id.indicator);
        mTitleIndicator.setViewPager(viewPager);

        // set ViewPager.OnPageChangeListener to enable the layout
        // to update it's scroll position correctly
        mTitleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // update currently selected configuration
                mSelectedConfiguration = position;
                // hide previous result
                mResultView.setVisibility(View.INVISIBLE);
                // update message and title based on selected configuration
                // and update recognizer settings (flag is set to true)
                updateUI(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // camera events listener is required as it will receive camera-related events
        // such as startup errors, autofocus callbacks etc.
        mRecognizerView.setCameraEventsListener(this);
        // scan result listener is requires as it will receive recognition results
        mRecognizerView.setScanResultListener(this);
        // we want camera to use whole available view space by cropping the camera preview
        // instead of letterboxing it
        mRecognizerView.setAspectMode(CameraAspectMode.ASPECT_FILL);

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
            mRecognizerView.setLicenseKey(Config.LICENSE_KEY);
        } catch (InvalidLicenceKeyException e) {
            e.printStackTrace();
            Toast.makeText(this, "Invalid license key!", Toast.LENGTH_SHORT).show();
            finish();
        }
        mRecognizerView.setOptimizeCameraForNearScan(true);

        // initialize BlinkOCR recognizer with currently selected parser
        // create BlinkOCR recognizer settings object and add parser to it
        BlinkOCRRecognizerSettings ocrSett = new BlinkOCRRecognizerSettings();
        ocrSett.addParser(mConfiguration[mSelectedConfiguration].getParserName(),
                mConfiguration[mSelectedConfiguration].getParserSettings());

        // prepare the recognition settings
        RecognitionSettings recognitionSettings = new RecognitionSettings();
        // add BlinkOCR recognizer settings object to recognizer settings array
        // BlinkOCR recognizer will be used in the recognition process
        recognitionSettings.setRecognizerSettingsArray(new RecognizerSettings[]{ocrSett});

        mRecognizerView.setRecognitionSettings(recognitionSettings);

        // define the scanning region of the image that will be scanned.
        // You must ensure that scanning region define here is the same as in the layout
        // The coordinates for scanning region are relative to recognizer view:
        // the following means: rectangle starts at 10% of recognizer view's width and
        // 34% of its height. Rectangle width is 80% of recognizer view's width and
        // 13% of its height.
        // If you do not set this, OCR will be performed on full camera frame and this
        // will result in very poor performance.
        mRecognizerView.setScanningRegion(new Rectangle(0.1f, 0.34f, 0.8f, 0.13f), false);

        // instantiate the camera permission manager
        mCameraPermissionManager = new CameraPermissionManager(this);
        // get the built in layout that should be displayed when camera permission is not given
        View v = mCameraPermissionManager.getAskPermissionOverlay();
        if (v != null) {
            // add it to the current layout that contains the recognizer view
            ViewGroup vg = (ViewGroup) findViewById(R.id.custom_segment_scan_root);
            vg.addView(v);
        }

        // all activity's lifecycle methods must be passed to recognizer view
        mRecognizerView.create();

        // update message and title based on selected configuration
        // update of recognizer settings is not needed (flag is set to false)
        updateUI(false);
    }



    /**
     * Updates user interface based on currently selected configuration. Also updates the
     * recognizers configuration if {@code updateRecognizerSettings} is set to {@code true}.
     * @param updateRecognizerSettings Indicates whether the recognizers reconfiguration
     *                                 will be performed, based on current settings.
     */
    private void updateUI(boolean updateRecognizerSettings) {
        mMessage.setText(mConfiguration[mSelectedConfiguration].getTextResource());

        mTitleIndicator.getViewPager().setCurrentItem(mSelectedConfiguration);

        if(updateRecognizerSettings) {
            RecognitionSettings recognitionSettings = new RecognitionSettings();

            BlinkOCRRecognizerSettings ocrSett = new BlinkOCRRecognizerSettings();
            ocrSett.addParser(mConfiguration[mSelectedConfiguration].getParserName(),
                    mConfiguration[mSelectedConfiguration].getParserSettings());

            recognitionSettings.setRecognizerSettingsArray(new RecognizerSettings[]{ocrSett});

            // unlike setRecognitionSettings that needs to be set before calling create,
            // reconfigureRecognizers is designed to be called while recognizer is active.
            mRecognizerView.reconfigureRecognizers(recognitionSettings);
        }
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
        // this method is called when camera preview has started
        // camera is being initialized in background thread and when
        // it is ready, this method is called.
        // You can use it to check camera properties, such as whether
        // torch is supported and then show/hide torch button.
        if (mRecognizerView != null && mRecognizerView.isCameraTorchSupported()) {
            mFlashButton.setVisibility(View.VISIBLE);
            mFlashButton.setImageResource(R.drawable.flashlight);
            mTorchOn = false;
        }

        // after camera is started, we can set the metering area for autofocus, white balance
        // and auto exposure measurements
        // we set the same rectangle as for scanning region
        // we also define that this metering area will follow device orientation changes
        mRecognizerView.setMeteringAreas(new RectF[] {new RectF(0.1f, 0.34f, 0.1f + 0.8f, 0.34f + 0.13f)}, true);
    }

    @Override
    public void onCameraPreviewStopped() {
        // this method is called when camera preview has stopped
    }

    @Override
    public void onError(Throwable ex) {
        // This method will be called when opening of camera resulted in exception or
        // recognition process encountered an error.
        // The error details will be given in exc parameter.
        Log.e(this, ex, "Error");
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setCancelable(false)
                .setTitle("Error")
                .setMessage(ex.getMessage())
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(dialog != null) dialog.dismiss();
                        finish();
                    }
                }).create().show();
        finish();
    }

    @Override
    public void onAutofocusFailed() {
        // This method is called when camera focusing has failed.
        // You should inform user to try scanning under different light.
    }

    @Override
    public void onAutofocusStarted(Rect[] focusAreas) {
        // This method is called when camera starts focusing.
        // Focus areas is array of rectangles that camera uses
        // as focus measure regions.
    }

    @Override
    public void onAutofocusStopped(Rect[] focusAreas) {
        // This method is called when camera finishes focusing.
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
    public void onScanningDone(RecognitionResults results) {
        BaseRecognitionResult[] dataArray = results.getRecognitionResults();
        // we've enabled only one recognizer, so we expect only one element in dataArray
        if (dataArray != null && dataArray.length == 1) {
            if (dataArray[0] instanceof BlinkOCRRecognitionResult) {
                BlinkOCRRecognitionResult result = (BlinkOCRRecognitionResult) dataArray[0];
                String scanned = result.getParsedResult(mConfiguration[mSelectedConfiguration].getParserName());
                if(scanned != null && !scanned.isEmpty()) {
                    mResult.setText(scanned);
                    mResultView.setVisibility(View.VISIBLE);
                }
                // additionally if you want to process raw OCR result of default parser group
                // instead of parsed strings you can obtain it like this
                // OcrResult ocrResult = result.getOcrResult();

                // to obtain raw OCR result for certain parser group, give a name of the parser
                // group to getOcrResult method
            }
        }
    }

    public void onBtnExitClicked(View v) {
        finish();
    }

    public void onBtnHelpClicked(View v) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void onBtnFlashClicked(View v) {
        mRecognizerView.setTorchState(!mTorchOn, new SuccessCallback() {
            @Override
            public void onOperationDone(boolean success) {
                if (success) {
                    mTorchOn = !mTorchOn;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mTorchOn) {
                                mFlashButton.setImageResource(R.drawable.flashlight_inverse);
                            } else {
                                mFlashButton.setImageResource(R.drawable.flashlight);
                            }
                        }
                    });
                }
            }
        });
    }

    public void onBtnAcceptClicked(View v) {
        // do something with data from mResult
        mSelectedConfiguration = (mSelectedConfiguration + 1) % mConfiguration.length;

        mResultView.setVisibility(View.INVISIBLE);
        updateUI(true);
    }

    private class SamplePagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return mConfiguration.length;
        }

        /**
         * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
         * same object as the {@link View} added to the {@link ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * <p>
         * Here we construct one using the position value, but for real application the title should
         * refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getString(mConfiguration[position].getTitleResource());
        }
        /**
         * Instantiate the {@link View} which should be displayed at {@code position}. Here we
         * inflate a layout from the apps resources and then change the text view to signify the position.
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return new View(ScanActivity.this);
        }

        /**
         * Destroy the item from the {@link ViewPager}. In our case this is simply removing the
         * {@link View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
