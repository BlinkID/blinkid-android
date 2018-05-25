package com.microblink.result.extract.blinkid.colombia;

import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

import java.util.Arrays;


public class ColombiaIDBackRecognitionResultExtractor extends BaseResultExtractor<ColombiaIDBackSideRecognizer.Result, ColombiaIDBackSideRecognizer> {

    @Override
    protected void extractData(ColombiaIDBackSideRecognizer.Result result) {
        mExtractedData.add(mBuilder.build(R.string.PPDocumentNumber, result.getDocumentNumber()));
        mExtractedData.add(mBuilder.build(R.string.PPFirstName, result.getOwnerFirsName()));
        mExtractedData.add(mBuilder.build(R.string.PPLastName, result.getOwnerLastName()));
        mExtractedData.add(mBuilder.build(R.string.PPSex, result.getOwnerSex()));
        mExtractedData.add(mBuilder.build(R.string.PPDateOfBirth, result.getOwnerDateOfBirth()));
        mExtractedData.add(mBuilder.build(R.string.PPBloodGroup, result.getOwnerBloodGroup()));
        mExtractedData.add(mBuilder.build(R.string.PPFingerprint, Arrays.toString(result.getOwnerFingerprint())));
    }

}
