package com.microblink.libresult.extract.slovenia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.slovenia.back.SlovenianIDBackSideRecognitionResult;

import java.util.List;

/**
 * Created by Boris on 26/08/16.
 */
public class SlovenianIDBackRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public SlovenianIDBackRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SlovenianIDBackSideRecognitionResult) {
            SlovenianIDBackSideRecognitionResult sloIDBackResult = (SlovenianIDBackSideRecognitionResult) result;
            super.extractMRZData(sloIDBackResult);

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    sloIDBackResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAuthority,
                    sloIDBackResult.getAuthority()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    sloIDBackResult.getDateOfIssue()
            ));
        }

        return mExtractedData;
    }
}
