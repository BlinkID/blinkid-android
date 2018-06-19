package com.microblink.result.extract.blinkid.jordan;

import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class JordanIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<JordanCombinedRecognizer.Result, JordanCombinedRecognizer> {

    @Override
    protected void extractData(JordanCombinedRecognizer.Result result) {
        add(R.string.PPName, result.getName());
        add(R.string.PPNationalNumber, result.getNationalNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPIssuer, result.getIssuer());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }
}
