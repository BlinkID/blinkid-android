package com.microblink.result.extract.blinkid.serbia;

import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SerbianIDFrontRecognitionResultExtractor extends BlinkIdExtractor<SerbiaIdFrontRecognizer.Result, SerbiaIdFrontRecognizer> {

    @Override
    protected void extractData(SerbiaIdFrontRecognizer.Result result) {
        add(R.string.PPIssueDate, result.getIssuingDate());
        add(R.string.PPValidUntil, result.getValidUntil());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
    }

}
