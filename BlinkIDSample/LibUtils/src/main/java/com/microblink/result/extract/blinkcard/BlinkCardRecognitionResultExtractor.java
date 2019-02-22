package com.microblink.result.extract.blinkcard;

import com.microblink.entities.recognizers.blinkcard.BlinkCardRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BlinkCardRecognitionResultExtractor extends BlinkIdExtractor<BlinkCardRecognizer.Result, BlinkCardRecognizer> {

    @Override
    protected void extractData(BlinkCardRecognizer.Result result) {
        add(R.string.PPIssuer, result.getIssuer().name());
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        addIfNotEmpty(R.string.PPOwner, result.getOwner());
        add(R.string.PPValidThru, result.getValidThru().getOriginalDateString());
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
    }


}
