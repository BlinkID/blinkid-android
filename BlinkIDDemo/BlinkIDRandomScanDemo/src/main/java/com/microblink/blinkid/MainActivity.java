package com.microblink.blinkid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.microblink.Config;
import com.microblink.activity.RandomScanActivity;
import com.microblink.ocr.RandomScanElement;
import com.microblink.recognizers.blinkocr.parser.generic.AmountParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.DateParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.EMailParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.IbanParserSettings;

public class MainActivity extends Activity {

    private static final int SINGLE_GROUP_REQ_CODE = 123;
    private static final int MULTIPLE_GROUPS_REQ_CODE = 234;

    private static final String DATE_PARSER_NAME = "Date";
    private static final String AMOUNT_PARSER_NAME = "Amount";
    private static final String IBAN_PARSER_NAME = "IBAN";
    private static final String EMAIL_PARSER_NAME = "Email";



    private static final String PARSER_GROUP_PAYMENT = "PG_PAYMENT";
    private static final String PARSER_GROUP_EMAIL = "PG_EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called as handler for "Single parser group" button.
     */
    public void onScanSingleGroup(View view) {
        /**
         * In this simple example we will use BlinkID SDK to create a simple app
         * that scans an amount, IBAN and date from invoice. We will use provided RandomScanActivity
         * to perform scan. In this case all parsers can be placed in the same parser group, so we will use
         * default settings (if parser groups are not defined, all parsers will be placed in the same
         * parser group)
         */

        Intent intent = new Intent(this, RandomScanActivity.class);

        // In order for scanning to work, you must enter a valid licence key. Without licence key,
        // scanning will not work. Licence key is bound the the package name of your app, so when
        // obtaining your licence key from Microblink make sure you give us the correct package name
        // of your app. You can obtain your licence key at http://microblink.com/login or contact us
        // at http://help.microblink.com.
        // Licence key also defines which recognizers are enabled and which are not. Since the licence
        // key validation is performed on image processing thread in native code, all enabled recognizers
        // that are disallowed by licence key will be turned off without any error and information
        // about turning them off will be logged to ADB logcat.
        intent.putExtra(RandomScanActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);

        // we need to scan 3 fields, so we will add 3 random scan elements to elements array
        RandomScanElement date = new RandomScanElement(R.string.date_title, DATE_PARSER_NAME, new DateParserSettings());
        // element can be optional, which means that result can be returned without scannig that element
        date.setOptional(true);
        RandomScanElement[] elemsArray = new RandomScanElement[] {
                // Each scan element holds following scan settings:
                // resource ID (or string) for title displayed in RandomScanActivity activity,
                // name of the scan element (used for obtaining results, must be unique)
                // and parser setting defining how the data will be extracted.
                // In random scan, all scan elements must have distinct parser types.
                new RandomScanElement(R.string.iban_title, IBAN_PARSER_NAME, new IbanParserSettings()),
                new RandomScanElement(R.string.amount_title, AMOUNT_PARSER_NAME, new AmountParserSettings()),
                date};

        // pass prepared array of scan elements
        intent.putExtra(RandomScanActivity.EXTRAS_SCAN_CONFIGURATION, elemsArray);

        // with this extra you can set the resource ID of the sound to be played when the scan
        // element is recognized
        intent.putExtra(RandomScanActivity.EXTRAS_BEEP_RESOURCE, R.raw.beep);

        // Set the intent which will be started when user taps help button.
//        intent.putExtra(RandomScanActivity.EXTRAS_HELP_INTENT, new Intent(this, HelpActivity.class));

        // It is possible to  to change default scan message that is displayed above
        // the scanning window. You can use the following code snippet to set scan message string
//        intent.putExtra(RandomScanActivity.EXTRAS_SCAN_MESSAGE, "Your custom scan message");

        // once intent is prepared, we start the RandomScanActivity which will preform scan and return results
        // by calling onActivityResult
        startActivityForResult(intent, SINGLE_GROUP_REQ_CODE);
    }

    /**
     * Called as handler for "Multiple parser groups" button.
     */
    public void onScanMultipleGroups(View view) {
        /**
         * This example is similar to "Single parser group" example. Email element is added
         * which causes that some parsers are unable to parse valid element data if all parsers
         * are placed in the same parser group. Because of this, we will put parsers in the two parser
         * groups and scanning will be slower because OCR of image will be performed for each parser
         * group.
         */
        Intent intent = new Intent(this, RandomScanActivity.class);

        intent.putExtra(RandomScanActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);

        // we will put parsers in two parser groups
        // PAYMENT: IBAN, amount and date parsers
        // EMAIL: email parser

        RandomScanElement iban = new RandomScanElement(R.string.iban_title, IBAN_PARSER_NAME, new IbanParserSettings());
        // set parser group for iban element parser
        iban.setParserGroup(PARSER_GROUP_PAYMENT);

        RandomScanElement amount = new RandomScanElement(R.string.amount_title, AMOUNT_PARSER_NAME, new AmountParserSettings());
        // set parser group for amount element parser
        amount.setParserGroup(PARSER_GROUP_PAYMENT);

        RandomScanElement date = new RandomScanElement(R.string.date_title, DATE_PARSER_NAME, new DateParserSettings());
        // set date to be optional
        date.setOptional(true);
        // set parser group for date element parser
        date.setParserGroup(PARSER_GROUP_PAYMENT);

        RandomScanElement email = new RandomScanElement(R.string.email_title, EMAIL_PARSER_NAME, new EMailParserSettings());
        // set parser group for email element parser
        email.setParserGroup(PARSER_GROUP_EMAIL);
        // set email to be optional, which means that result can be returned without scanning that element
        email.setOptional(true);

        RandomScanElement[] elemsArray = new RandomScanElement[] {
                iban, amount, date, email};

        // pass prepared array of scan elements
        intent.putExtra(RandomScanActivity.EXTRAS_SCAN_CONFIGURATION, elemsArray);

        // with this extra you can set the resource ID of the sound to be played when the scan
        // element is recognized
        intent.putExtra(RandomScanActivity.EXTRAS_BEEP_RESOURCE, R.raw.beep);


        // once intent is prepared, we start the RandomScanActivity which will preform scan and return results
        // by calling onActivityResult
        startActivityForResult(intent, MULTIPLE_GROUPS_REQ_CODE);
    }

    /**
     * This method is called whenever control is returned from activity started with
     * startActivityForResult.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // first we need to check that we have indeed returned from RandomScanActivity with
        // success
        if (resultCode == RandomScanActivity.RESULT_OK) {
            // now we can obtain bundle with scan results
            Bundle result = data.getBundleExtra(RandomScanActivity.EXTRAS_SCAN_RESULTS);
            switch (requestCode) {
                case SINGLE_GROUP_REQ_CODE:
                    // each result is stored under key equal to the name of the scan element that generated it
                    StringBuilder sb = new StringBuilder();
                    sb.append("IBAN: ").append(result.getString(IBAN_PARSER_NAME));
                    sb.append("\nAmount: ").append(result.getString(AMOUNT_PARSER_NAME));
                    // date is optional element, maybe it is not scanned
                    String date = result.getString(DATE_PARSER_NAME);
                    if (date != null) {
                        sb.append("\nDate: ").append(date);
                    }

                    Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
                    break;
                case MULTIPLE_GROUPS_REQ_CODE:
                    // each result is stored under key equal to the name of the scan element that generated it
                    sb = new StringBuilder();
                    sb.append("IBAN: ").append(result.getString(IBAN_PARSER_NAME));
                    sb.append("\nAmount: ").append(result.getString(AMOUNT_PARSER_NAME));
                    // date is optional element, maybe it is not scanned
                    date = result.getString(DATE_PARSER_NAME);
                    if (date != null) {
                        sb.append("\nDate: ").append(date);
                    }
                    // email is optional element, maybe it is not scanned
                    String email = result.getString(EMAIL_PARSER_NAME);
                    if (email != null) {
                        sb.append("\nEmail: ").append(email);
                    }

                    Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
