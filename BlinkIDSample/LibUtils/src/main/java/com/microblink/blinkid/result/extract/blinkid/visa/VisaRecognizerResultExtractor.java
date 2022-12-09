package com.microblink.blinkid.result.extract.blinkid.visa;

import com.microblink.blinkid.entities.recognizers.blinkid.visa.VisaRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class VisaRecognizerResultExtractor extends BlinkIdExtractor<VisaRecognizer.Result, VisaRecognizer> {

    @Override
    protected void extractData(VisaRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}
