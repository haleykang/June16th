package com.haley.test.june16th.chapter8;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by 202-18 on 2017-06-16.
 */

public class CustomViewGroup extends FrameLayout {

    float mMoveYDistance = 0;

    public CustomViewGroup(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.i("**haley**", "CustomViewGroup dispatchTouchEvent() >> " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("**haley**", "CustomViewGroup onTouchEvent() >> " + event.getAction());
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("**haley**", "CustomViewGroup onInterceptTouchEvent() >> " + ev.getAction());

        switch(ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                // 터치 다운 위치의 y 위치 기억
                mMoveYDistance = ev.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if(Math.abs(mMoveYDistance - ev.getY()) >= 20) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
}
