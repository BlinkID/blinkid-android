package com.microblink.result.extract.barcode;

import android.content.Context;

import com.microblink.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

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
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof Pdf417Recognizer) {
            // result is obtained from scanning PDF417 barcode
            Pdf417Recognizer.Result pdf417Result = ((Pdf417Recognizer) result).getResult();

            mExtractedData.add(mBuilder.build(
                    R.string.PPUncertain,
                    pdf417Result.isUncertain()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeData,
                    pdf417Result.getStringData()
            ));

            byte[] rawDataBytes = pdf417Result.getRawData();
            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeRawData,
                    Arrays.toString(rawDataBytes)
            ));
        }

        return mExtractedData;
    }
}
