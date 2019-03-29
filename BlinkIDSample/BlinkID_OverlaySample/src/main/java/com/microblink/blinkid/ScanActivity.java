package com.microblink.blinkid;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.DocumentOverlayController;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.view.recognition.ScanResultListener;

public class ScanActivity extends AppCompatActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {

    private DocumentOverlayController overlayController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        DocumentUISettings uiSettings = ScanUtil.createUISettings();
        ScanResultListener scanResultListener = new ScanResultListener() {
            @Override
            public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
                if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
                    setResult(Activity.RESULT_OK, ScanUtil.extractResult());
                    finish();
                }
            }
        };
        overlayController = ScanUtil.createOverlayController(uiSettings, scanResultListener);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mb_activity_scan);

        ActionBar ab = getActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        RecognizerRunnerFragment recognizerRunnerFragment;
        if (null == savedInstanceState) {
            recognizerRunnerFragment = new RecognizerRunnerFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(com.microblink.library.R.id.recognizer_runner_view_container, recognizerRunnerFragment);
            fragmentTransaction.commit();
        } else {
            recognizerRunnerFragment = (RecognizerRunnerFragment) getFragmentManager().findFragmentById(com.microblink.library.R.id.recognizer_runner_view_container);
        }

    }

    @NonNull
    @Override
    public ScanningOverlay getScanningOverlay() {
        return overlayController;
    }
}
