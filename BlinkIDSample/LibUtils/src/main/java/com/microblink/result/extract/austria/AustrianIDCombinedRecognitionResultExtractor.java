package com.microblink.result.extract.austria;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.austria.AustrianCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igrce on 09/01/17.
 */
public class AustrianIDCombinedRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public AustrianIDCombinedRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustrianCombinedRecognizer.Result) {
            // result is obtained from scanning both sides of Austrian ID
            AustrianCombinedRecognizer.Result combinedResult = (AustrianCombinedRecognizer.Result) result;

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
                    R.string.PPDateOfBirth,
                    combinedResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPHeight,
                    combinedResult.getHeight(),
                    "m"
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    combinedResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    combinedResult.getIssuingAuthority()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    combinedResult.getDateOfIssuance()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    combinedResult.getDocumentDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPrincipalResidenceAtIssuance,
                    combinedResult.getPrincipalResidenceAtIssuance()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPEyeColour,
                    combinedResult.getEyeColour()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    combinedResult.getNationality()
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
