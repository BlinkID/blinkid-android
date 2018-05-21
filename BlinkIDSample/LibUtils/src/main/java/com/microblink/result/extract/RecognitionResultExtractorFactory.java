package com.microblink.result.extract;

import android.content.Context;

import com.microblink.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.entities.recognizers.blinkbarcode.pdf417.Pdf417Recognizer;
import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustralianDLBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustralianDLFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustrianCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustrianIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustrianIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustrianPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatianCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatianIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatianIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.entities.recognizers.blinkid.egypt.EgyptIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.eudl.EUDLRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanOldIDRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.indonesia.IndonesianIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.IKadRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysianDLFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyTenteraRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDRecognizer;
import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDLFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolishCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolishIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolishIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.romania.RomanianIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbianCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbianIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbianIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SlovenianCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SlovenianIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SlovenianIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwissIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwissIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwissPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognizer;
import com.microblink.entities.recognizers.detector.DetectorRecognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.result.extract.australia.AustralianDLBackSideRecognitionResultExtractor;
import com.microblink.result.extract.australia.AustralianDLFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.austria.AustrianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.austria.AustrianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.austria.AustrianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.austria.AustrianPassportRecognitionResultExtractor;
import com.microblink.result.extract.barcode.BarcodeRecognitionResultExtractor;
import com.microblink.result.extract.barcode.Pdf417RecognitionResultExtractor;
import com.microblink.result.extract.colombia.ColombiaIDBackRecognitionResultExtractor;
import com.microblink.result.extract.colombia.ColombiaIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.croatia.CroatianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.croatia.CroatianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.croatia.CroatianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.czechia.CzechIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.czechia.CzechIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.czechia.CzechIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.detector.DetectorRecognitionResultExtractor;
import com.microblink.result.extract.documentface.DocumentFaceRecognitionResultExtractor;
import com.microblink.result.extract.egypt.EgyptIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.eudl.EUDriversLicenceRecognitionResultExtractor;
import com.microblink.result.extract.germany.GermanIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.germany.GermanIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.germany.GermanIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.germany.GermanOldIDRecognitionResultExtractor;
import com.microblink.result.extract.germany.GermanPassportRecognitionResultExtractor;
import com.microblink.result.extract.hongkong.HongKongIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.indonesia.IndonesianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.jordan.JordanIDBackRecognitionResultExtractor;
import com.microblink.result.extract.jordan.JordanIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.jordan.JordanIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.malaysia.IKadRecognitionResultExtractor;
import com.microblink.result.extract.malaysia.MalaysianDLFrontRecognitionResultExtractor;
import com.microblink.result.extract.malaysia.MyKadBackRecognitionResultExtractor;
import com.microblink.result.extract.malaysia.MyKadFrontRecognitionResultExtractor;
import com.microblink.result.extract.malaysia.MyTenteraRecognitionResultExtractor;
import com.microblink.result.extract.mrtd.MRTDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.mrtd.MrtdRecognitionResultExtractorFactory;
import com.microblink.result.extract.newzealand.NewZealandDLFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.poland.PolishIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.poland.PolishIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.poland.PolishIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.romania.RomanianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.serbia.SerbianIDBackRecognitionResultExtractor;
import com.microblink.result.extract.serbia.SerbianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.serbia.SerbianIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.singapore.SingaporeIDBackRecognitionResultExtractor;
import com.microblink.result.extract.singapore.SingaporeIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.singapore.SingaporeIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.slovakia.SlovakIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.slovakia.SlovakIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.slovakia.SlovakIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.slovenia.SlovenianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.slovenia.SlovenianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.slovenia.SlovenianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.successFrame.SuccessFrameGrabberResultExtractor;
import com.microblink.result.extract.switzerland.SwissIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.switzerland.SwissIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.switzerland.SwissPassportRecognitionResultExtractor;
import com.microblink.result.extract.unitedArabEmirates.UnitedArabEmiratesIDBackRecognitionResultExtractor;
import com.microblink.result.extract.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.usdl.USDLResultExtractor;

/**
 * Created by dodo on 27/05/15.
 */
public abstract class RecognitionResultExtractorFactory {

    public static IBaseRecognitionResultExtractor createExtractor(Context context, Object result) {

        if (result instanceof SuccessFrameGrabberRecognizer)
            return new SuccessFrameGrabberResultExtractor(context);

        else if (result instanceof USDLRecognizer)
            return new USDLResultExtractor(context);

        else if (result instanceof SerbianIDFrontRecognizer)
            return new SerbianIDFrontRecognitionResultExtractor(context);

        else if (result instanceof SerbianIDBackRecognizer)
            return new SerbianIDBackRecognitionResultExtractor(context);

        else if (result instanceof AustralianDLFrontSideRecognizer)
            return new AustralianDLFrontSideRecognitionResultExtractor(context);

        else if (result instanceof AustralianDLBackSideRecognizer)
            return new AustralianDLBackSideRecognitionResultExtractor(context);

        else if (result instanceof AustrianIDFrontSideRecognizer)
            return new AustrianIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof AustrianIDBackSideRecognizer)
            return new AustrianIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof AustrianCombinedRecognizer)
            return new AustrianIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof AustrianPassportRecognizer)
            return new AustrianPassportRecognitionResultExtractor(context);

        else if (result instanceof CroatianIDFrontSideRecognizer)
            return new CroatianIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof CroatianIDBackSideRecognizer)
            return new CroatianIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof CroatianCombinedRecognizer)
            return new CroatianIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof CzechIDBackSideRecognizer)
            return new CzechIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof CzechIDFrontSideRecognizer)
            return new CzechIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof CzechCombinedRecognizer)
            return new CzechIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof GermanOldIDRecognizer)
            return new GermanOldIDRecognitionResultExtractor(context);

        else if (result instanceof GermanIDBackSideRecognizer)
            return new GermanIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof GermanCombinedRecognizer)
            return new GermanIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof GermanIDFrontSideRecognizer)
            return new GermanIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof GermanPassportRecognizer)
            return new GermanPassportRecognitionResultExtractor(context);

        else if (result instanceof IndonesianIDFrontRecognizer)
            return new IndonesianIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof JordanIDFrontRecognizer)
            return new JordanIDFrontRecognitionResultExtractor(context);
            
        else if (result instanceof JordanIDBackRecognizer)
            return new JordanIDBackRecognitionResultExtractor(context);

        else if (result instanceof JordanCombinedRecognizer)
            return new JordanIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof HongKongIDFrontRecognizer)
            return new HongKongIDFrontRecognitionResultExtractor(context);
            
        else if (result instanceof ColombiaIDFrontSideRecognizer)
            return new ColombiaIDFrontRecognitionResultExtractor(context);

        else if (result instanceof ColombiaIDBackSideRecognizer)
            return new ColombiaIDBackRecognitionResultExtractor(context);

        else if (result instanceof EgyptIDFrontRecognizer)
            return new EgyptIDFrontRecognitionResultExtractor(context);

        else if (result instanceof MalaysianDLFrontRecognizer)
            return new  MalaysianDLFrontRecognitionResultExtractor(context);

        else if (result instanceof NewZealandDLFrontRecognizer)
            return new NewZealandDLFrontSideRecognitionResultExtractor(context);

        else if (result instanceof SwissIDBackRecognizer)
            return new SwissIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof SwissPassportRecognizer)
            return new SwissPassportRecognitionResultExtractor(context);

        else if (result instanceof SwissIDFrontRecognizer)
            return new SwissIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof Pdf417Recognizer)
            return new Pdf417RecognitionResultExtractor(context);

        else if (result instanceof BarcodeRecognizer)
            return new BarcodeRecognitionResultExtractor(context);

        else if (result instanceof EUDLRecognizer)
            return new EUDriversLicenceRecognitionResultExtractor(context);

        else if (result instanceof DocumentFaceRecognizer)
            return new DocumentFaceRecognitionResultExtractor(context);

        else if (result instanceof MyKadFrontRecognizer)
            return new MyKadFrontRecognitionResultExtractor(context);

        else if (result instanceof MyKadBackRecognizer)
            return new MyKadBackRecognitionResultExtractor(context);
            
        else if (result instanceof MyTenteraRecognizer)
            return new MyTenteraRecognitionResultExtractor(context);

        else if (result instanceof IKadRecognizer)
            return new IKadRecognitionResultExtractor(context);

        else if (result instanceof PolishIDBackSideRecognizer)
            return new PolishIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof PolishIDFrontSideRecognizer)
            return new PolishIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof PolishCombinedRecognizer)
            return new PolishIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof SlovakIDBackRecognizer)
            return new SlovakIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof SlovakIDFrontRecognizer)
            return new SlovakIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof SlovakCombinedRecognizer)
            return new SlovakIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof SlovenianIDFrontRecognizer)
            return new SlovenianIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof SlovenianIDBackRecognizer)
            return new SlovenianIDBackSideRecognitionResultExtractor(context);

        else if (result instanceof SlovenianCombinedRecognizer)
            return new SlovenianIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof SerbianCombinedRecognizer)
            return new SerbianIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof SingaporeIDBackRecognizer)
            return new SingaporeIDBackRecognitionResultExtractor(context);

        else if (result instanceof SingaporeIDFrontRecognizer)
            return new SingaporeIDFrontRecognitionResultExtractor(context);

        else if (result instanceof SingaporeCombinedRecognizer)
            return new SingaporeIDCombinedRecognitionResultExtractor(context);

        else if (result instanceof RomanianIDFrontRecognizer)
            return new RomanianIDFrontSideRecognitionResultExtractor(context);

        else if (result instanceof UnitedArabEmiratesIDFrontRecognizer)
            return new UnitedArabEmiratesIDFrontRecognitionResultExtractor(context);
            
        else if (result instanceof UnitedArabEmiratesIDBackRecognizer)
            return new UnitedArabEmiratesIDBackRecognitionResultExtractor(context);

        else if (result instanceof MRTDCombinedRecognizer)
            return new MRTDCombinedRecognitionResultExtractor(context);

        else if (result instanceof MRTDRecognizer)
            return new MrtdRecognitionResultExtractorFactory(context);

        else if (result instanceof DetectorRecognizer)
            return new DetectorRecognitionResultExtractor(context);

        return new BaseRecognitionResultExtractor(context);
    }
}
