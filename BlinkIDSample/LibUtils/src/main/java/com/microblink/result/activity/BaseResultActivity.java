package com.microblink.result.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.microblink.entities.recognizers.HighResImagesBundle;
import com.microblink.image.highres.HighResImageWrapper;
import com.microblink.libutils.R;

import java.io.File;
import java.io.IOException;

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

    public void footerButtonClickHandler(View view) {
        finish();
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
