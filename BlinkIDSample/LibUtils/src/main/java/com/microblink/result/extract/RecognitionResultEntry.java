package com.microblink.result.extract;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.libresult.R;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class RecognitionResultEntry {

    @NonNull
    private String mKey;
    private String mValue;
    private Bitmap mImageValue;

    public RecognitionResultEntry(@NonNull String key, @Nullable String value) {
        mKey = key;
        mValue = value;
    }

    public RecognitionResultEntry(@NonNull String key, @Nullable Bitmap value) {
        mKey = key;
        mImageValue = value;
    }

    public @NonNull String getKey() {
        return mKey;
    }

    public @NonNull String getValue() {
        return mValue == null ? "" : mValue;
    }

    @Nullable
    public Bitmap getImageValue() { return mImageValue; }

    @Override
    public String toString() {
        return mKey + ": " + getValue();
    }

    public static class Builder {
        private Context mContext;
        private String keySuffix = "";

        public Builder(@NonNull Context context) {
            mContext = context;
        }

        public Builder setKeySuffix(String keySuffix) {
            this.keySuffix = keySuffix;
            return this;
        }

        @NonNull
        private String createKey(@StringRes int keyId) {
            String key = mContext.getString(keyId);
            if (!TextUtils.isEmpty(keySuffix)) {
                key = key + " " + keySuffix;
            }
            return key;
        }

        public RecognitionResultEntry build(@StringRes int key, String value) {
            if (key == R.string.PPIBAN) {
                return new RecognitionResultEntry(createKey(key), RecognitionResultExtractorUtils.formatIBAN(value));
            } else {
                return new RecognitionResultEntry(createKey(key), value);
            }
        }

        public RecognitionResultEntry build(@StringRes int key, DateResult value) {
            if (value == null) {
                return new RecognitionResultEntry(createKey(key), "");
            } else {
                return build(key, value.getDate());
            }
        }

        public RecognitionResultEntry build(@StringRes int key, Date value) {
            String strVal = "";
            if (value != null) {
                Calendar cal = GregorianCalendar.getInstance();
                cal.clear();
                // year always exists
                cal.set(Calendar.YEAR, value.getYear());
                // if date is partial, day and month can be 0
                StringBuilder dateFormat = new StringBuilder();
                int day = value.getDay();
                if (day != 0) {
                    cal.set(Calendar.DATE, day);
                    dateFormat.append("dd/");
                }
                int month = value.getMonth();
                if (month != 0) {
                    cal.set(Calendar.MONTH, month -1);
                    dateFormat.append("MM/");
                }
                dateFormat.append("yyyy");
                SimpleDateFormat df = new SimpleDateFormat(dateFormat.toString(), Locale.US);
                strVal = df.format(cal.getTime());
            }
            return new RecognitionResultEntry(createKey(key), strVal);
        }

        public RecognitionResultEntry build(@StringRes int key, int amount, String currency) {
            return new RecognitionResultEntry(createKey(key), RecognitionResultExtractorUtils.formatAmount(amount, currency));
        }

        public RecognitionResultEntry build(@StringRes int key, int value) {
            return new RecognitionResultEntry(createKey(key), String.valueOf(value));
        }

        public RecognitionResultEntry build(@StringRes int key, long value) {
            return new RecognitionResultEntry(createKey(key), String.valueOf(value));
        }

        public RecognitionResultEntry build(@StringRes int key, byte[] bytes) {
            String value = null;
            if (bytes != null) {
                int len = bytes.length;
                value = Integer.toString(len) + " bytes";
                if (len > 1024) {
                    value += " (" + Double.toString( len / 1024.0 ) + " kiB)";
                }
            }
            return new RecognitionResultEntry(createKey(key), value);
        }

        public RecognitionResultEntry build(@StringRes int key, boolean value) {
            return new RecognitionResultEntry(createKey(key), String.valueOf(value));
        }

        public RecognitionResultEntry build(@StringRes int key, Image value) {
            if ( value == null ) {
                return build( key, "" );
            } else {
                Bitmap img = value.convertToBitmap();
                if ( img != null && value.getImageOrientation() != Orientation.ORIENTATION_UNKNOWN ) {

                    boolean needTransform = false;

                    // matrix for transforming the image
                    Matrix matrix = new Matrix();
                    int newWidth = img.getWidth();
                    int newHeight = img.getHeight();

                    if ( value.getImageOrientation() != Orientation.ORIENTATION_LANDSCAPE_RIGHT ) {
                        needTransform = true;
                        float pX = newWidth / 2.f;
                        float pY = newWidth / 2.f;

                        // rotate image and rescale image
                        if (value.getImageOrientation() == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                            matrix.postRotate(180.f, pX, pY);
                        } else {
                            if (value.getImageOrientation() == Orientation.ORIENTATION_PORTRAIT) {
                                matrix.postRotate(90.f, pX, pY);
                            } else if (value.getImageOrientation() == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                                matrix.postRotate(270.f, pX, pY);
                            }
                        }
                    }

                    // if image is too large, scale it down so it can be displayed in image view
                    int maxDimension = Math.max(newWidth, newHeight);
                    final int maxAllowedDimension = 1920;
                    if (maxDimension > maxAllowedDimension) {
                        needTransform = true;
                        float scale = (float) maxAllowedDimension / maxDimension;
                        matrix.postScale(scale, scale);
                    }
                    if (needTransform) {
                        img = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, false);
                    }
                }
                return new RecognitionResultEntry(createKey(key), img);
            }
        }
    }
}
