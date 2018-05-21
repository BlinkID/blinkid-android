package com.microblink.result.extract.czechia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.czechia.CzechIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by dodo on 24/05/16.
 */

public class CzechIDFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {
    public CzechIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof CzechIDFrontSideRecognizer.Result) {
            CzechIDFrontSideRecognizer.Result czIdFrontResult = (CzechIDFrontSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    czIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    czIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    czIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    czIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    czIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    czIdFrontResult.getDateOfIssue()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    czIdFrontResult.getDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    czIdFrontResult.getPlaceOfBirth()
            ));

            BlinkIDExtractionUtils.extractCommonData(czIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
