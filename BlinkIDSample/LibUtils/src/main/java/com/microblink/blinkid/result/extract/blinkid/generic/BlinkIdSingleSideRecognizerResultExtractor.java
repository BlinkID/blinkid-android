package com.microblink.blinkid.result.extract.blinkid.generic;

import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.barcode.BarcodeDriverLicenseDetailedInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.barcode.BarcodeResult;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.viz.VizResult;
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.BarcodeElementKey;
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.BarcodeElements;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.ResultSource;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class BlinkIdSingleSideRecognizerResultExtractor extends BlinkIdExtractor<BlinkIdSingleSideRecognizer.Result, BlinkIdSingleSideRecognizer> {

    @Override
    public boolean doesSupportResultSourceExtraction() {
        return true;
    }

    @Override
    protected void extractData(BlinkIdSingleSideRecognizer.Result result) {
        extractMixedResults(result);
    }

    @Override
    protected void extractData(BlinkIdSingleSideRecognizer.Result result, ResultSource resultSource) {
        switch (resultSource) {
            case NONEMPTY:
                extractMixedNonEmptyResults(result);
                break;
            case FRONT:
                extractVisualResults(result.getVizResult());
                break;
            case BACK:
                // leave it empty
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

    private void extractMixedResults(BlinkIdSingleSideRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        add(R.string.PPLocalizedName, result.getLocalizedName());
        add(R.string.PPFatherName, result.getFathersName());
        add(R.string.PPMotherName, result.getMothersName());
        add(R.string.PPSex, result.getSex());

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        add(R.string.PPAdditionalOptionalAddressInformation, result.getAdditionalOptionalAddressInformation());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        if (result.getDateOfBirth() != null) {
            add(R.string.PPDateOfBirthOriginal, result.getDateOfBirth().getStringResult());
        }
        int age = result.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        add(R.string.PPIssueDate, result.getDateOfIssue());
        if (result.getDateOfIssue() != null) {
            add(R.string.PPIssueDateOriginal, result.getDateOfIssue().getStringResult());
        }
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        if (result.getDateOfExpiry() != null) {
            add(R.string.PPDateOfExpiryOriginal, result.getDateOfExpiry().getStringResult());
        }
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
        add(R.string.PPDocumentOptionalAdditionalNumber, result.getDocumentOptionalAdditionalNumber());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());

        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            addIfNotEmpty(R.string.PPDriverLicenseDetailedInfo, driverLicenseInfo.toString());
        }

        ClassInfo classInfo = result.getClassInfo();
        add(R.string.PPClassInfoCountry, classInfo.getCountry().name());
        add(R.string.PPClassInfoRegion, classInfo.getRegion().name());
        add(R.string.PPClassInfoType, classInfo.getType().name());
        add(R.string.PPClassInfoCountryName, classInfo.getCountryName());
        add(R.string.PPClassInfoIsoNumericCountryCode, classInfo.getIsoNumericCountryCode());
        add(R.string.PPClassInfoIsoAlpha2CountryCode, classInfo.getIsoAlpha2CountryCode());
        add(R.string.PPClassInfoIsoAlpha3CountryCode, classInfo.getIsoAlpha3CountryCode());

        add(R.string.MBDocumentImageBlurred, result.getImageAnalysisResult().isBlurred());
        add(R.string.MBDocumentImageColorStatus, result.getImageAnalysisResult().getDocumentImageColorStatus().name());
        add(R.string.MBDocumentImageMoireStatus, result.getImageAnalysisResult().getDocumentImageMoireStatus().name());
        add(R.string.MBDocumentImageFaceStatus, result.getImageAnalysisResult().getFaceDetectionStatus().name());
        add(R.string.MBDocumentImageMrzStatus, result.getImageAnalysisResult().getMrzDetectionStatus().name());
        add(R.string.MBDocumentImageBarcodeStatus, result.getImageAnalysisResult().getBarcodeDetectionStatus().name());
        add(R.string.MBDocumentImageCardOrientation, result.getImageAnalysisResult().getCardOrientation().name());

        add(R.string.MBProcessingStatus, result.getProcessingStatus().name());
        add(R.string.MBRecognitionMode, result.getRecognitionMode().name());

        add(R.string.MBAdditionalProcessingInfo, result.getAdditionalProcessingInfo().toString());

        add(R.string.MBCameraFrame, result.getCameraFrame());
        add(R.string.MBBarcodeCameraFrame, result.getBarcodeCameraFrame());
    }

    private void extractMixedNonEmptyResults(BlinkIdSingleSideRecognizer.Result result) {
        addIfNotEmpty(R.string.PPFirstName, result.getFirstName());
        addIfNotEmpty(R.string.PPLastName, result.getLastName());
        addIfNotEmpty(R.string.PPFullName, result.getFullName());
        addIfNotEmpty(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        addIfNotEmpty(R.string.PPLocalizedName, result.getLocalizedName());
        addIfNotEmpty(R.string.PPFatherName, result.getFathersName());
        addIfNotEmpty(R.string.PPMotherName, result.getMothersName());
        addIfNotEmpty(R.string.PPSex, result.getSex());

        addIfNotEmpty(R.string.PPAddress, result.getAddress());
        addIfNotEmpty(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        addIfNotEmpty(R.string.PPAdditionalOptionalAddressInformation, result.getAdditionalOptionalAddressInformation());
        addIfNotEmpty(R.string.PPDateOfBirth, result.getDateOfBirth());
        if (result.getDateOfBirth() != null) {
            addIfNotEmpty(R.string.PPDateOfBirthOriginal, result.getDateOfBirth().getStringResult());
        }
        int age = result.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        addIfNotEmpty(R.string.PPIssueDate, result.getDateOfIssue());
        if (result.getDateOfIssue() != null) {
            addIfNotEmpty(R.string.PPIssueDateOriginal, result.getDateOfIssue().getStringResult());
        }
        addIfNotEmpty(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        if (result.getDateOfExpiry() != null) {
            addIfNotEmpty(R.string.PPDateOfExpiryOriginal, result.getDateOfExpiry().getStringResult());
        }
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());
        add(R.string.PPExpired, result.isExpired());

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
        addIfNotEmpty(R.string.PPDocumentOptionalAdditionalNumber, result.getDocumentOptionalAdditionalNumber());
        addIfNotEmpty(R.string.PPIssuingAuthority, result.getIssuingAuthority());

        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            addIfNotEmpty(R.string.PPDriverLicenseDetailedInfo, driverLicenseInfo.toString());
        }

        ClassInfo classInfo = result.getClassInfo();
        addIfNotEmpty(R.string.PPClassInfoCountry, classInfo.getCountry().name());
        addIfNotEmpty(R.string.PPClassInfoRegion, classInfo.getRegion().name());
        addIfNotEmpty(R.string.PPClassInfoType, classInfo.getType().name());
        addIfNotEmpty(R.string.PPClassInfoCountryName, classInfo.getCountryName());
        addIfNotEmpty(R.string.PPClassInfoIsoNumericCountryCode, classInfo.getIsoNumericCountryCode());
        addIfNotEmpty(R.string.PPClassInfoIsoAlpha2CountryCode, classInfo.getIsoAlpha2CountryCode());
        addIfNotEmpty(R.string.PPClassInfoIsoAlpha3CountryCode, classInfo.getIsoAlpha3CountryCode());

        add(R.string.MBDocumentImageBlurred, result.getImageAnalysisResult().isBlurred());
        addIfNotEmpty(R.string.MBDocumentImageColorStatus, result.getImageAnalysisResult().getDocumentImageColorStatus().name());
        addIfNotEmpty(R.string.MBDocumentImageMoireStatus, result.getImageAnalysisResult().getDocumentImageMoireStatus().name());
        addIfNotEmpty(R.string.MBDocumentImageFaceStatus, result.getImageAnalysisResult().getFaceDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentImageMrzStatus, result.getImageAnalysisResult().getMrzDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentImageBarcodeStatus, result.getImageAnalysisResult().getBarcodeDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentImageCardOrientation, result.getImageAnalysisResult().getCardOrientation().name());

        addIfNotEmpty(R.string.MBProcessingStatus, result.getProcessingStatus().name());
        addIfNotEmpty(R.string.MBRecognitionMode, result.getRecognitionMode().name());

        addIfNotEmpty(R.string.MBAdditionalProcessingInfo, result.getAdditionalProcessingInfo().toString());

        add(R.string.MBCameraFrame, result.getCameraFrame());
        add(R.string.MBBarcodeCameraFrame, result.getBarcodeCameraFrame());
    }

    private void extractVisualResults(VizResult result) {
        addIfNotEmpty(R.string.PPFirstName, result.getFirstName());
        addIfNotEmpty(R.string.PPLastName, result.getLastName());
        addIfNotEmpty(R.string.PPFullName, result.getFullName());
        addIfNotEmpty(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        addIfNotEmpty(R.string.PPLocalizedName, result.getLocalizedName());
        addIfNotEmpty(R.string.PPFatherName, result.getFathersName());
        addIfNotEmpty(R.string.PPMotherName, result.getMothersName());
        addIfNotEmpty(R.string.PPSex, result.getSex());

        addIfNotEmpty(R.string.PPAddress, result.getAddress());
        addIfNotEmpty(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        addIfNotEmpty(R.string.PPAdditionalOptionalAddressInformation, result.getAdditionalOptionalAddressInformation());
        addIfNotEmpty(R.string.PPDateOfBirth, result.getDateOfBirth());

        addIfNotEmpty(R.string.PPIssueDate, result.getDateOfIssue());
        addIfNotEmpty(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDateOfExpiryPermanent, result.isDateOfExpiryPermanent());

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
        addIfNotEmpty(R.string.PPDocumentOptionalAdditionalNumber, result.getDocumentOptionalAdditionalNumber());
        addIfNotEmpty(R.string.PPPersonalAdditionalNumber, result.getAdditionalPersonalIdNumber());
        addIfNotEmpty(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            addIfNotEmpty(R.string.PPDriverLicenseDetailedInfo, driverLicenseInfo.toString());
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
        addIfNotEmpty(R.string.PPMiddleName, result.getMiddleName());
        addIfNotEmpty(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        addIfNotEmpty(R.string.PPSex, result.getSex());

        addIfNotEmpty(R.string.PPAddress, result.getAddress());
        addIfNotEmpty(R.string.PPCity, result.getCity());
        addIfNotEmpty(R.string.PPStreet, result.getStreet());
        addIfNotEmpty(R.string.PPPostalCode, result.getPostalCode());
        addIfNotEmpty(R.string.PPJurisdiction, result.getJurisdiction());
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

        BarcodeDriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            addIfNotEmpty(R.string.PPDriverLicenseDetailedInfo, driverLicenseInfo.toString());
        }

        BarcodeElements extendedElements = result.getExtendedElements();
        if (!extendedElements.isEmpty()) {
            for (BarcodeElementKey key: BarcodeElementKey.values()) {
                String barcodeElement = extendedElements.getValue(key);
                if (!barcodeElement.isEmpty()) {
                    add(R.string.PPExtendedBarcodeData, key.name() + ": " + barcodeElement);
                }
            }
        }

        addIfNotEmpty(R.string.PPBarcodeType, result.getBarcodeType().name());
    }

    @Override
    protected void onDataExtractionDone(BlinkIdSingleSideRecognizer.Result result, ResultSource resultSource) {
        if (resultSource == ResultSource.MIXED) {
            extractCommonData(result, mExtractedData, mBuilder);
        }
    }
}