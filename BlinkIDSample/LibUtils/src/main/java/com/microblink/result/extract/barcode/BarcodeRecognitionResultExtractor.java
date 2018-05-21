package com.microblink.result.extract.barcode;

import android.content.Context;

import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof BarcodeRecognizer) {
            // result is obtained from scanning PDF417 barcode
            BarcodeRecognizer.Result barcodeResult = ((BarcodeRecognizer) result).getResult();

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeType,
                    barcodeResult.getBarcodeFormat().name()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPUncertain,
                    barcodeResult.isUncertain()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeData,
                    barcodeResult.getStringData()
            ));

            byte[] rawDataBytes = barcodeResult.getRawData();
            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeRawData,
                    Arrays.toString(rawDataBytes)
            ));
        }

        return mExtractedData;
    }
}
