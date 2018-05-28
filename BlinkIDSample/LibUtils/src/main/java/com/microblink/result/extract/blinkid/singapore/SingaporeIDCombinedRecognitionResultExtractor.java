package com.microblink.result.extract.blinkid.singapore;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SingaporeIDCombinedRecognitionResultExtractor extends BaseResultExtractor<SingaporeCombinedRecognizer.Result, SingaporeCombinedRecognizer> {

    @Override
    protected void extractData(SingaporeCombinedRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPFullName,
                result.getName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPBloodGroup,
                result.getBloodGroup()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNRICNumber,
                result.getCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPRace,
                result.getRace()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPCountryOfBirth,
                result.getCountryOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDocumentDateOfIssue()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentBothSidesMatch,
                result.isDocumentDataMatch()
        ));
    }
}
