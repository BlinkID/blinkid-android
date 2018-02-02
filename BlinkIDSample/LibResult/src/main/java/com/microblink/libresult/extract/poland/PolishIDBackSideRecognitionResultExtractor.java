package com.microblink.libresult.extract.poland;

import android.content.Context;

import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognitionResult;
import com.microblink.recognizers.blinkid.poland.back.PolishIDBackSideRecognitionResult;

import java.util.List;

/**
 * Created by daniel on 10/4/17.
 */
public class PolishIDBackSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public PolishIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof PolishIDBackSideRecognitionResult){
            // result is obtained by scanning the back side of Polish IDs
            PolishIDBackSideRecognitionResult polishIDBackResult = (PolishIDBackSideRecognitionResult) result;

            super.extractMRZData((MRTDRecognitionResult) result);
        }

        return mExtractedData;
    }
}
