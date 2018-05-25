package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SwissIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<SwitzerlandIDFrontRecognizer.Result, SwitzerlandIDFrontRecognizer> {

    @Override
    protected void extractData(SwitzerlandIDFrontRecognizer.Result result) {

        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));
    }

}

