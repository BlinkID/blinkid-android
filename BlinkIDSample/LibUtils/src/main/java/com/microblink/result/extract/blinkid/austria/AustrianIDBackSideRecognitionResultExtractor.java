package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class AustrianIDBackSideRecognitionResultExtractor extends BaseResultExtractor<AustriaIDBackSideRecognizer.Result, AustriaIDBackSideRecognizer> {

    @Override
    protected void extractData(AustriaIDBackSideRecognizer.Result ausIDBackResult) {
        extractMRZResult(ausIDBackResult.getMRZResult());

        mExtractedData.add(mBuilder.build(
                R.string.PPHeight,
                ausIDBackResult.getHeight(),
                "m"
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPlaceOfBirth,
                ausIDBackResult.getPlaceOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuingAuthority,
                ausIDBackResult.getIssuingAuthority()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                ausIDBackResult.getDateOfIssuance().getDate()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPrincipalResidenceAtIssuance,
                ausIDBackResult.getPrincipalResidence()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPEyeColour,
                ausIDBackResult.getEyeColour()
        ));
    }

}
