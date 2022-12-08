package com.microblink.blinkid.result.extract.blinkid.mrtd;

import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class MRTDCombinedRecognitionResultExtractor extends BlinkIdExtractor<MrtdCombinedRecognizer.Result, MrtdCombinedRecognizer> {

    @Override
    protected void extractData(MrtdCombinedRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPDocumentBothSidesMatch, result.getDocumentDataMatch().name());
    }

}
