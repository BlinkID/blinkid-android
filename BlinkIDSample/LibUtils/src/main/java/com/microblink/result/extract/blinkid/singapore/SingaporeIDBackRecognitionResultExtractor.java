package com.microblink.result.extract.blinkid.singapore;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeIDBackRecognitionResultExtractor extends BlinkIdExtractor<SingaporeIdBackRecognizer.Result, SingaporeIdBackRecognizer> {

    @Override
    protected void extractData(SingaporeIdBackRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getCardNumber());
        add(R.string.PPBloodType, result.getBloodGroup());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPAddress, result.getAddress());
    }

}