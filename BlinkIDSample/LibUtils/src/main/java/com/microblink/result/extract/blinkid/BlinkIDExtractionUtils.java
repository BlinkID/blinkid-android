package com.microblink.result.extract.blinkid;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.digitalsignature.DigitalSignatureResult;
import com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedCombinedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedSignatureImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.MrzImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.SignatureImageResult;
import com.microblink.libresult.R;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.List;

public class BlinkIDExtractionUtils {

    public static void extractCommonData(Recognizer.Result result,
                                         List<RecognitionResultEntry> extractedData,
                                         RecognitionResultEntry.Builder builder) {
        if(result instanceof FaceImageResult) {
            extractedData.add(builder.build(R.string.MBFaceImage, ((FaceImageResult) result).getFaceImage()));
        }

        if (result instanceof EncodedFaceImageResult) {
            byte[] encodedFaceImage = ((EncodedFaceImageResult) result).getEncodedFaceImage();
            if (encodedFaceImage != null) {
                extractedData.add(builder.build(R.string.MBEncodedFaceImage, encodedFaceImage));
            }
        }

        if(result instanceof SignatureImageResult) {
            extractedData.add(builder.build(R.string.MBSignatureImage, ((SignatureImageResult) result).getSignatureImage()));
        }

        if (result instanceof EncodedSignatureImageResult) {
            byte[] encodedSignatureImage = ((EncodedSignatureImageResult) result).getEncodedSignatureImage();
            if (encodedSignatureImage != null) {
                extractedData.add(builder.build(R.string.MBEncodedSignatureImage, encodedSignatureImage));
            }
        }

        if(result instanceof FullDocumentImageResult) {
            extractedData.add(builder.build(R.string.MBFullDocumentImage, ((FullDocumentImageResult) result).getFullDocumentImage()));
        }

        if (result instanceof EncodedFullDocumentImageResult) {
            byte[] encodedFullDocumentImage = ((EncodedFullDocumentImageResult) result).getEncodedFullDocumentImage();
            if (encodedFullDocumentImage != null) {
                extractedData.add(builder.build(R.string.MBEncodedFullDocumentImage, encodedFullDocumentImage));
            }
        }

        if(result instanceof CombinedFullDocumentImageResult) {
            CombinedFullDocumentImageResult combinedFullDocumentImageResult = (CombinedFullDocumentImageResult) result;
            extractedData.add(builder.build(R.string.MBFullDocumentImageFront, combinedFullDocumentImageResult.getFullDocumentFrontImage()));
            extractedData.add(builder.build(R.string.MBFullDocumentImageBack, combinedFullDocumentImageResult.getFullDocumentBackImage()));
        }

        if (result instanceof EncodedCombinedFullDocumentImageResult) {
            EncodedCombinedFullDocumentImageResult encodedCombinedFullDocumentImageResult = (EncodedCombinedFullDocumentImageResult) result;
            byte[] encodedFullDocumentImageFront = encodedCombinedFullDocumentImageResult.getEncodedFrontFullDocumentImage();
            if (encodedFullDocumentImageFront != null) {
                extractedData.add(builder.build(R.string.MBEncodedFullDocumentImageFront, encodedFullDocumentImageFront));
            }
            byte[] encodedFullDocumentImageBack = encodedCombinedFullDocumentImageResult.getEncodedBackFullDocumentImage();
            if (encodedFullDocumentImageBack != null) {
                extractedData.add(builder.build(R.string.MBEncodedFullDocumentImageBack, encodedFullDocumentImageBack));
            }
        }

        if(result instanceof MrzImageResult) {
            extractedData.add(builder.build(R.string.MBMRZImage, ((MrzImageResult) result).getMrzImage()));
        }

        if (result instanceof DigitalSignatureResult) {
            DigitalSignatureResult digitalSignatureResult = (DigitalSignatureResult) result;
            byte[] digitalSignature = digitalSignatureResult.getDigitalSignature();
            if (digitalSignature != null) {
                extractedData.add(builder.build(R.string.MBDigitalSignatureVersion, digitalSignatureResult.getDigitalSignatureVersion()));
                extractedData.add(builder.build(R.string.MBDigitalSignature, digitalSignature));
            }
        }
    }

}
