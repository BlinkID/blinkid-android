package com.microblink.result.extract.blinkid.malaysia;

import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaIkadFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class MalaysiaIKadFrontRecognitionResultExtractor extends BlinkIdExtractor<MalaysiaIkadFrontRecognizer.Result, MalaysiaIkadFrontRecognizer> {
    @Override
    protected void extractData(MalaysiaIkadFrontRecognizer.Result result) {
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPName, result.getName());
        add(R.string.PPPassportNumber, result.getPassportNumber());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPGender, result.getGender());
        add(R.string.PPSector, result.getSector());
        add(R.string.PPEmployer, result.getEmployer());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPFacultyAddress, result.getFacultyAddress());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }

}
