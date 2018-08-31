package com.microblink.result.extract.blinkid.paymentcard;

import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class PaymentCardFrontRecognitionResultExtractor extends BlinkIdExtractor<PaymentCardFrontRecognizer.Result, PaymentCardFrontRecognizer> {
    @Override
    protected void extractData(PaymentCardFrontRecognizer.Result result) {
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        add(R.string.PPOwner, result.getOwner());
        add(R.string.PPValidThru, result.getValidThru());
    }
}