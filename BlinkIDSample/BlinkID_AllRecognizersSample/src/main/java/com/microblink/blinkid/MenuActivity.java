package com.microblink.blinkid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.BaseMenuActivity;
import com.microblink.MenuListItem;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.entities.recognizers.blinkbarcode.simnumber.SimNumberRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.vin.VinRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDLBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDLFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.egypt.EgyptIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.eudl.EUDLRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyOldIDRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.indonesia.IndonesiaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.IKadRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaDLFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyTenteraRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDRecognizer;
import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDLFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognizer;
import com.microblink.recognizers.blinkid.eudl.EUDLCountry;
import com.microblink.result.ResultActivity;
import com.microblink.uisettings.ActivityRunner;
import com.microblink.uisettings.BarcodeUISettings;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.uisettings.DocumentVerificationUISettings;
import com.microblink.uisettings.UISettings;
import com.microblink.uisettings.options.ShowOcrResultMode;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends BaseMenuActivity {

    public static final int MY_BLINKID_REQUEST_CODE = 123;

    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // in case of problems with the SDK (crashes or ANRs, uncomment following line to enable
        // verbose logging that can help developers track down the problem)
        //Log.setLogLevel(Log.LogLevel.LOG_VERBOSE);

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

        items.add(buildMrtdElement());
        items.add(buildAustrianIDElement());
        items.add(buildAustrianIDCombinedElement());
        items.add(buildAustrianPassportElement());
        items.add(buildColombiaIDElement());
        items.add(buildCroatianIDElement());
        items.add(buildCroatianIDCombinedElement());
        items.add(buildCzechIDElement());
        items.add(buildCzechIDCombinedElement());
        items.add(buildEgyptIDFrontElement());
        items.add(buildGermanIDElement());
        items.add(buildGermanPassportElement());
        items.add(buildGermanIDCombinedElement());
        items.add(buildHongKongIDFrontElement());
        items.add(buildIndonesianIdElement());
        items.add(buildJordanIdElement());
        items.add(buildJordanIdCombinedElement());
        items.add(buildMyKadElement());
        items.add(buildIKadElement());
        items.add(buildMyTenteraElement());
        items.add(buildPolishIdElement());
        items.add(buildPolishIdCombinedElement());
        items.add(buildRomanianElement());
        items.add(buildSingaporeIDElement());
        items.add(buildSingaporeIDCombinedElement());
        items.add(buildSerbianIDElement());
        items.add(buildSerbianIDCombinedElement());
        items.add(buildSlovakIDElement());
        items.add(buildSlovakIDCombinedElement());
        items.add(buildSlovenianIDElement());
        items.add(buildSlovenianIDCombinedElement());
        items.add(buildSwissIDElement());
        items.add(buildSwissPassportElement());
        items.add(buildUnitedArabEmiratesIdElement());

        // DL list entries
        // TODO eudl
        //elements.add(buildAustrianDLElement());
        items.add(buildAustralianDLElement());
        items.add(buildMalaysianDLElement());
        items.add(buildNewZealandDLElement());
        //elements.add(buildGermanDLElement());
        //elements.add(buildUKDLElement());
        items.add(buildUsdlElement());
        //TODO elements.add(buildUsdlCombinedElement());

        // barcode list entries
        items.add(buildPDF417Element());
        items.add(buildBarcodeElement());
        items.add(buildSimNumberElement());
        items.add(buildVin());

        return items;
    }

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

    /**
     * This method is invoked after returning from scan activity. You can obtain scan results here
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // onActivityResult is called whenever we are returned from activity started
        // with startActivityForResult. We need to check request code to determine
        // that we have really returned from BlinkID activity.
        if (requestCode == MY_BLINKID_REQUEST_CODE) {

            // make sure BlinkID activity returned result
            if (resultCode == Activity.RESULT_OK) {
                // set intent's component to ResultActivity and pass its contents
                // to ResultActivity. ResultActivity will show how to extract data from result.
                data.setComponent(new ComponentName(this, ResultActivity.class));
                startActivity(data);
            } else {
                // if BlinkID activity did not return result, user has probably
                // pressed Back button and cancelled scanning
                Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private MenuListItem buildMrtdElement() {
        //Machine Readable Travel Document (MRTD) recognizer
        MRTDRecognizer recognizer = new MRTDRecognizer();
        // allow results with incorrect check digits, only for demo
        recognizer.setAllowUnverifiedResults(true);
        return buildMenuItem("ID document", buildDocumentScanUiSettings(recognizer));
    }

    private MenuListItem buildAustrianIDElement() {
        AustriaIDFrontSideRecognizer ausFront = new AustriaIDFrontSideRecognizer();
        AustriaIDBackSideRecognizer ausBack = new AustriaIDBackSideRecognizer();
        return buildMenuItem("Austrian ID", buildDocumentScanUiSettings(ausFront, ausBack));
    }

    private MenuListItem buildAustrianPassportElement() {
        AustriaPassportRecognizer ausPass = new AustriaPassportRecognizer();
        return buildMenuItem("Austrian Passport", buildDocumentScanUiSettings(ausPass));
    }

    private MenuListItem buildColombiaIDElement() {
        ColombiaIDFrontSideRecognizer colombiaIDFront = new ColombiaIDFrontSideRecognizer();
        ColombiaIDBackSideRecognizer colombiaIDBack = new ColombiaIDBackSideRecognizer();
        return buildMenuItem("Colombia ID", buildDocumentScanUiSettings(colombiaIDFront, colombiaIDBack));
    }

    private MenuListItem buildCroatianIDElement() {
        CroatiaIDFrontSideRecognizer croFront = new CroatiaIDFrontSideRecognizer();
        CroatiaIDBackSideRecognizer croBack = new CroatiaIDBackSideRecognizer();
        return buildMenuItem("Croatian ID", buildDocumentScanUiSettings(croFront, croBack));
    }

    private MenuListItem buildCzechIDElement() {
        CzechiaIDFrontSideRecognizer czFront = new CzechiaIDFrontSideRecognizer();
        CzechiaIDBackSideRecognizer czBack = new CzechiaIDBackSideRecognizer();
        return buildMenuItem("Czech ID", buildDocumentScanUiSettings(czFront, czBack));
    }

    private MenuListItem buildEgyptIDFrontElement() {
        EgyptIDFrontRecognizer egyptIDFront = new EgyptIDFrontRecognizer();
        return buildMenuItem("Egypt ID Front", buildDocumentScanUiSettings(egyptIDFront));
    }

    private MenuListItem buildGermanIDElement() {
        GermanyIDFrontSideRecognizer deFront = new GermanyIDFrontSideRecognizer();
        GermanyIDBackSideRecognizer deBack = new GermanyIDBackSideRecognizer();
        GermanyOldIDRecognizer deOld = new GermanyOldIDRecognizer();
        return buildMenuItem("German ID", buildDocumentScanUiSettings(deFront, deBack, deOld));
    }

    private MenuListItem buildGermanPassportElement() {
        GermanyPassportRecognizer dePassport = new GermanyPassportRecognizer();
        return buildMenuItem("German Passport", buildDocumentScanUiSettings(dePassport));
    }

    private MenuListItem buildHongKongIDFrontElement() {
        HongKongIDFrontRecognizer hongKongIDFrontRecognizer = new HongKongIDFrontRecognizer();
        return buildMenuItem("Hong Kong ID", buildDocumentScanUiSettings(hongKongIDFrontRecognizer));
    }

    private MenuListItem buildIndonesianIdElement(){
        IndonesiaIDFrontRecognizer idnFront= new IndonesiaIDFrontRecognizer();
        return buildMenuItem("Indonesian ID", buildDocumentScanUiSettings(idnFront));
    }

    private MenuListItem buildJordanIdElement(){
        JordanIDFrontRecognizer jorFront = new JordanIDFrontRecognizer();
        JordanIDBackRecognizer jorBack = new JordanIDBackRecognizer();
        return buildMenuItem("Jordan ID", buildDocumentScanUiSettings(jorFront, jorBack));
    }

    private MenuListItem buildSingaporeIDElement() {
        SingaporeIDFrontRecognizer singaporeFront = new SingaporeIDFrontRecognizer();
        SingaporeIDBackRecognizer singaporeBack = new SingaporeIDBackRecognizer();
        return buildMenuItem("Singapore ID", buildDocumentScanUiSettings(singaporeFront, singaporeBack));
    }

    private MenuListItem buildSerbianIDElement() {
        SerbiaIDFrontRecognizer serbFront = new SerbiaIDFrontRecognizer();
        SerbiaIDBackRecognizer serbBack = new SerbiaIDBackRecognizer();
        return buildMenuItem("Serbian ID", buildDocumentScanUiSettings(serbFront, serbBack));
    }

    private MenuListItem buildSlovakIDElement() {
        SlovakiaIDFrontRecognizer svkFront = new SlovakiaIDFrontRecognizer();
        SlovakiaIDBackRecognizer svkBack = new SlovakiaIDBackRecognizer();
        return buildMenuItem("Slovak ID", buildDocumentScanUiSettings(svkFront, svkBack));
    }

    private MenuListItem buildSlovenianIDElement() {
        SloveniaIDFrontRecognizer sloFront = new SloveniaIDFrontRecognizer();
        SloveniaIDBackRecognizer sloBack = new SloveniaIDBackRecognizer();
        return buildMenuItem("Slovenian ID", buildDocumentScanUiSettings(sloFront, sloBack));
    }

    private MenuListItem buildSwissPassportElement() {
        SwitzerlandPassportRecognizer swissPass = new SwitzerlandPassportRecognizer();
        return buildMenuItem("Swiss Passport", buildDocumentScanUiSettings(swissPass));
    }

    private MenuListItem buildUnitedArabEmiratesIdElement() {
        UnitedArabEmiratesIDFrontRecognizer unitedArabEmiratesIdFront = new UnitedArabEmiratesIDFrontRecognizer();
        UnitedArabEmiratesIDBackRecognizer unitedArabEmiratesIdBack = new UnitedArabEmiratesIDBackRecognizer();
        return buildMenuItem("United Arab Emirates ID", buildDocumentScanUiSettings(unitedArabEmiratesIdFront, unitedArabEmiratesIdBack));
    }

    private MenuListItem buildUKDLElement() {
        EUDLRecognizer ukdl = new EUDLRecognizer(EUDLCountry.EUDL_COUNTRY_UK);
        return buildMenuItem("UK Driver's Licence", buildDocumentScanUiSettings(ukdl));
    }

    private MenuListItem buildGermanDLElement() {
        EUDLRecognizer germanDl = new EUDLRecognizer(EUDLCountry.EUDL_COUNTRY_GERMANY);
        return buildMenuItem("German Driver's Licence", buildDocumentScanUiSettings(germanDl));
    }

    private MenuListItem buildAustrianDLElement() {
        EUDLRecognizer ausDl = new EUDLRecognizer(EUDLCountry.EUDL_COUNTRY_AUSTRIA);
        return buildMenuItem("Austrian Driver's Licence", buildDocumentScanUiSettings(ausDl));
    }

    private MenuListItem buildAustralianDLElement() {
        AustraliaDLFrontSideRecognizer ausDLFront = new AustraliaDLFrontSideRecognizer();
        AustraliaDLBackSideRecognizer ausDLBack = new AustraliaDLBackSideRecognizer();
        return buildMenuItem("Australian Driver's License", buildDocumentScanUiSettings(ausDLFront, ausDLBack));
    }

    private MenuListItem buildMalaysianDLElement() {
        MalaysiaDLFrontRecognizer malaysianDL = new MalaysiaDLFrontRecognizer();
        return buildMenuItem("Malaysian DL", buildDocumentScanUiSettings(malaysianDL));
    }

    private MenuListItem buildNewZealandDLElement(){
        NewZealandDLFrontRecognizer nzDlFront = new NewZealandDLFrontRecognizer();
        return buildMenuItem("New Zealand Driver's Licence", buildDocumentScanUiSettings(nzDlFront));
    }

    private MenuListItem buildUsdlElement() {
        USDLRecognizer usdl = new USDLRecognizer();
        return buildMenuItem("US Driver's License", buildDocumentScanUiSettings(usdl));
    }

    private MenuListItem buildMyKadElement() {
        MyKadFrontRecognizer mykadfront = new MyKadFrontRecognizer();
        MyKadBackRecognizer mykadback = new MyKadBackRecognizer();
        return buildMenuItem("Malaysian ID card", buildDocumentScanUiSettings(mykadfront, mykadback));
    }

    private MenuListItem buildIKadElement() {
        IKadRecognizer iKad = new IKadRecognizer();
        return buildMenuItem("Malaysian iKad document", buildDocumentScanUiSettings(iKad));
    }

    private MenuListItem buildMyTenteraElement() {
        MyTenteraRecognizer myTentera = new MyTenteraRecognizer();
        return buildMenuItem("Malaysian MyTentera", buildDocumentScanUiSettings(myTentera));
    }

    private MenuListItem buildPolishIdElement() {
        PolandIDFrontSideRecognizer polIdFront = new PolandIDFrontSideRecognizer();
        PolandIDBackSideRecognizer polIdBack = new PolandIDBackSideRecognizer();
        return buildMenuItem("Polish ID", buildDocumentScanUiSettings(polIdFront, polIdBack));
    }

    private MenuListItem buildRomanianElement() {
        RomaniaIDFrontRecognizer romanian = new RomaniaIDFrontRecognizer();
        return buildMenuItem("Romanian ID", buildDocumentScanUiSettings(romanian));
    }

    private MenuListItem buildSwissIDElement() {
        SwitzerlandIDFrontRecognizer swissIDBack = new SwitzerlandIDFrontRecognizer();
        SwitzerlandIDBackRecognizer swissIDFront = new SwitzerlandIDBackRecognizer();
        return buildMenuItem("Swiss ID", buildDocumentScanUiSettings(swissIDBack, swissIDFront));
    }

    private MenuListItem buildCroatianIDCombinedElement() {
        CroatiaCombinedRecognizer croIDCombined = new CroatiaCombinedRecognizer();
        return buildMenuItem("Croatian ID combined", buildCombinedScanUiSettings(croIDCombined));
    }

    private MenuListItem buildSerbianIDCombinedElement() {
        SerbiaCombinedRecognizer serbianIDCombined = new SerbiaCombinedRecognizer();
        return buildMenuItem("Serbian ID combined", buildCombinedScanUiSettings(serbianIDCombined));
    }

    private MenuListItem buildSlovenianIDCombinedElement() {
        SloveniaCombinedRecognizer svnIDCombined = new SloveniaCombinedRecognizer();
        return buildMenuItem("Slovenian ID combined", buildCombinedScanUiSettings(svnIDCombined));
    }

    private MenuListItem buildSlovakIDCombinedElement() {
        SlovakiaCombinedRecognizer svkIDCombined = new SlovakiaCombinedRecognizer();
        return buildMenuItem("Slovak ID combined", buildCombinedScanUiSettings(svkIDCombined));
    }

    private MenuListItem buildSingaporeIDCombinedElement() {
        SingaporeCombinedRecognizer singaporeIDCombined = new SingaporeCombinedRecognizer();
        return buildMenuItem("Singapore ID combined", buildCombinedScanUiSettings(singaporeIDCombined));
    }

    private MenuListItem buildCzechIDCombinedElement() {
        CzechiaCombinedRecognizer czechIDCombined = new CzechiaCombinedRecognizer();
        return buildMenuItem("Czech ID combined", buildCombinedScanUiSettings(czechIDCombined));
    }

    private MenuListItem buildJordanIdCombinedElement() {
        JordanCombinedRecognizer jordanIDCombined = new JordanCombinedRecognizer();
        return buildMenuItem("Jordan ID Combined", buildCombinedScanUiSettings(jordanIDCombined));
    }

    private MenuListItem buildAustrianIDCombinedElement() {
        AustriaCombinedRecognizer ausIDCombined = new AustriaCombinedRecognizer();
        return buildMenuItem("Austrian ID combined", buildCombinedScanUiSettings(ausIDCombined));
    }

    private MenuListItem buildGermanIDCombinedElement() {
        GermanyCombinedRecognizer deCombined = new GermanyCombinedRecognizer();
        return buildMenuItem("German ID Combined", buildCombinedScanUiSettings(deCombined));
    }

    private MenuListItem buildPolishIdCombinedElement() {
        PolandCombinedRecognizer polIDCombined = new PolandCombinedRecognizer();
        return buildMenuItem("Polish ID Combined",  buildCombinedScanUiSettings(polIDCombined));
    }

    private MenuListItem buildPDF417Element() {
        Pdf417Recognizer pdf417 = new Pdf417Recognizer();
        return buildMenuItem("PDF417 barcode", buildBarcodeScanUiSettings( pdf417));
    }

    private MenuListItem buildBarcodeElement() {
        BarcodeRecognizer barcodeRecognizer = new BarcodeRecognizer();
        barcodeRecognizer.setScanCode39(true);
        barcodeRecognizer.setScanCode128(true);
        barcodeRecognizer.setInverseScanning(true);
        barcodeRecognizer.setScanAztecCode(true);
        barcodeRecognizer.setScanDataMatrixCode(true);
        barcodeRecognizer.setScanEAN13Code(true);
        barcodeRecognizer.setScanEAN8Code(true);
        barcodeRecognizer.setScanITFCode(true);
        barcodeRecognizer.setScanQRCode(true);
        barcodeRecognizer.setScanUPCACode(true);
        barcodeRecognizer.setScanUPCECode(true);
        return buildMenuItem("Blink barcode", buildBarcodeScanUiSettings(barcodeRecognizer));
    }

    private MenuListItem buildSimNumberElement() {
        SimNumberRecognizer simNumberRecognizer = new SimNumberRecognizer();
        return buildMenuItem("Sim number barcode", buildBarcodeScanUiSettings(simNumberRecognizer));
    }

    private MenuListItem buildVin() {
        VinRecognizer vinRecognizer = new VinRecognizer();
        return buildMenuItem("VIN", buildBarcodeScanUiSettings(vinRecognizer));
    }

    private MenuListItem buildMenuItem(String title, final UISettings documentUISettings) {
        return new MenuListItem(title, new Runnable() {
            @Override
            public void run() {
                ActivityRunner.startActivityForResult(MenuActivity.this, MY_BLINKID_REQUEST_CODE, documentUISettings);
            }
        });
    }

    private DocumentVerificationUISettings buildCombinedScanUiSettings(Recognizer combinedRecognizer) {
        mRecognizerBundle = new RecognizerBundle(combinedRecognizer);
        return new DocumentVerificationUISettings(mRecognizerBundle);
    }

    private DocumentUISettings buildDocumentScanUiSettings(Recognizer...recognizers) {
        mRecognizerBundle = new RecognizerBundle(recognizers);
        DocumentUISettings documentUISettings = new DocumentUISettings(mRecognizerBundle);

        // with setNumMsBeforeTimeout you can define number of milliseconds that must pass
        // after first partial scan result has arrived before scan activity triggers a timeout.
        // Timeout is good for preventing infinitely long scanning experience when user attempts
        // to scan damaged or unsupported document. After timeout, scan activity will return only
        // data that was read successfully. This might be incomplete data.
        //mRecognizerBundle.setNumMsBeforeTimeout(10000);

        // If you add more recognizers, you can choose whether you
        // want to have the ability to obtain multiple scan results from same video frame. For example,
        // if both payment slip and payment barcode are visible on a single frame, by setting
        // setAllowMultipleScanResultsOnSingleImage to true you can obtain both scan results
        // from barcode and slip. If this is false (default), you will get the first valid result
        // (i.e. first result that contains all required data). Having this option turned off
        // creates better and faster user experience.
        //mRecognizerBundle.setAllowMultipleScanResultsOnSingleImage(true);

        // You can disable drawing of OCR results on scan activity. Drawing OCR results can be visually
        // appealing and might entertain the user while waiting for scan to complete, but might introduce a small
        // performance penalty.
        documentUISettings.setShowOcrResult(false);

        // You can have scan activity display the focus rectangle whenever camera
        // attempts to focus, similarly to various camera app's touch to focus effect.
        // By default this is off
        documentUISettings.setShowingFocusRectangle(true);

        // You can enable the pinch to zoom feature of scan activity.
        // By enabling this you allow the user to use the pinch gesture to zoom the camera.
        // By default this is off
        documentUISettings.setPinchToZoomAllowed(true);

        // Enable showing of OCR results as animated dots. This does not have effect if non-OCR recognizer like
        // barcode recognizer is active.
        documentUISettings.setShowOcrResultMode(ShowOcrResultMode.ANIMATED_DOTS);

        // set custom beep sound to be played after a scan
        documentUISettings.setBeepSoundResourceID(R.raw.beep);

        return documentUISettings;
    }

    private BarcodeUISettings buildBarcodeScanUiSettings(Recognizer...recognizers) {
        mRecognizerBundle = new RecognizerBundle(recognizers);
        //use default settings for barcode scanning
        return new BarcodeUISettings(mRecognizerBundle);
    }

}