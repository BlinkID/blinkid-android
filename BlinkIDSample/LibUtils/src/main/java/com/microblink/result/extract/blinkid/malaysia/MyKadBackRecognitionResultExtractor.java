package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyKadBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class MyKadBackRecognitionResultExtractor extends BlinkIdExtractor<MalaysiaMyKadBackRecognizer.Result, MalaysiaMyKadBackRecognizer> {

    @Override
    protected void extractData(MalaysiaMyKadBackRecognizer.Result result) {
        add(R.string.PPNRICNumber, result.getNric());
        add(R.string.PPExtendedNRIC, result.getExtendedNric());
        add(R.string.PPOldNRIC, result.getOldNric());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}