package com.microblink.libresult.extract.germany;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.germany.mrz.GermanIDMRZSideRecognitionResult;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;

import java.util.Date;
import java.util.List;

/**
 * Created by igrce on 26/08/16.
 */
public class GermanIDMRZSideRecognitionResultExtractor extends MRTDRecognitionResultExtractor {

    public GermanIDMRZSideRecognitionResultExtractor(Context context) {
        super(context);
    }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof GermanIDMRZSideRecognitionResult) {
            GermanIDMRZSideRecognitionResult deIDMrzResult = (GermanIDMRZSideRecognitionResult) result;

            String address = deIDMrzResult.getAddress();
            if (address != null && !address.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAddress,
                        address
                ));
            }

            String authority = deIDMrzResult.getAuthority();
            if (authority != null && !authority.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAuthority,
                        authority
                ));
            }

            Date dateOfIssue = deIDMrzResult.getDateOfIssue();
            if (dateOfIssue != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPIssueDate,
                        dateOfIssue
                ));
            }

            String eyeColor = deIDMrzResult.getEyeColour();
            if (eyeColor != null && !eyeColor.isEmpty()) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPEyeColour,
                        eyeColor
                ));
            }

            int height = deIDMrzResult.getHeight();
            if (height != 0) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPHeight,
                        Integer.toString(height) + " cm"
                ));
            }

            String placeOfBirth = deIDMrzResult.getPlaceOfBirth();
            if (placeOfBirth != null) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPPlaceOfBirth,
                        placeOfBirth
                ));
            }

            super.extractMRZData(deIDMrzResult);
        }

        return mExtractedData;
    }
}
