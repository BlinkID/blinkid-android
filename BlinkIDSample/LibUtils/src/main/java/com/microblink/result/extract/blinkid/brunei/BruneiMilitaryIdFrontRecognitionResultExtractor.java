package com.microblink.result.extract.blinkid.brunei;

import com.microblink.entities.recognizers.blinkid.brunei.BruneiMilitaryIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BruneiMilitaryIdFrontRecognitionResultExtractor extends BlinkIdExtractor<BruneiMilitaryIdFrontRecognizer.Result, BruneiMilitaryIdFrontRecognizer> {

    @Override
    protected void extractData(BruneiMilitaryIdFrontRecognizer.Result result) {
        add(R.string.PPRank, result.getRank());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}
