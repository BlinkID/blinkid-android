package com.microblink.result.extract.blinkid.serbia;

import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SerbianIDFrontRecognitionResultExtractor extends BaseResultExtractor<SerbiaIDFrontRecognizer.Result, SerbiaIDFrontRecognizer> {

    @Override
    protected void extractData(SerbiaIDFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getIssuingDate()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPValidUntil,
                result.getValidUntil()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getDocumentNumber()
        ));
    }

}
