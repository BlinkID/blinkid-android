package com.microblink.libresult.extract;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.microblink.results.date.Date;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by igor on 12/4/14.
 */
public class RecognitionResultEntry {

    @NonNull
    private String mKey;
    private String mValue;

    public RecognitionResultEntry(@NonNull String key, @Nullable String value) {
        this.mKey = key;
        this.mValue = value;
    }

    public @NonNull String getKey() {
        return mKey;
    }

    public @NonNull String getValue() {
        return mValue == null ? "" : mValue;
    }

    @Override
    public String toString() {
        return mKey + ": " + getValue();
    }

    public static class Builder {
        private Context mContext;

        public Builder(@NonNull Context context) {
            mContext = context;
        }

        public RecognitionResultEntry build(@StringRes int key, String value) {
            return new RecognitionResultEntry(mContext.getString(key), value);
        }

        public RecognitionResultEntry build(@StringRes int key, Date value) {
            String strVal = "";
            if (value != null) {
                Calendar cal = GregorianCalendar.getInstance();
                cal.set(value.getYear(), value.getMonth() - 1, value.getDay());
                DateFormat df = DateFormat.getDateInstance();
                strVal = df.format(cal.getTime());
            }
            return new RecognitionResultEntry(mContext.getString(key), strVal);
        }

        public RecognitionResultEntry build(@StringRes int key, int amount, String currency) {
            return new RecognitionResultEntry(mContext.getString(key), RecognitionResultExtractorUtils.formatAmount(amount, currency));
        }

        public RecognitionResultEntry build(@StringRes int key, int value) {
            return new RecognitionResultEntry(mContext.getString(key), String.valueOf(value));
        }

        public RecognitionResultEntry build(@StringRes int key, boolean value) {
            return new RecognitionResultEntry(mContext.getString(key), String.valueOf(value));
        }
    }
}
