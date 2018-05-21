package com.microblink.result.extract.switzerland;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.switzerland.SwissIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by daniel on 8/3/17.
 */
public class SwissIDFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public SwissIDFrontSideRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SwissIDFrontRecognizer.Result){
            // result is obtained by scanning the front side of Swiss IDs
            SwissIDFrontRecognizer.Result swissIdFrontResult = (SwissIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    swissIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    swissIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    swissIdFrontResult.getDateOfBirth()
            ));
            BlinkIDExtractionUtils.extractCommonData(swissIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;

    }
}

