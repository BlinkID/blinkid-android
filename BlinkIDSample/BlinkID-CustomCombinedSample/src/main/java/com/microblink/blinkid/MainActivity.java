package com.microblink.blinkid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.microblink.blinkid.entities.recognizers.Recognizer;
import com.microblink.blinkid.entities.recognizers.RecognizerBundle;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.blinkid.hardware.camera.CameraType;
import com.microblink.blinkid.menu.MenuListItem;
import com.microblink.blinkid.menu.ResultHandlerMenuActivity;
import com.microblink.blinkid.result.activity.RecognizerBundleResultActivity;
import com.microblink.util.ImageSettings;
import com.microblink.blinkid.util.RecognizerCompatibility;
import com.microblink.blinkid.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ResultHandlerMenuActivity {

    public static final int MY_BLINKID_REQUEST_CODE = 0x101;
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean isScanRequestCode(int code) {
        return code == MY_BLINKID_REQUEST_CODE;
    }

    @Override
    protected Class<?> getResultActivityForRequestCode(int requestCode) {
        return RecognizerBundleResultActivity.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

        items.add(createMenuListItem("BlinkID Multi Side", ImageSettings.enableAllImages(new BlinkIdMultiSideRecognizer())));
        items.add(createMenuListItem("MRTD combined", ImageSettings.enableAllImages(new MrtdCombinedRecognizer())));
        items.add(createMenuListItem("US / Canada DL combined", ImageSettings.enableAllImages(new UsdlCombinedRecognizer())));

        return items;
    }

    private MenuListItem createMenuListItem(String title, final Recognizer recognizer) {
        return new MenuListItem(title, new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, CustomVerificationFlowActivity.class);
                mRecognizerBundle = new RecognizerBundle(recognizer);
                mRecognizerBundle.saveToIntent(intent);
                intent.putExtra(CustomVerificationFlowActivity.EXTRAS_BEEP_RESOURCE, R.raw.beep);
                intent.putExtra(CustomVerificationFlowActivity.EXTRAS_COMBINED_CAMERA_TYPE, (Parcelable) CameraType.CAMERA_BACKFACE);
                startActivityForResult(intent, MY_BLINKID_REQUEST_CODE);
            }
        });
    }

}
