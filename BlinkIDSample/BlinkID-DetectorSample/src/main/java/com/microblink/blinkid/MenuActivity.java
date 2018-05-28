package com.microblink.blinkid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.microblink.entities.detectors.quad.QuadWithSizeDetector;
import com.microblink.entities.detectors.quad.document.DocumentDetector;
import com.microblink.entities.detectors.quad.document.DocumentSpecification;
import com.microblink.entities.detectors.quad.document.DocumentSpecificationPreset;
import com.microblink.entities.detectors.quad.mrtd.MRTDDetector;
import com.microblink.entities.detectors.quad.mrtd.MRTDSpecification;
import com.microblink.entities.detectors.quad.mrtd.MRTDSpecificationPreset;
import com.microblink.util.RecognizerCompatibility;
import com.microblink.util.RecognizerCompatibilityStatus;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }

        setupMenuListView();
    }

    private void setupMenuListView() {
        final List<MenuItem> menuItems = buildMenuListElements();
        ArrayAdapter<MenuItem> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);
        ListView listView = findViewById(R.id.detectorList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(menuItems.get(position).mScanIntent);
            }
        });
    }

    private List<MenuItem> buildMenuListElements() {
        // build id card detector from preset
        DocumentDetector idCardDetector =
                buildDocumentDetectorFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_ID1_CARD);

        // build cheque detector from preset
        DocumentDetector chequeDetector =
                buildDocumentDetectorFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_CHEQUE);

        // build A4 portrait detector from preset
        DocumentDetector a4PortraitDetector =
                buildDocumentDetectorFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_A4_PORTRAIT);

        // build A4 landscape detector from preset
        DocumentDetector a4LandscapeDetector =
                buildDocumentDetectorFromPreset(DocumentSpecificationPreset.DOCUMENT_SPECIFICATION_PRESET_A4_PORTRAIT);

        // build T1 machine readable travel document detector from preset
        MRTDDetector mrtdDetector = new MRTDDetector();
        mrtdDetector.setSpecifications(MRTDSpecification.createFromPreset(MRTDSpecificationPreset.MRTD_SPECIFICATION_TD1));

        //create menu item for each detector
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(buildMenuItem(R.string.id_detector, idCardDetector));
        items.add(buildMenuItem(R.string.cheque_detector, chequeDetector));
        items.add(buildMenuItem(R.string.a4_portrait_detector, a4PortraitDetector));
        items.add(buildMenuItem(R.string.a4_landscape_detector, a4LandscapeDetector));
        items.add(buildMenuItem(R.string.mrtd_detector, mrtdDetector));
        return items;
    }

    private DocumentDetector buildDocumentDetectorFromPreset(DocumentSpecificationPreset documentSpecPreset) {
        // create document specification from preset
        DocumentSpecification documentSpec = DocumentSpecification.createFromPreset(documentSpecPreset);
        // prepare document detector with defined document specification
        DocumentDetector documentDetector = new DocumentDetector(documentSpec);
        // set minimum number of stable detections to return detector result
        documentDetector.setNumStableDetectionsThreshold(3);
        return documentDetector;
    }

    private MenuItem buildMenuItem(int title, QuadWithSizeDetector detector) {
        Intent intent = new Intent(this, DetectorActivity.class);
        intent.putExtra(DetectorActivity.EXTRAS_DETECTOR, detector);
        return new MenuItem(getString(title), intent);
    }

    private static class MenuItem {
        private final String mTitle;
        final Intent mScanIntent;

        MenuItem(String title, Intent scanIntent) {
            mTitle = title;
            mScanIntent = scanIntent;
        }

        @Override
        public String toString() {
            return mTitle;
        }
    }

}
