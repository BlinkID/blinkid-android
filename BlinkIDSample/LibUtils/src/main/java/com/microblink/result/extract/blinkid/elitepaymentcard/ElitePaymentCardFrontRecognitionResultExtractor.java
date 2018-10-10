package com.microblink.result.extract.blinkid.elitepaymentcard;

import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class ElitePaymentCardFrontRecognitionResultExtractor extends BlinkIdExtractor<ElitePaymentCardFrontRecognizer.Result, ElitePaymentCardFrontRecognizer> {
    @Override
    protected void extractData(ElitePaymentCardFrontRecognizer.Result result) {
        add(R.string.PPOwner, result.getOwner());
    }
}
