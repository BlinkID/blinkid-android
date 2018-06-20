package com.microblink.result.extract.blinkid.switzerland;

import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;
import com.microblink.results.date.Date;

public class SwissIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<SwitzerlandIdBackRecognizer.Result, SwitzerlandIdBackRecognizer> {

    @Override
    protected void extractData(SwitzerlandIdBackRecognizer.Result result) {
        super.extractData(result);

        String placeOfOrigin = result.getPlaceOfOrigin();
        if (placeOfOrigin != null) {
            add(R.string.PPPlaceOfOrigin, placeOfOrigin);
        }

        String authority = result.getAuthority();
        if (authority != null && !authority.isEmpty()) {
            add(R.string.PPAuthority, authority);
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            add(R.string.PPIssueDate, dateOfIssue);
        }

        Date dateOfExpiry = result.getNonMrzDateOfExpiry();
        if (dateOfExpiry != null) {
            add(R.string.PPDateOfExpiry, dateOfExpiry);
        }

        String sex = result.getNonMrzSex();
        if (sex != null) {
            add(R.string.PPSex, sex);
        }

        String height = result.getHeight();
        if (height != null) {
            add(R.string.PPHeight, height);
        }
    }

}
