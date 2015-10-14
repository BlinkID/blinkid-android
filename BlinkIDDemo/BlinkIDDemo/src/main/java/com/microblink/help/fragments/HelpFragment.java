package com.microblink.help.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HelpFragment extends Fragment {
    private static final String KEY_MESSAGE_ID = "HelpFragment::MessageID";
    private static final String KEY_IMAGE_ID = "HelpFragment::ImageID";
    private static final String KEY_SWIPE_ID = "HelpFragment::SwipeID";

    public static HelpFragment newInstance(int messageId, int imageId, int swipeMsgId) {
        HelpFragment frag = new HelpFragment();
        frag.messageId_ = messageId;
        frag.swipeMsgId_ = swipeMsgId;
        frag.imageId_ = imageId;

        return frag;
    }

    private int messageId_ = 0;
    private int imageId_ = 0;
    private int swipeMsgId_ = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(KEY_MESSAGE_ID)) {
                messageId_ = savedInstanceState.getInt(KEY_MESSAGE_ID);
            }
            if (savedInstanceState.containsKey(KEY_IMAGE_ID)) {
                imageId_ = savedInstanceState.getInt(KEY_IMAGE_ID);
            }
            if (savedInstanceState.containsKey(KEY_SWIPE_ID)) {
                swipeMsgId_ = savedInstanceState.getInt(KEY_SWIPE_ID);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int help_view_page = getResources().getIdentifier("help_view_page", "layout", getActivity().getPackageName());
        int helpMessage = getResources().getIdentifier("helpMessage", "id", getActivity().getPackageName());
        int helpImage = getResources().getIdentifier("helpImage", "id", getActivity().getPackageName());
        View convertView = inflater.inflate(help_view_page, container, false);

        TextView messageView = ((TextView) convertView.findViewById(helpMessage));
        if (messageView != null) {
            if (messageId_ != 0) {
                messageView.setText(getString(messageId_));
            }
        }

        ImageView imageView = ((ImageView) convertView.findViewById(helpImage));
        if (imageView != null) {
            if (imageId_ != 0) {
                imageView.setImageDrawable(getResources().getDrawable(imageId_));
            }
        }

        return convertView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_IMAGE_ID, imageId_);
        outState.putInt(KEY_MESSAGE_ID, messageId_);
        outState.putInt(KEY_SWIPE_ID, swipeMsgId_);
    }
}
