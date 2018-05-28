package com.microblink.result.extract.blinkid.croatia;

import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIDFrontSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class CroatianIDFrontSideRecognitionResultExtractor extends BaseResultExtractor<CroatiaIDFrontSideRecognizer.Result,CroatiaIDFrontSideRecognizer> {

    @Override
    protected void extractData(CroatiaIDFrontSideRecognizer.Result croIdFrontResult) {
        mExtractedData.add(mBuilder.build(
                R.string.PPLastName,
                croIdFrontResult.getLastName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPFirstName,
                croIdFrontResult.getFirstName()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentNumber,
                croIdFrontResult.getIdentityCardNumber()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPSex,
                croIdFrontResult.getSex()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPCitizenship,
                croIdFrontResult.getCitizenship()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfBirth,
                croIdFrontResult.getDateOfBirth()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiry,
                croIdFrontResult.getDocumentDateOfExpiry()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDateOfExpiryPermanent,
                croIdFrontResult.getDocumentDateOfExpiryPermanent()
        ));

        mExtractedData.add(mBuilder.build(
                R.string.PPDocumentBilingual,
                croIdFrontResult.isDocumentBilingual()
        ));
    }

}
