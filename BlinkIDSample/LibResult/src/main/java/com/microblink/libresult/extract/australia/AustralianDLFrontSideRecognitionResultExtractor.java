package com.microblink.libresult.extract.australia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.australia.driversLicense.front.AustralianDLFrontSideRecognitionResult;

import java.util.List;


/**
 * Created by daniel on 8/25/17.
 */
public class AustralianDLFrontSideRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {
    public AustralianDLFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustralianDLFrontSideRecognitionResult) {
            AustralianDLFrontSideRecognitionResult ausDLFront = (AustralianDLFrontSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPFullName,
                    ausDLFront.getName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    ausDLFront.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPLicenceNumber,
                    ausDLFront.getLicenceNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPLicenceType,
                    ausDLFront.getLicenceType()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    ausDLFront.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    ausDLFront.getDateOfExpiry()
            ));
        }

        return mExtractedData;
    }
}
