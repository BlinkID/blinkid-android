package com.microblink.blinkid;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkbarcode.usdl.USDLRecognizer;
import com.microblink.entities.recognizers.blinkid.austria.AustrianCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.croatia.CroatianCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.czechia.CzechCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.germany.GermanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MRTDCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.poland.PolishCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.serbia.SerbianCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovakia.SlovakCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.slovenia.SlovenianCombinedRecognizer;
import com.microblink.hardware.camera.CameraType;
import com.microblink.result.ResultActivity;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int MY_BLINKID_REQUEST_CODE = 0x101;
    private RecognizerBundle mRecognizerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }

        final List<ListElement> elements = buildElements();
        ListView lv = findViewById(R.id.documentList);
        ArrayAdapter<ListElement> listAdapter = new ArrayAdapter<ListElement>(this, android.R.layout.simple_list_item_1, elements);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivityForResult(buildScanIntent(elements.get(position).mRecognizer), MY_BLINKID_REQUEST_CODE);
            }
        });
    }

    private Intent buildScanIntent(Recognizer recognizer) {
        Intent intent = new Intent(this, CustomVerificationFlowActivity.class);
        mRecognizerBundle = new RecognizerBundle(recognizer);
        mRecognizerBundle.saveToIntent(intent);
        intent.putExtra(CustomVerificationFlowActivity.EXTRAS_BEEP_RESOURCE, R.raw.beep);
        intent.putExtra(CustomVerificationFlowActivity.EXTRAS_COMBINED_CAMERA_TYPE, (Parcelable) CameraType.CAMERA_BACKFACE);
        return intent;
    }

    private List<ListElement> buildElements() {
        ArrayList<ListElement> elements = new ArrayList<ListElement>();

        elements.add(buildMRTDCombinedElement());
        elements.add(buildAustrianIDCombinedElement());
        elements.add(buildCroatianIDCombinedElement());
        elements.add(buildCzhechIDCombinedElement());
        elements.add(buildGermanIDCombinedElement());
        elements.add(buildJordanIDCombinedElement());
        elements.add(buildPolishIDCombinedElement());
        elements.add(buildSerbianIDCombinedElement());
        elements.add(buildSingaporeIDCombinedElement());
        elements.add(buildSlovakIDCombinedElement());
        elements.add(buildSlovenianIDCombinedElement());

        return elements;
    }

    private ListElement buildMRTDCombinedElement() {
        return new ListElement("MRTD combined", new MRTDCombinedRecognizer());
    }

    private ListElement buildAustrianIDCombinedElement() {
        return new ListElement("Austrian ID combined", new AustrianCombinedRecognizer());
    }

    private ListElement buildCroatianIDCombinedElement() {
        return new ListElement("Croatian ID combined", new CroatianCombinedRecognizer());
    }

    private ListElement buildCzhechIDCombinedElement() {
        return new ListElement("Czech ID combined", new CzechCombinedRecognizer());
    }

    private ListElement buildGermanIDCombinedElement() {
        return new ListElement("German ID combined", new GermanCombinedRecognizer());
    }

    private ListElement buildJordanIDCombinedElement() {
        return new ListElement("Jordan ID combined", new JordanCombinedRecognizer());
    }

    private ListElement buildPolishIDCombinedElement() {
        return new ListElement("Polish ID combined", new PolishCombinedRecognizer());
    }

    private ListElement buildSerbianIDCombinedElement() {
        return new ListElement("Serbian ID combined", new SerbianCombinedRecognizer());
    }

    private ListElement buildSingaporeIDCombinedElement() {
        return new ListElement("Singapore ID combined", new SingaporeCombinedRecognizer());
    }

    private ListElement buildSlovakIDCombinedElement() {
        return new ListElement("Slovak ID combined", new SlovakCombinedRecognizer());
    }

    private ListElement buildSlovenianIDCombinedElement() {
        return new ListElement("Slovenian ID combined", new SlovenianCombinedRecognizer());
    }

    /**
     * This method is invoked after returning from scan activity. You can obtain
     * scan results here
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != MY_BLINKID_REQUEST_CODE) {
            return;
        }

        // make sure BlinkID activity returned result
        if (resultCode == CustomVerificationFlowActivity.RESULT_OK && data != null) {
            // set intent's component to ResultActivity and pass its contents
            // to ResultActivity. ResultActivity will show how to extract data from result.
            data.setComponent(new ComponentName(this, ResultActivity.class));
            data.putExtra(ResultActivity.EXTRAS_RESULT_TYPE, ResultActivity.ResultType.RECOGNIZER_BUNDLE);
            startActivity(data);
        } else {
            // if BlinkID activity did not return result, user has probably
            // pressed Back button and cancelled scanning
            Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
        }
    }

    private class ListElement {
        private String mTitle;
        private Recognizer mRecognizer;

        public String getTitle() {
            return mTitle;
        }

        ListElement(String title, Recognizer recognizer) {
            mTitle = title;
            mRecognizer = recognizer;
        }

        @Override
        public String toString() {
            return getTitle();
        }
    }
}
