package com.microblink.result.extract.blinkid.mrtd;

import com.microblink.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.libresult.R;

public class MRTDCombinedRecognitionResultExtractor extends MrtdResultExtractor<MrtdCombinedRecognizer.Result, MrtdCombinedRecognizer> {

    @Override
    protected void extractData(MrtdCombinedRecognizer.Result result) {
        super.extractData(result);
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }

}
