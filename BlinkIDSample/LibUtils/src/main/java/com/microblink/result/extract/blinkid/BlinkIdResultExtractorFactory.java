package com.microblink.result.extract.blinkid;

import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlBackRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.entities.recognizers.blinkid.egypt.EgyptIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.eudl.EudlRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyOldIdRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.indonesia.IndonesiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.IkadRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyTenteraRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.romania.RomaniaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
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
import com.microblink.result.extract.blinkid.usdl.USDLCombinedResultExtractor;
import com.microblink.result.extract.blinkinput.BlinkInputResultExtractorFactory;
import com.microblink.result.extract.usdl.USDLResultExtractor;

public class BlinkIdResultExtractorFactory extends BlinkInputResultExtractorFactory {

    @Override
    protected void addExtractors() {
        super.addExtractors();

        add(AustraliaDlFrontRecognizer.class,
                new AustralianDLFrontSideRecognitionResultExtractor());
        add(AustraliaDlBackRecognizer.class,
                new AustralianDLBackSideRecognitionResultExtractor());
        add(AustriaIdFrontRecognizer.class,
                new AustrianIDFrontSideRecognitionResultExtractor());
        add(AustriaIdBackRecognizer.class,
                new AustrianIDBackSideRecognitionResultExtractor());
        add(AustriaCombinedRecognizer.class,
                new AustrianIDCombinedRecognitionResultExtractor());
        add(AustriaPassportRecognizer.class,
                new AustrianPassportRecognitionResultExtractor());
        add(CroatiaIdFrontRecognizer.class,
                new CroatianIDFrontSideRecognitionResultExtractor());
        add(CroatiaIdBackRecognizer.class,
                new CroatianIDBackSideRecognitionResultExtractor());
        add(CroatiaCombinedRecognizer.class,
                new CroatianIDCombinedRecognitionResultExtractor());
        add(CzechiaIdBackRecognizer.class,
                new CzechIDBackSideRecognitionResultExtractor());
        add(CzechiaIdFrontRecognizer.class,
                new CzechIDFrontSideRecognitionResultExtractor());
        add(CzechiaCombinedRecognizer.class,
                new CzechIDCombinedRecognitionResultExtractor());
        add(GermanyOldIdRecognizer.class,
                new GermanOldIDRecognitionResultExtractor());
        add(GermanyIdBackRecognizer.class,
                new GermanIDBackSideRecognitionResultExtractor());
        add(GermanyCombinedRecognizer.class,
                new GermanIDCombinedRecognitionResultExtractor());
        add(GermanyIdFrontRecognizer.class,
                new GermanIDFrontSideRecognitionResultExtractor());
        add(GermanyPassportRecognizer.class,
                new GermanPassportRecognitionResultExtractor());
        add(IndonesiaIdFrontRecognizer.class,
                new IndonesianIDFrontSideRecognitionResultExtractor());
        add(JordanIdFrontRecognizer.class,
                new JordanIDFrontRecognitionResultExtractor());
        add(JordanIdBackRecognizer.class,
                new JordanIDBackRecognitionResultExtractor());
        add(JordanCombinedRecognizer.class,
                new JordanIDCombinedRecognitionResultExtractor());
        add(HongKongIdFrontRecognizer.class,
                new HongKongIDFrontRecognitionResultExtractor());
        add(ColombiaIdFrontRecognizer.class,
                new ColombiaIDFrontRecognitionResultExtractor());
        add(ColombiaIdBackRecognizer.class,
                new ColombiaIDBackRecognitionResultExtractor());
        add(EgyptIdFrontRecognizer.class,
                new EgyptIDFrontRecognitionResultExtractor());
        add(MalaysiaDlFrontRecognizer.class,
                new MalaysianDLFrontRecognitionResultExtractor());
        add(NewZealandDlFrontRecognizer.class,
                new NewZealandDLFrontSideRecognitionResultExtractor());
        add(SwitzerlandIdBackRecognizer.class,
                new SwissIDBackSideRecognitionResultExtractor());
        add(SwitzerlandPassportRecognizer.class,
                new SwissPassportRecognitionResultExtractor());
        add(SwitzerlandIdFrontRecognizer.class,
                new SwissIDFrontSideRecognitionResultExtractor());
        add(EudlRecognizer.class,
                new EUDriversLicenceRecognitionResultExtractor());
        add(DocumentFaceRecognizer.class,
                new DocumentFaceRecognitionResultExtractor());
        add(MyKadFrontRecognizer.class,
                new MyKadFrontRecognitionResultExtractor());
        add(MyKadBackRecognizer.class,
                new MyKadBackRecognitionResultExtractor());
        add(MyTenteraRecognizer.class,
                new MyTenteraRecognitionResultExtractor());
        add(IkadRecognizer.class,
                new IKadRecognitionResultExtractor());
        add(PolandIdBackRecognizer.class,
                new PolishIDBackSideRecognitionResultExtractor());
        add(PolandIdFrontRecognizer.class,
                new PolishIDFrontSideRecognitionResultExtractor());
        add(PolandCombinedRecognizer.class,
                new PolishIDCombinedRecognitionResultExtractor());
        add(SerbiaIdFrontRecognizer.class,
                new SerbianIDFrontRecognitionResultExtractor());
        add(SerbiaIdBackRecognizer.class,
                new SerbianIDBackRecognitionResultExtractor());
        add(SlovakiaIdBackRecognizer.class,
                new SlovakIDBackSideRecognitionResultExtractor());
        add(SlovakiaIdFrontRecognizer.class,
                new SlovakIDFrontSideRecognitionResultExtractor());
        add(SlovakiaCombinedRecognizer.class,
                new SlovakIDCombinedRecognitionResultExtractor());
        add(SloveniaIdFrontRecognizer.class,
                new SlovenianIDFrontSideRecognitionResultExtractor());
        add(SloveniaIdBackRecognizer.class,
                new SlovenianIDBackSideRecognitionResultExtractor());
        add(SloveniaCombinedRecognizer.class,
                new SlovenianIDCombinedRecognitionResultExtractor());
        add(SerbiaCombinedRecognizer.class,
                new SerbianIDCombinedRecognitionResultExtractor());
        add(SingaporeIdBackRecognizer.class,
                new SingaporeIDBackRecognitionResultExtractor());
        add(SingaporeIdFrontRecognizer.class,
                new SingaporeIDFrontRecognitionResultExtractor());
        add(SingaporeCombinedRecognizer.class,
                new SingaporeIDCombinedRecognitionResultExtractor());
        add(RomaniaIdFrontRecognizer.class,
                new RomanianIDFrontSideRecognitionResultExtractor());
        add(UnitedArabEmiratesIdFrontRecognizer.class,
                new UnitedArabEmiratesIDFrontRecognitionResultExtractor());
        add(UnitedArabEmiratesIdBackRecognizer.class,
                new UnitedArabEmiratesIDBackRecognitionResultExtractor());
        add(UsdlRecognizer.class,
                new USDLResultExtractor());
        add(UsdlCombinedRecognizer.class,
                new USDLCombinedResultExtractor());
        add(MrtdCombinedRecognizer.class,
                new MRTDCombinedRecognitionResultExtractor());
        add(MrtdRecognizer.class,
                new MrtdRecognitionResultExtractor());
    }

}
