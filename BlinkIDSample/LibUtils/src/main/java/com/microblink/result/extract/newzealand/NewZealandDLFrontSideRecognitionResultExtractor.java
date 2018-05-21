package com.microblink.result.extract.newzealand;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDLFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 + * Created by Domagoj Ravlic on 13.12.2017
 + */


public class NewZealandDLFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public NewZealandDLFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof NewZealandDLFrontRecognizer.Result) {
            // result is obtained by scanning the front side of New Zealand DLs
            NewZealandDLFrontRecognizer.Result idnIdFrontResult = (NewZealandDLFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPSurname,
                    idnIdFrontResult.getSurname()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstNames,
                    idnIdFrontResult.getFirstNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    idnIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    idnIdFrontResult.getIssueDate()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    idnIdFrontResult.getExpiryDate()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPLicenceNumber,
                    idnIdFrontResult.getLicenseNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPCardVersion,
                    idnIdFrontResult.getCardVersion()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDonorIndicator,
                    idnIdFrontResult.getDonorIndicator()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    idnIdFrontResult.getAddress()
            ));
            BlinkIDExtractionUtils.extractCommonData(idnIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;

    }

}