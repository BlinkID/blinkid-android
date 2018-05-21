package com.microblink.result.extract.germany;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.germany.GermanPassportRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;
import com.microblink.results.date.Date;

import java.util.List;

/**
 * Created by mateja on 3/22/17.
 */

public class GermanPassportRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public GermanPassportRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanPassportRecognizer.Result) {
            GermanPassportRecognizer.Result dePassResult = (GermanPassportRecognizer.Result) result;

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

            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(dePassResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
