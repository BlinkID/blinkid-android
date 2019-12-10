package com.microblink.blinkid;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.blinkid.demo.R;
import com.microblink.menu.MenuListItem;
import com.microblink.menu.ResultHandlerMenuActivity;
import com.microblink.result.activity.RecognizerBundleResultActivity;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends ResultHandlerMenuActivity {

    public static final int MY_BLINK_ID_REQUEST_CODE = 123;

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean isScanRequestCode(int code) {
        return code == MY_BLINK_ID_REQUEST_CODE;
    }

    @Override
    protected Class<?> getResultActivityForRequestCode(int requestCode) {
        return RecognizerBundleResultActivity.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            finish();
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();
        items.add(new MenuListItem(getString(R.string.scanId), new Runnable() {
            @Override
            public void run() {
                final Intent intent = new Intent(MenuActivity.this, MyScanActivity.class);
                startActivityForResult(intent, MY_BLINK_ID_REQUEST_CODE);
            }
        }));
        return items;
    }

}