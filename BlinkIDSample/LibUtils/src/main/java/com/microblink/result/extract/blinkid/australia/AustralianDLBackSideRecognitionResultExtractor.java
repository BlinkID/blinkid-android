package com.microblink.result.extract.blinkid.australia;

import com.microblink.entities.recognizers.blinkid.australia.AustraliaDLBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class AustralianDLBackSideRecognitionResultExtractor extends BaseResultExtractor<AustraliaDLBackSideRecognizer.Result, AustraliaDLBackSideRecognizer> {

    @Override
    protected void extractData(AustraliaDLBackSideRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPLicenceNumber,
                result.getLicenceNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDateOfExpiry()
        ));
    }

}
