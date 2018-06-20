package com.microblink.result.extract.usdl;

import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys;
import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

public class USDLResultExtractor extends BaseResultExtractor<UsdlRecognizer.Result, UsdlRecognizer> {

    @Override
    protected void extractData(UsdlRecognizer.Result result) {
        for (UsdlKeys key : UsdlKeys.values()) {
            mExtractedData.add(new RecognitionResultEntry(key.name(), result.getField(key)));
        }

        StringBuilder optionalDataBuilder = new StringBuilder();
        String[] optionalElements = result.getOptionalElements();
        for (String d : optionalElements) {
            optionalDataBuilder.append(d);
            optionalDataBuilder.append('\n');
        }
        String optionalData = optionalDataBuilder.toString().trim();
        add(R.string.PPOptionalData, optionalData);
    }
}
