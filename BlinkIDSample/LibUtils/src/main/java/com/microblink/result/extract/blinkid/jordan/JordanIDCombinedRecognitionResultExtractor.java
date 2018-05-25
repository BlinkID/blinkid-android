package com.microblink.result.extract.blinkid.jordan;

import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class JordanIDCombinedRecognitionResultExtractor extends BaseResultExtractor<JordanCombinedRecognizer.Result, JordanCombinedRecognizer> {

    @Override
    protected void extractData(JordanCombinedRecognizer.Result result) {

        mExtractedData.add(mBuilder.build(
                R.string.PPName,
                result.getName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationalNumber,
                result.getNatianalNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                result.getNationality()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getDocumentNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuer,
                result.getIssuer()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDateOfExpiry()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPMRZVerified,
                result.isMRZVerified()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentBothSidesMatch,
                result.isDocumentDataMatch()
        ));
    }
}
