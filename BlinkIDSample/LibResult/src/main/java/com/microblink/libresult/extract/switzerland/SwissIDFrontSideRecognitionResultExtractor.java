package com.microblink.libresult.extract.switzerland;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.switzerland.front.SwissIDFrontSideRecognitionResult;

import java.util.List;


/**
 * Created by daniel on 8/3/17.
 */
public class SwissIDFrontSideRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public SwissIDFrontSideRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SwissIDFrontSideRecognitionResult){
            // result is obtained by scanning the front side of Swiss IDs
            SwissIDFrontSideRecognitionResult sloIdFrontResult = (SwissIDFrontSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    sloIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    sloIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    sloIdFrontResult.getDateOfBirth()
            ));

        }

        return mExtractedData;

    }
}

