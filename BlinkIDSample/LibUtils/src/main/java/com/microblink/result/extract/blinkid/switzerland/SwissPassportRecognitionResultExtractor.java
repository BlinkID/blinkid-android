package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SwissPassportRecognitionResultExtractor extends BlinkIdExtractor<SwitzerlandPassportRecognizer.Result, SwitzerlandPassportRecognizer> {

    @Override
    protected void extractData(SwitzerlandPassportRecognizer.Result result) {
        extractMRZResult(result.getMrzResult());

        String name = result.getGivenName();
        if (!name.isEmpty()) {
            add(R.string.PPFirstName, name);
        }
        String surname = result.getSurname();
        if (!surname.isEmpty()) {
            add(R.string.PPLastName, surname);
        }
        add(R.string.PPPlaceOfOrigin, result.getPlaceOfOrigin());
        String authority = result.getAuthority();
        if (!authority.isEmpty()) {
            add(R.string.PPAuthority, authority);
        }
        add(R.string.PPDateOfBirth, result.getDateOfBirth().getDate());
        add(R.string.PPIssueDate, result.getDateOfIssue().getDate());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry().getDate());
        add(R.string.PPPassportNumber, result.getPassportNumber());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPHeight, result.getHeight());
    }

}
