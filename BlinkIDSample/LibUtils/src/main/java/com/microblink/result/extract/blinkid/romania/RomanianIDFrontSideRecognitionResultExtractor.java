package com.microblink.result.extract.blinkid.romania;

import com.microblink.entities.recognizers.blinkid.romania.RomaniaIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class RomanianIDFrontSideRecognitionResultExtractor extends MrtdResultExtractor<RomaniaIdFrontRecognizer.Result, RomaniaIdFrontRecognizer> {

    @Override
    protected void extractData(RomaniaIdFrontRecognizer.Result result) {
        super.extractData(result);
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPIdentityCardNumber, result.getCardNumber());
        add(R.string.PPSeries, result.getIdSeries());
        add(R.string.PPCNP, result.getCnp());
        add(R.string.PPParentNames, result.getParentNames());
        add(R.string.PPNationality, result.getNonMRZNationality());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssuingAuthority, result.getIssuedBy());
        add(R.string.PPSex, result.getNonMRZSex());
        add(R.string.PPValidFrom, result.getValidFrom());
        add(R.string.PPValidUntil, result.getValidUntil());
    }

}
