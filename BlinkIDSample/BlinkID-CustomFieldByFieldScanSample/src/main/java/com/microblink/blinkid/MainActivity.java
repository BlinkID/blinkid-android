package com.microblink.blinkid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.BaseMenuActivity;
import com.microblink.MenuListItem;
import com.microblink.activity.FieldByFieldScanActivity;
import com.microblink.entities.ocrengine.legacy.BlinkOCREngineOptions;
import com.microblink.entities.parsers.amount.AmountParser;
import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldBundle;
import com.microblink.entities.parsers.config.fieldbyfield.FieldByFieldElement;
import com.microblink.entities.parsers.iban.IbanParser;
import com.microblink.entities.parsers.regex.RegexParser;
import com.microblink.help.HelpActivity;
import com.microblink.results.ocr.OcrFont;
import com.microblink.uisettings.ActivityRunner;
import com.microblink.uisettings.FieldByFieldUISettings;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMenuActivity {

    private static final int SIMPLE_INTEGRATION_REQUEST_CODE = 100;
    private static final int BLINK_OCR_VIN_REQUEST_CODE = 101;

    // reference to bundle is kept, it is used later for loading results from intent
    // parsers are member variables because they will be used for obtaining results
    private FieldByFieldBundle mVinFieldByFieldBundle;
    private RegexParser mVinParser;

    private FieldByFieldBundle mSimpleFieldByFieldBundle;
    private AmountParser mTotalAmountParser;
    private AmountParser mTaxParser;
    private IbanParser mIbanParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();
        items.add(buildSimpleIntegrationItem());
        items.add(buildRegexExampleElement());
        items.add(buildAdvancedIntegrationElement());
        items.add(buildFullScreenOCRElement());
        return items;
    }

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
    }


    // In this simple example we will use BlinkOCR SDK to create a simple example
    // that scans an amount from invoice, tax amount from invoice and IBAN to which amount has to be paid.
    private MenuListItem buildSimpleIntegrationItem() {
        mTotalAmountParser = new AmountParser();
        mTaxParser = new AmountParser();
        mIbanParser = new IbanParser();

        // we need to scan 3 items, so we will add 3 elements to bundle
        mSimpleFieldByFieldBundle= new FieldByFieldBundle(
                // each scan configuration contains two string resource IDs:
                // string shown in title bar and string shown in text field above scan box
                new FieldByFieldElement(R.string.amount_title, R.string.amount_msg, mTotalAmountParser),
                new FieldByFieldElement(R.string.tax_title, R.string.tax_msg, mTaxParser),
                new FieldByFieldElement(R.string.iban_title, R.string.iban_msg, mIbanParser)
        );

        final FieldByFieldUISettings uiSettings = new FieldByFieldUISettings(mSimpleFieldByFieldBundle);
        uiSettings.setHelpIntent(new Intent(this, HelpActivity.class));
        return new MenuListItem(getString(R.string.simple_integration), new Runnable() {
            @Override
            public void run() {
                ActivityRunner.startActivityForResult(MainActivity.this,
                        SIMPLE_INTEGRATION_REQUEST_CODE,
                        uiSettings);
            }
        });
    }

    /*
     * In this example we will use default BlinkOCRActivity to drive the recognition,
     * but here we will show how to setup a Regex parser. Regex parser allows configuring
     * custom regular expression which should be extracted from OCR result.
     *
     * In this example we will show how to setup Regex parser to scan Vehicle Identification Numbers
     * (VINs) also known as Chassis numbers of a car. The VIN is 17-character string consisting
     * of digits and uppercase letters.
     */
    private MenuListItem buildRegexExampleElement() {
        // now let's setup OCR engine parameters for scanning VIN:
        BlinkOCREngineOptions engineOptions = new BlinkOCREngineOptions();
        // only uppercase chars and digits are allowed. Don't waste time on classifying other characters as we
        // do not need them.
        engineOptions.addAllDigitsToWhitelist(OcrFont.OCR_FONT_ANY).addUppercaseCharsToWhitelist(OcrFont.OCR_FONT_ANY);
        // do not bother with text lines that are smaller than 40 pixels
        engineOptions.setMinimumLineHeight(40);
        // we expect the VIN to be black text, so we can drop all colors from image - this will give better accuracy
        // because coloured text will be automatically discarded.
        engineOptions.setColorDropoutEnabled(true);

        // now let's create a RegexParser
        mVinParser = new RegexParser("[A-Z0-9]{17}", engineOptions);

        // same as in simple integration, create field by field bundle
        mVinFieldByFieldBundle = new FieldByFieldBundle (
                new FieldByFieldElement(R.string.vin_title, R.string.vin_msg, mVinParser)
        );

        final FieldByFieldUISettings uiSettings = new FieldByFieldUISettings(mVinFieldByFieldBundle);
        return new MenuListItem(getString(R.string.regex_example), new Runnable() {
            @Override
            public void run() {
                ActivityRunner.startActivityForResult(MainActivity.this,
                        BLINK_OCR_VIN_REQUEST_CODE,
                        uiSettings);
            }
        });
    }

    // advanced integration example is given in ScanActivity source code
    private MenuListItem buildAdvancedIntegrationElement() {
        return new MenuListItem(getString(R.string.customUI), new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, ScanActivity.class));
            }
        });
    }

    // example of how to use full screen OCR is demonstrated in FullScreenOcrActivity activity
    private MenuListItem buildFullScreenOCRElement() {
        return new MenuListItem(getString(R.string.ocr_fullScreen), new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, FullScreenOcrActivity.class));
            }
        });
    }

    /*
     * This method is called whenever control is returned from activity started with
     * startActivityForResult.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // first we need to check that we have indeed returned from BlinkOCRActivity with success
        if (resultCode == FieldByFieldScanActivity.RESULT_OK) {
            switch (requestCode) {
                case SIMPLE_INTEGRATION_REQUEST_CODE:
                    // now we can load bundle with scan results, after loading, results will be available in parser instances
                    mSimpleFieldByFieldBundle.loadFromIntent(data);
                    // each field is available through its parser instance
                    String totalAmount = mTotalAmountParser.getResult().toString();
                    String taxAmount = mTaxParser.getResult().toString();
                    String iban = mIbanParser.getResult().toString();
                    Toast.makeText(
                            this,
                            String.format("To IBAN: %s we will pay total %s, tax: %s", iban, totalAmount, taxAmount),
                            Toast.LENGTH_LONG
                    ).show();
                    break;
                case BLINK_OCR_VIN_REQUEST_CODE:
                    mVinFieldByFieldBundle.loadFromIntent(data);
                    String vin = mVinParser.getResult().toString();
                    Toast.makeText(
                            this,
                            "Vehicle identification number is: " + vin,
                            Toast.LENGTH_LONG
                    ).show();
                    break;
            }
        }
    }

}
