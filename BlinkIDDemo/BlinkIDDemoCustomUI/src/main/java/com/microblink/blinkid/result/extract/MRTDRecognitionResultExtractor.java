package com.microblink.blinkid.result.extract;

import android.content.Context;

import com.microblink.blinkid.demo.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.ocr.mrtd.MRTDRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 12/19/14.
 */
public class MRTDRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    Context mContext;
    List<RecognitionResultEntry> mExtractedData;

    public MRTDRecognitionResultExtractor(Context mContext) {
        this.mContext = mContext;
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MRTDRecognitionResult) {
            MRTDRecognitionResult mrtdResult = (MRTDRecognitionResult) result;

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPPrimaryId),
                    mrtdResult.getPrimaryId()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPSecondaryId),
                    mrtdResult.getSecondaryId()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPIssuer),
                    mrtdResult.getIssuer()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPNationality),
                    mrtdResult.getNationality()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDateOfBirth),
                    mrtdResult.getDateOfBirth()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDocumentNumber),
                    mrtdResult.getDocumentNumber()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPSex),
                    mrtdResult.getSex()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDocumentCode),
                    mrtdResult.getDocumentCode()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDateOfExpiry),
                    mrtdResult.getDateOfExpiry()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPOpt1),
                    mrtdResult.getOpt1()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPOpt2),
                    mrtdResult.getOpt2()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPMRZText),
                    mrtdResult.getMRZText()
            ));
        }

        return mExtractedData;
    }
}
