package com.microblink.result.extract.blinkid.poland;

import com.microblink.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class PolishIDCombinedRecognitionResultExtractor extends BaseResultExtractor<PolandCombinedRecognizer.Result, PolandCombinedRecognizer> {

    @Override
    protected void extractData(PolandCombinedRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                result.getSurname()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                result.getGivenNames()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFamilyName,
                result.getFamilyName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPParentNames,
                result.getParentsGivenNames()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                result.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                result.getNationality()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPIssuer,
                result.getIssuer()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                result.getDateOfExpiry()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                result.getDocumentNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPersonalNumber,
                result.getPersonalNumber()
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
