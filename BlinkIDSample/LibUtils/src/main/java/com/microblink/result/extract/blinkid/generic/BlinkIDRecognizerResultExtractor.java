package com.microblink.result.extract.blinkid.generic;

import com.microblink.entities.recognizers.blinkid.generic.BlinkIdRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.libutils.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BlinkIDRecognizerResultExtractor extends BlinkIdExtractor<BlinkIdRecognizer.Result, BlinkIdRecognizer> {

    @Override
    protected void extractData(BlinkIdRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        add(R.string.PPLocalizedName, result.getLocalizedName());
        add(R.string.PPSex, result.getSex());

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        int age = result.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());

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

        ClassInfo classInfo = result.getClassInfo();
        add(R.string.PPClassInfoCountry, classInfo.getCountry().name());
        add(R.string.PPClassInfoRegion, classInfo.getRegion().name());
        add(R.string.PPClassInfoType, classInfo.getType().name());

        if ( result.getMrzResult().isMrzParsed() ) {
            extractMRZResult(result.getMrzResult());
        }

        add(R.string.MBDocumentImageColorStatus, result.getDocumentImageColorStatus().name());
        add(R.string.MBDocumentImageMoireStatus, result.getDocumentImageMoireStatus().name());

    }

}