package com.microblink.result.extract.austria;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.austria.AustrianPassportRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;
import com.microblink.results.date.DateResult;

import java.util.List;

/**
 * Result extractor for Austrian passport
 */
public class AustrianPassportRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory{

    public AustrianPassportRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustrianPassportRecognizer) {
            AustrianPassportRecognizer.Result autPassResult = ((AustrianPassportRecognizer) result).getResult();

            String name = autPassResult.getGivenName();
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

            String sex = autPassResult.getSex();
            if (sex != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPSex,
                        sex
                ));
            }

            String nat = autPassResult.getNationality();
            if (nat != null && !nat.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPNationality,
                        nat
                ));
            }

            String authority = autPassResult.getIssuingAuthority();
            if (authority != null && !authority.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAuthority,
                        authority
                ));
            }

            DateResult dateOfBirth = autPassResult.getDateOfBirth();
            if (dateOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDateOfBirth,
                        dateOfBirth.getDate()
                ));
            }

            DateResult dateOfIssue = autPassResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPIssueDate,
                        dateOfIssue.getDate()
                ));
            }

            DateResult dateOfExpiry = autPassResult.getDateOfExpiry();
            if (dateOfExpiry != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDateOfExpiry,
                        dateOfExpiry.getDate()
                ));
            }

            mExtractedData.add(mBuilder.build(
                    R.string.PPHeight,
                    autPassResult.getHeight()
            ));

            String passportNumber = autPassResult.getPassportNumber();
            if (passportNumber != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPassportNumber,
                        passportNumber
                ));
            }

            extractMRZResult(autPassResult.getMRZResult(), mExtractedData, mBuilder);
            BlinkIDExtractionUtils.extractCommonData(autPassResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
