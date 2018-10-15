package com.microblink.result.extract.blinkid.ireland;

import com.microblink.entities.recognizers.blinkid.ireland.IrelandDlFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class IrelandDlFrontRecognitionResultExtractor extends BlinkIdExtractor<IrelandDlFrontRecognizer.Result, IrelandDlFrontRecognizer> {

    @Override
    protected void extractData(IrelandDlFrontRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPIssueDate, result.getDateOfIssue());
        add(R.string.PPIssuedBy, result.getIssuedBy());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPDriverNumber, result.getDriverNumber());
        add(R.string.PPLicenceNumber, result.getLicenceNumber());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPLicenceCategories, result.getLicenceCategories());
    }

}