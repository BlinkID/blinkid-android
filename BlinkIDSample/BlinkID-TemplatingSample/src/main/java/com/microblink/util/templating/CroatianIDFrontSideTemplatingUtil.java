package com.microblink.util.templating;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.microblink.entities.detectors.quad.document.DocumentDetector;
import com.microblink.entities.detectors.quad.document.DocumentSpecification;
import com.microblink.entities.detectors.quad.document.DocumentSpecificationPreset;
import com.microblink.entities.ocrengine.legacy.BlinkOCREngineOptions;
import com.microblink.entities.parsers.Parser;
import com.microblink.entities.parsers.date.DateParser;
import com.microblink.entities.parsers.regex.RegexParser;
import com.microblink.entities.processors.imageReturn.ImageReturnProcessor;
import com.microblink.entities.processors.parserGroup.ParserGroupProcessor;
import com.microblink.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.entities.recognizers.templating.ProcessorGroup;
import com.microblink.entities.recognizers.templating.TemplatingClass;
import com.microblink.entities.recognizers.templating.TemplatingClassifier;
import com.microblink.entities.recognizers.templating.dewarpPolicies.DPIBasedDewarpPolicy;
import com.microblink.entities.recognizers.templating.dewarpPolicies.FixedDewarpPolicy;
import com.microblink.entities.recognizers.templating.parcelization.ParserParcelization;
import com.microblink.geometry.Rectangle;
import com.microblink.results.ocr.OcrFont;

/**
 * An example how Templating API can be used to add support for scanning custom document.
 * This example shows how to use Templating API to scan front side of Croatian National ID card.
 */
public final class CroatianIDFrontSideTemplatingUtil {

    /**
     * Constructor will configure all components required to add support for scanning front side
     * of Croatian National ID card.
     */
    public CroatianIDFrontSideTemplatingUtil() {

        // first, configure parsers that will extract OCR results
        configureParsers();

        // second, group configured parsers into ParserGroupProcessors and also
        // add ImageReturnProcessors that will obtain images
        configureProcessors();

        // third, group processors into processor groups and define relative locations within
        // document for each processor group to work on
        configureProcessorGroups();

        // fourth, group processor groups into document classes and for each class define a classifier
        // that will determine whether document belongs to this class or not
        configureClasses();

        // finally, create document detector and associate it DetectorRecognizer. Also, associate
        // document classes with the same DetectorRecognizer.
        configureDetectorRecognizer();
    }

    /**
     * @return the {@link DetectorRecognizer} configured for scanning front side of Croatian National ID card.
     */
    public DetectorRecognizer getDetectorRecognizer() {
        return mDetectorRecognizer;
    }

    public RegexParser getFirstNameParser() {
        return mFirstNameParser;
    }

    public RegexParser getLastNameParser() {
        return mLastNameParser;
    }

    public RegexParser getSexParser() {
        return mSexParser;
    }

    public RegexParser getCitizenshipParser() {
        return mCitizenshipParser;
    }

    public DateParser getDateOfBirthParser() {
        return mDateOfBirthParser;
    }

    public RegexParser getOldDocumentNumberParser() {
        return mOldDocumentNumberParser;
    }

    public RegexParser getNewDocumentNumberParser() {
        return mNewDocumentNumberParser;
    }

    public ImageReturnProcessor getFullDocumentImage() {
        return mFullDocumentImage;
    }

    public ImageReturnProcessor getFaceImage() {
        return mFaceImage;
    }

    /**
     * This function fill configure parsers for parsing data from OCR.
     */
    private void configureParsers() {

        //------------------------------------------------------------------------------------------
        // First and Last name
        //------------------------------------------------------------------------------------------

        // For extracting first names, we will use regex parser with regular expression which
        // attempts to extract as may uppercase words as possible from single line.
        mFirstNameParser = new RegexParser("([A-ZŠĐŽČĆ]+ ?)+");

        // tweak OCR engine options - allow only recognition of uppercase letters used in Croatia
        CroatianIDRecognizerUtils.addAllCroatianUppercaseCharsToWhitelist((BlinkOCREngineOptions) mFirstNameParser.getOcrEngineOptions());

        // For extracting last names, use same rules as for first names. It is easiest to simply
        // clone the name parser.
        mLastNameParser = mFirstNameParser.clone();

        //------------------------------------------------------------------------------------------
        // Sex parser
        //------------------------------------------------------------------------------------------

        // for parsing sex we will use regex parser configured with simple regular expression
        mSexParser = new RegexParser("[MŽ]/[MF]");

        // add possible chars to whitelist.
        ((BlinkOCREngineOptions)mSexParser.getOcrEngineOptions())
                .addCharToWhitelist('M', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('F', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('Ž', OcrFont.OCR_FONT_ANY)
                .addCharToWhitelist('/', OcrFont.OCR_FONT_ANY);
        mSexParser.setMustEndWithWhitespace(true);
        mSexParser.setMustStartWithWhitespace(true);

        //------------------------------------------------------------------------------------------
        // Citizenship parser
        //------------------------------------------------------------------------------------------

        // for parsing citizenship we will use regex parser configured with simple regular expression
        mCitizenshipParser = new RegexParser("[A-Z]{3}");
        CroatianIDRecognizerUtils.addAllCroatianUppercaseCharsToWhitelist((BlinkOCREngineOptions)mCitizenshipParser.getOcrEngineOptions());
        mCitizenshipParser.setMustEndWithWhitespace(true);
        mCitizenshipParser.setMustStartWithWhitespace(true);

        //------------------------------------------------------------------------------------------
        // Document number parser
        //------------------------------------------------------------------------------------------

        // Document number on Croatian ID is 9-digit number. We will extract that with simple
        // regex parser which only allows digits in OCR engine settings.
        mOldDocumentNumberParser = new RegexParser("\\d{9}");
        ((BlinkOCREngineOptions)mOldDocumentNumberParser.getOcrEngineOptions()).addAllDigitsToWhitelist(


                OcrFont.OCR_FONT_ANY);
        mOldDocumentNumberParser.getOcrEngineOptions().setMinimumCharHeight(35);

        // We need two document number parsers - one for old document version and another for new
        // version. We will put them in different parser group processors in different processing
        // locations and their results will help us determine whether we are scanning old or new
        // version of ID.
        // We can simply clone the document number parser.
        mNewDocumentNumberParser = mOldDocumentNumberParser.clone();

        //------------------------------------------------------------------------------------------
        // Date of birth parser
        //------------------------------------------------------------------------------------------

        // date of birth parser will be a simple date parser that accepts any date format
        mDateOfBirthParser = new DateParser();
    }

    /**
     * This function will configure processors that will be used on different processing locations.
     */
    private void configureProcessors() {

        // put first name parser in its own parser group
        mFirstNameParserGroup = new ParserGroupProcessor(mFirstNameParser);

        // also do the same for last name parser
        mLastNameParserGroup = new ParserGroupProcessor(mLastNameParser);

        // sex, citizenship and date of birth can be in same group
        mSexCitizenshipDOBGroup = new ParserGroupProcessor(mSexParser, mCitizenshipParser, mDateOfBirthParser);

        // document number group for old and new IDs
        mOldDocumentNumberGroup = new ParserGroupProcessor(mOldDocumentNumberParser);
        mNewDocumentNumberGroup = new ParserGroupProcessor(mNewDocumentNumberParser);

        // also create ImageReturnProcessors that will simply save the image that comes for processing
        mFullDocumentImage = new ImageReturnProcessor();
        mFaceImage = new ImageReturnProcessor();
    }

    /**
     * This function will configure processor groups for each processing location in old and new
     * version of front side of Croatian ID cards.
     */
    private void configureProcessorGroups() {

        //------------------------------------------------------------------------------------------
        // First and Last name
        //------------------------------------------------------------------------------------------
        //
        // The Croatian ID card has width of 85mm and height of 54mm. If we take a ruler and measure
        // the locations of address field, we get the following measurements:
        //
        // on old croatian ID card, last name is located in following rectangle:
        //
        // left = 23 mm
        // right = 50 mm
        // top = 11 mm
        // bottom = 17 mm
        //
        // ProcessorGroup requires converting this into relative coordinates, so we
        // get the following:
        //
        // x = 23mm / 85mm = 0.271
        // y = 11mm / 54mm = 0.204
        // width = (50mm - 23mm) / 85mm = 0.318
        // height = (17mm - 11mm) / 54mm = 0.111
        //
        // on new croatian ID card, last name is located in following rectangle:
        //
        // left = 23 mm
        // right = 54 mm
        // top = 11 mm
        // bottom = 20 mm
        //
        // ProcessorGroup requires converting this into relative coordinates, so we
        // get the following:
        //
        // x = 23mm / 85mm = 0.271
        // y = 11mm / 54mm = 0.204
        // w = (54mm - 23mm) / 85mm = 0.365
        // h = (20mm - 11mm) / 54mm = 0.167
        //
        // In the same manner we can measure the locations of first name on both old and new ID cards.
        //
        // Both first and last name can hold a single line of text, but both on new and old ID card
        // first name is printed with smaller font than last name. Therefore, we will require that
        // dewarped image for last names will be of height 100 pixels and for first names of height 150
        // pixels.
        // The width of the image will be automatically determined to keep the original aspect ratio.
        //------------------------------------------------------------------------------------------

        mFirstNameOldID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.282f, 0.333f, 0.306f, 0.167f),
                // dewarp height as described above will be achieved using fixed dewarp policy
                new FixedDewarpPolicy(150),
                // processors in this processor group
                mFirstNameParserGroup
        );

        mFirstNameNewID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.282f, 0.389f, 0.353f, 0.167f),
                // dewarp height as described above will be achieved using fixed dewarp policy
                new FixedDewarpPolicy(150),
                // processors in this processor group. Note that same processor can be in multiple
                // processor groups
                mFirstNameParserGroup
        );

        mLastNameOldID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.271f, 0.204f, 0.318f, 0.111f),
                // dewarp height as described above will be achieved using fixed dewarp policy
                new FixedDewarpPolicy(100),
                // processors in this processor group
                mLastNameParserGroup
        );

        mLastNameNewID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.282f, 0.204f, 0.353f, 0.167f),
                // dewarp height as described above will be achieved using fixed dewarp policy
                new FixedDewarpPolicy(100),
                // processors in this processor group. Note that same processor can be in multiple
                // processor groups
                mLastNameParserGroup
        );

        //------------------------------------------------------------------------------------------
        // Sex, citizenship and date of birth
        //------------------------------------------------------------------------------------------
        // Sex, citizenship and date of birth parsers are bundled together into single parser group
        // processor. Now let's define a processor group for new and old ID version for that
        // processor.
        //
        // Firstly, we need to take a ruler and measure the location from which all these fields
        // will be extracted.
        // On old croatian ID cards, the location containing both sex, citizenship and date of birth
        // is in following rectangle:
        //
        // left = 35 mm
        // right = 57 mm
        // top = 27 mm
        // bottom = 43 mm
        //
        // ProcessorGroup requires converting this into relative coordinates, so we
        // get the following:
        //
        // x = 35mm / 85mm = 0.412
        // y = 27 mm / 54mm = 0.500
        // w = (57mm - 35mm) / 85mm = 0.259
        // h = (43mm - 27mm) / 54mm = 0.296
        //
        // Similarly, on new croatian ID card, rectangle holding same information is the following:
        //
        // left = 33 mm
        // right = 57 mm
        // top = 27 mm
        // bottom = 43 mm
        //
        // ProcessorGroup requires converting this into relative coordinates, so we
        // get the following:
        //
        // x = 33mm / 85mm = 0.388
        // y = 27mm / 54mm = 0.556
        // w = (57mm - 33mm) / 85mm = 0.282
        // h = (43mm - 27mm) / 54mm = 0.296
        //
        // This location contains three fields in three lines of text. So we will set the height of
        // dewarped image to 300 pixels.
        // The width of the image will be automatically determined to keep the original aspect ratio.
        //------------------------------------------------------------------------------------------

        mSexCitizenshipDOBOldID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.412f, 0.500f, 0.259f, 0.296f),
                // fixed dewarp policy to get dewarp height of exactly 300 pixels
                new FixedDewarpPolicy(300),
                // processors in this processor group
                mSexCitizenshipDOBGroup
        );

        mSexCitizenshipDOBNewID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.388f, 0.500f, 0.282f, 0.296f),
                // fixed dewarp policy to get dewarp height of exactly 300 pixels
                new FixedDewarpPolicy(300),
                // processors in this processor group
                mSexCitizenshipDOBGroup
        );

        //------------------------------------------------------------------------------------------
        // Document number
        //------------------------------------------------------------------------------------------
        // In same way as above, we create ProcessorGroup for old and new versions of document number
        // parsers.
        //------------------------------------------------------------------------------------------

        mDocumentNumberOldID = new ProcessorGroup(
                new Rectangle(0.047f, 0.519f, 0.224f, 0.111f),
                new FixedDewarpPolicy(150),
                mOldDocumentNumberGroup
        );

        mDocumentNumberNewID = new ProcessorGroup(
                new Rectangle(0.047f, 0.685f, 0.224f, 0.111f),
                new FixedDewarpPolicy(150),
                mNewDocumentNumberGroup
        );

        //------------------------------------------------------------------------------------------
        // Face image
        //------------------------------------------------------------------------------------------
        // In same way as above, we create ProcessorGroup for image of the face on document.
        //------------------------------------------------------------------------------------------

        mFaceOldID = new ProcessorGroup(
                new Rectangle( 0.650f, 0.277f, 0.270f, 0.630f ),
                // use DPI-based policy to ensure images of 200 DPI
                new DPIBasedDewarpPolicy(200),
                mFaceImage
        );

        mFaceNewID = new ProcessorGroup(
                new Rectangle( 0.659f, 0.407f, 0.294f, 0.574f),
                // use DPI-based policy to ensure images of 200 DPI
                new DPIBasedDewarpPolicy(200),
                mFaceImage
        );

        //------------------------------------------------------------------------------------------
        // Full document image
        //------------------------------------------------------------------------------------------
        // location of full document is same regardless of document version
        //------------------------------------------------------------------------------------------

        mFullDocument = new ProcessorGroup(
                new Rectangle(0.f, 0.f, 1.f, 1.f),
                new DPIBasedDewarpPolicy(200),
                mFullDocumentImage
        );
    }

    /**
     * This function will configure classes for old and new version of the document and classifiers
     * for each class.
     */
    private void configureClasses() {
        // configure old version class
        {
            mOldID = new TemplatingClass();
            mOldID.setTemplatingClassifier(new CroIDTemplatingClassifier(mOldID, mOldDocumentNumberParser));

            mOldID.setClassificationProcessorGroups(mDocumentNumberOldID);
            mOldID.setNonClassificationProcessorGroups(mFirstNameOldID, mLastNameOldID, mSexCitizenshipDOBOldID, mFaceOldID, mFullDocument);
        }
        // configure new version class
        {
            mNewID = new TemplatingClass();
            mNewID.setTemplatingClassifier(new CroIDTemplatingClassifier(mNewID, mNewDocumentNumberParser));

            mNewID.setClassificationProcessorGroups(mDocumentNumberNewID);
            mNewID.setNonClassificationProcessorGroups(mFirstNameNewID, mLastNameNewID, mSexCitizenshipDOBNewID, mFaceNewID, mFullDocument);
        }
    }

    /**
     * This functions configures DetectorRecognizer with DocumentDetector that will detect ID card
     * and associates templating classes for old and new version of ID card with it.
     */
    private void configureDetectorRecognizer() {
        mDocumentDetector = new DocumentDetector(
                DocumentSpecification.createFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD));

        mDetectorRecognizer = new DetectorRecognizer(mDocumentDetector);
        mDetectorRecognizer.setTemplatingClasses(mOldID, mNewID);

        /*
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
        mDetectorRecognizer.setAllowFlippedRecognition( true );
    }

    /**
     * This class represents a {@link TemplatingClassifier} which determines whether the currently
     * scanned Croatian ID document belongs to the associated class (old or new version of the ID
     * document). The class also must implement {@link android.os.Parcelable}
     * interface in order to support passing it through {@link Parcel}.
     */
    private static final class CroIDTemplatingClassifier implements TemplatingClassifier {

        private TemplatingClass mMyTemplatingClass;
        /** Document number parser which is used for classification. */
        private RegexParser mDocumentNumberParser;
        private ParserParcelization mParcelizedDocumentNumberParser;

        /**
         * Constructor which accepts classifier class and parser used for classification.
         * @param myTemplatingClass associated templating class for which the classifier is responsible.
         * @param documentNumberParser parser whose data is used for the classification.
         */
        CroIDTemplatingClassifier(@NonNull TemplatingClass myTemplatingClass, @Nullable RegexParser documentNumberParser) {
            mMyTemplatingClass = myTemplatingClass;
            mDocumentNumberParser = documentNumberParser;
        }

        @Override
        public boolean classify(@NonNull TemplatingClass currentClass) {
            RegexParser documentNumberParser;

            if ( mMyTemplatingClass == currentClass ) {
                // if captured templating class is the same reference as currentClass, this means
                // that we are still using the original instance of the classifier, which has access
                // to original document number parser

                documentNumberParser = mDocumentNumberParser;
            } else {
                // if references are not the same, this means that classifier has been parcelized
                // and then de-parcelized during transmission to another activity. We need to ensure
                // that we perform the check of the document number parser's result within the
                // context we are currently running, so we need to utilize ParserParcelization
                // obtained during creating from Parcel to obtain access to correct parser.
                // For more information, see implementation note in writeToParcel below.
                documentNumberParser = mParcelizedDocumentNumberParser.getParser(currentClass);
            }

            // if document number parser has succeeded in parsing the document number, then
            // we are certain we are scanning the version (class) of Croatian National ID card
            // for which this classifier instance is responsible
            return documentNumberParser.getResult().getResultState() == Parser.Result.State.Valid;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            //--------------------------------------------------------------------------------------
            // IMPLEMENTATION NOTE:
            //--------------------------------------------------------------------------------------
            // If we write mMyTemplatingClass to dest, we will trigger StackOverflowException because
            // this classifier is contained within mMyTemplatingClass, so writeToParcel will be called
            // recursively.
            // If we write mDocumentNumberParser to dest, it will be OK, but the problem will be
            // on deserialization side - the deparcelized instance of the parser will not be the same
            // as the one actually used for recognition and therefore it will not be possible to use
            // it for classification.
            //
            // To address this problem, we will create a ParserParcelization instance around our
            // parser and class. The ParcelParcelization will simply find our parser withing given
            // Templating Class and remember its coordinates. This coordinates will then be written
            // to dest and restored when creating this object from Parcel. Finally, those coordinates
            // will then be used to obtain access to same parser within the context of recognition.
            //--------------------------------------------------------------------------------------

            ParserParcelization documentNumberParcelization = new ParserParcelization(mDocumentNumberParser, mMyTemplatingClass);
            // we do not need to use writeParcelable because ParserParcelization is not polymorphic
            documentNumberParcelization.writeToParcel(dest, flags);
        }

        /**
         * Constructor from {@link Parcel}
         * @param in Parcel containing serialized classifier.
         */
        private CroIDTemplatingClassifier(Parcel in ) {
            mParcelizedDocumentNumberParser = ParserParcelization.CREATOR.createFromParcel(in);
        }

        public static final Creator<CroIDTemplatingClassifier> CREATOR = new Creator<CroIDTemplatingClassifier>() {
            @Override
            public CroIDTemplatingClassifier createFromParcel(Parcel source) {
                return new CroIDTemplatingClassifier(source);
            }

            @Override
            public CroIDTemplatingClassifier[] newArray(int size) {
                return new CroIDTemplatingClassifier[size];
            }
        };
    }


    //----------------------------------------------------------------------------------------------
    // Detector recognizer
    //----------------------------------------------------------------------------------------------

    private DetectorRecognizer mDetectorRecognizer;

    //----------------------------------------------------------------------------------------------
    // Document detector
    //----------------------------------------------------------------------------------------------

    private DocumentDetector mDocumentDetector;

    //----------------------------------------------------------------------------------------------
    // Templating classes
    //----------------------------------------------------------------------------------------------

    private TemplatingClass mOldID;
    private TemplatingClass mNewID;

    //----------------------------------------------------------------------------------------------
    // Processor groups - old ID
    //----------------------------------------------------------------------------------------------

    private ProcessorGroup mFirstNameOldID;
    private ProcessorGroup mLastNameOldID;
    private ProcessorGroup mSexCitizenshipDOBOldID;
    private ProcessorGroup mDocumentNumberOldID;
    private ProcessorGroup mFaceOldID;

    //----------------------------------------------------------------------------------------------
    // Processor groups - new ID
    //----------------------------------------------------------------------------------------------

    private ProcessorGroup mFirstNameNewID;
    private ProcessorGroup mLastNameNewID;
    private ProcessorGroup mSexCitizenshipDOBNewID;
    private ProcessorGroup mDocumentNumberNewID;
    private ProcessorGroup mFaceNewID;

    //----------------------------------------------------------------------------------------------
    // Processor groups - both IDs
    //----------------------------------------------------------------------------------------------

    private ProcessorGroup mFullDocument;

    //----------------------------------------------------------------------------------------------
    // Processors
    //----------------------------------------------------------------------------------------------

    private ParserGroupProcessor mFirstNameParserGroup;
    private ParserGroupProcessor mLastNameParserGroup;
    private ParserGroupProcessor mSexCitizenshipDOBGroup;
    private ImageReturnProcessor mFullDocumentImage;
    private ImageReturnProcessor mFaceImage;

    // two groups because we have two classification parsers
    private ParserGroupProcessor mOldDocumentNumberGroup;
    private ParserGroupProcessor mNewDocumentNumberGroup;

    //----------------------------------------------------------------------------------------------
    // Data parsers
    //----------------------------------------------------------------------------------------------

    private RegexParser mFirstNameParser;
    private RegexParser mLastNameParser;
    private RegexParser mSexParser;
    private RegexParser mCitizenshipParser;
    private DateParser mDateOfBirthParser;

    //----------------------------------------------------------------------------------------------
    // Classification parsers
    //----------------------------------------------------------------------------------------------

    private RegexParser mOldDocumentNumberParser;
    private RegexParser mNewDocumentNumberParser;
}
