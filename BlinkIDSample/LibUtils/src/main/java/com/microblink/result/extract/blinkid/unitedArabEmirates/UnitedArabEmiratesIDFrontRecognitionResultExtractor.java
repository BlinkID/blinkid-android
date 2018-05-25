package com.microblink.result.extract.blinkid.unitedArabEmirates;

import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class UnitedArabEmiratesIDFrontRecognitionResultExtractor extends BaseResultExtractor<UnitedArabEmiratesIDFrontRecognizer.Result, UnitedArabEmiratesIDFrontRecognizer> {

    @Override
    protected void extractData(UnitedArabEmiratesIDFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPIdentityCardNumber,
                result.getIdNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPName,
                result.getName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                result.getNationality()
        ));
    }

}