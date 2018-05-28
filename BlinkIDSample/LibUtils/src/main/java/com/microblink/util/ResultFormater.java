package com.microblink.util;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;

import java.util.Locale;

/**
 * Created by igor on 12/15/14.
 */
public class ResultFormater {

    public static String formatAmount(int amount, String currency) {
        if ("Ft".equals(currency)) {
            return String.format(Locale.US, "%d " + currency, amount);
        }

        String stringBuilder = "%d,%02d " +
                currency;
        return String.format(Locale.US, stringBuilder, amount / 100, amount % 100);
    }

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

    public static String stringifyRecognitionResults(Recognizer<?,?>[] recognizers) {
        StringBuilder sb = new StringBuilder();
        if (recognizers == null) {
            return "";
        }
        for (Recognizer<?,?> rec : recognizers) {
            if (rec.getResult().getResultState() != Recognizer.Result.State.Empty) {
                sb.append(rec.getResult().getClass().getSimpleName());
                sb.append(":\n");
                sb.append(rec.getResult().toString());
                sb.append("\n\n");
            }
        }

        return sb.toString();
    }

    public static CharSequence getRecognizerSimpleName(Recognizer<?, ?> recognizer) {
        if (recognizer instanceof SuccessFrameGrabberRecognizer) {
            return getRecognizerSimpleName(((SuccessFrameGrabberRecognizer) recognizer).getSlaveRecognizer());
        } else {
            return recognizer.getClass().getSimpleName();
        }
    }
}
