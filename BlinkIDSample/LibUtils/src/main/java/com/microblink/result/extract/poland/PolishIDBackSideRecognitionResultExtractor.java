package com.microblink.result.extract.poland;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.poland.PolishIDBackSideRecognizer;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by daniel on 10/4/17.
 */
public class PolishIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public PolishIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof PolishIDBackSideRecognizer.Result){
            // result is obtained by scanning the back side of Polish IDs
            PolishIDBackSideRecognizer.Result plIDBackResult = (PolishIDBackSideRecognizer.Result) result;
            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(plIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
