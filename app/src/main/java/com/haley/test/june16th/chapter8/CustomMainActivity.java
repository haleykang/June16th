package com.haley.test.june16th.chapter8;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by 202-18 on 2017-06-16.
 */

public class CustomMainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. 뷰 그룹 생성
        CustomViewGroup viewGroup = new CustomViewGroup(this);
        viewGroup.setBackgroundColor(Color.BLUE);
        FrameLayout.LayoutParams viewGroupLp = new FrameLayout.LayoutParams(600, 600);

        // 2. 뷰 생성
        CustomView view = new CustomView(this);
        view.setBackgroundColor(Color.YELLOW);
        FrameLayout.LayoutParams viewLp = new FrameLayout.LayoutParams(300, 300);

        // 3. 생성된 뷰를 뷰 그룹에 추가
        viewGroup.addView(view, viewLp);

        // 4. 콘텐트 영역에 생성된 뷰그룹 추가
        setContentView(viewGroup, viewGroupLp);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("**haley**", "CustomMainActivity dispatchTouchEvent() >> " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("**haley**", "CustomMainActivity onTouchEvent() >> " + event.getAction());
        return super.onTouchEvent(event);
    }
}
