package com.microblink.blinkid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.microblink.activity.result.ScanResult;
import com.microblink.activity.result.contract.MbScan;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.uisettings.BlinkIdUISettings;
import com.microblink.uisettings.UISettings;

public class MainActivity extends AppCompatActivity {

    private BlinkIdCombinedRecognizer recognizer;
    private RecognizerBundle recognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we'll use Machine Readable Travel Document recognizer
        recognizer = new BlinkIdCombinedRecognizer();

        // put our recognizer in bundle so that it can be sent via intent
        recognizerBundle = new RecognizerBundle(recognizer);
    }

    public void onScanButtonClick(View view) {
        // use default UI for scanning documents
        BlinkIdUISettings uiSettings = new BlinkIdUISettings(recognizerBundle);

        // start scan activity based on UI settings
        blinkIdScanLauncher.launch(uiSettings);
    }

    private final ActivityResultLauncher<UISettings> blinkIdScanLauncher = registerForActivityResult(
            new MbScan(),
            result -> {
                if (result.getResultStatus() == ScanResult.ResultStatus.FINISHED) {
                    // OK result code means scan was successful
                    onScanSuccess(result.getData());
                } else if (result.getResultStatus() == ScanResult.ResultStatus.EXCEPTION) {
                    Toast.makeText(this, result.getException().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    // user probably pressed Back button and cancelled scanning
                    onScanCanceled();
                }
            }

    );

    private void onScanSuccess(Intent data) {
        // update recognizer results with scanned data
        recognizerBundle.loadFromIntent(data);

        // you can now extract any scanned data from result, we'll just get primary id
        BlinkIdCombinedRecognizer.Result result = recognizer.getResult();
        String name = result.getFullName();
        if (name.isEmpty()) {
            name = result.getFirstName();
        }
        Toast.makeText(this, "Name: " + name, Toast.LENGTH_LONG).show();
    }

    private void onScanCanceled() {
        Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
    }

}
