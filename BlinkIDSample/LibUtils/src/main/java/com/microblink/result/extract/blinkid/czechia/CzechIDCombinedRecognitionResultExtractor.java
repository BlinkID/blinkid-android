package com.microblink.result.extract.blinkid.czechia;

import com.microblink.entities.recognizers.blinkid.czechia.CzechiaCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CzechIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<CzechiaCombinedRecognizer.Result, CzechiaCombinedRecognizer> {

    @Override
    protected void extractData(CzechiaCombinedRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPGivenNames, result.getGivenNames());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPAddress, result.getPermanentStay());
        add(R.string.PPAuthority, result.getAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPersonalNumber, result.getPersonalNumber());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
    }
}
