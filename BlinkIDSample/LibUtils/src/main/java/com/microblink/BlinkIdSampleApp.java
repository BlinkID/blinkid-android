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
    protected String getLicenseKey() {
        return "sRwCABZjb20ubWljcm9ibGluay5ibGlua2lkAGxleUpEY21WaGRHVmtUMjRpT2pFM01URXdNamd4TnpVeU5qQXNJa055WldGMFpXUkdiM0lpT2lKa1pHUXdOalpsWmkwMU9ESXpMVFF3TURndE9UUTRNQzAxTkRVNFlqQXhZVFUyWWpnaWZRPT0XQSGw4MlSYFI4GLBuTrvzIIXpisl+k7h/R9V8iUNw+edq0mlVNOnFqeHImrWXu8UbaKaxqggm6j+lxv818EBLdZ3EaqbZnHZxvOJ2r6SmLdfH8BKXU8OQkyr0VLU4be2TM2DmktEjagaIbkikp96uNyEKCx/3ag==";
    }

}
