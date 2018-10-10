package com.microblink.result.extract.blinkid.elitepaymentcard;

import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class ElitePaymentCardCombinedRecognitionResultExtractor extends BlinkIdExtractor<ElitePaymentCardCombinedRecognizer.Result, ElitePaymentCardCombinedRecognizer> {
    @Override
    protected void extractData(ElitePaymentCardCombinedRecognizer.Result result) {
        add(R.string.PPPaymentCardNumber, result.getCardNumber());
        add(R.string.PPOwner, result.getOwner());
        add(R.string.PPValidThru, result.getValidThru());
        add(R.string.PPCVV, result.getCvv());
        add(R.string.PPInventoryNumber, result.getInventoryNumber());
    }
}
