package com.microblink.menu;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.widget.Toast;

public abstract class ResultHandlerMenuActivity extends BaseMenuActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // onActivityResult is called whenever we are returned from activity started
        // with startActivityForResult. We need to check request code to determine
        // that we have really returned from expected activity.
        if (resultCode == Activity.RESULT_OK && data != null && isScanRequestCode(requestCode)) {
            // set intent's component to ResultActivity and pass its contents
            // to ResultActivity. ResultActivity will show how to extract
            // data from result.
            data.setComponent(new ComponentName(getApplicationContext(), getResultActivityForRequestCode(requestCode)));
            startActivity(data);
        } else {
            // if activity did not return result, user has probably
            // pressed Back button and cancelled scanning
            Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
        }
    }

    protected abstract boolean isScanRequestCode(int code);

    protected abstract Class<?> getResultActivityForRequestCode(int requestCode);

}
