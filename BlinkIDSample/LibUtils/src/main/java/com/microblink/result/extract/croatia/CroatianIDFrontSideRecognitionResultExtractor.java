package com.microblink.result.extract.croatia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.croatia.CroatianIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by Boris on 26/04/16.
 */
public class CroatianIDFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public CroatianIDFrontSideRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof CroatianIDFrontSideRecognizer.Result){
            // result is obtained by scanning front side of Croatian ID
            CroatianIDFrontSideRecognizer.Result croIdFrontResult = (CroatianIDFrontSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    croIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    croIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    croIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    croIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPCitizenship,
                    croIdFrontResult.getCitizenship()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    croIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    croIdFrontResult.getDocumentDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiryPermanent,
                    croIdFrontResult.getDocumentDateOfExpiryPermanent()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentBilingual,
                    croIdFrontResult.isDocumentBilingual()
            ));

            BlinkIDExtractionUtils.extractCommonData(croIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;

    }
}
