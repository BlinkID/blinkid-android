package com.microblink.libresult;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.microblink.libresult.extract.RecognitionResultEntry;

import java.util.List;


/**
 * Created by igor on 12/9/14.
 */
public class ResultEntryAdapter extends ArrayAdapter<RecognitionResultEntry> {

    private Context mContext;

    public ResultEntryAdapter(Context context, int resource, List<RecognitionResultEntry> entries) {
        super(context, resource, entries);
        this.mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.result_entry, null);
        }

        final RecognitionResultEntry entry = getItem(position);
        TextView keyText = (TextView) convertView.findViewById(R.id.resultLabel);
        keyText.setText(entry.getKey());
        final EditText valueText = (EditText) convertView.findViewById(R.id.resultValue);
        valueText.setText(entry.getValue());
        return convertView;
    }
}
