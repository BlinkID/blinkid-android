package com.microblink.result.extract.blinkid.slovenia;

import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SlovenianIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<SloveniaIDFrontRecognizer.Result, SloveniaIDFrontRecognizer> {

    @Override
    protected void extractData(SloveniaIDFrontRecognizer.Result sloIdFrontResult) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                sloIdFrontResult.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                sloIdFrontResult.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                sloIdFrontResult.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                sloIdFrontResult.getNationality()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                sloIdFrontResult.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                sloIdFrontResult.getDateOfExpiry()
        ));
    }

}
