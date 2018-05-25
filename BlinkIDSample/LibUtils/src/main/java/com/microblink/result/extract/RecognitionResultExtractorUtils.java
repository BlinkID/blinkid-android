package com.microblink.result.extract;

import java.util.Locale;

public abstract class RecognitionResultExtractorUtils {

    public static String formatIBAN(String value) {
        if (value == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); ++i) {
            builder.append(value.charAt(i));
            if (i % 4 == 3)
                builder.append(' ');
        }
        return builder.toString().trim();
    }

    public static String formatAmount(int amount, String currency) {
        if ("HUF".equals(currency)) {
            return String.format(Locale.US, "%d " + currency, amount);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("%d,%02d ");
            stringBuilder.append(currency);
            return String.format(Locale.US, stringBuilder.toString(), amount / 100, amount % 100);
        }
    }
}
