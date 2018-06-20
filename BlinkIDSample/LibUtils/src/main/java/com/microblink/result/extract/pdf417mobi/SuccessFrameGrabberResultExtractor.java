package com.microblink.result.extract.pdf417mobi;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.result.extract.ResultExtractorFactoryProvider;

public class SuccessFrameGrabberResultExtractor extends BaseResultExtractor<SuccessFrameGrabberRecognizer.Result, SuccessFrameGrabberRecognizer> {

    @Override
    protected void extractData(SuccessFrameGrabberRecognizer.Result result) {
        Recognizer slaveRecognizer = mRecognizer.getSlaveRecognizer();
        BaseResultExtractor slaveExtractor = ResultExtractorFactoryProvider.get().createExtractor(slaveRecognizer);
        mExtractedData.addAll(slaveExtractor.extractData(mContext, slaveRecognizer));
        mExtractedData.add(mBuilder.build(
                R.string.PPSuccessFrame,
                mRecognizer.getResult().getSuccessFrame()
        ));
    }
}
