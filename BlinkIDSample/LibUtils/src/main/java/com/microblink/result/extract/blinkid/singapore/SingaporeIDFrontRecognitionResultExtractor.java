package com.microblink.result.extract.blinkid.singapore;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SingaporeIDFrontRecognitionResultExtractor extends BaseResultExtractor<SingaporeIDFrontRecognizer.Result, SingaporeIDFrontRecognizer> {

    @Override
    protected void extractData(SingaporeIDFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFullName,
                result.getName()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPRace,
                result.getRace()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPCountryOfBirth,
                result.getCountryOfBirth()
        ));
    }

}