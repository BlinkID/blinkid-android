package com.microblink.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.microblink.MicroblinkSDK;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.highres.HighResImageWrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ImageUtils {

    private static final String IMAGES_FOLDER = "Documents/microblink";
    private static final String HIGH_RES_IMAGES_FOLDER = IMAGES_FOLDER + "/HighRes";
    private static final String FRAMES_FOLDER = IMAGES_FOLDER + "/Frames";

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

    public static void storeHighResImage(Context context, String imageName, @NonNull HighResImageWrapper image) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            storeImageToScopedStorage(imageName, HIGH_RES_IMAGES_FOLDER, image.getImage().convertToBitmap());
            Toast.makeText(context, "Saved to " + HIGH_RES_IMAGES_FOLDER, Toast.LENGTH_SHORT).show();
        } else {
            final String imagesFolderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + HIGH_RES_IMAGES_FOLDER;
            File imagesDir = new File(imagesFolderPath);
            if (!imagesDir.exists()) {
                imagesDir.mkdirs();
            }

            String imagePath = imagesFolderPath + "/" + imageName;
            File file = new File(imagePath);

            try {
                image.saveToFile(file);
                MediaScannerConnection.scanFile(context, new String[]{imagePath}, null, null);
                Toast.makeText(context, "Saved to " + HIGH_RES_IMAGES_FOLDER, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void storeImage(@NonNull Image image, String imageName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
        String dateString = dateFormat.format(new Date());
        String fullImageName = imageName + " - " + image.getImageType().name() + " - " + image.getImageFormat().name() + " - " + image.getImageOrientation().name()  + " - " + dateString + ".jpg";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            storeImageToScopedStorage(fullImageName, FRAMES_FOLDER, image.convertToBitmap());
        } else {
            final String imagesFolderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + FRAMES_FOLDER;
            File imagesDir = new File(imagesFolderPath);
            if (!imagesDir.exists()) {
                if (!imagesDir.mkdirs()) {
                    Log.w(ImageUtils.class, "Failed to create folder " + imagesFolderPath);
                }
            }

            String filename = imagesFolderPath + "/" + fullImageName;
            Bitmap b = image.convertToBitmap();
            if (b == null) {
                Log.e(ImageUtils.class, "Failed to convert image to bitmap!");
                return;
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(filename);
                boolean success = b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                if (!success) {
                    Log.e(ImageUtils.class, "Failed to compress bitmap!");
                    try {
                        fos.close();
                    } catch (IOException ignored) {
                    } finally {
                        fos = null;
                    }
                    boolean deleteSuccess = new File(filename).delete();
                    if (!deleteSuccess) {
                        Log.e(ImageUtils.class, "Failed to delete {}", filename);
                    }
                }
            } catch (FileNotFoundException e) {
                Log.e(ImageUtils.class, e, "Failed to save image");
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        }
    }

    private static void storeImageToScopedStorage(String imageName, String imageFolder, Bitmap bitmap) {
        Context context = MicroblinkSDK.getApplicationContext();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Files.FileColumns.DISPLAY_NAME, imageName);
        contentValues.put(MediaStore.Files.FileColumns.MIME_TYPE, "image/jpeg");
        contentValues.put(MediaStore.Files.FileColumns.RELATIVE_PATH, imageFolder);
        contentValues.put(MediaStore.Files.FileColumns.IS_PENDING, 1);

        ContentResolver contentResolver = context.getContentResolver();
        Uri collection = MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
        Uri uri = contentResolver.insert(collection, contentValues);

        try {
            OutputStream stream = contentResolver.openOutputStream(uri);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            contentValues.clear();
            contentValues.put(MediaStore.Files.FileColumns.IS_PENDING, 0);
            contentResolver.update(uri, contentValues, null, null);
        }
    }

}
