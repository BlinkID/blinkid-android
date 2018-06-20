package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyOldIdRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class GermanOldIDRecognitionResultExtractor extends MrtdResultExtractor<GermanyOldIdRecognizer.Result, GermanyOldIdRecognizer> {

    @Override
    protected void extractData(GermanyOldIdRecognizer.Result result) {
        super.extractData(result);

        String placeOfBirth = result.getPlaceOfBirth();
        if (placeOfBirth != null) {
            add(R.string.PPPlaceOfBirth, placeOfBirth);
        }
    }

}
