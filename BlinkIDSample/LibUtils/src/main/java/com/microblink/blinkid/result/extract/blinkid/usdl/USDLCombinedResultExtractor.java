package com.microblink.blinkid.result.extract.blinkid.usdl;

import com.microblink.blinkid.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class USDLCombinedResultExtractor extends BlinkIdExtractor<UsdlCombinedRecognizer.Result, UsdlCombinedRecognizer> {

    @Override
    protected void extractData(UsdlCombinedRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPMiddleName, result.getMiddleName());
        add(R.string.PPNameSuffix, result.getNameSuffix());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        int age = result.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        add(R.string.PPRestrictions, result.getRestrictions());
        add(R.string.PPEndorsements, result.getEndorsements());
        add(R.string.PPVehicleClass, result.getVehicleClass());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }
}
