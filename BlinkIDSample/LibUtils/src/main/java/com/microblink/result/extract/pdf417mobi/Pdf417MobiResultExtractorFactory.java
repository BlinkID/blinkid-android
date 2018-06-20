package com.microblink.result.extract.pdf417mobi;

import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.entities.recognizers.blinkbarcode.simnumber.SimNumberRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.result.extract.BaseResultExtractorFactory;
import com.microblink.result.extract.usdl.USDLResultExtractor;

public class Pdf417MobiResultExtractorFactory extends BaseResultExtractorFactory {

    @Override
    protected void addExtractors() {
        add(SuccessFrameGrabberRecognizer.class,
                new SuccessFrameGrabberResultExtractor());
        add(BarcodeRecognizer.class,
                new BarcodeRecognitionResultExtractor());
        add(Pdf417Recognizer.class,
                new Pdf417RecognitionResultExtractor());
        add(SimNumberRecognizer.class,
                new SimNumberRecognitionResultExtractor());
        add(UsdlRecognizer.class,
                new USDLResultExtractor());
    }

}
