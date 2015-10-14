package com.microblink.help.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.microblink.help.fragments.HelpFragment;

public class BlinkOCRAdapter extends FragmentPagerAdapter {

    private int[] mHelpMessages = null;
    private int[] mHelpImages = null;
    private int mSwipeMsgId;

    public BlinkOCRAdapter(FragmentManager fm, Context context) {
        super(fm);
        // dynamically load resources, as they might not exist
        mHelpMessages = new int[3];
        mHelpImages = new int[3];
        String pkg = context.getPackageName();
        Resources res = context.getResources();
        mHelpMessages[0] = res.getIdentifier("help_msg_01", "string", pkg);
        mHelpMessages[1] = res.getIdentifier("help_msg_02", "string", pkg);
        mHelpMessages[2] = res.getIdentifier("help_msg_03", "string", pkg);

        mSwipeMsgId = res.getIdentifier("PhotoPaySwipeMessage", "string", pkg);

        mHelpImages[0] = res.getIdentifier("help01", "drawable", pkg);
        mHelpImages[1] = res.getIdentifier("help02", "drawable", pkg);
        mHelpImages[2] = res.getIdentifier("help03", "drawable", pkg);
    }

    @Override
    public Fragment getItem(int arg0) {
        int index = arg0 % getCount();
        return HelpFragment.newInstance(mHelpMessages[index], mHelpImages[index], index == 0 ? mSwipeMsgId : 0);
    }

    @Override
    public int getCount() {
        return 3;
    }

}
