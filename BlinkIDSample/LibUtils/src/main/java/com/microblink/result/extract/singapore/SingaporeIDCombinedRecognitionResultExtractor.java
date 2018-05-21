package com.microblink.result.extract.singapore;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 2/23/17.
 */

public class SingaporeIDCombinedRecognitionResultExtractor implements IBaseRecognitionResultExtractor {


    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public SingaporeIDCombinedRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }


    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SingaporeCombinedRecognizer.Result) {
            // result is obtained from scanning both sides of Croatian ID
            SingaporeCombinedRecognizer.Result combinedResult = (SingaporeCombinedRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPFullName,
                    combinedResult.getName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBloodGroup,
                    combinedResult.getBloodGroup()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNRICNumber,
                    combinedResult.getCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    combinedResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPRace,
                    combinedResult.getRace()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    combinedResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPCountryOfBirth,
                    combinedResult.getCountryOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    combinedResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    combinedResult.getDocumentDateOfIssue()
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
