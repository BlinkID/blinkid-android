package com.microblink.result.extract;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.libutils.R;
import com.microblink.result.ResultSource;

public class SuccessFrameGrabberResultExtractor extends BaseResultExtractor<SuccessFrameGrabberRecognizer.Result, SuccessFrameGrabberRecognizer> {

    @Override
    protected void extractData(SuccessFrameGrabberRecognizer.Result result) {
        Recognizer slaveRecognizer = mRecognizer.getSlaveRecognizer();
        BaseResultExtractor slaveExtractor = ResultExtractorFactoryProvider.get().createExtractor(slaveRecognizer);
        mExtractedData.addAll(slaveExtractor.extractData(mContext, slaveRecognizer, ResultSource.MIXED));
        mExtractedData.add(mBuilder.build(
                R.string.PPSuccessFrame,
                mRecognizer.getResult().getSuccessFrame()
        ));
    }
}
