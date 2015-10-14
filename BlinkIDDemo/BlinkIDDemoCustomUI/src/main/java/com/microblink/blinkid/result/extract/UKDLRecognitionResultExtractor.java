package com.microblink.blinkid.result.extract;

import android.content.Context;

import com.microblink.blinkid.demo.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.ocr.ukdl.UKDLRecognitionResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 02/06/15.
 */
public class UKDLRecognitionResultExtractor implements IBaseRecognitionResultExtractor {
    Context mContext;
    List<RecognitionResultEntry> mExtractedData;

    public UKDLRecognitionResultExtractor(Context mContext) {
        this.mContext = mContext;
        mExtractedData = new ArrayList<>();
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null) {
            return mExtractedData;
        }

        DateFormat df = new SimpleDateFormat("dd.mm.yyyy.");

        if (result instanceof UKDLRecognitionResult) {
            UKDLRecognitionResult ukdlResult = (UKDLRecognitionResult) result;

            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPFirstName),
                    ukdlResult.getFirstName()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPLastName),
                    ukdlResult.getLastName()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPAddress),
                    ukdlResult.getAddress()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPPlaceOfBirth),
                    ukdlResult.getPlaceOfBirth()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDateOfBirth),
                    ukdlResult.getDateOfBirth() == null ? "" : df.format(ukdlResult.getDateOfBirth())
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPPlaceOfBirth),
                    ukdlResult.getPlaceOfBirth()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPDriverNumber),
                    ukdlResult.getDriverNumber()
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPIssueDate),
                    ukdlResult.getDocumentIssueDate() == null ? "" : df.format(ukdlResult.getDocumentIssueDate())
            ));
            mExtractedData.add(new RecognitionResultEntry(
                    mContext.getString(R.string.PPExpiryDate),
                    ukdlResult.getDocumentExpiryDate() == null ? "" : df.format(ukdlResult.getDocumentExpiryDate())
            ));
        }

        return mExtractedData;
    }
}
