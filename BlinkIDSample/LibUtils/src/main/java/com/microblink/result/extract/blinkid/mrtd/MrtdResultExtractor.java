package com.microblink.result.extract.blinkid.mrtd;

import android.support.annotation.CallSuper;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDDocumentType;
import com.microblink.libresult.R;
import com.microblink.recognizers.blinkid.mrtd.MRTDResult;
import com.microblink.result.extract.BaseResultExtractor;

public abstract class MrtdResultExtractor<ResultType extends Recognizer.Result & MRTDResult, RecognizerType extends Recognizer<?, ResultType>>
        extends BaseResultExtractor<ResultType, RecognizerType> {

    @Override
    @CallSuper
    protected void extractData(ResultType mrtdResult) {
        if (mrtdResult == null) {
            return;
        }

        MRTDDocumentType docType = mrtdResult.getDocumentType();
        add(R.string.PPMRTDDocumentType, docType.toString());
        add(R.string.PPMRZParsed, mrtdResult.isMRZParsed());
        add(R.string.PPMRZVerified, mrtdResult.isMRZVerified());
        add(R.string.PPPrimaryId, mrtdResult.getPrimaryId());
        add(R.string.PPSecondaryId, mrtdResult.getSecondaryId());
        add(R.string.PPDateOfBirth, mrtdResult.getDateOfBirth());
        add(R.string.PPSex, mrtdResult.getSex());
        add(R.string.PPNationality, mrtdResult.getNationality());
        add(R.string.PPDocumentCode, mrtdResult.getDocumentCode());
        add(R.string.PPIssuer, mrtdResult.getIssuer());
        add(R.string.PPDateOfExpiry, mrtdResult.getDateOfExpiry());
        add(R.string.PPOpt2, mrtdResult.getOpt2());

        if (docType == MRTDDocumentType.MRTD_TYPE_GREEN_CARD) {
            add(R.string.PPAlienNumber, mrtdResult.getAlienNumber());
            add(R.string.PPApplicationReceiptNumber, mrtdResult.getApplicationReceiptNumber());
            add(R.string.PPImmigrantCaseNumber, mrtdResult.getImmigrantCaseNumber());
        } else {
            add(R.string.PPDocumentNumber, mrtdResult.getDocumentNumber());
            add(R.string.PPOpt1, mrtdResult.getOpt1());
        }

        add(R.string.PPMRZText, mrtdResult.getMRZText());
    }

}
