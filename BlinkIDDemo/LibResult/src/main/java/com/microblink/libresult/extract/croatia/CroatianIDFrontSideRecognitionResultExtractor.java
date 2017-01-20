package com.microblink.libresult.extract.croatia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.croatia.front.CroatianIDFrontSideRecognitionResult;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;

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

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    croIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    croIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    croIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    croIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPCitizenship,
                    croIdFrontResult.getCitizenship()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    croIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    croIdFrontResult.getDocumentDateOfExpiry()
            ));
        }

        return mExtractedData;

    }
}
