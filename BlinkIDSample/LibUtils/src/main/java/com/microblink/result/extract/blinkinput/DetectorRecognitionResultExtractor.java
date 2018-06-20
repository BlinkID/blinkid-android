package com.microblink.result.extract.blinkinput;

import com.microblink.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class DetectorRecognitionResultExtractor extends BaseResultExtractor<DetectorRecognizer.Result, DetectorRecognizer> {

    @Override
    protected void extractData(DetectorRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.MBRecognitionStatus, result.getResultState().name()));
        // add detection location
        mExtractedData.add(mBuilder.build(R.string.PPDetectorResult, mRecognizer.getDetector().getResult().toString()));

        TemplateDataExtractor templateDataExtractor = new TemplateDataExtractor();
        mExtractedData.addAll(templateDataExtractor.extract(mContext, mRecognizer));
    }

}
