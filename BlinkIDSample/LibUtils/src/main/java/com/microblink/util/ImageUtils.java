package com.microblink.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;

public class ImageUtils {

    public static Bitmap transformImage(Image image) {
        Bitmap bitmapImage = image.convertToBitmap();
        if ( bitmapImage != null && image.getImageOrientation() != Orientation.ORIENTATION_UNKNOWN ) {

            boolean needTransform = false;

            // matrix for transforming the image
            Matrix matrix = new Matrix();
            int newWidth = bitmapImage.getWidth();
            int newHeight = bitmapImage.getHeight();

            if ( image.getImageOrientation() != Orientation.ORIENTATION_LANDSCAPE_RIGHT ) {
                needTransform = true;
                float pX = newWidth / 2.f;
                float pY = newWidth / 2.f;

                // rotate image and rescale image
                if (image.getImageOrientation() == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                    matrix.postRotate(180.f, pX, pY);
                } else {
                    if (image.getImageOrientation() == Orientation.ORIENTATION_PORTRAIT) {
                        matrix.postRotate(90.f, pX, pY);
                    } else if (image.getImageOrientation() == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
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
                bitmapImage = Bitmap.createBitmap(bitmapImage, 0, 0, bitmapImage.getWidth(), bitmapImage.getHeight(), matrix, false);
            }
        }

        return bitmapImage;
    }
}
