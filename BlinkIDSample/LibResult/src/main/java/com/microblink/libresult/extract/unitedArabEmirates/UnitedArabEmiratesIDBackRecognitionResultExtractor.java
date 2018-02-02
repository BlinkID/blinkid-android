package com.microblink.libresult.extract.unitedArabEmirates;

import android.content.Context;

import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.unitedArabEmirates.back.UnitedArabEmiratesIDBackRecognitionResult;

import java.util.List;


public class UnitedArabEmiratesIDBackRecognitionResultExtractor extends
        MRTDRecognitionResultExtractor
{
    public UnitedArabEmiratesIDBackRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof UnitedArabEmiratesIDBackRecognitionResult){
            // result is obtained by scanning the back side of United Arab Emirates IDs
            UnitedArabEmiratesIDBackRecognitionResult
                    unitedArabEmiratesIDBackResult = (UnitedArabEmiratesIDBackRecognitionResult) result;

            super.extractMRZData(unitedArabEmiratesIDBackResult);
        }

        return mExtractedData;
    }
}

