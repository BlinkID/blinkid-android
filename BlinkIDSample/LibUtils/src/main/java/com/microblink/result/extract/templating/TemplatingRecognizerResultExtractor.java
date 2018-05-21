package com.microblink.result.extract.templating;

import android.content.Context;

import com.microblink.entities.parsers.Parser;
import com.microblink.entities.processors.Processor;
import com.microblink.entities.processors.imageReturn.ImageReturnProcessor;
import com.microblink.entities.processors.parserGroup.ParserGroupProcessor;
import com.microblink.entities.recognizers.templating.ProcessorGroup;
import com.microblink.entities.recognizers.templating.TemplatingClass;
import com.microblink.entities.recognizers.templating.TemplatingRecognizer;
import com.microblink.image.Image;
import com.microblink.libresult.R;
import com.microblink.result.extract.IBaseRecognitionResultExtractor;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo on 21/02/2018.
 */

public abstract class TemplatingRecognizerResultExtractor implements IBaseRecognitionResultExtractor {

    protected List<RecognitionResultEntry> mExtractedData;

    protected RecognitionResultEntry.Builder mBuilder;

    protected TemplatingRecognizerResultExtractor(Context context) {
        mBuilder = new RecognitionResultEntry.Builder(context);
        mExtractedData = new ArrayList<>();
    }

    protected void extractTemplateData(TemplatingRecognizer<?,?> templatingRecognizer) {
        // add class (if found)
        TemplatingClass cls = templatingRecognizer.getResult().getTemplatingClass();
        if ( cls != null ) {
            mExtractedData.add(mBuilder.build(R.string.PPDocumentClassification, cls.toString()));
            // add all processor results
            ProcessorGroup[] pgs = cls.getClassificationProcessorGroups();
            if ( pgs != null ) {
                for (ProcessorGroup p : pgs ) {
                    addProcessorResults(p);
                }
            }
            pgs = cls.getNonClassificationProcessorGroups();
            if ( pgs != null ) {
                for (ProcessorGroup p : pgs ) {
                    addProcessorResults(p);
                }
            }
        }
    }

    private void addProcessorResults(ProcessorGroup processorGroup) {
        for (Processor p : processorGroup.getProcessors()) {
            if ( p instanceof ParserGroupProcessor) {
                addParserResults((ParserGroupProcessor)p);
            } else if (p instanceof ImageReturnProcessor) {
                Image img = ((ImageReturnProcessor)p).getResult().getRawImage();
                mExtractedData.add(new RecognitionResultEntry("ImageReturnProcessor", img != null ? img.convertToBitmap() : null));
                byte[] encodedImg = ((ImageReturnProcessor)p).getResult().getEncodedImage();
                String value = null;
                if ( encodedImg != null ) {
                    int len = encodedImg.length;
                    value = Integer.toString(len) + " bytes";
                    if (len > 1024) {
                        value += " (" + Double.toString(len / 1024.0) + " kiB)";
                    }
                }
                mExtractedData.add(new RecognitionResultEntry("ImageReturnProcessor-encoded", value));
            }
        }
    }

    private void addParserResults(ParserGroupProcessor parserGroupProcessor) {
        for (Parser parser : parserGroupProcessor.getParsers()) {
            mExtractedData.add(new RecognitionResultEntry(parser.getClass().getSimpleName(), parser.getResult().toString()));
        }
    }
}
