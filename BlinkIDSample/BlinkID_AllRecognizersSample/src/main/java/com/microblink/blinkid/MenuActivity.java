package com.microblink.blinkid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.microblink.BaseMenuActivity;
import com.microblink.MenuListItem;
import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldBundle;
import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldElement;
import com.microblink.entities.parsers.date.DateParser;
import com.microblink.entities.parsers.email.EMailParser;
import com.microblink.entities.parsers.licenseplates.LicensePlatesParser;
import com.microblink.entities.parsers.raw.RawParser;
import com.microblink.entities.parsers.vin.VinParser;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.entities.recognizers.blinkbarcode.simnumber.SimNumberRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.vin.VinRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlBackRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.brunei.BruneiIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.brunei.BruneiIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.brunei.BruneiResidencePermitBackRecognizer;
import com.microblink.entities.recognizers.blinkid.brunei.BruneiResidencePermitFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.cyprus.CyprusIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.cyprus.CyprusIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.cyprus.CyprusOldIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.cyprus.CyprusOldIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.egypt.EgyptIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardBackRecognizer;
import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.eudl.EudlCountry;
import com.microblink.entities.recognizers.blinkid.eudl.EudlRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyDlBackRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIdOldRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.indonesia.IndonesiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.ireland.IrelandDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.italy.ItalyDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.kuwait.KuwaitIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.kuwait.KuwaitIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaIkadFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyKadBackRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyKadFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyKasFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyPrFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyTenteraFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.mexico.MexicoVoterIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.morocco.MoroccoIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.morocco.MoroccoIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardBackRecognizer;
import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.romania.RomaniaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeChangiEmployeeIdRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.spain.SpainDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.sweden.dl.SwedenDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.help.HelpActivity;
import com.microblink.result.ResultActivity;
import com.microblink.uisettings.ActivityRunner;
import com.microblink.uisettings.BarcodeUISettings;
import com.microblink.uisettings.BaseScanUISettings;
import com.microblink.uisettings.DocumentUISettings;
import com.microblink.uisettings.DocumentVerificationUISettings;
import com.microblink.uisettings.FieldByFieldUISettings;
import com.microblink.uisettings.UISettings;
import com.microblink.uisettings.options.BeepSoundUIOptions;
import com.microblink.uisettings.options.HelpIntentUIOptions;
import com.microblink.uisettings.options.OcrResultDisplayMode;
import com.microblink.uisettings.options.OcrResultDisplayUIOptions;
import com.microblink.util.ImageSettings;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends BaseMenuActivity {

    public static final int MY_BLINKID_REQUEST_CODE = 123;

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

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

    /**
     * This method is invoked after returning from scan activity. You can obtain
     * scan results here
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // onActivityResult is called whenever we are returned from activity started
        // with startActivityForResult. We need to check request code to determine
        // that we have really returned from BlinkID activity.
        if (requestCode == MY_BLINKID_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            startResultActivity(data);
        } else {
            // if BlinkID activity did not return result, user has probably
            // pressed Back button and cancelled scanning
            Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
        }
    }

    private void startResultActivity(Intent data) {
        // set intent's component to ResultActivity and pass its contents
        // to ResultActivity. ResultActivity will show how to extract
        // data from result.
        data.setComponent(new ComponentName(getApplicationContext(), ResultActivity.class));
        startActivity(data);
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

        // ID document list entries
        items.add(buildMrtdElement());
        items.add(buildAustrianIDElement());
        items.add(buildAustrianIDCombinedElement());
        items.add(buildAustrianPassportElement());
        items.add(buildBruneiIdFrontElement());
        items.add(buildBruneiIdBackElement());
        items.add(buildBruneiResidencePermitFrontElement());
        items.add(buildBruneiResidencePermitBackElement());
        items.add(buildColombiaIDElement());
        items.add(buildCroatianIDElement());
        items.add(buildCroatianIDCombinedElement());
        items.add(buildCyprusIDElement());
        items.add(buildCyprusOldIDElement());
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
        items.add(buildKuwaitIdElement());
        items.add(buildMexicoVoterIdElement());
        items.add(buildMyKadElement());
        items.add(buildIKadElement());
        items.add(buildMyTenteraElement());
        items.add(buildMyPrElement());
        items.add(buildMyKasElement());
        items.add(buildMoroccoIDElement());
        items.add(buildPolishIdElement());
        items.add(buildPolishIdCombinedElement());
        items.add(buildRomanianElement());
        items.add(buildSingaporeIDElement());
        items.add(buildSingaporeChangiEmployeeIdElement());
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
        items.add(buildAustriaDLFrontElement());
        items.add(buildAustralianDLElement());
        items.add(buildColombiaDLElement());
        items.add(buildIrelandDLElement());
        items.add(buildItalyDlElement());
        items.add(buildMalaysianDLElement());
        items.add(buildNewZealandDLElement());
        items.add(buildGermanDLFrontElement());
        items.add(buildGermanDLBackElement());
        items.add(buildSingaporeDLElement());
        items.add(buildSpainDLElement());
        items.add(buildSwedenDLElement());
        items.add(buildSwissDLElement());
        items.add(buildUKDLElement());
        items.add(buildUsdlElement());
        items.add(buildUnitedArabEmiratesDLElement());
        items.add(buildUsdlCombinedElement());

        // entries for documents which are not country-specific
        items.add(buildPaymentCardElement());
        items.add(buildPaymentCardCombinedElement());
        items.add(buildElitePaymentCardElement());
        items.add(buildElitePaymentCardCombinedElement());

        // barcode list entries
        items.add(buildPDF417Element());
        items.add(buildBarcodeElement());
        items.add(buildSimNumberElement());
        items.add(buildVinElement());

        // Field by field entries
        items.add(buildGenericFieldByFieldElement());
        items.add(buildVehicleFieldByFieldElement());

        return items;
    }

    /**
     * Starts scan activity. Activity that will be used is determined by the passed activity settings.
     * UI options are configured inside this method.
     * @param activitySettings activity settings that will be used for scanning, only recognizers are
     *                         important, UI options will be configured inside this method.
     * @param helpIntent help intent that can be launched if scan activity supports that
     */
    private void scanAction(@NonNull UISettings activitySettings, @Nullable Intent helpIntent) {
        setupActivitySettings(activitySettings, helpIntent);
        ActivityRunner.startActivityForResult(this, MY_BLINKID_REQUEST_CODE, activitySettings);
    }

    /**
     * Starts scan activity. Activity that will be used is determined by the passed activity settings.
     * UI options are configured inside this method.
     * @param activitySettings activity settings that will be used for scanning, only recognizers are
     *                         important, UI options will be configured inside this method.
     */
    private void scanAction(@NonNull UISettings activitySettings) {
        scanAction(activitySettings, null);
    }

    /**
     * Starts {@link com.microblink.activity.DocumentVerificationActivity} with given recognizer.
     * @param combinedRecognizer recognizer that will be used.
     */
    private void combinedRecognitionAction(Recognizer combinedRecognizer) {
        DocumentVerificationUISettings uiSettings = new DocumentVerificationUISettings(new RecognizerBundle(combinedRecognizer));
        uiSettings.setBeepSoundResourceID(R.raw.beep);

        ActivityRunner.startActivityForResult(this, MY_BLINKID_REQUEST_CODE, uiSettings);
    }

    private void setupActivitySettings(@NonNull UISettings settings, @Nullable Intent helpIntent) {
        if (settings instanceof BeepSoundUIOptions) {
            // optionally, if you want the beep sound to be played after a scan
            // add a sound resource id
            ((BeepSoundUIOptions) settings).setBeepSoundResourceID(R.raw.beep);
        }
        if (helpIntent != null && settings instanceof HelpIntentUIOptions) {
            // if we have help intent, we can pass it to scan activity so it can invoke
            // it if user taps the help button. If we do not set the help intent,
            // scan activity will hide the help button.
            ((HelpIntentUIOptions) settings).setHelpIntent(helpIntent);
        }
        if (settings instanceof OcrResultDisplayUIOptions) {
            // If you want, you can disable drawing of OCR results on scan activity. Drawing OCR results can be visually
            // appealing and might entertain the user while waiting for scan to complete, but might introduce a small
            // performance penalty.
            // ((ShowOcrResultUIOptions) settings).setShowOcrResult(false);

            // Enable showing of OCR results as animated dots. This does not have effect if non-OCR recognizer like
            // barcode recognizer is active.
            ((OcrResultDisplayUIOptions) settings).setOcrResultDisplayMode(OcrResultDisplayMode.ANIMATED_DOTS);
        }
        if (settings instanceof BaseScanUISettings) {
            // If you want you can have scan activity display the focus rectangle whenever camera
            // attempts to focus, similarly to various camera app's touch to focus effect.
            // By default this is off, and you can turn this on by setting EXTRAS_SHOW_FOCUS_RECTANGLE
            // extra to true.
            // ((BaseScanUISettings) settings).setShowingFocusRectangle(true);

            // If you want, you can enable the pinch to zoom feature of scan activity.
            // By enabling this you allow the user to use the pinch gesture to zoom the camera.
            // By default this is off
            ((BaseScanUISettings) settings).setPinchToZoomAllowed(true);
        }
    }

    private MenuListItem buildMrtdElement() {
        return new MenuListItem("Passport and ID", new Runnable() {
            @Override
            public void run() {
                MrtdRecognizer mrtdRecogniezr = new MrtdRecognizer();
                mrtdRecogniezr.setAllowUnverifiedResults(true);
                ImageSettings.enableAllImages(mrtdRecogniezr);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(mrtdRecogniezr)));
            }
        });
    }

    private MenuListItem buildAustrianIDElement() {
        return new MenuListItem("Austrian ID", new Runnable() {
            @Override
            public void run() {
                AustriaIdFrontRecognizer austriaFront = new AustriaIdFrontRecognizer();
                ImageSettings.enableAllImages(austriaFront);

                AustriaIdBackRecognizer austriaBack = new AustriaIdBackRecognizer();
                ImageSettings.enableAllImages(austriaBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(austriaFront, austriaBack)));
            }
        });
    }

    private MenuListItem buildAustrianPassportElement() {
        return new MenuListItem("Austrian passport", new Runnable() {
            @Override
            public void run() {
                AustriaPassportRecognizer austriaPassport = new AustriaPassportRecognizer();
                ImageSettings.enableAllImages(austriaPassport);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(austriaPassport)));
            }
        });
    }

    private MenuListItem buildBruneiIdFrontElement() {
        return new MenuListItem("Brunei ID front", new Runnable() {
            @Override
            public void run() {
                BruneiIdFrontRecognizer bruneiFront = new BruneiIdFrontRecognizer();
                ImageSettings.enableAllImages(bruneiFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(bruneiFront)));
            }
        });
    }

    private MenuListItem buildBruneiIdBackElement() {
        return new MenuListItem("Brunei ID back", new Runnable() {
            @Override
            public void run() {
                BruneiIdBackRecognizer recognizer = new BruneiIdBackRecognizer();
                ImageSettings.enableAllImages(recognizer);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(recognizer)));
            }
        });
    }

    private MenuListItem buildBruneiResidencePermitFrontElement() {
        return new MenuListItem("Brunei residence permit front", new Runnable() {
            @Override
            public void run() {
                BruneiResidencePermitFrontRecognizer recognizer = new BruneiResidencePermitFrontRecognizer();
                ImageSettings.enableAllImages(recognizer);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(recognizer)));
            }
        });
    }

    private MenuListItem buildBruneiResidencePermitBackElement() {
        return new MenuListItem("Brunei residence permit back", new Runnable() {
            @Override
            public void run() {
                BruneiResidencePermitBackRecognizer recognizer = new BruneiResidencePermitBackRecognizer();
                ImageSettings.enableAllImages(recognizer);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(recognizer)));
            }
        });
    }

    private MenuListItem buildColombiaIDElement() {
        return new MenuListItem("Colombia ID", new Runnable() {
            @Override
            public void run() {
                ColombiaIdFrontRecognizer colombiaFront = new ColombiaIdFrontRecognizer();
                ImageSettings.enableAllImages(colombiaFront);

                ColombiaIdBackRecognizer colombiaBack = new ColombiaIdBackRecognizer();

                scanAction(new DocumentUISettings(prepareRecognizerBundle(colombiaFront, colombiaBack)));
            }
        });
    }

    private MenuListItem buildCroatianIDElement() {
        return new MenuListItem("Croatian ID", new Runnable() {
            @Override
            public void run() {
                CroatiaIdFrontRecognizer croatiaFront = new CroatiaIdFrontRecognizer();
                ImageSettings.enableAllImages(croatiaFront);

                CroatiaIdBackRecognizer croatiaBack = new CroatiaIdBackRecognizer();
                ImageSettings.enableAllImages(croatiaBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(croatiaFront, croatiaBack)));
            }
        });
    }

    private MenuListItem buildCyprusIDElement() {
        return new MenuListItem("Cyprus ID", new Runnable() {
            @Override
            public void run() {
                CyprusIdFrontRecognizer cyprusFront = new CyprusIdFrontRecognizer();
                ImageSettings.enableAllImages(cyprusFront);

                CyprusIdBackRecognizer cyprusBack = new CyprusIdBackRecognizer();
                ImageSettings.enableAllImages(cyprusBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(cyprusFront, cyprusBack)));
            }
        });
    }

    private MenuListItem buildCyprusOldIDElement() {
        return new MenuListItem("Cyprus Old ID", new Runnable() {
            @Override
            public void run() {
                CyprusOldIdFrontRecognizer cyprusOldIdFrontRecognizer = new CyprusOldIdFrontRecognizer();
                ImageSettings.enableAllImages(cyprusOldIdFrontRecognizer);

                CyprusOldIdBackRecognizer cyprusOldIdBackRecognizer = new CyprusOldIdBackRecognizer();
                ImageSettings.enableAllImages(cyprusOldIdBackRecognizer);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(cyprusOldIdFrontRecognizer, cyprusOldIdBackRecognizer)));
            }
        });
    }

    private MenuListItem buildCzechIDElement() {
        return new MenuListItem("Czech ID", new Runnable() {
            @Override
            public void run() {
                CzechiaIdFrontRecognizer czechiaFront = new CzechiaIdFrontRecognizer();
                ImageSettings.enableAllImages(czechiaFront);

                CzechiaIdBackRecognizer czechiaBack = new CzechiaIdBackRecognizer();
                ImageSettings.enableAllImages(czechiaBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(czechiaFront, czechiaBack)));
            }
        });
    }

    private MenuListItem buildEgyptIDFrontElement() {
        return new MenuListItem("Egypt ID Front", new Runnable() {
            @Override
            public void run() {
                EgyptIdFrontRecognizer egyptFront = new EgyptIdFrontRecognizer();
                ImageSettings.enableAllImages(egyptFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(egyptFront)));
            }
        });
    }

    private MenuListItem buildGermanIDElement() {
        return new MenuListItem("German ID", new Runnable() {
            @Override
            public void run() {
                GermanyIdFrontRecognizer germanyIdFront = new GermanyIdFrontRecognizer();
                ImageSettings.enableAllImages(germanyIdFront);

                GermanyIdBackRecognizer germanyIdBack = new GermanyIdBackRecognizer();
                ImageSettings.enableAllImages(germanyIdBack);

                GermanyIdOldRecognizer germanyIdOld = new GermanyIdOldRecognizer();
                ImageSettings.enableAllImages(germanyIdOld);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(germanyIdFront, germanyIdBack, germanyIdOld)));
            }
        });
    }

    private MenuListItem buildGermanPassportElement() {
        return new MenuListItem("German Passport", new Runnable() {
            @Override
            public void run() {
                GermanyPassportRecognizer germanyPassport = new GermanyPassportRecognizer();
                ImageSettings.enableAllImages(germanyPassport);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(germanyPassport)));
            }
        });
    }

    private MenuListItem buildHongKongIDFrontElement() {
        return new MenuListItem("Hong Kong ID", new Runnable() {
            @Override
            public void run() {
                HongKongIdFrontRecognizer hongKongFront = new HongKongIdFrontRecognizer();
                ImageSettings.enableAllImages(hongKongFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(hongKongFront)));
            }
        });
    }

    private MenuListItem buildIndonesianIdElement() {
        return new MenuListItem("Indonesian ID", new Runnable() {
            @Override
            public void run() {
                IndonesiaIdFrontRecognizer indonesiaFront = new IndonesiaIdFrontRecognizer();
                ImageSettings.enableAllImages(indonesiaFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(indonesiaFront)));
            }
        });
    }

    private MenuListItem buildJordanIdElement() {
        return new MenuListItem("Jordan ID", new Runnable() {
            @Override
            public void run() {
                JordanIdFrontRecognizer jordanFront = new JordanIdFrontRecognizer();
                ImageSettings.enableAllImages(jordanFront);

                JordanIdBackRecognizer jordanBack = new JordanIdBackRecognizer();
                ImageSettings.enableAllImages(jordanBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(jordanFront, jordanBack)));
            }
        });
    }

    private MenuListItem buildKuwaitIdElement() {
        return new MenuListItem("Kuwait ID", new Runnable() {
            @Override
            public void run() {
                KuwaitIdFrontRecognizer kuwaitFront = new KuwaitIdFrontRecognizer();
                ImageSettings.enableAllImages(kuwaitFront);

                KuwaitIdBackRecognizer kuwaitBack = new KuwaitIdBackRecognizer();
                ImageSettings.enableAllImages(kuwaitBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(kuwaitFront, kuwaitBack)));
            }
        });
    }

    private MenuListItem buildMexicoVoterIdElement() {
        return new MenuListItem("Mexico Voter ID", new Runnable() {
            @Override
            public void run() {
                MexicoVoterIdFrontRecognizer mexicoFront = new MexicoVoterIdFrontRecognizer();
                ImageSettings.enableAllImages(mexicoFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(mexicoFront)));
            }
        });
    }

    private MenuListItem buildMyKadElement() {
        return new MenuListItem("Malaysian ID", new Runnable() {
            @Override
            public void run() {
                MalaysiaMyKadFrontRecognizer mykadFront = new MalaysiaMyKadFrontRecognizer();
                ImageSettings.enableAllImages(mykadFront);

                MalaysiaMyKadBackRecognizer mykadBack = new MalaysiaMyKadBackRecognizer();
                ImageSettings.enableAllImages(mykadBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(mykadFront, mykadBack)));
            }
        });
    }

    private MenuListItem buildIKadElement() {
        return new MenuListItem("Malaysian Immigrator ID", new Runnable() {
            @Override
            public void run() {
                MalaysiaIkadFrontRecognizer ikad = new MalaysiaIkadFrontRecognizer();
                ImageSettings.enableAllImages(ikad);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(ikad)));
            }
        });
    }

    private MenuListItem buildMyTenteraElement() {
        return new MenuListItem("Malaysian MyTentera", new Runnable() {
            @Override
            public void run() {
                MalaysiaMyTenteraFrontRecognizer myTenteraRec = new MalaysiaMyTenteraFrontRecognizer();
                ImageSettings.enableAllImages(myTenteraRec);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(myTenteraRec)));
            }
        });
    }

    private MenuListItem buildMyPrElement() {
        return new MenuListItem("Malaysian MyPR", new Runnable() {
            @Override
            public void run() {
                MalaysiaMyPrFrontRecognizer myPrRec = new MalaysiaMyPrFrontRecognizer();
                ImageSettings.enableAllImages(myPrRec);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(myPrRec)));
            }
        });
    }

    private MenuListItem buildMyKasElement() {
        return new MenuListItem("Malaysian MyKAS", new Runnable() {
            @Override
            public void run() {
                MalaysiaMyKasFrontRecognizer myKasRec = new MalaysiaMyKasFrontRecognizer();
                ImageSettings.enableAllImages(myKasRec);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(myKasRec)));
            }
        });
    }

    private MenuListItem buildMoroccoIDElement() {
        return new MenuListItem("Morocco ID", new Runnable() {
            @Override
            public void run() {
                MoroccoIdFrontRecognizer moroccoFront = new MoroccoIdFrontRecognizer();
                ImageSettings.enableAllImages(moroccoFront);

                MoroccoIdBackRecognizer moroccoBack = new MoroccoIdBackRecognizer();
                ImageSettings.enableAllImages(moroccoBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(moroccoFront, moroccoBack)));
            }
        });
    }

    private MenuListItem buildPolishIdElement() {
        return new MenuListItem("Polish ID", new Runnable() {
            @Override
            public void run() {
                PolandIdFrontRecognizer polandFront = new PolandIdFrontRecognizer();
                ImageSettings.enableAllImages(polandFront);

                PolandIdBackRecognizer polandBack = new PolandIdBackRecognizer();
                ImageSettings.enableAllImages(polandBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(polandFront, polandBack)));
            }
        });
    }

    private MenuListItem buildRomanianElement() {
        return new MenuListItem("Romanian ID", new Runnable() {
            @Override
            public void run() {
                RomaniaIdFrontRecognizer romaniaFront = new RomaniaIdFrontRecognizer();
                ImageSettings.enableAllImages(romaniaFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(romaniaFront)));
            }
        });
    }

    private MenuListItem buildSingaporeIDElement() {
        return new MenuListItem("Singapore ID", new Runnable() {
            @Override
            public void run() {
                SingaporeIdFrontRecognizer singaporeFront = new SingaporeIdFrontRecognizer();
                ImageSettings.enableAllImages(singaporeFront);

                SingaporeIdBackRecognizer singaporeBack = new SingaporeIdBackRecognizer();
                ImageSettings.enableAllImages(singaporeBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(singaporeFront, singaporeBack)));
            }
        });
    }

    private MenuListItem buildSingaporeChangiEmployeeIdElement() {
        return new MenuListItem("Singapore Changi Employee ID", new Runnable() {
            @Override
            public void run() {
                SingaporeChangiEmployeeIdRecognizer singaporeChangiEmployeeIdRecognizer = new SingaporeChangiEmployeeIdRecognizer();
                ImageSettings.enableAllImages(singaporeChangiEmployeeIdRecognizer);
                scanAction(new DocumentUISettings(prepareRecognizerBundle(singaporeChangiEmployeeIdRecognizer)));
            }
        });
    }

    private MenuListItem buildSerbianIDElement() {
        return new MenuListItem("Serbian ID", new Runnable() {
            @Override
            public void run() {
                SerbiaIdFrontRecognizer serbiaFront = new SerbiaIdFrontRecognizer();
                ImageSettings.enableAllImages(serbiaFront);

                SerbiaIdBackRecognizer serbiaBack = new SerbiaIdBackRecognizer();
                ImageSettings.enableAllImages(serbiaBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(serbiaFront, serbiaBack)));
            }
        });
    }

    private MenuListItem buildSlovakIDElement() {
        return new MenuListItem("Slovak ID", new Runnable() {
            @Override
            public void run() {
                SlovakiaIdFrontRecognizer slovakFront = new SlovakiaIdFrontRecognizer();
                ImageSettings.enableAllImages(slovakFront);

                SlovakiaIdBackRecognizer slovakBack = new SlovakiaIdBackRecognizer();
                ImageSettings.enableAllImages(slovakBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(slovakFront, slovakBack)));
            }
        });
    }

    private MenuListItem buildSlovenianIDElement() {
        return new MenuListItem("Slovenian ID", new Runnable() {
            @Override
            public void run() {
                SloveniaIdFrontRecognizer sloveniaFront = new SloveniaIdFrontRecognizer();
                ImageSettings.enableAllImages(sloveniaFront);

                SloveniaIdBackRecognizer sloveniaBack = new SloveniaIdBackRecognizer();
                ImageSettings.enableAllImages(sloveniaBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(sloveniaFront, sloveniaBack)));
            }
        });
    }

    private MenuListItem buildSwissIDElement() {
        return new MenuListItem("Swiss ID", new Runnable() {
            @Override
            public void run() {
                SwitzerlandIdFrontRecognizer switzerlandFront = new SwitzerlandIdFrontRecognizer();
                ImageSettings.enableAllImages(switzerlandFront);

                SwitzerlandIdBackRecognizer switzerlandBack = new SwitzerlandIdBackRecognizer();
                ImageSettings.enableAllImages(switzerlandBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(switzerlandFront, switzerlandBack)));
            }
        });
    }

    private MenuListItem buildSwissPassportElement() {
        return new MenuListItem("Swiss Passport", new Runnable() {
            @Override
            public void run() {
                SwitzerlandPassportRecognizer switzerlandPassport = new SwitzerlandPassportRecognizer();
                ImageSettings.enableAllImages(switzerlandPassport);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(switzerlandPassport)));
            }
        });
    }

    private MenuListItem buildUnitedArabEmiratesIdElement() {
        return new MenuListItem("United Arab Emirates ID", new Runnable() {
            @Override
            public void run() {
                UnitedArabEmiratesIdFrontRecognizer uaeFront = new UnitedArabEmiratesIdFrontRecognizer();
                ImageSettings.enableAllImages(uaeFront);

                UnitedArabEmiratesIdBackRecognizer uaeBack = new UnitedArabEmiratesIdBackRecognizer();
                ImageSettings.enableAllImages(uaeBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(uaeFront, uaeBack)));
            }
        });
    }

    private MenuListItem buildPaymentCardElement() {
        return new MenuListItem("Payment Card", new Runnable() {
            @Override
            public void run() {
                PaymentCardFrontRecognizer paymentCardFront = new PaymentCardFrontRecognizer();
                ImageSettings.enableAllImages(paymentCardFront);

                PaymentCardBackRecognizer paymentCardBack = new PaymentCardBackRecognizer();
                ImageSettings.enableAllImages(paymentCardBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(paymentCardFront, paymentCardBack)));
            }
        });
    }

    private MenuListItem buildElitePaymentCardElement() {
        return new MenuListItem("Elite Payment Card", new Runnable() {
            @Override
            public void run() {
                ElitePaymentCardFrontRecognizer frontRec = new ElitePaymentCardFrontRecognizer();
                ImageSettings.enableAllImages(frontRec);

                ElitePaymentCardBackRecognizer backRec = new ElitePaymentCardBackRecognizer();
                ImageSettings.enableAllImages(backRec);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(frontRec, backRec)));
            }
        });
    }

    private MenuListItem buildEUDLElement(String title, final EudlCountry country) {
        return new MenuListItem(title, new Runnable() {
            @Override
            public void run() {
                EudlRecognizer eudl = new EudlRecognizer(country);
                ImageSettings.enableAllImages(eudl);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(eudl)));
            }
        });
    }

    private MenuListItem buildUKDLElement() {
        return buildEUDLElement("UK Driver's License", EudlCountry.EUDL_COUNTRY_UK);
    }

    private MenuListItem buildGermanDLFrontElement() {
        return new MenuListItem("German Driver's License Front", new Runnable() {
            @Override
            public void run() {
                GermanyDlFrontRecognizer recognizer = new GermanyDlFrontRecognizer();
                ImageSettings.enableAllImages(recognizer);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(recognizer)));
            }
        });
    }

    private MenuListItem buildGermanDLBackElement() {
        return new MenuListItem("German Driver's License Back", new Runnable() {
            @Override
            public void run() {
                GermanyDlBackRecognizer germanDlBack = new GermanyDlBackRecognizer();
                ImageSettings.enableAllImages(germanDlBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(germanDlBack)));
            }
        });
    }

    private MenuListItem buildAustriaDLFrontElement() {
        return new MenuListItem("Austria Driver's License", new Runnable() {
            @Override
            public void run() {
                AustriaDlFrontRecognizer austriaDlFrontRecognizer = new AustriaDlFrontRecognizer();
                ImageSettings.enableAllImages(austriaDlFrontRecognizer);
                scanAction(new DocumentUISettings(prepareRecognizerBundle(austriaDlFrontRecognizer)));
            }
        });
    }

    private MenuListItem buildAustralianDLElement() {
        return new MenuListItem("Australian Driver's License", new Runnable() {
            @Override
            public void run() {
                AustraliaDlFrontRecognizer australiaDlFront = new AustraliaDlFrontRecognizer();
                ImageSettings.enableAllImages(australiaDlFront);

                AustraliaDlBackRecognizer australiaDlBack = new AustraliaDlBackRecognizer();
                ImageSettings.enableAllImages(australiaDlBack);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(australiaDlFront, australiaDlBack)));
            }
        });
    }

    private MenuListItem buildIrelandDLElement() {
        return new MenuListItem("Ireland Driver's License", new Runnable() {
            @Override
            public void run() {
                IrelandDlFrontRecognizer irelandDlFront = new IrelandDlFrontRecognizer();
                ImageSettings.enableAllImages(irelandDlFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(irelandDlFront)));
            }
        });
    }

    private MenuListItem buildItalyDlElement(){
        return new MenuListItem("Italy Driver's License", new Runnable() {
            @Override
            public void run() {
                ItalyDlFrontRecognizer italyDlFrontRecognizer = new ItalyDlFrontRecognizer();
                ImageSettings.enableAllImages(italyDlFrontRecognizer);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(italyDlFrontRecognizer)));
            }
        });
    }

    private MenuListItem buildColombiaDLElement() {
        return new MenuListItem("Colombia Driver's License", new Runnable() {
            @Override
            public void run() {
                ColombiaDlFrontRecognizer colombiaDlFront = new ColombiaDlFrontRecognizer();
                ImageSettings.enableAllImages(colombiaDlFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(colombiaDlFront)));
            }
        });
    }

    private MenuListItem buildMalaysianDLElement() {
        return new MenuListItem("Malaysian Driver's License", new Runnable() {
            @Override
            public void run() {
                MalaysiaDlFrontRecognizer malaysiaDlFront = new MalaysiaDlFrontRecognizer();
                ImageSettings.enableAllImages(malaysiaDlFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(malaysiaDlFront)));
            }
        });
    }

    private MenuListItem buildNewZealandDLElement() {
        return new MenuListItem("New Zealand Driver's License", new Runnable() {
            @Override
            public void run() {
                NewZealandDlFrontRecognizer newZealandDlFront = new NewZealandDlFrontRecognizer();
                ImageSettings.enableAllImages(newZealandDlFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(newZealandDlFront)));
            }
        });
    }

    private MenuListItem buildSingaporeDLElement() {
        return new MenuListItem("Singapore Driver's License", new Runnable() {
            @Override
            public void run() {
                SingaporeDlFrontRecognizer singaporeDlFrontRecognizer = new SingaporeDlFrontRecognizer();
                ImageSettings.enableAllImages(singaporeDlFrontRecognizer);
                scanAction(new DocumentUISettings(prepareRecognizerBundle(singaporeDlFrontRecognizer)));
            }
        });
    }

    private MenuListItem buildSpainDLElement() {
        return new MenuListItem("Spain Driver's License", new Runnable() {
            @Override
            public void run() {
                SpainDlFrontRecognizer spainDlFrontRecognizer = new SpainDlFrontRecognizer();
                ImageSettings.enableAllImages(spainDlFrontRecognizer);
                scanAction(new DocumentUISettings(prepareRecognizerBundle(spainDlFrontRecognizer)));
            }
        });
    }

    private MenuListItem buildSwedenDLElement() {
        return new MenuListItem("Sweden Driver's License", new Runnable() {
            @Override
            public void run() {
                SwedenDlFrontRecognizer sweDL = new SwedenDlFrontRecognizer();
                ImageSettings.enableAllImages(sweDL);

                sweDL.setExtractLicenceCategories(true);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(sweDL)));
            }
        });
    }

    private MenuListItem buildSwissDLElement() {
        return new MenuListItem("Swiss Driver's License", new Runnable() {
            @Override
            public void run() {
                SwitzerlandDlFrontRecognizer switzerlandDl = new SwitzerlandDlFrontRecognizer();
                ImageSettings.enableAllImages(switzerlandDl);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(switzerlandDl)));
            }
        });
    }

    private MenuListItem buildUnitedArabEmiratesDLElement() {
        return new MenuListItem("United Arab Emirates Driver's License", new Runnable() {
            @Override
            public void run() {
                UnitedArabEmiratesDlFrontRecognizer uaeDlFront = new UnitedArabEmiratesDlFrontRecognizer();
                ImageSettings.enableAllImages(uaeDlFront);

                scanAction(new DocumentUISettings(prepareRecognizerBundle(uaeDlFront)));
            }
        });
    }

    private MenuListItem buildUsdlElement() {
        return new MenuListItem("US Driver's License", new Runnable() {
            @Override
            public void run() {
                UsdlRecognizer usdl = new UsdlRecognizer();

                scanAction(new DocumentUISettings(prepareRecognizerBundle(usdl)));
            }
        });
    }

    private MenuListItem buildAustrianIDCombinedElement() {
        return new MenuListItem("Austrian Combined", new Runnable() {
            @Override
            public void run() {
                AustriaCombinedRecognizer austriaCombined = new AustriaCombinedRecognizer();
                ImageSettings.enableAllImages(austriaCombined);
                combinedRecognitionAction(austriaCombined);
            }
        });
    }

    private MenuListItem buildCroatianIDCombinedElement() {
        return new MenuListItem("Croatian Combined", new Runnable() {
            @Override
            public void run() {
                CroatiaCombinedRecognizer croatiaCombined = new CroatiaCombinedRecognizer();
                ImageSettings.enableAllImages(croatiaCombined);

                combinedRecognitionAction(croatiaCombined);
            }
        });
    }

    private MenuListItem buildCzechIDCombinedElement() {
        return new MenuListItem("Czech Combined", new Runnable() {
            @Override
            public void run() {
                CzechiaCombinedRecognizer czechiaCombined = new CzechiaCombinedRecognizer();
                ImageSettings.enableAllImages(czechiaCombined);

                combinedRecognitionAction(czechiaCombined);
            }
        });
    }

    private MenuListItem buildGermanIDCombinedElement() {
        return new MenuListItem("German Combined", new Runnable() {
            @Override
            public void run() {
                GermanyCombinedRecognizer germanyCombined = new GermanyCombinedRecognizer();
                ImageSettings.enableAllImages(germanyCombined);

                combinedRecognitionAction(germanyCombined);
            }
        });
    }

    private MenuListItem buildJordanIdCombinedElement() {
        return new MenuListItem("Jordan Combined", new Runnable() {
            @Override
            public void run() {
                JordanCombinedRecognizer jordanCombined = new JordanCombinedRecognizer();
                ImageSettings.enableAllImages(jordanCombined);

                combinedRecognitionAction(jordanCombined);
            }
        });
    }

    private MenuListItem buildPaymentCardCombinedElement() {
        return new MenuListItem("Payment Card Combined", new Runnable() {
            @Override
            public void run() {
                PaymentCardCombinedRecognizer paymentCardCombined = new PaymentCardCombinedRecognizer();
                ImageSettings.enableAllImages(paymentCardCombined);

                combinedRecognitionAction(paymentCardCombined);
            }
        });
    }

    private MenuListItem buildElitePaymentCardCombinedElement() {
        return new MenuListItem("Elite Payment Card Combined", new Runnable() {
            @Override
            public void run() {
                ElitePaymentCardCombinedRecognizer paymentCardCombined = new ElitePaymentCardCombinedRecognizer();
                ImageSettings.enableAllImages(paymentCardCombined);

                combinedRecognitionAction(paymentCardCombined);
            }
        });
    }

    private MenuListItem buildPolishIdCombinedElement() {
        return new MenuListItem("Polish Combined", new Runnable() {
            @Override
            public void run() {
                PolandCombinedRecognizer polandCombined = new PolandCombinedRecognizer();
                ImageSettings.enableAllImages(polandCombined);

                combinedRecognitionAction(polandCombined);
            }
        });
    }

    private MenuListItem buildSerbianIDCombinedElement() {
        return new MenuListItem("Serbian Combined", new Runnable() {
            @Override
            public void run() {
                SerbiaCombinedRecognizer serbiaCombined = new SerbiaCombinedRecognizer();
                ImageSettings.enableAllImages(serbiaCombined);

                combinedRecognitionAction(serbiaCombined);
            }
        });
    }

    private MenuListItem buildSlovenianIDCombinedElement() {
        return new MenuListItem("Slovenian Combined", new Runnable() {
            @Override
            public void run() {
                SloveniaCombinedRecognizer sloveniaCombined = new SloveniaCombinedRecognizer();
                ImageSettings.enableAllImages(sloveniaCombined);

                combinedRecognitionAction(sloveniaCombined);
            }
        });
    }

    private MenuListItem buildSlovakIDCombinedElement() {
        return new MenuListItem("Slovak Combined", new Runnable() {
            @Override
            public void run() {
                SlovakiaCombinedRecognizer slovakiaCombined = new SlovakiaCombinedRecognizer();
                ImageSettings.enableAllImages(slovakiaCombined);

                combinedRecognitionAction(slovakiaCombined);
            }
        });
    }

    private MenuListItem buildSingaporeIDCombinedElement() {
        return new MenuListItem("Singapore Combined", new Runnable() {
            @Override
            public void run() {
                SingaporeCombinedRecognizer singaporeCombined = new SingaporeCombinedRecognizer();
                ImageSettings.enableAllImages(singaporeCombined);

                combinedRecognitionAction(singaporeCombined);
            }
        });
    }

    private MenuListItem buildUsdlCombinedElement() {
        return new MenuListItem("US Driver's License combined", new Runnable() {
            @Override
            public void run() {
                UsdlCombinedRecognizer usdlCombined = new UsdlCombinedRecognizer();
                ImageSettings.enableAllImages(usdlCombined);

                combinedRecognitionAction(usdlCombined);
            }
        });
    }

    private MenuListItem buildPDF417Element() {
        return new MenuListItem("PDF417 barcode", new Runnable() {
            @Override
            public void run() {
                Pdf417Recognizer pdf417Recognizer = new Pdf417Recognizer();

                BarcodeUISettings activitySettings = new BarcodeUISettings(prepareRecognizerBundle(pdf417Recognizer));
                activitySettings.setShowDialogAfterScan(false);

                scanAction(activitySettings);
            }
        });
    }

    private MenuListItem buildBarcodeElement() {
        return new MenuListItem("Blink barcode", new Runnable() {
            @Override
            public void run() {
                BarcodeRecognizer barcode = new BarcodeRecognizer();
                barcode.setScanCode39(true);
                barcode.setScanCode128(true);
                barcode.setScanInverse(true);
                barcode.setScanAztecCode(true);
                barcode.setScanDataMatrix(true);
                barcode.setScanEan13(true);
                barcode.setScanEan8(true);
                barcode.setScanItf(true);
                barcode.setScanPdf417(true);
                barcode.setScanQrCode(true);
                barcode.setScanUpca(true);
                barcode.setScanUpce(true);

                BarcodeUISettings activitySettings = new BarcodeUISettings(prepareRecognizerBundle(barcode));
                activitySettings.setShowDialogAfterScan(false);

                scanAction(activitySettings);
            }
        });
    }

    private MenuListItem buildSimNumberElement() {
        return new MenuListItem("Sim number barcode", new Runnable() {
            @Override
            public void run() {
                SimNumberRecognizer simNumberRecognizer = new SimNumberRecognizer();

                BarcodeUISettings activitySettings = new BarcodeUISettings(prepareRecognizerBundle(simNumberRecognizer));
                activitySettings.setShowDialogAfterScan(false);

                scanAction(activitySettings);
            }
        });
    }

    private MenuListItem buildVinElement() {
        return new MenuListItem("VIN barcode", new Runnable() {
            @Override
            public void run() {
                VinRecognizer vinRecognizer = new VinRecognizer();

                BarcodeUISettings activitySettings = new BarcodeUISettings(prepareRecognizerBundle(vinRecognizer));
                activitySettings.setShowDialogAfterScan(false);

                scanAction(activitySettings);
            }
        });
    }

    private MenuListItem buildGenericFieldByFieldElement() {
        return new MenuListItem("Generic field by field scan", new Runnable() {
            @Override
            public void run() {
                FieldByFieldBundle bundle = new FieldByFieldBundle(
                        new FieldByFieldElement(R.string.email_title, R.string.email_msg, new EMailParser()),
                        new FieldByFieldElement(R.string.date_title, R.string.date_msg, new DateParser()),
                        new FieldByFieldElement(R.string.raw_title, R.string.raw_msg, new RawParser())
                );
                FieldByFieldUISettings settings = new FieldByFieldUISettings(bundle);

                scanAction(settings, createHelpIntent());
            }
        });
    }

    private MenuListItem buildVehicleFieldByFieldElement() {
        return new MenuListItem("Vehicle field by field scan", new Runnable() {
            @Override
            public void run() {
                FieldByFieldBundle bundle = new FieldByFieldBundle(
                        new FieldByFieldElement("VIN", "Position VIN in this frame", new VinParser()),
                        new FieldByFieldElement("License Plate", "Position license plate in this frame", new LicensePlatesParser())
                );
                FieldByFieldUISettings settings = new FieldByFieldUISettings(bundle);

                scanAction(settings, createHelpIntent());
            }
        });
    }

    private Intent createHelpIntent() {
        return new Intent(this, HelpActivity.class);
    }

    private RecognizerBundle prepareRecognizerBundle(@NonNull Recognizer<?,?>... recognizers ) {
        return new RecognizerBundle(recognizers);
    }

}