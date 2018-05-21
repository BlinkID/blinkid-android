package com.microblink.result.extract.successFrame;

import android.content.Context;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.libresult.R;
import com.microblink.recognizers.BaseLegacyRecognizerWrapper;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.RecognitionResultExtractorFactory;

import java.util.ArrayList;
import java.util.List;

public final class SuccessFrameGrabberResultExtractor implements IBaseRecognitionResultExtractor{
    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;
    private Context mContext;

    public SuccessFrameGrabberResultExtractor(Context context) {
        mContext = context;
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if ( result instanceof SuccessFrameGrabberRecognizer ) {

            SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = (SuccessFrameGrabberRecognizer) result;
            Recognizer slaveRecognizer = successFrameGrabberRecognizer.getSlaveRecognizer();

            IBaseRecognitionResultExtractor slaveExtractor = RecognitionResultExtractorFactory.createExtractor(
                    mContext,
                    slaveRecognizer
            );

            if (slaveRecognizer instanceof BaseLegacyRecognizerWrapper) {
                mExtractedData.addAll(slaveExtractor.extractData(slaveRecognizer.getResult()));
            } else {
                mExtractedData.addAll(slaveExtractor.extractData(slaveRecognizer));
            }

            mExtractedData.add(mBuilder.build(
                    R.string.PPSuccessFrame,
                    successFrameGrabberRecognizer.getResult().getSuccessFrame()
            ));

        }

        return mExtractedData;
    }
}
