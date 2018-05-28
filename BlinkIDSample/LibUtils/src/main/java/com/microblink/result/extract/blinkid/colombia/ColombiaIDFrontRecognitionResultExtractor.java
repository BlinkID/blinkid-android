package com.microblink.result.extract.blinkid.colombia;

import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class ColombiaIDFrontRecognitionResultExtractor extends BaseResultExtractor<ColombiaIDFrontSideRecognizer.Result, ColombiaIDFrontSideRecognizer> {

    @Override
    protected void extractData(ColombiaIDFrontSideRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, result.getDocumentNumber()));
        mExtractedData.add(mBuilder.build(R.string.PPFirstName, result.getOwnerFirsName()));
        mExtractedData.add(mBuilder.build(R.string.PPLastName, result.getOwnerLastName()));
    }

}
