package com.microblink.result.extract.blinkid.colombia;

import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class ColombiaIDFrontRecognitionResultExtractor extends BlinkIdExtractor<ColombiaIdFrontRecognizer.Result, ColombiaIdFrontRecognizer> {

    @Override
    protected void extractData(ColombiaIdFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFirstName, result.getLastName());
        add(R.string.PPLastName, result.getFirstName());
    }

}
