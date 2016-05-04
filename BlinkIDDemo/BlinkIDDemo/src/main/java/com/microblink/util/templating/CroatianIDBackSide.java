package com.microblink.util.templating;

import android.os.Parcel;

import com.microblink.detectors.DecodingInfo;
import com.microblink.geometry.Rectangle;
import com.microblink.recognizers.blinkid.mrtd.MRTDDocumentClassifier;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognitionResult;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognizerSettings;
import com.microblink.recognizers.blinkocr.parser.generic.DateParserSettings;
import com.microblink.recognizers.blinkocr.parser.regex.RegexParserSettings;
import com.microblink.recognizers.templating.TemplatingRecognizerSettings;
import com.microblink.results.ocr.OcrFont;
import com.microblink.util.TemplatingUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which can return MRTDRecognizerSettings configured to scan back side of Croatian IDs.
 */
public class CroatianIDBackSide {

    private static final String ID_ADDRESS = "Address";
    private static final String ID_ISSUED_BY = "IssuedBy";
    private static final String ID_DATE_OF_ISSUE = "DateOfIssue";

    private static final String CLASS_OLD_ID = "oldCroId";
    private static final String CLASS_NEW_ID = "newCrogd";


    private static void setupAddress(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        RegexParserSettings addressParser = new RegexParserSettings("([A-ZŠĐŽČĆ]+,? ?)+\n([A-ZŠĐŽČĆ]+ ?)+\\d+");
        CroatianIDFrontSide.addAllCroatianUppercaseCharsToWhitelist(addressParser.getOcrEngineOptions());
        addressParser.getOcrEngineOptions().addAllDigitsToWhitelist(OcrFont.OCR_FONT_ANY);
        addressParser.getOcrEngineOptions().setColorDropoutEnabled(false);
        addressParser.getOcrEngineOptions().setMinimumCharHeight(35);

        settings.addParserToParserGroup(ID_ADDRESS, ID_ADDRESS, addressParser);

        oldId.add(new DecodingInfo(new Rectangle(0.247f, 0.056f, 0.459f, 0.148f), 200, ID_ADDRESS));
        newId.add(new DecodingInfo(new Rectangle(0.247f, 0.056f, 0.459f, 0.185f), 300, ID_ADDRESS));
    }

    private static void setupIssuedBy(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        RegexParserSettings issuedByParser = new RegexParserSettings("P[PU] ([A-ZŠĐŽČĆ]+ ?)+");
        CroatianIDFrontSide.addAllCroatianUppercaseCharsToWhitelist(issuedByParser.getOcrEngineOptions());
        issuedByParser.getOcrEngineOptions().setColorDropoutEnabled(false);
        issuedByParser.getOcrEngineOptions().setMinimumCharHeight(20);

        settings.addParserToParserGroup(ID_ISSUED_BY, ID_ISSUED_BY, issuedByParser);

        oldId.add(new DecodingInfo(new Rectangle(0.247f, 0.204f, 0.459f, 0.111f), 100, ID_ISSUED_BY));
        newId.add(new DecodingInfo(new Rectangle(0.247f, 0.241f, 0.459f, 0.130f), 100, ID_ISSUED_BY));
    }

    private static void setupDateOfIssue(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        settings.addParserToParserGroup(ID_DATE_OF_ISSUE, ID_DATE_OF_ISSUE, new DateParserSettings());

        oldId.add(new DecodingInfo(new Rectangle(0.247f, 0.315f, 0.282f, 0.111f), 100, ID_DATE_OF_ISSUE));
        newId.add(new DecodingInfo(new Rectangle(0.247f, 0.370f, 0.282f, 0.093f), 100, ID_DATE_OF_ISSUE));
    }

    public static MRTDRecognizerSettings buildCroatianIDBackSideRecognizerSettings() {
        MRTDRecognizerSettings settings = new MRTDRecognizerSettings();

        List<DecodingInfo> oldIdDecodingInfos = new ArrayList<>();
        List<DecodingInfo> newIdDecodingInfos = new ArrayList<>();
        setupAddress(settings, oldIdDecodingInfos, newIdDecodingInfos);
        setupIssuedBy(settings, oldIdDecodingInfos, newIdDecodingInfos);
        setupDateOfIssue(settings, oldIdDecodingInfos, newIdDecodingInfos);

        settings.setParserDecodingInfos(TemplatingUtils.listToArray(newIdDecodingInfos), CLASS_NEW_ID);
        settings.setParserDecodingInfos(TemplatingUtils.listToArray(oldIdDecodingInfos), CLASS_OLD_ID);
        settings.setDocumentClassifier(new CroBackIdClassifier());

        return settings;
    }

    private static class CroBackIdClassifier implements MRTDDocumentClassifier {

        @Override
        public String classifyDocument(MRTDRecognitionResult mrzExtractionResult) {
            if (mrzExtractionResult.isValid()) {
                // check opt1 - if it contains OIB, then it is a new ID
                if ("<<<<<<<<<<<<<<<".equals(mrzExtractionResult.getOpt1())) {
                    return CLASS_OLD_ID;
                } else {
                    return CLASS_NEW_ID;
                }
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

        public CroBackIdClassifier() {
        }

        public static final Creator<CroBackIdClassifier> CREATOR = new Creator<CroBackIdClassifier>() {
            @Override
            public CroBackIdClassifier createFromParcel(Parcel source) {
                return new CroBackIdClassifier();
            }

            @Override
            public CroBackIdClassifier[] newArray(int size) {
                return new CroBackIdClassifier[size];
            }
        };
    }
}
