package com.microblink.libresult.extract.barcode;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkbarcode.pdf417.Pdf417ScanResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class Pdf417RecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;

    public Pdf417RecognitionResultExtractor(Context context) {
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

        if (result instanceof Pdf417ScanResult) {
            // result is obtained from scanning PDF417 barcode
            Pdf417ScanResult pdf417Result = (Pdf417ScanResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPUncertain,
                    Boolean.toString(pdf417Result.isUncertain())
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeData,
                    pdf417Result.getStringData()
            ));

            byte[] rawDataBytes = pdf417Result.getRawData().getAllData();
            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeRawData,
                    Arrays.toString(rawDataBytes)
            ));
        }

        return mExtractedData;
    }
}
