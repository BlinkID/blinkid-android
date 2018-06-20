package com.microblink.util.templating;

import android.os.Parcel;
import android.support.annotation.NonNull;

import com.microblink.entities.ocrengine.legacy.BlinkOCREngineOptions;
import com.microblink.entities.parsers.date.DateParser;
import com.microblink.entities.parsers.regex.RegexParser;
import com.microblink.entities.processors.parserGroup.ParserGroupProcessor;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzFilter;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.entities.recognizers.templating.ProcessorGroup;
import com.microblink.entities.recognizers.templating.TemplatingClass;
import com.microblink.entities.recognizers.templating.TemplatingClassifier;
import com.microblink.entities.recognizers.templating.dewarpPolicies.FixedDewarpPolicy;
import com.microblink.geometry.Rectangle;
import com.microblink.results.ocr.OcrFont;

/**
 * An example how Templating API can be used to add support for scanning custom document with
 * machine readable zone (MRZ).
 * This example shows how to use Templating API to scan back side of Croatian National ID card.
 */
public final class CroatianIDBackSideTemplatingUtil {

    /**
     * Constructor will configure all components required to add support for scanning back side
     * of Croatian National ID card.
     */
    public CroatianIDBackSideTemplatingUtil() {

        // first, configure parsers that will extract OCR results outside Machine Readable Zone
        configureParsers();

        // second, group configured parsers into ParserGroupProcessors
        configureProcessors();

        // third, group processors into processor groups and define relative locations within
        // document for each processor group to work on
        configureProcessorGroups();

        // fourth, group processor groups into document classes and for each class define a classifier
        // that will determine whether document belongs to this class or not
        configureClasses();

        // finally, create MRTDRecognizer and associate document classes with it.
        configureMRTDRecognizer();
    }

    /**
     * @return the {@link MrtdRecognizer} configured for scanning back side of Croatian National ID card
     */
    public MrtdRecognizer getMRTDRecognizer() {
        return mMRTDRecognizer;
    }


    public RegexParser getAddressParser() {
        return mAddressParser;
    }

    public RegexParser getIssuedByParser() {
        return mIssuedByParser;
    }

    public DateParser getDateOfIssueParser() {
        return mDateOfIssueParser;
    }

    /**
     * This function fill configure parsers for parsing data from OCR outside of Machine Readable Zone.
     */
    private void configureParsers() {

        //------------------------------------------------------------------------------------------
        // Address
        //------------------------------------------------------------------------------------------

        /*
         * For parsing address, we will use regex parser which expects one or more words in first line (the name of city),
         * and one or more words and a number in second line (street name and number).
         */
        mAddressParser = new RegexParser("([A-ZŠĐŽČĆ]+,? ?)+\n([A-ZŠĐŽČĆ]+ ?)+\\d+");
        /*
         * To ensure optimal OCR results, we will allow only uppercase letters and digits in OCR. Thus, OCR
         * will not return lowercase letters, reducing the possibility of misreads.
         */
        CroatianIDRecognizerUtils.addAllCroatianUppercaseCharsToWhitelist((BlinkOCREngineOptions) mAddressParser.getOcrEngineOptions());
        ((BlinkOCREngineOptions)mAddressParser.getOcrEngineOptions()).addAllDigitsToWhitelist(OcrFont.OCR_FONT_ANY);
        mAddressParser.getOcrEngineOptions().setColorDropoutEnabled(false);
        ((BlinkOCREngineOptions)mAddressParser.getOcrEngineOptions()).setMinimumCharHeight(35);

        //------------------------------------------------------------------------------------------
        // Issued by
        //------------------------------------------------------------------------------------------

        /*
         * Similarly, we will use Regex parser for parsing "issued by" field.
         */
        mIssuedByParser = new RegexParser("P[PU] ([A-ZŠĐŽČĆ]+ ?)+");
        CroatianIDRecognizerUtils.addAllCroatianUppercaseCharsToWhitelist((BlinkOCREngineOptions)mIssuedByParser.getOcrEngineOptions());
        mIssuedByParser.getOcrEngineOptions().setColorDropoutEnabled(false);
        ((BlinkOCREngineOptions)mIssuedByParser.getOcrEngineOptions()).setMinimumCharHeight(20);

        //------------------------------------------------------------------------------------------
        // Date of issue
        //------------------------------------------------------------------------------------------

        /*
         * For parsing date of issue, we will use DateParser.
         */
        mDateOfIssueParser = new DateParser();
    }

    /**
     * This function will configure processors that will be used on different processing locations.
     */
    private void configureProcessors() {
        // we will put each parser into its own parser group processor
        mAddressParserGroup = new ParserGroupProcessor(mAddressParser);
        mIssuedByParserGroup = new ParserGroupProcessor(mIssuedByParser);
        mDateOfIssueParserGroup = new ParserGroupProcessor(mDateOfIssueParser);
    }

    /**
     * This function will configure processor groups for each processing location in old and new
     * version of back side of Croatian ID cards.
     */
    private void configureProcessorGroups() {

        //------------------------------------------------------------------------------------------
        // Address
        //------------------------------------------------------------------------------------------
        // The Croatian ID card has width of 85mm and height of 54mm. If we take a ruler and measure
        // the locations of address field, we get the following measurements:
        //
        // on old croatian ID card, address field is located in following rectangle:
        //
        // left = 21 mm
        // right = 60 mm
        // top = 3 mm
        // bottom = 11 mm
        //
        // ProcessorGroup requires converting this rectangle into relative coordinates so we get
        // the following:
        //
        // x = 21mm / 85mm = 0.247
        // y = 3mm / 54mm = 0.056
        // width = (60mm - 21mm) / 85mm = 0.459
        // height = (11mm - 3mm) / 54mm = 0.148
        //
        // The address field on old croatian ID cards can hold up to two lines of text. Therefore, we
        // will require that dewarped image from this location has height of 200 pixels.
        // The width of the image will be automatically determined to keep the original aspect ratio.
        //
        // Similarly, on new croatian ID card, address field is located in following rectangle:
        //
        // left = 21 mm
        // right = 60 mm
        // top = 3 mm
        // bottom = 13 mm
        //
        // After converting this to relative coordinates, we get the following:
        //
        // x = 21mm / 8mm5 = 0.247
        // y = 3mm / 54mm = 0.056
        // width = (60mm - 21mm) / 85mm = 0.459
        // height = (13mm - 3mm) / 54mm = 0.185
        //
        // The address field on new croatian ID cards can hold up to three lines of text. Therefore, we
        // will require that dewarped image from this location has height of 300 pixels.
        // The width of the image will be automatically determined to keep the original aspect ratio.
        //------------------------------------------------------------------------------------------

        mAddressOldID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.247f, 0.056f, 0.459f, 0.148f),
                // dewarp height as described above will be achieved using fixed dewarp policy
                new FixedDewarpPolicy(200),
                // processors in this processor group
                mAddressParserGroup
        );

        mAddressNewID = new ProcessorGroup(
                // location as described above
                new Rectangle(0.247f, 0.056f, 0.459f, 0.185f),
                // dewarp height as described above will be achieved using fixed dewarp policy
                new FixedDewarpPolicy(300),
                // processors in this processor group. Note that same processor can be in multiple
                // processor groups
                mAddressParserGroup
        );

        //------------------------------------------------------------------------------------------
        // Issued by
        //------------------------------------------------------------------------------------------
        // In same way as above, we create ProcessorGroup for old and new versions of issued by
        // parsers
        //------------------------------------------------------------------------------------------

        mIssuedByOldID = new ProcessorGroup(
                new Rectangle(0.247f, 0.204f, 0.459f, 0.111f),
                new FixedDewarpPolicy(100),
                mIssuedByParserGroup
        );

        mIssuedByNewID = new ProcessorGroup(
                new Rectangle(0.247f, 0.241f, 0.459f, 0.130f),
                new FixedDewarpPolicy(100),
                mIssuedByParserGroup
        );

        //------------------------------------------------------------------------------------------
        // Date of issue
        //------------------------------------------------------------------------------------------
        // In same way as above, we create ProcessorGroup for old and new versions of date of issue
        // parsers
        //------------------------------------------------------------------------------------------

        mDateOfIssueOldID = new ProcessorGroup(
                new Rectangle(0.247f, 0.315f, 0.282f, 0.111f),
                new FixedDewarpPolicy(100),
                mDateOfIssueParserGroup
        );

        mDateOfIssueNewID = new ProcessorGroup(
                new Rectangle(0.247f, 0.370f, 0.282f, 0.093f),
                new FixedDewarpPolicy(100),
                mDateOfIssueParserGroup
        );
    }

    /**
     * This function will configure classes for old and new version of the document and classifiers
     * for each class.
     */
    private void configureClasses() {
        {
            // configure old version class
            mOldID = new TemplatingClass();
            mOldID.setTemplatingClassifier(new CroIDOldTemplatingClassifier());

            mOldID.setNonClassificationProcessorGroups(mAddressOldID, mIssuedByOldID, mDateOfIssueOldID);
        }
        {
            // configure new version class
            mNewID = new TemplatingClass();
            mNewID.setTemplatingClassifier(new CroIDNewTemplatingClassifier());

            mNewID.setNonClassificationProcessorGroups(mAddressNewID, mIssuedByNewID, mDateOfIssueNewID);
        }
    }

    /**
     * This function configures MRTDRecognizer so that it will extract both MRZ data and non-MRZ
     * data from back side of the Croatian National ID card.
     */
    private void configureMRTDRecognizer() {
        mMRTDRecognizer = new MrtdRecognizer();

        // define MRZ filter that will ensure that documents with MRZ that are not Croatian ID
        // will not be processed
        mMRTDRecognizer.setMRZFilter(new CroIDMRZFilter());

        mMRTDRecognizer.setTemplatingClasses(mOldID, mNewID);

        // allow saving full document image
        mMRTDRecognizer.setReturnFullDocumentImage(true);
        // allow saving image of the Machine Readable Zone
        mMRTDRecognizer.setReturnMrzImage(true);
        // save those images in 200 DPI
        mMRTDRecognizer.setSaveImageDPI(200);
    }

    /**
     * This class represents a {@link TemplatingClassifier} for determining whether old version of
     * Croatian ID document is being scanned. The class also must implement {@link android.os.Parcelable}
     * interface in order to support passing it through {@link Parcel}.
     */
    private static final class CroIDOldTemplatingClassifier implements TemplatingClassifier {

        @Override
        public boolean classify(@NonNull TemplatingClass currentTemplatingClass) {
            MrtdRecognizer mrtdRecognizer = currentTemplatingClass.getOwningRecognizer();
            return "<<<<<<<<<<<<<<<".equals(mrtdRecognizer.getResult().getMrzResult().getOpt1());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            // nothing to do here because classification in this particular case is based on result
            // of the MRTD recognizer that can be obtained via currentTemplatingClass parameter
            // however, if you need to perform classification based results of certain processors
            // or parsers and you are sending this classifier (as part of recognizer) via Intent
            // to another activity, then you will need to parcelize those captures here.
            //
            // For example how that is done, check CroatianIDFrontSideTemplatingRecognizer example
        }

        public static final Creator<CroIDOldTemplatingClassifier> CREATOR = new Creator<CroIDOldTemplatingClassifier>() {
            @Override
            public CroIDOldTemplatingClassifier createFromParcel(Parcel source) {
                return new CroIDOldTemplatingClassifier();
            }

            @Override
            public CroIDOldTemplatingClassifier[] newArray(int size) {
                return new CroIDOldTemplatingClassifier[size];
            }
        };
    }

    /**
     * This class represents a {@link TemplatingClassifier} for determining whether new version of
     * Croatian ID document is being scanned. The class also must implement {@link android.os.Parcelable}
     * interface in order to support passing it through {@link Parcel}.
     */
    private static final class CroIDNewTemplatingClassifier implements TemplatingClassifier {

        @Override
        public boolean classify(@NonNull TemplatingClass currentTemplatingClass) {
            MrtdRecognizer mrtdRecognizer = currentTemplatingClass.getOwningRecognizer();
            return !"<<<<<<<<<<<<<<<".equals(mrtdRecognizer.getResult().getMrzResult().getOpt1());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            // nothing to do here because classification in this particular case is based on result
            // of the MRTD recognizer that can be obtained via currentTemplatingClass parameter
            // however, if you need to perform classification based results of certain processors
            // or parsers and you are sending this classifier (as part of recognizer) via Intent
            // to another activity, then you will need to parcelize those captures here.
            //
            // For example how that is done, check CroatianIDFrontSideTemplatingRecognizer example
        }

        public static final Creator<CroIDNewTemplatingClassifier> CREATOR = new Creator<CroIDNewTemplatingClassifier>() {
            @Override
            public CroIDNewTemplatingClassifier createFromParcel(Parcel source) {
                return new CroIDNewTemplatingClassifier();
            }

            @Override
            public CroIDNewTemplatingClassifier[] newArray(int size) {
                return new CroIDNewTemplatingClassifier[size];
            }
        };
    }

    /**
     * This class represents a {@link MrzFilter} for determining whether document should be processed.
     */
    private static final class CroIDMRZFilter implements MrzFilter {

        @Override
        public boolean mrzFilter(@NonNull MrtdRecognizer mrtdRecognizer) {
            MrzResult mrzResult = mrtdRecognizer.getResult().getMrzResult();
            // continue processing only if issuer is HRV and document code is IO, i.e.
            // if we are dealing with back side of the Croatian National ID card
            return "HRV".equals(mrzResult.getIssuer()) &&
                    "IO".equals(mrzResult.getDocumentCode());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            // nothing to do here
        }

        public static final Creator<CroIDMRZFilter> CREATOR = new Creator<CroIDMRZFilter>() {
            @Override
            public CroIDMRZFilter createFromParcel(Parcel source) {
                return new CroIDMRZFilter();
            }

            @Override
            public CroIDMRZFilter[] newArray(int size) {
                return new CroIDMRZFilter[size];
            }
        };
    }

    //----------------------------------------------------------------------------------------------
    // MRTD recognizer
    //----------------------------------------------------------------------------------------------

    MrtdRecognizer mMRTDRecognizer;

    //----------------------------------------------------------------------------------------------
    // Templating classes
    //----------------------------------------------------------------------------------------------

    private TemplatingClass mOldID;
    private TemplatingClass mNewID;

    //----------------------------------------------------------------------------------------------
    // Processor groups - old ID
    //----------------------------------------------------------------------------------------------

    private ProcessorGroup mAddressOldID;
    private ProcessorGroup mIssuedByOldID;
    private ProcessorGroup mDateOfIssueOldID;

    //----------------------------------------------------------------------------------------------
    // Processor groups - new ID
    //----------------------------------------------------------------------------------------------

    private ProcessorGroup mAddressNewID;
    private ProcessorGroup mIssuedByNewID;
    private ProcessorGroup mDateOfIssueNewID;

    //----------------------------------------------------------------------------------------------
    // Processors
    //----------------------------------------------------------------------------------------------

    private ParserGroupProcessor mAddressParserGroup;
    private ParserGroupProcessor mIssuedByParserGroup;
    private ParserGroupProcessor mDateOfIssueParserGroup;

    //----------------------------------------------------------------------------------------------
    // Parsers
    //----------------------------------------------------------------------------------------------

    private RegexParser mAddressParser;
    private RegexParser mIssuedByParser;
    private DateParser  mDateOfIssueParser;

}
