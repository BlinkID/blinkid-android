package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.results.date.Date;

public class MyKadFrontRecognitionResultExtractor extends BlinkIdExtractor<MyKadFrontRecognizer.Result, MyKadFrontRecognizer> {

    @Override
    protected void extractData(MyKadFrontRecognizer.Result result) {
        add(R.string.PPFullName, result.getOwnerFullName());
        add(R.string.PPAddress, result.getOwnerAddress());
        add(R.string.PPAddressStreet, result.getOwnerAddressStreet());
        add(R.string.PPAddressZipCode, result.getOwnerAddressZipCode());
        add(R.string.PPAddressCity, result.getOwnerAddressCity());
        add(R.string.PPAddressState, result.getOwnerAddressState());

        Date birthDate = result.getOwnerBirthDate();
        if (birthDate != null) {
            add(R.string.PPDateOfBirth, birthDate);
        } else {
            add(R.string.PPDateOfBirth, result.getRawBirthDate());
        }
        add(R.string.PPSex, result.getOwnerSex());
        add(R.string.PPReligion, result.getOwnerReligion());
        String armyNumber = result.getArmyNumber();
        if (armyNumber != null && !armyNumber.isEmpty()) {
            add(R.string.PPArmyNumber, armyNumber);
        }
        add(R.string.PPNRICNumber, result.getNricNumber());
    }
}
