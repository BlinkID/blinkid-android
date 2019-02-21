package com.microblink.result.extract.blinkid.brunei;

import com.microblink.entities.recognizers.blinkid.brunei.BruneiTemporaryResidencePermitBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BruneiTemporaryResidencePermitBackRecognitionResultExtractor extends BlinkIdExtractor<BruneiTemporaryResidencePermitBackRecognizer.Result, BruneiTemporaryResidencePermitBackRecognizer> {

        @Override
        protected void extractData(BruneiTemporaryResidencePermitBackRecognizer.Result result) {
            extractMRZResult(result.getMrzResult());

            add(R.string.PPPassportNumber, result.getPassportNumber());
            add(R.string.PPAddress, result.getAddress());
            add(R.string.PPIssueDate, result.getDateOfIssue());
        }

}
