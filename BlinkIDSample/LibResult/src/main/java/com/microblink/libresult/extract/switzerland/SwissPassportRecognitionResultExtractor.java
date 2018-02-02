package com.microblink.libresult.extract.switzerland;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.switzerland.passport.SwissPassportRecognitionResult;
import com.microblink.results.date.Date;

import java.util.List;

/**
 * Created by daniel on 7/19/17.
 */
public class SwissPassportRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public SwissPassportRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SwissPassportRecognitionResult) {
            SwissPassportRecognitionResult swissPassResult = (SwissPassportRecognitionResult) result;

            String name = swissPassResult.getName();
            if (name != null && !name.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPFirstName,
                        name
                ));
            }

            String surname = swissPassResult.getSurname();
            if (surname != null && !surname.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPLastName,
                        surname
                ));
            }

            String placeOfOrigin = swissPassResult.getPlaceOfOrigin();
            if (placeOfOrigin != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPlaceOfOrigin,
                        placeOfOrigin
                ));
            }

            String authority = swissPassResult.getAuthority();
            if (authority != null && !authority.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAuthority,
                        authority
                ));
            }

            Date dateOfBirth = swissPassResult.getNonMRZDateOfBirth();
            if (dateOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDateOfBirth,
                        dateOfBirth
                ));
            }

            Date dateOfIssue = swissPassResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPIssueDate,
                        dateOfIssue
                ));
            }

            Date dateOfExpiry = swissPassResult.getNonMRZDateOfExpiry();
            if (dateOfExpiry != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDateOfExpiry,
                        dateOfExpiry
                ));
            }

            String passportNumber = swissPassResult.getPassportNumber();
            if (passportNumber != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPassportNumber,
                        passportNumber
                ));
            }

            String sex = swissPassResult.getNonMRZSex();
            if (sex != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPSex,
                        sex
                ));
            }

            String height = swissPassResult.getHeight();
            if (height != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPHeight,
                        height
                ));
            }

            super.extractMRZData(swissPassResult);
        }

        return mExtractedData;
    }

}
