package com.microblink.result.extract.blinkcard;

import com.microblink.entities.recognizers.blinkcard.BlinkCardEliteRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BlinkCardEliteRecognitionResultExtractor extends BlinkIdExtractor<BlinkCardEliteRecognizer.Result, BlinkCardEliteRecognizer> {
    @Override
    protected void extractData(BlinkCardEliteRecognizer.Result result) {
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        add(R.string.PPOwner, result.getOwner());
        add(R.string.PPValidThru, result.getValidThru());
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
    }
}
