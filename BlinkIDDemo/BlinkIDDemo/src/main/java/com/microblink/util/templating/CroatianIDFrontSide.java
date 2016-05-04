package com.microblink.util.templating;

import android.os.Parcel;

import com.microblink.detectors.DecodingInfo;
import com.microblink.detectors.document.DocumentDetectorSettings;
import com.microblink.detectors.document.DocumentSpecification;
import com.microblink.detectors.document.DocumentSpecificationPreset;
import com.microblink.geometry.Rectangle;
import com.microblink.recognizers.blinkocr.BlinkOCRRecognitionResult;
import com.microblink.recognizers.blinkocr.BlinkOCRRecognizerSettings;
import com.microblink.recognizers.blinkocr.DocumentClassifier;
import com.microblink.recognizers.blinkocr.engine.BlinkOCREngineOptions;
import com.microblink.recognizers.blinkocr.parser.generic.DateParserSettings;
import com.microblink.recognizers.blinkocr.parser.regex.RegexParserSettings;
import com.microblink.recognizers.templating.TemplatingRecognizerSettings;
import com.microblink.results.ocr.OcrFont;
import com.microblink.util.TemplatingUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which can return BlinkOCRRecognizerSettings configured to scan front side of Croatian IDs.
 */
public class CroatianIDFrontSide {
    private static final String ID_LAST_NAME = "LastName";
    private static final String ID_FIRST_NAME = "FirstName";
    private static final String ID_SEX_CITIZENSHIP_DOB = "SexCitizenshipDob";
    private static final String ID_SEX = "Sex";
    private static final String ID_CITIZENSHIP = "Citizenship";
    private static final String ID_DATE_OF_BIRTH = "DateOfBirth";
    private static final String ID_DOCUMENT_NUMBER = "DocumentNumber";
    private static final String ID_DOCUMENT_NUMBER_OLD = "DocumentNumberOld";
    private static final String ID_DOCUMENT_NUMBER_NEW = "DocumentNumberNew";

    private static final String CLASS_OLD_ID = "oldCroId";
    private static final String CLASS_NEW_ID = "newCrogd";

    static void addAllCroatianUppercaseCharsToWhitelist(BlinkOCREngineOptions options) {
        options.addUppercaseCharsToWhitelist(OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Š', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Đ', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Ž', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Č', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Ć', OcrFont.OCR_FONT_ANY);
    }

    private static void setupName(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId, boolean firstName) {
        String id = firstName ? ID_FIRST_NAME : ID_LAST_NAME;
        int dewarpHeight = firstName ? 150 : 100;

        RegexParserSettings nameParser = new RegexParserSettings("([A-ZŠĐŽČĆ]+ ?)+");
        addAllCroatianUppercaseCharsToWhitelist(nameParser.getOcrEngineOptions());

        settings.addParserToParserGroup(id, id, nameParser);

        Rectangle locationOld = firstName ? new Rectangle(0.282f, 0.333f, 0.306f, 0.167f) : new Rectangle(0.282f, 0.204f, 0.306f, 0.111f);
        Rectangle locationNew = firstName ? new Rectangle(0.282f, 0.389f, 0.353f, 0.167f) : new Rectangle(0.282f, 0.204f, 0.353f, 0.167f);

        oldId.add(new DecodingInfo(locationOld, dewarpHeight, id));
        newId.add(new DecodingInfo(locationNew, dewarpHeight, id));
    }

    private static void setupSexCitizenshipAndDateOfBirth(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        oldId.add(new DecodingInfo(new Rectangle(0.407f, 0.500f, 0.259f, 0.296f), 300, ID_SEX_CITIZENSHIP_DOB));
        newId.add(new DecodingInfo(new Rectangle(0.388f, 0.500f, 0.282f, 0.296f), 300, ID_SEX_CITIZENSHIP_DOB));

        RegexParserSettings sexParser = new RegexParserSettings("[MŽ]/[MF]");
        sexParser.getOcrEngineOptions().addCharToWhitelist('M', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('F', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('Ž', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('/', OcrFont.OCR_FONT_ANY);
        sexParser.setMustEndWithWhitespace(true);
        sexParser.setMustStartWithWhitespace(true);

        settings.addParserToParserGroup(ID_SEX_CITIZENSHIP_DOB, ID_SEX, sexParser);

        RegexParserSettings citizenshipParser = new RegexParserSettings("[A-Z]{3}");
        addAllCroatianUppercaseCharsToWhitelist(citizenshipParser.getOcrEngineOptions());
        citizenshipParser.setMustEndWithWhitespace(true);
        citizenshipParser.setMustStartWithWhitespace(true);

        settings.addParserToParserGroup(ID_SEX_CITIZENSHIP_DOB, ID_CITIZENSHIP, citizenshipParser);

        settings.addParserToParserGroup(ID_SEX_CITIZENSHIP_DOB, ID_DATE_OF_BIRTH, new DateParserSettings());
    }

    private static void setupDocumentNumber(TemplatingRecognizerSettings settings, List<DecodingInfo> decodingInfos) {
        decodingInfos.add(new DecodingInfo(new Rectangle(0.047f, 0.519f, 0.224f, 0.111f), 150, ID_DOCUMENT_NUMBER_OLD));
        decodingInfos.add(new DecodingInfo(new Rectangle(0.047f, 0.685f, 0.224f, 0.111f), 150, ID_DOCUMENT_NUMBER_NEW));

        RegexParserSettings documentNumberParser = new RegexParserSettings("\\d{9}");
        documentNumberParser.getOcrEngineOptions().addAllDigitsToWhitelist(OcrFont.OCR_FONT_ANY);
        documentNumberParser.getOcrEngineOptions().setMinimumCharHeight(35);

        settings.addParserToParserGroup(ID_DOCUMENT_NUMBER_OLD, ID_DOCUMENT_NUMBER, documentNumberParser);
        settings.addParserToParserGroup(ID_DOCUMENT_NUMBER_NEW, ID_DOCUMENT_NUMBER, documentNumberParser);
    }

    public static BlinkOCRRecognizerSettings buildCroatianIDFrontSideRecognizerSettings() {
        BlinkOCRRecognizerSettings settings = new BlinkOCRRecognizerSettings();
        List<DecodingInfo> oldIdDecodingInfos = new ArrayList<>();
        List<DecodingInfo> newIdDecodingInfos = new ArrayList<>();
        List<DecodingInfo> classificationDecodingInfos = new ArrayList<>();

        setupName(settings, oldIdDecodingInfos, newIdDecodingInfos, false);
        setupName(settings, oldIdDecodingInfos, newIdDecodingInfos, true);
        setupSexCitizenshipAndDateOfBirth(settings, oldIdDecodingInfos, newIdDecodingInfos);
        setupDocumentNumber(settings, classificationDecodingInfos);

        // setup card detector
        DocumentSpecification idSpec = DocumentSpecification.createFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD);
        idSpec.setDecodingInfos(TemplatingUtils.listToArray(classificationDecodingInfos));
        DocumentDetectorSettings dds = new DocumentDetectorSettings(new DocumentSpecification[]{idSpec});

        settings.setDetectorSettings(dds);

        settings.setDocumentClassifier(new CroFrontIdClassifier());
        // set decoding info classes
        settings.setParserDecodingInfos(TemplatingUtils.listToArray(oldIdDecodingInfos), CLASS_OLD_ID);
        settings.setParserDecodingInfos(TemplatingUtils.listToArray(newIdDecodingInfos), CLASS_NEW_ID);

        settings.setAllowFlippedRecognition(true);

        return settings;
    }

    private static class CroFrontIdClassifier implements DocumentClassifier {

        @Override
        public String classifyDocument(BlinkOCRRecognitionResult extractionResult) {
            if (extractionResult.isValid()) {
                String documentNumber = extractionResult.getParsedResult(ID_DOCUMENT_NUMBER_OLD, ID_DOCUMENT_NUMBER);
                if (documentNumber != null && !"".equals(documentNumber)) {
                    return CLASS_OLD_ID;
                }
                documentNumber = extractionResult.getParsedResult(ID_DOCUMENT_NUMBER_NEW, ID_DOCUMENT_NUMBER);
                if (documentNumber != null && !"".equals(documentNumber)) {
                    return CLASS_NEW_ID;
                }
                return null;
            }
            return null;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public CroFrontIdClassifier() {
        }

        protected CroFrontIdClassifier(Parcel in) {
        }

        public static final Creator<CroFrontIdClassifier> CREATOR = new Creator<CroFrontIdClassifier>() {
            @Override
            public CroFrontIdClassifier createFromParcel(Parcel source) {
                return new CroFrontIdClassifier(source);
            }

            @Override
            public CroFrontIdClassifier[] newArray(int size) {
                return new CroFrontIdClassifier[size];
            }
        };
    }
}
