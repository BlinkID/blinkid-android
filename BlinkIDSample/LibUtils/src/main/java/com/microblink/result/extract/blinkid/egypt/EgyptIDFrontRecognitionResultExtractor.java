package com.microblink.result.extract.blinkid.egypt;

import com.microblink.entities.recognizers.blinkid.egypt.EgyptIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;


public class EgyptIDFrontRecognitionResultExtractor extends BlinkIdExtractor<EgyptIdFrontRecognizer.Result, EgyptIdFrontRecognizer> {

    @Override
    protected void extractData(EgyptIdFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPNationalNumber, result.getNationalNumber());
    }

}
