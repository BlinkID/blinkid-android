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
 * This class will show how a Templating API extension of {@link MRTDRecognizerSettings} can be used
 * to scan additional elements besides fields from Machine Readable Zone.
 * <p/>
 * This example will show how to extract address, issuing authority and date of issue
 * from back side of Croatian ID cards. This data is not available in Machine Readable Zone.
 * <p/>
 * The description of how ID cards in Croatia look like can be found on Wikipedia:
 * https://en.wikipedia.org/wiki/Croatian_identity_card
 * <p/>
 * This class will focus only on back side of Croatian ID cards. For example of how to use
 * Templating API for scanning front side, check class {@link com.microblink.util.templating.CroatianIDFrontSide}.
 * <p/>
 * As can be seen on Wikipedia, there are two types of Croatian ID cards - those issued from
 * year 2003 until yar 2013 and those issued after year 2013. The positions of fields we want
 * to extract are not same on versions from 2003 and 2013. Therefore, we first need to determine
 * which version of ID are we dealing with. For that matter, we will implement interface
 * {@link MRTDDocumentClassifier} as shown in {@link CroBackIdClassifier}.
 * <p/>
 * The process of setting up {@link MRTDRecognizerSettings} for scanning required fields
 * is shown in method {@link #buildCroatianIDBackSideRecognizerSettings()}.
 */
public class CroatianIDBackSide {

    private static final String ID_ADDRESS = "Address";
    private static final String ID_ISSUED_BY = "IssuedBy";
    private static final String ID_DATE_OF_ISSUE = "DateOfIssue";

    private static final String CLASS_OLD_ID = "oldCroId";
    private static final String CLASS_NEW_ID = "newCroId";

    /**
     * This function will setup address parser and location on back side of Croatian ID cards.
     * <p/>
     * The Croatian ID card has width of 85mm and height of 54mm. If we take a ruler and measure
     * the locations of address field, we get the following measurements:
     * <p/>
     * on old croatian ID card, address field is located in following rectangle:
     * left = 21 mm
     * right = 60 mm
     * top = 3 mm
     * bottom = 11 mm
     * <p/>
     * {@link DecodingInfo} requires converting this rectangle into relative coordinates so we get
     * the following:
     * <p/>
     * x = 21mm / 85mm = 0.247
     * y = 3mm / 54mm = 0.056
     * width = (60mm - 21mm) / 85mm = 0.459
     * height = (11mm - 3mm) / 54mm = 0.148
     * <p/>
     * The address field on old croatian ID cards can hold up to two lines of text. Therefore, we
     * will require that dewarped image from this location has height of 200 pixels.
     * The width of the image will be automatically determined to keep the original aspect ratio.
     * <p/>
     * Similarly, on new croatian ID card, address field is located in following rectangle:
     * left = 21 mm
     * right = 60 mm
     * top = 3 mm
     * bottom = 13 mm
     * <p/>
     * After converting this to relative coordinates, we get the following:
     * <p/>
     * x = 21mm / 8mm5 = 0.247
     * y = 3mm / 54mm = 0.056
     * width = (60mm - 21mm) / 85mm = 0.459
     * height = (13mm - 3mm) / 54mm = 0.185
     * <p/>
     * The address field on new croatian ID cards can hold up to three lines of text. Therefore, we
     * will require that dewarped image from this location has height of 300 pixels.
     * The width of the image will be automatically determined to keep the original aspect ratio.
     */
    private static void setupAddress(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        /*
         * For parsing address, we will use regex parser which expects one or more words in first line (the name of city),
         * and one or more words and a number in second line (street name and number).
         */
        RegexParserSettings addressParser = new RegexParserSettings("([A-ZŠĐŽČĆ]+,? ?)+\n([A-ZŠĐŽČĆ]+ ?)+\\d+");
        /*
         * To ensure optimal OCR results, we will allow only uppercase letters and digits in OCR. Thus, OCR
         * will not return lowercase letters, reducing the possibility of misreads.
         */
        CroatianIDFrontSide.addAllCroatianUppercaseCharsToWhitelist(addressParser.getOcrEngineOptions());
        addressParser.getOcrEngineOptions().addAllDigitsToWhitelist(OcrFont.OCR_FONT_ANY);
        addressParser.getOcrEngineOptions().setColorDropoutEnabled(false);
        addressParser.getOcrEngineOptions().setMinimumCharHeight(35);

        /*
         * Now we need to add parser to parser group. We must ensure that name of parser group is same
         * as name in decoding info, as this associates the parser group settings to location on the
         * ID card.
         * In this case we will only have one parser in parser group, so we can use the same name both
         * for parser and parser group.
         * It is also possible to add multiple parsers to same parser group. You can see an example
         * of that in CroatianIDFrontSide class which shows how to use Templating API for scanning
         * front side of Croatian ID cards.
         */
        settings.addParserToParserGroup(ID_ADDRESS, ID_ADDRESS, addressParser);

        /*
         * Finally, we setup the locations on document where this parser group can be used.
         * We will setup two different locations - one for old ID cards and one for new ID cards.
         */
        oldId.add(new DecodingInfo(new Rectangle(0.247f, 0.056f, 0.459f, 0.148f), 200, ID_ADDRESS));
        newId.add(new DecodingInfo(new Rectangle(0.247f, 0.056f, 0.459f, 0.185f), 300, ID_ADDRESS));
    }

    /**
     * This function will setup issuing authority parser and location on back side of Croatian ID cards.
     * <p/>
     * The setting up is same as shown in {@link #setupAddress(TemplatingRecognizerSettings, List, List)},
     * except different regular expression and locations are used.
     */
    private static void setupIssuedBy(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        RegexParserSettings issuedByParser = new RegexParserSettings("P[PU] ([A-ZŠĐŽČĆ]+ ?)+");
        CroatianIDFrontSide.addAllCroatianUppercaseCharsToWhitelist(issuedByParser.getOcrEngineOptions());
        issuedByParser.getOcrEngineOptions().setColorDropoutEnabled(false);
        issuedByParser.getOcrEngineOptions().setMinimumCharHeight(20);

        settings.addParserToParserGroup(ID_ISSUED_BY, ID_ISSUED_BY, issuedByParser);

        oldId.add(new DecodingInfo(new Rectangle(0.247f, 0.204f, 0.459f, 0.111f), 100, ID_ISSUED_BY));
        newId.add(new DecodingInfo(new Rectangle(0.247f, 0.241f, 0.459f, 0.130f), 100, ID_ISSUED_BY));
    }

    /**
     * This function will setup date of issue parser and location on back side of Croatian ID cards.
     * <p/>
     * The setting up is almost the same as shown in {@link #setupAddress(TemplatingRecognizerSettings, List, List)}, except
     * dedicated {@link DateParserSettings} is used for setting up date parser, instead of using Regular Expression parser.
     */
    private static void setupDateOfIssue(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        settings.addParserToParserGroup(ID_DATE_OF_ISSUE, ID_DATE_OF_ISSUE, new DateParserSettings());

        oldId.add(new DecodingInfo(new Rectangle(0.247f, 0.315f, 0.282f, 0.111f), 100, ID_DATE_OF_ISSUE));
        newId.add(new DecodingInfo(new Rectangle(0.247f, 0.370f, 0.282f, 0.093f), 100, ID_DATE_OF_ISSUE));
    }

    /**
     * This method shows how {@link MRTDRecognizerSettings} can be set up to also scan Address,
     * Issuing Authority and Date of issue from back side of Croatian ID cards, besides scanning
     * data from Machine Readable Zone.
     *
     * @return set-up {@link MRTDRecognizerSettings} object which can scan Address, Issuing Authority
     * and date of issue from back side of Croatian ID cards (besides data from Machine Readable Zone)
     */
    public static MRTDRecognizerSettings buildCroatianIDBackSideRecognizerSettings() {
        // at first, we create MRTDRecognizerSettings object as if we would when scanning
        // normal ID card or passport with Machine Readable Zone.
        MRTDRecognizerSettings settings = new MRTDRecognizerSettings();

        // the trick to scanning non-MRZ data is to define locations inside document where data
        // is located and parser which will be used to extract the data.
        // we use two lists of DecodingInfo objects - one for holding locations on old ID card (version from year 2003)
        // and one for holding locations on new ID card (version from year 2013)
        List<DecodingInfo> oldIdDecodingInfos = new ArrayList<>();
        List<DecodingInfo> newIdDecodingInfos = new ArrayList<>();
        // setup methods will add locations to list and will also add parser to settings object
        setupAddress(settings, oldIdDecodingInfos, newIdDecodingInfos);
        setupIssuedBy(settings, oldIdDecodingInfos, newIdDecodingInfos);
        setupDateOfIssue(settings, oldIdDecodingInfos, newIdDecodingInfos);

        // after locations have been configured, we need to set them to settings object.
        // We will use two classes, one for old ID card and one for new ID card. Classes are named
        // with strings CLASS_NEW_ID and CLASS_OLD_ID.
        settings.setParserDecodingInfos(TemplatingUtils.listToArray(newIdDecodingInfos), CLASS_NEW_ID);
        settings.setParserDecodingInfos(TemplatingUtils.listToArray(oldIdDecodingInfos), CLASS_OLD_ID);
        // finally, we set the document classifier which will use the data parsed from
        // machine readable zone to determine whether new ID or old ID is being scanned.
        // After this is determined, location list from either CLASS_NEW_ID or CLASS_OLD_ID will
        // be used for reading non-MRZ data.
        settings.setDocumentClassifier(new CroBackIdClassifier());

        return settings;
    }

    /**
     * This class implements {@link MRTDDocumentClassifier} interface. In its {@link #classifyDocument(MRTDRecognitionResult)}
     * method it must decide from {@link MRTDRecognitionResult} containing data parsed from machine
     * readable zone whether the document being scanned is old or new croatian ID. If document cannot
     * be classified, an empty string or null can be returned.
     */
    private static class CroBackIdClassifier implements MRTDDocumentClassifier {

        @Override
        public String classifyDocument(MRTDRecognitionResult mrzExtractionResult) {
            // ensure we are scanning Croatian Identity card
            if ("HRV".equals(mrzExtractionResult.getIssuer()) && "IO".equals(mrzExtractionResult.getDocumentCode())) {
                // if MRZ data is from Croatian ID card, we can discriminate new and old ID card
                // by opt1 field - old croatian ID cards have this field empty,
                // i.e. the value of that field is '<<<<<<<<<<<<<<<'.
                // New ID cards contain personal identification number in this field.
                if ("<<<<<<<<<<<<<<<".equals(mrzExtractionResult.getOpt1())) {
                    return CLASS_OLD_ID;
                } else {
                    return CLASS_NEW_ID;
                }
            }
            // if not scanning Croatian ID, refuse classification
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

        /**
         * {@link MRTDDocumentClassifier} interface extends {@link android.os.Parcelable} so it can
         * be sent via Intent inside {@link MRTDRecognizerSettings}. In order to be able to extract
         * the classifier from {@link Parcel}, {@link #CREATOR} field must be defined.
         */
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
