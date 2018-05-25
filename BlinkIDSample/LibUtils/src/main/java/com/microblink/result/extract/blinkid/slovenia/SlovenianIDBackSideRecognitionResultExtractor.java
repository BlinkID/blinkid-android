package com.microblink.result.extract.blinkid.slovenia;

import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class SlovenianIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<SloveniaIDBackRecognizer.Result, SloveniaIDBackRecognizer> {

    @Override
    protected void extractData(SloveniaIDBackRecognizer.Result result) {
        super.extractData(result);

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPIssuingAuthority,
                result.getAuthority()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDateOfIssue()
        ));
    }

}
