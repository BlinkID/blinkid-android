package com.microblink.result.extract.blinkid.egypt;

import com.microblink.entities.recognizers.blinkid.egypt.EgyptIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;


public class EgyptIDFrontRecognitionResultExtractor extends BaseResultExtractor<EgyptIDFrontRecognizer.Result, EgyptIDFrontRecognizer> {

    @Override
    protected void extractData(EgyptIDFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, result.getDocumentNumber()));
        mExtractedData.add(mBuilder.build(R.string.PPNationalNumber, result.getNationalNumber()));
    }
}
