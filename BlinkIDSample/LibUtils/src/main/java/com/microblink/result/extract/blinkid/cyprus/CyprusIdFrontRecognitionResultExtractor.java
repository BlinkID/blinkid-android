package com.microblink.result.extract.blinkid.cyprus;

import com.microblink.entities.recognizers.blinkid.cyprus.CyprusIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CyprusIdFrontRecognitionResultExtractor extends BlinkIdExtractor<CyprusIdFrontRecognizer.Result, CyprusIdFrontRecognizer > {
    @Override
    protected void extractData(CyprusIdFrontRecognizer.Result result) {
        add(R.string.PPIdentityCardNumber, result.getIdNumber());
    }
}
