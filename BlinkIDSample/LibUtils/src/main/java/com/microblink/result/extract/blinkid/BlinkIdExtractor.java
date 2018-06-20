package com.microblink.result.extract.blinkid;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdDocumentType;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public abstract class BlinkIdExtractor<ResultType extends Recognizer.Result, RecognizerType extends Recognizer<?, ResultType>> extends BaseResultExtractor<ResultType, RecognizerType> {

    @Override
    protected void onDataExtractionDone(ResultType result) {
        BlinkIDExtractionUtils.extractCommonData(result, mExtractedData, mBuilder);
        super.onDataExtractionDone(result);
    }

    protected void extractMRZResult(MrzResult mrzResult) {
        MrtdDocumentType docType = mrzResult.getDocumentType();

        add(R.string.PPMRTDDocumentType, docType.toString());
        add(R.string.PPMRZParsed, mrzResult.isMrzParsed());
        add(R.string.PPMRZVerified, mrzResult.isMrzVerified());
        add(R.string.PPPrimaryId, mrzResult.getPrimaryId());
        add(R.string.PPSecondaryId, mrzResult.getSecondaryId());
        add(R.string.PPDateOfBirth, mrzResult.getDateOfBirth().getDate());
        add(R.string.PPSex, mrzResult.getGender());
        add(R.string.PPNationality, mrzResult.getNationality());
        add(R.string.PPDocumentCode, mrzResult.getDocumentCode());
        add(R.string.PPIssuer, mrzResult.getIssuer());
        add(R.string.PPDateOfExpiry, mrzResult.getDateOfExpiry().getDate());
        add(R.string.PPOpt2, mrzResult.getOpt2());
        add(R.string.PPMRZText, mrzResult.getMrzText());

        if (docType == MrtdDocumentType.MRTD_TYPE_GREEN_CARD) {
            add(R.string.PPAlienNumber, mrzResult.getAlienNumber());
            add(R.string.PPApplicationReceiptNumber, mrzResult.getApplicationReceiptNumber());
            add(R.string.PPImmigrantCaseNumber, mrzResult.getImmigrantCaseNumber());
        } else {
            add(R.string.PPDocumentNumber, mrzResult.getDocumentNumber());
            add(R.string.PPOpt1, mrzResult.getOpt1());
        }
    }

}
