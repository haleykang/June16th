package com.haley.test.june16th.chapter8;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.haley.test.june16th.R;


/**
 * Created by 202-18 on 2017-06-16.
 */

public class TestTouchClass extends Activity {

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

    Button mButton = null;

    /*  @Override
      public boolean onLongClick(View v) {

          switch(v.getId()) {
              case R.id.button_view: {
                  Toast.makeText(this, "onLongClick!", Toast.LENGTH_SHORT).show();
                  return true;
              }
          }
          return false;
      }
  */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_listener_layout);
        mButton = (Button)findViewById(R.id.bt_test);
    }

    public void onMyClick(View v) {
        switch(v.getId()) {
            case R.id.button_view: {
                ToggleButton toggleButton = (ToggleButton)v;

                // 버튼을 활성화 혹은 비활성화 상태로 변경
                mButton.setEnabled(toggleButton.isChecked());
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
