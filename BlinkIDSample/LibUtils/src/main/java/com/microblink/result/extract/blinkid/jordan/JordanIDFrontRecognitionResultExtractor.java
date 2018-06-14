package com.microblink.result.extract.blinkid.jordan;

import com.microblink.entities.recognizers.blinkid.jordan.JordanIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class JordanIDFrontRecognitionResultExtractor extends BaseResultExtractor<JordanIdFrontRecognizer.Result, JordanIdFrontRecognizer> {

    @Override
    protected void extractData(JordanIdFrontRecognizer.Result result) {
        add(R.string.PPNationalNumber, result.getNatianalNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}
