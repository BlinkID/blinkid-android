package com.microblink.result.extract.utils;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.libresult.R;
import com.microblink.recognizers.blinkid.digitalsignature.DigitalSignatureResult;
import com.microblink.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult;
import com.microblink.recognizers.blinkid.imageresult.EncodedCombinedFullDocumentImageResult;
import com.microblink.recognizers.blinkid.imageresult.EncodedFaceImageResult;
import com.microblink.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult;
import com.microblink.recognizers.blinkid.imageresult.EncodedSignatureImageResult;
import com.microblink.recognizers.blinkid.imageresult.FaceImageResult;
import com.microblink.recognizers.blinkid.imageresult.FullDocumentImageResult;
import com.microblink.recognizers.blinkid.imageresult.MrzImageResult;
import com.microblink.recognizers.blinkid.imageresult.SignatureImageResult;
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
            extractedData.add(builder.build(R.string.MBEncodedFaceImage, ((EncodedFaceImageResult) result).getEncodedFaceImage()));
        }

        if(result instanceof SignatureImageResult) {
            extractedData.add(builder.build(R.string.MBSignatureImage, ((SignatureImageResult) result).getSignatureImage()));
        }

        if (result instanceof EncodedSignatureImageResult) {
            extractedData.add(builder.build(R.string.MBEncodedSignatureImage, ((EncodedSignatureImageResult) result).getEncodedSignatureImage()));
        }

        if(result instanceof FullDocumentImageResult) {
            extractedData.add(builder.build(R.string.MBFullDocumentImage, ((FullDocumentImageResult) result).getFullDocumentImage()));
        }

        if (result instanceof EncodedFullDocumentImageResult) {
            extractedData.add(builder.build(R.string.MBEncodedFullDocumentImage, ((EncodedFullDocumentImageResult) result).getEncodedFullDocumentImage()));
        }

        if(result instanceof CombinedFullDocumentImageResult) {
            CombinedFullDocumentImageResult combinedFullDocumentImageResult = (CombinedFullDocumentImageResult) result;
            extractedData.add(builder.build(R.string.MBFullDocumentImageFront, combinedFullDocumentImageResult.getFullDocumentFrontImage()));
            extractedData.add(builder.build(R.string.MBFullDocumentImageBack, combinedFullDocumentImageResult.getFullDocumentBackImage()));
        }

        if (result instanceof EncodedCombinedFullDocumentImageResult) {
            EncodedCombinedFullDocumentImageResult encodedCombinedFullDocumentImageResult = (EncodedCombinedFullDocumentImageResult) result;
            extractedData.add(builder.build(R.string.MBEncodedFullDocumentImageFront, encodedCombinedFullDocumentImageResult.getEncodedFrontFullDocumentImage()));
            extractedData.add(builder.build(R.string.MBEncodedFullDocumentImageBack, encodedCombinedFullDocumentImageResult.getEncodedBackFullDocumentImage()));
        }

        if(result instanceof MrzImageResult) {
            extractedData.add(builder.build(R.string.MBMRZImage, ((MrzImageResult) result).getMrzImage()));
        }

        if (result instanceof DigitalSignatureResult) {
            DigitalSignatureResult digitalSignatureResult = (DigitalSignatureResult) result;
            extractedData.add(builder.build(R.string.MBDigitalSignatureVersion, digitalSignatureResult.getDigitalSignatureVersion()));
            extractedData.add(builder.build(R.string.MBDigitalSignature, digitalSignatureResult.getDigitalSignature()));
        }
    }

}
