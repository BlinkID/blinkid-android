package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;
import com.microblink.results.date.Date;

public class SwissIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<SwitzerlandIDBackRecognizer.Result, SwitzerlandIDBackRecognizer> {

    @Override
    protected void extractData(SwitzerlandIDBackRecognizer.Result result) {
        super.extractData(result);

        String placeOfOrigin = result.getPlaceOfOrigin();
        if (placeOfOrigin != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfOrigin,
                    placeOfOrigin
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

        Date dateOfExpiry = result.getNonMRZDateOfExpiry();
        if (dateOfExpiry != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    dateOfExpiry
            ));
        }

        String sex = result.getNonMRZSex();
        if (sex != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    sex
            ));
        }

        String height = result.getHeight();
        if (height != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPHeight,
                    height
            ));
        }
    }

}
