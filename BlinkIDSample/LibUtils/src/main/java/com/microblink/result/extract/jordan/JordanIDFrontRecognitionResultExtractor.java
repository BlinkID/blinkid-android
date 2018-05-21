package com.microblink.result.extract.jordan;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.jordan.JordanIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by Matea K on 24.02.18.
 */

public class JordanIDFrontRecognitionResultExtractor extends TemplatingRecognizerResultExtractor
{
    public JordanIDFrontRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result)
    {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof JordanIDFrontRecognizer.Result) {
            //result is obtained by scanning the front side of Jordan ID
            JordanIDFrontRecognizer.Result jordanIDFrontResult = (JordanIDFrontRecognizer.Result) result;

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
            BlinkIDExtractionUtils.extractCommonData(jordanIDFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
