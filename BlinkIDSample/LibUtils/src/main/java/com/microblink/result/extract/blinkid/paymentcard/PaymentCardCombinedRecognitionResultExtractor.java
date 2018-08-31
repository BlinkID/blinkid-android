package com.microblink.result.extract.blinkid.paymentcard;

import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class PaymentCardCombinedRecognitionResultExtractor extends BlinkIdExtractor<PaymentCardCombinedRecognizer.Result, PaymentCardCombinedRecognizer> {

    @Override
    protected void extractData(PaymentCardCombinedRecognizer.Result result) {
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        add(R.string.PPOwner, result.getOwner());
        add(R.string.PPValidThru, result.getValidThru());
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
    }


}
