package com.microblink.result.extract.blinkid.documentface;

import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.libresult.R;
import com.microblink.result.extract.BaseResultExtractor;

public class DocumentFaceRecognitionResultExtractor extends BaseResultExtractor<DocumentFaceRecognizer.Result, DocumentFaceRecognizer> {

    @Override
    protected void extractData(DocumentFaceRecognizer.Result result) {
        add(R.string.MBDocumentLocation, result.getDocumentLocation().toString());
        add(R.string.MBFaceLocation, result.getFaceLocation().toString());
    }
}