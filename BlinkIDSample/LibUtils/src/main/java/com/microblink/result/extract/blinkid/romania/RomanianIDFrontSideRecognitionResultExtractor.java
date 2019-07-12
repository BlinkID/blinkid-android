package com.microblink.result.extract.blinkid.romania;

import com.microblink.entities.recognizers.blinkid.romania.RomaniaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class RomanianIDFrontSideRecognitionResultExtractor extends BlinkIdExtractor<RomaniaIdFrontRecognizer.Result, RomaniaIdFrontRecognizer> {

    @Override
    protected void extractData(RomaniaIdFrontRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPParentNames, result.getParentName());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssuingAuthority, result.getIssuedBy());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPCNP, result.getCnpNumber());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }

}
