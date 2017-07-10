package com.microblink.libresult.extract.barcode;

import android.content.Context;


import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkbarcode.BarcodeType;
import com.microblink.recognizers.blinkbarcode.barcode.BarcodeScanResult;

import java.util.ArrayList;
import java.util.List;

public class BarcodeRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;

    public BarcodeRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    /**
     * Returns list with extracted entries.
     *
     * @param result BaseRecognitionResult
     * @return list with extracted entries
     */
    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof BarcodeScanResult) {
            // result is obtained from scanning PDF417 barcode
            BarcodeScanResult barcodeResult = (BarcodeScanResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeType,
                    barcodeResult.getBarcodeType() != null ? barcodeResult.getBarcodeType().name() : "null"
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeData,
                    barcodeResult.getStringData()
            ));

            if (barcodeResult.getBarcodeType() == BarcodeType.CODE39) {
                // special case for code39 barcodes that can have special extended encoding
                mExtractedData.add(mBuilder.build(
                        R.string.PPExtendedBarcodeData,
                        barcodeResult.getExtendedStringData()
                ));
            }
        }

        return mExtractedData;
    }
}
