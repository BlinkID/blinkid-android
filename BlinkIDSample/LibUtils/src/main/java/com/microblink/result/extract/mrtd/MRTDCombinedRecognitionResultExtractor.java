package com.microblink.result.extract.mrtd;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.mrtd.MRTDCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.List;

/**
 * Created by daniel on 3/20/17.
 */

public class MRTDCombinedRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public MRTDCombinedRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MRTDCombinedRecognizer.Result) {
            MRTDCombinedRecognizer.Result combinedResult = (MRTDCombinedRecognizer.Result) result;

            super.extractMRZData(result);

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentBothSidesMatch,
                    combinedResult.isDocumentDataMatch()
            ));

            BlinkIDExtractionUtils.extractCommonData(combinedResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
