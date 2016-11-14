package com.microblink.libresult.extract.singapore;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.singapore.SingaporeIDRecognitionResult;

import java.util.List;

/**
 * Created by Boris on 03/05/16.
 */
public class SingaporeIDRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public SingaporeIDRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SingaporeIDRecognitionResult){
            // result is obtained by scanning of Singapore ID
            SingaporeIDRecognitionResult singaporeIDResult = (SingaporeIDRecognitionResult) result;

            SingaporeIDRecognitionResult.SingaporeIDClassification classification = singaporeIDResult.getDocumentClassification();

            mExtractedData.add(mBuilder.build(R.string.PPDocumentClassification,
                    classification.toString()
            ));

            if (classification == SingaporeIDRecognitionResult.SingaporeIDClassification.BACK_SIDE) {
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
            } else {
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
        }

        return mExtractedData;
    }
}