package com.microblink.result.extract.pdf417mobi;

import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

import java.util.Arrays;

public class BarcodeRecognitionResultExtractor extends BaseResultExtractor<BarcodeRecognizer.Result, BarcodeRecognizer> {

    @Override
    protected void extractData(BarcodeRecognizer.Result result) {
        add(R.string.PPBarcodeType, result.getBarcodeType().name());
        add(R.string.PPUncertain, result.isUncertain());
        add(R.string.PPBarcodeData, result.getStringData());
        byte[] rawDataBytes = result.getRawData();
        add(R.string.PPBarcodeRawData, Arrays.toString(rawDataBytes));
    }

}
