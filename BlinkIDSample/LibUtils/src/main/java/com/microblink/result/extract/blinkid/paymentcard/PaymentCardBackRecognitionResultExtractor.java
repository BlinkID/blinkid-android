package com.microblink.result.extract.blinkid.paymentcard;

import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class PaymentCardBackRecognitionResultExtractor extends BlinkIdExtractor<PaymentCardBackRecognizer.Result, PaymentCardBackRecognizer> {
    @Override
    protected void extractData(PaymentCardBackRecognizer.Result result) {
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
    }
}