package com.microblink.result.extract.slovakia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.slovakia.SlovakIDFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by igrce on 26/08/16.
 */
public class SlovakIDFrontSideRecognitionResultExtractor  extends TemplatingRecognizerResultExtractor {

    public SlovakIDFrontSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SlovakIDFrontRecognizer.Result) {
            SlovakIDFrontRecognizer.Result svkIdFrontResult = (SlovakIDFrontRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    svkIdFrontResult.getLastName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    svkIdFrontResult.getFirstName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    svkIdFrontResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    svkIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    svkIdFrontResult.getDocumentNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuedBy,
                    svkIdFrontResult.getIssuedBy()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    svkIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPersonalNumber,
                    svkIdFrontResult.getPersonalNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    svkIdFrontResult.getDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    svkIdFrontResult.getDateOfIssue()
            ));
            BlinkIDExtractionUtils.extractCommonData(svkIdFrontResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
