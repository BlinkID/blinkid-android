package com.microblink.result.extract.blinkid.brunei;
import com.microblink.entities.recognizers.blinkid.brunei.BruneiResidencePermitBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BruneiResidencePermitBackRecognitionResultExtractor extends BlinkIdExtractor<BruneiResidencePermitBackRecognizer.Result, BruneiResidencePermitBackRecognizer> {

        @Override
        protected void extractData(BruneiResidencePermitBackRecognizer.Result result) {
            extractMRZResult(result.getMrzResult());

            add(R.string.PPRace, result.getRace());
            add(R.string.PPAddress, result.getAddress());
            add(R.string.PPIssueDate, result.getDateOfIssue());
        }

}
