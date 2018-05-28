package com.microblink.result.extract.blinkid.czechia;

import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class CzechIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<CzechiaIDFrontSideRecognizer.Result, CzechiaIDFrontSideRecognizer> {

    @Override
    protected void extractData(CzechiaIDFrontSideRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getIdentityCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDateOfIssue()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDateOfExpiry()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPlaceOfBirth,
                result.getPlaceOfBirth()
        ));
    }

}
