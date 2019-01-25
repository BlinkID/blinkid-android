package com.microblink.result.extract.blinkid.brunei;
import com.microblink.entities.recognizers.blinkid.brunei.BruneiIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BruneiIdBackRecognitionResultExtractor extends BlinkIdExtractor<BruneiIdBackRecognizer.Result, BruneiIdBackRecognizer> {

        @Override
        protected void extractData(BruneiIdBackRecognizer.Result result) {
            extractMRZResult(result.getMrzResult());

            add(R.string.PPRace, result.getRace());
            add(R.string.PPAddress, result.getAddress());
            add(R.string.PPIssueDate, result.getDateOfIssue());
        }

}
