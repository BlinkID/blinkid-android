package com.microblink.result.extract.blinkid.colombia;

import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

import java.util.Arrays;


public class ColombiaIDBackRecognitionResultExtractor extends BlinkIdExtractor<ColombiaIdBackRecognizer.Result, ColombiaIdBackRecognizer> {

    @Override
    protected void extractData(ColombiaIdBackRecognizer.Result result) {
        add(R.string.PPDocumentNumber, result.getDocumentNumber());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPLastName, result.getLastName());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPDateOfBirth, result.getBirthDate());
        add(R.string.PPBloodType, result.getBloodGroup());
        add(R.string.PPFingerprint, Arrays.toString(result.getFingerprint()));
    }

}
