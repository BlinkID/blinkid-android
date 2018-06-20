package com.microblink.result.extract.blinkid.serbia;

import com.microblink.entities.recognizers.blinkid.serbia.SerbiaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SerbianIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<SerbiaCombinedRecognizer.Result, SerbiaCombinedRecognizer> {

    @Override
    protected void extractData(SerbiaCombinedRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getIdentityCardNumber());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPersonalNumber, result.getJmbg());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssuer, result.getIssuer());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }
}
