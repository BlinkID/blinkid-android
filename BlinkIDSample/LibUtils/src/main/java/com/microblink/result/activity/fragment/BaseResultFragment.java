package com.microblink.result.activity.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;

import com.microblink.libutils.R;
import com.microblink.locale.LanguageUtils;
import com.microblink.result.activity.fragment.ResultEntryAdapter;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.List;


public abstract class BaseResultFragment extends Fragment {

    private ListView mListView;

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
        mListView = new ListView(getActivity());
        mListView.setDividerHeight(1);
        mListView.setScrollbarFadingEnabled(false);

        // some id is required so that android can save listview's scroll state
        // when activity goes to background
        // the id does not need to be unique
        mListView.setId(android.R.id.text2);

        return mListView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<RecognitionResultEntry> resultEntries = createResultEntries(getActivity());

        // Create adapter which will be used to populate ListView.
        ResultEntryAdapter adapter = new ResultEntryAdapter(getActivity(), R.layout.result_entry,
                resultEntries);
        mListView.setAdapter(adapter);
        // Hide virtual keyboard
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
