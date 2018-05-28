package com.microblink.result.extract.blinkid.jordan;

import com.microblink.entities.recognizers.blinkid.jordan.JordanIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class JordanIDFrontRecognitionResultExtractor extends BaseResultExtractor<JordanIDFrontRecognizer.Result, JordanIDFrontRecognizer> {

    @Override
    protected void extractData(JordanIDFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPNationalNumber,
                result.getNatianalNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPName,
                result.getName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));
    }

}
