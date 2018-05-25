package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.IKadRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class IKadRecognitionResultExtractor extends BaseResultExtractor<IKadRecognizer.Result, IKadRecognizer> {

    @Override
    protected void extractData(IKadRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.PPFullName, result.getFullName()));
        mExtractedData.add(mBuilder.build(R.string.PPAddress, result.getAddress()));
        mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, result.getDateOfBirth()));
        mExtractedData.add(mBuilder.build(R.string.PPEmployer, result.getEmployer()));
        mExtractedData.add(mBuilder.build(R.string.PPDateOfExpiry, result.getExpiryDate()));
        mExtractedData.add(mBuilder.build(R.string.PPNationality, result.getNationality()));
        mExtractedData.add(mBuilder.build(R.string.PPPassportNumber, result.getPassportNumber()));
        mExtractedData.add(mBuilder.build(R.string.PPSector, result.getSector()));
        mExtractedData.add(mBuilder.build(R.string.PPSex, result.getSex()));
    }

}
