package com.microblink.result.activity.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.result.ResultSource;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.ResultExtractorFactoryProvider;
import com.microblink.util.Log;

import java.util.List;

public class ResultFragment extends BaseResultFragment {

    public static final String RECOGNIZER_POSITION = "RECOGNIZER_POSITION";
    private int mRecognizerPosition;
    private ResultSource resultSource = ResultSource.MIXED;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        resultTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> view, View view1, int pos, long l) {
                ResultSource newResultSource = ResultSource.values()[pos];
                if (newResultSource != resultSource) {
                    resultSource = newResultSource;
                    setupListAdapter();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> view) {
            }
        });
        return view;
    }

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
        if ( !(hostActivity instanceof ResultFragmentActivity) ) {
            throw new ClassCastException("ResultFragment must be used inside activity which"
                    + " implements ResultFragment.ResultFragmentActivity interface");
        }
    }

    @Override
    protected List<RecognitionResultEntry> createResultEntries(Context context) {
        // this must be called after the activity has been created
        Recognizer<Recognizer.Result> recognizer =
                ((ResultFragmentActivity) getActivity()).getRecognizerAtPosition(
                        mRecognizerPosition);


        // Extract data from BaseRecognitionResult
        BaseResultExtractor resultExtractor = ResultExtractorFactoryProvider.get().createExtractor(recognizer);
        List<RecognitionResultEntry> extractedData;

        if (resultExtractor.doesSupportResultSourceExtraction()) {
            resultTypeSection.setVisibility(View.VISIBLE);
        }

        extractedData = resultExtractor.extractData(getActivity(), recognizer, resultSource);
        if (extractedData.size() <= 0) {
            Toast.makeText(getActivity(), "Result list is empty", Toast.LENGTH_SHORT).show();
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
    public interface ResultFragmentActivity {
        Recognizer<Recognizer.Result > getRecognizerAtPosition(int resultPosition);
    }
}
