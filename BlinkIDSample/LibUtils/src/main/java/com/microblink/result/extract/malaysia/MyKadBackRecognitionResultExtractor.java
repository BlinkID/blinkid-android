package com.microblink.result.extract.malaysia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by Matea K on 11.10.17..
 */

public class MyKadBackRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public MyKadBackRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MyKadBackRecognizer.Result) {
            // result is obtained by scanning the front side of Slovenian IDs
            MyKadBackRecognizer.Result myKadBackResult = (MyKadBackRecognizer.Result) result;

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
            BlinkIDExtractionUtils.extractCommonData(myKadBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }

}