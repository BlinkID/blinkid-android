package com.microblink;

import com.microblink.blinkid.SampleApplication;
import com.microblink.blinkid.result.extract.BaseResultExtractorFactory;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdResultExtractorFactory;

public final class BlinkIdSampleApp extends SampleApplication {

    @Override
    protected BaseResultExtractorFactory createResultExtractorFactory() {
        return new BlinkIdResultExtractorFactory();
    }

    @Override
    protected String getLicenceFilePath() {
        return "com.microblink.blinkid.mblic";
    }

}
