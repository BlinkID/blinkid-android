package com.microblink.result.extract.unitedArabEmirates;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by Matea K on 28.12.17.
 */

public class UnitedArabEmiratesIDFrontRecognitionResultExtractor extends TemplatingRecognizerResultExtractor
{
    public UnitedArabEmiratesIDFrontRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result)
    {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof UnitedArabEmiratesIDFrontRecognizer) {
            //result is obtained by scanning the front side of United Arab Emirates ID
            UnitedArabEmiratesIDFrontRecognizer.Result unitedArabEmiratesIDFrontResult = ((UnitedArabEmiratesIDFrontRecognizer) result).getResult();

            mExtractedData.add(mBuilder.build(
                    R.string.PPIdentityCardNumber,
                    unitedArabEmiratesIDFrontResult.getIdNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPName,
                    unitedArabEmiratesIDFrontResult.getName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    unitedArabEmiratesIDFrontResult.getNationality()
            ));
            BlinkIDExtractionUtils.extractCommonData(unitedArabEmiratesIDFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}