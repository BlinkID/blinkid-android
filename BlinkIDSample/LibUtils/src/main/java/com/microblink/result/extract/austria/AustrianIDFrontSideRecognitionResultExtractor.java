package com.microblink.result.extract.austria;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.austria.AustrianIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by dodo on 24/05/16.
 */

public class AustrianIDFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {
    public AustrianIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof AustrianIDFrontSideRecognizer) {

            AustrianIDFrontSideRecognizer.Result ausIdFrontResult = ((AustrianIDFrontSideRecognizer) result).getResult();

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    ausIdFrontResult.getSurname()
            ));

            ausIdFrontResult.getEncodedSignatureImage();
            ausIdFrontResult.getEncodedFullDocumentImage();
            ausIdFrontResult.getEncodedFaceImage();

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    ausIdFrontResult.getGivenName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    ausIdFrontResult.getDocumentNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    ausIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    ausIdFrontResult.getDateOfBirth().getDate()
            ));

            BlinkIDExtractionUtils.extractCommonData(ausIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
