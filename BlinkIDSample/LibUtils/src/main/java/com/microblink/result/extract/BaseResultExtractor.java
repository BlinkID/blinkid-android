package com.microblink.result.extract;

import android.content.Context;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.result.ResultSource;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseResultExtractor<ResultType extends Recognizer.Result, RecognizerType extends Recognizer<ResultType>> {

    protected RecognitionResultEntry.Builder mBuilder;
    protected List<RecognitionResultEntry> mExtractedData;
    protected RecognizerType mRecognizer;
    protected Context mContext;

    public List<RecognitionResultEntry> extractData(Context context, RecognizerType recognizer, ResultSource resultSource) {
        mContext = context;
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
        mRecognizer = recognizer;

        ResultType result = recognizer.getResult();
        extractData(result, resultSource);
        onDataExtractionDone(result, resultSource);

        return mExtractedData;
    }

    // override if needed
    public boolean doesSupportResultSourceExtraction() {
        return false;
    }

    // override if needed
    protected void onDataExtractionDone(ResultType result) {}
    protected void onDataExtractionDone(ResultType result, ResultSource resultSource) {
        onDataExtractionDone(result);
    }

    protected abstract void extractData(ResultType result);
    protected void extractData(ResultType result, ResultSource resultSource) {
        extractData(result);
    }

    protected void add(int key, String value) {
        mExtractedData.add(mBuilder.build(key, value));
    }

    protected void addIfNotEmpty(int key, String value) {
        if (!value.isEmpty()) {
            mExtractedData.add(mBuilder.build(key, value));
        }
    }

    protected void add(int key, int value, String valueSuffix) {
        mExtractedData.add(mBuilder.build(key, value, valueSuffix));
    }

    protected void add(int key, DateResult date) {
        mExtractedData.add(mBuilder.build(key, date.getDate()));
    }

    protected void addIfNotEmpty(int key, DateResult dateResult) {
        Date date = dateResult.getDate();
        if (date != null && date.getDay() > 0) {
            mExtractedData.add(mBuilder.build(key, date));
        }
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

    protected void add(int key, byte[] value) {
        mExtractedData.add(mBuilder.build(key, value));
    }


}
