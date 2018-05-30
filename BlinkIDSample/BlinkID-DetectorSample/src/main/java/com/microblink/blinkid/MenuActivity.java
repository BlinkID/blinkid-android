package com.microblink.blinkid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.microblink.BaseMenuActivity;
import com.microblink.MenuListItem;
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

public class MenuActivity extends BaseMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check if BlinkID is supported on the device
        RecognizerCompatibilityStatus supportStatus = RecognizerCompatibility.getRecognizerCompatibilityStatus(this);
        if (supportStatus != RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED) {
            Toast.makeText(this, "BlinkID is not supported! Reason: " + supportStatus.name(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected List<MenuListItem> createMenuListItems() {
        List<MenuListItem> items = new ArrayList<>();

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
        items.add(buildMenuItem(R.string.id_detector, idCardDetector));
        items.add(buildMenuItem(R.string.cheque_detector, chequeDetector));
        items.add(buildMenuItem(R.string.a4_portrait_detector, a4PortraitDetector));
        items.add(buildMenuItem(R.string.a4_landscape_detector, a4LandscapeDetector));
        items.add(buildMenuItem(R.string.mrtd_detector, mrtdDetector));

        return items;
    }

    @Override
    protected String getTitleText() {
        return getString(R.string.app_name);
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

    private MenuListItem buildMenuItem(int title, QuadWithSizeDetector detector) {
        final Intent intent = new Intent(this, DetectorActivity.class);
        intent.putExtra(DetectorActivity.EXTRAS_DETECTOR, detector);
        return new MenuListItem(getString(title), new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        });
    }

}
