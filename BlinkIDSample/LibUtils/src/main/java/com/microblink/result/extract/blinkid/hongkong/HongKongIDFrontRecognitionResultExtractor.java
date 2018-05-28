package com.microblink.result.extract.blinkid.hongkong;

import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.results.date.Date;

public class HongKongIDFrontRecognitionResultExtractor extends BaseResultExtractor<HongKongIDFrontRecognizer.Result, HongKongIDFrontRecognizer> {

    @Override
    protected void extractData(HongKongIDFrontRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, result.getDocumentNumber()));
        mExtractedData.add(mBuilder.build(R.string.PPFullName, result.getOwnerFullName()));
        mExtractedData.add(mBuilder.build(R.string.PPCommercialCode, result.getOwnerCommercialCode()));
        mExtractedData.add(mBuilder.build(R.string.PPSex, result.getOwnerSex()));

        Date birthDate = result.getOwnerBirthDate();
        if (birthDate != null) {
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, birthDate));
        }

        Date dateOfIssue = result.getDateOfIssue();
        if (dateOfIssue != null) {
            mExtractedData.add(mBuilder.build(R.string.PPIssueDate, dateOfIssue));
        }
    }

}
