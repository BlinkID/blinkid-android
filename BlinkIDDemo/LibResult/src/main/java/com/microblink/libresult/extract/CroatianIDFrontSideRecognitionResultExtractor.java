package com.microblink.libresult.extract;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.croatia.front.CroatianIDFrontSideRecognitionResult;

import java.util.List;

/**
 * Created by Boris on 26/04/16.
 */
public class CroatianIDFrontSideRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public CroatianIDFrontSideRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof CroatianIDFrontSideRecognitionResult){
            // result is obtained by scanning front side of Croatian ID
            CroatianIDFrontSideRecognitionResult croIdFrontResult = (CroatianIDFrontSideRecognitionResult) result;

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPLastName),
                    croIdFrontResult.getLastName()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPFirstName),
                    croIdFrontResult.getFirstName()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDocumentNumber),
                    croIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPSex),
                    croIdFrontResult.getSex()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPCitizenship),
                    croIdFrontResult.getCitizenship()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDateOfBirth),
                    croIdFrontResult.getDateOfBirth() == null ? null : croIdFrontResult.getDateOfBirth().toString()
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDateOfExpiry),
                    croIdFrontResult.getDocumentDateOfExpiry() == null ? null : croIdFrontResult.getDocumentDateOfExpiry().toString()
            ));
        }

        return mExtractedData;

    }
}
