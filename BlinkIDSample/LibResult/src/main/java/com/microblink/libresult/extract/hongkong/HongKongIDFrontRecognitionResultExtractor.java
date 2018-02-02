package com.microblink.libresult.extract.hongkong;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.hongkong.front.HongKongIDFrontRecognitionResult;
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
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof HongKongIDFrontRecognitionResult) {
            HongKongIDFrontRecognitionResult hongKongResult = (HongKongIDFrontRecognitionResult) result;

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

        }

        return mExtractedData;
    }
}
