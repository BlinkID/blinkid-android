package com.microblink.result.extract.colombia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;


public class ColombiaIDFrontRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public ColombiaIDFrontRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof ColombiaIDFrontSideRecognizer.Result) {
            ColombiaIDFrontSideRecognizer.Result colombiaIDFrontResult = (ColombiaIDFrontSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, colombiaIDFrontResult.getDocumentNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPFirstName, colombiaIDFrontResult.getOwnerFirsName()));
            mExtractedData.add(mBuilder.build(R.string.PPLastName, colombiaIDFrontResult.getOwnerLastName()));

            BlinkIDExtractionUtils.extractCommonData(colombiaIDFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
