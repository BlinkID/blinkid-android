package com.microblink.blinkid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ResultsActivity extends Activity {

    private static final String KEY_RESULT_TEXT = "resultText";
    private static final String KEY_SUCCESS_FRAME_IMAGE_PATH = "successFramePath";
    private static final String KEY_FULL_DOCUMENT_IMAGE_PATH = "fullDocumentPath";
    private static final String KEY_FACE_IMAGE_PATH = "facePath";

    public static Intent buildIntent(Context context,
                                     String resultText,
                                     String successFramePath,
                                     String fullDocumentImagePath,
                                     String faceImagePath) {
        Intent intent = new Intent(context, ResultsActivity.class);
        intent.putExtra(KEY_RESULT_TEXT, resultText);
        intent.putExtra(KEY_SUCCESS_FRAME_IMAGE_PATH, successFramePath);
        intent.putExtra(KEY_FULL_DOCUMENT_IMAGE_PATH, fullDocumentImagePath);
        intent.putExtra(KEY_FACE_IMAGE_PATH, faceImagePath);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView resultsTv = findViewById(R.id.results_tv);
        resultsTv.setText(getResultsFromExtras());

        ImageView successFrameImg = findViewById(R.id.success_frame_img);
        successFrameImg.setImageBitmap(getResultBitmapFromExtras(KEY_SUCCESS_FRAME_IMAGE_PATH));

        ImageView fullDocumentImg = findViewById(R.id.full_document_img);
        fullDocumentImg.setImageBitmap(getResultBitmapFromExtras(KEY_FULL_DOCUMENT_IMAGE_PATH));

        ImageView faceImg = findViewById(R.id.face_img);
        faceImg.setImageBitmap(getResultBitmapFromExtras(KEY_FACE_IMAGE_PATH));
    }

    private String getResultsFromExtras() {
        return getIntent().getStringExtra(KEY_RESULT_TEXT);
    }

    private Bitmap getResultBitmapFromExtras(String pathKey) {
        String imagePath = getIntent().getStringExtra(pathKey);
        if(imagePath == null) {
            return null;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap resultBitmap = BitmapFactory.decodeFile(imagePath, options);
        //noinspection ResultOfMethodCallIgnored
        new File(imagePath).delete();
        return resultBitmap;
    }

}
