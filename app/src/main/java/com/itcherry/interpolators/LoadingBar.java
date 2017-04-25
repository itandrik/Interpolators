package com.itcherry.interpolators;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import static android.R.attr.x;
import static android.R.attr.y;

/**
 * Created by 1 on 22.04.2017.
 */

public class LoadingBar extends View {
    public static final int COUNT_OF_NODES_IN_REGIONAL_NETWORK = 10;
    public static final int RADIUS_CIRCLE_REGIONAL_NETWORK = 100;
    public static final int ANGLE_CIRCLE_REGIONAL_NETWORK = 90;

    public LoadingBar(Context context) {
        super(context);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        double angle = ANGLE_CIRCLE_REGIONAL_NETWORK;
        for (int i = 0; i < COUNT_OF_NODES_IN_REGIONAL_NETWORK; i++) {
            long newX = Math.round(RADIUS_CIRCLE_REGIONAL_NETWORK *
                    Math.cos(angle) + x);
            long newY = Math.round(RADIUS_CIRCLE_REGIONAL_NETWORK *
                    Math.sin(angle) + y);

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
            canvas.drawBitmap(bitmap, newX, newY, null);

            angle += Math.PI * 2 / COUNT_OF_NODES_IN_REGIONAL_NETWORK;
        }
    }
}
