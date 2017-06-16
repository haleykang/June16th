package com.haley.test.june16th.chapter8;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;

/**
 * Created by 202-18 on 2017-06-16.
 */

public class KeyCustomViewGroup extends LinearLayout {
    public KeyCustomViewGroup(Context context) {
        super(context);
    }

    public KeyCustomViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyCustomViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("**haley**", "ViewGroup onKeyDown() " +
                KeyEvent.keyCodeToString(event.getKeyCode()));
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i("**haley**", "ViewGroup onKeyUp() " +
                KeyEvent.keyCodeToString(event.getKeyCode()));
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("**haley**", "ViewGroup dispatchKeyEvent() " +
                KeyEvent.keyCodeToString(event.getKeyCode()));
        return super.dispatchKeyEvent(event);
    }
}
