package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class GermanIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<GermanyCombinedRecognizer.Result, GermanyCombinedRecognizer> {

    @Override
    protected void extractData(GermanyCombinedRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPGivenNames, result.getGivenNames());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssuingAuthority, result.getAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPEyeColour, result.getColourOfEyes());
        add(R.string.PPHeight, result.getHeight());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
        add(R.string.PPCANNumber, result.getCanNumber());
        add(R.string.PPMRZText, result.getRawMrzString());
    }

}
