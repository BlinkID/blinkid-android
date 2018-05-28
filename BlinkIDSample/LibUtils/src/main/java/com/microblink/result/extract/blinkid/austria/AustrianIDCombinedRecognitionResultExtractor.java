package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class AustrianIDCombinedRecognitionResultExtractor extends BaseResultExtractor<AustriaCombinedRecognizer.Result,AustriaCombinedRecognizer> {

    @Override
    protected void extractData(AustriaCombinedRecognizer.Result result) {
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
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPHeight,
                result.getHeight(),
                "m"
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPlaceOfBirth,
                result.getPlaceOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuingAuthority,
                result.getIssuingAuthority()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDateOfIssuance()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDocumentDateOfExpiry()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPrincipalResidenceAtIssuance,
                result.getPrincipalResidenceAtIssuance()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPEyeColour,
                result.getEyeColour()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                result.getNationality()
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
