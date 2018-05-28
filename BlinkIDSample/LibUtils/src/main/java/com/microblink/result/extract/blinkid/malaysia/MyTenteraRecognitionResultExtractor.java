package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MyTenteraRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.results.date.Date;

public class MyTenteraRecognitionResultExtractor extends BaseResultExtractor<MyTenteraRecognizer.Result, MyTenteraRecognizer> {

    @Override
    protected void extractData(MyTenteraRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.PPArmyNumber, result.getArmyNumber()));
        mExtractedData.add(mBuilder.build(R.string.PPFullName, result.getOwnerFullName()));
        mExtractedData.add(mBuilder.build(R.string.PPAddress, result.getOwnerAddress()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressStreet, result.getOwnerAddressStreet()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressZipCode, result.getOwnerAddressZipCode()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressCity, result.getOwnerAddressCity()));
        mExtractedData.add(mBuilder.build(R.string.PPAddressState, result.getOwnerAddressState()));

        Date birthDate = result.getOwnerBirthDate();
        if (birthDate != null) {
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, birthDate));
        }

        mExtractedData.add(mBuilder.build(R.string.PPSex, result.getOwnerSex()));
        mExtractedData.add(mBuilder.build(R.string.PPReligion, result.getOwnerReligion()));
        mExtractedData.add(mBuilder.build(R.string.PPNRICNumber, result.getNRICNumber()));
    }

}
