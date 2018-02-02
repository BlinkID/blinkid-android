package com.microblink.libresult.extract.australia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.australia.driversLicense.back.AustralianDLBackSideRecognitionResult;

import java.util.List;

/**
 * Created by igrce on 30/11/17.
 */
public class AustralianDLBackSideRecognitionResultExtractor extends
        BlinkOcrRecognitionResultExtractor {
    public AustralianDLBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustralianDLBackSideRecognitionResult) {
            AustralianDLBackSideRecognitionResult
                    ausDLBack = (AustralianDLBackSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    ausDLBack.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPLicenceNumber,
                    ausDLBack.getLicenceNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    ausDLBack.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    ausDLBack.getDateOfExpiry()
            ));
        }

        return mExtractedData;
    }
}
