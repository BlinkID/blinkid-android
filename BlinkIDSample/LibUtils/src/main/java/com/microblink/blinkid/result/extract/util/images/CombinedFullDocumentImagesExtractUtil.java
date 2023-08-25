package com.microblink.blinkid.result.extract.util.images;

import com.microblink.blinkid.entities.recognizers.Recognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult;
import com.microblink.blinkid.entities.recognizers.blinkid.imageresult.EncodedCombinedFullDocumentImageResult;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.RecognitionResultEntry;

import java.util.List;

public class CombinedFullDocumentImagesExtractUtil {

    public static void extractCombinedFullDocumentImages(Recognizer.Result result,
                                                         List<RecognitionResultEntry> extractedData,
                                                         RecognitionResultEntry.Builder builder) {

        if(result instanceof CombinedFullDocumentImageResult) {
            CombinedFullDocumentImageResult combinedFullDocumentImageResult = (CombinedFullDocumentImageResult) result;
            extractedData.add(builder.build(R.string.MBFullDocumentImageFront, combinedFullDocumentImageResult.getFullDocumentFrontImage()));
            extractedData.add(builder.build(R.string.MBFullDocumentImageBack, combinedFullDocumentImageResult.getFullDocumentBackImage()));
        }

        if (result instanceof EncodedCombinedFullDocumentImageResult) {
            EncodedCombinedFullDocumentImageResult encodedCombinedFullDocumentImageResult = (EncodedCombinedFullDocumentImageResult) result;
            byte[] encodedFullDocumentImageFront = encodedCombinedFullDocumentImageResult.getEncodedFrontFullDocumentImage();
            if (EncodedImagesUtil.shouldShowEncodedImageEntry(encodedFullDocumentImageFront)) {
                extractedData.add(builder.build(R.string.MBEncodedFullDocumentImageFront, encodedFullDocumentImageFront));
            }
            byte[] encodedFullDocumentImageBack = encodedCombinedFullDocumentImageResult.getEncodedBackFullDocumentImage();
            if (EncodedImagesUtil.shouldShowEncodedImageEntry(encodedFullDocumentImageBack)) {
                extractedData.add(builder.build(R.string.MBEncodedFullDocumentImageBack, encodedFullDocumentImageBack));
            }
        }
    }
}
