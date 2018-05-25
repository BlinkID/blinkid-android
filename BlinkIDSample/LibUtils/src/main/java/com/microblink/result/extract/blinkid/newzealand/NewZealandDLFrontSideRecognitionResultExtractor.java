package com.microblink.result.extract.blinkid.newzealand;

import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDLFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class NewZealandDLFrontSideRecognitionResultExtractor extends BaseResultExtractor<NewZealandDLFrontRecognizer.Result, NewZealandDLFrontRecognizer> {

    @Override
    protected void extractData(NewZealandDLFrontRecognizer.Result result) {

        mExtractedData.add(mBuilder.build(
                R.string.PPSurname,
                result.getSurname()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstNames,
                result.getFirstNames()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getIssueDate()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getExpiryDate()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPLicenceNumber,
                result.getLicenseNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPCardVersion,
                result.getCardVersion()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDonorIndicator,
                result.getDonorIndicator()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));
    }

}