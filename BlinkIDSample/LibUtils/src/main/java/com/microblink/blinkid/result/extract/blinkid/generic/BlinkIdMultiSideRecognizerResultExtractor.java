package com.microblink.blinkid.result.extract.blinkid.generic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.Side;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.StringResult;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.barcode.BarcodeDriverLicenseDetailedInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.barcode.BarcodeResult;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.viz.VizResult;
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.BarcodeElementKey;
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.BarcodeElements;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.ResultSource;
import com.microblink.blinkid.result.extract.RecognitionResultEntry;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.blinkid.util.ImageUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BlinkIdMultiSideRecognizerResultExtractor extends BlinkIdExtractor<BlinkIdMultiSideRecognizer.Result, BlinkIdMultiSideRecognizer> {

    @Override
    public boolean doesSupportResultSourceExtraction() {
        return true;
    }

    @Override
    protected void extractData(BlinkIdMultiSideRecognizer.Result result) {
        extractMixedResults(result);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Context context, BlinkIdMultiSideRecognizer recognizer, ResultSource resultSource) {
        mContext = context;
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
        mRecognizer = recognizer;

        BlinkIdMultiSideRecognizer.Result result = recognizer.getResult();
        String jsonResult = recognizer.toSignedJson().getPayload();
        try {
            JSONObject json = new JSONObject(jsonResult);
            jsonResult = json.toString(4);
        } catch(JSONException e) {
            // can be ignored
        }
        extractData(result, resultSource, jsonResult);
        onDataExtractionDone(result, resultSource);

        return mExtractedData;
    }

    @Override
    protected void extractData(BlinkIdMultiSideRecognizer.Result result, ResultSource resultSource, String jsonResult) {
        switch (resultSource) {
            case NONEMPTY:
                extractMixedNonEmptyResults(result, jsonResult);
                break;
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
            case LOCATIONS:
                addAllLocationResults(result);
                break;
            case MIXED:
            default:
                extractMixedResults(result);
                break;
        }
    }

    private void addAllLocationResults(BlinkIdMultiSideRecognizer.Result result) {
        extractLocationsResultsFromVizResult(result.getFrontVizResult());
        extractLocationsResultsFromVizResult(result.getBackVizResult());
        add(R.string.PPFaceImageSide, result.getFaceImageSide() != null ? result.getFaceImageSide().toString() : "null");
        add(R.string.PPFaceImageLocation, result.getFaceImageLocation() != null ? result.getFaceImageLocation().toString() : "null");

        List<StringResult> frontStringResults = getAllStringResultsFromVizResult(result.getFrontVizResult());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2f);

        if(result.getFullDocumentFrontImage() != null){
            Bitmap image = ImageUtils.transformImage(result.getFullDocumentFrontImage());
            Bitmap bmOverlay = Bitmap.createBitmap(image.getWidth(), image.getHeight(), image.getConfig()); ;
            Canvas canvas = new Canvas(bmOverlay);
            canvas.drawBitmap(image, new Matrix(), null);
            drawLocationsOnBitmap(canvas, paint, frontStringResults, Side.Front);
            if (result.getFaceImageSide() == Side.Front && result.getFaceImageLocation() != null) {
                paint.setColor(Color.BLACK);
                canvas.drawRect(result.getFaceImageLocation().toRectF(), paint);
            }
            add(R.string.MBFullDocumentImageFront, bmOverlay);
        }

        List<StringResult> backStringResults = getAllStringResultsFromVizResult(result.getBackVizResult());

        if(result.getFullDocumentBackImage() != null){
            Bitmap image = ImageUtils.transformImage(result.getFullDocumentBackImage());
            Bitmap bmOverlay = Bitmap.createBitmap(image.getWidth(), image.getHeight(), image.getConfig()); ;
            Canvas canvas = new Canvas(bmOverlay);
            canvas.drawBitmap(image, new Matrix(), null);
            drawLocationsOnBitmap(canvas, paint, backStringResults, Side.Back);
            if (result.getFaceImageSide() == Side.Back && result.getFaceImageLocation() != null) {
                paint.setColor(Color.BLACK);
                canvas.drawRect(result.getFaceImageLocation().toRectF(), paint);
            }
            add(R.string.MBFullDocumentImageBack, bmOverlay);
        }
    }

    private void extractMixedResults(BlinkIdMultiSideRecognizer.Result result) {
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        add(R.string.PPLocalizedName, result.getLocalizedName());
        add(R.string.PPFatherName, result.getFathersName());
        add(R.string.PPMotherName, result.getMothersName());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPSponsor, result.getSponsor());
        add(R.string.PPBloodType, result.getBloodType());

        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        add(R.string.PPAdditionalOptionalAddressInformation, result.getAdditionalOptionalAddressInformation());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        if (result.getDateOfBirth() != null) {
            add(R.string.PPDateOfBirthOriginal, result.getDateOfBirth().getOriginalDateString());
        }
        int age = result.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        add(R.string.PPIssueDate, result.getDateOfIssue());
        if (result.getDateOfIssue() != null) {
            add(R.string.PPIssueDateOriginal, result.getDateOfIssue().getOriginalDateString());
        }
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        if (result.getDateOfExpiry() != null) {
            add(R.string.PPDateOfExpiryOriginal, result.getDateOfExpiry().getOriginalDateString());
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

        add(R.string.MBDocumentFrontImageBlurred, result.getFrontImageAnalysisResult().isBlurred());
        add(R.string.MBDocumentFrontImageColorStatus, result.getFrontImageAnalysisResult().getDocumentImageColorStatus().name());
        add(R.string.MBDocumentFrontImageMoireStatus, result.getFrontImageAnalysisResult().getDocumentImageMoireStatus().name());
        add(R.string.MBDocumentFrontImageFaceStatus, result.getFrontImageAnalysisResult().getFaceDetectionStatus().name());
        add(R.string.MBDocumentFrontImageMrzStatus, result.getFrontImageAnalysisResult().getMrzDetectionStatus().name());
        add(R.string.MBDocumentFrontImageBarcodeStatus, result.getFrontImageAnalysisResult().getBarcodeDetectionStatus().name());
        add(R.string.MBDocumentFrontImageCardOrientation, result.getFrontImageAnalysisResult().getCardOrientation().name());
        add(R.string.MBDocumentFrontImageCardRotation, result.getFrontImageAnalysisResult().getCardRotation() != null ? result.getFrontImageAnalysisResult().getCardRotation().name() : "null");

        add(R.string.MBDocumentBackImageBlurred, result.getBackImageAnalysisResult().isBlurred());
        add(R.string.MBDocumentBackImageColorStatus, result.getBackImageAnalysisResult().getDocumentImageColorStatus().name());
        add(R.string.MBDocumentBackImageMoireStatus, result.getBackImageAnalysisResult().getDocumentImageMoireStatus().name());
        add(R.string.MBDocumentBackImageFaceStatus, result.getBackImageAnalysisResult().getFaceDetectionStatus().name());
        add(R.string.MBDocumentBackImageMrzStatus, result.getBackImageAnalysisResult().getMrzDetectionStatus().name());
        add(R.string.MBDocumentBackImageBarcodeStatus, result.getBackImageAnalysisResult().getBarcodeDetectionStatus().name());
        add(R.string.MBDocumentBackImageCardOrientation, result.getBackImageAnalysisResult().getCardOrientation().name());
        add(R.string.MBDocumentBackImageCardRotation, result.getBackImageAnalysisResult().getCardRotation() != null ? result.getBackImageAnalysisResult().getCardRotation().name() : "null");

        add(R.string.MBProcessingStatus, result.getProcessingStatus().name());
        add(R.string.MBFrontProcessingStatus, result.getFrontProcessingStatus().name());
        add(R.string.MBBackProcessingStatus, result.getBackProcessingStatus().name());
        add(R.string.MBRecognitionMode, result.getRecognitionMode().name());

        add(R.string.MBFrontAdditionalProcessingInfo, result.getFrontAdditionalProcessingInfo().toString());
        add(R.string.MBBackAdditionalProcessingInfo, result.getBackAdditionalProcessingInfo().toString());

        add(R.string.PPDataMatch, result.getDataMatch().toString());

        add(R.string.MBFrontCameraFrame, result.getFrontCameraFrame());
        add(R.string.MBBackCameraFrame, result.getBackCameraFrame());
        add(R.string.MBBarcodeCameraFrame, result.getBarcodeCameraFrame());
    }

    private void extractMixedNonEmptyResults(BlinkIdMultiSideRecognizer.Result result, String jsonResult) {
        addIfNotEmpty(R.string.PPFirstName, result.getFirstName());
        addIfNotEmpty(R.string.PPLastName, result.getLastName());
        addIfNotEmpty(R.string.PPFullName, result.getFullName());
        addIfNotEmpty(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        addIfNotEmpty(R.string.PPLocalizedName, result.getLocalizedName());
        addIfNotEmpty(R.string.PPFatherName, result.getFathersName());
        addIfNotEmpty(R.string.PPMotherName, result.getMothersName());
        addIfNotEmpty(R.string.PPSex, result.getSex());
        addIfNotEmpty(R.string.PPSponsor, result.getSponsor());
        addIfNotEmpty(R.string.PPBloodType, result.getBloodType());

        addIfNotEmpty(R.string.PPAddress, result.getAddress());
        addIfNotEmpty(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        addIfNotEmpty(R.string.PPAdditionalOptionalAddressInformation, result.getAdditionalOptionalAddressInformation());
        addIfNotEmpty(R.string.PPDateOfBirth, result.getDateOfBirth());
        if (result.getDateOfBirth() != null) {
            addIfNotEmpty(R.string.PPDateOfBirthOriginal, result.getDateOfBirth().getOriginalDateString());
        }
        int age = result.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        addIfNotEmpty(R.string.PPIssueDate, result.getDateOfIssue());
        if (result.getDateOfIssue() != null) {
            addIfNotEmpty(R.string.PPIssueDateOriginal, result.getDateOfIssue().getOriginalDateString());
        }
        addIfNotEmpty(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        if (result.getDateOfExpiry() != null) {
            addIfNotEmpty(R.string.PPDateOfExpiryOriginal, result.getDateOfExpiry().getOriginalDateString());
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

        add(R.string.MBDocumentFrontImageBlurred, result.getFrontImageAnalysisResult().isBlurred());
        addIfNotEmpty(R.string.MBDocumentFrontImageColorStatus, result.getFrontImageAnalysisResult().getDocumentImageColorStatus().name());
        addIfNotEmpty(R.string.MBDocumentFrontImageMoireStatus, result.getFrontImageAnalysisResult().getDocumentImageMoireStatus().name());
        addIfNotEmpty(R.string.MBDocumentFrontImageFaceStatus, result.getFrontImageAnalysisResult().getFaceDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentFrontImageMrzStatus, result.getFrontImageAnalysisResult().getMrzDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentFrontImageBarcodeStatus, result.getFrontImageAnalysisResult().getBarcodeDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentFrontImageCardOrientation, result.getFrontImageAnalysisResult().getCardOrientation().name());
        addIfNotEmpty(R.string.MBDocumentFrontImageCardRotation, result.getFrontImageAnalysisResult().getCardRotation() != null ? result.getFrontImageAnalysisResult().getCardRotation().name() : "null");

        add(R.string.MBDocumentBackImageBlurred, result.getBackImageAnalysisResult().isBlurred());
        addIfNotEmpty(R.string.MBDocumentBackImageColorStatus, result.getBackImageAnalysisResult().getDocumentImageColorStatus().name());
        addIfNotEmpty(R.string.MBDocumentBackImageMoireStatus, result.getBackImageAnalysisResult().getDocumentImageMoireStatus().name());
        addIfNotEmpty(R.string.MBDocumentBackImageFaceStatus, result.getBackImageAnalysisResult().getFaceDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentBackImageMrzStatus, result.getBackImageAnalysisResult().getMrzDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentBackImageBarcodeStatus, result.getBackImageAnalysisResult().getBarcodeDetectionStatus().name());
        addIfNotEmpty(R.string.MBDocumentBackImageCardOrientation, result.getBackImageAnalysisResult().getCardOrientation().name());
        addIfNotEmpty(R.string.MBDocumentBackImageCardRotation, result.getBackImageAnalysisResult().getCardRotation() != null ? result.getBackImageAnalysisResult().getCardRotation().name() : "null");

        addIfNotEmpty(R.string.MBProcessingStatus, result.getProcessingStatus().name());
        addIfNotEmpty(R.string.MBFrontProcessingStatus, result.getFrontProcessingStatus().name());
        addIfNotEmpty(R.string.MBBackProcessingStatus, result.getBackProcessingStatus().name());
        addIfNotEmpty(R.string.MBRecognitionMode, result.getRecognitionMode().name());

        addIfNotEmpty(R.string.MBFrontAdditionalProcessingInfo, result.getFrontAdditionalProcessingInfo().toString());
        addIfNotEmpty(R.string.MBBackAdditionalProcessingInfo, result.getBackAdditionalProcessingInfo().toString());

        addIfNotEmpty(R.string.PPDataMatch, result.getDataMatch().toString());

        add(R.string.MBFrontCameraFrame, result.getFrontCameraFrame());
        add(R.string.MBBackCameraFrame, result.getBackCameraFrame());
        add(R.string.MBBarcodeCameraFrame, result.getBarcodeCameraFrame());
        add(R.string.MBJsonResult, jsonResult);
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
        addIfNotEmpty(R.string.PPSponsor, result.getSponsor());
        addIfNotEmpty(R.string.PPBloodType, result.getBloodType());

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
            for (BarcodeElementKey key : BarcodeElementKey.values()) {
                String barcodeElement = extendedElements.getValue(key);
                if (!barcodeElement.isEmpty()) {
                    add(R.string.PPExtendedBarcodeData, key.name() + ": " + barcodeElement);
                }
            }
        }

        addIfNotEmpty(R.string.PPBarcodeType, result.getBarcodeType().name());
    }

    @Override
    protected void onDataExtractionDone(BlinkIdMultiSideRecognizer.Result result, ResultSource resultSource) {
        if (resultSource == ResultSource.MIXED) {
            extractCommonData(result, mExtractedData, mBuilder);
        }
    }

}