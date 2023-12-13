package com.microblink.blinkid.help;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.locale.LanguageUtils;

public class HelpActivity extends FragmentActivity {

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LanguageUtils.setLanguageConfiguration(getResources());
    }

}
