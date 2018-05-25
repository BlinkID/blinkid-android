package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;
import com.microblink.results.date.Date;

public class GermanIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<GermanyIDBackSideRecognizer.Result, GermanyIDBackSideRecognizer> {

    @Override
    protected void extractData(GermanyIDBackSideRecognizer.Result result) {
        super.extractData(result);

        String address = result.getAddress();
        if (address != null && !address.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    address
            ));
        }

        String zipCode = result.getAddressZipCode();
        if (zipCode != null && !zipCode.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddressZipCode,
                    zipCode
            ));
        }

        String city = result.getAddressCity();
        if (city != null && !city.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddressCity,
                    city
            ));
        }

        String street = result.getAddressStreet();
        if (street != null && !street.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddressStreet,
                    street
            ));
        }

        String houseNumber = result.getAddressHouseNumber();
        if (houseNumber != null && !houseNumber.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddressHouseNumber,
                    houseNumber
            ));
        }

        String authority = result.getAuthority();
        if (authority != null && !authority.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPAuthority,
                    authority
            ));
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    dateOfIssue
            ));
        }

        String eyeColor = result.getEyeColour();
        if (eyeColor != null && !eyeColor.isEmpty()) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPEyeColour,
                    eyeColor
            ));
        }

        int height = result.getHeight();
        if (height != 0) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPHeight,
                    Integer.toString(height) + " cm"
            ));
        }
    }

}
