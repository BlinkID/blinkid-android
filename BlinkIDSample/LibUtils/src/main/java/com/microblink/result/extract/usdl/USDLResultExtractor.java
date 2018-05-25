package com.microblink.result.extract.usdl;

import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLKeys;
import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

public class USDLResultExtractor extends BaseResultExtractor<USDLRecognizer.Result, USDLRecognizer> {

    @Override
    protected void extractData(USDLRecognizer.Result result) {
        for (USDLKeys key : USDLKeys.values()) {
            mExtractedData.add(new RecognitionResultEntry(key.name(), result.getField(key)));
        }

        StringBuilder optionalDataBuilder = new StringBuilder();
        String[] optionalElements = result.getOptionalElements();
        for (String d : optionalElements) {
            optionalDataBuilder.append(d);
            optionalDataBuilder.append('\n');
        }
        String optionalData = optionalDataBuilder.toString().trim();

        mExtractedData.add(mBuilder.build(R.string.PPOptionalData, optionalData));
    }
}
