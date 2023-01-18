package com.microblink.blinkid;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.blinkid.entities.recognizers.Recognizer;
import com.microblink.blinkid.entities.recognizers.RecognizerBundle;
import com.microblink.blinkid.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.visa.VisaRecognizer;
import com.microblink.blinkid.menu.MenuListItem;
import com.microblink.blinkid.menu.ResultHandlerMenuActivity;
import com.microblink.blinkid.result.activity.RecognizerBundleResultActivity;
import com.microblink.blinkid.uisettings.ActivityRunner;
import com.microblink.blinkid.uisettings.BlinkIdUISettings;
import com.microblink.blinkid.uisettings.DocumentUISettings;
import com.microblink.blinkid.uisettings.LegacyDocumentVerificationUISettings;
import com.microblink.blinkid.uisettings.UISettings;
import com.microblink.blinkid.uisettings.options.BeepSoundUIOptions;
import com.microblink.blinkid.uisettings.options.OcrResultDisplayMode;
import com.microblink.blinkid.uisettings.options.OcrResultDisplayUIOptions;
import com.microblink.util.ImageSettings;
import com.microblink.blinkid.util.RecognizerCompatibility;
import com.microblink.blinkid.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MenuActivity extends ResultHandlerMenuActivity {

    public static final int MY_BLINKID_REQUEST_CODE = 123;

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean isScanRequestCode(int code) {
        return code == MY_BLINKID_REQUEST_CODE;
    }

    @Override
    protected Class<?> getResultActivityForRequestCode(int requestCode) {
        return RecognizerBundleResultActivity.class;
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

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

        items.add(buildBlinkIdSingleSideElement());
        items.add(buildBlinkIdMultiSideElement());
        items.add(buildPassportElement());
        items.add(buildVisaElement());

        items.add(buildMrtdElement());
        items.add(buildMrtdCombinedElement());
        items.add(buildDocumentFaceElement());

        items.add(buildIdBarcodeElement());
        items.add(buildUsdlElement());
        items.add(buildUsdlCombinedElement());

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
     * Starts {@link com.microblink.blinkid.activity.LegacyDocumentVerificationActivity} with given recognizer.
     * @param combinedRecognizer recognizer that will be used.
     */
    private void combinedRecognitionAction(Recognizer combinedRecognizer) {
        LegacyDocumentVerificationUISettings uiSettings = new LegacyDocumentVerificationUISettings(new RecognizerBundle(combinedRecognizer));
        uiSettings.setBeepSoundResourceID(R.raw.beep);

        ActivityRunner.startActivityForResult(this, MY_BLINKID_REQUEST_CODE, uiSettings);
    }

    private void setupActivitySettings(@NonNull UISettings settings, @Nullable Intent helpIntent) {
        if (settings instanceof BeepSoundUIOptions) {
            // optionally, if you want the beep sound to be played after a scan
            // add a sound resource id
            ((BeepSoundUIOptions) settings).setBeepSoundResourceID(R.raw.beep);
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
    }

    private MenuListItem buildBlinkIdSingleSideElement() {
        return new MenuListItem("BlinkId Single Side", () -> {
            BlinkIdSingleSideRecognizer blinkIdSingle = new BlinkIdSingleSideRecognizer();
            ImageSettings.enableAllImages(blinkIdSingle);
            scanAction(new BlinkIdUISettings(prepareRecognizerBundle(blinkIdSingle)));
        });
    }

    private MenuListItem buildBlinkIdMultiSideElement() {
        return new MenuListItem("BlinkId Multi Side", () -> {
            BlinkIdMultiSideRecognizer blinkIdMulti = new BlinkIdMultiSideRecognizer();
            ImageSettings.enableAllImages(blinkIdMulti);
            scanAction(new BlinkIdUISettings(prepareRecognizerBundle(blinkIdMulti)));
        });
    }

    private MenuListItem buildPassportElement() {
        return new MenuListItem("Passport", () -> {
            PassportRecognizer passportRecognizer = new PassportRecognizer();
            ImageSettings.enableAllImages(passportRecognizer);
            scanAction(new DocumentUISettings(prepareRecognizerBundle(passportRecognizer)));
        });
    }

    private MenuListItem buildVisaElement() {
        return new MenuListItem("Visa", () -> {
            VisaRecognizer visaRecognizer = new VisaRecognizer();
            ImageSettings.enableAllImages(visaRecognizer);
            scanAction(new DocumentUISettings(prepareRecognizerBundle(visaRecognizer)));
        });
    }

    private MenuListItem buildMrtdElement() {
        return new MenuListItem("Passport and ID", () -> {
            MrtdRecognizer mrtdRecognizer = new MrtdRecognizer();
            mrtdRecognizer.setAllowUnverifiedResults(true);
            ImageSettings.enableAllImages(mrtdRecognizer);
            scanAction(new DocumentUISettings(prepareRecognizerBundle(mrtdRecognizer)));
        });
    }

    private MenuListItem buildMrtdCombinedElement() {
        return new MenuListItem("Passport and ID Combined", () -> {
            MrtdCombinedRecognizer mrtdCombinedRecognizer = new MrtdCombinedRecognizer();
            ImageSettings.enableAllImages(mrtdCombinedRecognizer);
            combinedRecognitionAction(mrtdCombinedRecognizer);
        });
    }

    private MenuListItem buildDocumentFaceElement() {
        return new MenuListItem("Document Face", () -> {
            DocumentFaceRecognizer documentFaceRecognizer = new DocumentFaceRecognizer();
            ImageSettings.enableAllImages(documentFaceRecognizer);
            scanAction(new DocumentUISettings(prepareRecognizerBundle(documentFaceRecognizer)));
        });
    }

    private MenuListItem buildIdBarcodeElement() {
        return new MenuListItem("ID barcode", () -> {
            IdBarcodeRecognizer idBarcodeRecognizer = new IdBarcodeRecognizer();
            scanAction(new DocumentUISettings(prepareRecognizerBundle(idBarcodeRecognizer)));
        });
    }

    private MenuListItem buildUsdlElement() {
        return new MenuListItem("USDL", () -> {
            UsdlRecognizer usdlRecognizer = new UsdlRecognizer();
            ImageSettings.enableAllImages(usdlRecognizer);
            scanAction(new DocumentUISettings(prepareRecognizerBundle(usdlRecognizer)));
        });
    }

    private MenuListItem buildUsdlCombinedElement() {
        return new MenuListItem("USDL Combined", () -> {
            UsdlCombinedRecognizer usdlCombinedRecognizer = new UsdlCombinedRecognizer();
            ImageSettings.enableAllImages(usdlCombinedRecognizer);
            combinedRecognitionAction(usdlCombinedRecognizer);
        });
    }

    private RecognizerBundle prepareRecognizerBundle(@NonNull Recognizer<?>... recognizers ) {
        return new RecognizerBundle(recognizers);
    }

}