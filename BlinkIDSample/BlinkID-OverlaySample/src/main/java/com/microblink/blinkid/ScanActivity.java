package com.microblink.blinkid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.blinkid.entities.recognizers.RecognizerBundle;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.fragment.RecognizerRunnerFragment;
import com.microblink.blinkid.fragment.overlay.ScanningOverlay;
import com.microblink.blinkid.fragment.overlay.blinkid.BlinkIdOverlayController;
import com.microblink.blinkid.recognition.RecognitionSuccessType;
import com.microblink.blinkid.view.recognition.ScanResultListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ScanActivity extends AppCompatActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {

    private RecognizerRunnerFragment recognizerRunnerFragment;
    private BlinkIdOverlayController overlayController;
    private RecognizerBundle recognizerBundle;

    private ScanResultListener scanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            // pause scanning to prevent new results while activity is being shut down
            recognizerRunnerFragment.getRecognizerRunnerView().pauseScanning();

            Intent intent = new Intent();

            // save recognizer bundle to make it available for loading later
            recognizerBundle.saveToIntent(intent);

            // save HighResImagesBundle, for cases when high res frames are enabled
            overlayController.getHighResImagesBundle().saveToIntent(intent);

            // set result before finish scan activity
            switch (recognitionSuccessType) {
                case SUCCESSFUL:
                case PARTIAL:
                    setResult(RESULT_OK, intent);
                    break;
                case UNSUCCESSFUL:
                    setResult(RESULT_CANCELED);
                    break;
            }

            finish();
        }

        @Override
        public void onUnrecoverableError(@NonNull Throwable throwable) {
            Toast.makeText(ScanActivity.this, throwable.toString(), Toast.LENGTH_LONG).show();
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // setup recognizer and put it into recognizer bundle
        BlinkIdMultiSideRecognizer recognizer = new BlinkIdMultiSideRecognizer();
        recognizer.setReturnFullDocumentImage(true);
        recognizer.setReturnFaceImage(true);
        recognizerBundle = new RecognizerBundle(recognizer);

        overlayController = BlinkIdOverlayControllerBuilder.build(this, recognizerBundle, scanResultListener);

        // scanning overlay must be created before restoring fragment state
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_activity);

        if (null == savedInstanceState) {
            // create fragment transaction to replace R.id.recognizer_runner_view_container with RecognizerRunnerFragment
            recognizerRunnerFragment = new RecognizerRunnerFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(com.microblink.blinkid.library.R.id.recognizer_runner_view_container, recognizerRunnerFragment);
            fragmentTransaction.commit();
        } else {
            // obtain reference to fragment restored by Android within super.onCreate() call
            recognizerRunnerFragment = (RecognizerRunnerFragment) getSupportFragmentManager().findFragmentById(R.id.recognizer_runner_view_container);
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
        return overlayController;
    }

}
