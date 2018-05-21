package com.microblink.result.extract.malaysia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
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
public class MyKadFrontRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public MyKadFrontRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MyKadFrontRecognizer.Result) {
            MyKadFrontRecognizer.Result myKadFrontResult = (MyKadFrontRecognizer.Result) result;

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
            BlinkIDExtractionUtils.extractCommonData(myKadFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
