package com.microblink.result.extract;


import java.util.List;

/**
 * Created by igor on 12/8/14.
 */
public interface IBaseRecognitionResultExtractor {

    /**
     * Returns list with extracted entries.
     *
     * @param result BaseRecognitionResult
     * @return list with extracted entries
     */
    public List<RecognitionResultEntry> extractData(Object result);
}
