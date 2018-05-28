package com.microblink.result.extract.blinkid.eudl;

import com.microblink.entities.recognizers.blinkid.eudl.EUDLRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class EUDriversLicenceRecognitionResultExtractor extends BaseResultExtractor<EUDLRecognizer.Result, EUDLRecognizer> {

    @Override
    protected void extractData(EUDLRecognizer.Result result) {

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPlaceOfBirth,
                result.getPlaceOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDocumentIssueDate()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDocumentExpiryDate()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDriverNumber,
                result.getDriverNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuingAuthority,
                result.getDocumentIssuingAuthority()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPCountryId,
                result.getCountry().name()
        ));
    }

}
