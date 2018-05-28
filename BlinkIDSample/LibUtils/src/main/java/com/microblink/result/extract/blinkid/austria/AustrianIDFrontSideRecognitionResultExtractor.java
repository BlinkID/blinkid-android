package com.microblink.result.extract.blinkid.austria;

import com.microblink.entities.recognizers.blinkid.austria.AustriaIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class AustrianIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<AustriaIDFrontSideRecognizer.Result, AustriaIDFrontSideRecognizer> {

    @Override
    protected void extractData(AustriaIDFrontSideRecognizer.Result ausIdFrontResult) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                ausIdFrontResult.getSurname()
        ));

        ausIdFrontResult.getEncodedSignatureImage();
        ausIdFrontResult.getEncodedFullDocumentImage();
        ausIdFrontResult.getEncodedFaceImage();

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                ausIdFrontResult.getGivenName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                ausIdFrontResult.getDocumentNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                ausIdFrontResult.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                ausIdFrontResult.getDateOfBirth().getDate()
        ));
    }

}
