package com.microblink.libresult.extract.singapore;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.singapore.front.SingaporeIDFrontRecognitionResult;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;

import java.util.List;

/**
 * Created by Boris on 03/05/16.
 */
public class SingaporeIDFrontRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public SingaporeIDFrontRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SingaporeIDFrontRecognitionResult){
            // result is obtained by scanning of Singapore ID
            SingaporeIDFrontRecognitionResult singaporeIDResult = (SingaporeIDFrontRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    singaporeIDResult.getCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFullName,
                    singaporeIDResult.getName()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPRace,
                    singaporeIDResult.getRace()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    singaporeIDResult.getDateOfBirth()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    singaporeIDResult.getSex()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPCountryOfBirth,
                    singaporeIDResult.getCountryOfBirth()
            ));
        }

        return mExtractedData;
    }
}