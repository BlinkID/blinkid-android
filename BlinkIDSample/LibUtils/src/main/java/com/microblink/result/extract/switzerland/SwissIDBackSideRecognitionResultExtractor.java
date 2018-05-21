package com.microblink.result.extract.switzerland;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.switzerland.SwissIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;
import com.microblink.results.date.Date;

import java.util.List;

/**
 * Created by daniel on 7/21/17.
 */

public class SwissIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public SwissIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SwissIDBackRecognizer.Result) {
            SwissIDBackRecognizer.Result swissIdBackResult = (SwissIDBackRecognizer.Result) result;

            String placeOfOrigin = swissIdBackResult.getPlaceOfOrigin();
            if (placeOfOrigin != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPlaceOfOrigin,
                        placeOfOrigin
                ));
            }

            String authority = swissIdBackResult.getAuthority();
            if (authority != null && !authority.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAuthority,
                        authority
                ));
            }

            Date dateOfIssue = swissIdBackResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPIssueDate,
                        dateOfIssue
                ));
            }

            Date dateOfExpiry = swissIdBackResult.getNonMRZDateOfExpiry();
            if (dateOfExpiry != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDateOfExpiry,
                        dateOfExpiry
                ));
            }

            String sex = swissIdBackResult.getNonMRZSex();
            if (sex != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPSex,
                        sex
                ));
            }

            String height = swissIdBackResult.getHeight();
            if (height != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPHeight,
                        height
                ));
            }
            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(swissIdBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }

}
