package com.microblink.libresult.extract.malaysia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.MyKadRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 20/11/15.
 */
public class MyKadRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public MyKadRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MyKadRecognitionResult) {
            MyKadRecognitionResult myKadResult = (MyKadRecognitionResult) result;

            mExtractedData.add(mBuilder.build(R.string.PPFullName, myKadResult.getOwnerFullName()));
            mExtractedData.add(mBuilder.build(R.string.PPAddress, myKadResult.getOwnerAddress()));
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, myKadResult.getOwnerBirthDate()));
            mExtractedData.add(mBuilder.build(R.string.PPSex, myKadResult.getOwnerSex()));
            mExtractedData.add(mBuilder.build(R.string.PPReligion, myKadResult.getOwnerReligion()));
            mExtractedData.add(mBuilder.build(R.string.PPNRICNumber, myKadResult.getNRICNumber()));
        }

        return mExtractedData;
    }
}
