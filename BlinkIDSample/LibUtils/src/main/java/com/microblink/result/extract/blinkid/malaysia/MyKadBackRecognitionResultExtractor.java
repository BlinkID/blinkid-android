package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class MyKadBackRecognitionResultExtractor extends BaseResultExtractor<MyKadBackRecognizer.Result, MyKadBackRecognizer> {

    @Override
    protected void extractData(MyKadBackRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPExtendedNRIC,
                result.getExtendedNRIC()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNRICNumber,
                result.getNRIC()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));
    }

}