package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaDLFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class MalaysianDLFrontRecognitionResultExtractor extends BaseResultExtractor<MalaysiaDLFrontRecognizer.Result, MalaysiaDLFrontRecognizer> {

    @Override
    protected void extractData(MalaysiaDLFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.PPIdentityNumber, result.getIdentityNumber()));
        mExtractedData.add(mBuilder.build(R.string.PPFullName, result.getName()));
        mExtractedData.add(mBuilder.build(R.string.PPNationality, result.getNationality()));
        mExtractedData.add(mBuilder.build(R.string.PPClass, result.getDLClass()));
        mExtractedData.add(mBuilder.build(R.string.PPValidFrom, result.getValidFrom()));
        mExtractedData.add(mBuilder.build(R.string.PPValidUntil, result.getValidUntil()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressStreet, result.getStreet()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressZipCode, result.getZipCode()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressCity, result.getCity()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressState, result.getState()));
        mExtractedData.add(mBuilder.build(R.string.PPAddress, result.getFullAddress()));
    }

}
