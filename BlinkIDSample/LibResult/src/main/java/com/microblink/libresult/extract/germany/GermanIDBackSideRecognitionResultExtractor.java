package com.microblink.libresult.extract.germany;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.germany.back.GermanIDBackSideRecognitionResult;
import com.microblink.results.date.Date;

import java.util.List;

/**
 * Created by daniel on 4/12/17.
 */
public class GermanIDBackSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public GermanIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanIDBackSideRecognitionResult) {
            GermanIDBackSideRecognitionResult deIDBackResult = (GermanIDBackSideRecognitionResult) result;

            String address = deIDBackResult.getAddress();
            if (address != null && !address.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAddress,
                        address
                ));
            }

            String zipCode = deIDBackResult.getAddressZipCode();
            if (zipCode != null && !zipCode.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAddressZipCode,
                        zipCode
                ));
            }

            String city = deIDBackResult.getAddressCity();
            if (city != null && !city.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAddressCity,
                        city
                ));
            }

            String street = deIDBackResult.getAddressStreet();
            if (street != null && !street.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAddressStreet,
                        street
                ));
            }

            String houseNumber = deIDBackResult.getAddressHouseNumber();
            if (houseNumber != null && !houseNumber.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAddressHouseNumber,
                        houseNumber
                ));
            }

            String authority = deIDBackResult.getAuthority();
            if (authority != null && !authority.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAuthority,
                        authority
                ));
            }

            Date dateOfIssue = deIDBackResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPIssueDate,
                        dateOfIssue
                ));
            }

            String eyeColor = deIDBackResult.getEyeColour();
            if (eyeColor != null && !eyeColor.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPEyeColour,
                        eyeColor
                ));
            }

            int height = deIDBackResult.getHeight();
            if (height != 0) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPHeight,
                        Integer.toString(height) + " cm"
                ));
            }


            super.extractMRZData(deIDBackResult);
        }

        return mExtractedData;
    }
}
