package com.microblink.result.extract.singapore;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by Boris on 03/05/16.
 */
public class SingaporeIDBackRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public SingaporeIDBackRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SingaporeIDBackRecognizer.Result){
            // result is obtained by scanning of Singapore ID
            SingaporeIDBackRecognizer.Result singaporeIDResult = (SingaporeIDBackRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    singaporeIDResult.getCardNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBloodGroup,
                    singaporeIDResult.getBloodGroup()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    singaporeIDResult.getDocumentDateOfIssue()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    singaporeIDResult.getAddress()
            ));
            BlinkIDExtractionUtils.extractCommonData(singaporeIDResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}