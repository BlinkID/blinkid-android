package com.microblink.result.extract.blinkid.slovenia;

import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SlovenianIDCombinedRecognitionResultExtractor extends BaseResultExtractor<SloveniaCombinedRecognizer.Result, SloveniaCombinedRecognizer> {

    @Override
    protected void extractData(SloveniaCombinedRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getIdentityCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPCitizenship,
                result.getCitizenship()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDocumentDateOfExpiry()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuingAuthority,
                result.getIssuingAuthority()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDocumentDateOfIssue()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPersonalNumber,
                result.getPersonalIdentificationNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPMRZVerified,
                result.isMRZVerified()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentBothSidesMatch,
                result.isDocumentDataMatch()
        ));
    }

}
