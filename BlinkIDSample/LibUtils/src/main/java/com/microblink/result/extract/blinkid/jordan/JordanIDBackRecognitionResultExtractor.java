package com.microblink.result.extract.blinkid.jordan;

import com.microblink.entities.recognizers.blinkid.jordan.JordanIdBackRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class JordanIDBackRecognitionResultExtractor extends BlinkIdExtractor<JordanIdBackRecognizer.Result, JordanIdBackRecognizer> {

    @Override
    protected void extractData(JordanIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}