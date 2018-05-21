package com.microblink.result.extract.croatia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.croatia.CroatianIDBackSideRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by Boris on 22/04/16.
 */
public class CroatianIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public CroatianIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof CroatianIDBackSideRecognizer.Result){
            // result is obtained by scanning back side of croatian ID
            CroatianIDBackSideRecognizer.Result croIDBackResult = (CroatianIDBackSideRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    croIDBackResult.getAddress()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentForNonResidents,
                    croIDBackResult.documentForNonResident()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    croIDBackResult.getIssuingAuthority()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    croIDBackResult.getDocumentDateOfIssue()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiryPermanent,
                    croIDBackResult.getDocumentDateOfExpiryPermanent()
            ));

            super.extractMRZData(result);

            BlinkIDExtractionUtils.extractCommonData(croIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
