package com.microblink.result.extract.blinkid.unitedArabEmirates;

import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdBackRecognizer;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class UnitedArabEmiratesIDBackRecognitionResultExtractor extends BlinkIdExtractor<UnitedArabEmiratesIdBackRecognizer.Result, UnitedArabEmiratesIdBackRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesIdBackRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());
    }

}

