package com.microblink.result.extract.blinkid.spain;

import com.microblink.entities.recognizers.blinkid.spain.SpainDlFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SpainDlFrontRecognitionResultExtractor extends BlinkIdExtractor<SpainDlFrontRecognizer.Result, SpainDlFrontRecognizer> {

    @Override
    protected void extractData(SpainDlFrontRecognizer.Result result) {
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth().getDate());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPValidFrom, result.getValidFrom().getDate());
        add(R.string.PPValidUntil, result.getValidUntil().getDate());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPDocumentNumber, result.getNumber());
        add(R.string.PPLicenceCategories, result.getLicenceCategories());
    }
}
