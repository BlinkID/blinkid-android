package com.microblink.blinkid;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.fragment.overlay.basic.BasicOverlayController;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.view.recognition.ScanResultListener;

public class ScanActivity extends AppCompatActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {

    private RecognizerRunnerFragment recognizerRunnerFragment;
    private BasicOverlayController scanningOverlay;
    private DocumentUISettings uiSettings;

    private ScanResultListener scanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            // pause scanning to prevent new results while activity is being shut down
            recognizerRunnerFragment.getRecognizerRunnerView().pauseScanning();

            Intent intent = new Intent();
            saveResultsToIntent(intent);

            // set result before finish scan activity
            switch (recognitionSuccessType) {
                case SUCCESSFUL:
                    setResult(RESULT_OK, intent);
                    break;
                case UNSUCCESSFUL:
                    setResult(RESULT_CANCELED);
                    break;
                case PARTIAL:
                    setResult(RESULT_OK, intent);
                    break;
            }

            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();

        // DocumentUISettings object is expected in intent
        uiSettings = new DocumentUISettings(intent);
        scanningOverlay = new BasicOverlayController(uiSettings.toOverlaySettings(this), scanResultListener);

        // scanning overlay must be created before restoring fragment state
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_activity);

        if (null == savedInstanceState) {
            // create fragment transaction to replace R.id.recognizer_runner_view_container with RecognizerRunnerFragment
            recognizerRunnerFragment = new RecognizerRunnerFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(com.microblink.library.R.id.recognizer_runner_view_container, recognizerRunnerFragment);
            fragmentTransaction.commit();
        } else {
            // obtain reference to fragment restored by Android within super.onCreate() call
            recognizerRunnerFragment = (RecognizerRunnerFragment) getFragmentManager().findFragmentById(R.id.recognizer_runner_view_container);
        }

    }

    @Override
    public void onBackPressed() {
        // user cancels scanning by pressing back button
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }

    @NonNull
    @Override
    public ScanningOverlay getScanningOverlay() {
        return scanningOverlay;
    }

    /**
     * Save scanning results from the bundle in intent for later usage.
     * @param intent intent in which scan results will be saved.
     */
    private void saveResultsToIntent(@NonNull Intent intent) {
        // save HighResImagesBundle, for cases when high res frames are enabled in ui settings
        scanningOverlay.getHighResImagesBundle().saveToIntent(intent);

        // save recognizer bundle to make it available for loading later
        uiSettings.getRecognizerBundle().saveToIntent(intent);
    }
}
