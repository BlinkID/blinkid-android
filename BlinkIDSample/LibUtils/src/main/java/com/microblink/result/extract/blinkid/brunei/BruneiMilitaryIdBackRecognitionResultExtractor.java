package com.microblink.result.extract.blinkid.brunei;

import com.microblink.entities.recognizers.blinkid.brunei.BruneiMilitaryIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BruneiMilitaryIdBackRecognitionResultExtractor extends BlinkIdExtractor<BruneiMilitaryIdBackRecognizer.Result, BruneiMilitaryIdBackRecognizer> {

    @Override
    protected void extractData(BruneiMilitaryIdBackRecognizer.Result result) {
        add(R.string.PPArmyNumber, result.getArmyNumber());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }

}
