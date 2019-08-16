package com.microblink.result.extract.blinkid.belgium;

import com.microblink.entities.recognizers.blinkid.belgium.BelgiumIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BelgiumIdFrontRecognizerResultExtractor extends BlinkIdExtractor<BelgiumIdFrontRecognizer.Result, BelgiumIdFrontRecognizer> {

    @Override
    protected void extractData(BelgiumIdFrontRecognizer.Result belgiumIdFrontRecognizerResult) {
        add(R.string.PPIdentityCardNumber, belgiumIdFrontRecognizerResult.getCardNumber());
    }

}
