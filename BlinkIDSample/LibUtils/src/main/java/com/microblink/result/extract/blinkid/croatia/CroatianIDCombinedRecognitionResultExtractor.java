package com.microblink.result.extract.blinkid.croatia;

import com.microblink.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CroatianIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<CroatiaCombinedRecognizer.Result, CroatiaCombinedRecognizer> {

    @Override
    protected void extractData(CroatiaCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDocumentNumber, result.getIdentityCardNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPCitizenship, result.getCitizenship());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPDocumentForNonResidents, result.isNonResident());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPersonalNumber, result.getPersonalIdentificationNumber());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
        add(R.string.PPDocumentBilingual, result.isDocumentBilingual());
    }

}
