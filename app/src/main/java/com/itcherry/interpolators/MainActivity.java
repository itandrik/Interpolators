package com.itcherry.interpolators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Animation animAccelerate;
    Animation animDecelerate;
    Animation animAccelerateDecelerate;
    Animation animAnticipate;
    Animation animAnticipateOvershoot;
    Animation animOvershoot;
    Animation animBounce;
    Animation animCycle;
    Animation animLinear;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animAccelerate = AnimationUtils.loadAnimation(this, R.anim.accelerate);

        animDecelerate = AnimationUtils.loadAnimation(this, R.anim.decelerate);

        animAccelerateDecelerate = AnimationUtils.loadAnimation(this,
                R.anim.accelerate_decelerate);

        animAnticipate = AnimationUtils.loadAnimation(this, R.anim.anticipate);

        animAnticipateOvershoot = AnimationUtils.loadAnimation(this,
                R.anim.anticipate_overshoot);

        animOvershoot = AnimationUtils.loadAnimation(this, R.anim.overshoot);

        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);

        animCycle = AnimationUtils.loadAnimation(this, R.anim.cycle);

        animLinear = AnimationUtils.loadAnimation(this, R.anim.linear);

        image = (ImageView) findViewById(R.id.image);

        /*LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.loading_drawable);
        Drawable item = layerDrawable
                .findDrawableByLayerId(R.id.loadingCircle1);
        if (item.getAlpha() == 0) {
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(item, PropertyValuesHolder.ofInt("alpha", 255));
            animator.setTarget(item);
            animator.setDuration(2000);
            animator.start();
        } else {
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(item, PropertyValuesHolder.ofInt("alpha", 0));
            animator.setTarget(item);
            animator.setDuration(2000);
            animator.start();
        }*/
    }

    /*public void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.accelerate:
                image.startAnimation(animAccelerate);
                break;
            case R.id.decelerate:
                image.startAnimation(animDecelerate);
                break;
            case R.id.acceleratedecelerate:
                image.startAnimation(animAccelerateDecelerate);
                break;
            case R.id.anticipate:
                image.startAnimation(animAnticipate);
                break;
            case R.id.anticipateovershoot:
                image.startAnimation(animAnticipateOvershoot);
                break;
            case R.id.overshoot:
                image.startAnimation(animOvershoot);
                break;
            case R.id.bounce:
                // image.startAnimation(animBounce);
                TranslateAnimation tAnim = new TranslateAnimation(0, 0, -700, 10);
                tAnim.setInterpolator(new BounceInterpolator());
                tAnim.setDuration(1000);

                image.startAnimation(tAnim);
                break;
            case R.id.cycle:
                image.startAnimation(animCycle);
                break;
            case R.id.linear:
                image.startAnimation(animLinear);
                break;
        }
    }*/
}
