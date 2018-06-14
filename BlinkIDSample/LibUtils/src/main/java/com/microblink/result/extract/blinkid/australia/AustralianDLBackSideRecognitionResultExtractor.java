package com.microblink.result.extract.blinkid.australia;

import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class AustralianDLBackSideRecognitionResultExtractor extends BaseResultExtractor<AustraliaDlBackRecognizer.Result, AustraliaDlBackRecognizer> {

    @Override
    protected void extractData(AustraliaDlBackRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }

}
