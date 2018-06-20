package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class GermanIDCombinedRecognitionResultExtractor extends BlinkIdExtractor<GermanyCombinedRecognizer.Result, GermanyCombinedRecognizer> {

    @Override
    protected void extractData(GermanyCombinedRecognizer.Result result) {
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDocumentNumber, result.getIdentityCardNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPNationality, result.getNationality());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPIssuingAuthority, result.getIssuingAuthority());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPEyeColour, result.getEyeColor());
        add(R.string.PPHeight, result.getHeight());
        add(R.string.PPMRZVerified, result.isMrzVerified());
        add(R.string.PPDocumentBothSidesMatch, result.isDocumentDataMatch());
        add(R.string.PPCANNumber, result.getCanNumber());
    }

}
