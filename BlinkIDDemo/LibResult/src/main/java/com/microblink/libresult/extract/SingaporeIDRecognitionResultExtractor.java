package com.microblink.libresult.extract;

import android.content.Context;

import com.microblink.libresult.R;
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

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDocumentClassification),
                    classification.toString()
            ));

            if (classification == SingaporeIDRecognitionResult.SingaporeIDClassification.BACK_SIDE) {
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPBloodGroup),
                        singaporeIDResult.getBloodGroup()
                ));
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPIssueDate),
                        singaporeIDResult.getDocumentDateOfIssue() == null ? null : singaporeIDResult.getDocumentDateOfIssue().toString()
                ));
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPAddress),
                        singaporeIDResult.getAddress()
                ));
            } else {
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPDocumentNumber),
                        singaporeIDResult.getCardNumber()
                ));

                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPFullName),
                        singaporeIDResult.getName()
                ));
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPRace),
                        singaporeIDResult.getRace()
                ));
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPDateOfBirth),
                        singaporeIDResult.getDateOfBirth() == null ? null : singaporeIDResult.getDateOfBirth().toString()
                ));
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPSex),
                        singaporeIDResult.getSex()
                ));
                mExtractedData.add(new RecognitionResultEntry(
                        mContext.getString(R.string.PPCountryOfBirth),
                        singaporeIDResult.getCountryOfBirth()
                ));
            }
        }

        return mExtractedData;
    }
}