package com.microblink.result;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.ResultExtractorFactoryProvider;
import com.microblink.util.Log;

import java.util.List;

public class ResultFragment extends BaseResultFragment {

    public static final String RECOGNIZER_POSITION = "RECOGNIZER_POSITION";

    private int mRecognizerPosition;

    /**
     * Fragment factory.
     */
    public static ResultFragment newInstance(int resultPosition) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(RECOGNIZER_POSITION, resultPosition);
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
        BaseResultExtractor resultExtractor = ResultExtractorFactoryProvider.get().createExtractor(recognizer);
        List<RecognitionResultEntry> extractedData = resultExtractor.extractData(getActivity(), recognizer);

        if (extractedData.size() <= 0) {
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
