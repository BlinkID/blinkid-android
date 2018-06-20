package com.microblink.result.extract.blinkid.poland;

import com.microblink.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class PolishIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<PolandCombinedRecognizer.Result, PolandCombinedRecognizer> {

    @Override
    protected void extractData(PolandCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getGivenNames());
        add(R.string.PPFamilyName, result.getFamilyName());
        add(R.string.PPParentNames, result.getParentsGivenNames());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPIssuer, result.getIssuer());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPPersonalNumber, result.getPersonalNumber());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }
}
