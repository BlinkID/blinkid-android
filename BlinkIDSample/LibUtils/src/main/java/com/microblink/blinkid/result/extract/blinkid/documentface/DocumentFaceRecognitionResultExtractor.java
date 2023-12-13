package com.microblink.blinkid.result.extract.blinkid.documentface;

import com.microblink.blinkid.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.blinkid.libutils.R;
import com.microblink.blinkid.result.extract.blinkid.BlinkIdExtractor;

public class DocumentFaceRecognitionResultExtractor extends BlinkIdExtractor<DocumentFaceRecognizer.Result, DocumentFaceRecognizer> {

    @Override
    protected void extractData(DocumentFaceRecognizer.Result result) {
        add(R.string.MBDocumentLocation, result.getDocumentLocation().toString());
        add(R.string.MBFaceLocation, result.getFaceLocation().toString());
    }
}