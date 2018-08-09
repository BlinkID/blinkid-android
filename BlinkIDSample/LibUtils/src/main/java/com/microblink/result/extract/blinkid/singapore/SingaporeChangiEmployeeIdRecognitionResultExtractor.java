package com.microblink.result.extract.blinkid.singapore;

import com.microblink.entities.recognizers.blinkid.singapore.SingaporeChangiEmployeeIdRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.blinkid.BlinkIdExtractor;

public class SingaporeChangiEmployeeIdRecognitionResultExtractor extends BlinkIdExtractor<SingaporeChangiEmployeeIdRecognizer.Result, SingaporeChangiEmployeeIdRecognizer> {

    @Override
    protected void extractData(SingaporeChangiEmployeeIdRecognizer.Result SingaporeChangiEmployeeIdResult) {
        add(R.string.PPName, SingaporeChangiEmployeeIdResult.getName());
        add(R.string.PPDocumentNumber, SingaporeChangiEmployeeIdResult.getDocumentNumber());
        add(R.string.PPCompanyName, SingaporeChangiEmployeeIdResult.getCompanyName());
        add(R.string.PPDateOfExpiry, SingaporeChangiEmployeeIdResult.getDateOfExpiry());
    }
}
