package com.microblink.util.templating;

import android.os.Parcel;

import com.microblink.detectors.DecodingInfo;
import com.microblink.detectors.DetectorSettings;
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
 * This class will show how a Templating API extension of {@link BlinkOCRRecognizerSettings} can be used
 * to scan elements from parts of detection.
 * <p/>
 * This example will show how to setup {@link BlinkOCRRecognizerSettings} to perform detection and
 * data extraction from front side of Croatian ID cards.
 * <p/>
 * The description of how ID cards in Croatia look like can be found on Wikipedia:
 * https://en.wikipedia.org/wiki/Croatian_identity_card
 * <p/>
 * Croatian IDs are credit card sized documents. This example will show you how to setup {@link DocumentDetectorSettings}
 * to perform detection of credit card sized documents and how to perform OCR and data extraction from
 * locations defined by {@link DecodingInfo} objects inherent to detector. Even more, this data will
 * then be used to perform classification of type of Croatian ID document using {@link DocumentClassifier}
 * which will determine whether scanned document is Croatian ID version from year 2003 or from year 2013.
 * After this is determined, specific {@link DecodingInfo} objects will be used to extract other
 * data from locations specific to each version of Croatian ID.
 * <p/>
 * The process of setting up {@link BlinkOCRRecognizerSettings} for scanning front side of Croatian ID
 * is shown in method {@link #buildCroatianIDFrontSideRecognizerSettings()}.
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
    private static final String CLASS_NEW_ID = "newCroId";

    /**
     * This function will setup {@link BlinkOCREngineOptions} to allow recognition
     * only of uppercase latin letters used in Croatia.
     *
     * @param options {@link BlinkOCREngineOptions} object to be set up
     */
    static void addAllCroatianUppercaseCharsToWhitelist(BlinkOCREngineOptions options) {
        options.addUppercaseCharsToWhitelist(OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Š', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Đ', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Ž', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Č', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Ć', OcrFont.OCR_FONT_ANY);
    }

    /**
     * This function will setup first and last name parser and locations of first and last
     * names on front side of Croatian ID cards.
     * <p/>
     * The Croatian ID card has width of 85mm and height of 54mm. If we take a ruler and measure
     * the locations of address field, we get the following measurements:
     * <p/>
     * on old croatian ID card, last name is located in following rectangle:
     * left = 23 mm
     * right = 50 mm
     * top = 11 mm
     * bottom = 17 mm
     * <p/>
     * {@link DecodingInfo} requires converting this into relative coordinates, so we
     * get the following:
     * <p/>
     * x = 23mm / 85mm = 0.271
     * y = 11mm / 54mm = 0.204
     * width = (50mm - 23mm) / 85mm = 0.318
     * height = (17mm - 11mm) / 54mm = 0.111
     * <p/>
     * on new croatian ID card, last name is located in following rectangle:
     * left = 23 mm
     * right = 54 mm
     * top = 11 mm
     * bottom = 20 mm
     * <p/>
     * {@link DecodingInfo} requires converting this into relative coordinates, so we
     * get the following:
     * <p/>
     * x = 23mm / 85mm = 0.271
     * y = 11mm / 54mm = 0.204
     * w = (54mm - 23mm) / 85mm = 0.365
     * h = (20mm - 11mm) / 54mm = 0.167
     * <p/>
     * In the same manner we can measure the locations of first name on both old and new ID cards.
     * <p/>
     * Both first and last name can hold a single line of text, but both on new and old ID card
     * first name is printed with smaller font than last name. Therefore, we will require that
     * dewarped image for last names will be of height 100 pixels and for first names of height 150
     * pixels.
     * The width of the image will be automatically determined to keep the original aspect ratio.
     *
     * @param settings  Settings object to which parser will be set.
     * @param oldId     list of {@link DecodingInfo} objects specific for old Croatian ID card
     * @param newId     list of {@link DecodingInfo} objects specific for new Croatian ID card
     * @param firstName indicator whether first or last name should be configured (only dewarp height
     *                  and location differs - regular expression for data extraction is the same)
     */
    private static void setupName(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId, boolean firstName) {
        /**
         * Id will be used both for parser name and parser group name. The reason for this is that only one parser
         * will be used on image obtained from required location.
         *
         * An example where multiple parsers are used on same dewarped location can be seen in method
         * @{link #setupSexCitizenshipAndDateOfBirth).
         */
        String id = firstName ? ID_FIRST_NAME : ID_LAST_NAME;

        /**
         * Since first name is printed with smaller font, the height of dewarped image containing first name
         * should be larger than height of dewarped image containing last name.
         */
        int dewarpHeight = firstName ? 150 : 100;

        /**
         * For extracting first and last names, we will use regex parser with regular expression which
         * attempts to extract as may uppercase words as possible from single line.
         */
        RegexParserSettings nameParser = new RegexParserSettings("([A-ZŠĐŽČĆ]+ ?)+");
        /**
         * tweak OCR engine options - allow only recognition of uppercase letters used in Croatia
         */
        addAllCroatianUppercaseCharsToWhitelist(nameParser.getOcrEngineOptions());

        /**
         * add parser to parser group
         */
        settings.addParserToParserGroup(id, id, nameParser);

        /**
         * setup locations of first and last name in both old and new Croatian ID card
         */
        Rectangle locationOld = firstName ? new Rectangle(0.282f, 0.333f, 0.306f, 0.167f) : new Rectangle(0.271f, 0.204f, 0.318f, 0.111f);
        Rectangle locationNew = firstName ? new Rectangle(0.282f, 0.389f, 0.353f, 0.167f) : new Rectangle(0.282f, 0.204f, 0.353f, 0.167f);

        // add locations to list
        oldId.add(new DecodingInfo(locationOld, dewarpHeight, id));
        newId.add(new DecodingInfo(locationNew, dewarpHeight, id));
    }

    /**
     * This function will setup single location containing sex, citizenship and date of birth and three parsers
     * for these three fields.
     * <p/>
     * Firstly, we need to take a ruler and measure the location from which all these fields will be extracted.
     * On old croatian ID cards, the location containing both sex, citizenship and date of birth is in following
     * rectangle:
     * <p/>
     * left = 35 mm
     * right = 57 mm
     * top = 27 mm
     * bottom = 43 mm
     * <p/>
     * {@link DecodingInfo} requires converting this into relative coordinates, so we
     * get the following:
     * <p/>
     * x = 35mm / 85mm = 0.412
     * y = 27 mm / 54mm = 0.500
     * w = (57mm - 35mm) / 85mm = 0.259
     * h = (43mm - 27mm) / 54mm = 0.296
     * <p/>
     * Similarly, on new croatian ID card, rectangle holding same information is the following:
     * <p/>
     * left = 33 mm
     * right = 57 mm
     * top = 27 mm
     * bottom = 43 mm
     * <p/>
     * {@link DecodingInfo} requires converting this into relative coordinates, so we
     * get the following:
     * <p/>
     * x = 33mm / 85mm = 0.388
     * y = 27mm / 54mm = 0.556
     * w = (57mm - 33mm) / 85mm = 0.282
     * h = (43mm - 27mm) / 54mm = 0.296
     * <p/>
     * This location contains three fields in three lines of text. So we will set the height of
     * dewarped image to 300 pixels.
     * The width of the image will be automatically determined to keep the original aspect ratio.
     *
     * @param settings Settings object to which parser will be set.
     * @param oldId    list of {@link DecodingInfo} objects specific for old Croatian ID card
     * @param newId    list of {@link DecodingInfo} objects specific for new Croatian ID card
     */
    private static void setupSexCitizenshipAndDateOfBirth(TemplatingRecognizerSettings settings, List<DecodingInfo> oldId, List<DecodingInfo> newId) {
        // first define location on both old and new Croatian IDs
        // set the name of location to ID_SEX_CITIZENSHIP_DOB
        // this will also be the name of parser group containing all parsers
        oldId.add(new DecodingInfo(new Rectangle(0.412f, 0.500f, 0.259f, 0.296f), 300, ID_SEX_CITIZENSHIP_DOB));
        newId.add(new DecodingInfo(new Rectangle(0.388f, 0.500f, 0.282f, 0.296f), 300, ID_SEX_CITIZENSHIP_DOB));

        /**
         * for parsing sex we will use regex parser configured with simple regular expression
         */
        RegexParserSettings sexParser = new RegexParserSettings("[MŽ]/[MF]");
        /**
         * add possible chars to whitelist.
         *
         * Note that since this parser will be in same parser group with other parsers,
         * final whitelist for OCR will be obtained by merging all whitelists of all
         * parsers in same parser group.
         */
        sexParser.getOcrEngineOptions().addCharToWhitelist('M', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('F', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('Ž', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('/', OcrFont.OCR_FONT_ANY);
        sexParser.setMustEndWithWhitespace(true);
        sexParser.setMustStartWithWhitespace(true);

        // this line will add sex parser to parser group: note that parser group
        // name is ID_SEX_CITIZENSHIP_DOB (same as name od DecodingInfo) and name of
        // the parser is ID_SEX
        settings.addParserToParserGroup(ID_SEX_CITIZENSHIP_DOB, ID_SEX, sexParser);

        /**
         * for parsing citizenship we will use regex parser configured with simple regular expression
         * which will be added to same parser group
         */
        RegexParserSettings citizenshipParser = new RegexParserSettings("[A-Z]{3}");
        addAllCroatianUppercaseCharsToWhitelist(citizenshipParser.getOcrEngineOptions());
        citizenshipParser.setMustEndWithWhitespace(true);
        citizenshipParser.setMustStartWithWhitespace(true);

        settings.addParserToParserGroup(ID_SEX_CITIZENSHIP_DOB, ID_CITIZENSHIP, citizenshipParser);

        /**
         * finally, we will add date parser to same parser group.
         */
        settings.addParserToParserGroup(ID_SEX_CITIZENSHIP_DOB, ID_DATE_OF_BIRTH, new DateParserSettings());

        /**
         * So, all parsers in parser group ID_SEX_CITIZENSHIP_DOB will be run on OCR result obtained
         * from image taken from location defined by decoding info of the same name
         */
    }

    /**
     * This function will show how to setup scanning of document number from {@link DecodingInfo} objects
     * inherent to detector set with {@link BlinkOCRRecognizerSettings#setDetectorSettings(DetectorSettings)}.
     * <p/>
     * First, we will add two possible locations of document number - one location on old Croatian IDs
     * and one location on new Croatian IDs. After that when card-like document will be detected,
     * both locations will be dewarped and OCR and data extraction will be performed. After that,
     * only one parser will succeed in parsing document number - either one on location for old
     * Croatian ID or one on location for new Croatian ID. This information will then be used
     * in {@link CroFrontIdClassifier} to determine whether the scanned document is old or new
     * Croatian ID and appropriate array of {@link DecodingInfo} objects can then be used
     * to extract other data as set up in functions {@link #setupName(TemplatingRecognizerSettings, List, List, boolean)}
     * and {@link #setupSexCitizenshipAndDateOfBirth(TemplatingRecognizerSettings, List, List)}.
     *
     * @param settings      Settings object to which parser will be set.
     * @param decodingInfos List of {@link DecodingInfo} objects inherent to the detector.
     */
    private static void setupDocumentNumber(TemplatingRecognizerSettings settings, List<DecodingInfo> decodingInfos) {
        /**
         * First define locations of document number on both old and new Croatian ID cards. Make sure you use different
         * names to later be able to distinguish which location produced result and which did not.
         */
        decodingInfos.add(new DecodingInfo(new Rectangle(0.047f, 0.519f, 0.224f, 0.111f), 150, ID_DOCUMENT_NUMBER_OLD));
        decodingInfos.add(new DecodingInfo(new Rectangle(0.047f, 0.685f, 0.224f, 0.111f), 150, ID_DOCUMENT_NUMBER_NEW));

        /**
         * Document number on Croatian ID is 9-digit number. We will extract that with simple
         * regex parser which only allows digits in OCR engine settings.
         */
        RegexParserSettings documentNumberParser = new RegexParserSettings("\\d{9}");
        documentNumberParser.getOcrEngineOptions().addAllDigitsToWhitelist(OcrFont.OCR_FONT_ANY);
        documentNumberParser.getOcrEngineOptions().setMinimumCharHeight(35);

        /**
         * It is important to add that parser to both parser groups associated with both decoding infos set above.
         */
        settings.addParserToParserGroup(ID_DOCUMENT_NUMBER_OLD, ID_DOCUMENT_NUMBER, documentNumberParser);
        settings.addParserToParserGroup(ID_DOCUMENT_NUMBER_NEW, ID_DOCUMENT_NUMBER, documentNumberParser);
    }

    /**
     * This method shows how {@link BlinkOCRRecognizerSettings} can be set up to scan front side of
     * Croatian ID cards. At first, parser groups for first and last name and other data (sex, citizenship,
     * date of birth) are created, together with associated parsers (see {@link com.microblink.recognizers.blinkocr.parser.OcrParserSettings})
     * and {@link DecodingInfo} objects specific for old and new Croatian ID cards.
     * Next, a list of {@link DecodingInfo} objects inherent to detector will be prepared and detector
     * which can detect credit card sized documents will be set to be used. Finally, a {@link DocumentClassifier}
     * will be implemented which will determine which version of Croatian ID document is being scanned.
     *
     * @return set-up {@link BlinkOCRRecognizerSettings} object which can scan front side of Croatian ID cards
     */
    public static BlinkOCRRecognizerSettings buildCroatianIDFrontSideRecognizerSettings() {
        // settings object which will be set up
        BlinkOCRRecognizerSettings settings = new BlinkOCRRecognizerSettings();

        // list of decoding info objects for old Croatian ID
        List<DecodingInfo> oldIdDecodingInfos = new ArrayList<>();
        // list of decoding info objects for new Croatian ID
        List<DecodingInfo> newIdDecodingInfos = new ArrayList<>();
        // list of decoding info objects inherent to detector and used for
        // parsing document number and ID type classification
        /**
         * NOTE: if you do not need document classification in your use case,
         *       you only need to set decoding info objects inherent to
         *       detector you will be using. Locations from these objects
         *       are always analysed, while locations set with
         *       #setParserDecodingInfos(DecodingInfo[], String) are only used
         *       after DocumentClassifier returns the same string.
         */
        List<DecodingInfo> classificationDecodingInfos = new ArrayList<>();

        // call methods for setting up locations and parsers for all fields
        setupName(settings, oldIdDecodingInfos, newIdDecodingInfos, false);
        setupName(settings, oldIdDecodingInfos, newIdDecodingInfos, true);
        setupSexCitizenshipAndDateOfBirth(settings, oldIdDecodingInfos, newIdDecodingInfos);
        setupDocumentNumber(settings, classificationDecodingInfos);

        // setup card detector
        DocumentSpecification idSpec = DocumentSpecification.createFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD);
        // set decoding info objects inherent to this document specification
        idSpec.setDecodingInfos(TemplatingUtils.listToArray(classificationDecodingInfos));
        // create card detector with single document specification
        DocumentDetectorSettings dds = new DocumentDetectorSettings(new DocumentSpecification[]{idSpec});

        // ensure this detector will be used when performing object detection
        settings.setDetectorSettings(dds);

        // set classifier which will analyse recognition result obtained from decoding locations
        // inherent to detector (set above) and return either string CLASS_OLD_ID or string CLASS_NEW_ID,
        // depending on whether it has identified old or new Croatian ID.
        settings.setDocumentClassifier(new CroFrontIdClassifier());
        // set decoding info classes
        // After document classification is performed, only one array of decoding info objects will
        // be used to extract information like first and last name etc.
        settings.setParserDecodingInfos(TemplatingUtils.listToArray(oldIdDecodingInfos), CLASS_OLD_ID);
        settings.setParserDecodingInfos(TemplatingUtils.listToArray(newIdDecodingInfos), CLASS_NEW_ID);

        /**
         * If detector which cannot determine orientation is used, like in this case*, allow
         * flipped recognition. This will ensure that after detection has been performed and nothing
         * was extracted from any of the decoding locations inherent to the detector, the detection
         * will be flipped and process will be repeated. This is slower, but enables scanning of
         * Croatian IDs which are held upside down.
         *
         * * DocumentDetector performs detection based on document edges. Since documents are symmetric,
         *   it cannot know the correct orientation of the text. Some other detectors, like
         *   MRTDDetector, have the ability to know the correct orientation of the text on document.
         */
        settings.setAllowFlippedRecognition(true);

        return settings;
    }

    /**
     * This class implements {@link DocumentClassifier} interface. In its {@link #classifyDocument(BlinkOCRRecognitionResult)}
     * method it must decide from {@link BlinkOCRRecognitionResult} containing data extracted from
     * locations defined with {@link DecodingInfo} objects inherent to detector used whether document
     * being scanned is old or new Croatian ID. If document cannot be classified, empty string or
     * null can be returned.
     */
    private static class CroFrontIdClassifier implements DocumentClassifier {

        @Override
        public String classifyDocument(BlinkOCRRecognitionResult extractionResult) {
            // we first check if document number parser has succeeded in
            // parsing document number from location on old Croatian ID (Decoding Info object with
            // name ID_DOCUMENT_NUMBER_OLD defined in method setupDocumentNumber above).
            String documentNumber = extractionResult.getParsedResult(ID_DOCUMENT_NUMBER_OLD, ID_DOCUMENT_NUMBER);
            if (documentNumber != null && !"".equals(documentNumber)) {
                // if document number has been successfully parsed from location unique to old
                // Croatian ID, then classify the document as old Croatian ID
                return CLASS_OLD_ID;
            }
            // if document number was not parsed from location unique to old ID, let's check if
            // it has been parsed on location unique to new ID
            documentNumber = extractionResult.getParsedResult(ID_DOCUMENT_NUMBER_NEW, ID_DOCUMENT_NUMBER);
            if (documentNumber != null && !"".equals(documentNumber)) {
                // if document number has been successfully parsed from location unique to new
                // Croatian ID, then classify the document as new Croatian ID
                return CLASS_NEW_ID;
            }
            // if this line is reached, then classifier cannot correctly classify the document
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

        /**
         * {@link DocumentClassifier} interface extends {@link android.os.Parcelable} so it can
         * be sent via Intent inside {@link BlinkOCRRecognizerSettings}. In order to be able to
         * extract the classifier from {@link Parcel}, {@link #CREATOR} field must be defined.
         */
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
