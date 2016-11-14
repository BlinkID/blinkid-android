package com.microblink.libresult.extract.barcode;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkbarcode.BarcodeType;
import com.microblink.recognizers.blinkbarcode.bardecoder.BarDecoderScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class BardecoderRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;

    public BardecoderRecognitionResultExtractor(Context context) {
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

        if (result instanceof BarDecoderScanResult) {
            // result is obtained from scanning PDF417 barcode
            BarDecoderScanResult barcodeResult = (BarDecoderScanResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeType,
                    barcodeResult.getBarcodeType().name()
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
