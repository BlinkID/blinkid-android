package com.microblink.libresult.extract.malaysia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.mykad.back.MyKadBackSideRecognitionResult;

import java.util.List;

/**
 * Created by Matea K on 11.10.17..
 */

public class MyKadBackRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor {

    public MyKadBackRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MyKadBackSideRecognitionResult) {
            // result is obtained by scanning the front side of Slovenian IDs
            MyKadBackSideRecognitionResult myKadBackResult = (MyKadBackSideRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPExtendedNRIC,
                    myKadBackResult.getExtendedNRIC()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNRICNumber,
                    myKadBackResult.getNRIC()
            ));


            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    myKadBackResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    myKadBackResult.getSex()
            ));

        }

        return mExtractedData;
    }

}