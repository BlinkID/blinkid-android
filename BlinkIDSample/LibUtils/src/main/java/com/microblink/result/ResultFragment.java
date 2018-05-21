package com.microblink.result;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.recognizers.BaseLegacyRecognizerWrapper;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.RecognitionResultExtractorFactory;
import com.microblink.util.Log;

import java.util.List;

/**
 * Created by igor on 12/2/14.
 */
public class ResultFragment extends BaseResultFragment {

    public static final boolean TEST_STANDALONE_RESULT = false;

    public static final String SCAN_DURATION = "SCAN_DURATION";
    public static final String RECOGNIZER_POSITION = "RECOGNIZER_POSITION";

    private long mScanDuration = 0;

    private int mRecognizerPosition;

    /**
     * Fragment factory.
     */
    public static ResultFragment newInstance(int resultPosition, long scanDuration) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(RECOGNIZER_POSITION, resultPosition);
        args.putLong(SCAN_DURATION, scanDuration);
        fragment.setArguments(args);

        Log.d("ResultFragment", "Creating new fragment");

        return fragment;
    }

    @Override
    protected void checkHostActivity(Activity hostActivity) {
        if ( !(hostActivity instanceof IResultFragmentActivity) ) {
            throw new ClassCastException("ResultFragment must be used inside activity which"
                    + " implements ResultFragment.IResultFragmentActivity interface");
        }
    }

    @Override
    protected List<RecognitionResultEntry> createResultEntries(Context context) {
        // this must be called after the activity has been created
        Recognizer<Recognizer, Recognizer.Result> recognizer =
                ((IResultFragmentActivity) getActivity()).getRecognizerAtPosition(
                        mRecognizerPosition);

        // Extract data from BaseRecognitionResult
        IBaseRecognitionResultExtractor resultExtractor = RecognitionResultExtractorFactory.createExtractor(getActivity(), recognizer);

        List<RecognitionResultEntry> extractedData;
        if (recognizer instanceof BaseLegacyRecognizerWrapper) {
            extractedData = resultExtractor.extractData((recognizer.getResult()));
        } else {
            extractedData = resultExtractor.extractData(recognizer);
        }

        // test for transfer of standalone
        if ( TEST_STANDALONE_RESULT ) {
            Entity.Result<?> firstResult = getActivity().getIntent().getParcelableExtra("proba");
            resultExtractor = RecognitionResultExtractorFactory.createExtractor(getActivity(), firstResult);
            extractedData = resultExtractor.extractData(firstResult);
        }

        // Add scan duration
        if (extractedData.size() > 0) {
            // extractedData.add(new RecognitionResultEntry("Scan duration", String.valueOf(mScanDuration) + " ms"));
        } else {
            Toast.makeText(getActivity(), "Result list is empty", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }

        return extractedData;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getArguments();
        mRecognizerPosition = -1;
        if (extras != null) {
            mRecognizerPosition = extras.getInt(RECOGNIZER_POSITION, mRecognizerPosition);
            mScanDuration = extras.getLong(SCAN_DURATION, 0L);
        }

        if (mRecognizerPosition == -1) {
            throw new IllegalStateException("Recognizer position from parent activity"
                    + " must be passed as fragment argument");
        }
    }

    /**
     * Interface which must be implemented by all activities that use {@link ResultFragment}.
     */
    public interface IResultFragmentActivity {
        Recognizer<Recognizer, Recognizer.Result > getRecognizerAtPosition(int resultPosition);
    }
}
