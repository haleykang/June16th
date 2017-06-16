package com.haley.test.june16th.chapter8;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.haley.test.june16th.R;

/**
 * Created by 202-18 on 2017-06-16.
 */

public class TestTouchClass extends Activity implements View.OnLongClickListener {

   /* @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("**haley**", "Button View onTouch() >> " + event.getAction());
        return false;
    }*/

   /* @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_view:
                Toast.makeText(this, "Onclick!", Toast.LENGTH_SHORT).show();
                break;
        }
    }*/

    @Override
    public boolean onLongClick(View v) {

        switch(v.getId()) {
            case R.id.button_view: {
                Toast.makeText(this, "onLongClick!", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_listener_layout);

        Button button = (Button)findViewById(R.id.button_view);
        // button.setOnTouchListener(new MyTouchListener());
        button.setOnLongClickListener(this);
    }

    public void onMyClick(View v) {
        switch(v.getId()) {
            case R.id.button_view: {
                Toast.makeText(this, "onClick!", Toast.LENGTH_SHORT).show();
                break;
            }

        }
    }
/*
    // 내부 클래스 구현
    class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Log.d("**haley**", "Button View onTouch() >> " + event.getAction());

            // 이벤트를 소비하지 않도록 함
            return false;

        }
    }*/
}
