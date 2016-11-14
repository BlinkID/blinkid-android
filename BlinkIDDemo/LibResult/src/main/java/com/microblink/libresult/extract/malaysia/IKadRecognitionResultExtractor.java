package com.microblink.libresult.extract.malaysia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.IKadRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateja on 9/19/16.
 */
public class IKadRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public IKadRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }
        if (result instanceof IKadRecognitionResult) {
            IKadRecognitionResult iKadResult = (IKadRecognitionResult) result;

            mExtractedData.add(mBuilder.build(R.string.PPFullName, iKadResult.getFullName()));
            mExtractedData.add(mBuilder.build(R.string.PPAddress, iKadResult.getAddress()));
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, iKadResult.getDateOfBirth()));
            mExtractedData.add(mBuilder.build(R.string.PPEmployer, iKadResult.getEmployer()));
            mExtractedData.add(mBuilder.build(R.string.PPDateOfExpiry, iKadResult.getExpiryDate()));
            mExtractedData.add(mBuilder.build(R.string.PPNationality, iKadResult.getNationality()));
            mExtractedData.add(mBuilder.build(R.string.PPPassportNumber, iKadResult.getPassportNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPSector, iKadResult.getSector()));
            mExtractedData.add(mBuilder.build(R.string.PPSex, iKadResult.getSex()));
        }

        return mExtractedData;
    }
}
