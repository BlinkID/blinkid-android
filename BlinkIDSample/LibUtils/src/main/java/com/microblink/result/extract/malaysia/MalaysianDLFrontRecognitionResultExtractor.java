package com.microblink.result.extract.malaysia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.malaysia.MalaysianDLFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matea K on 14.02.18
 */
public class MalaysianDLFrontRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public MalaysianDLFrontRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MalaysianDLFrontRecognizer.Result) {
            MalaysianDLFrontRecognizer.Result malaysianDLFrontResult = (MalaysianDLFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(R.string.PPIdentityNumber, malaysianDLFrontResult.getIdentityNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPFullName, malaysianDLFrontResult.getName()));
            mExtractedData.add(mBuilder.build(R.string.PPNationality, malaysianDLFrontResult.getNationality()));
            mExtractedData.add(mBuilder.build(R.string.PPClass, malaysianDLFrontResult.getDLClass()));
            mExtractedData.add(mBuilder.build(R.string.PPValidFrom, malaysianDLFrontResult.getValidFrom()));
            mExtractedData.add(mBuilder.build(R.string.PPValidUntil, malaysianDLFrontResult.getValidUntil()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressStreet, malaysianDLFrontResult.getStreet()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressZipCode, malaysianDLFrontResult.getZipCode()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressCity, malaysianDLFrontResult.getCity()));
            mExtractedData.add(mBuilder.build(R.string.PPAddressState, malaysianDLFrontResult.getState()));
            mExtractedData.add(mBuilder.build(R.string.PPAddress, malaysianDLFrontResult.getFullAddress()));

            BlinkIDExtractionUtils.extractCommonData(malaysianDLFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
