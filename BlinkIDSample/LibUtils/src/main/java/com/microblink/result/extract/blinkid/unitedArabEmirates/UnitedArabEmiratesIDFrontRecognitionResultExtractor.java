package com.microblink.result.extract.blinkid.unitedArabEmirates;

import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class UnitedArabEmiratesIDFrontRecognitionResultExtractor extends BlinkIdExtractor<UnitedArabEmiratesIdFrontRecognizer.Result, UnitedArabEmiratesIdFrontRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesIdFrontRecognizer.Result result) {
        add(R.string.PPIdentityCardNumber, result.getIdNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPNationality, result.getNationality());
    }

}