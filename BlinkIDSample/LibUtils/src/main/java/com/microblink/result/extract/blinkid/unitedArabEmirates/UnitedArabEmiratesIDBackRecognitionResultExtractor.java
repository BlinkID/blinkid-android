package com.microblink.result.extract.blinkid.unitedArabEmirates;

import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdBackRecognizer;
import com.microblink.result.extract.BaseResultExtractor;

public class UnitedArabEmiratesIDBackRecognitionResultExtractor extends BaseResultExtractor<UnitedArabEmiratesIdBackRecognizer.Result, UnitedArabEmiratesIdBackRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}

