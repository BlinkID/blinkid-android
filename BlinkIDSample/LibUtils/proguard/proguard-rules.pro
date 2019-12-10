-renamesourcefileattribute line

# HelpActivity is public
-keep public class com.microblink.help.** {
    *;
}

# ResultActivity is public
-keep public class com.microblink.result.ResultActivity {
    *;
}

# ResultActivityBeta is public
-keep public class com.microblink.result.ResultActivityBeta {
    *;
}

# StatisticsActivity is public
-keep public class com.microblink.statistics.StatisticsActivity {
    *;
}

# DefaultImageListener is public
-keep public class com.microblink.result.DefaultImageListener {
    *;
}

-keep class com.microblink.fullscreen.** {
    *;
}

-keep class com.microblink.customcamera.** {
    *;
}

-keep class com.microblink.util.templating.** {
    public *;
}

-keep class com.microblink.detector.DetectorActivity {
    *;
}

-keep class com.microblink.result.extract.RecognitionResultExtractorFactory {
    public *;
}

-keep interface com.microblink.result.extract.IBaseRecognitionResultExtractor {
    public *;
}

-keep class com.microblink.result.extract.RecognitionResultEntry {
    public *;
}

-keep class com.microblink.util.BlinkOcrConfigurator {
    public *;
}

# new gradle plugin does not do that, and causes app to violently crash
-keep class **.R$* {
    *;
}