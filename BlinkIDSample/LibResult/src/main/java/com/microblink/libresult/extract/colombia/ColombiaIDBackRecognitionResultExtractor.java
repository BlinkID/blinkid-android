package com.microblink.libresult.extract.colombia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.colombia.back.ColombiaIDBackRecognitionResult;

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
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof ColombiaIDBackRecognitionResult) {
            ColombiaIDBackRecognitionResult colombiaIDBackResult = (ColombiaIDBackRecognitionResult) result;

            mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, colombiaIDBackResult.getDocumentNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPFirstName, colombiaIDBackResult.getOwnerFirsName()));
            mExtractedData.add(mBuilder.build(R.string.PPLastName, colombiaIDBackResult.getOwnerLastName()));
            mExtractedData.add(mBuilder.build(R.string.PPSex, colombiaIDBackResult.getOwnerSex()));
            mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, colombiaIDBackResult.getOwnerDateOfBirth()));
            mExtractedData.add(mBuilder.build(R.string.PPBloodGroup, colombiaIDBackResult.getOwnerBloodGroup()));
            mExtractedData.add(mBuilder.build(R.string.PPFingerprint, Arrays.toString(colombiaIDBackResult.getOwnerFingerprint())));

        }

        return mExtractedData;
    }
}
