package com.microblink.result.extract.blinkid.kuwait;

import com.microblink.entities.recognizers.blinkid.kuwait.KuwaitIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class KuwaitIdBackRecognitionResultExtractor  extends BlinkIdExtractor<KuwaitIdBackRecognizer.Result, KuwaitIdBackRecognizer> {

    @Override
    protected void extractData(KuwaitIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        add(R.string.PPSerialNo, result.getSerialNo());
    }
}