package com.microblink.libresult.extract.czechia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.czechia.back.CzechIDBackSideRecognitionResult;

import java.util.List;

public class CzechIDBackSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public CzechIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof CzechIDBackSideRecognitionResult) {
            CzechIDBackSideRecognitionResult czechIDBackResult = (CzechIDBackSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    czechIDBackResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPersonalNumber,
                    czechIDBackResult.getPersonalNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAuthority,
                    czechIDBackResult.getAuthority()
            ));

            super.extractMRZData(czechIDBackResult);
        }

        return mExtractedData;
    }
}
