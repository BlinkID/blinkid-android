package com.microblink.libresult.extract.croatia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.blinkid.croatia.back.CroatianIDBackSideRecognitionResult;

import java.util.List;

/**
 * Created by Boris on 22/04/16.
 */
public class CroatianIDBackSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public CroatianIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof CroatianIDBackSideRecognitionResult){
            // result is obtained by scanning back side of croatian ID
            CroatianIDBackSideRecognitionResult croIDBackResult = (CroatianIDBackSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    croIDBackResult.getAddress()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    croIDBackResult.getIssuingAuthority()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    croIDBackResult.getDocumentDateOfIssue()
            ));

            super.extractMRZData(croIDBackResult);
        }

        return mExtractedData;
    }
}
