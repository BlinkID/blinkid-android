package com.microblink.result.extract;

import com.microblink.result.extract.blinkid.BlinkIdResultExtractorFactory;

public class ResultExtractorFactoryProvider {

    private static final BlinkIdResultExtractorFactory extractorFactory = new BlinkIdResultExtractorFactory();

    public static BaseResultExtractorFactory get() {
        return extractorFactory;
    }

}
