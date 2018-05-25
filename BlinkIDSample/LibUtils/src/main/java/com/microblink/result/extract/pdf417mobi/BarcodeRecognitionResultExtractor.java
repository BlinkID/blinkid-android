package com.microblink.result.extract.pdf417mobi;

import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

import java.util.Arrays;

public class BarcodeRecognitionResultExtractor extends BaseResultExtractor<BarcodeRecognizer.Result, BarcodeRecognizer> {

    @Override
    protected void extractData(BarcodeRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPBarcodeType,
                result.getBarcodeFormat().name()
        ));

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
