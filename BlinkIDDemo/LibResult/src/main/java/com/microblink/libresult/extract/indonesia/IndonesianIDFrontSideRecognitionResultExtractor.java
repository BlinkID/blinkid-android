package com.microblink.libresult.extract.indonesia;

import android.content.Context;

import com.microblink.libresult.R;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkid.indonesia.front.IndonesianIDFrontRecognitionResult;

import java.util.List;


/**
 * Created by ivan on 11.10.17..
 */

public class IndonesianIDFrontSideRecognitionResultExtractor extends
        BlinkOcrRecognitionResultExtractor {

    public IndonesianIDFrontSideRecognitionResultExtractor(Context context) { super(context); }

    @Override
    public List<RecognitionResultEntry> extractData(BaseRecognitionResult result) {

        if (result == null){
            return mExtractedData;
        }

        if (result instanceof IndonesianIDFrontRecognitionResult){
            // result is obtained by scanning the front side of Slovenian IDs
            IndonesianIDFrontRecognitionResult
                    idnIdFrontResult = (IndonesianIDFrontRecognitionResult) result;

            mExtractedData.add(mBuilder.build(
                    R.string.PPProvince,
                    idnIdFrontResult.getProvince()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPCity,
                    idnIdFrontResult.getCity()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDocumentNumber,
                    idnIdFrontResult.getDocumentNumber()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPName,
                    idnIdFrontResult.getName()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPPlaceOfBirth,
                    idnIdFrontResult.getPlaceOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfBirth,
                    idnIdFrontResult.getDateOfBirth()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPSex,
                    idnIdFrontResult.getSex()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPBloodGroup,
                    idnIdFrontResult.getBloodType()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPAddress,
            idnIdFrontResult.getAddress()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPRT,
                    idnIdFrontResult.getRT()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPRW,
                    idnIdFrontResult.getRW()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPKelDesa,
                    idnIdFrontResult.getKelDesa()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDistrict,
                    idnIdFrontResult.getDistrict()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPReligion,
                    idnIdFrontResult.getReligion()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPMaritalStatus,
                    idnIdFrontResult.getMaritalStatus()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPOccupation,
                    idnIdFrontResult.getOccupation()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPCitizenship,
                    idnIdFrontResult.getCitizenship()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPValidUntil,
                    idnIdFrontResult.getValidUntil()
            ));

            mExtractedData.add(mBuilder.build(
                    R.string.PPDateOfExpiryPermanent,
                    idnIdFrontResult.getValidUntilPermanent()
            ));
        }

        return mExtractedData;

    }
}
