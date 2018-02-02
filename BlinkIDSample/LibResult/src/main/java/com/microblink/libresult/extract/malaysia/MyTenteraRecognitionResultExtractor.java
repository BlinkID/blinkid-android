package com.microblink.libresult.extract.malaysia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.tentera.MyTenteraRecognitionResult;
import com.microblink.results.date.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 20/11/15.
 */
public class MyTenteraRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public MyTenteraRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MyTenteraRecognitionResult) {
            MyTenteraRecognitionResult myTenteraResult = (MyTenteraRecognitionResult) result;

            mExtractedData.add(mBuilder.build(R.string.PPArmyNumber, myTenteraResult.getArmyNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPFullName, myTenteraResult.getOwnerFullName()));
            mExtractedData.add(mBuilder.build(R.string.PPAddress, myTenteraResult.getOwnerAddress()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressStreet, myTenteraResult.getOwnerAddressStreet()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressZipCode, myTenteraResult.getOwnerAddressZipCode()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressCity, myTenteraResult.getOwnerAddressCity()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressState, myTenteraResult.getOwnerAddressState()));

            Date birthDate = myTenteraResult.getOwnerBirthDate();
            if (birthDate != null) {
                mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, birthDate));
            }

            mExtractedData.add(mBuilder.build(R.string.PPSex, myTenteraResult.getOwnerSex()));
            mExtractedData.add(mBuilder.build(R.string.PPReligion, myTenteraResult.getOwnerReligion()));
            mExtractedData.add(mBuilder.build(R.string.PPNRICNumber, myTenteraResult.getNRICNumber()));
        }

        return mExtractedData;
    }
}
