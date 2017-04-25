package com.itcherry.interpolators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

/**
 * Created by 1 on 24.04.2017.
 */

public class Loading2 extends View {
    private Animation animation;

    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private Circle circle4;
    private Circle circle5;
    private Circle circle6;
    private Circle circle7;
    private Circle circle8;
    private Circle circle9;
    private Circle circle10;

    private Circle[] circleItems = new Circle[10];
    private boolean isAnimationStarted = false;

    public Loading2(Context context, AttributeSet attrs) {
        super(context, attrs);

        Log.d("LOG_TAG", "Constructor Loading2");
        /*int angle = 90;
        for (int i = 0; i < 10; i++) {
            long newX = Math.round(150 * Math.cos(angle) + (getWidth() / 2));
            long newY = Math.round(150 * Math.sin(angle) + (getHeight() / 2));
            angle += Math.PI * 2 / 10;
            circleItems[i] = new Circle(getContext());
            circleItems[i].setBounds(new Rect((int) newX, (int) newY, (int) newX + 35, (int) newY + 35));
        }*/
        System.out.println(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("LOG_TAG", "On draw");
        int angle = 90;
        /*for (int i = 0; i < 10; i++) {
            long newX = Math.round(150 * Math.cos(angle) + (getWidth() / 2));
            long newY = Math.round(150 * Math.sin(angle) + (getHeight() / 2));
            angle += Math.PI * 2 / 10;
            circleItems[i] = new Circle(getContext());
            circleItems[i].setBounds(new Rect((int) newX, (int) newY, (int) newX + 35, (int) newY + 35));
            circleItems[i].draw(canvas);
        }*/
        for (Circle circle : circleItems) {
            long newX = Math.round(150 * Math.cos(angle) + (getWidth() / 2));
            long newY = Math.round(150 * Math.sin(angle) + (getHeight() / 2));
            angle += Math.PI * 2 / 10;
            circle = new Circle(getContext());
            circle.setBounds(new Rect((int) newX, (int) newY, (int) newX + 35, (int) newY + 35));
            circle.draw(canvas);
        }
        //setCirclesAnimations();
        //startAnimations();
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        Log.d("LOG_TAG", "On animation start");
    }

    /*private void startAnimationCircle() {
        ObjectAnimator animX = ObjectAnimator.ofInt(circle1, "scaleX", 0, 70);
        ObjectAnimator animY = ObjectAnimator.ofInt(circle1, "scaleY", 0, 70);
        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animX, animY);
        animSetXY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //iv1.invalidate();
                //circle1.invalidate();
                invalidate();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //animation.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animSetXY.start();
    }*/

    private void setCirclesAnimations() {
        Animation animation;
        int offset = 650;
        for (Circle circle : circleItems) {
            animation = AnimationUtils.loadAnimation(getContext(), R.anim.circle_scaler);
            animation.setStartOffset(offset);
            circle.setAnimation(animation);
            offset += 1000;
        }
        circleItems[9].getAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setCirclesAnimations();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onAnimationEnd() {
        animation.setInterpolator(new LinearInterpolator());
        this.startAnimation(animation);
    }

    private void startAnimations() {
        if (!isAnimationStarted) {
            animation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_view);
            animation.setInterpolator(new AccelerateInterpolator());
            this.startAnimation(animation);
            for (Circle circle : circleItems) {
                circle.startAnimation(circle.getAnimation());
            }
            isAnimationStarted = true;
        }
    }
}
