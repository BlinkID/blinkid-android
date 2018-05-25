package com.microblink.result.extract.blinkid.singapore;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SingaporeIDBackRecognitionResultExtractor extends BaseResultExtractor<SingaporeIDBackRecognizer.Result, SingaporeIDBackRecognizer> {

    @Override
    protected void extractData(SingaporeIDBackRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPBloodGroup,
                result.getBloodGroup()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDocumentDateOfIssue()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));
    }

}