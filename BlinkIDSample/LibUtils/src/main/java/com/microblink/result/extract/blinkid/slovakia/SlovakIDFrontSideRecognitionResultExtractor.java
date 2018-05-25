package com.microblink.result.extract.blinkid.slovakia;

import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SlovakIDFrontSideRecognitionResultExtractor  extends BaseResultExtractor<SlovakiaIDFrontRecognizer.Result, SlovakiaIDFrontRecognizer> {

    @Override
    protected void extractData(SlovakiaIDFrontRecognizer.Result svkIdFrontResult) {
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
                svkIdFrontResult.getDocumentNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuedBy,
                svkIdFrontResult.getIssuedBy()
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

}
