package com.microblink.libresult.extract.newzealand;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.newzealand.driversLicense.front.NewZealandDLFrontRecognitionResult;

import java.util.List;

public class NewZealandDLFrontSideRecognitionResultExtractor extends
        BlinkOcrRecognitionResultExtractor {

    public NewZealandDLFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof NewZealandDLFrontRecognitionResult) {
            // result is obtained by scanning the front side of New Zealand DLs
            NewZealandDLFrontRecognitionResult
                    idnIdFrontResult = (NewZealandDLFrontRecognitionResult) result;

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
        }

        return mExtractedData;

    }

}