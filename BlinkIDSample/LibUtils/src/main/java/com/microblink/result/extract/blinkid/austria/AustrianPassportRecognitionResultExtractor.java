package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;
import com.microblink.results.date.DateResult;


public class AustrianPassportRecognitionResultExtractor extends BlinkIdExtractor<AustriaPassportRecognizer.Result, AustriaPassportRecognizer> {

    @Override
    protected void extractData(AustriaPassportRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        String name = result.getGivenName();
        if (name != null && !name.isEmpty()) {
            add(R.string.PPFirstName, name);
        }

        String surname = result.getSurname();
        if (surname != null && !surname.isEmpty()) {
            add(R.string.PPLastName, surname);
        }

        String placeOfBirth = result.getPlaceOfBirth();
        if (placeOfBirth != null) {
            add(R.string.PPPlaceOfBirth, placeOfBirth);
        }

        String sex = result.getSex();
        if (sex != null) {
            add(R.string.PPSex, sex);
        }

        String nat = result.getNationality();
        if (nat != null && !nat.isEmpty()) {
            add(R.string.PPNationality, nat);
        }

        String authority = result.getIssuingAuthority();
        if (authority != null && !authority.isEmpty()) {
            add(R.string.PPAuthority, authority);
        }

        DateResult dateOfBirth = result.getDateOfBirth();
        if (dateOfBirth != null) {
            add(R.string.PPDateOfBirth, dateOfBirth.getDate());
        }

        DateResult dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            add(R.string.PPIssueDate, dateOfIssue.getDate());
        }

        DateResult dateOfExpiry = result.getDateOfExpiry();
        if (dateOfExpiry != null) {
            add(R.string.PPDateOfExpiry, dateOfExpiry.getDate());
        }

        add(R.string.PPHeight, result.getHeight());

        String passportNumber = result.getPassportNumber();
        if (passportNumber != null) {
            add(R.string.PPPassportNumber, passportNumber);
        }
    }

}
