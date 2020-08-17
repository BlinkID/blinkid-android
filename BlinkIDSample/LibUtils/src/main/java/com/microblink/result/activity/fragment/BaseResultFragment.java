package com.microblink.result.activity.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;

import com.microblink.libutils.R;
import com.microblink.locale.LanguageUtils;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.List;


public abstract class BaseResultFragment extends Fragment {

    private ListView mListView;
    protected View resultTypeSection;
    protected AppCompatSpinner resultTypeSpinner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LanguageUtils.setLanguageConfiguration(getResources());
        checkHostActivity(getActivity());
    }

    /**
     * Checks parent activity and throws {@link IllegalStateException} if the parent activity
     * does not implement interface which is required for concrete fragment.
     * @param hostActivity parent activity
     */
    protected abstract void checkHostActivity(Activity hostActivity);

    /**
     * Creates result entries that will be shown in list view.
     * @return created result entries
     */
    protected abstract List<RecognitionResultEntry> createResultEntries(Context context);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        mListView = view.findViewById(R.id.list_view);
        resultTypeSection = view.findViewById(R.id.result_type_section);
        resultTypeSpinner = view.findViewById(R.id.result_type_spinner);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupListAdapter();
        // Hide virtual keyboard
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    protected void setupListAdapter() {
        List<RecognitionResultEntry> resultEntries = createResultEntries(getActivity());

        // Create adapter which will be used to populate ListView.
        ResultEntryAdapter adapter = new ResultEntryAdapter(getActivity(), R.layout.result_entry,
                resultEntries);
        mListView.setAdapter(adapter);
    }
}
