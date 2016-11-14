package com.microblink.libresult.extract.eudl;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.eudl.EUDLRecognitionResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 02/06/15.
 */
public class EUDLRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    private RecognitionResultEntry.Builder mBuilder;
    List<RecognitionResultEntry> mExtractedData;

    public EUDLRecognitionResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof EUDLRecognitionResult) {
            EUDLRecognitionResult eudlResult = (EUDLRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPFirstName,
                    eudlResult.getFirstName()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPLastName,
                    eudlResult.getLastName()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
                    eudlResult.getAddress()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    eudlResult.getPlaceOfBirth()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    eudlResult.getDateOfBirth()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    eudlResult.getDocumentIssueDate()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPExpiryDate,
                    eudlResult.getDocumentExpiryDate()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPDriverNumber,
                    eudlResult.getDriverNumber()
            ));
            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAuthority,
                    eudlResult.getDocumentIssuingAuthority()
            ));
        }
        return mExtractedData;
    }
}
