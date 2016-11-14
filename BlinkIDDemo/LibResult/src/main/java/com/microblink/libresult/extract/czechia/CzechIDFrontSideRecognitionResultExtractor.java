package com.microblink.libresult.extract.czechia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.czechia.front.CzechIDFrontSideRecognitionResult;

import java.util.List;

public class CzechIDFrontSideRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {
    public CzechIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof CzechIDFrontSideRecognitionResult) {
            CzechIDFrontSideRecognitionResult czechIdFrontResult = (CzechIDFrontSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    czechIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    czechIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    czechIdFrontResult.getIdentityCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    czechIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    czechIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    czechIdFrontResult.getDateOfIssue()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPExpiryDate,
                    czechIdFrontResult.getDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    czechIdFrontResult.getPlaceOfBirth()
            ));

        }

        return mExtractedData;
    }
}
