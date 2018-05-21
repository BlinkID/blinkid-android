package com.microblink.result.extract.australia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.australia.AustralianDLFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by daniel on 8/25/17.
 */
public class AustralianDLFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {
    public AustralianDLFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustralianDLFrontSideRecognizer.Result) {
            AustralianDLFrontSideRecognizer.Result ausDLFront = (AustralianDLFrontSideRecognizer.Result) result;

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

            BlinkIDExtractionUtils.extractCommonData(ausDLFront, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
