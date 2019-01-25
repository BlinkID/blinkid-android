package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyIdOldRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class GermanOldIDRecognitionResultExtractor extends BlinkIdExtractor<GermanyIdOldRecognizer.Result, GermanyIdOldRecognizer> {

    @Override
    protected void extractData(GermanyIdOldRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
    }

}
