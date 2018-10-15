package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaDlFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class AustriaDlFrontRecognitionResultExtractor extends BlinkIdExtractor<AustriaDlFrontRecognizer.Result, AustriaDlFrontRecognizer> {

    @Override
    protected void extractData(AustriaDlFrontRecognizer.Result result){
        add(R.string.PPName, result.getName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPVehicleCategories, result.getVehicleCategories());
    }
}
