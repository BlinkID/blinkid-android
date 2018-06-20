package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class AustrianIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<AustriaIdFrontRecognizer.Result, AustriaIdFrontRecognizer> {

    @Override
    protected void extractData(AustriaIdFrontRecognizer.Result ausIdFrontResult) {
        add(R.string.PPLastName, ausIdFrontResult.getSurname());
        add(R.string.PPFirstName, ausIdFrontResult.getGivenName());
        add(R.string.PPDocumentNumber, ausIdFrontResult.getDocumentNumber());
        add(R.string.PPSex, ausIdFrontResult.getSex());
        add(R.string.PPDateOfBirth, ausIdFrontResult.getDateOfBirth().getDate());
    }

}
