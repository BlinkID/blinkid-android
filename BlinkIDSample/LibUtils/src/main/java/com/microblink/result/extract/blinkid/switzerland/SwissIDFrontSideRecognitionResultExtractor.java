package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SwissIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<SwitzerlandIdFrontRecognizer.Result, SwitzerlandIdFrontRecognizer> {

    @Override
    protected void extractData(SwitzerlandIdFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}

