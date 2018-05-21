package com.microblink.result.extract.colombia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ColombiaIDBackRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public ColombiaIDBackRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof ColombiaIDBackSideRecognizer.Result) {
            ColombiaIDBackSideRecognizer.Result colombiaIDBackResult = (ColombiaIDBackSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, colombiaIDBackResult.getDocumentNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPFirstName, colombiaIDBackResult.getOwnerFirsName()));
            mExtractedData.add(mBuilder.build(R.string.PPLastName, colombiaIDBackResult.getOwnerLastName()));
            mExtractedData.add(mBuilder.build(R.string.PPSex, colombiaIDBackResult.getOwnerSex()));
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, colombiaIDBackResult.getOwnerDateOfBirth()));
            mExtractedData.add(mBuilder.build(R.string.PPBloodGroup, colombiaIDBackResult.getOwnerBloodGroup()));
            mExtractedData.add(mBuilder.build(R.string.PPFingerprint, Arrays.toString(colombiaIDBackResult.getOwnerFingerprint())));

            BlinkIDExtractionUtils.extractCommonData(colombiaIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
