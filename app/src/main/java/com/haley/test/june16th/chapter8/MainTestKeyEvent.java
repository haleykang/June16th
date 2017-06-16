package com.haley.test.june16th.chapter8;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.haley.test.june16th.R;


public class MainTestKeyEvent extends Activity implements View.OnKeyListener {

    private long mExitModeTime = 0L;

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if(event.getAction() == KeyEvent.ACTION_DOWN &&
                keyCode == KeyEvent.KEYCODE_BACK &&
                event.isLongPress() == true) {

            Toast.makeText(this, "이전키가 길게 눌러짐.", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        // 뒤로 가기 버튼 눌렀을 때!
        if(mExitModeTime != 0 && SystemClock.uptimeMillis() - mExitModeTime < 3000) {
            // 이전키를 누르면 먼저 토스트 팝업으로 이전키가 눌러진걸 알림
            // 만일 사용자가 3초 이내에 다시 이전키를 누르면 종료 의도로 판단하고 종료
            finish();
        } else {
            Toast.makeText(this, "이전키를 한 번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show();
            mExitModeTime = SystemClock.uptimeMillis();
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test_key_event);
        KeyCustomView view1 = (KeyCustomView)findViewById(R.id.view1);
        view1.setOnKeyListener(this);
    }

    // 키 다운 이벤트 발생 시 호출

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.v("**haley**", "Activity onKeyDown() >> " + KeyEvent.keyCodeToString(keyCode));
        return super.onKeyDown(keyCode, event);
    }

    // 키 업 이벤트

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i("**haley**", "Activity onKeyUp() >> " + KeyEvent.keyCodeToString(keyCode));
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d("**haley**", "Activity dispatchKeyEvent() >> "
                + KeyEvent.keyCodeToString(event.getKeyCode()));
        return super.dispatchKeyEvent(event);
    }
}
