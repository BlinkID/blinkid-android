package com.microblink.libresult.extract.romania;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.romania.front.RomanianIDFrontSideRecognitionResult;
import com.microblink.util.Log;

import java.util.List;

/**
 * Created by Boris on 03/03/17.
 */

public class RomanianIDFrontSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {
    public RomanianIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof RomanianIDFrontSideRecognitionResult) {
            RomanianIDFrontSideRecognitionResult romanianIdFrontResult = (RomanianIDFrontSideRecognitionResult) result;

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
                    romanianIdFrontResult.getNationality()
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
                    romanianIdFrontResult.getSex()
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
            super.extractMRZData(romanianIdFrontResult);
            Log.e(this, "After super");
        }

        return mExtractedData;
    }
}
