package com.microblink.result.extract.blinkid.slovenia;

import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class SlovenianIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<SloveniaIdBackRecognizer.Result, SloveniaIdBackRecognizer> {

    @Override
    protected void extractData(SloveniaIdBackRecognizer.Result result) {
        super.extractData(result);
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssuingAuthority, result.getAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
    }

}
