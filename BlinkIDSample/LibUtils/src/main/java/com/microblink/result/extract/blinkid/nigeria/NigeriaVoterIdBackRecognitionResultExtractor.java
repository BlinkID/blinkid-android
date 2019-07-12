package com.microblink.result.extract.blinkid.nigeria;

import com.microblink.entities.recognizers.blinkid.nigeria.NigeriaVoterIdBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class NigeriaVoterIdBackRecognitionResultExtractor extends BlinkIdExtractor<NigeriaVoterIdBackRecognizer.Result, NigeriaVoterIdBackRecognizer> {

    @Override
    protected void extractData(NigeriaVoterIdBackRecognizer.Result result) {
        add(R.string.PPSurname, result.getSurname());
        add(R.string.PPFirstName, result.getFirstName());
        add(R.string.PPDateOfBirth, result.getDateOfBirth());
        add(R.string.PPSex, result.getSex());
        add(R.string.PPAddress, result.getAddress());
        add(R.string.PPRawResult, result.getRawBarcodeData());
    }

}