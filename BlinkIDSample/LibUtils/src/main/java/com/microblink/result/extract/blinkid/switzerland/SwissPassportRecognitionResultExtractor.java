package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;
import com.microblink.results.date.Date;

public class SwissPassportRecognitionResultExtractor extends MrtdResultExtractor<SwitzerlandPassportRecognizer.Result, SwitzerlandPassportRecognizer> {

    @Override
    protected void extractData(SwitzerlandPassportRecognizer.Result result) {
        super.extractData(result);

        String name = result.getName();
        if (name != null && !name.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    name
            ));
        }

        String surname = result.getSurname();
        if (surname != null && !surname.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    surname
            ));
        }

        String placeOfOrigin = result.getPlaceOfOrigin();
        if (placeOfOrigin != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfOrigin,
                    placeOfOrigin
            ));
        }

        String authority = result.getAuthority();
        if (authority != null && !authority.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAuthority,
                    authority
            ));
        }

        Date dateOfBirth = result.getNonMRZDateOfBirth();
        if (dateOfBirth != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    dateOfBirth
            ));
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    dateOfIssue
            ));
        }

        Date dateOfExpiry = result.getNonMRZDateOfExpiry();
        if (dateOfExpiry != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    dateOfExpiry
            ));
        }

        String passportNumber = result.getPassportNumber();
        if (passportNumber != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPPassportNumber,
                    passportNumber
            ));
        }

        String sex = result.getNonMRZSex();
        if (sex != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    sex
            ));
        }

        String height = result.getHeight();
        if (height != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPHeight,
                    height
            ));
        }
    }

}
