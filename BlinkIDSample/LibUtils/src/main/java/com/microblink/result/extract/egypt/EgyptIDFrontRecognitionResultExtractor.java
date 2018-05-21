package com.microblink.result.extract.egypt;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.egypt.EgyptIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;


public class EgyptIDFrontRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public EgyptIDFrontRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof EgyptIDFrontRecognizer.Result) {
            EgyptIDFrontRecognizer.Result egyptIDFrontRecognition = (EgyptIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, egyptIDFrontRecognition.getDocumentNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPNationalNumber, egyptIDFrontRecognition.getNationalNumber()));
            BlinkIDExtractionUtils.extractCommonData(egyptIDFrontRecognition, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
