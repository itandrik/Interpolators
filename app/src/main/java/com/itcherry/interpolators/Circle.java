package com.itcherry.interpolators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;

/**
 * Created by 1 on 24.04.2017.
 */

public class Circle extends View {

    private Drawable item = ResourcesCompat.getDrawable(getResources(), R.drawable.circle, null);
    private Rect bounds;

    public Circle(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        item.setBounds(bounds);
        item.draw(canvas);
    }

    public void setBounds(Rect bounds) {
        this.bounds = bounds;
        item.setBounds(bounds);
    }

    /*public void setScaleX(int scaleX) {
        this.scaleX = scaleX;
        bounds.set(bounds.left, bounds.top, bounds.right + scaleX, bounds.bottom);
        item.setBounds(bounds);
    }

    public void setScaleY(int scaleY) {
        this.scaleY = scaleY;
        bounds.set(bounds.left, bounds.top, bounds.right, bounds.bottom + scaleY);
        item.setBounds(bounds);
    }*/
}
