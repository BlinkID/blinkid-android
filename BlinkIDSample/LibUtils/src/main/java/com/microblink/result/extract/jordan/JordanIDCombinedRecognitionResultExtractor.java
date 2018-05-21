package com.microblink.result.extract.jordan;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

public class JordanIDCombinedRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public JordanIDCombinedRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof JordanCombinedRecognizer.Result) {
            // result is obtained from scanning both sides of Jordan ID
            JordanCombinedRecognizer.Result combinedResult = (JordanCombinedRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPName,
                    combinedResult.getName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationalNumber,
                    combinedResult.getNatianalNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    combinedResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    combinedResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    combinedResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    combinedResult.getDocumentNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuer,
                    combinedResult.getIssuer()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    combinedResult.getDateOfExpiry()
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
