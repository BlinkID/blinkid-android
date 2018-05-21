package com.microblink.help;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.microblink.help.adapters.BlinkOCRAdapter;
import com.microblink.help.pageindicator.UnderlinePageIndicator;
import com.microblink.locale.LanguageUtils;
import com.microblink.libresult.R;

/**
 * Activity responsible for showing help screens.
 *
 * @author DoDo
 */
public class HelpActivity extends FragmentActivity {

    private UnderlinePageIndicator mIndicator = null;
    private ViewPager mViewPager = null;
    private ImageButton mCloseButton = null;


    /**
     * Called when activity is created.
     */
    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.help_view);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentPagerAdapter pageAdapter = getPageAdapter();
        mViewPager.setAdapter(pageAdapter);

        mIndicator = (UnderlinePageIndicator) findViewById(R.id.underline_indicator);
        mIndicator.setViewPager(mViewPager);
        mIndicator.setFades(false);

        mCloseButton = (ImageButton) findViewById(R.id.closeButton);
        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LanguageUtils.setLanguageConfiguration(getResources());
    }

    /**
     * Method returns the adequate FragmentPagerAdapter based on which help
     * screens should be shown.
     *
     * @return Page adapter for paged activity.
     */
    protected FragmentPagerAdapter getPageAdapter() {
            return new BlinkOCRAdapter(getSupportFragmentManager(), this);
    }
}
