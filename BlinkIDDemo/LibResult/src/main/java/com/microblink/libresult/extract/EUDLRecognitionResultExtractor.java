package com.microblink.libresult.extract;

import android.content.Context;

import com.microblink.libresult.R;
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
    Context mContext;
    List<RecognitionResultEntry> mExtractedData;

    public EUDLRecognitionResultExtractor(Context mContext) {
        this.mContext = mContext;
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        DateFormat df = new SimpleDateFormat("dd.mm.yyyy.");

        if (result instanceof EUDLRecognitionResult) {
            EUDLRecognitionResult eudlResult = (EUDLRecognitionResult) result;

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPFirstName),
                    eudlResult.getFirstName()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPLastName),
                    eudlResult.getLastName()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPAddress),
                    eudlResult.getAddress()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPPlaceOfBirth),
                    eudlResult.getPlaceOfBirth()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDateOfBirth),
                    eudlResult.getDateOfBirth() == null ? "" : df.format(eudlResult.getDateOfBirth())
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPIssueDate),
                    eudlResult.getDocumentIssueDate() == null ? "" : df.format(eudlResult.getDocumentIssueDate())
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPExpiryDate),
                    eudlResult.getDocumentExpiryDate() == null ? "" : df.format(eudlResult.getDocumentExpiryDate())
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDriverNumber),
                    eudlResult.getDriverNumber()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPIssuingAuthority),
                    eudlResult.getDocumentIssuingAuthority()
            ));
        }
        return mExtractedData;
    }
}
