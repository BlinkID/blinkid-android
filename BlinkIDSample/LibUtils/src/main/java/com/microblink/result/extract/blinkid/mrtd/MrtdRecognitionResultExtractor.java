package com.microblink.result.extract.blinkid.mrtd;

import com.microblink.entities.recognizers.blinkid.mrtd.MRTDRecognizer;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.result.extract.blinkinput.TemplateDataExtractor;

public class MrtdRecognitionResultExtractor extends BaseResultExtractor<MRTDRecognizer.Result, MRTDRecognizer> {

    @Override
    protected void extractData(MRTDRecognizer.Result result) {
        extractMRZResult(result.getMRZResult());

        TemplateDataExtractor templateDataExtractor = new TemplateDataExtractor();
        mExtractedData.addAll(templateDataExtractor.extract(mContext, mRecognizer));
    }

}
