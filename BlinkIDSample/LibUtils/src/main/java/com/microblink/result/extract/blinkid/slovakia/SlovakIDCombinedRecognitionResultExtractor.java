package com.microblink.result.extract.blinkid.slovakia;

import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SlovakIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<SlovakiaCombinedRecognizer.Result, SlovakiaCombinedRecognizer> {

    @Override
    protected void extractData(SlovakiaCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssuedBy, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPersonalNumber, result.getPersonalIdentificationNumber());
        add(R.string.PPSurnameAtBirth, result.getSurnameAtBirth());
        add(R.string.PPSpecialRemarks, result.getSpecialRemarks());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }

}
