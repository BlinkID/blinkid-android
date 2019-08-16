package com.microblink.result.extract.blinkid.visa;

import com.microblink.entities.recognizers.blinkid.visa.VisaRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class VisaRecognizerResultExtractor extends BlinkIdExtractor<VisaRecognizer.Result, VisaRecognizer> {

    @Override
    protected void extractData(VisaRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}
