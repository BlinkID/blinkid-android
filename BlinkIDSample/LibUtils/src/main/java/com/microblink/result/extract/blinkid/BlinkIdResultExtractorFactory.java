package com.microblink.result.extract.blinkid;

import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlBackRecognizer;
import com.microblink.entities.recognizers.blinkid.australia.AustraliaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.colombia.ColombiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.cyprus.CyprusIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.cyprus.CyprusIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.entities.recognizers.blinkid.egypt.EgyptIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardBackRecognizer;
import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.elitepaymentcard.ElitePaymentCardFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.eudl.EudlRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyDlBackRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyOldIdRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanyPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.hongkong.HongKongIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.indonesia.IndonesiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.ireland.IrelandDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.italy.ItalyDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.kuwait.KuwaitIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.kuwait.KuwaitIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.IkadRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MalaysiaMyTenteraFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadBackRecognizer;
import com.microblink.entities.recognizers.blinkid.malaysia.MyKadFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.mexico.MexicoVoterIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.morocco.MoroccoIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.morocco.MoroccoIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.newzealand.NewZealandDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardBackRecognizer;
import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.paymentcard.PaymentCardFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolandIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.romania.RomaniaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeChangiEmployeeIdRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakiaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.spain.SpainDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.sweden.dl.SwedenDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesDlFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdBackRecognizer;
import com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdFrontRecognizer;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.result.extract.blinkid.australia.AustralianDLBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.australia.AustralianDLFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustriaDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.austria.AustrianPassportRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.colombia.ColombiaDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.colombia.ColombiaIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.colombia.ColombiaIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.croatia.CroatianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.croatia.CroatianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.croatia.CroatianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.cyprus.CyprusIdBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.cyprus.CyprusIdFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.czechia.CzechIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.czechia.CzechIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.czechia.CzechIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.documentface.DocumentFaceRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.egypt.EgyptIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.elitepaymentcard.ElitePaymentCardBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.elitepaymentcard.ElitePaymentCardCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.elitepaymentcard.ElitePaymentCardFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.eudl.EUDriversLicenceRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanDLBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanOldIDRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.germany.GermanPassportRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.hongkong.HongKongIdFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.indonesia.IndonesianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.ireland.IrelandDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.italy.ItalyDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.jordan.JordanIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.jordan.JordanIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.jordan.JordanIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.kuwait.KuwaitIdBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.kuwait.KuwaitIdFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.IKadRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MalaysianDLFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MyKadBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MyKadFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.malaysia.MyTenteraRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.mexico.MexicoVoterIdFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.morocco.MoroccoIdBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.morocco.MoroccoIdFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.mrtd.MRTDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.mrtd.MrtdRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.newzealand.NewZealandDLFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.paymentcard.PaymentCardBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.paymentcard.PaymentCardCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.paymentcard.PaymentCardFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.poland.PolishIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.poland.PolishIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.poland.PolishIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.romania.RomanianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.serbia.SerbianIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.serbia.SerbianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.serbia.SerbianIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeChangiEmployeeIdRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.singapore.SingaporeIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovakia.SlovakIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovakia.SlovakIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovakia.SlovakIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovenia.SlovenianIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovenia.SlovenianIDCombinedRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.slovenia.SlovenianIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.spain.SpainDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.sweden.SwedenDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.switzerland.SwissDLFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.switzerland.SwissIDBackSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.switzerland.SwissIDFrontSideRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.switzerland.SwissPassportRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.unitedArabEmirates.UnitedArabEmiratesDlFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognitionResultExtractor;
import com.microblink.result.extract.blinkid.usdl.USDLCombinedResultExtractor;
import com.microblink.result.extract.blinkinput.BlinkInputResultExtractorFactory;
import com.microblink.result.extract.usdl.USDLResultExtractor;

public class BlinkIdResultExtractorFactory extends BlinkInputResultExtractorFactory {

    @Override
    protected void addExtractors() {
        super.addExtractors();

        add(UsdlRecognizer.class,
                new USDLResultExtractor());
        add(UsdlCombinedRecognizer.class,
                new USDLCombinedResultExtractor());
        add(SerbiaIdFrontRecognizer.class,
                new SerbianIDFrontRecognitionResultExtractor());
        add(SerbiaIdBackRecognizer.class,
                new SerbianIDBackRecognitionResultExtractor());
        add(AustraliaDlFrontRecognizer.class,
                new AustralianDLFrontSideRecognitionResultExtractor());
        add(AustraliaDlBackRecognizer.class,
                new AustralianDLBackSideRecognitionResultExtractor());
        add(AustriaDlFrontRecognizer.class,
                new AustriaDlFrontRecognitionResultExtractor());
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
        add(CyprusIdBackRecognizer.class,
                new CyprusIdBackRecognitionResultExtractor());
        add(CyprusIdFrontRecognizer.class,
                new CyprusIdFrontRecognitionResultExtractor());
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
        add(GermanyDlBackRecognizer.class,
                new GermanDLBackSideRecognitionResultExtractor());
        add(IndonesiaIdFrontRecognizer.class,
                new IndonesianIDFrontSideRecognitionResultExtractor());
        add(IrelandDlFrontRecognizer.class,
                new IrelandDlFrontRecognitionResultExtractor());
        add(ItalyDlFrontRecognizer.class,
                new ItalyDlFrontRecognitionResultExtractor());
        add(JordanIdFrontRecognizer.class,
                new JordanIDFrontRecognitionResultExtractor());
        add(JordanIdBackRecognizer.class,
                new JordanIDBackRecognitionResultExtractor());
        add(JordanCombinedRecognizer.class,
                new JordanIDCombinedRecognitionResultExtractor());
        add(HongKongIdFrontRecognizer.class,
                new HongKongIdFrontRecognitionResultExtractor());
        add(ColombiaDlFrontRecognizer.class,
                new ColombiaDlFrontRecognitionResultExtractor());
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
        add(SwitzerlandDlFrontRecognizer.class,
                new SwissDLFrontSideRecognitionResultExtractor());
        add(EudlRecognizer.class,
                new EUDriversLicenceRecognitionResultExtractor());
        add(DocumentFaceRecognizer.class,
                new DocumentFaceRecognitionResultExtractor());
        add(MyKadFrontRecognizer.class,
                new MyKadFrontRecognitionResultExtractor());
        add(MyKadBackRecognizer.class,
                new MyKadBackRecognitionResultExtractor());
        add(MalaysiaMyTenteraFrontRecognizer.class,
                new MyTenteraRecognitionResultExtractor());
        add(IkadRecognizer.class,
                new IKadRecognitionResultExtractor());
        add(MexicoVoterIdFrontRecognizer.class,
                new MexicoVoterIdFrontRecognitionResultExtractor());
        add(MoroccoIdBackRecognizer.class,
                new MoroccoIdBackRecognitionResultExtractor());
        add(MoroccoIdFrontRecognizer.class,
                new MoroccoIdFrontRecognitionResultExtractor());
        add(PaymentCardFrontRecognizer.class,
                new PaymentCardFrontRecognitionResultExtractor());
        add(PaymentCardBackRecognizer.class,
                new PaymentCardBackRecognitionResultExtractor());
        add(PaymentCardCombinedRecognizer.class,
                new PaymentCardCombinedRecognitionResultExtractor());
        add(ElitePaymentCardFrontRecognizer.class,
                new ElitePaymentCardFrontRecognitionResultExtractor());
        add(ElitePaymentCardBackRecognizer.class,
                new ElitePaymentCardBackRecognitionResultExtractor());
        add(ElitePaymentCardCombinedRecognizer.class,
                new ElitePaymentCardCombinedRecognitionResultExtractor());
        add(PolandIdBackRecognizer.class,
                new PolishIDBackSideRecognitionResultExtractor());
        add(PolandIdFrontRecognizer.class,
                new PolishIDFrontSideRecognitionResultExtractor());
        add(PolandCombinedRecognizer.class,
                new PolishIDCombinedRecognitionResultExtractor());
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
                new SingaporeCombinedRecognitionResultExtractor());
        add(SingaporeDlFrontRecognizer.class,
                new SingaporeDlFrontRecognitionResultExtractor());
        add(SingaporeChangiEmployeeIdRecognizer.class,
                new SingaporeChangiEmployeeIdRecognitionResultExtractor());
        add(SpainDlFrontRecognizer.class,
                new SpainDlFrontRecognitionResultExtractor());
        add(RomaniaIdFrontRecognizer.class,
                new RomanianIDFrontSideRecognitionResultExtractor());
        add(UnitedArabEmiratesIdFrontRecognizer.class,
                new UnitedArabEmiratesIDFrontRecognitionResultExtractor());
        add(UnitedArabEmiratesIdBackRecognizer.class,
                new UnitedArabEmiratesIDBackRecognitionResultExtractor());
        add(UnitedArabEmiratesDlFrontRecognizer.class,
                new UnitedArabEmiratesDlFrontRecognitionResultExtractor());
        add(MrtdCombinedRecognizer.class,
                new MRTDCombinedRecognitionResultExtractor());
        add(MrtdRecognizer.class,
                new MrtdRecognitionResultExtractor());
        add(SwedenDlFrontRecognizer.class,
                new SwedenDlFrontRecognitionResultExtractor());
        add(KuwaitIdFrontRecognizer.class,
                new KuwaitIdFrontRecognitionResultExtractor());
        add(KuwaitIdBackRecognizer.class,
                new KuwaitIdBackRecognitionResultExtractor());
    }

}
