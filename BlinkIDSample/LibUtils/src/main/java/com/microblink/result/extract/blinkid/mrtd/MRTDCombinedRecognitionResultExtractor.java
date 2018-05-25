package com.microblink.result.extract.blinkid.mrtd;

import com.microblink.entities.recognizers.blinkid.mrtd.MRTDCombinedRecognizer;
import com.microblink.libresult.R;

public class MRTDCombinedRecognitionResultExtractor extends MrtdResultExtractor<MRTDCombinedRecognizer.Result, MRTDCombinedRecognizer> {

    @Override
    protected void extractData(MRTDCombinedRecognizer.Result result) {
        super.extractData(result);

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentBothSidesMatch,
                result.isDocumentDataMatch()
        ));
    }

}
