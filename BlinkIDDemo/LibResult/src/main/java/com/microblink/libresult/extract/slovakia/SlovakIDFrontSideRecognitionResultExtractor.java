package com.microblink.libresult.extract.slovakia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.slovakia.front.SlovakIDFrontSideRecognitionResult;

import java.util.List;

public class SlovakIDFrontSideRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {
    public SlovakIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SlovakIDFrontSideRecognitionResult) {
            SlovakIDFrontSideRecognitionResult svkIdFrontResult = (SlovakIDFrontSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    svkIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    svkIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    svkIdFrontResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    svkIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    svkIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    svkIdFrontResult.getIssuingAuthority()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    svkIdFrontResult.getDateOfBirth()
            ));


            mExtractedData.add(mBuilder.build(
                    R.string.PPPersonalNumber,
                    svkIdFrontResult.getPersonalNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    svkIdFrontResult.getDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    svkIdFrontResult.getDateOfIssue()
            ));
        }

        return mExtractedData;
    }
}
