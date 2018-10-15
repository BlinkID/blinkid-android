package com.microblink.result.extract.blinkid.elitepaymentcard;

import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class ElitePaymentCardBackRecognitionResultExtractor extends BlinkIdExtractor<ElitePaymentCardBackRecognizer.Result, ElitePaymentCardBackRecognizer> {

    @Override
    protected void extractData(ElitePaymentCardBackRecognizer.Result result) {
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        add(R.string.PPValidThru, result.getValidThru());
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
    }
}
