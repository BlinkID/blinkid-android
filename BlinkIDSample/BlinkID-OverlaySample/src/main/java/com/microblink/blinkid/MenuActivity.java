package com.microblink.blinkid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.microblink.BaseMenuActivity;
import com.microblink.MenuListItem;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.fragment.overlay.basic.BasicOverlayController;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayController;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.result.ResultActivity;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.view.recognition.ScanResultListener;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends BaseMenuActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {

    private static final int REQUEST_CODE = 137;

    private RecognizerRunnerFragment recognizerRunnerFragment;
    private RecognizerBundle recognizerBundle;
    private BlinkIdOverlayController scanningOverlay;
    private DocumentUISettings uiSettings;

    private ViewGroup parent;
    private View scanLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent = findViewById(android.R.id.content);

        Recognizer recognizer = new MrtdRecognizer();
        ((MrtdRecognizer) recognizer).setReturnFullDocumentImage(true);
        recognizerBundle = new RecognizerBundle(recognizer);

        uiSettings = new DocumentUISettings(recognizerBundle);
        scanningOverlay = uiSettings.createOverlayController(this, scanResultListener);
    }

    @Override
    public void onBackPressed() {
        if (recognizerRunnerFragment != null) {
            finishScanning();
        } else {
            finish();
        }
    }

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

        items.add(buildActivityScanItem());
        items.add(buildFragmentScanItem());

        return items;
    }

    /**
     * Start scanning by using separate activity.
     * @return item in menu list with defined action.
     */
    private MenuListItem buildActivityScanItem() {
        return new MenuListItem(
                "Use Activity",
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MenuActivity.this, ScanActivity.class);
                        // scan activity intent should have prepared ui settings with recognizer
                        // bundle as part of intent extra
                        uiSettings.saveToIntent(intent);
                        startActivityForResult(intent, REQUEST_CODE);
                    }
                }
        );
    }

    /**
     * Start scanning by using fragment on top of current activity instead of using separate activity.
     * @return item in menu list with defined action.
     */
    private MenuListItem buildFragmentScanItem() {
        return new MenuListItem(
                "Use Fragment",
                new Runnable() {
                    @Override
                    public void run() {
                        startScanningWithOverlay();
                    }
                }
        );
    }

    /**
     * Starts scanning with the overlay on {@link RecognizerRunnerFragment}.
     */
    private void startScanningWithOverlay() {
        if (recognizerRunnerFragment == null) {
            scanLayout = LayoutInflater.from(this).inflate(R.layout.fragment_layout, parent, false);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            addContentView(scanLayout, params);

            recognizerRunnerFragment = new RecognizerRunnerFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.recognizer_runner_view_container, recognizerRunnerFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    /**
     * This method is invoked after returning from scan activity. You can obtain
     * scan results here.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            startResultActivity(data);
        }
    }

    /**
     * Starts build-in scan activity for showing scan results.
     * @param data intent populated with scan results.
     */
    private void startResultActivity(Intent data) {
        data.setComponent(new ComponentName(this, ResultActivity.class));
        startActivity(data);
    }

    /**
     *  This method is called when scanning fragment is closed, it removes view for scanning and
     *  sets {@link RecognizerRunnerFragment} to null as a flag that scanning is done.
     */
    private void finishScanning() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                parent.removeView(scanLayout);
            }
        });
        getFragmentManager().popBackStack();
        recognizerRunnerFragment = null;
    }

    @NonNull
    @Override
    public ScanningOverlay getScanningOverlay() {
        return scanningOverlay;
    }


    private ScanResultListener scanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            // pause scanning to prevent new results while finishing scanning
            recognizerRunnerFragment.getRecognizerRunnerView().pauseScanning();

            if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
                // save results to intent
                Intent intent = new Intent();
                // recognizer bundle with results can be saved directly to intent for result activity,
                // since we have access to bundle
                recognizerBundle.saveToIntent(intent);
                startResultActivity(intent);

                finishScanning();
            }
        }
    };
}
