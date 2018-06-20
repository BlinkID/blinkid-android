package com.microblink.result.extract.blinkid.czechia;

import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class CzechIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<CzechiaIdBackRecognizer.Result, CzechiaIdBackRecognizer> {

    @Override
    protected void extractData(CzechiaIdBackRecognizer.Result result) {
        super.extractData(result);
        add(R.string.PPAddress, result.getPermanentStay());
        add(R.string.PPPersonalNumber, result.getPersonalNumber());
        add(R.string.PPAuthority, result.getAuthority());
    }

}
