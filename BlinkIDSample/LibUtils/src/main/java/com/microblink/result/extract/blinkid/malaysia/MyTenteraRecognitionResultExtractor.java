package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MyTenteraRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.results.date.Date;

public class MyTenteraRecognitionResultExtractor extends BaseResultExtractor<MyTenteraRecognizer.Result, MyTenteraRecognizer> {

    @Override
    protected void extractData(MyTenteraRecognizer.Result result) {
        add(R.string.PPArmyNumber, result.getArmyNumber());
        add(R.string.PPFullName, result.getOwnerFullName());
        add(R.string.PPAddress, result.getOwnerAddress());
        add(R.string.PPAddressStreet, result.getOwnerAddressStreet());
        add(R.string.PPAddressZipCode, result.getOwnerAddressZipCode());
        add(R.string.PPAddressCity, result.getOwnerAddressCity());
        add(R.string.PPAddressState, result.getOwnerAddressState());

        Date birthDate = result.getOwnerBirthDate();
        if (birthDate != null) {
            add(R.string.PPDateOfBirth, birthDate);
        }

        add(R.string.PPSex, result.getOwnerSex());
        add(R.string.PPReligion, result.getOwnerReligion());
        add(R.string.PPNRICNumber, result.getNricNumber());
    }

}
