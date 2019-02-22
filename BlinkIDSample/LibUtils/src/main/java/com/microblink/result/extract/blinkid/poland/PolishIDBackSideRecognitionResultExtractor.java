package com.microblink.result.extract.blinkid.poland;

import com.microblink.entities.recognizers.blinkid.poland.PolandIdBackRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class PolishIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<PolandIdBackRecognizer.Result, PolandIdBackRecognizer> {

    @Override
    protected void extractData(PolandIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}
