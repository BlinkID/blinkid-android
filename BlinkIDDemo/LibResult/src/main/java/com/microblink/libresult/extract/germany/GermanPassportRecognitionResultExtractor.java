package com.microblink.libresult.extract.germany;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.germany.passport.GermanPassportRecognitionResult;
import com.microblink.results.date.Date;

import java.util.List;

/**
 * Created by mateja on 3/22/17.
 */

public class GermanPassportRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public GermanPassportRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanPassportRecognitionResult) {
            GermanPassportRecognitionResult dePassResult = (GermanPassportRecognitionResult) result;

            String name = dePassResult.getName();
            if (name != null && !name.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPFirstName,
                        name
                ));
            }

            String surname = dePassResult.getSurname();
            if (surname != null && !surname.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPLastName,
                        surname
                ));
            }

            String authority = dePassResult.getAuthority();
            if (authority != null && !authority.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAuthority,
                        authority
                ));
            }

            Date dateOfIssue = dePassResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPIssueDate,
                        dateOfIssue
                ));
            }

            String nat = dePassResult.getNationality();
            if (nat != null && !nat.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPNationality,
                        nat
                ));
            }

            String placeOfBirth = dePassResult.getPlaceOfBirth();
            if (placeOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPlaceOfBirth,
                        placeOfBirth
                ));
            }

            super.extractMRZData(dePassResult);
        }

        return mExtractedData;
    }
}
