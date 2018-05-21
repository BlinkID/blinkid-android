package com.microblink.result.extract.mrtd;

import android.content.Context;

import com.microblink.entities.recognizers.blinkid.mrtd.MRTDRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRZResult;
import com.microblink.libresult.R;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDDocumentType;
import com.microblink.recognizers.blinkid.mrtd.MRTDResult;
import com.microblink.result.extract.RecognitionResultEntry;
import com.microblink.result.extract.templating.TemplatingRecognizerResultExtractor;

import java.util.List;

/**
 * Created by dodo on 25/09/15.
 */
public class MrtdRecognitionResultExtractorFactory extends TemplatingRecognizerResultExtractor {

    public MrtdRecognitionResultExtractorFactory(Context context) {
        super(context);
    }

    public static void extractMRZResult(MRZResult mrzResult, List<RecognitionResultEntry> extractedData, RecognitionResultEntry.Builder builder ) {
        MRTDDocumentType docType = mrzResult.getDocumentType();

        extractedData.add(builder.build(
                R.string.PPMRTDDocumentType,
                docType.toString()
        ));

        extractedData.add(builder.build(
                R.string.PPMRZParsed,
                mrzResult.isMRZParsed()
        ));

        extractedData.add(builder.build(
                R.string.PPMRZVerified,
                mrzResult.isMRZVerified()
        ));

        extractedData.add(builder.build(
                R.string.PPPrimaryId,
                mrzResult.getPrimaryId()
        ));

        extractedData.add(builder.build(
                R.string.PPSecondaryId,
                mrzResult.getSecondaryId()
        ));

        extractedData.add(builder.build(
                R.string.PPDateOfBirth,
                mrzResult.getDateOfBirth().getDate()
        ));

        extractedData.add(builder.build(
                R.string.PPSex,
                mrzResult.getGender()
        ));

        extractedData.add(builder.build(
                R.string.PPNationality,
                mrzResult.getNationality()
        ));

        extractedData.add(builder.build(
                R.string.PPDocumentCode,
                mrzResult.getDocumentCode()
        ));

        extractedData.add(builder.build(
                R.string.PPIssuer,
                mrzResult.getIssuer()
        ));

        extractedData.add(builder.build(
                R.string.PPDateOfExpiry,
                mrzResult.getDateOfExpiry().getDate()
        ));

        extractedData.add(builder.build(
                R.string.PPOpt2,
                mrzResult.getOpt2()
        ));

        if (docType == MRTDDocumentType.MRTD_TYPE_GREEN_CARD) {
            extractedData.add(builder.build(
                    R.string.PPAlienNumber,
                    mrzResult.getAlienNumber()
            ));

            extractedData.add(builder.build(
                    R.string.PPApplicationReceiptNumber,
                    mrzResult.getApplicationReceiptNumber()
            ));

            extractedData.add(builder.build(
                    R.string.PPImmigrantCaseNumber,
                    mrzResult.getImmigrantCaseNumber()
            ));
        } else {
            extractedData.add(builder.build(
                    R.string.PPDocumentNumber,
                    mrzResult.getDocumentNumber()
            ));

            extractedData.add(builder.build(
                    R.string.PPOpt1,
                    mrzResult.getOpt1()
            ));
        }

        extractedData.add(builder.build(
                R.string.PPMRZText,
                mrzResult.getMRZText()
        ));
    }

    protected List<RecognitionResultEntry> extractMRZData(Object result) {
        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MRTDResult) {
            // result is obtained from scanning MRZ
            MRTDResult mrtdResult = (MRTDResult) result;

            MRTDDocumentType docType = mrtdResult.getDocumentType();

            mExtractedData.add(mBuilder.build(
                    R.string.PPMRTDDocumentType,
                    docType.toString()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPMRZParsed,
                    mrtdResult.isMRZParsed()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPMRZVerified,
                    mrtdResult.isMRZVerified()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPrimaryId,
                    mrtdResult.getPrimaryId()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSecondaryId,
                    mrtdResult.getSecondaryId()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    mrtdResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    mrtdResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPNationality,
                    mrtdResult.getNationality()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentCode,
                    mrtdResult.getDocumentCode()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPIssuer,
                    mrtdResult.getIssuer()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiry,
                    mrtdResult.getDateOfExpiry()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPOpt2,
                    mrtdResult.getOpt2()
            ));

            if (docType == MRTDDocumentType.MRTD_TYPE_GREEN_CARD) {
                mExtractedData.add(mBuilder.build(
                        R.string.PPAlienNumber,
                        mrtdResult.getAlienNumber()
                ));

                mExtractedData.add(mBuilder.build(
                        R.string.PPApplicationReceiptNumber,
                        mrtdResult.getApplicationReceiptNumber()
                ));

                mExtractedData.add(mBuilder.build(
                        R.string.PPImmigrantCaseNumber,
                        mrtdResult.getImmigrantCaseNumber()
                ));
            } else {
                mExtractedData.add(mBuilder.build(
                        R.string.PPDocumentNumber,
                        mrtdResult.getDocumentNumber()
                ));

                mExtractedData.add(mBuilder.build(
                        R.string.PPOpt1,
                        mrtdResult.getOpt1()
                ));
            }

            mExtractedData.add(mBuilder.build(
                    R.string.PPMRZText,
                    mrtdResult.getMRZText()
            ));
        }

        return mExtractedData;
    }

    /**
     * Returns list with extracted entries.
     *
     * @param result BaseRecognitionResult
     * @return list with extracted entries
     */
    @Override
    public List<RecognitionResultEntry> extractData(Object result) {

        if (result == null) {
            return mExtractedData;
        }

        if (result instanceof MRTDRecognizer) {
            // result is obtained from scanning PDF417 barcode
            MRTDRecognizer mrtdRecognizer = (MRTDRecognizer) result;

            MRTDRecognizer.Result mrtdResult = mrtdRecognizer.getResult();

            extractMRZResult(mrtdResult.getMRZResult(), mExtractedData, mBuilder);

            extractTemplateData(mrtdRecognizer);

            // add images
            mExtractedData.add(mBuilder.build(R.string.MBFullDocumentImage, mrtdResult.getFullDocumentImage()));
            mExtractedData.add(mBuilder.build(R.string.MBMRZImage, mrtdResult.getMrzImage()));
        }

        return mExtractedData;
    }
}
