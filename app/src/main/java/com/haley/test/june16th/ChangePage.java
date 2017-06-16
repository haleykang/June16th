package com.haley.test.june16th;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.haley.test.june16th.chapter8.CustomMainActivity;
import com.haley.test.june16th.chapter8.MainTestKeyEvent;
import com.haley.test.june16th.chapter8.TestTouchClass;

public class ChangePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_page);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tv_toMainActivity:
                changeActivity(MainActivity.class);
                break;
            case R.id.tv_toTestEvent:
                changeActivity(CustomMainActivity.class);
                break;
            case R.id.tv_toTestTouchListner:
                changeActivity(TestTouchClass.class);
                break;
            case R.id.tv_toTestKeyEvent:
                changeActivity(MainTestKeyEvent.class);
                break;
        }
    }

    // changeActivity
    public void changeActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}


