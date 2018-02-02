package com.microblink.libresult.extract.slovakia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.slovakia.back.SlovakIDBackSideRecognitionResult;

import java.util.List;

public class SlovakIDBackSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public SlovakIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SlovakIDBackSideRecognitionResult) {
            SlovakIDBackSideRecognitionResult svkIDBackResult = (SlovakIDBackSideRecognitionResult) result;

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

            super.extractMRZData(svkIDBackResult);
        }

        return mExtractedData;
    }
}
