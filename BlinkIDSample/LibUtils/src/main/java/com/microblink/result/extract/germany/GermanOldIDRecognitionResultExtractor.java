package com.microblink.result.extract.germany;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.germany.GermanOldIDRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by daniel on 4/12/17.
 */

public class GermanOldIDRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public GermanOldIDRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanOldIDRecognizer.Result) {
            GermanOldIDRecognizer.Result deOldIdResult = (GermanOldIDRecognizer.Result) result;

            String placeOfBirth = deOldIdResult.getPlaceOfBirth();
            if (placeOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPlaceOfBirth,
                        placeOfBirth
                ));
            }

            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(deOldIdResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
