package com.microblink.result.extract.blinkid.cyprus;

import com.microblink.entities.recognizers.blinkid.cyprus.CyprusIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CyprusIdBackRecognitionResultExtractor extends BlinkIdExtractor< CyprusIdBackRecognizer.Result, CyprusIdBackRecognizer> {
    @Override
    protected void extractData(CyprusIdBackRecognizer.Result result) {
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfExpiry, result.getExpiresOn());
    }
}
