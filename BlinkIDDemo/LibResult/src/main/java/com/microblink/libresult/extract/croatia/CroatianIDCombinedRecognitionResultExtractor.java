package com.microblink.libresult.extract.croatia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.croatia.combined.CroatianIDCombinedRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 29/11/16.
 */

public class CroatianIDCombinedRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public CroatianIDCombinedRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof CroatianIDCombinedRecognitionResult) {
            // result is obtained from scanning both sides of Croatian ID
            CroatianIDCombinedRecognitionResult combinedResult = (CroatianIDCombinedRecognitionResult) result;

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
                    R.string.PPCitizenship,
                    combinedResult.getCitizenship()
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
                    R.string.PPDocumentForNonResidents,
                    combinedResult.documentForNonResident()
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

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentBilingual,
                    combinedResult.isDocumentBilingual()
            ));

        }

        return mExtractedData;
    }
}
