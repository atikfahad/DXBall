package com.dxball.dxballpractise;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class GameCanvas extends View {
    Paint paint;
    float maxWidth, maxHeight;
    float x, y, dx = 1, dy = 1;
    boolean ifFirst = true;
    float radius = 20;
    boolean flag = true;
    boolean up = false, down = true, left = false, right = false;

    protected void onDraw(Canvas canvas){
        if (ifFirst){
            ifFirst = false;
            maxWidth = canvas.getWidth();
            maxHeight = canvas.getHeight();
            x = maxWidth / 2;
            y = maxHeight / 2;
        }

        canvas.drawRGB(255,255,255);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        if(y == maxHeight - radius){
            down = false;
            up = true;
        }
        if(down && y > 0) {
            canvas.drawCircle(x, y++, radius, paint);
        }
        else if(up && y <= maxHeight - radius) {
            canvas.drawCircle(x, y--, radius, paint);
            if(y == radius){
                up = false;
                down = true;
            }
        }
        else if(left && x > 0){
            canvas.drawCircle(x--, y,radius, paint);
        }
        else if(right && x <= maxWidth - radius){
            canvas.drawCircle(x++, y, radius, paint);
        }
        invalidate();

    }

    public GameCanvas(Context context) {
        super(context);
        paint = new Paint();
    }
}
