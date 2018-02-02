package com.microblink.libresult.extract.poland;
import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.poland.front.PolishIDFrontSideRecognitionResult;

import java.util.List;

/**
 * Created by daniel on 03/10/17.
 */
public class PolishIDFrontSideRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public PolishIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof PolishIDFrontSideRecognitionResult) {
            PolishIDFrontSideRecognitionResult polIdFrontResult = (PolishIDFrontSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    polIdFrontResult.getSurname()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    polIdFrontResult.getGivenNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFamilyName,
                    polIdFrontResult.getFamilyName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPParentNames,
                    polIdFrontResult.getParentsGivenNames()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    polIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    polIdFrontResult.getDateOfBirth()
            ));

        }

        return mExtractedData;
    }
}

