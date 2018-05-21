package com.microblink.result.extract.eudl;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.eudl.EUDLRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 12/10/15.
 */
public class EUDriversLicenceRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;

    public EUDriversLicenceRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof EUDLRecognizer.Result) {
            EUDLRecognizer.Result eudlResult = (EUDLRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    eudlResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    eudlResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    eudlResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    eudlResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    eudlResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    eudlResult.getDocumentIssueDate()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    eudlResult.getDocumentExpiryDate()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDriverNumber,
                    eudlResult.getDriverNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    eudlResult.getDocumentIssuingAuthority()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPCountryId,
                    eudlResult.getCountry().name()
            ));

            BlinkIDExtractionUtils.extractCommonData(eudlResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
