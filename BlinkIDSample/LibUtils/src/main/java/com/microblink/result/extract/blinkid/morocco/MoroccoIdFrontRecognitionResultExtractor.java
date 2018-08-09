package com.microblink.result.extract.blinkid.morocco;

import com.microblink.entities.recognizers.blinkid.morocco.MoroccoIdFrontRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class MoroccoIdFrontRecognitionResultExtractor extends BlinkIdExtractor<MoroccoIdFrontRecognizer.Result, MoroccoIdFrontRecognizer> {
    @Override
    protected void extractData(MoroccoIdFrontRecognizer.Result result) {
        add(R.string.PPName, result.getName());
        add(R.string.PPLastName, result.getSurname());
        add(R.string.PPPlaceOfBirth, result.getPlaceOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
    }
}
