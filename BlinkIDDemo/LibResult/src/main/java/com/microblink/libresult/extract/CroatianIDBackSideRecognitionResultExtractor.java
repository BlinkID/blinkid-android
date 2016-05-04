package com.microblink.libresult.extract;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
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

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPAddress),
                    croIDBackResult.getAddress()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPIssuingAuthority),
                    croIDBackResult.getIssuingAuthority()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPIssueDate),
                    croIDBackResult.getDocumentDateOfIssue() == null ? null : croIDBackResult.getDocumentDateOfIssue().toString()
            ));

            super.extractMRZData(croIDBackResult);
        }

        return mExtractedData;
    }
}
