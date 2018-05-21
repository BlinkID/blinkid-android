package com.microblink.result.extract.serbia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.serbia.SerbianIDBackRecognizer;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by Boris on 26/08/16.
 */
public class SerbianIDBackRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public SerbianIDBackRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SerbianIDBackRecognizer.Result) {
            SerbianIDBackRecognizer.Result srbIDBackResult = (SerbianIDBackRecognizer.Result) result;
            super.extractMRZData(result);
            BlinkIDExtractionUtils.extractCommonData(srbIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
