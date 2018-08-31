package com.microblink.result.extract.blinkid.croatia;

import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CroatianIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<CroatiaIdBackRecognizer.Result, CroatiaIdBackRecognizer> {

    @Override
    protected void extractData(CroatiaIdBackRecognizer.Result result) {

        extractMRZResult(result.getMrzResult());

        add(R.string.PPResidence, result.getResidence());
        add(R.string.PPDocumentForNonResidents, result.isDocumentForNonResident());
        add(R.string.PPIssuingAuthority, result.getIssuedBy());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());
    }

}
