package com.microblink.result.extract.blinkid.morocco;

import com.microblink.entities.recognizers.blinkid.morocco.MoroccoIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class MoroccoIdBackRecognitionResultExtractor extends BlinkIdExtractor<MoroccoIdBackRecognizer.Result, MoroccoIdBackRecognizer> {
    @Override
    protected void extractData(MoroccoIdBackRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPDateOfExpiry, result.getDateOfExpiry());
        add(R.string.PPFatherName, result.getFathersName());
        add(R.string.PPMotherName, result.getMothersName());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPCivilStatusNumber, result.getCivilStatusNumber());
        add(R.string.PPSex, result.getSex());
    }
}
