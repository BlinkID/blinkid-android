package com.microblink.result.extract.poland;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.poland.PolishCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 10/11/17.
 */
public class PolishIDCombinedRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public PolishIDCombinedRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof PolishCombinedRecognizer.Result) {
            // result is obtained from scanning both sides of Polish ID
            PolishCombinedRecognizer.Result combinedResult = (PolishCombinedRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    combinedResult.getSurname()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    combinedResult.getGivenNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFamilyName,
                    combinedResult.getFamilyName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPParentNames,
                    combinedResult.getParentsGivenNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    combinedResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    combinedResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuer,
                    combinedResult.getIssuer()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    combinedResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    combinedResult.getDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    combinedResult.getDocumentNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPersonalNumber,
                    combinedResult.getPersonalNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPMRZVerified,
                    combinedResult.isMRZVerified()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentBothSidesMatch,
                    combinedResult.isDocumentDataMatch()
            ));
            BlinkIDExtractionUtils.extractCommonData(combinedResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
