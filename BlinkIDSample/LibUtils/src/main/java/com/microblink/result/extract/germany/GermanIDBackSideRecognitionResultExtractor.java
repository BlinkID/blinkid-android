package com.microblink.result.extract.germany;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.germany.GermanIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;
import com.microblink.results.date.Date;

import java.util.List;

/**
 * Created by daniel on 4/12/17.
 */
public class GermanIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public GermanIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanIDBackSideRecognizer.Result) {
            GermanIDBackSideRecognizer.Result deIDBackResult = (GermanIDBackSideRecognizer.Result) result;

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

            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(deIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
