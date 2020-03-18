package com.microblink.result.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.microblink.entities.recognizers.HighResImagesBundle;
import com.microblink.image.Image;
import com.microblink.image.highres.HighResImageWrapper;
import com.microblink.libutils.R;

import java.io.File;
import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public abstract class BaseResultActivity extends AppCompatActivity {

    protected ViewPager mPager;
    private HighResImagesBundle highResImagesBundle;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setActivityContentView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        try {
            highResImagesBundle = new HighResImagesBundle(intent);
        } catch (Exception e) {
            // crash if high res frames aren't enabled
            highResImagesBundle = null;
        }

        if (highResImagesBundle != null && !highResImagesBundle.getImages().isEmpty()) {
            invalidateOptionsMenu();
        } else {
            toolbar.setVisibility(View.GONE);
        }

        mPager = findViewById(R.id.resultPager);
        mPager.setAdapter(createResultFragmentPagerAdapter(intent));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mPager);
        tabLayout.setClipChildren(false);

        findViewById(R.id.btnUseResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showHighResImagesDialog() {
        if (highResImagesBundle != null && !highResImagesBundle.getImages().isEmpty()) {
            LinearLayout imagesLayout = new LinearLayout(this);
            imagesLayout.setOrientation(LinearLayout.VERTICAL);

            ScrollView scrollView = new ScrollView(this);
            scrollView.addView(imagesLayout);

            for (HighResImageWrapper highResImageWrapper : highResImagesBundle.getImages()) {
                Image highResImage = highResImageWrapper.getImage();
                Bitmap highResBmp = highResImage.convertToBitmap();
                Matrix rotationMatrix = new Matrix();
                switch (highResImage.getImageOrientation()) {
                    case ORIENTATION_PORTRAIT:
                        rotationMatrix.postRotate(90);
                        break;
                    case ORIENTATION_LANDSCAPE_LEFT:
                        rotationMatrix.postRotate(180);
                        break;
                    case ORIENTATION_PORTRAIT_UPSIDE:
                        rotationMatrix.postRotate(270);
                }
                Bitmap rotatedBmp = Bitmap.createBitmap(
                        highResBmp, 0, 0, highResBmp.getWidth(), highResBmp.getHeight(), rotationMatrix, true);
                highResBmp.recycle();

                final float scale = getResources().getDisplayMetrics().density;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        (int) (400 * scale)
                );
                layoutParams.topMargin = (int) (20 * scale);

                ImageView imageView = new ImageView(this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(rotatedBmp);
                imagesLayout.addView(imageView);
            }

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setView(scrollView);
            dialogBuilder.setTitle(R.string.dialog_title_high_res_images);
            dialogBuilder.setPositiveButton(R.string.btn_close, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialogBuilder.create().show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (highResImagesBundle != null) {
            highResImagesBundle.clearSavedState();
        }
    }

    /**
     * Loads expected result data from given intent and creates appropriate fragment
     * pager adapter. This method is called from {@link BaseResultActivity#onCreate(Bundle)}
     * @param intent contains result data.
     * @return appropriate fragment pager adapter for the result data.
     */
    @NonNull
    protected abstract FragmentPagerAdapter createResultFragmentPagerAdapter(Intent intent);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (highResImagesBundle != null) {
            highResImagesBundle.saveState();
        }
    }

    protected void setActivityContentView() {
        setContentView(R.layout.result_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (highResImagesBundle == null || highResImagesBundle.getImages().isEmpty()) {
            return false;
        } else {
            getMenuInflater().inflate(R.menu.menu_save_high_res, menu);
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save_high_res) {
            saveHighResImages();
            return true;
        } else if (item.getItemId() == R.id.action_show_high_res) {
            showHighResImagesDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveHighResImages() {
        final String imagesFolderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "MbHighRes";
        File imagesDir = new File(imagesFolderPath);
        if (!imagesDir.exists()) {
            imagesDir.mkdirs();
        }

        for(HighResImageWrapper image : highResImagesBundle.getImages()) {
            String currentTime = String.valueOf(System.currentTimeMillis());
            String imagePath = imagesFolderPath + "/" + currentTime + ".jpeg";
            File file = new File(imagePath);
            try {
                image.saveToFile(file);
                MediaScannerConnection.scanFile(getApplicationContext(), new String[]{imagePath}, null, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Saved to MbHighRes folder", Toast.LENGTH_SHORT).show();
    }

}
