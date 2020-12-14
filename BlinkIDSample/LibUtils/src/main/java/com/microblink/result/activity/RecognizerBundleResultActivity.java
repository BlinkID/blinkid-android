package com.microblink.result.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.result.activity.fragment.ResultFragment;
import com.microblink.util.ResultUtils;

import java.util.ArrayList;
import java.util.List;

public class RecognizerBundleResultActivity extends BaseResultActivity implements
        ResultFragment.ResultFragmentActivity {

    private static final String SHOULD_SHOW_RESULT_DIALOG_EXTRA = "SHOULD_SHOW_RESULT_DIALOG_EXTRA";

    protected RecognizerBundle mRecognizerBundle;
    private List<Recognizer> mRecognizersWithResult;

    public static void putShouldShowResultDialogExtra(Intent data, boolean shouldShowResultDialog) {
        data.putExtra(SHOULD_SHOW_RESULT_DIALOG_EXTRA, shouldShowResultDialog);
    }

    private static boolean getShouldShowResultDialogExtra(Intent data) {
        return data.getBooleanExtra(SHOULD_SHOW_RESULT_DIALOG_EXTRA, false);
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        // clear saved state to be sure that data is cleared from cache and from file when
        // intent optimisation is used
        if (mRecognizerBundle != null) {
            mRecognizerBundle.clearSavedState();
        }
    }

    @NonNull
    @Override
    protected FragmentPagerAdapter createResultFragmentPagerAdapter(Intent intent) {
        mRecognizersWithResult = obtainRecognizersWithResult(intent);
        return new RecognizerListFragmentAdapter(getSupportFragmentManager());
    }

    protected List<Recognizer> obtainRecognizersWithResult(Intent intent) {
        StringBuilder resultDialogMessageBuilder = new StringBuilder();

        List<Recognizer> recognizersWithResult = new ArrayList<>();
        mRecognizerBundle = new RecognizerBundle();
        mRecognizerBundle.loadFromIntent(intent);
        for ( Recognizer<Recognizer.Result> r : mRecognizerBundle.getRecognizers() ) {
            if ( r.getResult().getResultState() != Recognizer.Result.State.Empty ) {
                recognizersWithResult.add( r );
            }

            resultDialogMessageBuilder.append(String.format("%s: %s\n",
                    r.getName(),
                    r.getResult().getResultState().name()));
        }

        showResultDialogIfEligible(resultDialogMessageBuilder.toString());

        return recognizersWithResult;
    }

    private void showResultDialogIfEligible(String resultDialogMessage) {
        boolean shouldShowResultDialog = getShouldShowResultDialogExtra(getIntent());

        if (shouldShowResultDialog) {
            new AlertDialog.Builder(this)
                    .setTitle("Recognizer Result States")
                    .setMessage(resultDialogMessage)
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
        }
    }

    @CallSuper
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mRecognizerBundle != null) {
            mRecognizerBundle.saveState();

        }
    }

    @Override
    public Recognizer<Recognizer.Result > getRecognizerAtPosition(int resultPosition) {
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
            return ResultUtils.getEntitySimpleName(mRecognizersWithResult.get(position));
        }
    }

}
