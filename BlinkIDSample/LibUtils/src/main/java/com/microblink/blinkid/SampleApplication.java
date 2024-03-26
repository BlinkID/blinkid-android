package com.microblink.blinkid;

import android.app.Application;
import android.widget.Toast;

import com.microblink.blinkid.intent.IntentDataTransferMode;
import com.microblink.blinkid.result.extract.BaseResultExtractorFactory;
import com.microblink.blinkid.result.extract.ResultExtractorFactoryProvider;
import com.microblink.blinkid.util.Log;
import com.microblink.blinkid.util.RecognizerCompatibility;
import com.microblink.blinkid.util.RecognizerCompatibilityStatus;

public abstract class SampleApplication extends Application {

    protected static boolean isRecognitionSupported = true;

    public static boolean isRecognitionSupported() {
        return isRecognitionSupported;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus == RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Log.i(this, "Recognition is supported!");
        } else if (supportStatus == RecognizerCompatibilityStatus.NO_CAMERA) {
            Toast.makeText(this, "Recognition is supported only in Direct API mode!", Toast.LENGTH_SHORT).show();
            Log.w(this, "Recognition is supported only in Direct API mode!");
        } else {
            isRecognitionSupported = false;
            Toast.makeText(this, "Recognition is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
            Log.e(this, "Recognition is not supported! Reason: {}", supportStatus.name());
        }

        if (isRecognitionSupported) {
            String licenseFilePath = getLicenceFilePath();
            if (licenseFilePath != null) {
                MicroblinkSDK.setLicenseFile(licenseFilePath, this);
            }
            MicroblinkSDK.setIntentDataTransferMode(IntentDataTransferMode.PERSISTED_OPTIMISED);
        }

        ResultExtractorFactoryProvider.set(createResultExtractorFactory());

        // in case of problems with the SDK (crashes or ANRs, uncomment following line to enable
        // verbose logging that can help developers track down the problem)
        //Log.setLogLevel(Log.LogLevel.LOG_VERBOSE);
    }

    protected abstract BaseResultExtractorFactory createResultExtractorFactory();

    protected abstract String getLicenceFilePath();

}
