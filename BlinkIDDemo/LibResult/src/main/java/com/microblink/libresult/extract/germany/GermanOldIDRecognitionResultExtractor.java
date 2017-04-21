package com.microblink.libresult.extract.germany;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.germany.old.front.GermanOldIDRecognitionResult;

import java.util.List;

/**
 * Created by daniel on 4/12/17.
 */

public class GermanOldIDRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public GermanOldIDRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanOldIDRecognitionResult) {
            GermanOldIDRecognitionResult deOldIdResult = (GermanOldIDRecognitionResult) result;

            String placeOfBirth = deOldIdResult.getPlaceOfBirth();
            if (placeOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPlaceOfBirth,
                        placeOfBirth
                ));
            }

            super.extractMRZData(deOldIdResult);
        }

        return mExtractedData;
    }
}
