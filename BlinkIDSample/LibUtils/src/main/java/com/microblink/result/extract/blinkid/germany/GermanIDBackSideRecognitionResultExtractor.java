package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;
import com.microblink.results.date.Date;

public class GermanIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<GermanyIdBackRecognizer.Result, GermanyIdBackRecognizer> {

    @Override
    protected void extractData(GermanyIdBackRecognizer.Result result) {
        super.extractData(result);

        String address = result.getAddress();
        if (address != null && !address.isEmpty()) {
            add(R.string.PPAddress, address);
        }

        String zipCode = result.getAddressZipCode();
        if (zipCode != null && !zipCode.isEmpty()) {
            add(R.string.PPAddressZipCode, zipCode);
        }

        String city = result.getAddressCity();
        if (city != null && !city.isEmpty()) {
            add(R.string.PPAddressCity, city);
        }

        String street = result.getAddressStreet();
        if (street != null && !street.isEmpty()) {
            add(R.string.PPAddressStreet, street);
        }

        String houseNumber = result.getAddressHouseNumber();
        if (houseNumber != null && !houseNumber.isEmpty()) {
            add(R.string.PPAddressHouseNumber, houseNumber);
        }

        String authority = result.getAuthority();
        if (authority != null && !authority.isEmpty()) {
            add(R.string.PPAuthority, authority);
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            add(R.string.PPIssueDate, dateOfIssue);
        }

        String eyeColor = result.getEyeColour();
        if (eyeColor != null && !eyeColor.isEmpty()) {
            add(R.string.PPEyeColour, eyeColor);
        }

        String height = result.getHeight();
        if (height != null && !height.isEmpty()) {
            add(R.string.PPHeight, height);
        }
    }

}
