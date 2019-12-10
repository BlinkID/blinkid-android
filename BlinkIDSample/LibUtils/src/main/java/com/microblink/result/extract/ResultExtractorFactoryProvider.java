package com.microblink.result.extract;

public class ResultExtractorFactoryProvider {

    private static BaseResultExtractorFactory resultExtractorFactory;

    public static BaseResultExtractorFactory get() {
        if (resultExtractorFactory == null) throw new NullPointerException("Please set result extractor factory!");
        return resultExtractorFactory;
    }

    public static void set(BaseResultExtractorFactory extractorFactory) {
        resultExtractorFactory = extractorFactory;
    }

}
