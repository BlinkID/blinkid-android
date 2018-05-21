package com.microblink.result.extract.unitedArabEmirates;

import  android.content.Context;

import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

public class UnitedArabEmiratesIDBackRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory
{
    public UnitedArabEmiratesIDBackRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof UnitedArabEmiratesIDBackRecognizer){
            // result is obtained by scanning the back side of United Arab Emirates IDs
            UnitedArabEmiratesIDBackRecognizer.Result unitedArabEmiratesIDBackResult = ((UnitedArabEmiratesIDBackRecognizer) result).getResult();
            extractMRZResult(unitedArabEmiratesIDBackResult.getMRZResult(), mExtractedData, mBuilder);
            BlinkIDExtractionUtils.extractCommonData(unitedArabEmiratesIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}

