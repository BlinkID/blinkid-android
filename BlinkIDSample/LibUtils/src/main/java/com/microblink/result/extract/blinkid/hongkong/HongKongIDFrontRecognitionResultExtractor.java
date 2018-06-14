package com.microblink.result.extract.blinkid.hongkong;

import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.results.date.Date;

public class HongKongIDFrontRecognitionResultExtractor extends BaseResultExtractor<HongKongIdFrontRecognizer.Result, HongKongIdFrontRecognizer> {

    @Override
    protected void extractData(HongKongIdFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPCommercialCode, result.getCommercialCode());
        add(R.string.PPSex, result.getSex());

        Date birthDate = result.getDateOfBirth();
        if (birthDate != null) {
            add(R.string.PPDateOfBirth, birthDate);
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            add(R.string.PPIssueDate, dateOfIssue);
        }
    }

}
