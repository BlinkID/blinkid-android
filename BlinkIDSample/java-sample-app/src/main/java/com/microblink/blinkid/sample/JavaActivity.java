package com.microblink.blinkid.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.microblink.blinkid.core.BlinkIdSdkSettings;
import com.microblink.blinkid.ux.activity.BlinkIdScanActivity;
import com.microblink.blinkid.ux.contract.BlinkIdScanActivityResult;
import com.microblink.blinkid.ux.contract.BlinkIdScanActivitySettings;
import com.microblink.blinkid.ux.contract.MbBlinkIdScan;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String licenseKey = "sRwCAB1jb20ubWljcm9ibGluay5ibGlua2lkLnNhbXBsZQBsZXlKRGNtVmhkR1ZrVDI0aU9qRTNOREU0T0RBME9UVTBPRE1zSWtOeVpXRjBaV1JHYjNJaU9pSmtaR1F3TmpabFppMDFPREl6TFRRd01EZ3RPVFE0TUMwMU5EVTRZakF4WVRVMllqZ2lmUT09itFq81+BsXnPNx0/n2rf2kwiIQOLqbsCQB6gmKLNoCVHc8KwvGtkduMoga0UFeWF2YLmXKc+PmeqU8Ax6+3MmuIWeZhzBYngmhERJF1p5avA0arq4HmYVJZwSfnw";
        BlinkIdSdkSettings sdkSettings = new BlinkIdSdkSettings(licenseKey);
        BlinkIdScanActivitySettings activitySettings = new BlinkIdScanActivitySettings(sdkSettings);

        ActivityResultLauncher<BlinkIdScanActivitySettings> resultLauncher = registerForActivityResult(
                new MbBlinkIdScan(),
                result -> {
                    // handle result here
                }
        );

        findViewById(R.id.button).setOnClickListener(v -> {
            resultLauncher.launch(activitySettings);
        });
    }
}