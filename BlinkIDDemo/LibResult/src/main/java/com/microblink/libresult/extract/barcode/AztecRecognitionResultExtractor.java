package com.microblink.libresult.extract.barcode;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkbarcode.aztec.AztecScanResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class AztecRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;

    public AztecRecognitionResultExtractor(Context context) {
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

        if (result instanceof AztecScanResult) {
            // result is obtained from scanning Aztec barcode
            AztecScanResult aztecResult = (AztecScanResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPUncertain,
                    aztecResult.isUncertain()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBarcodeData,
                    aztecResult.getStringData()
            ));
        }

        return mExtractedData;
    }
}
