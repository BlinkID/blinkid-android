package com.microblink.result.extract.blinkid.serbia;

import com.microblink.entities.recognizers.blinkid.serbia.SerbiaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class SerbianIDCombinedRecognitionResultExtractor extends BaseResultExtractor<SerbiaCombinedRecognizer.Result, SerbiaCombinedRecognizer> {

    @Override
    protected void extractData(SerbiaCombinedRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getIdentityCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDocumentDateOfExpiry()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssueDate,
                result.getDocumentDateOfIssue()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPersonalNumber,
                result.getJMBG()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                result.getNationality()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDocumentDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuer,
                result.getIssuer()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
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
