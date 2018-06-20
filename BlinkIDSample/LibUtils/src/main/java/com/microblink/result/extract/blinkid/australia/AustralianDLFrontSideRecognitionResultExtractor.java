package com.microblink.result.extract.blinkid.australia;

import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class AustralianDLFrontSideRecognitionResultExtractor extends BlinkIdExtractor<AustraliaDlFrontRecognizer.Result, AustraliaDlFrontRecognizer> {

    @Override
    protected void extractData(AustraliaDlFrontRecognizer.Result result) {
        add(R.string.PPFullName, result.getName());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPLicenceType, result.getLicenceType());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }

}
