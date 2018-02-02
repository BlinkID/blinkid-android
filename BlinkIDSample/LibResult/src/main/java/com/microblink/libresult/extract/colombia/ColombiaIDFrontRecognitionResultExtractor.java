package com.microblink.libresult.extract.colombia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.colombia.front.ColombiaIDFrontRecognitionResult;

import java.util.ArrayList;
import java.util.List;


public class ColombiaIDFrontRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public ColombiaIDFrontRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof ColombiaIDFrontRecognitionResult) {
            ColombiaIDFrontRecognitionResult
                    colombiaIDFrontResult = (ColombiaIDFrontRecognitionResult) result;

            mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, colombiaIDFrontResult.getDocumentNumber()));
            mExtractedData.add(mBuilder.build(R.string.PPFirstName, colombiaIDFrontResult.getOwnerFirsName()));
            mExtractedData.add(mBuilder.build(R.string.PPLastName, colombiaIDFrontResult.getOwnerLastName()));

        }

        return mExtractedData;
    }
}
