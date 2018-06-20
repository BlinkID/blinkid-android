package com.microblink.result.extract;

import android.content.Context;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdDocumentType;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
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
        onDataExtractionDone(result);

        return mExtractedData;
    }

    // override if needed
    protected void onDataExtractionDone(ResultType result) {}

    protected abstract void extractData(ResultType result);

    protected void add(int key, String value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void add(int key, int value, String valueSuffix) {
        mExtractedData.add(mBuilder.build(key, value, valueSuffix));
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

    protected void add(int key, int value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

}
