package com.microblink.libresult.extract.egypt;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.egypt.front.EgyptIDFrontRecognitionResult;

import java.util.List;


public class EgyptIDFrontRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public EgyptIDFrontRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof EgyptIDFrontRecognitionResult) {
            EgyptIDFrontRecognitionResult egyptIDFrontRecognition = (EgyptIDFrontRecognitionResult) result;

            mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, egyptIDFrontRecognition.getDocumentNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPNationalNumber, egyptIDFrontRecognition.getNationalNumber()));
        }

        return mExtractedData;
    }
}
