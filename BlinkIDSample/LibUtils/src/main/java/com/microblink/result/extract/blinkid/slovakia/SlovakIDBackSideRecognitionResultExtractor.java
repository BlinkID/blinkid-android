package com.microblink.result.extract.blinkid.slovakia;

import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class SlovakIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<SlovakiaIDBackRecognizer.Result, SlovakiaIDBackRecognizer> {

    @Override
    protected void extractData(SlovakiaIDBackRecognizer.Result result) {
        super.extractData(result);

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSurnameAtBirth,
                result.getSurnameAtBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPlaceOfBirth,
                result.getPlaceOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSpecialRemarks,
                result.getSpecialRemarks()
        ));
    }

}
