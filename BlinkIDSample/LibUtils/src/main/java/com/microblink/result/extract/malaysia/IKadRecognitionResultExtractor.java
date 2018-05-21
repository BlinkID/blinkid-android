package com.microblink.result.extract.malaysia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.malaysia.IKadRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

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
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }
        if (result instanceof IKadRecognizer.Result) {
            IKadRecognizer.Result iKadResult = (IKadRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(R.string.PPFullName, iKadResult.getFullName()));
            mExtractedData.add(mBuilder.build(R.string.PPAddress, iKadResult.getAddress()));
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, iKadResult.getDateOfBirth()));
            mExtractedData.add(mBuilder.build(R.string.PPEmployer, iKadResult.getEmployer()));
            mExtractedData.add(mBuilder.build(R.string.PPDateOfExpiry, iKadResult.getExpiryDate()));
            mExtractedData.add(mBuilder.build(R.string.PPNationality, iKadResult.getNationality()));
            mExtractedData.add(mBuilder.build(R.string.PPPassportNumber, iKadResult.getPassportNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPSector, iKadResult.getSector()));
            mExtractedData.add(mBuilder.build(R.string.PPSex, iKadResult.getSex()));

            BlinkIDExtractionUtils.extractCommonData(iKadResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
