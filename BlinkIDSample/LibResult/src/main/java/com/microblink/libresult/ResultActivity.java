package com.microblink.libresult;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.microblink.activity.ScanActivity;
import com.microblink.recognizers.RecognitionResults;

/**
 * Created by igor on 12/2/14.
 */
public class ResultActivity extends FragmentActivity {

    FragmentPagerAdapter adapterViewPager;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result_menu);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new ResultFragmentAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    public void buttonClickHandler(View view) {
        final int id = view.getId();
        if (id == R.id.btnYesPay) {
            finish();
        } else if (id == R.id.btnNoBack) {
            finish();
        }
    }

    class ResultFragmentAdapter extends FragmentPagerAdapter {

        RecognitionResults mResults = getIntent().getExtras().getParcelable(
                ScanActivity.EXTRAS_RECOGNITION_RESULTS);

        public ResultFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ResultFragment.newInstance(mResults.getRecognitionResults()[position]);
        }

        @Override
        public int getCount() {
            if (mResults.getRecognitionResults() == null) {
                return 0;
            } else {
                return mResults.getRecognitionResults().length;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mResults.getRecognitionResults()[position].getTitle();
        }
    }
}
