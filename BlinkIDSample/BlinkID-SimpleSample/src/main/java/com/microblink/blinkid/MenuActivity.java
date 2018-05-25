package com.microblink.blinkid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.microblink.activity.BarcodeScanActivity;
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
import com.microblink.uisettings.BaseScanUISettings;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.uisettings.options.ShowOcrResultMode;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends Activity {

    public static final int MY_BLINKID_REQUEST_CODE = 0x101;

    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // in case of problems with the SDK (crashes or ANRs, uncomment following line to enable
        // verbose logging that can help developers track down the problem)
        //Log.setLogLevel(Log.LogLevel.LOG_VERBOSE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }

        setupMenuList();
    }

    private void setupMenuList() {
        final List<ListElement> elements = buildMenuListElements();
        ListView lv = findViewById(R.id.recognizerList);
        ArrayAdapter<ListElement> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elements);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActivityRunner.startActivityForResult(MenuActivity.this, MY_BLINKID_REQUEST_CODE, elements.get(position).mScanUISettings);
            }
        });
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
                data.putExtra(ResultActivity.EXTRAS_RESULT_TYPE, ResultActivity.ResultType.RECOGNIZER_BUNDLE);
                startActivity(data);
            } else {
                // if BlinkID activity did not return result, user has probably
                // pressed Back button and cancelled scanning
                Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private List<ListElement> buildMenuListElements() {
        ArrayList<ListElement> elements = new ArrayList<>();

        elements.add(buildMrtdElement());
        elements.add(buildAustrianIDElement());
        elements.add(buildAustrianIDCombinedElement());
        elements.add(buildAustrianPassportElement());
        elements.add(buildColombiaIDElement());
        elements.add(buildCroatianIDElement());
        elements.add(buildCroatianIDCombinedElement());
        elements.add(buildCzechIDElement());
        elements.add(buildCzechIDCombinedElement());
        elements.add(buildEgyptIDFrontElement());
        elements.add(buildGermanIDElement());
        elements.add(buildGermanPassportElement());
        elements.add(buildGermanIDCombinedElement());
        elements.add(buildHongKongIDFrontElement());
        elements.add(buildIndonesianIdElement());
        elements.add(buildJordanIdElement());
        elements.add(buildJordanIdCombinedElement());
        elements.add(buildMyKadElement());
        elements.add(buildIKadElement());
        elements.add(buildMyTenteraElement());
        elements.add(buildPolishIdElement());
        elements.add(buildPolishIdCombinedElement());
        elements.add(buildRomanianElement());
        elements.add(buildSingaporeIDElement());
        elements.add(buildSingaporeIDCombinedElement());
        elements.add(buildSerbianIDElement());
        elements.add(buildSerbianIDCombinedElement());
        elements.add(buildSlovakIDElement());
        elements.add(buildSlovakIDCombinedElement());
        elements.add(buildSlovenianIDElement());
        elements.add(buildSlovenianIDCombinedElement());
        elements.add(buildSwissIDElement());
        elements.add(buildSwissPassportElement());
        elements.add(buildUnitedArabEmiratesIdElement());

        // DL list entries
        // TODO eudl
        //elements.add(buildAustrianDLElement());
        elements.add(buildAustralianDLElement());
        elements.add(buildMalaysianDLElement());
        elements.add(buildNewZealandDLElement());
        //elements.add(buildGermanDLElement());
        //elements.add(buildUKDLElement());
        elements.add(buildUsdlElement());
        //TODO elements.add(buildUsdlCombinedElement());

        // barcode list entries
        elements.add(buildPDF417Element());
        elements.add(buildBarcodeElement());
        elements.add(buildSimNumberElement());
        elements.add(buildVin());

        // templating API entries
        /* TODO templating
        elements.add(buildTemplatingAPICroIDFrontElement());
        elements.add(buildTemplatingAPICroIDBackElement());*/

        return elements;
    }

    private ListElement buildMrtdElement() {
        //Machine Readable Travel Document (MRTD) recognizer
        MRTDRecognizer recognizer = new MRTDRecognizer();
        // allow results with incorrect check digits, only for demo
        recognizer.setAllowUnverifiedResults(true);
        return new ListElement("ID document", buildDocumentScanIntent(recognizer));
    }

    private ListElement buildAustrianIDElement() {
        AustriaIDFrontSideRecognizer ausFront = new AustriaIDFrontSideRecognizer();
        AustriaIDBackSideRecognizer ausBack = new AustriaIDBackSideRecognizer();
        return new ListElement("Austrian ID", buildDocumentScanIntent(ausFront, ausBack));
    }

    private ListElement buildAustrianPassportElement() {
        AustriaPassportRecognizer ausPass = new AustriaPassportRecognizer();
        return new ListElement("Austrian Passport", buildDocumentScanIntent(ausPass));
    }

    private ListElement buildColombiaIDElement() {
        ColombiaIDFrontSideRecognizer colombiaIDFront = new ColombiaIDFrontSideRecognizer();
        ColombiaIDBackSideRecognizer colombiaIDBack = new ColombiaIDBackSideRecognizer();
        return new ListElement("Colombia ID", buildDocumentScanIntent(colombiaIDFront, colombiaIDBack));
    }

    private ListElement buildCroatianIDElement() {
        CroatiaIDFrontSideRecognizer croFront = new CroatiaIDFrontSideRecognizer();
        CroatiaIDBackSideRecognizer croBack = new CroatiaIDBackSideRecognizer();
        return new ListElement("Croatian ID", buildDocumentScanIntent(croFront, croBack));
    }

    private ListElement buildCzechIDElement() {
        CzechiaIDFrontSideRecognizer czFront = new CzechiaIDFrontSideRecognizer();
        CzechiaIDBackSideRecognizer czBack = new CzechiaIDBackSideRecognizer();
        return new ListElement("Czech ID", buildDocumentScanIntent(czFront, czBack));
    }

    private ListElement buildEgyptIDFrontElement() {
        EgyptIDFrontRecognizer egyptIDFront = new EgyptIDFrontRecognizer();
        return new ListElement("Egypt ID Front", buildDocumentScanIntent(egyptIDFront));
    }

    private ListElement buildGermanIDElement() {
        GermanyIDFrontSideRecognizer deFront = new GermanyIDFrontSideRecognizer();
        GermanyIDBackSideRecognizer deBack = new GermanyIDBackSideRecognizer();
        GermanyOldIDRecognizer deOld = new GermanyOldIDRecognizer();
        return new ListElement("German ID", buildDocumentScanIntent(deFront, deBack, deOld));
    }

    private ListElement buildGermanPassportElement() {
        GermanyPassportRecognizer dePassport = new GermanyPassportRecognizer();
        return new ListElement("German Passport", buildDocumentScanIntent(dePassport));
    }

    private ListElement buildHongKongIDFrontElement() {
        HongKongIDFrontRecognizer hongKongIDFrontRecognizerSettings = new HongKongIDFrontRecognizer();
        return new ListElement("Hong Kong ID", buildDocumentScanIntent(hongKongIDFrontRecognizerSettings));
    }

    private ListElement buildIndonesianIdElement(){
        IndonesiaIDFrontRecognizer idnFrontSettings= new IndonesiaIDFrontRecognizer();
        return new ListElement("Indonesian ID", buildDocumentScanIntent(idnFrontSettings));
    }

    private ListElement buildJordanIdElement(){
        JordanIDFrontRecognizer jorFront = new JordanIDFrontRecognizer();
        JordanIDBackRecognizer jorBack = new JordanIDBackRecognizer();
        return new ListElement("Jordan ID", buildDocumentScanIntent(jorFront, jorBack));
    }

    private ListElement buildSingaporeIDElement() {
        SingaporeIDFrontRecognizer singaporeFront = new SingaporeIDFrontRecognizer();
        SingaporeIDBackRecognizer singaporeBack = new SingaporeIDBackRecognizer();
        return new ListElement("Singapore ID", buildDocumentScanIntent(singaporeFront, singaporeBack));
    }

    private ListElement buildSerbianIDElement() {
        SerbiaIDFrontRecognizer serbFront = new SerbiaIDFrontRecognizer();
        SerbiaIDBackRecognizer serbBack = new SerbiaIDBackRecognizer();
        return new ListElement("Serbian ID", buildDocumentScanIntent(serbFront, serbBack));
    }

    private ListElement buildSlovakIDElement() {
        SlovakiaIDFrontRecognizer svkFront = new SlovakiaIDFrontRecognizer();
        SlovakiaIDBackRecognizer svkBack = new SlovakiaIDBackRecognizer();
        return new ListElement("Slovak ID", buildDocumentScanIntent(svkFront, svkBack));
    }

    private ListElement buildSlovenianIDElement() {
        SloveniaIDFrontRecognizer sloFront = new SloveniaIDFrontRecognizer();
        SloveniaIDBackRecognizer sloBack = new SloveniaIDBackRecognizer();
        return new ListElement("Slovenian ID", buildDocumentScanIntent(sloFront, sloBack));
    }

    private ListElement buildSwissPassportElement() {
        SwitzerlandPassportRecognizer swissPass = new SwitzerlandPassportRecognizer();
        return new ListElement("Swiss Passport", buildDocumentScanIntent(swissPass));
    }

    private ListElement buildUnitedArabEmiratesIdElement() {
        UnitedArabEmiratesIDFrontRecognizer unitedArabEmiratesIdFront = new UnitedArabEmiratesIDFrontRecognizer();
        UnitedArabEmiratesIDBackRecognizer unitedArabEmiratesIdBack = new UnitedArabEmiratesIDBackRecognizer();
        return new ListElement("United Arab Emirates ID", buildDocumentScanIntent(unitedArabEmiratesIdFront, unitedArabEmiratesIdBack));
    }

    private ListElement buildUKDLElement() {
        EUDLRecognizer ukdl = new EUDLRecognizer(EUDLCountry.EUDL_COUNTRY_UK);
        return new ListElement("UK Driver's Licence", buildDocumentScanIntent(ukdl));
    }

    private ListElement buildGermanDLElement() {
        EUDLRecognizer germanDl = new EUDLRecognizer(EUDLCountry.EUDL_COUNTRY_GERMANY);
        return new ListElement("German Driver's Licence", buildDocumentScanIntent(germanDl));
    }

    private ListElement buildAustrianDLElement() {
        EUDLRecognizer ausDl = new EUDLRecognizer(EUDLCountry.EUDL_COUNTRY_AUSTRIA);
        return new ListElement("Austrian Driver's Licence", buildDocumentScanIntent(ausDl));
    }

    private ListElement buildAustralianDLElement() {
        AustraliaDLFrontSideRecognizer ausDLFront = new AustraliaDLFrontSideRecognizer();
        AustraliaDLBackSideRecognizer ausDLBack = new AustraliaDLBackSideRecognizer();
        return new ListElement("Australian Driver's License", buildDocumentScanIntent(ausDLFront, ausDLBack));
    }

    private ListElement buildMalaysianDLElement() {
        MalaysiaDLFrontRecognizer malaysianDL = new MalaysiaDLFrontRecognizer();
        return new ListElement("Malaysian DL", buildDocumentScanIntent(malaysianDL));
    }

    private ListElement buildNewZealandDLElement(){
        NewZealandDLFrontRecognizer nzDlFront = new NewZealandDLFrontRecognizer();
        return new ListElement("New Zealand Driver's Licence", buildDocumentScanIntent(nzDlFront));
    }

    private ListElement buildUsdlElement() {
        USDLRecognizer usdl = new USDLRecognizer();
        return new ListElement("US Driver's License", buildDocumentScanIntent(usdl));
    }

    private ListElement buildMyKadElement() {
        MyKadFrontRecognizer mykadfront = new MyKadFrontRecognizer();
        MyKadBackRecognizer mykadback = new MyKadBackRecognizer();
        return new ListElement("Malaysian ID card", buildDocumentScanIntent(mykadfront, mykadback));
    }

    private ListElement buildIKadElement() {
        IKadRecognizer iKad = new IKadRecognizer();
        return new ListElement("Malaysian iKad document", buildDocumentScanIntent(iKad));
    }

    private ListElement buildMyTenteraElement() {
        MyTenteraRecognizer myTentera = new MyTenteraRecognizer();
        return new ListElement("Malaysian MyTentera", buildDocumentScanIntent(myTentera));
    }

    private ListElement buildPolishIdElement() {
        PolandIDFrontSideRecognizer polIdFront = new PolandIDFrontSideRecognizer();
        PolandIDBackSideRecognizer polIdBack = new PolandIDBackSideRecognizer();
        return new ListElement("Polish ID", buildDocumentScanIntent(polIdFront, polIdBack));
    }

    private ListElement buildRomanianElement() {
        RomaniaIDFrontRecognizer romanian = new RomaniaIDFrontRecognizer();
        return new ListElement("Romanian ID", buildDocumentScanIntent(romanian));
    }

    private ListElement buildSwissIDElement() {
        SwitzerlandIDFrontRecognizer swissIDBack = new SwitzerlandIDFrontRecognizer();
        SwitzerlandIDBackRecognizer swissIDFront = new SwitzerlandIDBackRecognizer();
        return new ListElement("Swiss ID", buildDocumentScanIntent(swissIDBack, swissIDFront));
    }

    private ListElement buildCroatianIDCombinedElement() {
        CroatiaCombinedRecognizer croIDCombined = new CroatiaCombinedRecognizer();
        return new ListElement("Croatian ID combined", buildCombinedIntent(croIDCombined));
    }

    private ListElement buildSerbianIDCombinedElement() {
        SerbiaCombinedRecognizer serbianIDCombined = new SerbiaCombinedRecognizer();
        return new ListElement("Serbian ID combined", buildCombinedIntent(serbianIDCombined));
    }

    private ListElement buildSlovenianIDCombinedElement() {
        SloveniaCombinedRecognizer svnIDCombined = new SloveniaCombinedRecognizer();
        return new ListElement("Slovenian ID combined", buildCombinedIntent(svnIDCombined));
    }

    private ListElement buildSlovakIDCombinedElement() {
        SlovakiaCombinedRecognizer svkIDCombined = new SlovakiaCombinedRecognizer();
        return new ListElement("Slovak ID combined", buildCombinedIntent(svkIDCombined));
    }

    private ListElement buildSingaporeIDCombinedElement() {
        SingaporeCombinedRecognizer singaporeIDCombined = new SingaporeCombinedRecognizer();
        return new ListElement("Singapore ID combined", buildCombinedIntent(singaporeIDCombined));
    }

    private ListElement buildCzechIDCombinedElement() {
        CzechiaCombinedRecognizer czechIDCombined = new CzechiaCombinedRecognizer();
        return new ListElement("Czech ID combined", buildCombinedIntent(czechIDCombined));
    }

    private ListElement buildJordanIdCombinedElement() {
        JordanCombinedRecognizer jordanIDCombined = new JordanCombinedRecognizer();
        return new ListElement("Jordan ID Combined", buildCombinedIntent(jordanIDCombined));
    }

    private ListElement buildAustrianIDCombinedElement() {
        AustriaCombinedRecognizer ausIDCombined = new AustriaCombinedRecognizer();
        return new ListElement("Austrian ID combined", buildCombinedIntent(ausIDCombined));
    }

    private ListElement buildGermanIDCombinedElement() {
        GermanyCombinedRecognizer deCombined = new GermanyCombinedRecognizer();
        return new ListElement("German ID Combined", buildCombinedIntent(deCombined));
    }

    private ListElement buildPolishIdCombinedElement() {
        PolandCombinedRecognizer polIDCombined = new PolandCombinedRecognizer();
        return new ListElement("Polish ID Combined",  buildCombinedIntent(polIDCombined));
    }

    private ListElement buildPDF417Element() {
        Pdf417Recognizer pdf417 = new Pdf417Recognizer();
        return new ListElement("PDF417 barcode", buildBarcodeScanIntent( pdf417));
    }

    private ListElement buildBarcodeElement() {
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
        return new ListElement("Blink barcode", buildBarcodeScanIntent(barcodeRecognizer));
    }

    private ListElement buildSimNumberElement() {
        SimNumberRecognizer simNumberRecognizer = new SimNumberRecognizer();
        return new ListElement("Sim number barcode", buildBarcodeScanIntent(simNumberRecognizer));
    }

    private ListElement buildVin() {
        VinRecognizer vinRecognizer = new VinRecognizer();
        return new ListElement("VIN", buildBarcodeScanIntent(vinRecognizer));
    }

    private DocumentUISettings buildCombinedIntent(Recognizer combinedRecognizer) {
        //TODO different activity for combined?
        return buildDocumentScanIntent(combinedRecognizer);
    }

    private DocumentUISettings buildDocumentScanIntent(Recognizer...recognizers) {
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

    private BarcodeUISettings buildBarcodeScanIntent(Recognizer...recognizers) {
        mRecognizerBundle = new RecognizerBundle(recognizers);
        //use default settings for barcode scanning
        return new BarcodeUISettings(mRecognizerBundle);
    }

    private class ListElement {
        private String mTitle;
        private BaseScanUISettings mScanUISettings;

        ListElement(String title, BaseScanUISettings scanUISettings) {
            mTitle = title;
            mScanUISettings = scanUISettings;
        }

        /**
         * Used by array adapter to determine list element text
         */
        @Override
        public String toString() {
            return mTitle;
        }
    }
}