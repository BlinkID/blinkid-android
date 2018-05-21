package com.microblink.result.extract.poland;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.poland.PolishIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by daniel on 03/10/17.
 */
public class PolishIDFrontSideRecognitionResultExtractor  extends TemplatingRecognizerResultExtractor {

    public PolishIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof PolishIDFrontSideRecognizer.Result) {
            PolishIDFrontSideRecognizer.Result polIdFrontResult = (PolishIDFrontSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    polIdFrontResult.getSurname()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    polIdFrontResult.getGivenNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFamilyName,
                    polIdFrontResult.getFamilyName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPParentNames,
                    polIdFrontResult.getParentsGivenNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    polIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    polIdFrontResult.getDateOfBirth()
            ));
            BlinkIDExtractionUtils.extractCommonData(polIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}

