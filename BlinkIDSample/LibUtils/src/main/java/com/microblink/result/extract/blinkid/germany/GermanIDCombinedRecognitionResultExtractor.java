package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class GermanIDCombinedRecognitionResultExtractor extends BaseResultExtractor<GermanyCombinedRecognizer.Result, GermanyCombinedRecognizer> {

    @Override
    protected void extractData(GermanyCombinedRecognizer.Result result) {

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
                R.string.PPNationality,
                result.getNationality()
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
                R.string.PPPlaceOfBirth,
                result.getPlaceOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPEyeColour,
                result.getEyeColor()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPHeight,
                result.getHeight()
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
