package com.microblink.libresult;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.microblink.libresult.extract.BaseRecognitionResultExtractor;
import com.microblink.libresult.extract.IBaseRecognitionResultExtractor;
import com.microblink.libresult.extract.RecognitionResultEntry;
import com.microblink.libresult.extract.australia.AustralianDLBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.australia.AustralianDLFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.austria.AustrianIDBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.austria.AustrianIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.austria.AustrianIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.austria.AustrianPassportRecognitionResultExtractor;
import com.microblink.libresult.extract.barcode.BarcodeRecognitionResultExtractor;
import com.microblink.libresult.extract.barcode.Pdf417RecognitionResultExtractor;
import com.microblink.libresult.extract.blinkInput.BlinkOcrRecognitionResultExtractor;
import com.microblink.libresult.extract.colombia.ColombiaIDBackRecognitionResultExtractor;
import com.microblink.libresult.extract.colombia.ColombiaIDFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.croatia.CroatianIDBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.croatia.CroatianIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.croatia.CroatianIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.czechia.CzechIDBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.czechia.CzechIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.czechia.CzechIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.egypt.EgyptIDFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.eudl.EUDLRecognitionResultExtractor;
import com.microblink.libresult.extract.germany.GermanIDBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.germany.GermanIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.germany.GermanIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.germany.GermanOldIDRecognitionResultExtractor;
import com.microblink.libresult.extract.germany.GermanPassportRecognitionResultExtractor;
import com.microblink.libresult.extract.hongkong.HongKongIDFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.indonesia.IndonesianIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.jordan.JordanIDBackRecognitionResultExtractor;
import com.microblink.libresult.extract.jordan.JordanIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.jordan.JordanIDFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.malaysia.IKadRecognitionResultExtractor;
import com.microblink.libresult.extract.malaysia.MalaysianDLFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.malaysia.MyKadBackRecognitionResultExtractor;
import com.microblink.libresult.extract.malaysia.MyKadFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.malaysia.MyTenteraRecognitionResultExtractor;
import com.microblink.libresult.extract.mrtd.MRTDRecognitionResultExtractor;
import com.microblink.libresult.extract.newzealand.NewZealandDLFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.poland.PolishIDBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.poland.PolishIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.poland.PolishIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.romania.RomanianIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.serbia.SerbianIDBackRecognitionResultExtractor;
import com.microblink.libresult.extract.serbia.SerbianIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.serbia.SerbianIDFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.simnumber.SimNumberRecognitionResultExtractor;
import com.microblink.libresult.extract.singapore.SingaporeIDBackRecognitionResultExtractor;
import com.microblink.libresult.extract.singapore.SingaporeIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.singapore.SingaporeIDFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.slovakia.SlovakIDBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.slovakia.SlovakIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.slovakia.SlovakIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.slovenia.SlovenianIDBackRecognitionResultExtractor;
import com.microblink.libresult.extract.slovenia.SlovenianIDCombinedRecognitionResultExtractor;
import com.microblink.libresult.extract.slovenia.SlovenianIDFrontRecognitionResultExtractor;
import com.microblink.libresult.extract.switzerland.SwissIDBackSideRecognitionResultExtractor;
import com.microblink.libresult.extract.switzerland.SwissIDFrontSideRecognitionResultExtractor;
import com.microblink.libresult.extract.switzerland.SwissPassportRecognitionResultExtractor;
import com.microblink.libresult.extract.unitedArabEmirates.UnitedArabEmiratesIDBackRecognitionResultExtractor;
import com.microblink.libresult.extract.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognitionResultExtractor;
import com.microblink.locale.LanguageUtils;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.blinkbarcode.barcode.BarcodeScanResult;
import com.microblink.recognizers.blinkbarcode.pdf417.Pdf417ScanResult;
import com.microblink.recognizers.blinkbarcode.simnumber.SimNumberScanResult;
import com.microblink.recognizers.blinkid.australia.driversLicense.back.AustralianDLBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.australia.driversLicense.front.AustralianDLFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.austria.back.AustrianIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.austria.combined.AustrianIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.austria.front.AustrianIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.austria.passport.AustrianPassportRecognitionResult;
import com.microblink.recognizers.blinkid.colombia.back.ColombiaIDBackRecognitionResult;
import com.microblink.recognizers.blinkid.colombia.front.ColombiaIDFrontRecognitionResult;
import com.microblink.recognizers.blinkid.croatia.back.CroatianIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.croatia.combined.CroatianIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.croatia.front.CroatianIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.czechia.back.CzechIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.czechia.combined.CzechIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.czechia.front.CzechIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.egypt.front.EgyptIDFrontRecognitionResult;
import com.microblink.recognizers.blinkid.eudl.EUDLRecognitionResult;
import com.microblink.recognizers.blinkid.germany.back.GermanIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.germany.combined.GermanIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.germany.front.GermanIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.germany.old.front.GermanOldIDRecognitionResult;
import com.microblink.recognizers.blinkid.germany.passport.GermanPassportRecognitionResult;
import com.microblink.recognizers.blinkid.hongkong.front.HongKongIDFrontRecognitionResult;
import com.microblink.recognizers.blinkid.indonesia.front.IndonesianIDFrontRecognitionResult;
import com.microblink.recognizers.blinkid.jordan.back.JordanIDBackRecognitionResult;
import com.microblink.recognizers.blinkid.jordan.combined.JordanIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.jordan.front.JordanIDFrontRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.dl.front.MalaysianDLFrontRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.ikad.IKadRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.mykad.back.MyKadBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.mykad.front.MyKadFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.malaysia.tentera.MyTenteraRecognitionResult;
import com.microblink.recognizers.blinkid.mrtd.MRTDRecognitionResult;
import com.microblink.recognizers.blinkid.newzealand.driversLicense.front.NewZealandDLFrontRecognitionResult;
import com.microblink.recognizers.blinkid.poland.back.PolishIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.poland.combined.PolishIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.poland.front.PolishIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.romania.front.RomanianIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.serbia.back.SerbianIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.serbia.combined.SerbianIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.serbia.front.SerbianIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.singapore.back.SingaporeIDBackRecognitionResult;
import com.microblink.recognizers.blinkid.singapore.combined.SingaporeIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.singapore.front.SingaporeIDFrontRecognitionResult;
import com.microblink.recognizers.blinkid.slovakia.back.SlovakIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.slovakia.combined.SlovakIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.slovakia.front.SlovakIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.slovenia.back.SlovenianIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.slovenia.combined.SlovenianIDCombinedRecognitionResult;
import com.microblink.recognizers.blinkid.slovenia.front.SlovenianIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.switzerland.back.SwissIDBackSideRecognitionResult;
import com.microblink.recognizers.blinkid.switzerland.front.SwissIDFrontSideRecognitionResult;
import com.microblink.recognizers.blinkid.switzerland.passport.SwissPassportRecognitionResult;
import com.microblink.recognizers.blinkid.unitedArabEmirates.back.UnitedArabEmiratesIDBackRecognitionResult;
import com.microblink.recognizers.blinkid.unitedArabEmirates.front.UnitedArabEmiratesIDFrontRecognitionResult;
import com.microblink.recognizers.blinkocr.BlinkOCRRecognitionResult;

import java.util.List;

/**
 * Created by igor on 12/2/14.
 */
public class ResultFragment extends Fragment {

    private static final String DATA = "DATA";
    public static final String RESULT_PARCELABLE = "RESULT_PARCELABLE";

    IBaseRecognitionResultExtractor mResultExtractor = null;
    List<RecognitionResultEntry> extractedData;
    private BaseRecognitionResult mData = null;

    private AbsListView mListView;
    private ListAdapter mAdapter;

    // newInstance constructor for creating fragment with arguments
    public static ResultFragment newInstance(Parcelable result) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putParcelable(RESULT_PARCELABLE, result);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("InlinedApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.containsKey(DATA)) {
            mData = savedInstanceState.getParcelable(DATA);
        }
        if (mData == null) {
            Bundle extras = getArguments();
            if (extras != null) {
                mData =  extras.getParcelable(RESULT_PARCELABLE);
            }
        }

        // CroatianIDBackSideRecognitionResult extends MRTDRecognitionResult so we first need
        // to check for CroatianIDBackSideRecognitionResult and then for MRTDRecognitionResult

        if (mData instanceof SingaporeIDFrontRecognitionResult) {
            mResultExtractor = new SingaporeIDFrontRecognitionResultExtractor(getActivity());
        } else if ( mData instanceof SingaporeIDBackRecognitionResult) {
            mResultExtractor = new SingaporeIDBackRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SingaporeIDCombinedRecognitionResult) {
            mResultExtractor = new SingaporeIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof AustralianDLFrontSideRecognitionResult) {
            mResultExtractor = new AustralianDLFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof AustralianDLBackSideRecognitionResult) {
            mResultExtractor = new AustralianDLBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof AustrianIDBackSideRecognitionResult) {
            mResultExtractor = new AustrianIDBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof AustrianIDFrontSideRecognitionResult) {
            mResultExtractor = new AustrianIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof AustrianIDCombinedRecognitionResult) {
            mResultExtractor = new AustrianIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof AustrianPassportRecognitionResult) {
            mResultExtractor = new AustrianPassportRecognitionResultExtractor(getActivity());
        } else if (mData instanceof ColombiaIDBackRecognitionResult) {
            mResultExtractor = new ColombiaIDBackRecognitionResultExtractor(getActivity());
        } else if (mData instanceof ColombiaIDFrontRecognitionResult) {
            mResultExtractor = new ColombiaIDFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof CroatianIDBackSideRecognitionResult) {
            mResultExtractor = new CroatianIDBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof CroatianIDFrontSideRecognitionResult) {
            mResultExtractor = new CroatianIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof CroatianIDCombinedRecognitionResult) {
            mResultExtractor = new CroatianIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof CzechIDBackSideRecognitionResult) {
            mResultExtractor = new CzechIDBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof CzechIDFrontSideRecognitionResult) {
            mResultExtractor = new CzechIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof CzechIDCombinedRecognitionResult) {
            mResultExtractor = new CzechIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof EgyptIDFrontRecognitionResult) {
            mResultExtractor = new EgyptIDFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof GermanIDBackSideRecognitionResult) {
            mResultExtractor = new GermanIDBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof GermanIDFrontSideRecognitionResult) {
            mResultExtractor = new GermanIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof GermanOldIDRecognitionResult) {
            mResultExtractor = new GermanOldIDRecognitionResultExtractor(getActivity());
        } else if (mData instanceof GermanPassportRecognitionResult) {
            mResultExtractor = new GermanPassportRecognitionResultExtractor(getActivity());
        } else if (mData instanceof GermanIDCombinedRecognitionResult) {
            mResultExtractor = new GermanIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof HongKongIDFrontRecognitionResult) {
            mResultExtractor = new HongKongIDFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof IndonesianIDFrontRecognitionResult) {
            mResultExtractor = new IndonesianIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof JordanIDFrontRecognitionResult) {
            mResultExtractor = new JordanIDFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof JordanIDBackRecognitionResult) {
            mResultExtractor = new JordanIDBackRecognitionResultExtractor(getActivity());
        } else if (mData instanceof JordanIDCombinedRecognitionResult) {
            mResultExtractor = new JordanIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof NewZealandDLFrontRecognitionResult) {
            mResultExtractor = new NewZealandDLFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof PolishIDBackSideRecognitionResult) {
            mResultExtractor = new PolishIDBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof PolishIDFrontSideRecognitionResult) {
            mResultExtractor = new PolishIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof PolishIDCombinedRecognitionResult) {
            mResultExtractor = new PolishIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof RomanianIDFrontSideRecognitionResult) {
            mResultExtractor = new RomanianIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SlovakIDBackSideRecognitionResult) {
            mResultExtractor = new SlovakIDBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SlovakIDFrontSideRecognitionResult) {
            mResultExtractor = new SlovakIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SlovakIDCombinedRecognitionResult) {
            mResultExtractor = new SlovakIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SerbianIDBackSideRecognitionResult) {
            mResultExtractor = new SerbianIDBackRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SerbianIDFrontSideRecognitionResult) {
            mResultExtractor = new SerbianIDFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SerbianIDCombinedRecognitionResult) {
            mResultExtractor = new SerbianIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SlovenianIDBackSideRecognitionResult) {
            mResultExtractor = new SlovenianIDBackRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SlovenianIDFrontSideRecognitionResult) {
            mResultExtractor = new SlovenianIDFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SlovenianIDCombinedRecognitionResult) {
            mResultExtractor = new SlovenianIDCombinedRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SwissIDBackSideRecognitionResult) {
            mResultExtractor = new SwissIDBackSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SwissIDFrontSideRecognitionResult) {
            mResultExtractor = new SwissIDFrontSideRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SwissPassportRecognitionResult) {
            mResultExtractor = new SwissPassportRecognitionResultExtractor(getActivity());
        } else if (mData instanceof UnitedArabEmiratesIDBackRecognitionResult) {
            mResultExtractor = new UnitedArabEmiratesIDBackRecognitionResultExtractor(getActivity());
        } else if (mData instanceof UnitedArabEmiratesIDFrontRecognitionResult) {
            mResultExtractor = new UnitedArabEmiratesIDFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof IKadRecognitionResult) {
            mResultExtractor = new IKadRecognitionResultExtractor(getActivity());
        } else if (mData instanceof MyKadFrontSideRecognitionResult) {
            mResultExtractor = new MyKadFrontRecognitionResultExtractor(getActivity());
        } else if (mData instanceof MyKadBackSideRecognitionResult) {
            mResultExtractor = new MyKadBackRecognitionResultExtractor(getActivity());
        } else if (mData instanceof MyTenteraRecognitionResult) {
            mResultExtractor = new MyTenteraRecognitionResultExtractor(getActivity());
        } else if (mData instanceof MalaysianDLFrontRecognitionResult) {
            mResultExtractor = new MalaysianDLFrontRecognitionResultExtractor(getActivity());
        } else if(mData instanceof MRTDRecognitionResult) {
            mResultExtractor = new MRTDRecognitionResultExtractor(getActivity());
        } else if(mData instanceof EUDLRecognitionResult) {
            mResultExtractor = new EUDLRecognitionResultExtractor(getActivity());
        } else if (mData instanceof Pdf417ScanResult) {
            mResultExtractor = new Pdf417RecognitionResultExtractor(getActivity());
        } else if (mData instanceof BarcodeScanResult) {
            mResultExtractor = new BarcodeRecognitionResultExtractor(getActivity());
        } else if (mData instanceof SimNumberScanResult) {
            mResultExtractor = new SimNumberRecognitionResultExtractor(getActivity());
        } else if (mData instanceof BlinkOCRRecognitionResult) {
            mResultExtractor = new BlinkOcrRecognitionResultExtractor(getActivity());
        } else {
            mResultExtractor = new BaseRecognitionResultExtractor(getActivity());
        }

        // Extract data from BaseRecognitionResult
        extractedData = mResultExtractor.extractData(mData);
        if (extractedData.size() < 1) {
            Toast.makeText(getActivity(), "Result list is empty", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }

        // Create adapter which will be used to populate ListView.
        mAdapter = new ResultEntryAdapter(getActivity(), R.layout.result_entry, extractedData);

        // Hide virtual keyboard
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView listView = new ListView(getActivity());

        listView.setAdapter(mAdapter);
        // some id is required so that android can save listview's scroll state
        // when activity goes to background
        // the id does not need to be unique
        listView.setId(android.R.id.text2);
        return listView;
    }

    @Override
    public void onResume() {
        LanguageUtils.setLanguageConfiguration(getResources());
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mData != null) {
            outState.putParcelable(DATA, mData);
        }
        super.onSaveInstanceState(outState);
    }
}
