package com.microblink.result.extract.blinkid.germany;

import com.microblink.entities.recognizers.blinkid.germany.GermanyOldIDRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.mrtd.MrtdResultExtractor;

public class GermanOldIDRecognitionResultExtractor extends MrtdResultExtractor<GermanyOldIDRecognizer.Result, GermanyOldIDRecognizer> {

    @Override
    protected void extractData(GermanyOldIDRecognizer.Result result) {
        super.extractData(result);

        String placeOfBirth = result.getPlaceOfBirth();
        if (placeOfBirth != null) {
            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    placeOfBirth
            ));
        }
    }

}
