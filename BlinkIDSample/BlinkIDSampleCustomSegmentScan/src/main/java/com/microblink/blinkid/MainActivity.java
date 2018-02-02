package com.microblink.blinkid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.microblink.Config;
import com.microblink.activity.SegmentScanActivity;
import com.microblink.help.HelpActivity;
import com.microblink.ocr.ScanConfiguration;
import com.microblink.recognizers.blinkocr.engine.BlinkOCREngineOptions;
import com.microblink.recognizers.blinkocr.parser.generic.AmountParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.IbanParserSettings;
import com.microblink.recognizers.blinkocr.parser.regex.RegexParserSettings;
import com.microblink.results.ocr.OcrFont;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final int SIMPLE_INTEGRATION_REQUEST_CODE = 100;
    private static final int BLINK_OCR_VIN_REQUEST_CODE = 101;

    private static final String PARSER_NAME_VIN = "VIN";

    /**
     * List view elements.
     */
    private ListElement[] mElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // build list elements
        mElements = buildListElements();
        ListView lv = (ListView) findViewById(R.id.detectorList);
        ArrayAdapter<ListElement> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mElements);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mElements[position].getTitle().equals(getString(R.string.simple_integration))) {
                    startActivityForResult(mElements[position].getScanIntent(), SIMPLE_INTEGRATION_REQUEST_CODE);
                } else if (mElements[position].getTitle().equals(getString(R.string.regex_example))) {
                    startActivityForResult(mElements[position].getScanIntent(), BLINK_OCR_VIN_REQUEST_CODE);
                } else {
                    startActivity(mElements[position].getScanIntent());
                }
            }
        });
    }

    /**
     * This method is used to build the array of {@link ListElement} objects.
     *
     * @return Array of {@link ListElement} objects. Each {@link ListElement}
     * object will have its title that will be shown in ListView and prepared intent
     * that can be used to start the appropriate activity.
     */
    private ListElement[] buildListElements() {
        ArrayList<ListElement> elements = new ArrayList<>();

        elements.add(buildSimpleIntegrationElement());
        elements.add(buildRegexExampleElement());
        elements.add(buildAdvancedIntegrationElement());
        elements.add(buildFullScreenOCRElement());

        ListElement[] elemsArray = new ListElement[elements.size()];
        return elements.toArray(elemsArray);
    }

    /**
     * Builds the {@link ListElement} with corresponding title and intent that can be
     * used to start the {@link FullScreenOCR} activity for Full Screen OCR example.
     *
     * @return Built list element.
     */
    public ListElement buildFullScreenOCRElement() {
        // example of how to use full screen OCR is demonstrated in FullScreenOCR activity
        Intent intent = new Intent(this, FullScreenOCR.class);
        return new ListElement(getString(R.string.ocr_fullScreen), intent);
    }

    /**
     * Builds the {@link ListElement} with corresponding title and intent that can be
     * used to start the {@link ScanActivity} activity for Custom UI example.
     *
     * @return Built list element.
     */
    public ListElement buildAdvancedIntegrationElement() {
        // advanced integration example is given in ScanActivity source code
        Intent intent = new Intent(this, ScanActivity.class);
        return new ListElement(getString(R.string.customUI), intent);
    }

    /**
     * Builds the {@link ListElement} with corresponding title and intent that can be
     * used to start the {@link SegmentScanActivity} activity for Simple Integration example.
     *
     * @return Built list element.
     */
    public ListElement buildSimpleIntegrationElement() {
        /**
         * In this simple example we will use BlinkOCR SDK to create a simple example
         * that scans an amount from invoice, tax amount from invoice and IBAN
         * to which amount has to be paid.
         */

        Intent intent = new Intent(this, SegmentScanActivity.class);
        // license key is required for recognizer to work.
        intent.putExtra(SegmentScanActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);

        // we need to scan 3 items, so we will add 3 scan configurations to scan configuration array
        ScanConfiguration conf[] = new ScanConfiguration[]{
                // each scan configuration contains two string resource IDs: string shown in title bar and string shown
                // in text field above scan box. Besides that, it contains name of the result and settings object
                // which defines what will be scanned.
                new ScanConfiguration(R.string.amount_title, R.string.amount_msg, "TotalAmount", new AmountParserSettings()),
                new ScanConfiguration(R.string.tax_title, R.string.tax_msg, "Tax", new AmountParserSettings()),
                new ScanConfiguration(R.string.iban_title, R.string.iban_msg, "IBAN", new IbanParserSettings())
        };

        intent.putExtra(SegmentScanActivity.EXTRAS_SCAN_CONFIGURATION, conf);

        // optionally, if we want the help screen to be available to user on camera screen,
        // we can simply prepare an intent for help activity and pass it to BlinkOCRActivity
        Intent helpIntent = new Intent(this, HelpActivity.class);
        intent.putExtra(SegmentScanActivity.EXTRAS_HELP_INTENT, helpIntent);

        return new ListElement(getString(R.string.simple_integration), intent);
    }

    /**
     * Builds the {@link ListElement} with corresponding title and intent that can be
     * used to start the {@link SegmentScanActivity} activity for Regex Parser example.
     *
     * @return Built list element.
     */
    public ListElement buildRegexExampleElement() {
        /*
         * In this example we will use default BlinkOCRActivity to drive the recognition,
         * but here we will show how to setup a Regex parser. Regex parser allows configuring
         * custom regular expression which should be extracted from OCR result.
         *
         * In this example we will show how to setup Regex parser to scan Vehicle Identification Numbers
         * (VINs) also known as Chassis numbers of a car. The VIN is 17-character string constisting
         * of digits and uppercase letters.
         */

        // same as in simple integration example, we will invoke scanning on BlinkOCRActivity,
        // so we need to setup an Intent for it.
        Intent intent = new Intent(this, SegmentScanActivity.class);
        // license key is required for recognizer to work.
        intent.putExtra(SegmentScanActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);

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
        RegexParserSettings regexParserSettings = new RegexParserSettings("[A-Z0-9]{17}", engineOptions);

        // same as in simple integration, create a scan configuration array
        ScanConfiguration conf[] = new ScanConfiguration[]{
                new ScanConfiguration(R.string.vin_title, R.string.vin_msg, PARSER_NAME_VIN, regexParserSettings)
        };

        intent.putExtra(SegmentScanActivity.EXTRAS_SCAN_CONFIGURATION, conf);

        // optionally, if we want the help screen to be available to user on camera screen,
        // we can simply prepare an intent for help activity and pass it to BlinkOCRActivity
        Intent helpIntent = new Intent(this, HelpActivity.class);
        intent.putExtra(SegmentScanActivity.EXTRAS_HELP_INTENT, helpIntent);

        return new ListElement(getString(R.string.regex_example), intent);

    }

    /**
     * This method is called whenever control is returned from activity started with
     * startActivityForResult.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // first we need to check that we have indeed returned from BlinkOCRActivity with
        // success
        if (resultCode == SegmentScanActivity.RESULT_OK) {
            // now we can obtain bundle with scan results
            Bundle result = data.getBundleExtra(SegmentScanActivity.EXTRAS_SCAN_RESULTS);
            switch (requestCode) {
                case SIMPLE_INTEGRATION_REQUEST_CODE:
                    // each result is stored under key equal to the name of the scan configuration
                    // that generated it
                    String totalAmount = result.getString("TotalAmount");
                    String taxAmount = result.getString("Tax");
                    String iban = result.getString("IBAN");
                    Toast.makeText(this, "To IBAN: " + iban + " we will pay total "
                            + totalAmount + ", tax: " + taxAmount, Toast.LENGTH_LONG).show();
                    break;
                case BLINK_OCR_VIN_REQUEST_CODE:
                    String vin = result.getString(PARSER_NAME_VIN);
                    Toast.makeText(this, "Vehicle identification number is: " + vin,
                            Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    /**
     * Element of {@link ArrayAdapter} for {@link ListView} that holds information about title
     * which should be displayed in list and {@link Intent} that should be started on click.
     */
    private class ListElement {
        private String mTitle;
        private Intent mScanIntent;

        public String getTitle() {
            return mTitle;
        }

        public Intent getScanIntent() {
            return mScanIntent;
        }

        public ListElement(String title, Intent scanIntent) {
            mTitle = title;
            mScanIntent = scanIntent;
        }

        /**
         * Used by array adapter to determine list element text
         */
        @Override
        public String toString() {
            return getTitle();
        }
    }
}
