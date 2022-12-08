package com.microblink.blinkid;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.microblink.blinkid.activity.result.ResultStatus;
import com.microblink.blinkid.activity.result.contract.TwoSideDocumentScan;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onScanButtonClick(View view) {
        // start scan activity
        blinkIdScanLauncher.launch(null);
    }

    private final ActivityResultLauncher<Void> blinkIdScanLauncher = registerForActivityResult(
            new TwoSideDocumentScan(), result -> {
                if (result.getResultStatus() == ResultStatus.FINISHED) {
                    // OK result code means scan was successful
                    onScanSuccess(result.getResult());
                } else if (result.getResultStatus() == ResultStatus.EXCEPTION) {
                    Toast.makeText(this, result.getException().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    // user probably pressed Back button and cancelled scanning
                    Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
                }
            }

    );

    private void onScanSuccess(BlinkIdMultiSideRecognizer.Result result) {
        String name = result.getFirstName().value();
        Toast.makeText(this, "Name: " + name, Toast.LENGTH_LONG).show();
    }
}
