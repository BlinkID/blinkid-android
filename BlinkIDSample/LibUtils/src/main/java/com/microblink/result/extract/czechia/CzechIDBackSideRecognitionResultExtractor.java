package com.microblink.result.extract.czechia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.czechia.CzechIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by dodo on 24/05/16.
 */

public class CzechIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public CzechIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof CzechIDBackSideRecognizer.Result) {
            CzechIDBackSideRecognizer.Result czIDBackResult = (CzechIDBackSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    czIDBackResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPersonalNumber,
                    czIDBackResult.getPersonalNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAuthority,
                    czIDBackResult.getAuthority()
            ));

            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(czIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
