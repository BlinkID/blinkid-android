package com.microblink.menu;

import androidx.annotation.NonNull;

public class MenuListItem {

    private String mTitle;
    private Runnable mOnClickAction;

    @NonNull
    public String getTitle() {
        return mTitle;
    }

    @NonNull
    Runnable getOnClickAction() {
        return mOnClickAction;
    }

    public MenuListItem(@NonNull String title, @NonNull Runnable action) {
        mTitle = title;
        mOnClickAction = action;
    }

    /**
     * Used by array adapter to determine list element text
     */
    @Override
    public String toString() {
        return getTitle();
    }

}
