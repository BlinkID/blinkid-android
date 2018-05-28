package com.microblink.result.extract.blinkinput;

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
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.ArrayList;
import java.util.List;

public class TemplateDataExtractor {

    private RecognitionResultEntry.Builder mBuilder;
    private List<RecognitionResultEntry> mExtractedData;

    public List<RecognitionResultEntry> extract(Context context, TemplatingRecognizer<?, ?> templatingRecognizer) {
        mExtractedData = new ArrayList<>();
        mBuilder = new RecognitionResultEntry.Builder(context);
        // add class (if found)
        TemplatingClass templatingClass = templatingRecognizer.getResult().getTemplatingClass();
        if (templatingClass == null) {
            return mExtractedData;
        }

        mExtractedData.add(mBuilder.build(R.string.PPDocumentClassification, templatingClass.toString()));
        // add all processor results
        ProcessorGroup[] pgs = templatingClass.getClassificationProcessorGroups();
        if (pgs != null) {
            for (ProcessorGroup p : pgs) {
                addProcessorResults(p);
            }
        }
        pgs = templatingClass.getNonClassificationProcessorGroups();
        if (pgs != null) {
            for (ProcessorGroup p : pgs) {
                addProcessorResults(p);
            }
        }
        return mExtractedData;
    }

    private void addProcessorResults(ProcessorGroup processorGroup) {
        for (Processor p : processorGroup.getProcessors()) {
            if (p instanceof ParserGroupProcessor) {
                addParserResults((ParserGroupProcessor) p);
            } else if (p instanceof ImageReturnProcessor) {
                Image img = ((ImageReturnProcessor) p).getResult().getRawImage();
                mExtractedData.add(new RecognitionResultEntry("ImageReturnProcessor", img != null ? img.convertToBitmap() : null));
                byte[] encodedImg = ((ImageReturnProcessor) p).getResult().getEncodedImage();
                String value = null;
                if (encodedImg != null) {
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
