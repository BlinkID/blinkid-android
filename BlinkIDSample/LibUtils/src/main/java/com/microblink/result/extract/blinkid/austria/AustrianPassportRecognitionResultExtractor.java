package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.results.date.DateResult;


public class AustrianPassportRecognitionResultExtractor extends BaseResultExtractor<AustriaPassportRecognizer.Result, AustriaPassportRecognizer> {

    @Override
    protected void extractData(AustriaPassportRecognizer.Result result) {
        extractMRZResult(result.getMRZResult());

        String name = result.getGivenName();
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

        String placeOfBirth = result.getPlaceOfBirth();
        if (placeOfBirth != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    placeOfBirth
            ));
        }

        String sex = result.getSex();
        if (sex != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    sex
            ));
        }

        String nat = result.getNationality();
        if (nat != null && !nat.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    nat
            ));
        }

        String authority = result.getIssuingAuthority();
        if (authority != null && !authority.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAuthority,
                    authority
            ));
        }

        DateResult dateOfBirth = result.getDateOfBirth();
        if (dateOfBirth != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    dateOfBirth.getDate()
            ));
        }

        DateResult dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    dateOfIssue.getDate()
            ));
        }

        DateResult dateOfExpiry = result.getDateOfExpiry();
        if (dateOfExpiry != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    dateOfExpiry.getDate()
            ));
        }

        mExtractedData.add(mBuilder.build(
                R.string.PPHeight,
                result.getHeight()
        ));

        String passportNumber = result.getPassportNumber();
        if (passportNumber != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPPassportNumber,
                    passportNumber
            ));
        }
    }

}
