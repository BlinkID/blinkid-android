package com.microblink.libresult.extract.singapore;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.singapore.back.SingaporeIDBackRecognitionResult;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;

import java.util.List;

/**
 * Created by Boris on 03/05/16.
 */
public class SingaporeIDBackRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public SingaporeIDBackRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SingaporeIDBackRecognitionResult){
            // result is obtained by scanning of Singapore ID
            SingaporeIDBackRecognitionResult singaporeIDResult = (SingaporeIDBackRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    singaporeIDResult.getCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBloodGroup,
                    singaporeIDResult.getBloodGroup()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    singaporeIDResult.getDocumentDateOfIssue()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    singaporeIDResult.getAddress()
            ));
        }

        return mExtractedData;
    }
}