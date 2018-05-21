package com.microblink.result.extract.documentface;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 18/10/16.
 */
public class DocumentFaceRecognitionResultExtractor implements IBaseRecognitionResultExtractor {


    private List<RecognitionResultEntry> mExtractedData;

    private RecognitionResultEntry.Builder mBuilder;

    public DocumentFaceRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof DocumentFaceRecognizer){
            DocumentFaceRecognizer.Result documentFaceRecognitionResult = ((DocumentFaceRecognizer) result).getResult();

            mExtractedData.add(mBuilder.build(
                    R.string.MBDocumentLocation,
                    documentFaceRecognitionResult.getDocumentLocation().toString()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.MBFaceLocation,
                    documentFaceRecognitionResult.getFaceLocation().toString()
            ));

            BlinkIDExtractionUtils.extractCommonData(documentFaceRecognitionResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}