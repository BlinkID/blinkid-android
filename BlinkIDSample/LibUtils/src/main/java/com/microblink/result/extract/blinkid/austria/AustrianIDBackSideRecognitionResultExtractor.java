package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class AustrianIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<AustriaIdBackRecognizer.Result, AustriaIdBackRecognizer> {

    @Override
    protected void extractData(AustriaIdBackRecognizer.Result ausIDBackResult) {
        extractMRZResult(ausIDBackResult.getMrzResult());

        add(R.string.PPHeight, ausIDBackResult.getHeight());
        add(R.string.PPPlaceOfBirth, ausIDBackResult.getPlaceOfBirth());
        add(R.string.PPIssuingAuthority, ausIDBackResult.getIssuingAuthority());
        add(R.string.PPIssueDate, ausIDBackResult.getDateOfIssuance().getDate());
        add(R.string.PPPrincipalResidenceAtIssuance, ausIDBackResult.getPrincipalResidence());
        add(R.string.PPEyeColour, ausIDBackResult.getEyeColour());
        add(R.string.PPDocumentNumber, ausIDBackResult.getDocumentNumber());
    }

}
