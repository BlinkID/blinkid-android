package com.microblink.result.extract.blinkid.croatia;

import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class CroatianIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<CroatiaIdBackRecognizer.Result, CroatiaIdBackRecognizer> {

    @Override
    protected void extractData(CroatiaIdBackRecognizer.Result result) {
        super.extractData(result);

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPDocumentForNonResidents, result.documentForNonResident());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiryPermanent, result.getDateOfExpiryPermanent());
    }

}
