package com.microblink.blinkid.imagescan;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.microblink.blinkid.demo.R;
import com.microblink.directApi.DirectApiErrorListener;
import com.microblink.directApi.RecognizerRunner;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.recognition.FirstSideRecognitionCallback;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.view.recognition.ScanResultListener;

import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;

public class CombinedScanImageActivity extends Activity {

    private static final String ASSETS_BITMAP_NAME_FRONT_SIDE = "cro_ID_front1.jpg";
    private static final String ASSETS_BITMAP_NAME_BACK_SIDE = "cro_ID_back1.jpg";

    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;

    private static final String TAG = "CombinedScanImage";

    /** Scan action button */
    private Button mScanButton;

    /** Front side bitmap for recognition. */
    private Bitmap mFrontBitmap;
    /** Back side bitmap for recognition. */
    private Bitmap mBackBitmap;

    /** Progress dialog shown while recognition is in progress */
    private ProgressDialog mProgress;

    /** Recognizer for scanning front and back side of a document */
    private BlinkIdCombinedRecognizer mBlinkIdCombinedRecognizer = new BlinkIdCombinedRecognizer();

    /** RecognizerRunner that will run recognizers on given image */
    private RecognizerRunner mRecognizerRunner;

    /** Flag which indicates whether first side of a document has been successfully scanned or not */
    private boolean mFirstSideScanned = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_image_combined);

        mScanButton = findViewById(R.id.btnScan);
        mFrontBitmap = readImageFromAssets(ASSETS_BITMAP_NAME_FRONT_SIDE);
        mBackBitmap = readImageFromAssets(ASSETS_BITMAP_NAME_BACK_SIDE);

        ImageView ivImageFront = findViewById(R.id.ivImageFront);
        ivImageFront.setImageBitmap(mFrontBitmap);
        ImageView ivImageBack = findViewById(R.id.ivImageBack);
        ivImageBack.setImageBitmap(mBackBitmap);

    }

    private Bitmap readImageFromAssets(String assetName) {
        // initial bitmap is loaded from assets
        AssetManager assets = getAssets();
        InputStream istr = null;
        try {
            istr = assets.open(assetName);
            // load initial bitmap from assets
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = BITMAP_CONFIG;
            return BitmapFactory.decodeStream(istr, null, options);
        } catch (IOException e) {
            // handle exception
            Log.e(TAG, "Failed to load image from assets!");
            Toast.makeText(this, "Failed to load image from assets!", Toast.LENGTH_LONG).show();
            finish();
            return null;
        } finally {
            if (istr != null) {
                try {
                    istr.close();
                } catch (IOException ignorable) {
                    // do nothing
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        // get the recognizer runner instance
        mRecognizerRunner = RecognizerRunner.getSingletonInstance();

        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        // set first side recognition callback to be notified when front side is successfully scanned
        metadataCallbacks.setFirstSideRecognitionCallback(mFirstSideRecognitionCallback);
        mRecognizerRunner.setMetadataCallbacks(metadataCallbacks);

        // initialize recognizer runner singleton
        mRecognizerRunner.initialize(this, new RecognizerBundle(mBlinkIdCombinedRecognizer), new DirectApiErrorListener() {
            @Override
            public void onRecognizerError(@NonNull Throwable t) {
                Log.e(TAG, "Failed to initialize recognizer.", t);
                Toast.makeText(CombinedScanImageActivity.this, "Failed to initialize recognizer. Reason: "
                        + t.getMessage(), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    /**
     * Handler for button "Scan"
     */
    public void scanButtonHandler(View view) {
        if (mFrontBitmap == null || mBackBitmap == null) {
            return;
        }

        // disable button
        mScanButton.setEnabled(false);
        // show progress dialog
        mProgress = new ProgressDialog(this);
        mProgress.setIndeterminate(true);
        mProgress.setMessage("Performing recognition");
        mProgress.setCancelable(false);
        mProgress.show();

        // reset recognition state to clear all previous results
        mRecognizerRunner.resetRecognitionState();
        // send front side image to recognition
        mRecognizerRunner.recognizeBitmap(
                mFrontBitmap,
                Orientation.ORIENTATION_LANDSCAPE_RIGHT,
                mScanResultListenerFrontSide
        );
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mRecognizerRunner != null) {
            // terminate the native library
            mRecognizerRunner.terminate();
        }
    }

    FirstSideRecognitionCallback mFirstSideRecognitionCallback = new FirstSideRecognitionCallback() {
        @Override
        public void onFirstSideRecognitionFinished() {
            mFirstSideScanned = true;
        }
    };

    private ScanResultListener mScanResultListenerFrontSide =  new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            if (mFirstSideScanned) {
                // send back side image to recognition
                mRecognizerRunner.recognizeBitmap(
                        mBackBitmap,
                        Orientation.ORIENTATION_LANDSCAPE_RIGHT,
                        mScanResultListenerBackSide
                );
            } else {
                prepareForNextCombinedRecognition();
                showFailureMessage();
            }
        }

        @Override
        public void onUnrecoverableError(@NonNull Throwable throwable) {
            Toast.makeText(CombinedScanImageActivity.this, throwable.toString(), Toast.LENGTH_LONG).show();
        }
    };

    private ScanResultListener mScanResultListenerBackSide =  new ScanResultListener() {
        @Override
        public void onScanningDone(@NonNull RecognitionSuccessType recognitionSuccessType) {
            prepareForNextCombinedRecognition();
            if (recognitionSuccessType != RecognitionSuccessType.UNSUCCESSFUL) {
                showResultsDialog(mBlinkIdCombinedRecognizer.getResult());
            } else {
                showFailureMessage();
            }
        }

        @Override
        public void onUnrecoverableError(@NonNull Throwable throwable) {
            Toast.makeText(CombinedScanImageActivity.this, throwable.toString(), Toast.LENGTH_LONG).show();
        }
    };

    private void showResultsDialog(BlinkIdCombinedRecognizer.Result result) {
        StringBuilder sbResults = new StringBuilder();
        String newline = String.format("%n");
        sbResults.append("First name: ").append(result.getFirstName()).append(newline);
        sbResults.append("Last name: ").append(result.getLastName()).append(newline);
        sbResults.append("Personal number: ").append(result.getPersonalIdNumber()).append(newline);
        // ... there are also other result fields to extract

        new AlertDialog.Builder(this)
                .setTitle("Scan results")
                .setMessage(sbResults.toString())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .create()
                .show();
    }

    private void showFailureMessage() {
        Toast.makeText(CombinedScanImageActivity.this, "Nothing scanned!", Toast.LENGTH_SHORT).show();
    }

    private void prepareForNextCombinedRecognition() {
        mFirstSideScanned = false;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mScanButton.setEnabled(true);
                mProgress.dismiss();
            }
        });
    }

}
