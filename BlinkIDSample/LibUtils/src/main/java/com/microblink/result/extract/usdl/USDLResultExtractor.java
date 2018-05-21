package com.microblink.result.extract.usdl;

import android.content.Context;

import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLKeys;
import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

public final class USDLResultExtractor implements IBaseRecognitionResultExtractor {
    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;

    public USDLResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if ( result == null ) {
            return mExtractedData;
        }

        if (result instanceof USDLRecognizer) {
            USDLRecognizer.Result usdlResult = ((USDLRecognizer) result).getResult();

            for (USDLKeys key : USDLKeys.values()) {
                mExtractedData.add(new RecognitionResultEntry(key.name(), usdlResult.getField(key)));
            }

            // now also build optional data
            String optionalData = "";
            {
                StringBuilder optionalDataBuilder = new StringBuilder();
                String[] optionalElements = usdlResult.getOptionalElements();
                for ( String d : optionalElements ) {
                    optionalDataBuilder.append(d);
                    optionalDataBuilder.append('\n');
                }
                optionalData = optionalDataBuilder.toString().trim();
            }
            mExtractedData.add(mBuilder.build(R.string.PPOptionalData, optionalData));
        }

        return mExtractedData;
    }
}
