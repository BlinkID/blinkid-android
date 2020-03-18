package com.microblink.result.extract.blinkid;

import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdRecognizer;
import com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.visa.VisaRecognizer;
import com.microblink.result.extract.BaseResultExtractorFactory;
import com.microblink.result.extract.blinkid.documentface.DocumentFaceRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.generic.BlinkIDCombinedRecognizerResultExtractor;
import com.microblink.result.extract.blinkid.generic.BlinkIDRecognizerResultExtractor;
import com.microblink.result.extract.blinkid.idbarcode.IdBarcodeResultExtractor;
import com.microblink.result.extract.blinkid.mrtd.MRTDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.mrtd.MrtdRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.passport.PassportResultExtractor;
import com.microblink.result.extract.blinkid.usdl.USDLCombinedResultExtractor;
import com.microblink.result.extract.blinkid.visa.VisaRecognizerResultExtractor;
import com.microblink.result.extract.usdl.USDLResultExtractor;

public class BlinkIdResultExtractorFactory extends BaseResultExtractorFactory {

    @Override
    protected void addExtractors() {
        add(UsdlRecognizer.class,
                new USDLResultExtractor());
        add(UsdlCombinedRecognizer.class,
                new USDLCombinedResultExtractor());
        add(BlinkIdRecognizer.class,
                new BlinkIDRecognizerResultExtractor());
        add(BlinkIdCombinedRecognizer.class,
                new BlinkIDCombinedRecognizerResultExtractor());
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
