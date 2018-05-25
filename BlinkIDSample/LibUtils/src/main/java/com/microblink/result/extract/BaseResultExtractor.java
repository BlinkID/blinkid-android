package com.microblink.result.extract;

import android.content.Context;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDDocumentType;
import com.microblink.entities.recognizers.blinkid.mrtd.MRZResult;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIDExtractionUtils;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseResultExtractor<ResultType extends Recognizer.Result, RecognizerType extends Recognizer<?, ResultType>> {

    protected RecognitionResultEntry.Builder mBuilder;
    protected List<RecognitionResultEntry> mExtractedData;
    protected RecognizerType mRecognizer;
    protected Context mContext;

    public List<RecognitionResultEntry> extractData(Context context, RecognizerType recognizer) {
        mContext = context;
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
        mRecognizer = recognizer;
        ResultType result = recognizer.getResult();
        extractData(result);
        BlinkIDExtractionUtils.extractCommonData(result, mExtractedData, mBuilder);
        return mExtractedData;
    }

    protected abstract void extractData(ResultType result);

    protected void add(int key, String value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void add(int key, DateResult date) {
        mExtractedData.add(mBuilder.build(key, date.getDate()));
    }

    protected void add(int key, Date date) {
        mExtractedData.add(mBuilder.build(key, date));
    }

    protected void add(int key, boolean value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void extractMRZResult(MRZResult mrzResult) {
        MRTDDocumentType docType = mrzResult.getDocumentType();

        add(R.string.PPMRTDDocumentType, docType.toString());
        add(R.string.PPMRZParsed, mrzResult.isMRZParsed());
        add(R.string.PPMRZVerified, mrzResult.isMRZVerified());
        add(R.string.PPPrimaryId, mrzResult.getPrimaryId());
        add(R.string.PPSecondaryId, mrzResult.getSecondaryId());
        add(R.string.PPDateOfBirth, mrzResult.getDateOfBirth().getDate());
        add(R.string.PPSex, mrzResult.getGender());
        add(R.string.PPNationality, mrzResult.getNationality());
        add(R.string.PPDocumentCode, mrzResult.getDocumentCode());
        add(R.string.PPIssuer, mrzResult.getIssuer());
        add(R.string.PPDateOfExpiry, mrzResult.getDateOfExpiry().getDate());
        add(R.string.PPOpt2, mrzResult.getOpt2());
        add(R.string.PPMRZText, mrzResult.getMRZText());

        if (docType == MRTDDocumentType.MRTD_TYPE_GREEN_CARD) {
            add(R.string.PPAlienNumber, mrzResult.getAlienNumber());
            add(R.string.PPApplicationReceiptNumber, mrzResult.getApplicationReceiptNumber());
            add(R.string.PPImmigrantCaseNumber, mrzResult.getImmigrantCaseNumber());
        } else {
            add(R.string.PPDocumentNumber, mrzResult.getDocumentNumber());
            add(R.string.PPOpt1, mrzResult.getOpt1());
        }
    }

}
