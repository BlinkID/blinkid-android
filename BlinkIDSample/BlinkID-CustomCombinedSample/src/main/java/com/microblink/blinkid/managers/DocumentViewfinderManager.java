package com.microblink.blinkid.managers;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.microblink.view.viewfinder.ViewfinderShapeView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * Document viewfinder manager that should be used for showing the splash screens over the viewfinder.
 */
public class DocumentViewfinderManager {

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private ViewfinderShapeView mCardViewfinder;
    private TextView mTvMessage;
    private ImageView mIvIcon;

    /**
     * Constructor which accepts viewfinder overlay views.
     * @param cardViewfinder viewfinder view.
     * @param tvMessage text view for displaying viewfinder text messages.
     * @param ivIcon icon view that is used for displaying document icon.
     */
    public DocumentViewfinderManager(@NonNull ViewfinderShapeView cardViewfinder, @NonNull TextView tvMessage, @NonNull ImageView ivIcon) {
        mCardViewfinder = cardViewfinder;
        mTvMessage = tvMessage;
        mIvIcon = ivIcon;
    }

    /**
     * Shows splash message over the viewfinder with given background.
     * @param message splash text message.
     * @param icon document icon.
     * @param backgroundColorResourceID resource ID of the splash message background color.
     */
    public void showSplashScreen(@NonNull final String message, @DrawableRes final int icon, @ColorRes final int backgroundColorResourceID) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIvIcon.setImageResource(icon);
                mTvMessage.setText(message);
                mTvMessage.setVisibility(View.VISIBLE);
                mIvIcon.setVisibility(View.VISIBLE);
                mCardViewfinder.setInnerColor(ContextCompat.getColor(mCardViewfinder.getContext(), backgroundColorResourceID));
                mCardViewfinder.setInnerAlpha(ViewfinderAnimationUtil.MAX_VIEWFINDER_ALPHA);
                mTvMessage.setAlpha(1f);
                mIvIcon.setAlpha(1f);
            }
        });
    }

    /**
     * Clears splash screen with alpha animation after the given delay and executes the given
     * {@link Runnable} when animation finishes.
     * @param delay delay in milliseconds before clear animation will be started.
     * @param animationDuration duration of the clear alpha animation in milliseconds.
     * @param animationEndRunnable runnable to be executed when animation finishes.
     */
    public void clearSplashScreen(long delay, final long animationDuration, final Runnable animationEndRunnable) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animator anim = ViewfinderAnimationUtil.createSplashAnimation(animationDuration, new Runnable() {
                    @Override
                    public void run() {
                        mCardViewfinder.setInnerAlpha(0);
                        mIvIcon.setVisibility(View.INVISIBLE);
                        mTvMessage.setVisibility(View.INVISIBLE);
                        if (animationEndRunnable != null) {
                            animationEndRunnable.run();
                        }
                    }
                }, mCardViewfinder, mTvMessage, mIvIcon);
                anim.start();
            }
        }, delay);
    }

}
