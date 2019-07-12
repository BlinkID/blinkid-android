package com.microblink.result.extract.blinkid.generic;

import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BlinkIDCombinedRecognizerResultExtractor extends BlinkIdExtractor<BlinkIdCombinedRecognizer.Result, BlinkIdCombinedRecognizer> {

    @Override
    protected void extractData(BlinkIdCombinedRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());

        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());

        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            add(R.string.PPRestrictions, driverLicenseInfo.getRestrictions());
            add(R.string.PPEndorsements, driverLicenseInfo.getEndorsements());
            add(R.string.PPVehicleClass, driverLicenseInfo.getVehicleClass());
        }

    }

}