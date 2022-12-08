-renamesourcefileattribute line

# HelpActivity is public
-keep public class com.microblink.blinkid.help.** {
    *;
}

# ResultActivity is public
-keep public class com.microblink.blinkid.result.ResultActivity {
    *;
}

# ResultActivityBeta is public
-keep public class com.microblink.blinkid.result.ResultActivityBeta {
    *;
}

# StatisticsActivity is public
-keep public class com.microblink.blinkid.statistics.StatisticsActivity {
    *;
}

# DefaultImageListener is public
-keep public class com.microblink.blinkid.result.DefaultImageListener {
    *;
}

-keep class com.microblink.blinkid.fullscreen.** {
    *;
}

-keep class com.microblink.blinkid.customcamera.** {
    *;
}

-keep class com.microblink.blinkid.util.templating.** {
    public *;
}

-keep class com.microblink.blinkid.detector.DetectorActivity {
    *;
}

-keep class com.microblink.blinkid.result.extract.RecognitionResultExtractorFactory {
    public *;
}

-keep interface com.microblink.blinkid.result.extract.IBaseRecognitionResultExtractor {
    public *;
}

-keep class com.microblink.blinkid.result.extract.RecognitionResultEntry {
    public *;
}

-keep class com.microblink.blinkid.util.BlinkOcrConfigurator {
    public *;
}

# new gradle plugin does not do that, and causes app to violently crash
-keep class **.R$* {
    *;
}