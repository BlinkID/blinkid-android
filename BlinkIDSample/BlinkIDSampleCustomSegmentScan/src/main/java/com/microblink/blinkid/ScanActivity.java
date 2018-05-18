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
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.microblink.entities.parsers.Parser;
import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldElement;
import com.microblink.entities.parsers.date.DateParser;
import com.microblink.entities.parsers.email.EMailParser;
import com.microblink.entities.parsers.raw.RawParser;
import com.microblink.entities.processors.parserGroup.ParserGroupProcessor;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkinput.BlinkInputRecognizer;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.SuccessCallback;
import com.microblink.help.HelpActivity;
import com.microblink.ocr.SlidingTabLayout;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.util.CameraPermissionManager;
import com.microblink.util.Log;
import com.microblink.view.CameraAspectMode;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.microblink.view.recognition.ScanResultListener;


public class ScanActivity extends Activity implements CameraEventsListener, ScanResultListener {

    /** builtin view that controls camera and recognition */
    private RecognizerRunnerView mRecognizerView;
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
    private FieldByFieldElement[] mFieldByFieldElements = createFieldByFieldElements();
    /** Index of selected configuration. */
    private int mSelectedElement = 0;

    /** Processor which is used on the input image, performs the OCR and lets parsers from the
     * group to extract data. In this sample, at any moment only one parser is in the group. */
    private ParserGroupProcessor mParserGroupProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_scan);

        // obtain references to needed member variables
        mRecognizerView = findViewById(R.id.rec_view);
        mFlashButton = findViewById(R.id.btnFlash);
        mResultView = findViewById(R.id.layResult);
        mMessage = findViewById(R.id.txtMessage);
        mResult = findViewById(R.id.txtResult);
        mTitleIndicator = findViewById(R.id.indicator);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SamplePagerAdapter());

        mTitleIndicator = findViewById(R.id.indicator);
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
                mSelectedElement = position;
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

        mRecognizerView.setOptimizeCameraForNearScan(true);

        // initialize BlinkInput recognizer with initial field by field element
        // create BlinkInput recognizer object and add parser to it
        FieldByFieldElement initialScanElement = mFieldByFieldElements[mSelectedElement];

        Parser currentParser = initialScanElement.getParser();
        mParserGroupProcessor = new ParserGroupProcessor(currentParser);
        mRecognizerView.setRecognizerBundle(createRecognizerBundle(mParserGroupProcessor));

        // define the scanning region of the image that will be scanned.
        // You must ensure that scanning region define here is the se as in the layout
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
            ViewGroup vg = findViewById(R.id.custom_segment_scan_root);
            vg.addView(v);
        }

        // all activity's lifecycle methods must be passed to recognizer view
        mRecognizerView.create();

        // update message and title based on selected configuration
        // update of recognizer settings is not needed (flag is set to false)
        updateUI(false);
    }

    private FieldByFieldElement[] createFieldByFieldElements() {
        RawParser rawParser = new RawParser();
        // enable Sieve algorithm which will reuse OCR results from multiple video frames to improve quality
        rawParser.setUseSieve(false);

        return new FieldByFieldElement[] {
                // each scan configuration contains two string resource IDs:
                // string shown in title bar and string shown in text field above scan box
                new FieldByFieldElement(R.string.date_title, R.string.date_msg, new DateParser()),
                new FieldByFieldElement(R.string.email_title, R.string.email_msg, new EMailParser()),
                new FieldByFieldElement(R.string.raw_title, R.string.raw_msg, rawParser)
        };
    }

    private RecognizerBundle createRecognizerBundle(ParserGroupProcessor parserGroupProcessor) {
        // Recognizer which is used for scanning, uses prepared parser group for performing OCR and
        // and active parser from the group for parsing the OCR result
        BlinkInputRecognizer blinkInputRecognizer = new BlinkInputRecognizer(parserGroupProcessor);
        return new RecognizerBundle(blinkInputRecognizer);
    }

    /**
     * Updates user interface based on currently selected configuration. Also updates the
     * recognizers configuration if {@code updateRecognizerSettings} is set to {@code true}.
     * @param updateRecognizerSettings Indicates whether the recognizers reconfiguration
     *                                 will be performed, based on current settings.
     */
    private void updateUI(boolean updateRecognizerSettings) {
        mMessage.setText(mFieldByFieldElements[mSelectedElement].getTextResource());
        mTitleIndicator.getViewPager().setCurrentItem(mSelectedElement);

        if (updateRecognizerSettings) {
            FieldByFieldElement scanElement = mFieldByFieldElements[mSelectedElement];
            Parser currentParser = scanElement.getParser();
            mParserGroupProcessor = new ParserGroupProcessor(currentParser);
            // unlike setRecognitionSettings that needs to be set before calling create, reconfigureRecognizers is designed
            // to be called while recognizer is active.
            mRecognizerView.reconfigureRecognizers(createRecognizerBundle(mParserGroupProcessor));
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
    public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
        if (recognitionSuccessType == RecognitionSuccessType.UNSUCCESSFUL) {
            // ignore event if nothing has been scanned
            return;
        }
        FieldByFieldElement scanElement = mFieldByFieldElements[mSelectedElement];

        // obtain result of the currently active parser
        Parser.Result<?> parserResult = scanElement.getParser().getResult();

        if (parserResult.getResultState() == Parser.Result.State.Valid) {
            final String resultString = parserResult.toString().trim();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mResult.setText(resultString);
                    mResultView.setVisibility(View.VISIBLE);
                }
            });
            // additionally if you want to process raw OCR result instead of parsed strings, and
            // your license key allows obtaining of the OCR result, you can obtain it like this:
            //  OcrResult ocrResult = mParserGroupProcessor.getResult().getOcrResult();
        }

        // Finally, scanning will be resumed automatically and will reuse
        // results from previous scan to make current scan of better quality.
        // Note that preserving state preserves state of all
        // recognizers, including barcode recognizers (if enabled).
        // If you want to reset internal state call:
        // mRecognizerRunnerView.resetRecognitionState();
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
        mSelectedElement = (mSelectedElement + 1) % mFieldByFieldElements.length;

        mResultView.setVisibility(View.INVISIBLE);
        updateUI(true);
    }

    private class SamplePagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return mFieldByFieldElements.length;
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
            return getResources().getString(mFieldByFieldElements[position].getTitleResource());
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
