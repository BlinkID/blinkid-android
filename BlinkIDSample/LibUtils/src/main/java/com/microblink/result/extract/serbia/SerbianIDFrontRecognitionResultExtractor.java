package com.microblink.result.extract.serbia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.serbia.SerbianIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by Boris on 26/08/16.
 */
public class SerbianIDFrontRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {
    public SerbianIDFrontRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SerbianIDFrontRecognizer.Result) {
            SerbianIDFrontRecognizer.Result srbIdFrontResult = (SerbianIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    srbIdFrontResult.getIssuingDate()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPValidUntil,
                    srbIdFrontResult.getValidUntil()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    srbIdFrontResult.getDocumentNumber()
            ));
            BlinkIDExtractionUtils.extractCommonData(srbIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
