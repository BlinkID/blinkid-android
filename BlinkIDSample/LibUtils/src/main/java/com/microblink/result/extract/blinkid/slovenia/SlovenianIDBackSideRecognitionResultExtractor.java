package com.microblink.result.extract.blinkid.slovenia;

import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SlovenianIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<SloveniaIdBackRecognizer.Result, SloveniaIdBackRecognizer> {

    @Override
    protected void extractData(SloveniaIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAdministrativeUnit, result.getAdministrativeUnit());
        add(R.string.PPIssueDate, result.getDateOfIssue());
    }

}
