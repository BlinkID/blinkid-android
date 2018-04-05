package com.microblink.libresult.extract.jordan;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.jordan.front.JordanIDFrontRecognitionResult;

import java.util.List;


public class JordanIDFrontRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {
    public JordanIDFrontRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof JordanIDFrontRecognitionResult) {
            //result is obtained by scanning the front side of Jordan ID
            JordanIDFrontRecognitionResult jordanIDFrontResult = (JordanIDFrontRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationalNumber,
                    jordanIDFrontResult.getNatianalNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPName,
                    jordanIDFrontResult.getName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    jordanIDFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    jordanIDFrontResult.getDateOfBirth()
            ));
        }

        return mExtractedData;
    }
}
