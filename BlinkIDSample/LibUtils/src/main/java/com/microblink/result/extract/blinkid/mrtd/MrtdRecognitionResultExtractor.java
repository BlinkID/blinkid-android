package com.microblink.result.extract.blinkid.mrtd;

import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.result.extract.blinkinput.TemplateDataExtractor;

public class MrtdRecognitionResultExtractor extends BlinkIdExtractor<MrtdRecognizer.Result, MrtdRecognizer> {

    @Override
    protected void extractData(MrtdRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        TemplateDataExtractor templateDataExtractor = new TemplateDataExtractor();
        mExtractedData.addAll(templateDataExtractor.extract(mContext, mRecognizer));
    }

}
