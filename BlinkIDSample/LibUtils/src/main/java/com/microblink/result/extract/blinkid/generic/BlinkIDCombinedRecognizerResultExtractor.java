package com.microblink.result.extract.blinkid.generic;

import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.libutils.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BlinkIDCombinedRecognizerResultExtractor extends BlinkIdExtractor<BlinkIdCombinedRecognizer.Result, BlinkIdCombinedRecognizer> {

    @Override
    protected void extractData(BlinkIdCombinedRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        add(R.string.PPSex, result.getSex());

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());

        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPNationality, result.getNationality());

        add(R.string.PPRace, result.getRace());
        add(R.string.PPReligion, result.getReligion());
        add(R.string.PPProfession, result.getProfession());
        add(R.string.PPMaritalStatus, result.getMaritalStatus());
        add(R.string.PPResidentialStatus, result.getResidentialStatus());
        add(R.string.PPEmployer, result.getEmployer());

        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPPersonalNumber, result.getPersonalIdNumber());
        add(R.string.PPDocumentAdditionalNumber, result.getDocumentAdditionalNumber());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPConditions, result.getConditions());


        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            add(R.string.PPRestrictions, driverLicenseInfo.getRestrictions());
            add(R.string.PPEndorsements, driverLicenseInfo.getEndorsements());
            add(R.string.PPVehicleClass, driverLicenseInfo.getVehicleClass());
        }

        if ( result.getMrzResult().isMrzParsed() ) {
            extractMRZResult(result.getMrzResult());
        }

    }

}