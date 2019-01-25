package com.microblink.result.extract.blinkid.slovakia;

import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SlovakIDBackSideRecognitionResultExtractor extends BlinkIdExtractor<SlovakiaIdBackRecognizer.Result, SlovakiaIdBackRecognizer> {

    @Override
    protected void extractData(SlovakiaIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPSurnameAtBirth, result.getSurnameAtBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPSpecialRemarks, result.getSpecialRemarks());
    }

}
