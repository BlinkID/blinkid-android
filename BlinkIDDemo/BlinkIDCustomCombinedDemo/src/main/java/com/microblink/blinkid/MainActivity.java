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

import com.microblink.Config;
import com.microblink.activity.ScanActivity;
import com.microblink.hardware.camera.CameraType;
import com.microblink.libresult.ResultActivity;
import com.microblink.recognizers.BaseRecognitionResult;
import com.microblink.recognizers.RecognitionResults;
import com.microblink.recognizers.blinkid.CombinedRecognizerSettings;
import com.microblink.recognizers.blinkid.austria.combined.AustrianIDCombinedRecognizerSettings;
import com.microblink.recognizers.blinkid.croatia.combined.CroatianIDCombinedRecognizerSettings;
import com.microblink.recognizers.blinkid.czechia.combined.CzechIDCombinedRecognizerSettings;
import com.microblink.recognizers.blinkid.serbia.combined.SerbianIDCombinedRecognizerSettings;
import com.microblink.recognizers.blinkid.singapore.combined.SingaporeIDCombinedRecognizerSettings;
import com.microblink.recognizers.blinkid.slovakia.combined.SlovakIDCombinedRecognizerSettings;
import com.microblink.recognizers.blinkid.slovenia.combined.SlovenianIDCombinedRecognizerSettings;
import com.microblink.util.Log;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;
import com.microblink.view.recognition.RecognitionType;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int MY_BLINKID_REQUEST_CODE = 0x101;

    private ListElement[] mElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }

        // build list elements
        buildElements();
        ListView lv = (ListView) findViewById(R.id.documentList);
        ArrayAdapter<ListElement> listAdapter = new ArrayAdapter<ListElement>(this, android.R.layout.simple_list_item_1, mElements);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivityForResult(buildScanIntent(mElements[position].getCombinedRecognizerSettings()), MY_BLINKID_REQUEST_CODE);
            }
        });
    }

    /**
     * Builds scan intent for {@link CustomVerificationFlowActivity} with given combined recognizer settings.
     * @param combinedRecognizerSettings settings for the combined recognizer that will be used.
     * @return scan intent for {@link CustomVerificationFlowActivity} with given combined recognizer settings
     */
    private Intent buildScanIntent(CombinedRecognizerSettings combinedRecognizerSettings) {
        Intent intent = new Intent(this, CustomVerificationFlowActivity.class);
        intent.putExtra(CustomVerificationFlowActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);
        intent.putExtra(CustomVerificationFlowActivity.EXTRAS_COMBINED_RECOGNIZER_SETTINGS, combinedRecognizerSettings);
        intent.putExtra(CustomVerificationFlowActivity.EXTRAS_BEEP_RESOURCE, R.raw.beep);
        intent.putExtra(CustomVerificationFlowActivity.EXTRAS_COMBINED_CAMERA_TYPE, (Parcelable) CameraType.CAMERA_BACKFACE);
        return intent;
    }

    /**
     * This method is used to build the array of ListElement objects. Each ListElement
     * object will have its title that will be shown in ListView and prepared
     * {@link CombinedRecognizerSettings}.
     */
    private void buildElements() {
        ArrayList<ListElement> elements = new ArrayList<ListElement>();

        elements.add(buildAustrianIDCombinedElement());
        elements.add(buildCroatianIDCombinedElement());
        elements.add(buildChechIDCombinedElement());
        elements.add(buildSerbianIDCombinedElement());
        elements.add(buildSingaporeIDCombinedElement());
        elements.add(buildSlovakIDCombinedElement());
        elements.add(buildSlovenianIDCombinedElement());

        mElements = new ListElement[elements.size()];
        elements.toArray(mElements);
    }

    private ListElement buildAustrianIDCombinedElement() {
        AustrianIDCombinedRecognizerSettings ausIDCombined = new AustrianIDCombinedRecognizerSettings();

        return new ListElement("Austrian ID combined", ausIDCombined);
    }

    private ListElement buildCroatianIDCombinedElement() {
        CroatianIDCombinedRecognizerSettings croIDCombined = new CroatianIDCombinedRecognizerSettings();
        return new ListElement("Croatian ID combined", croIDCombined);
    }

    private ListElement buildChechIDCombinedElement() {
        CzechIDCombinedRecognizerSettings czechIDCombined = new CzechIDCombinedRecognizerSettings();

        return new ListElement("Czech ID combined", czechIDCombined);
    }

    private ListElement buildSerbianIDCombinedElement() {
        SerbianIDCombinedRecognizerSettings serbianIDCombined = new SerbianIDCombinedRecognizerSettings();

        return new ListElement("Serbian ID combined", serbianIDCombined);
    }

    private ListElement buildSingaporeIDCombinedElement() {
        SingaporeIDCombinedRecognizerSettings singaporeIDCombined = new SingaporeIDCombinedRecognizerSettings();

        return new ListElement("Singapore ID combined", singaporeIDCombined);
    }

    private ListElement buildSlovakIDCombinedElement() {
        SlovakIDCombinedRecognizerSettings svkIDCombined = new SlovakIDCombinedRecognizerSettings();

        return new ListElement("Slovak ID combined", svkIDCombined);
    }

    private ListElement buildSlovenianIDCombinedElement() {
        SlovenianIDCombinedRecognizerSettings svnIDCombined = new SlovenianIDCombinedRecognizerSettings();

        return new ListElement("Slovenian ID combined", svnIDCombined);
    }

    /**
     * This method is invoked after returning from scan activity. You can obtain
     * scan results here
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // onActivityResult is called whenever we are returned from activity started
        // with startActivityForResult. We need to check request code to determine
        // that we have really returned from BlinkID activity.
        if (requestCode == MY_BLINKID_REQUEST_CODE) {

            // make sure BlinkID activity returned result
            if (resultCode == CustomVerificationFlowActivity.RESULT_OK && data != null) {

                BaseRecognitionResult combinedResult = data.getParcelableExtra(CustomVerificationFlowActivity.EXTRAS_COMBINED_RECOGNITION_RESULT);
                if (combinedResult != null) {
                    // prepare recognition results for ResultActivity, it accepts RecognitionResults extra
                    data.putExtra(ScanActivity.EXTRAS_RECOGNITION_RESULTS, new RecognitionResults(new BaseRecognitionResult[]{combinedResult}, RecognitionType.SUCCESSFUL));
                } else {
                    Log.e(this, "Unable to retrieve recognition results!");
                }
                // set intent's component to ResultActivity and pass its contents
                // to ResultActivity. ResultActivity will show how to extract
                // data from result.
                data.setComponent(new ComponentName(this, ResultActivity.class));
                startActivity(data);
            } else {
                // if BlinkID activity did not return result, user has probably
                // pressed Back button and cancelled scanning
                Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /**
     * Element of {@link ArrayAdapter} for {@link ListView} that holds information about title
     * which should be displayed in the list and
     * {@link com.microblink.recognizers.blinkid.CombinedRecognizerSettings} that should be used
     * when scan activity is started on click.
     */
    private class ListElement {
        private String mTitle;
        private CombinedRecognizerSettings mCombinedRecognizerSettings;

        public String getTitle() {
            return mTitle;
        }

        public CombinedRecognizerSettings getCombinedRecognizerSettings() {
            return mCombinedRecognizerSettings;
        }

        public ListElement(String title, CombinedRecognizerSettings combinedRecognizerSettings) {
            mTitle = title;
            mCombinedRecognizerSettings = combinedRecognizerSettings;
        }

        /**
         * Used by array adapter to determine list element text
         */
        @Override
        public String toString() {
            return getTitle();
        }
    }
}
