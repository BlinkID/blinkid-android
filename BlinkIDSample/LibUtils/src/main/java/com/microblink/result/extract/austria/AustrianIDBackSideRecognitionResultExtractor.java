package com.microblink.result.extract.austria;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.austria.AustrianIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by dodo on 24/05/16.
 */

public class AustrianIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public AustrianIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustrianIDBackSideRecognizer) {
            AustrianIDBackSideRecognizer.Result ausIDBackResult = ((AustrianIDBackSideRecognizer) result).getResult();

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
                    ausIDBackResult.getDateOfIssuance().getDate()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPrincipalResidenceAtIssuance,
                    ausIDBackResult.getPrincipalResidence()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPEyeColour,
                    ausIDBackResult.getEyeColour()
            ));

            extractMRZResult(ausIDBackResult.getMRZResult(), mExtractedData, mBuilder);
            BlinkIDExtractionUtils.extractCommonData(ausIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
