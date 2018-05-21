package com.microblink.result.extract.australia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.australia.AustralianDLBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by igrce on 30/11/17.
 */
public class AustralianDLBackSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {
    public AustralianDLBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustralianDLBackSideRecognizer.Result) {
            AustralianDLBackSideRecognizer.Result ausDLBack = (AustralianDLBackSideRecognizer.Result) result;

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

            BlinkIDExtractionUtils.extractCommonData(ausDLBack, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
