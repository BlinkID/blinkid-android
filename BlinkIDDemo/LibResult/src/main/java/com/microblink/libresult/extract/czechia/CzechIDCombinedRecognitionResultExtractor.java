package com.microblink.libresult.extract.czechia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.czechia.combined.CzechIDCombinedRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Extractor of CzechIDCombinedRecognitionResult
 */
public class CzechIDCombinedRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public CzechIDCombinedRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof CzechIDCombinedRecognitionResult) {
            // result is obtained from scanning both sides of Czech ID
            CzechIDCombinedRecognitionResult combinedResult = (CzechIDCombinedRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    combinedResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    combinedResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    combinedResult.getIdentityCardNumber()
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
                    R.string.PPDateOfBirth,
                    combinedResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    combinedResult.getDocumentDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    combinedResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    combinedResult.getIssuingAuthority()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    combinedResult.getDocumentDateOfIssue()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPersonalNumber,
                    combinedResult.getPersonalIdentificationNumber()
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
