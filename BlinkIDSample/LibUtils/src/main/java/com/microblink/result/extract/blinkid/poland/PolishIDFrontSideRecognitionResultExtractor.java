package com.microblink.result.extract.blinkid.poland;

import com.microblink.entities.recognizers.blinkid.poland.PolandIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class PolishIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<PolandIdFrontRecognizer.Result, PolandIdFrontRecognizer> {

    @Override
    protected void extractData(PolandIdFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getGivenNames());
        add(R.string.PPFamilyName, result.getFamilyName());
        add(R.string.PPParentNames, result.getParentsGivenNames());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
    }

}

