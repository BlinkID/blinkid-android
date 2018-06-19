package com.microblink.result.extract.blinkid.usdl;

import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class USDLCombinedResultExtractor extends BlinkIdExtractor<UsdlCombinedRecognizer.Result, UsdlCombinedRecognizer> {

    @Override
    protected void extractData(UsdlCombinedRecognizer.Result result) {
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
