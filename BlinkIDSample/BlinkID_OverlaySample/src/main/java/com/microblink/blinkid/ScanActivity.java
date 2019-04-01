package com.microblink.blinkid;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.DocumentOverlayController;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.view.recognition.ScanResultListener;

public class ScanActivity extends AppCompatActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {

    private RecognizerRunnerFragment recognizerRunnerFragment;
    private DocumentOverlayController scanningOverlay;
    private DocumentUISettings uiSettings;

    private ScanResultListener scanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            // pause scanning to prevent new results while activity is being shut down
            recognizerRunnerFragment.getRecognizerRunnerView().pauseScanning();

            Intent intent = new Intent();
            saveResultsToIntent(intent);

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

        uiSettings = new DocumentUISettings(intent);
        scanningOverlay = new DocumentOverlayController(uiSettings, scanResultListener);

        // scanning overlay must be created before restoring fragment state
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_activity);

        ActionBar ab = getActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

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
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }

    @NonNull
    @Override
    public ScanningOverlay getScanningOverlay() {
        return scanningOverlay;
    }

    protected void saveResultsToIntent(@NonNull Intent intent) {
        scanningOverlay.getHighResImagesBundle().saveToIntent(intent);

        RecognizerBundle bundle = uiSettings.getRecognizerBundle();
        if (bundle != null) {
            bundle.saveToIntent(intent);
        }
    }
}
