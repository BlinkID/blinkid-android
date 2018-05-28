package com.microblink.result.extract.blinkid.romania;

import com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class RomanianIDFrontSideRecognitionResultExtractor extends MrtdResultExtractor<RomaniaIDFrontRecognizer.Result, RomaniaIDFrontRecognizer> {

    @Override
    protected void extractData(RomaniaIDFrontRecognizer.Result result) {
        super.extractData(result);

        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIdentityCardNumber,
                result.getIdentityCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSeries,
                result.getIdentityCardSeries()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPCNP,
                result.getCNP()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPParentNames,
                result.getParentNames()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                result.getNonMRZNationality()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPlaceOfBirth,
                result.getPlaceOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuingAuthority,
                result.getIssuedBy()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getNonMRZSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPValidFrom,
                result.getValidFrom()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPValidUntil,
                result.getValidUntil()
        ));
    }

}
