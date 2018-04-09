package com.dxball.dxballpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.View.OnKeyListener;

public class MainActivity extends AppCompatActivity implements OnKeyListener {
    GameCanvas g = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        g = new GameCanvas(this);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        g.setFocusableInTouchMode(true);
        g.requestFocus();
        setContentView(g);
        //setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        switch(event.getAction())
        {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                g.keyLeft = true;
                Log.d("1.", "onKey: volume_pressed_down");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Log.d("2.", "onKey: volume_pressed_up");
                g.keyRight = true;
                break;
        }
        return false;
    }
}
