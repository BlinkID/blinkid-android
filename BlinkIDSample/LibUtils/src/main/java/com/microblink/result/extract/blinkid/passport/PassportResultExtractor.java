package com.microblink.result.extract.blinkid.passport;

import com.microblink.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class PassportResultExtractor extends BlinkIdExtractor<PassportRecognizer.Result, PassportRecognizer> {

    @Override
    protected void extractData(PassportRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}
