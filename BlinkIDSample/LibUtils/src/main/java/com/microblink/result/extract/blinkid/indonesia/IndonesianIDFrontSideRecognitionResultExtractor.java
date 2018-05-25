package com.microblink.result.extract.blinkid.indonesia;

import com.microblink.entities.recognizers.blinkid.indonesia.IndonesiaIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class IndonesianIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<IndonesiaIDFrontRecognizer.Result, IndonesiaIDFrontRecognizer> {

    @Override
    protected void extractData(IndonesiaIDFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPProvince,
                result.getProvince()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPCity,
                result.getCity()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getDocumentNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPName,
                result.getName()
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
                R.string.PPSex,
                result.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPBloodGroup,
                result.getBloodType()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPRT,
                result.getRT()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPRW,
                result.getRW()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPKelDesa,
                result.getKelDesa()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDistrict,
                result.getDistrict()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPReligion,
                result.getReligion()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPMaritalStatus,
                result.getMaritalStatus()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPOccupation,
                result.getOccupation()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPCitizenship,
                result.getCitizenship()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPValidUntil,
                result.getValidUntil()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiryPermanent,
                result.getValidUntilPermanent()
        ));
    }

}
