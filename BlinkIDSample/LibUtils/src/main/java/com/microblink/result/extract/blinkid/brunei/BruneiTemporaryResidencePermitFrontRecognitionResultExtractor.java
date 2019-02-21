package com.microblink.result.extract.blinkid.brunei;

import com.microblink.entities.recognizers.blinkid.brunei.BruneiTemporaryResidencePermitFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class BruneiTemporaryResidencePermitFrontRecognitionResultExtractor extends BlinkIdExtractor<BruneiTemporaryResidencePermitFrontRecognizer.Result, BruneiTemporaryResidencePermitFrontRecognizer> {
    @Override
    protected void extractData(BruneiTemporaryResidencePermitFrontRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFullName, result.getFullName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPAddress, result.getAddress());
    }
}
