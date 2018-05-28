package com.microblink.result.extract.blinkid.croatia;

import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class CroatianIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<CroatiaIDBackSideRecognizer.Result, CroatiaIDBackSideRecognizer> {

    @Override
    protected void extractData(CroatiaIDBackSideRecognizer.Result result) {
        super.extractData(result);

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentForNonResidents,
                result.documentForNonResident()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPIssuingAuthority,
                result.getIssuingAuthority()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDocumentDateOfIssue()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiryPermanent,
                result.getDocumentDateOfExpiryPermanent()
        ));
    }

}
