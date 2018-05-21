package com.microblink.result.extract.slovenia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.slovenia.SlovenianIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by mateja on 29/08/16.
 */
public class SlovenianIDFrontSideRecognitionResultExtractor extends TemplatingRecognizerResultExtractor {

    public SlovenianIDFrontSideRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SlovenianIDFrontRecognizer.Result){
            // result is obtained by scanning the front side of Slovenian IDs
            SlovenianIDFrontRecognizer.Result sloIdFrontResult = (SlovenianIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    sloIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    sloIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    sloIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    sloIdFrontResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    sloIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    sloIdFrontResult.getDateOfExpiry()
            ));
            BlinkIDExtractionUtils.extractCommonData(sloIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;

    }
}
