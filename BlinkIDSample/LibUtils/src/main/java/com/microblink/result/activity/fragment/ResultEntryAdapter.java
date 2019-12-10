package com.microblink.result.activity.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.microblink.libutils.R;
import com.microblink.result.extract.RecognitionResultEntry;

import java.util.List;

public class ResultEntryAdapter extends ArrayAdapter<RecognitionResultEntry> {

    private LayoutInflater mInflater;

    public ResultEntryAdapter(Context context, int resource, List<RecognitionResultEntry> entries) {
        super(context, resource, entries);
        mInflater = LayoutInflater.from(context);
    }

    class ImageTag {};

    private void setupTitle( View view, String title ) {
        TextView keyText = view.findViewById(R.id.resultLabel);
        keyText.setText(title);
    }

    private View setupImageEntry( View convertView, ViewGroup parent, RecognitionResultEntry entry ) {
        if ( convertView == null || convertView.getTag() == null ) {
            convertView = mInflater.inflate(R.layout.result_image_entry, parent, false);
            convertView.setTag(new ImageTag());
        }
        setupTitle(convertView, entry.getKey());
        ImageView iv = convertView.findViewById(R.id.resultValue);
        iv.setImageBitmap(entry.getImageValue());
        return convertView;
    }

    private View setupTextEntry( View convertView, ViewGroup parent, RecognitionResultEntry entry ) {
        if ( convertView == null || convertView.getTag() != null ) {
            convertView = mInflater.inflate(R.layout.result_entry, parent, false);
        }
        setupTitle(convertView, entry.getKey());
        TextView valueText = convertView.findViewById(R.id.resultValue);
        valueText.setText(entry.getValue());
        return convertView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final RecognitionResultEntry entry = getItem(position);

        if ( entry == null ) {
            return convertView;
        }

        if ( entry.getImageValue() != null ) {
            return setupImageEntry(convertView, parent, entry);
        } else {
            return setupTextEntry(convertView, parent, entry);
        }
    }
}
