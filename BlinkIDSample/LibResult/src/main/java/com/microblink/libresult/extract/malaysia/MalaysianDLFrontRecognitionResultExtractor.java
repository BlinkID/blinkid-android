package com.microblink.libresult.extract.malaysia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.dl.front.MalaysianDLFrontRecognitionResult;

import java.util.List;

public class MalaysianDLFrontRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public MalaysianDLFrontRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MalaysianDLFrontRecognitionResult) {
            MalaysianDLFrontRecognitionResult malaysianDLFrontResult = (MalaysianDLFrontRecognitionResult) result;

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

        }

        return mExtractedData;
    }
}
