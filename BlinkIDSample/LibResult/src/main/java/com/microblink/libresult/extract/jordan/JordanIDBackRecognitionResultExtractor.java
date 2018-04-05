package com.microblink.libresult.extract.jordan;


import android.content.Context;

import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.jordan.back.JordanIDBackRecognitionResult;

import java.util.List;

public class JordanIDBackRecognitionResultExtractor extends MRTDRecognitionResultExtractor
{
    public JordanIDBackRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof JordanIDBackRecognitionResult){
            super.extractMRZData((JordanIDBackRecognitionResult) result);
        }

        return mExtractedData;
    }
}