package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyDlBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;


public class GermanDLBackSideRecognitionResultExtractor extends BlinkIdExtractor<GermanyDlBackRecognizer.Result, GermanyDlBackRecognizer> {

    @Override
    protected void extractData(GermanyDlBackRecognizer.Result result) {
        add(R.string.PPDateOfIssueDlCategoryB, result.getDateOfIssueB10());
        add(R.string.PPDateOfIssueDlCategoryBNotSpecified, result.isDateOfIssueB10NotSpecified());
    }

}
