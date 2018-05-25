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

import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldBundle;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.help.pageindicator.TabPageIndicator;
import com.microblink.libresult.R;

import java.util.ArrayList;

public class ResultActivity extends FragmentActivity implements
        ResultFragment.IResultFragmentActivity,
        FieldByFieldResultFragment.IFieldByFieldResultFragmentActivity {

    public static final String EXTRAS_RESULT_TYPE = "EXTRAS_RESULT_TYPE";

    public enum ResultType {
        RECOGNIZER_BUNDLE,
        FIELD_BY_FIELD_BUNDLE
    }

    protected ViewPager mPager;

    protected RecognizerBundle mRecognizerBundle;
    protected FieldByFieldBundle mFieldByFieldBundle;

    protected ResultType mResultType;

    private ArrayList<Recognizer> mRecognizersWithResult;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setActivityContentView();

        Intent intent = getIntent();
        mResultType = (ResultType) intent.getSerializableExtra(EXTRAS_RESULT_TYPE);

        mRecognizerBundle = new RecognizerBundle();
        mFieldByFieldBundle = new FieldByFieldBundle();

        if (mResultType == null) {
            if (mRecognizerBundle.existsInIntent(intent)) {
                mResultType = ResultType.RECOGNIZER_BUNDLE;
            } else if (mFieldByFieldBundle.existsInIntent(intent)) {
                mResultType = ResultType.FIELD_BY_FIELD_BUNDLE;
            }
        }

        if (mResultType == null) {
            throw new IllegalStateException("Results must be passed to ResultActivity!");
        }

        mPager = findViewById(R.id.resultPager);
        switch (mResultType) {
            case RECOGNIZER_BUNDLE:
                mRecognizersWithResult = new ArrayList<>();
                mRecognizerBundle.loadFromIntent(intent);
                for ( Recognizer< Recognizer, Recognizer.Result > r : mRecognizerBundle.getRecognizers() ) {
                    if ( r.getResult().getResultState() != Recognizer.Result.State.Empty ) {
                        mRecognizersWithResult.add( r );
                    }
                }
                mPager.setAdapter(new RecognizerListFragmentAdapter(getSupportFragmentManager()));
                break;
            case FIELD_BY_FIELD_BUNDLE:
                mFieldByFieldBundle.loadFromIntent(intent);
                mPager.setAdapter(new FieldByFieldBundleFragmentAdapter(getSupportFragmentManager()));
                break;
        }

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
        mFieldByFieldBundle.clearSavedState();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mResultType == ResultType.RECOGNIZER_BUNDLE) {
            mRecognizerBundle.saveState();
        } else if (mResultType == ResultType.FIELD_BY_FIELD_BUNDLE) {
            mFieldByFieldBundle.saveState();
        }
    }

    public void setActivityContentView() {
        setContentView(R.layout.result_menu);
    }

    public void footerButtonClickHandler(View view) {
        finish();
    }

    @Override
    public Recognizer< Recognizer, Recognizer.Result > getRecognizerAtPosition(int resultPosition) {
        if (resultPosition < 0 || resultPosition >= mRecognizersWithResult.size()) {
            throw new IllegalStateException("Recognizer with non empty result on requested position"
                    + " does not exist. Possible cause is that recognizer bundle state has been lost"
                    + " in intent transactions.");
        }
        //noinspection unchecked
        return mRecognizersWithResult.get(resultPosition);
    }

    @Override
    public FieldByFieldBundle getFieldByFieldBundle() {
        return mFieldByFieldBundle;
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

    private class FieldByFieldBundleFragmentAdapter extends FragmentPagerAdapter {

        FieldByFieldBundleFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FieldByFieldResultFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ResultActivity.this.getString(R.string.title_field_by_field_results);
        }

    }
}
