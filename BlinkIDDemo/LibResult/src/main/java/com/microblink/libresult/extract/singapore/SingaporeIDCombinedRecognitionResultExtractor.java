package com.microblink.libresult.extract.singapore;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.singapore.combined.SingaporeIDCombinedRecognitionResult;

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
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SingaporeIDCombinedRecognitionResult) {
            // result is obtained from scanning both sides of Croatian ID
            SingaporeIDCombinedRecognitionResult combinedResult = (SingaporeIDCombinedRecognitionResult) result;

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

        }

        return mExtractedData;
    }

}
