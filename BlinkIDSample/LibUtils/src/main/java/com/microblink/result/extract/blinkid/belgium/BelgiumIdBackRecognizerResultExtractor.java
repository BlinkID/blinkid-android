package com.microblink.result.extract.blinkid.belgium;

import com.microblink.entities.recognizers.blinkid.belgium.BelgiumIdBackRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BelgiumIdBackRecognizerResultExtractor extends BlinkIdExtractor<BelgiumIdBackRecognizer.Result, BelgiumIdBackRecognizer> {
    @Override
    protected void extractData(BelgiumIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }
}
