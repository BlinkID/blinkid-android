package com.microblink.blinkid.result.extract.blinkid.passport;

import com.microblink.blinkid.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class PassportResultExtractor extends BlinkIdExtractor<PassportRecognizer.Result, PassportRecognizer> {

    @Override
    protected void extractData(PassportRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}
