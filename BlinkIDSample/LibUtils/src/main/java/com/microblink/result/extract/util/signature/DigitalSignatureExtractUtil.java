package com.microblink.result.extract.util.signature;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.digitalsignature.DigitalSignatureResult;
import com.microblink.libutils.R;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.List;

public final class DigitalSignatureExtractUtil {

    public static void extractDigitalSignature(Recognizer.Result result,
                                               List<RecognitionResultEntry> extractedData,
                                               RecognitionResultEntry.Builder builder) {

        if (result instanceof DigitalSignatureResult) {
            DigitalSignatureResult digitalSignatureResult = (DigitalSignatureResult) result;
            byte[] digitalSignature = digitalSignatureResult.getDigitalSignature();
            if (digitalSignature != null) {
                boolean allZeros = true;
                for (byte b : digitalSignature) {
                    if (b != 0) {
                        allZeros = false;
                        break;
                    }
                }
                if (!allZeros) {
                    extractedData.add(builder.build(R.string.MBDigitalSignatureVersion, digitalSignatureResult.getDigitalSignatureVersion()));
                    extractedData.add(builder.build(R.string.MBDigitalSignature, digitalSignature));
                }
            }
        }
    }
}
