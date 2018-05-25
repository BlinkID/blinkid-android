package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.results.date.Date;

public class MyKadFrontRecognitionResultExtractor extends BaseResultExtractor<MyKadFrontRecognizer.Result, MyKadFrontRecognizer> {

    @Override
    protected void extractData(MyKadFrontRecognizer.Result result) {

        mExtractedData.add(mBuilder.build(R.string.PPFullName, result.getOwnerFullName()));
        mExtractedData.add(mBuilder.build(R.string.PPAddress, result.getOwnerAddress()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressStreet, result.getOwnerAddressStreet()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressZipCode, result.getOwnerAddressZipCode()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressCity, result.getOwnerAddressCity()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressState, result.getOwnerAddressState()));

        Date birthDate = result.getOwnerBirthDate();
        if (birthDate != null) {
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, birthDate));
        } else {
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, result.getRawBirthDate()));
        }
        mExtractedData.add(mBuilder.build(R.string.PPSex, result.getOwnerSex()));
        mExtractedData.add(mBuilder.build(R.string.PPReligion, result.getOwnerReligion()));
        String armyNumber = result.getArmyNumber();
        if (armyNumber != null && !armyNumber.isEmpty()) {
            mExtractedData.add(mBuilder.build(R.string.PPArmyNumber, armyNumber));
        }
        mExtractedData.add(mBuilder.build(R.string.PPNRICNumber, result.getNRICNumber()));
    }
}
