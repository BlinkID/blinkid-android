package com.microblink.libresult.extract.unitedArabEmirates;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.unitedArabEmirates.front.UnitedArabEmiratesIDFrontRecognitionResult;



import java.util.List;

public class UnitedArabEmiratesIDFrontRecognitionResultExtractor extends
        BlinkOcrRecognitionResultExtractor
{
    public UnitedArabEmiratesIDFrontRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result)
    {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof UnitedArabEmiratesIDFrontRecognitionResult) {
            //result is obtained by scanning the front side of United Arab Emirates ID
            UnitedArabEmiratesIDFrontRecognitionResult
                    unitedArabEmiratesIDFrontResult = (UnitedArabEmiratesIDFrontRecognitionResult) result;

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
        }

        return mExtractedData;
    }
}