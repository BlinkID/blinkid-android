package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SwissIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<SwitzerlandIdFrontRecognizer.Result, SwitzerlandIdFrontRecognizer> {

    @Override
    protected void extractData(SwitzerlandIdFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getGivenName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}

