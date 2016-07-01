package com.microblink.blinkid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.microblink.Config;
import com.microblink.detectors.DecodingInfo;
import com.microblink.detectors.DetectorSettings;
import com.microblink.detectors.document.DocumentDetectorSettings;
import com.microblink.detectors.document.DocumentSpecification;
import com.microblink.detectors.document.DocumentSpecificationPreset;
import com.microblink.detectors.quad.mrtd.MRTDDetectorSettings;
import com.microblink.geometry.Rectangle;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;

public class MenuActivity extends Activity {

    /** List view elements. */
    private ListElement[] mElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }

        // build list elements
        mElements = buildListElements();
        ListView lv = (ListView) findViewById(R.id.detectorList);
        ArrayAdapter<ListElement> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mElements);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(mElements[position].getScanIntent());
            }
        });
    }

    /**
     * Builds intent that can be used to start the {@link DetectorActivity} with given detector settings.
     * @param detectorSettings Detector settings determine which detector will be used.
     * @return Intent that can be used to start the {@link DetectorActivity} with given detector settings.
     */
    private Intent buildDetectorIntent(DetectorSettings detectorSettings) {
        Intent intent = new Intent(this, DetectorActivity.class);
        // pass detector settings, DetectorActivity accepts array of detector settings
        intent.putExtra(DetectorActivity.EXTRAS_DETECTOR_SETTINGS,
                new DetectorSettings[]{detectorSettings});
        // pass license key
        intent.putExtra(DetectorActivity.EXTRAS_LICENSE_KEY, Config.LICENSE_KEY);
        return intent;
    }


    /**
     * This method is used to build the array of {@link ListElement} objects.
     * @return Array of {@link ListElement} objects. Each {@link ListElement}
     * object will have its title that will be shown in ListView and prepared intent
     * that can be used to start the {@link DetectorActivity}.
     */
    private ListElement[] buildListElements() {
        ArrayList<ListElement> elements = new ArrayList<>();

        // * Document list entries *
        // define document specification for idCard, use provided preset
        DocumentSpecification idSpec = DocumentSpecification.createFromPreset(
                DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD);
        elements.add(buildDocumentDetectorElement(getString(R.string.id_detector), idSpec));

        // define document specification for cheque, use provided preset
        DocumentSpecification chequeSpec = DocumentSpecification.createFromPreset(
                DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_CHEQUE);
        elements.add(buildDocumentDetectorElement(getString(R.string.cheque_detector), chequeSpec));

        // define document specification for A4 portrait, use provided preset
        DocumentSpecification a4PortraitSpec = DocumentSpecification.createFromPreset(
                DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_A4_PORTRAIT);
        elements.add(buildDocumentDetectorElement(getString(R.string.a4_portrait_detector), a4PortraitSpec));

        // define document specification for A4 landscape, use provided preset
        DocumentSpecification a4LandscapeSpec = DocumentSpecification.createFromPreset(
                DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_A4_LANDSCAPE);
        elements.add(buildDocumentDetectorElement(getString(R.string.a4_landscape_detector), a4LandscapeSpec));


        // * MRTD list entry *
        elements.add(buildMRTDDetectorElement());

        ListElement[] elemsArray = new ListElement[elements.size()];
        return elements.toArray(elemsArray);
    }

    /**
     * Builds the {@link ListElement} with corresponding title and intent that can be
     * used to start the {@link DetectorActivity} with settings for MRTDDetector.
     * @return Built list element.
     */
    private ListElement buildMRTDDetectorElement() {
        // Decoding info is used to define the position in the detected location that is
        // interesting (it is expressed as rectangle relative to detected rectangle)
        // and the height of the dewarped image obtained from that position.
        DecodingInfo di = new DecodingInfo(new Rectangle(0.f, 0.f, 1.f, 1.f), 100, "MRZ");

        // Prepare machine readable travel document detector settings with defined
        // decoding info.
        MRTDDetectorSettings mrtds = new MRTDDetectorSettings(new DecodingInfo[] {di});
        return new ListElement(getString(R.string.mrtd_detector), buildDetectorIntent(mrtds));
    }

    /**
     * Builds the {@link ListElement} with given title and intent that can be
     * used to start the {@link DetectorActivity} with settings for DocumentDetector.
     * @param title Title that will be shown in list view.
     * @param documentSpec Specification for the document that should be detected (idCard, cheque...)
     * @return Built list element.
     */
    private ListElement buildDocumentDetectorElement(String title, DocumentSpecification documentSpec) {
        // prepare document detector settings with defined document specification
        DocumentDetectorSettings dds = new DocumentDetectorSettings(new DocumentSpecification[] {documentSpec});
        // set minimum number of stable detections to return detector result
        dds.setNumStableDetectionsThreshold(3);
        return new ListElement(title, buildDetectorIntent(dds));
    }


    /**
     * Element of {@link ArrayAdapter} for {@link ListView} that holds information about title
     * which should be displayed in list and {@link Intent} that should be started on click.
     */
    private class ListElement {
        private String mTitle;
        private Intent mScanIntent;

        public String getTitle() {
            return mTitle;
        }

        public Intent getScanIntent() {
            return mScanIntent;
        }

        public ListElement(String title, Intent scanIntent) {
            mTitle = title;
            mScanIntent = scanIntent;
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
