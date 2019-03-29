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
import com.microblink.fragment.RecognizerRunnerFragment;
import com.microblink.fragment.overlay.DocumentOverlayController;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.result.ResultActivity;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.view.recognition.ScanResultListener;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends BaseMenuActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {

    private RecognizerRunnerFragment recognizerRunnerFragment;
    private DocumentOverlayController overlayController;

    private ScanResultListener scanResultListener = new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
                showResult(ScanUtil.extractResult());
                finishScanning();
            }
        }
    };

    private ViewGroup parent;
    private View scanLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent = findViewById(android.R.id.content);
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

        items.add(buildRecognizer());
        items.add(buildFragmentRecognizer());

        return items;
    }

    private MenuListItem buildRecognizer() {
        return new MenuListItem(
                "Use Activity",
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MenuActivity.this, ScanActivity.class);
                        startActivityForResult(intent, ScanUtil.REQUEST_CODE);
                    }
                }
        );
    }

    private MenuListItem buildFragmentRecognizer() {
        return new MenuListItem(
                "Use Fragment",
                new Runnable() {
                    @Override
                    public void run() {
                        DocumentUISettings uiSettings = ScanUtil.createUISettings();
                        overlayController = ScanUtil.createOverlayController(uiSettings, scanResultListener);
                        startScanningWithOverlay();
                    }
                }
        );
    }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == Activity.RESULT_OK && requestCode == ScanUtil.REQUEST_CODE) {
            showResult(data);
        }
    }

    private void showResult(Intent data) {
        data.setComponent(new ComponentName(this, ResultActivity.class));
        startActivity(data);
    }

    private void finishScanning() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                parent.removeView(scanLayout);
            }
        });

        recognizerRunnerFragment = null;
    }

    @NonNull
    @Override
    public ScanningOverlay getScanningOverlay() {
        return overlayController;
    }
}
