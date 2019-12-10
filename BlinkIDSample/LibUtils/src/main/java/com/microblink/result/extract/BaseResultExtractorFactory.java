package com.microblink.result.extract;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseResultExtractorFactory {

    private Map<String, BaseResultExtractor> extractorMap = new HashMap<>();

    public BaseResultExtractor createExtractor(Recognizer recognizer) {
        if (extractorMap.isEmpty()) {
            // SuccessFrameGrabberResultExtractor is needed in all cases
            add(SuccessFrameGrabberRecognizer.class,
                    new SuccessFrameGrabberResultExtractor());
            addExtractors();
        }

        String key = recognizer.getClass().getName();
        if (extractorMap.containsKey(key)) {
            return extractorMap.get(key);
        } else {
            throw new UnsupportedOperationException("Unknown recognizer");
        }
    }

    protected abstract void addExtractors();

    protected void add(Class recognizerClass, BaseResultExtractor extractor) {
        extractorMap.put(recognizerClass.getName(), extractor);
    }
}
