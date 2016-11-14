package com.microblink.libresult.extract.austria;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.austria.back.AustrianIDBackSideRecognitionResult;

import java.util.List;

public class AustrianIDBackSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public AustrianIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustrianIDBackSideRecognitionResult) {
            AustrianIDBackSideRecognitionResult ausIDBackResult = (AustrianIDBackSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPHeight,
                    ausIDBackResult.getHeight(),
                    "m"
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    ausIDBackResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    ausIDBackResult.getIssuingAuthority()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    ausIDBackResult.getDateOfIssuance()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPrincipalResidenceAtIssuance,
                    ausIDBackResult.getPrincipalResidenceAtIssuance()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPEyeColour,
                    ausIDBackResult.getEyeColour()
            ));

            super.extractMRZData(ausIDBackResult);
        }

        return mExtractedData;
    }
}
