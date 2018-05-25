package com.microblink.result;

import android.app.Activity;
import android.content.Context;

import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldBundle;
import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldElement;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.RecognitionResultExtractorUtils;
import com.microblink.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FieldByFieldResultFragment extends BaseResultFragment {

    /**
     * Fragment factory.
     */
    public static FieldByFieldResultFragment newInstance() {
        FieldByFieldResultFragment fragment = new FieldByFieldResultFragment();
        Log.d("FieldByFieldResultFragment", "Creating new fragment");
        return fragment;
    }


    @Override
    protected void checkHostActivity(Activity hostActivity) {
        if ( !(hostActivity instanceof IFieldByFieldResultFragmentActivity) ) {
            throw new ClassCastException("FieldByFieldResultFragment must be used inside activity which"
                    + " implements FieldByFieldResultFragment.IFieldByFieldResultFragmentActivity interface");
        }
    }

    @Override
    protected List<RecognitionResultEntry> createResultEntries(Context context) {
        List<RecognitionResultEntry> extractedData = new ArrayList<>();

        // this must be called after the activity has been created
        FieldByFieldBundle fieldByFieldBundle = ((IFieldByFieldResultFragmentActivity) getActivity()).getFieldByFieldBundle();

        for (FieldByFieldElement elem : fieldByFieldBundle.getElements()) {
            String key = elem.getTitle(context);
            String stringlValue = elem.getParser().getResult().toString();
            if (key.contains("IBAN")) {
                stringlValue = RecognitionResultExtractorUtils.formatIBAN(stringlValue);
            }
            extractedData.add(new RecognitionResultEntry(key, stringlValue));
        }

        return extractedData;
    }

    /**
     * Interface which must be implemented by all activities that use {@link FieldByFieldResultFragment}.
     */
    public interface IFieldByFieldResultFragmentActivity {
        FieldByFieldBundle getFieldByFieldBundle();
    }
}
