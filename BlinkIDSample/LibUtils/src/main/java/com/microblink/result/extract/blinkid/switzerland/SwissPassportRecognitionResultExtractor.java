package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;
import com.microblink.results.date.Date;

public class SwissPassportRecognitionResultExtractor extends MrtdResultExtractor<SwitzerlandPassportRecognizer.Result, SwitzerlandPassportRecognizer> {

    @Override
    protected void extractData(SwitzerlandPassportRecognizer.Result result) {
        super.extractData(result);

        String name = result.getGivenName();
        if (name != null && !name.isEmpty()) {
            add(R.string.PPFirstName, name);
        }

        String surname = result.getSurname();
        if (surname != null && !surname.isEmpty()) {
            add(R.string.PPLastName, surname);
        }

        String placeOfOrigin = result.getPlaceOfBirth();
        if (placeOfOrigin != null) {
            add(R.string.PPPlaceOfOrigin, placeOfOrigin);
        }

        String authority = result.getAuthority();
        if (authority != null && !authority.isEmpty()) {
            add(R.string.PPAuthority, authority);
        }

        Date dateOfBirth = result.getNonMrzDateOfBirth();
        if (dateOfBirth != null) {
            add(R.string.PPDateOfBirth, dateOfBirth);
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            add(R.string.PPIssueDate, dateOfIssue);
        }

        Date dateOfExpiry = result.getNonMrzDateOfExpiry();
        if (dateOfExpiry != null) {
            add(R.string.PPDateOfExpiry, dateOfExpiry);
        }

        String passportNumber = result.getPassportNumber();
        if (passportNumber != null) {
            add(R.string.PPPassportNumber, passportNumber);
        }

        String sex = result.getNonMrzSex();
        if (sex != null) {
            add(R.string.PPSex, sex);
        }

        String height = result.getHeight();
        if (height != null) {
            add(R.string.PPHeight, height);
        }
    }

}
