package com.microblink.blinkid.result.extract.blinkid;

import com.microblink.blinkid.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.visa.VisaRecognizer;
import com.microblink.blinkid.result.extract.BaseResultExtractorFactory;
import com.microblink.blinkid.result.extract.blinkid.documentface.DocumentFaceRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.generic.BlinkIdMultiSideRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.generic.BlinkIdSingleSideRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.idbarcode.IdBarcodeResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.mrtd.MRTDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.mrtd.MrtdRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.passport.PassportResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.usdl.USDLCombinedResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.visa.VisaRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.usdl.USDLResultExtractor;

public class BlinkIdResultExtractorFactory extends BaseResultExtractorFactory {

    @Override
    protected void addExtractors() {
        add(UsdlRecognizer.class,
                new USDLResultExtractor());
        add(UsdlCombinedRecognizer.class,
                new USDLCombinedResultExtractor());
        add(BlinkIdSingleSideRecognizer.class,
                new BlinkIdSingleSideRecognizerResultExtractor());
        add(BlinkIdMultiSideRecognizer.class,
                new BlinkIdMultiSideRecognizerResultExtractor());
        add(DocumentFaceRecognizer.class,
                new DocumentFaceRecognitionResultExtractor());
        add(PassportRecognizer.class,
                new PassportResultExtractor());
        add(VisaRecognizer.class,
                new VisaRecognizerResultExtractor());
        add(MrtdCombinedRecognizer.class,
                new MRTDCombinedRecognitionResultExtractor());
        add(MrtdRecognizer.class,
                new MrtdRecognitionResultExtractor());
        add(IdBarcodeRecognizer.class,
                new IdBarcodeResultExtractor());
    }
}
