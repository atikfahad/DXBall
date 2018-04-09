package com.dxball.dxballpractise;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;


public class GameCanvas extends View implements KeyEvent.Callback {
    Paint paint;
    float maxWidth, maxHeight;
    float x, y, dx = 1, dy = 1;
    boolean ifFirst = true;
    float radius = 20;
    boolean flag = true;
    boolean up = false, down = true, left = false, right = false;
    boolean keyLeft = false, keyRight = false;

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
        if(keyRight){
            keyRight = false;
            right = true;
            left = up = down = false;
        }
        if(keyLeft){
            keyLeft = false;
            left = true;
            right = up = down = false;
        }
        if(y >= maxHeight - radius){
            down = false;
            up = true;
        }
        if(down && y > 0) {
            canvas.drawCircle(x, y+=3, radius, paint);
        }
        else if(up && y <= maxHeight - radius) {
            canvas.drawCircle(x, y-=3, radius, paint);
            if(y <= radius){
                up = false;
                down = true;
            }
        }
        else if(left){
            canvas.drawCircle(x-=3, y,radius, paint);
            if(x <= radius){
                left = false;
                right = true;
            }
        }
        else if(right){
            canvas.drawCircle(x+=3, y, radius, paint);
            if(x >= maxWidth - radius){
                right = false;
                left = true;
            }
        }
        invalidate();

    }

    public GameCanvas(Context context) {
        super(context);
        paint = new Paint();
    }

//    @Override
//    public boolean onKey(View view, int keyCode, KeyEvent event) {
//        switch(event.getAction())
//        {
//            case KeyEvent.KEYCODE_VOLUME_DOWN:
//                this.keyLeft = true;
//                Log.d("1.", "onKey: volume_pressed_down");
//                break;
//            case KeyEvent.KEYCODE_VOLUME_UP:
//                Log.d("2.", "onKey: volume_pressed_up");
//                this.keyRight = true;
//                break;
//        }
//        return false;
//    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)){
            this.keyLeft = true;
            Log.d("1.", "onKey: volume_pressed_down");
        }
        else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)){
            this.keyRight = true;
            Log.d("1.", "onKey: volume_pressed_up");
        }
        return true;
    }
}
