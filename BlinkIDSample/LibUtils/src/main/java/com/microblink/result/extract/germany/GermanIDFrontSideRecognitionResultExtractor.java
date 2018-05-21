package com.microblink.result.extract.germany;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.germany.GermanIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by igrce on 26/08/16.
 */
public class GermanIDFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public GermanIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanIDFrontSideRecognizer.Result) {
            GermanIDFrontSideRecognizer.Result deIdFrontResult = (GermanIDFrontSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    deIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    deIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    deIdFrontResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    deIdFrontResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    deIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    deIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    deIdFrontResult.getDateOfExpiry()
            ));

            BlinkIDExtractionUtils.extractCommonData(deIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
