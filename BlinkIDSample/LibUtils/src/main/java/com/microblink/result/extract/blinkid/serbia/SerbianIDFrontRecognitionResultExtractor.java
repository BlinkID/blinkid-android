package com.microblink.result.extract.blinkid.serbia;

import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SerbianIDFrontRecognitionResultExtractor extends BaseResultExtractor<SerbiaIdFrontRecognizer.Result, SerbiaIdFrontRecognizer> {

    @Override
    protected void extractData(SerbiaIdFrontRecognizer.Result result) {
        add(R.string.PPIssueDate, result.getIssuingDate());
        add(R.string.PPValidUntil, result.getValidUntil());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
    }

}
