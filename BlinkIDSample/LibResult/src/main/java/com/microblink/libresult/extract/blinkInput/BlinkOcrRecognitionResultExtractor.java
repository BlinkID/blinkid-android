package com.microblink.libresult.extract.blinkInput;

import android.content.Context;

import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.IResultHolder;
import com.microblink.recognizers.blinkocr.BlinkOCRRecognitionResult;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class BlinkOcrRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    protected RecognitionResultEntry.Builder mBuilder;
    protected Context mContext;
    protected List<RecognitionResultEntry> mExtractedData;

    public BlinkOcrRecognitionResultExtractor(Context context) {
        mContext = context;
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    /**
     * Returns list with extracted entries.
     *
     * @param result BaseRecognitionResult
     * @return list with extracted entries
     */
    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof BlinkOCRRecognitionResult) {
            BlinkOCRRecognitionResult blinkOcrResult = (BlinkOCRRecognitionResult) result;

            // you can retrieve parsed element with getParsedResult method. The key
            // that should be used is the same as scan configuration's "parser name" (3rd)
            // constructor argument
            // For example to retrieve parsed IBAN, provided we installed parser with name "IBAN":
            // String iban = blinkOcrResult.getParsedResult("IBAN");

            // here we will extract all elements from result
            IResultHolder data = blinkOcrResult.getResultHolder();
            for(String key : data.keySet()) {
                Object field = data.getObject(key);
                if (field instanceof String) {
                    mExtractedData.add(new RecognitionResultEntry(key, (String) field));
                } else if (field instanceof DateResult) {
                    Date date = ((DateResult) field).getDate();
                    mExtractedData.add(new RecognitionResultEntry(key,
                            String.format("%d-%02d-%02d", date.getYear(), date.getMonth(),
                                    date.getDay())));
                }
            }
        }

        return mExtractedData;
    }
}
