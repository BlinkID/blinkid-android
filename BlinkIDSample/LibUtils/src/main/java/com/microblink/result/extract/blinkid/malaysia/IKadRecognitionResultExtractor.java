package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.IkadRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class IKadRecognitionResultExtractor extends BlinkIdExtractor<IkadRecognizer.Result, IkadRecognizer> {

    @Override
    protected void extractData(IkadRecognizer.Result result) {
        add(R.string.PPFullName, result.getName());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPFacultyAddress, result.getFacultyAddress());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPEmployer, result.getEmployer());
        add(R.string.PPDateOfExpiry, result.getExpiryDate());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPPassportNumber, result.getPassportNumber());
        add(R.string.PPSector, result.getSector());
        add(R.string.PPSex, result.getSex());
    }

}
