package com.microblink.result;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.support.annotation.NonNull;

import com.microblink.image.CurrentImageListener;
import com.microblink.image.DebugImageListener;
import com.microblink.image.Image;
import com.microblink.image.SuccessfulImageListener;
import com.microblink.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DefaultImageListener implements DebugImageListener, SuccessfulImageListener, CurrentImageListener {

    private String mOutputFolder;

    public DefaultImageListener(@NonNull String outputFolder) {
        mOutputFolder = outputFolder;
    }

    @Override
    public void onImageAvailable(@NonNull Image image) {
        saveImage(image, image.getImageName());
    }

    @Override
    public void onFrameAvailable(Image cameraFrame, boolean isFocused, double frameQuality) {
        String name = "currentFrame - " + (isFocused ? "focused" : "unfocused") + " - Q " + frameQuality;
        saveImage(cameraFrame, name);
    }

    @Override
    public void onSuccessfulImageAvailable(@NonNull Image image) {
        saveImage(image, image.getImageName());
    }

    private void saveImage(@NonNull Image image, String imageName) {
        File f = new File(mOutputFolder);
        if (!f.exists()) {
            if (!f.mkdirs()) {
                Log.w(this, "Failed to create folder " + mOutputFolder);
            }
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
        String dateString = dateFormat.format(new Date());
        String filename;
        filename = mOutputFolder + "/" + imageName + " - " + image.getImageType().name() + " - " + image.getImageFormat().name() + " - " + image.getImageOrientation().name()  + " - " + dateString + ".jpg";
        Bitmap b = image.convertToBitmap();
        if (b == null) {
            Log.e(this, "Failed to convert image to bitmap!");
            return;
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            boolean success = b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            if (!success) {
                Log.e(this, "Failed to compress bitmap!");
                try {
                    fos.close();
                } catch (IOException ignored) {
                } finally {
                    fos = null;
                }
                boolean deleteSuccess = new File(filename).delete();
                if (!deleteSuccess) {
                    Log.e(this, "Failed to delete {}", filename);
                }
            }
        } catch (FileNotFoundException e) {
            Log.e(this, e, "Failed to save image");
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mOutputFolder);
    }

    private DefaultImageListener(Parcel in) {
        mOutputFolder = in.readString();
    }

    public static final Creator<DefaultImageListener> CREATOR = new Creator<DefaultImageListener>() {
        @Override
        public DefaultImageListener createFromParcel(Parcel source) {
            return new DefaultImageListener(source);
        }

        @Override
        public DefaultImageListener[] newArray(int size) {
            return new DefaultImageListener[size];
        }
    };
}
