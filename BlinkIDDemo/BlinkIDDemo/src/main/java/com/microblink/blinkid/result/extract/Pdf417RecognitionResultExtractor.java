package com.microblink.blinkid.result.extract;

import android.content.Context;

import com.microblink.blinkid.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.barcode.pdf417.Pdf417ScanResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class Pdf417RecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private Context mContext;
    private List<RecognitionResultEntry> mExtractedData;

    public Pdf417RecognitionResultExtractor(Context mContext) {
        this.mContext = mContext;
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

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPUncertain),
                    Boolean.toString(pdf417Result.isUncertain())
            ));

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPBarcodeData),
                    pdf417Result.getStringData()
            ));

            byte[] rawDataBytes = pdf417Result.getRawData().getAllData();
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPBarcodeRawData),
                    Arrays.toString(rawDataBytes)
            ));
        }

        return mExtractedData;
    }
}
