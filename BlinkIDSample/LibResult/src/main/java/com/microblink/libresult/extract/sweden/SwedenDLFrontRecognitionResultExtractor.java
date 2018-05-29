package com.microblink.libresult.extract.sweden;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.sweden.dl.SwedenDLFrontRecognitionResult;

import java.util.List;


public class SwedenDLFrontRecognitionResultExtractor extends BlinkOcrRecognitionResultExtractor
{
    public SwedenDLFrontRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result)
    {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof SwedenDLFrontRecognitionResult) {
            //result is obtained by scanning the front side of Sweden DL
            SwedenDLFrontRecognitionResult swedenDLFrontResult = (SwedenDLFrontRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPLicenceNumber,
                    swedenDLFrontResult.getLicenceNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSurname,
                    swedenDLFrontResult.getSurname()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPName,
                    swedenDLFrontResult.getName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    swedenDLFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssueDate,
                    swedenDLFrontResult.getDateOfIssue()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    swedenDLFrontResult.getDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuingAgency,
                    swedenDLFrontResult.getIssuingAgency()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPReferenceNumber,
                    swedenDLFrontResult.getReferenceNumber()
            ));

            String licenceCategories = swedenDLFrontResult.getLicenceCategories();
            if (licenceCategories != null && !licenceCategories.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPLicenceCategories,
                        licenceCategories
                ));
            }
        }

        return mExtractedData;
    }
}