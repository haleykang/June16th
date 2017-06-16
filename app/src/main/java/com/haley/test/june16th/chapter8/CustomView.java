package com.haley.test.june16th.chapter8;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 202-18 on 2017-06-16.
 */

public class CustomView extends View {
    public boolean mNeedFirstTouchProcessEvent = true;

    public CustomView(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("**haley**", "CustomView dispatchTouchEvent() >> " + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("**haley**", "CustomView onTouchEvent() >> " + event.getAction());

        // 1. 뷰에 전달되는 첫 번째 터치 이벤트 프로세스틑 부모 뷰 그룹이 가로채지 않도록 설정
        if(mNeedFirstTouchProcessEvent == true && event.getAction() == MotionEvent.ACTION_DOWN) {
            getParent().requestDisallowInterceptTouchEvent(true);
            mNeedFirstTouchProcessEvent = false;
        }
        return true;
    }
}
