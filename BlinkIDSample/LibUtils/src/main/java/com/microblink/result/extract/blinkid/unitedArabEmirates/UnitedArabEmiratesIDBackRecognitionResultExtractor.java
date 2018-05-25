package com.microblink.result.extract.blinkid.unitedArabEmirates;

import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer;
import com.microblink.result.extract.BaseResultExtractor;

public class UnitedArabEmiratesIDBackRecognitionResultExtractor extends BaseResultExtractor<UnitedArabEmiratesIDBackRecognizer.Result, UnitedArabEmiratesIDBackRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesIDBackRecognizer.Result result) {
        extractMRZResult(result.getMRZResult());
    }

}

