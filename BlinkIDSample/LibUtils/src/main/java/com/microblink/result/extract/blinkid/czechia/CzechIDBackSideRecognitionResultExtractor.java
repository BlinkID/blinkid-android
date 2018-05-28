package com.microblink.result.extract.blinkid.czechia;

import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class CzechIDBackSideRecognitionResultExtractor extends MrtdResultExtractor<CzechiaIDBackSideRecognizer.Result, CzechiaIDBackSideRecognizer> {

    @Override
    protected void extractData(CzechiaIDBackSideRecognizer.Result result) {
        super.extractData(result);

        mExtractedData.add(mBuilder.build(
                R.string.PPAddress,
                result.getAddress()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPPersonalNumber,
                result.getPersonalNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPAuthority,
                result.getAuthority()
        ));
    }

}
