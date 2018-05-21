package com.microblink.result.extract.detector;

import android.content.Context;

import com.microblink.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by dodo on 20/11/15.
 */
public class DetectorRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public DetectorRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof DetectorRecognizer) {
            DetectorRecognizer detectorRecognizer = (DetectorRecognizer) result;

            mExtractedData.add(mBuilder.build(R.string.MBRecognitionStatus, detectorRecognizer.getResult().getResultState().name()));

            // add detection location
            mExtractedData.add(mBuilder.build(R.string.PPDetectorResult, detectorRecognizer.getDetector().getResult().toString()));

            extractTemplateData(detectorRecognizer);
        }

        return mExtractedData;
    }


}
