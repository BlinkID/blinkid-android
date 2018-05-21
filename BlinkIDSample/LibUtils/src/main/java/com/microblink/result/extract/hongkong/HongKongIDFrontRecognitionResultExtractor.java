package com.microblink.result.extract.hongkong;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.results.date.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 20/11/15.
 */
public class HongKongIDFrontRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public HongKongIDFrontRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof HongKongIDFrontRecognizer.Result) {
            HongKongIDFrontRecognizer.Result hongKongResult = (HongKongIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, hongKongResult.getDocumentNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPFullName, hongKongResult.getOwnerFullName()));
            mExtractedData.add(mBuilder.build(R.string.PPCommercialCode, hongKongResult.getOwnerCommercialCode()));
            mExtractedData.add(mBuilder.build(R.string.PPSex, hongKongResult.getOwnerSex()));

            Date birthDate = hongKongResult.getOwnerBirthDate();
            if (birthDate != null) {
                mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, birthDate));
            }

            Date dateOfIssue = hongKongResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(R.string.PPIssueDate, dateOfIssue));
            }
            BlinkIDExtractionUtils.extractCommonData(hongKongResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
