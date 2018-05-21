package com.microblink.result.extract.slovenia;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.slovenia.SlovenianIDBackRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.utils.BlinkIDExtractionUtils;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;

import java.util.List;

/**
 * Created by mateja on 29/08/16.
 */
public class SlovenianIDBackSideRecognitionResultExtractor extends MrtdRecognitionResultExtractorFactory {

    public SlovenianIDBackSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof SlovenianIDBackRecognizer.Result){
            // result is obtained by scanning the back side of Slovenian IDs
            SlovenianIDBackRecognizer.Result sloIDBackResult = (SlovenianIDBackRecognizer.Result) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    sloIDBackResult.getAddress()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    sloIDBackResult.getAuthority()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    sloIDBackResult.getDateOfIssue()
            ));
            super.extractMRZData(result);
            BlinkIDExtractionUtils.extractCommonData(sloIDBackResult, mExtractedData, mBuilder);
        }

        return mExtractedData;
    }
}
