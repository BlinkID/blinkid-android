package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class GermanIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<GermanyIDFrontSideRecognizer.Result, GermanyIDFrontSideRecognizer> {

    @Override
    protected void extractData(GermanyIDFrontSideRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                result.getNationality()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPlaceOfBirth,
                result.getPlaceOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getIdentityCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDateOfExpiry()
        ));
    }

}
