package com.microblink.result.extract.pdf417mobi;

import com.microblink.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

import java.util.Arrays;

public class Pdf417RecognitionResultExtractor extends BaseResultExtractor<Pdf417Recognizer.Result, Pdf417Recognizer> {

    @Override
    protected void extractData(Pdf417Recognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPUncertain,
                result.isUncertain()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPBarcodeData,
                result.getStringData()
        ));

        byte[] rawDataBytes = result.getRawData();
        mExtractedData.add(mBuilder.build(
                R.string.PPBarcodeRawData,
                Arrays.toString(rawDataBytes)
        ));
    }

}
