package com.microblink.util.templating;

import com.microblink.entities.ocrengine.legacy.BlinkOCREngineOptions;
import com.microblink.results.ocr.OcrFont;

abstract class CroatianIDRecognizerUtils {
    /**
     * This function will setup {@link BlinkOCREngineOptions} to allow recognition
     * only of uppercase latin letters used in Croatia.
     *
     * @param options {@link BlinkOCREngineOptions} object to be set up
     */
    static void addAllCroatianUppercaseCharsToWhitelist(BlinkOCREngineOptions options) {
        options.addUppercaseCharsToWhitelist(OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Š', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Đ', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Ž', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Č', OcrFont.OCR_FONT_ANY);
        options.addCharToWhitelist('Ć', OcrFont.OCR_FONT_ANY);
    }
}
