package com.microblink.libresult.extract.austria;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.austria.passport.AustrianPassportRecognitionResult;
import com.microblink.results.date.Date;

import java.util.List;


/**
 * Result extractor for Austrian passport
 */
public class AustrianPassportRecognitionResultExtractor extends MRTDRecognitionResultExtractor{

    public AustrianPassportRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustrianPassportRecognitionResult) {
            AustrianPassportRecognitionResult autPassResult = (AustrianPassportRecognitionResult) result;

            String name = autPassResult.getName();
            if (name != null && !name.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPFirstName,
                        name
                ));
            }

            String surname = autPassResult.getSurname();
            if (surname != null && !surname.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPLastName,
                        surname
                ));
            }

            String placeOfBirth = autPassResult.getPlaceOfBirth();
            if (placeOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPlaceOfBirth,
                        placeOfBirth
                ));
            }

            String sex = autPassResult.getNonMRZSex();
            if (sex != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPSex,
                        sex
                ));
            }

            String nat = autPassResult.getNonMRZNationality();
            if (nat != null && !nat.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPNationality,
                        nat
                ));
            }

            String authority = autPassResult.getAuthority();
            if (authority != null && !authority.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAuthority,
                        authority
                ));
            }

            Date dateOfBirth = autPassResult.getNonMRZDateOfBirth();
            if (dateOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDateOfBirth,
                        dateOfBirth
                ));
            }

            Date dateOfIssue = autPassResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPIssueDate,
                        dateOfIssue
                ));
            }

            Date dateOfExpiry = autPassResult.getNonMRZDateOfExpiry();
            if (dateOfExpiry != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDateOfExpiry,
                        dateOfExpiry
                ));
            }

            String height = autPassResult.getHeight();
            if (height != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPHeight,
                        height
                ));
            }

            String passportNumber = autPassResult.getPassportNumber();
            if (passportNumber != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPassportNumber,
                        passportNumber
                ));
            }

            super.extractMRZData(autPassResult);
        }

        return mExtractedData;
    }
}
