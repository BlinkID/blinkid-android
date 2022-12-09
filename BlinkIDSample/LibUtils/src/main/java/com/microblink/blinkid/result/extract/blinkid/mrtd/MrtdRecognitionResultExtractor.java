package com.microblink.blinkid.result.extract.blinkid.mrtd;

import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class MrtdRecognitionResultExtractor extends BlinkIdExtractor<MrtdRecognizer.Result, MrtdRecognizer> {

    @Override
    protected void extractData(MrtdRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        TemplateDataExtractor templateDataExtractor = new TemplateDataExtractor();
        mExtractedData.addAll(templateDataExtractor.extract(mContext, mRecognizer));
    }

}
