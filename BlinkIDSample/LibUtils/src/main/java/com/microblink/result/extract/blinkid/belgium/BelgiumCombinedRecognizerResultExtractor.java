package com.microblink.result.extract.blinkid.belgium;

import com.microblink.entities.recognizers.blinkid.belgium.BelgiumCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BelgiumCombinedRecognizerResultExtractor extends BlinkIdExtractor<BelgiumCombinedRecognizer.Result, BelgiumCombinedRecognizer> {

    @Override
    protected void extractData(BelgiumCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPIdentityCardNumber, result.getCardNumber());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPIssuingAuthority, result.getIssuedBy());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }


}
