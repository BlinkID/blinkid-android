package com.microblink.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.help.pageindicator.TabPageIndicator;
import com.microblink.libresult.R;

import java.util.ArrayList;

public class ResultActivity extends FragmentActivity implements ResultFragment.IResultFragmentActivity{

    protected ViewPager mPager;

    protected RecognizerBundle mRecognizerBundle;

    private ArrayList<Recognizer> mRecognizersWithResult;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setActivityContentView();

        Intent intent = getIntent();

        mRecognizerBundle = new RecognizerBundle();

        mPager = findViewById(R.id.resultPager);
        mRecognizersWithResult = new ArrayList<>();
        mRecognizerBundle.loadFromIntent(intent);
        for (Recognizer<Recognizer.Result> r : mRecognizerBundle.getRecognizers()) {
            if (r.getResult().getResultState() != Recognizer.Result.State.Empty) {
                mRecognizersWithResult.add(r);
            }
        }
        mPager.setAdapter(new RecognizerListFragmentAdapter(getSupportFragmentManager()));

        TabPageIndicator indicator = findViewById(R.id.resultIndicator);
        indicator.setViewPager(mPager);
        indicator.setClipChildren(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // clear saved state to be sure that data is cleared from cache and from file when
        // intent optimisation is used
        mRecognizerBundle.clearSavedState();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mRecognizerBundle.saveState();
    }

    public void setActivityContentView() {
        setContentView(R.layout.result_menu);
    }

    public void footerButtonClickHandler(View view) {
        finish();
    }

    @Override
    public Recognizer<Recognizer.Result> getRecognizerAtPosition(int resultPosition) {
        if (resultPosition < 0 || resultPosition >= mRecognizersWithResult.size()) {
            throw new IllegalStateException("Recognizer with non empty result on requested position"
                    + " does not exist. Possible cause is that recognizer bundle state has been lost"
                    + " in intent transactions.");
        }
        //noinspection unchecked
        return mRecognizersWithResult.get(resultPosition);
    }

    private class RecognizerListFragmentAdapter extends FragmentPagerAdapter {

        RecognizerListFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ResultFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return mRecognizersWithResult.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ResultUtils.getRecognizerSimpleName(mRecognizersWithResult.get(position));
        }
    }
}
