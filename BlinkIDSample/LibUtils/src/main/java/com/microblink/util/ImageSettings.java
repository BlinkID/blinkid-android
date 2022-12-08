package com.microblink.util;

import com.microblink.blinkid.entities.recognizers.Recognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.imageoptions.FaceImageOptions;
import com.microblink.blinkid.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions;

public class ImageSettings {

    public static Recognizer enableAllImages(Recognizer recognizer) {
        if(recognizer instanceof FullDocumentImageOptions) {
            FullDocumentImageOptions options = (FullDocumentImageOptions) recognizer;
            options.setReturnFullDocumentImage(true);
        }
        if(recognizer instanceof FaceImageOptions) {
            FaceImageOptions options = (FaceImageOptions) recognizer;
            options.setReturnFaceImage(true);
        }
        return recognizer;
    }

}
