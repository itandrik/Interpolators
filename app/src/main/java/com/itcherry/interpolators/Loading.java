package com.itcherry.interpolators;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 1 on 23.04.2017.
 */

public class Loading extends View {
    private Drawable item1 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item2 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item3 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item4 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item5 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item6 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item7 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item8 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item9 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Drawable item10 = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);

    private List<Drawable> circleItems = Arrays.asList(
            item1, item2, item3, item4, item5,
            item6, item7, item8, item9, item10);
    ;
    private Animation animation;

    public Loading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
       /* iv1 = new ImageView(context);
        iv2 = new ImageView(context);
        iv3 = new ImageView(context);
        iv4 = new ImageView(context);
        iv5 = new ImageView(context);
        iv6 = new ImageView(context);
        iv7 = new ImageView(context);
        iv8 = new ImageView(context);
        iv9 = new ImageView(context);
        iv10 = new ImageView(context);*/

        /*iv1.setImageDrawable(item1);
        iv2.setImageDrawable(item2);
        iv3.setImageDrawable(item3);
        iv4.setImageDrawable(item4);
        iv5.setImageDrawable(item5);
        iv6.setImageDrawable(item6);
        iv7.setImageDrawable(item7);
        iv8.setImageDrawable(item8);
        iv9.setImageDrawable(item9);
        iv10.setImageDrawable(item10);*/

        animation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_view);
        animation.setInterpolator(new AccelerateInterpolator());
        this.startAnimation(animation);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        double angle = 90;
        for (Drawable item : circleItems) {
            long newX = Math.round(150 * Math.cos(angle) + (getWidth() / 2));
            long newY = Math.round(150 * Math.sin(angle) + (getHeight() / 2));
            angle += Math.PI * 2 / 10;
            item.setBounds((int) newX, (int) newY, (int) newX + 35, (int) newY + 35);
            /*ImageView iv = new ImageView(getContext());
            iv.setImageDrawable(item);*/
            item.mutate();
            //circleViews.get(i).setImageDrawable(circleItems.get(i));
            //circleViews.get(i).draw(canvas);
            item.draw(canvas);
        }
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (Drawable frame: circleItems) {
            animationDrawable.addFrame(frame, 1000);
        }
        animationDrawable.start();
        /*ObjectAnimator animX = ObjectAnimator.ofFloat(item1, "scaleX", 0.0f, 100f);
        ObjectAnimator animY = ObjectAnimator.ofFloat(item1, "scaleY", 0.0f, 100f);
        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animX, animY);
        animSetXY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //iv1.invalidate();
                invalidate();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animation.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animSetXY.start();*/
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        animation.setInterpolator(new LinearInterpolator());
        this.startAnimation(animation);
    }

    /*private Animator createIndeterminateAnimator() {
        AnimatorSet set = new AnimatorSet();
        Animator progressAnimator = getAnimator(SECONDARY_PROGRESS, new DecelerateInterpolator());
        Animator secondaryProgressAnimator = getAnimator(PROGRESS, new AccelerateInterpolator());
        set.playTogether(progressAnimator, secondaryProgressAnimator);
        set.setDuration(duration);
        return set;
    }*/

    @NonNull
    private ObjectAnimator getAnimator(Drawable target, String propertyName) {
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(target, propertyName, 0, 1000);
        progressAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        progressAnimator.setDuration(2000);
        progressAnimator.setStartDelay(2000);
        progressAnimator.setRepeatMode(ValueAnimator.RESTART);
        progressAnimator.setRepeatCount(ValueAnimator.INFINITE);
        return progressAnimator;
    }
}
