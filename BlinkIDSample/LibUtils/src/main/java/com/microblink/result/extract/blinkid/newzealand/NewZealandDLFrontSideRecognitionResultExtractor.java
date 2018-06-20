package com.microblink.result.extract.blinkid.newzealand;

import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDlFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class NewZealandDLFrontSideRecognitionResultExtractor extends BlinkIdExtractor<NewZealandDlFrontRecognizer.Result, NewZealandDlFrontRecognizer> {

    @Override
    protected void extractData(NewZealandDlFrontRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPFirstNames, result.getFirstNames());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPIssueDate, result.getIssueDate());
        add(R.string.PPDateOfExpiry, result.getExpiryDate());
        add(R.string.PPLicenceNumber, result.getLicenseNumber());
        add(R.string.PPCardVersion, result.getCardVersion());
        add(R.string.PPDonorIndicator, result.getDonorIndicator());
        add(R.string.PPAddress, result.getAddress());
    }

}