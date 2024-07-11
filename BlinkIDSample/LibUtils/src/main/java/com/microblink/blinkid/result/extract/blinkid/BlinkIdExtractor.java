/*
 * Copyright (c)2020 Microblink Ltd. All rights reserved.
 *
 * ANY UNAUTHORIZED USE OR SALE, DUPLICATION, OR DISTRIBUTION
 * OF THIS PROGRAM OR ANY OF ITS PARTS, IN SOURCE OR BINARY FORMS,
 * WITH OR WITHOUT MODIFICATION, WITH THE PURPOSE OF ACQUIRING
 * UNLAWFUL MATERIAL OR ANY OTHER BENEFIT IS PROHIBITED!
 * THIS PROGRAM IS PROTECTED BY COPYRIGHT LAWS AND YOU MAY NOT
 * REVERSE ENGINEER, DECOMPILE, OR DISASSEMBLE IT.
 */

package com.microblink.blinkid.result.extract.blinkid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.microblink.blinkid.entities.recognizers.Recognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.AlphabetType;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.DateResult;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.DriverLicenseDetailedInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.Side;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.StringResult;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.VehicleClassInfo;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.viz.VizResult;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.EncodedSignatureImageResult;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.FaceImageResult;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.FullDocumentImageResult;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.SignatureImageResult;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdDocumentType;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.BaseResultExtractor;
import com.microblink.blinkid.result.extract.RecognitionResultEntry;
import com.microblink.blinkid.result.extract.util.images.CombinedFullDocumentImagesExtractUtil;
import com.microblink.blinkid.results.date.SimpleDate;
import com.microblink.blinkid.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class BlinkIdExtractor<ResultType extends Recognizer.Result, RecognizerType extends Recognizer<ResultType>> extends BaseResultExtractor<ResultType, RecognizerType> {

    @Override
    protected void onDataExtractionDone(ResultType result) {
        extractCommonData(result, mExtractedData, mBuilder);
        super.onDataExtractionDone(result);
    }

    protected void extractMRZResult(MrzResult mrzResult) {
        MrtdDocumentType docType = mrzResult.getDocumentType();

        add(R.string.PPDocumentType, docType.toString());
        add(R.string.PPMRZParsed, mrzResult.isMrzParsed());
        add(R.string.PPMRZVerified, mrzResult.isMrzVerified());
        add(R.string.PPPrimaryId, mrzResult.getPrimaryId());
        add(R.string.PPSecondaryId, mrzResult.getSecondaryId());
        add(R.string.PPDateOfBirth, mrzResult.getDateOfBirth().getDate(), mrzResult.getDateOfBirth().isFilledByDomainKnowledge());
        int age = mrzResult.getAge();
        if (age != -1) {
            add(R.string.PPAge, age);
        }
        add(R.string.PPSex, mrzResult.getGender());
        add(R.string.PPNationalityCode, mrzResult.getSanitizedNationality());
        add(R.string.PPNationality, mrzResult.getNationalityName());
        add(R.string.PPDocumentCode, mrzResult.getSanitizedDocumentCode());
        add(R.string.PPIssuerCode, mrzResult.getSanitizedIssuer());
        add(R.string.PPIssuer, mrzResult.getIssuerName());
        add(R.string.PPDateOfExpiry, mrzResult.getDateOfExpiry().getDate(), mrzResult.getDateOfExpiry().isFilledByDomainKnowledge());
        add(R.string.PPOpt2, mrzResult.getSanitizedOpt2());
        add(R.string.PPMRZText, mrzResult.getMrzText());

        if (docType == MrtdDocumentType.MRTD_TYPE_GREEN_CARD) {
            add(R.string.PPAlienNumber, mrzResult.getAlienNumber());
            add(R.string.PPApplicationReceiptNumber, mrzResult.getApplicationReceiptNumber());
            add(R.string.PPImmigrantCaseNumber, mrzResult.getImmigrantCaseNumber());
        } else {
            add(R.string.PPDocumentNumber, mrzResult.getSanitizedDocumentNumber());
            add(R.string.PPOpt1, mrzResult.getSanitizedOpt1());
        }
    }

    protected void extractCommonData(Recognizer.Result result,
                                     List<RecognitionResultEntry> extractedData,
                                     RecognitionResultEntry.Builder builder) {
        if (result instanceof FaceImageResult) {
            extractedData.add(builder.build(R.string.MBFaceImage, ((FaceImageResult) result).getFaceImage()));
        }

        if (result instanceof EncodedFaceImageResult) {
            byte[] encodedFaceImage = ((EncodedFaceImageResult) result).getEncodedFaceImage();
            if (shouldShowEncodedImageEntry(encodedFaceImage)) {
                extractedData.add(builder.build(R.string.MBEncodedFaceImage, encodedFaceImage));
            }
        }

        if (result instanceof FullDocumentImageResult) {
            extractedData.add(builder.build(R.string.MBFullDocumentImage, ((FullDocumentImageResult) result).getFullDocumentImage()));
        }

        if (result instanceof EncodedFullDocumentImageResult) {
            byte[] encodedFullDocumentImage = ((EncodedFullDocumentImageResult) result).getEncodedFullDocumentImage();
            if (shouldShowEncodedImageEntry(encodedFullDocumentImage)) {
                extractedData.add(builder.build(R.string.MBEncodedFullDocumentImage, encodedFullDocumentImage));
            }
        }

        CombinedFullDocumentImagesExtractUtil.extractCombinedFullDocumentImages(result, extractedData, builder);

        if (result instanceof SignatureImageResult) {
            extractedData.add(builder.build(R.string.MBSignatureImage, ((SignatureImageResult) result).getSignatureImage()));
        }

        if (result instanceof EncodedSignatureImageResult) {
            byte[] encodedSignatureImage = ((EncodedSignatureImageResult) result).getEncodedSignatureImage();
            if (shouldShowEncodedImageEntry(encodedSignatureImage)) {
                extractedData.add(builder.build(R.string.MBEncodedSignatureImage, encodedSignatureImage));
            }
        }
    }

    protected static boolean shouldShowEncodedImageEntry(byte[] encodedImage) {
        return encodedImage != null && encodedImage.length > 0;
    }

    protected void addIfNotEmpty(int key, StringResult value) {
        if (value != null && !value.isEmpty()) {
            mExtractedData.add(mBuilder.build(key, value.toString()));
        }
    }

    protected void add(int key, StringResult value) {
        mExtractedData.add(mBuilder.build(key, value != null ? value.toString() : null));
    }

    protected void addLocation(int key, StringResult value) {
        if (value == null || value.value().isEmpty()) return;
        try {
            JSONObject root = new JSONObject();

            if (!value.value(AlphabetType.Latin).isEmpty()) {
                JSONObject latin = new JSONObject();

                latin.put("value", value.value(AlphabetType.Latin));
                latin.put("side", value.side(AlphabetType.Latin) != null ? value.side(AlphabetType.Latin) : "null");
                latin.put("location", value.location(AlphabetType.Latin) != null ? value.location(AlphabetType.Latin).toString() : "null");
                root.put("latin", latin);
            }

            if (!value.value(AlphabetType.Arabic).isEmpty()) {
                JSONObject arabic = new JSONObject();
                arabic.put("value", value.value(AlphabetType.Arabic));
                arabic.put("side", value.side(AlphabetType.Arabic) != null ? value.side(AlphabetType.Arabic) : "null");
                arabic.put("location", value.location(AlphabetType.Arabic) != null ? value.location(AlphabetType.Arabic).toString() : "null");
                root.put("arabic", arabic);
            }

            if (!value.value(AlphabetType.Cyrillic).isEmpty()) {
                JSONObject cyrilic = new JSONObject();
                cyrilic.put("value", value.value(AlphabetType.Cyrillic));
                cyrilic.put("side", value.side(AlphabetType.Cyrillic) != null ? value.side(AlphabetType.Cyrillic) : "null");
                cyrilic.put("location", value.location(AlphabetType.Cyrillic) != null ? value.location(AlphabetType.Cyrillic).toString() : "null");
                root.put("cyrilic", cyrilic);
            }

            add(key, root.toString(2).replaceAll("\\\\", ""));

        } catch (JSONException e) {
            Log.e(this, "Exception creating locations!" + e.getMessage());
        }
    }

    protected void addLocation(int key, DateResult value) {
        if (value == null) return;
        addLocation(key, value.getOriginalDateString());
    }

    protected void addIfNotEmpty(int key, DateResult dateResult) {
        if (dateResult == null) return;
        SimpleDate date = dateResult.getDate();
        if (date != null) {
            add(key, date, dateResult.isFilledByDomainKnowledge());
        } else {
            addIfNotEmpty(key, dateResult.getOriginalDateString());
        }
    }

    protected void add(int key, DateResult date) {
        mExtractedData.add(mBuilder.build(key, date != null ? date.getDate() : null, date != null ? date.isFilledByDomainKnowledge() : false));
    }

    protected void extractLocationsResultsFromVizResult(VizResult result) {
        addLocation(R.string.PPFirstName, result.getFirstName());
        addLocation(R.string.PPLastName, result.getLastName());
        addLocation(R.string.PPFullName, result.getFullName());
        addLocation(R.string.PPAdditionalNameInformation, result.getAdditionalNameInformation());
        addLocation(R.string.PPLocalizedName, result.getLocalizedName());
        addLocation(R.string.PPFatherName, result.getFathersName());
        addLocation(R.string.PPMotherName, result.getMothersName());
        addLocation(R.string.PPSex, result.getSex());

        addLocation(R.string.PPAddress, result.getAddress());
        addLocation(R.string.PPAdditionalAddressInformation, result.getAdditionalAddressInformation());
        addLocation(R.string.PPAdditionalOptionalAddressInformation, result.getAdditionalOptionalAddressInformation());
        addLocation(R.string.PPDateOfBirth, result.getDateOfBirth());

        addLocation(R.string.PPIssueDate, result.getDateOfIssue());
        addLocation(R.string.PPDateOfExpiry, result.getDateOfExpiry());

        addLocation(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        addLocation(R.string.PPNationality, result.getNationality());

        addLocation(R.string.PPRace, result.getRace());
        addLocation(R.string.PPReligion, result.getReligion());
        addLocation(R.string.PPProfession, result.getProfession());
        addLocation(R.string.PPMaritalStatus, result.getMaritalStatus());
        addLocation(R.string.PPResidentialStatus, result.getResidentialStatus());
        addLocation(R.string.PPEmployer, result.getEmployer());

        addLocation(R.string.PPDocumentNumber, result.getDocumentNumber());
        addLocation(R.string.PPPersonalNumber, result.getPersonalIdNumber());
        addLocation(R.string.PPDocumentAdditionalNumber, result.getDocumentAdditionalNumber());
        addLocation(R.string.PPDocumentOptionalAdditionalNumber, result.getDocumentOptionalAdditionalNumber());
        addLocation(R.string.PPPersonalAdditionalNumber, result.getAdditionalPersonalIdNumber());
        addLocation(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        addLocation(R.string.PPDocumentSubtype, result.getDocumentSubtype());
        addLocation(R.string.PPRemarks, result.getRemarks());
        addLocation(R.string.PPResidencePermitType, result.getResidencePermitType());
        addLocation(R.string.PPVisaType, result.getVisaType());

        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            addLocation(R.string.PPRestrictions, driverLicenseInfo.getRestrictions());
            addLocation(R.string.PPConditions, driverLicenseInfo.getConditions());
            addLocation(R.string.PPEndorsements, driverLicenseInfo.getEndorsements());
            addLocation(R.string.PPVehicleClass, driverLicenseInfo.getVehicleClass());
            for (VehicleClassInfo vehicleClassInfo : driverLicenseInfo.getVehicleClassesInfo()) {
                addLocation(R.string.PPVehicleClass, vehicleClassInfo.getVehicleClass());
                addLocation(R.string.PPLicenceType, vehicleClassInfo.getLicenceType());
                addLocation(R.string.PPEffectiveDate, vehicleClassInfo.getEffectiveDate());
                addLocation(R.string.PPDateOfExpiry, vehicleClassInfo.getExpiryDate());
            }
        }
    }

    protected List<StringResult> getAllStringResultsFromVizResult(VizResult result) {
        List<StringResult> allStringResults = new ArrayList<>();
        allStringResults.add(result.getFirstName());
        allStringResults.add(result.getLastName());
        allStringResults.add(result.getFullName());
        allStringResults.add(result.getAdditionalNameInformation());
        allStringResults.add(result.getLocalizedName());
        allStringResults.add(result.getFathersName());
        allStringResults.add(result.getMothersName());
        allStringResults.add(result.getSex());

        allStringResults.add(result.getAddress());
        allStringResults.add(result.getAdditionalAddressInformation());
        allStringResults.add(result.getAdditionalOptionalAddressInformation());

        if (result.getDateOfBirth() != null) allStringResults.add(result.getDateOfBirth().getOriginalDateString());
        if (result.getDateOfIssue() != null) allStringResults.add(result.getDateOfIssue().getOriginalDateString());
        if (result.getDateOfExpiry() != null) allStringResults.add(result.getDateOfExpiry().getOriginalDateString());

        allStringResults.add(result.getPlaceOfBirth());
        allStringResults.add(result.getNationality());

        allStringResults.add(result.getRace());
        allStringResults.add(result.getReligion());
        allStringResults.add(result.getProfession());
        allStringResults.add(result.getMaritalStatus());
        allStringResults.add(result.getResidentialStatus());
        allStringResults.add(result.getEmployer());

        allStringResults.add(result.getDocumentNumber());
        allStringResults.add(result.getPersonalIdNumber());
        allStringResults.add(result.getDocumentAdditionalNumber());
        allStringResults.add(result.getDocumentOptionalAdditionalNumber());
        allStringResults.add(result.getAdditionalPersonalIdNumber());
        allStringResults.add(result.getIssuingAuthority());
        allStringResults.add(result.getDocumentSubtype());
        allStringResults.add(result.getRemarks());
        allStringResults.add(result.getResidencePermitType());
        allStringResults.add(result.getVisaType());
        DriverLicenseDetailedInfo driverLicenseInfo = result.getDriverLicenseDetailedInfo();
        if (!driverLicenseInfo.isEmpty()) {
            allStringResults.add(driverLicenseInfo.getRestrictions());
            allStringResults.add(driverLicenseInfo.getConditions());
            allStringResults.add(driverLicenseInfo.getEndorsements());
            allStringResults.add(driverLicenseInfo.getVehicleClass());
            for (VehicleClassInfo vehicleClassInfo : driverLicenseInfo.getVehicleClassesInfo()) {
                allStringResults.add(vehicleClassInfo.getVehicleClass());
                allStringResults.add(vehicleClassInfo.getLicenceType());
                if (vehicleClassInfo.getEffectiveDate() != null) allStringResults.add(vehicleClassInfo.getEffectiveDate().getOriginalDateString());
                if (vehicleClassInfo.getExpiryDate() != null) allStringResults.add(vehicleClassInfo.getExpiryDate().getOriginalDateString());
            }
        }
        return allStringResults;
    }

    protected void drawLocationsOnBitmap(Canvas canvas, Paint paint, List<StringResult> stringResults, Side side) {
        if (stringResults.size() == 0) return;
        for (StringResult stringResult : stringResults) {
            if (stringResult == null) continue;
            if (!stringResult.value(AlphabetType.Latin).isEmpty() && stringResult.location(AlphabetType.Latin) != null && stringResult.side(AlphabetType.Latin) == side) {
                paint.setColor(Color.GREEN);
                canvas.drawRect(stringResult.location(AlphabetType.Latin).toRectF(), paint);
            }
            if (!stringResult.value(AlphabetType.Arabic).isEmpty() && stringResult.location(AlphabetType.Arabic) != null && stringResult.side(AlphabetType.Arabic) == side) {
                paint.setColor(Color.RED);
                canvas.drawRect(stringResult.location(AlphabetType.Arabic).toRectF(), paint);
            }
            if (!stringResult.value(AlphabetType.Cyrillic).isEmpty() && stringResult.location(AlphabetType.Cyrillic) != null && stringResult.side(AlphabetType.Cyrillic) == side) {
                paint.setColor(Color.BLUE);
                canvas.drawRect(stringResult.location(AlphabetType.Cyrillic).toRectF(), paint);
            }
        }
    }
}
