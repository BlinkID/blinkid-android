package com.microblink.result.extract.blinkid;

import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDLBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDLFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.entities.recognizers.blinkid.egypt.EgyptIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.eudl.EUDLRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyOldIDRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.indonesia.IndonesiaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.IKadRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaDLFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyTenteraRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDRecognizer;
import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDLFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIDBackSideRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIDFrontSideRecognizer;
import com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIDFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognizer;
import com.microblink.result.extract.blinkid.australia.AustralianDLBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.australia.AustralianDLFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianPassportRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.colombia.ColombiaIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.colombia.ColombiaIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.croatia.CroatianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.croatia.CroatianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.croatia.CroatianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.czechia.CzechIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.czechia.CzechIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.czechia.CzechIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.documentface.DocumentFaceRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.egypt.EgyptIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.eudl.EUDriversLicenceRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanOldIDRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanPassportRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.hongkong.HongKongIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.indonesia.IndonesianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.jordan.JordanIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.jordan.JordanIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.jordan.JordanIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.IKadRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MalaysianDLFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MyKadBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MyKadFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MyTenteraRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.mrtd.MRTDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.mrtd.MrtdRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.newzealand.NewZealandDLFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.poland.PolishIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.poland.PolishIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.poland.PolishIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.romania.RomanianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.serbia.SerbianIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.serbia.SerbianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.serbia.SerbianIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovakia.SlovakIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovakia.SlovakIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovakia.SlovakIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovenia.SlovenianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovenia.SlovenianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovenia.SlovenianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.switzerland.SwissIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.switzerland.SwissIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.switzerland.SwissPassportRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkinput.BlinkInputResultExtractorFactory;
import com.microblink.result.extract.usdl.USDLResultExtractor;

public class BlinkIdResultExtractorFactory extends BlinkInputResultExtractorFactory {

    @Override
    protected void addExtractors() {
        super.addExtractors();

        add(USDLRecognizer.class,
                new USDLResultExtractor());
        add(SerbiaIDFrontRecognizer.class,
                new SerbianIDFrontRecognitionResultExtractor());
        add(SerbiaIDBackRecognizer.class,
                new SerbianIDBackRecognitionResultExtractor());
        add(AustraliaDLFrontSideRecognizer.class,
                new AustralianDLFrontSideRecognitionResultExtractor());
        add(AustraliaDLBackSideRecognizer.class,
                new AustralianDLBackSideRecognitionResultExtractor());
        add(AustriaIDFrontSideRecognizer.class,
                new AustrianIDFrontSideRecognitionResultExtractor());
        add(AustriaIDBackSideRecognizer.class,
                new AustrianIDBackSideRecognitionResultExtractor());
        add(AustriaCombinedRecognizer.class,
                new AustrianIDCombinedRecognitionResultExtractor());
        add(AustriaPassportRecognizer.class,
                new AustrianPassportRecognitionResultExtractor());
        add(CroatiaIDFrontSideRecognizer.class,
                new CroatianIDFrontSideRecognitionResultExtractor());
        add(CroatiaIDBackSideRecognizer.class,
                new CroatianIDBackSideRecognitionResultExtractor());
        add(CroatiaCombinedRecognizer.class,
                new CroatianIDCombinedRecognitionResultExtractor());
        add(CzechiaIDBackSideRecognizer.class,
                new CzechIDBackSideRecognitionResultExtractor());
        add(CzechiaIDFrontSideRecognizer.class,
                new CzechIDFrontSideRecognitionResultExtractor());
        add(CzechiaCombinedRecognizer.class,
                new CzechIDCombinedRecognitionResultExtractor());
        add(GermanyOldIDRecognizer.class,
                new GermanOldIDRecognitionResultExtractor());
        add(GermanyIDBackSideRecognizer.class,
                new GermanIDBackSideRecognitionResultExtractor());
        add(GermanyCombinedRecognizer.class,
                new GermanIDCombinedRecognitionResultExtractor());
        add(GermanyIDFrontSideRecognizer.class,
                new GermanIDFrontSideRecognitionResultExtractor());
        add(GermanyPassportRecognizer.class,
                new GermanPassportRecognitionResultExtractor());
        add(IndonesiaIDFrontRecognizer.class,
                new IndonesianIDFrontSideRecognitionResultExtractor());
        add(JordanIDFrontRecognizer.class,
                new JordanIDFrontRecognitionResultExtractor());
        add(JordanIDBackRecognizer.class,
                new JordanIDBackRecognitionResultExtractor());
        add(JordanCombinedRecognizer.class,
                new JordanIDCombinedRecognitionResultExtractor());
        add(HongKongIDFrontRecognizer.class,
                new HongKongIDFrontRecognitionResultExtractor());
        add(ColombiaIDFrontSideRecognizer.class,
                new ColombiaIDFrontRecognitionResultExtractor());
        add(ColombiaIDBackSideRecognizer.class,
                new ColombiaIDBackRecognitionResultExtractor());
        add(EgyptIDFrontRecognizer.class,
                new EgyptIDFrontRecognitionResultExtractor());
        add(MalaysiaDLFrontRecognizer.class,
                new MalaysianDLFrontRecognitionResultExtractor());
        add(NewZealandDLFrontRecognizer.class,
                new NewZealandDLFrontSideRecognitionResultExtractor());
        add(SwitzerlandIDBackRecognizer.class,
                new SwissIDBackSideRecognitionResultExtractor());
        add(SwitzerlandPassportRecognizer.class,
                new SwissPassportRecognitionResultExtractor());
        add(SwitzerlandIDFrontRecognizer.class,
                new SwissIDFrontSideRecognitionResultExtractor());
        add(EUDLRecognizer.class,
                new EUDriversLicenceRecognitionResultExtractor());
        add(DocumentFaceRecognizer.class,
                new DocumentFaceRecognitionResultExtractor());
        add(MyKadFrontRecognizer.class,
                new MyKadFrontRecognitionResultExtractor());
        add(MyKadBackRecognizer.class,
                new MyKadBackRecognitionResultExtractor());
        add(MyTenteraRecognizer.class,
                new MyTenteraRecognitionResultExtractor());
        add(IKadRecognizer.class,
                new IKadRecognitionResultExtractor());
        add(PolandIDBackSideRecognizer.class,
                new PolishIDBackSideRecognitionResultExtractor());
        add(PolandIDFrontSideRecognizer.class,
                new PolishIDFrontSideRecognitionResultExtractor());
        add(PolandCombinedRecognizer.class,
                new PolishIDCombinedRecognitionResultExtractor());
        add(SlovakiaIDBackRecognizer.class,
                new SlovakIDBackSideRecognitionResultExtractor());
        add(SlovakiaIDFrontRecognizer.class,
                new SlovakIDFrontSideRecognitionResultExtractor());
        add(SlovakiaCombinedRecognizer.class,
                new SlovakIDCombinedRecognitionResultExtractor());
        add(SloveniaIDFrontRecognizer.class,
                new SlovenianIDFrontSideRecognitionResultExtractor());
        add(SloveniaIDBackRecognizer.class,
                new SlovenianIDBackSideRecognitionResultExtractor());
        add(SloveniaCombinedRecognizer.class,
                new SlovenianIDCombinedRecognitionResultExtractor());
        add(SerbiaCombinedRecognizer.class,
                new SerbianIDCombinedRecognitionResultExtractor());
        add(SingaporeIDBackRecognizer.class,
                new SingaporeIDBackRecognitionResultExtractor());
        add(SingaporeIDFrontRecognizer.class,
                new SingaporeIDFrontRecognitionResultExtractor());
        add(SingaporeCombinedRecognizer.class,
                new SingaporeIDCombinedRecognitionResultExtractor());
        add(RomaniaIDFrontRecognizer.class,
                new RomanianIDFrontSideRecognitionResultExtractor());
        add(UnitedArabEmiratesIDFrontRecognizer.class,
                new UnitedArabEmiratesIDFrontRecognitionResultExtractor());
        add(UnitedArabEmiratesIDBackRecognizer.class,
                new UnitedArabEmiratesIDBackRecognitionResultExtractor());
        add(MRTDCombinedRecognizer.class,
                new MRTDCombinedRecognitionResultExtractor());
        add(MRTDRecognizer.class,
                new MrtdRecognitionResultExtractor());
    }

}
