package com.microblink.blinkid;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Parcel;

import com.microblink.image.Image;
import com.microblink.image.ImageListener;
import com.microblink.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyImageListener implements ImageListener {

   /**
    * Called when library has image available.
    */
    @Override
    public void onImageAvailable(Image image) {
        // we will save images to 'myImages' folder on external storage
        // image filenames will be 'imageType - currentTimestamp.jpg'
        String output = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myImages";
        File f = new File(output);
        if(!f.exists()) {
            f.mkdirs();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateString = dateFormat.format(new Date());
        String filename = null;
        switch(image.getImageFormat()) {
            case ALPHA_8: {
                filename = output + "/alpha_8 - " + image.getImageName() + " - " + dateString + ".jpg";
                break;
            }
            case BGRA_8888: {
                filename = output + "/bgra - " + image.getImageName() + " - " + dateString + ".jpg";
                break;
            }
            case YUV_NV21: {
                filename = output + "/yuv - " + image.getImageName()+ " - " + dateString + ".jpg";
                break;
            }
        }
        Bitmap b = image.convertToBitmap();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            boolean success = b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            if(!success) {
                Log.e(this, "Failed to compress bitmap!");
                if(fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ignored) {
                    } finally {
                        fos = null;
                    }
                    new File(filename).delete();
                }
            }
        } catch (FileNotFoundException e) {
            Log.e(this, e, "Failed to save image");
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                }
            }
        }
        // after this line, image gets disposed. If you want to save it
        // for later, you need to clone it with image.clone()
    }

    /**
     * ImageListener interface extends Parcelable interface, so we also need to implement
     * that interface. The implementation of Parcelable interface is below this line.
     */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static final Creator<MyImageListener> CREATOR = new Creator<MyImageListener>() {
        @Override
        public MyImageListener createFromParcel(Parcel source) {
            return new MyImageListener();
        }

        @Override
        public MyImageListener[] newArray(int size) {
            return new MyImageListener[size];
        }
    };
}