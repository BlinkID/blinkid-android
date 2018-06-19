package com.microblink.result.extract.blinkid.czechia;

import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CzechIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<CzechiaIdFrontRecognizer.Result, CzechiaIdFrontRecognizer> {

    @Override
    protected void extractData(CzechiaIdFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDocumentNumber, result.getIdentityCardNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
    }

}
