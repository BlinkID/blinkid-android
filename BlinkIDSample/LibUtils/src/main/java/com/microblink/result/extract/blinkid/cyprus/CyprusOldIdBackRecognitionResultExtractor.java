package com.microblink.result.extract.blinkid.cyprus;

import com.microblink.entities.recognizers.blinkid.cyprus.CyprusOldIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CyprusOldIdBackRecognitionResultExtractor extends BlinkIdExtractor< CyprusOldIdBackRecognizer.Result, CyprusOldIdBackRecognizer> {
    @Override
    protected void extractData(CyprusOldIdBackRecognizer.Result result) {
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfExpiry, result.getExpiresOn());
    }
}
