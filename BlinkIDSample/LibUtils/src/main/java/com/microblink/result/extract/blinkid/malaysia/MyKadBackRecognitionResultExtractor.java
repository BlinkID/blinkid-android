package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class MyKadBackRecognitionResultExtractor extends BlinkIdExtractor<MyKadBackRecognizer.Result, MyKadBackRecognizer> {

    @Override
    protected void extractData(MyKadBackRecognizer.Result result) {
        add(R.string.PPNRICNumber, result.getNric());
        add(R.string.PPExtendedNRIC, result.getExtendedNric());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
    }

}