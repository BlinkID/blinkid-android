package com.microblink;

import android.app.Application;
import android.widget.Toast;

import com.microblink.intent.IntentDataTransferMode;
import com.microblink.result.extract.BaseResultExtractorFactory;
import com.microblink.result.extract.ResultExtractorFactoryProvider;
import com.microblink.util.Log;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

public abstract class SampleApplication extends Application {

    private static boolean isRecognitionSupported = true;

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
            Toast.makeText(this, "Recognition is supported only in DirectAPI mode!", Toast.LENGTH_SHORT).show();
            Log.w(this, "Recognition is supported only in DirectAPI mode!");
        } else {
            isRecognitionSupported = false;
            Toast.makeText(this, "Recognition is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
            Log.e(this, "Recognition is not supported! Reason: {}", supportStatus.name());
        }

        if (isRecognitionSupported) {
            MicroblinkSDK.setLicenseFile(getLicenceFilePath(), this);
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
