package com.microblink.result;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;

public class ResultUtils {

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
