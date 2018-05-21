package com.microblink.result.extract.singapore;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by Boris on 03/05/16.
 */
public class SingaporeIDFrontRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public SingaporeIDFrontRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SingaporeIDFrontRecognizer.Result){
            // result is obtained by scanning of Singapore ID
            SingaporeIDFrontRecognizer.Result singaporeIDResult = (SingaporeIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    singaporeIDResult.getCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFullName,
                    singaporeIDResult.getName()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPRace,
                    singaporeIDResult.getRace()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    singaporeIDResult.getDateOfBirth()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    singaporeIDResult.getSex()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPCountryOfBirth,
                    singaporeIDResult.getCountryOfBirth()
            ));
            BlinkIDExtractionUtils.extractCommonData(singaporeIDResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}