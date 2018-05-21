package com.microblink.result.extract;

import android.content.Context;

import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.IResultHolder;
import com.microblink.results.date.DateResult;
import com.microblink.util.LibResultConstants;
import com.microblink.util.ResultFormater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by igor on 12/4/14.
 */
public class BaseRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    /**
     * Extracted data storage.
     */
    protected List<RecognitionResultEntry> mExtractedData;

    Context mContext;

    public BaseRecognitionResultExtractor(Context mContext) {
        this.mContext = mContext;
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {
        if (result == null) {
            return mExtractedData;
        }
        BaseRecognitionResult baseResult = (BaseRecognitionResult) result;
        IResultHolder resultHolder = baseResult.getResultHolder();
        for (String key : resultHolder.keySet()) {
            Object value = resultHolder.getObject(key);
            String stringlValue = null;
            if (value instanceof Integer) {
                Integer intValue = (Integer) value;
                if (key.equals(LibResultConstants.AMOUNT)) {
                    String currency = baseResult.getStringElement(LibResultConstants.CURRENCY);
                    stringlValue = ResultFormater.formatAmount(intValue, currency);
                }
            } else if (value instanceof String) {
                stringlValue = (String) value;
                if (key.equals(LibResultConstants.IBAN)) {
                    stringlValue = ResultFormater.formatIBAN(stringlValue);
                }
            } else if (value instanceof DateResult) {
                stringlValue = ((DateResult) value).getOriginalDateString();
            }
            if (!key.equals(LibResultConstants.RAW_RESULT) && stringlValue != null && !stringlValue.isEmpty()) {
                mExtractedData.add(new RecognitionResultEntry(
                        key,
                        stringlValue
                ));
            }
        }
        mExtractedData.add(new RecognitionResultEntry("valid", Boolean.valueOf(baseResult.isValid()).toString()));
        mExtractedData.add(new RecognitionResultEntry("empty", Boolean.valueOf(baseResult.isEmpty()).toString()));
        return mExtractedData;
    }

}
