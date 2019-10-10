package com.microblink.blinkid.managers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import com.microblink.view.viewfinder.ViewfinderShapeView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class ViewfinderAnimationUtil {

    public static final float MAX_VIEWFINDER_ALPHA = 0.67f;

    public static AnimatorSet createSplashAnimation(long animationDuration, @NonNull final Runnable animationEndRunnable, ViewfinderShapeView viewfinderTarget, View... viewTargets) {
        List<Animator> animators = new ArrayList<>();

        ObjectAnimator viewfinderAnimator = ObjectAnimator.ofFloat(viewfinderTarget, "innerAlpha", MAX_VIEWFINDER_ALPHA, 0);
        viewfinderAnimator.setDuration(animationDuration);
        animators.add(viewfinderAnimator);

        for (View v : viewTargets) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(v, "alpha", 1, 0);
            animator.setDuration(animationDuration);
            animators.add(animator);
        }

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animators);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (animationEndRunnable != null) {
                    animationEndRunnable.run();
                }
            }
        });
        return animatorSet;
    }
}
