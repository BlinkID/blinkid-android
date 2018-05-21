package com.microblink.result.extract.jordan;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.jordan.JordanIDBackRecognizer;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

public class JordanIDBackRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory
{
    public JordanIDBackRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof JordanIDBackRecognizer.Result){
            // result is obtained by scanning the back side of Jordan IDs
            JordanIDBackRecognizer.Result jordanIDBackResult = (JordanIDBackRecognizer.Result) result;

            BlinkIDExtractionUtils.extractCommonData(jordanIDBackResult, mExtractedData, mBuilder);
            super.extractMRZData(jordanIDBackResult);
        }

        return mExtractedData;
    }
}