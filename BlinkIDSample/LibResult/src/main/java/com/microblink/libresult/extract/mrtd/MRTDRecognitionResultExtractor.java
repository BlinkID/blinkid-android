package com.microblink.libresult.extract.mrtd;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognitionResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 12/19/14.
 */
public class MRTDRecognitionResultExtractor implements IBaseRecognitionResultExtractor {

    protected RecognitionResultEntry.Builder mBuilder;
    protected List<RecognitionResultEntry> mExtractedData;

    public MRTDRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    protected final void extractMRZData(MRTDRecognitionResult mrtdResult) {
        mExtractedData.add(mBuilder.build(
                R.string.PPPrimaryId,
                mrtdResult.getPrimaryId()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPSecondaryId,
                mrtdResult.getSecondaryId()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPIssuer,
                mrtdResult.getIssuer()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPNationality,
                mrtdResult.getNationality()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                mrtdResult.getDateOfBirth()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                mrtdResult.getDocumentNumber()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                mrtdResult.getSex()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentCode,
                mrtdResult.getDocumentCode()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                mrtdResult.getDateOfExpiry()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPOpt1,
                mrtdResult.getOpt1()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPOpt2,
                mrtdResult.getOpt2()
        ));
        mExtractedData.add(mBuilder.build(
                R.string.PPMRZText,
                mrtdResult.getMRZText()
        ));
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MRTDRecognitionResult) {
            MRTDRecognitionResult mrtdResult = (MRTDRecognitionResult) result;

            extractMRZData(mrtdResult);

            // additionally, add all elements that from non-MRZ
            for (String s : mrtdResult.getResultHolder().keySet()) {
                // if s contains '.', then it is part of non-MRZ data
                if (s.contains(".") && !s.contains("OCRResult")) {
                    String[] chunks = s.split("\\.");
                    mExtractedData.add(new RecognitionResultEntry(s, mrtdResult.getParsedResult(chunks[0], chunks[1])));
                }
            }

        }

        return mExtractedData;
    }
}
