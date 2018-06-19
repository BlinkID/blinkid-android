package com.microblink.result.extract.blinkid.slovenia;

import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SlovenianIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<SloveniaCombinedRecognizer.Result, SloveniaCombinedRecognizer> {

    @Override
    protected void extractData(SloveniaCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDocumentNumber, result.getIdentityCardNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPCitizenship, result.getCitizenship());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPersonalNumber, result.getPersonalIdentificationNumber());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }

}
