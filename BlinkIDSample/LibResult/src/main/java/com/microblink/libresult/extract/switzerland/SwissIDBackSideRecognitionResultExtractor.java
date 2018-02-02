package com.microblink.libresult.extract.switzerland;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.switzerland.back.SwissIDBackSideRecognitionResult;
import com.microblink.results.date.Date;

import java.util.List;

/**
 * Created by daniel on 7/21/17.
 */

public class SwissIDBackSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public SwissIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SwissIDBackSideRecognitionResult) {
            SwissIDBackSideRecognitionResult swissIdBackResult = (SwissIDBackSideRecognitionResult) result;

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

            super.extractMRZData(swissIdBackResult);
        }

        return mExtractedData;
    }

}
