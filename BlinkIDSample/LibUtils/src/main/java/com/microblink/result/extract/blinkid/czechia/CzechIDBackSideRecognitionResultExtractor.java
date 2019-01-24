package com.microblink.result.extract.blinkid.czechia;

import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CzechIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<CzechiaIdBackRecognizer.Result, CzechiaIdBackRecognizer> {

    @Override
    protected void extractData(CzechiaIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPAddress, result.getPermanentStay());
        add(R.string.PPPersonalNumber, result.getPersonalNumber());
        add(R.string.PPAuthority, result.getAuthority());
    }

}
