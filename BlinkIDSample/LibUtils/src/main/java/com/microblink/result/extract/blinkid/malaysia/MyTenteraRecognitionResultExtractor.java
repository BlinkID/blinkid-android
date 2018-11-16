package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyTenteraFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.results.date.Date;

public class MyTenteraRecognitionResultExtractor extends BlinkIdExtractor<MalaysiaMyTenteraFrontRecognizer.Result, MalaysiaMyTenteraFrontRecognizer> {

    @Override
    protected void extractData(MalaysiaMyTenteraFrontRecognizer.Result result) {
        add(R.string.PPArmyNumber, result.getArmyNumber());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAddress, result.getFullAddress());
        add(R.string.PPAddressStreet, result.getStreet());
        add(R.string.PPAddressZipCode, result.getZipcode());
        add(R.string.PPAddressCity, result.getCity());
        add(R.string.PPAddressState, result.getOwnerState());

        Date birthDate = result.getBirthDate().getDate();
        if (birthDate != null) {
            add(R.string.PPDateOfBirth, birthDate);
        }

        add(R.string.PPSex, result.getSex());
        add(R.string.PPReligion, result.getReligion());
        add(R.string.PPNRICNumber, result.getNric());
    }

}
