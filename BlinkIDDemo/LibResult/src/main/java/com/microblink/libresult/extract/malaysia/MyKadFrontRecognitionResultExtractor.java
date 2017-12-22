package com.microblink.libresult.extract.malaysia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.mykad.front.MyKadFrontSideRecognitionResult;
import com.microblink.results.date.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 20/11/15.
 */
public class MyKadFrontRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public MyKadFrontRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MyKadFrontSideRecognitionResult) {
            MyKadFrontSideRecognitionResult myKadFrontResult = (MyKadFrontSideRecognitionResult) result;


            mExtractedData.add(mBuilder.build(R.string.PPFullName, myKadFrontResult.getOwnerFullName()));
            mExtractedData.add(mBuilder.build(R.string.PPAddress, myKadFrontResult.getOwnerAddress()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressStreet, myKadFrontResult.getOwnerAddressStreet()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressZipCode, myKadFrontResult.getOwnerAddressZipCode()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressCity, myKadFrontResult.getOwnerAddressCity()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressState, myKadFrontResult.getOwnerAddressState()));

            Date birthDate = myKadFrontResult.getOwnerBirthDate();
            if (birthDate != null) {
                mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, birthDate));
            } else {
                mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, myKadFrontResult.getRawBirthDate()));
            }
            mExtractedData.add(mBuilder.build(R.string.PPSex, myKadFrontResult.getOwnerSex()));
            mExtractedData.add(mBuilder.build(R.string.PPReligion, myKadFrontResult.getOwnerReligion()));
            String armyNumber = myKadFrontResult.getArmyNumber();
            if (armyNumber != null && !armyNumber.isEmpty()) {
                mExtractedData.add(mBuilder.build(R.string.PPArmyNumber, armyNumber));
            }
            mExtractedData.add(mBuilder.build(R.string.PPNRICNumber, myKadFrontResult.getNRICNumber()));
        }

        return mExtractedData;
    }
}
