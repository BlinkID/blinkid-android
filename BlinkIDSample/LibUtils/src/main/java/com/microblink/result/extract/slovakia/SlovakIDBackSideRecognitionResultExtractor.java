package com.microblink.result.extract.slovakia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.slovakia.SlovakIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by igrce on 26/08/16.
 */
public class SlovakIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public SlovakIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SlovakIDBackRecognizer.Result) {
            SlovakIDBackRecognizer.Result svkIDBackResult = (SlovakIDBackRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    svkIDBackResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSurnameAtBirth,
                    svkIDBackResult.getSurnameAtBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    svkIDBackResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSpecialRemarks,
                    svkIDBackResult.getSpecialRemarks()
            ));

            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(svkIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
