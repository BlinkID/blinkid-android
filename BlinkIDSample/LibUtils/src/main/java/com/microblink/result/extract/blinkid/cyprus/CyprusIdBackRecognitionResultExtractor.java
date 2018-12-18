package com.microblink.result.extract.blinkid.cyprus;

import com.microblink.entities.recognizers.blinkid.cyprus.CyprusIdBackRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CyprusIdBackRecognitionResultExtractor extends BlinkIdExtractor<CyprusIdBackRecognizer.Result, CyprusIdBackRecognizer> {
    @Override
    protected void extractData(CyprusIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }
}
