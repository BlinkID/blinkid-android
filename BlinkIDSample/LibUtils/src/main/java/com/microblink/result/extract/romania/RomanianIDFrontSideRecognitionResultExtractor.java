package com.microblink.result.extract.romania;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.romania.RomanianIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;
import com.microblink.util.Log;

import java.util.List;

/**
 * Created by Boris on 03/03/17.
 */

public class RomanianIDFrontSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {
    public RomanianIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof RomanianIDFrontRecognizer.Result) {
            RomanianIDFrontRecognizer.Result romanianIdFrontResult = (RomanianIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    romanianIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    romanianIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIdentityCardNumber,
                    romanianIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSeries,
                    romanianIdFrontResult.getIdentityCardSeries()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPCNP,
                    romanianIdFrontResult.getCNP()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPParentNames,
                    romanianIdFrontResult.getParentNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    romanianIdFrontResult.getNonMRZNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    romanianIdFrontResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    romanianIdFrontResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    romanianIdFrontResult.getIssuedBy()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    romanianIdFrontResult.getNonMRZSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPValidFrom,
                    romanianIdFrontResult.getValidFrom()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPValidUntil,
                    romanianIdFrontResult.getValidUntil()
            ));

            Log.e(this, "Before super");
            super.extractMRZData(result);
            Log.e(this, "After super");

            BlinkIDExtractionUtils.extractCommonData(romanianIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
