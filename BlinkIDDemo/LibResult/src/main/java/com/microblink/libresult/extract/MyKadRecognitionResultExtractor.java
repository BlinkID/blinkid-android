package com.microblink.libresult.extract;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.MyKadRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 20/11/15.
 */
public class MyKadRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    List<RecognitionResultEntry> mExtractedData;

    Context mContext;

    public MyKadRecognitionResultExtractor(Context mContext) {
        this.mContext = mContext;
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MyKadRecognitionResult) {
            MyKadRecognitionResult myKadResult = (MyKadRecognitionResult) result;

            mExtractedData.add(new RecognitionResultEntry(mContext.getString(R.string.PPFullName), myKadResult.getOwnerFullName()));
            mExtractedData.add(new RecognitionResultEntry(mContext.getString(R.string.PPAddress), myKadResult.getOwnerAddress()));
            mExtractedData.add(new RecognitionResultEntry(mContext.getString(R.string.PPDateOfBirth), myKadResult.getOwnerBirthDate()));
            mExtractedData.add(new RecognitionResultEntry(mContext.getString(R.string.PPSex), myKadResult.getOwnerSex()));
            mExtractedData.add(new RecognitionResultEntry(mContext.getString(R.string.PPReligion), myKadResult.getOwnerReligion()));
            mExtractedData.add(new RecognitionResultEntry(mContext.getString(R.string.PPNRICNumber), myKadResult.getNRICNumber()));
        }

        return mExtractedData;
    }
}
