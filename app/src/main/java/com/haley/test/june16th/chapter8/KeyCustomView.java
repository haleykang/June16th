package com.haley.test.june16th.chapter8;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;

/**
 * Created by 202-18 on 2017-06-16.
 */

public class KeyCustomView extends Button {

    public KeyCustomView(Context context) {
        super(context);
    }

    public KeyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("**haley**", getText() + " onKeyDown() " +
                KeyEvent.keyCodeToString(event.getKeyCode()));
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d("**haley**", getText() + " onKeyUp() " +
                KeyEvent.keyCodeToString(event.getKeyCode()));
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d("**haley**", getText() + " dispatchKeyEvent() " +
                KeyEvent.keyCodeToString(event.getKeyCode()));
        return super.dispatchKeyEvent(event);
    }
}
