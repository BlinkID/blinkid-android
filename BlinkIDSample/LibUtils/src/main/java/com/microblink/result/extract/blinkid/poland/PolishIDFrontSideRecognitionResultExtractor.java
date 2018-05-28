package com.microblink.result.extract.blinkid.poland;

import com.microblink.entities.recognizers.blinkid.poland.PolandIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class PolishIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<PolandIDFrontSideRecognizer.Result, PolandIDFrontSideRecognizer> {

    @Override
    protected void extractData(PolandIDFrontSideRecognizer.Result result) {
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
                R.string.PPDateOfBirth,
                result.getDateOfBirth()
        ));
    }

}

