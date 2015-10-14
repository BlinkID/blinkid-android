package com.microblink.blinkid.result.extract;

/**
 * Created by igor on 12/4/14.
 */
public class RecognitionResultEntry {

    private String key;
    private String value;

    public RecognitionResultEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (key != null) {
            builder.append(key);
        }
        if (value != null) {
            builder.append(value);
        }
        return builder.toString();
    }
}
