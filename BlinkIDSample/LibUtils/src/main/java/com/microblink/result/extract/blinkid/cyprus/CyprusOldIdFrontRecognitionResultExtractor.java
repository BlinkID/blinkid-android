package com.microblink.result.extract.blinkid.cyprus;

import com.microblink.entities.recognizers.blinkid.cyprus.CyprusOldIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class CyprusOldIdFrontRecognitionResultExtractor extends BlinkIdExtractor< CyprusOldIdFrontRecognizer.Result, CyprusOldIdFrontRecognizer > {
    @Override
    protected void extractData(CyprusOldIdFrontRecognizer.Result result) {
        add(R.string.PPIdentityNumber, result.getIdNumber());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPName, result.getName());
        add(R.string.PPSurname, result.getSurname());
    }
}
