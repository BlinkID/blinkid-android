package com.microblink.result.extract.blinkid.idbarcode;

import com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.microblink.libutils.R;
import com.microblink.result.extract.BaseResultExtractor;

import java.util.Arrays;

public class IdBarcodeResultExtractor extends BaseResultExtractor<IdBarcodeRecognizer.Result, IdBarcodeRecognizer> {

    @Override
    protected void extractData(IdBarcodeRecognizer.Result result) {
        add(R.string.PPDocumentType, result.getDocumentType().name());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAddressStreet, result.getStreet());
        add(R.string.PPAddressPostalCode, result.getPostalCode());
        add(R.string.PPAddressCity, result.getCity());
        add(R.string.PPAddressJurisdiction, result.getJurisdiction());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        int age = result.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPExpired, result.isExpired());
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
        add(R.string.PPRestrictions, result.getRestrictions());
        add(R.string.PPEndorsements, result.getEndorsements());
        add(R.string.PPVehicleClass, result.getVehicleClass());
        add(R.string.PPBarcodeType, result.getBarcodeType().name());
        add(R.string.PPUncertain, result.isUncertain());
        add(R.string.PPBarcodeData, result.getStringData());
        byte[] rawDataBytes = result.getRawData();
        add(R.string.PPBarcodeRawData, Arrays.toString(rawDataBytes));
    }

}
