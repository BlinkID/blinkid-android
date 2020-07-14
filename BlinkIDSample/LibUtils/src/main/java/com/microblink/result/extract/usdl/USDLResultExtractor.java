package com.microblink.result.extract.usdl;

import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.libutils.R;
import com.microblink.result.extract.BaseResultExtractor;

public class USDLResultExtractor extends BaseResultExtractor<UsdlRecognizer.Result, UsdlRecognizer> {

    @Override
    protected void extractData(UsdlRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAddressStreet, result.getStreet());
        add(R.string.PPAddressPostalCode, result.getPostalCode());
        add(R.string.PPAddressCity, result.getCity());
        add(R.string.PPAddressJurisdiction, result.getJurisdiction());
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
