package com.microblink.blinkid.result.extract.util.images;

public class EncodedImagesUtil {

    public static boolean shouldShowEncodedImageEntry(byte[] encodedImage) {
        return encodedImage != null && encodedImage.length > 0;
    }

}
