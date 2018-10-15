package com.microblink.result.extract.blinkid.indonesia;

import com.microblink.entities.recognizers.blinkid.indonesia.IndonesiaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class IndonesianIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<IndonesiaIdFrontRecognizer.Result, IndonesiaIdFrontRecognizer> {

    @Override
    protected void extractData(IndonesiaIdFrontRecognizer.Result result) {
        add(R.string.PPProvince, result.getProvince());
        add(R.string.PPCity, result.getCity());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPBloodType, result.getBloodType());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPRT, result.getRt());
        add(R.string.PPRW, result.getRw());
        add(R.string.PPKelDesa, result.getKelDesa());
        add(R.string.PPDistrict, result.getDistrict());
        add(R.string.PPReligion, result.getReligion());
        add(R.string.PPMaritalStatus, result.getMaritalStatus());
        add(R.string.PPOccupation, result.getOccupation());
        add(R.string.PPCitizenship, result.getCitizenship());
        add(R.string.PPValidUntil, result.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());
    }

}
