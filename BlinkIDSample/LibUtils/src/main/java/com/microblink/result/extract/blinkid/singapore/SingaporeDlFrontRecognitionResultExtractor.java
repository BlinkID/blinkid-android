package com.microblink.result.extract.blinkid.singapore;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeDlFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeDlFrontRecognitionResultExtractor extends BlinkIdExtractor<SingaporeDlFrontRecognizer.Result, SingaporeDlFrontRecognizer> {

    @Override
    protected void extractData(SingaporeDlFrontRecognizer.Result singaporeDlFrontResult) {
        add(R.string.PPLicenceNumber, singaporeDlFrontResult.getLicenceNumber());
        add(R.string.PPName, singaporeDlFrontResult.getName());
        add(R.string.PPDateOfBirth, singaporeDlFrontResult.getBirthDate());
        add(R.string.PPIssueDate, singaporeDlFrontResult.getIssueDate());
        add(R.string.PPValidUntil, singaporeDlFrontResult.getValidTill());
    }
}
