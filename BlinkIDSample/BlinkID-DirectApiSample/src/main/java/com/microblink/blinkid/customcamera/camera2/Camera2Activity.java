package com.microblink.blinkid.customcamera.camera2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;

import com.microblink.blinkid.demo.R;

@TargetApi(21)
public class Camera2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);
        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2Fragment.newInstance())
                    .commit();
        }
    }
}
