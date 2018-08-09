package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class AustrianIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<AustriaCombinedRecognizer.Result,AustriaCombinedRecognizer> {

    @Override
    protected void extractData(AustriaCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getGivenName());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPHeight, result.getHeight());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssuance());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPPrincipalResidenceAtIssuance, result.getPrincipalResidence());
        add(R.string.PPEyeColour, result.getEyeColour());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPMRZVerified, result.isMrtdVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }


}
