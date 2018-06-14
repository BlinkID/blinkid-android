package com.microblink.util;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.MrzImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.SignatureImageOptions;

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
        if(recognizer instanceof SignatureImageOptions) {
            SignatureImageOptions options = (SignatureImageOptions) recognizer;
            options.setReturnSignatureImage(true);
        }
        if(recognizer instanceof MrzImageOptions) {
            MrzImageOptions options = (MrzImageOptions) recognizer;
            options.setReturnMrzImage(true);
        }
        return recognizer;
    }

}
