package com.microblink.libresult.extract.jordan;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.jordan.combined.JordanIDCombinedRecognitionResult;

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
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof JordanIDCombinedRecognitionResult) {
            // result is obtained from scanning both sides of Jordan ID
            JordanIDCombinedRecognitionResult combinedResult = (JordanIDCombinedRecognitionResult) result;

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
        }

        return mExtractedData;
    }
}
