package com.microblink.blinkid;

import com.microblink.ocr.ScanConfiguration;
import com.microblink.recognizers.blinkocr.parser.generic.DateParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.EMailParserSettings;
import com.microblink.recognizers.blinkocr.parser.generic.RawParserSettings;

/**
 * Created by dodo on 03/03/15.
 */
public class Configurator {
    public static ScanConfiguration[] createScanConfigurations() {
        // here we will create scan configuration for E-Mail and Raw text
        // in Raw text parser we will enable Sieve algorithm which will
        // reuse OCR results from multiple video frames to improve quality

        RawParserSettings rawSett = new RawParserSettings();
        rawSett.setUseSieve(false);

        return new ScanConfiguration[] {
                // each scan configuration contains two string resource IDs: string shown in title bar and string shown
                // in text field above scan box. Besides that, it contains name of the result and settings object
                // which defines what will be scanned.
                new ScanConfiguration(R.string.date_title, R.string.date_msg, "Date", new DateParserSettings()),
                new ScanConfiguration(R.string.email_title, R.string.email_msg, "EMail", new EMailParserSettings()),
                new ScanConfiguration(R.string.raw_title, R.string.raw_msg, "Raw", rawSett)
        };
    }
}
