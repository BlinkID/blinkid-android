package com.microblink.result.extract.blinkid.generic;

import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.entities.recognizers.blinkid.generic.barcode.BarcodeResult;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.entities.recognizers.blinkid.generic.viz.VizResult;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.libutils.R;
import com.microblink.result.ResultSource;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BlinkIDCombinedRecognizerResultExtractor extends BlinkIdExtractor<BlinkIdCombinedRecognizer.Result, BlinkIdCombinedRecognizer> {

    @Override
    public boolean doesSupportResultSourceExtraction() {
        return true;
    }

    @Override
    protected void extractData(BlinkIdCombinedRecognizer.Result result) {
        extractMixedResults(result);
    }

    @Override
    protected void extractData(BlinkIdCombinedRecognizer.Result result, ResultSource resultSource) {
        switch (resultSource) {
            case FRONT:
                extractVisualResults(result.getFrontVizResult());
                break;
            case BACK:
                extractVisualResults(result.getBackVizResult());
                break;
            case MRZ:
                extractMrzResults(result.getMrzResult());
                break;
            case BARCODE:
                extractBarcodeResults(result.getBarcodeResult());
                break;
            case MIXED:
            default:
                extractMixedResults(result);
                break;
        }
    }

    private void extractMixedResults(BlinkIdCombinedRecognizer.Result result) {
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

        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            add(R.string.PPRestrictions, driverLicenseInfo.getRestrictions());
            add(R.string.PPEndorsements, driverLicenseInfo.getEndorsements());
            add(R.string.PPVehicleClass, driverLicenseInfo.getVehicleClass());
            add(R.string.PPConditions, driverLicenseInfo.getConditions());
        }

        ClassInfo classInfo = result.getClassInfo();
        add(R.string.PPClassInfoCountry, classInfo.getCountry().name());
        add(R.string.PPClassInfoRegion, classInfo.getRegion().name());
        add(R.string.PPClassInfoType, classInfo.getType().name());

        add(R.string.MBDocumentFrontImageBlurred, result.getFrontImageAnalysisResult().isBlurred());
        add(R.string.MBDocumentFrontImageColorStatus, result.getFrontImageAnalysisResult().getDocumentImageColorStatus().name());
        add(R.string.MBDocumentFrontImageMoireStatus, result.getFrontImageAnalysisResult().getDocumentImageMoireStatus().name());
        add(R.string.MBDocumentFrontImageFaceStatus, result.getFrontImageAnalysisResult().getFaceDetectionStatus().name());
        add(R.string.MBDocumentFrontImageMrzStatus, result.getFrontImageAnalysisResult().getMrzDetectionStatus().name());
        add(R.string.MBDocumentFrontImageBarcodeStatus, result.getFrontImageAnalysisResult().getBarcodeDetectionStatus().name());

        add(R.string.MBDocumentBackImageBlurred, result.getBackImageAnalysisResult().isBlurred());
        add(R.string.MBDocumentBackImageColorStatus, result.getBackImageAnalysisResult().getDocumentImageColorStatus().name());
        add(R.string.MBDocumentBackImageMoireStatus, result.getBackImageAnalysisResult().getDocumentImageMoireStatus().name());
        add(R.string.MBDocumentBackImageFaceStatus, result.getBackImageAnalysisResult().getFaceDetectionStatus().name());
        add(R.string.MBDocumentBackImageMrzStatus, result.getBackImageAnalysisResult().getMrzDetectionStatus().name());
        add(R.string.MBDocumentBackImageBarcodeStatus, result.getBackImageAnalysisResult().getBarcodeDetectionStatus().name());

        add(R.string.MBProcessingStatus, result.getProcessingStatus().name());
        add(R.string.MBRecognitionMode, result.getRecognitionMode().name());
    }

    private void extractVisualResults(VizResult result) {
        addIfNotEmpty(R.string.PPFirstName, result.getFirstName());
        addIfNotEmpty(R.string.PPLastName, result.getLastName());
        addIfNotEmpty(R.string.PPFullName, result.getFullName());
        addIfNotEmpty(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        addIfNotEmpty(R.string.PPLocalizedName, result.getLocalizedName());
        addIfNotEmpty(R.string.PPSex, result.getSex());

        addIfNotEmpty(R.string.PPAddress, result.getAddress());
        addIfNotEmpty(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        addIfNotEmpty(R.string.PPDateOfBirth, result.getDateOfBirth());

        addIfNotEmpty(R.string.PPIssueDate, result.getDateOfIssue());
        addIfNotEmpty(R.string.PPDateOfExpiry, result.getDateOfExpiry());

        addIfNotEmpty(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        addIfNotEmpty(R.string.PPNationality, result.getNationality());

        addIfNotEmpty(R.string.PPRace, result.getRace());
        addIfNotEmpty(R.string.PPReligion, result.getReligion());
        addIfNotEmpty(R.string.PPProfession, result.getProfession());
        addIfNotEmpty(R.string.PPMaritalStatus, result.getMaritalStatus());
        addIfNotEmpty(R.string.PPResidentialStatus, result.getResidentialStatus());
        addIfNotEmpty(R.string.PPEmployer, result.getEmployer());

        addIfNotEmpty(R.string.PPDocumentNumber, result.getDocumentNumber());
        addIfNotEmpty(R.string.PPPersonalNumber, result.getPersonalIdNumber());
        addIfNotEmpty(R.string.PPDocumentAdditionalNumber, result.getDocumentAdditionalNumber());
        addIfNotEmpty(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();

        if (!driverLicenseInfo.isEmpty()) {
            addIfNotEmpty(R.string.PPRestrictions, driverLicenseInfo.getRestrictions());
            addIfNotEmpty(R.string.PPEndorsements, driverLicenseInfo.getEndorsements());
            addIfNotEmpty(R.string.PPVehicleClass, driverLicenseInfo.getVehicleClass());
            addIfNotEmpty(R.string.PPConditions, driverLicenseInfo.getConditions());
        }
    }

    private void extractMrzResults(MrzResult result) {
        if (result.isMrzParsed()) {
            extractMRZResult(result);
        }
    }

    private void extractBarcodeResults(BarcodeResult result) {
        addIfNotEmpty(R.string.PPFirstName, result.getFirstName());
        addIfNotEmpty(R.string.PPLastName, result.getLastName());
        addIfNotEmpty(R.string.PPFullName, result.getFullName());
        addIfNotEmpty(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        addIfNotEmpty(R.string.PPSex, result.getSex());

        addIfNotEmpty(R.string.PPAddress, result.getAddress());
        addIfNotEmpty(R.string.PPDateOfBirth, result.getDateOfBirth());

        addIfNotEmpty(R.string.PPIssueDate, result.getDateOfIssue());
        addIfNotEmpty(R.string.PPDateOfExpiry, result.getDateOfExpiry());

        addIfNotEmpty(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        addIfNotEmpty(R.string.PPNationality, result.getNationality());

        addIfNotEmpty(R.string.PPRace, result.getRace());
        addIfNotEmpty(R.string.PPReligion, result.getReligion());
        addIfNotEmpty(R.string.PPProfession, result.getProfession());
        addIfNotEmpty(R.string.PPMaritalStatus, result.getMaritalStatus());
        addIfNotEmpty(R.string.PPResidentialStatus, result.getResidentialStatus());
        addIfNotEmpty(R.string.PPEmployer, result.getEmployer());

        addIfNotEmpty(R.string.PPDocumentNumber, result.getDocumentNumber());
        addIfNotEmpty(R.string.PPPersonalNumber, result.getPersonalIdNumber());
        addIfNotEmpty(R.string.PPDocumentAdditionalNumber, result.getDocumentAdditionalNumber());
        addIfNotEmpty(R.string.PPIssuingAuthority, result.getIssuingAuthority());

        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            addIfNotEmpty(R.string.PPRestrictions, driverLicenseInfo.getRestrictions());
            addIfNotEmpty(R.string.PPEndorsements, driverLicenseInfo.getEndorsements());
            addIfNotEmpty(R.string.PPVehicleClass, driverLicenseInfo.getVehicleClass());
        }
    }

    @Override
    protected void onDataExtractionDone(BlinkIdCombinedRecognizer.Result result, ResultSource resultSource) {
        if (resultSource == ResultSource.MIXED) {
            extractCommonData(result, mExtractedData, mBuilder);
        }
    }

}