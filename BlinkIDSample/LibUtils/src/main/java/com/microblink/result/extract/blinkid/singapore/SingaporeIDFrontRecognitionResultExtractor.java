package com.microblink.result.extract.blinkid.singapore;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeIDFrontRecognitionResultExtractor extends BlinkIdExtractor<SingaporeIdFrontRecognizer.Result, SingaporeIdFrontRecognizer> {

    @Override
    protected void extractData(SingaporeIdFrontRecognizer.Result result) {
        add(R.string.PPIdentityCardNumber, result.getIdentityCardNumber());
        add(R.string.PPFullName, result.getName());
        add(R.string.PPRace, result.getRace());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPCountryOfBirth, result.getCountryOfBirth());
    }

}