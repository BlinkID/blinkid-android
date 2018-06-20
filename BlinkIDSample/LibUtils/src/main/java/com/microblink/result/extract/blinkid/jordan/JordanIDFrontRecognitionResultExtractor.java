package com.microblink.result.extract.blinkid.jordan;

import com.microblink.entities.recognizers.blinkid.jordan.JordanIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class JordanIDFrontRecognitionResultExtractor extends BlinkIdExtractor<JordanIdFrontRecognizer.Result, JordanIdFrontRecognizer> {

    @Override
    protected void extractData(JordanIdFrontRecognizer.Result result) {
        add(R.string.PPNationalNumber, result.getNationalNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}
