package com.microblink.result.extract.blinkid.australia;

import com.microblink.entities.recognizers.blinkid.australia.AustraliaDLFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class AustralianDLFrontSideRecognitionResultExtractor extends BaseResultExtractor<AustraliaDLFrontSideRecognizer.Result, AustraliaDLFrontSideRecognizer> {

    @Override
    protected void extractData(AustraliaDLFrontSideRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPFullName,
                result.getName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPLicenceNumber,
                result.getLicenceNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPLicenceType,
                result.getLicenceType()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDateOfExpiry()
        ));
    }

}
