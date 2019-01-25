package com.microblink.result.extract.blinkid.mrtd;

import com.microblink.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class MRTDCombinedRecognitionResultExtractor extends BlinkIdExtractor<MrtdCombinedRecognizer.Result, MrtdCombinedRecognizer> {

    @Override
    protected void extractData(MrtdCombinedRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }

}
