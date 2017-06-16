package com.haley.test.june16th;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.widget.TabHost;

public class MainActivity extends Activity {

    String TAG = "**MainActivity**";
    Context mContext;
    TabHost mTabHost01;

    TabHost.TabSpec mFirstTab;
    TabHost.TabSpec mSecondTab;
    TabHost.TabSpec mThirdTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLog("onCreate() 시작");

        this.mTabHost01 = (TabHost)this.findViewById(R.id.tab_host01);
        mTabHost01.setup();
        mContext = this;

        // 탭이 변할 떄 마다 실행되는 명령문 작성
        mTabHost01.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                myLog("onTabChanged() tabId : " + tabId);

                int currentTab = mTabHost01.getCurrentTab(); // 현재 보여지고 있는 탭 스펙의 위치 번호

                switch(currentTab) {
                    case 0:
                        myLog("First Tab");
                        break;
                    case 1:
                        myLog("Second Tab");
                        break;
                    case 2:
                        myLog("Third Tab");
                        break;
                }
            }
        });

        // 첫 번째 탭
        mFirstTab = mTabHost01.newTabSpec("tabId01");
        //tabId01 : 텝스펙의 아이디 -> getTag() 함수로 읽어올 수 있음
        mFirstTab.setContent(R.id.tab_content01);
        // 탭에 출력할 내용 정하기(타이틀)
        mFirstTab.setIndicator("TAB01");
        mTabHost01.addTab(mFirstTab);
        myLog("======================================");
        myLog("텝 호스트에 첫 번째 텝 생성");

        // 두 번째 탭
        mSecondTab = mTabHost01.newTabSpec("tabId02");
        mSecondTab.setContent(R.id.tab_content02);
        Drawable drawable01 = ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_launcher, null);
        mSecondTab.setIndicator("TAB02", drawable01);
        mTabHost01.addTab(mSecondTab);
        myLog("======================================");
        myLog("텝 호스트에 두 번째 텝 생성");

        // 세 번쨰 텝
        mThirdTab = mTabHost01.newTabSpec("tabId03");
        mThirdTab.setContent(R.id.tab_content03);
        mThirdTab.setIndicator("TAB03");
        mTabHost01.addTab(mThirdTab);
        myLog("======================================");
        myLog("텝 호스트에 세 번째 텝 생성");

        // 화면에 2번째 탭을 보여줌
        mTabHost01.setCurrentTab(1);
        // 첫 번쨰 탭은 0, 두 번째 탭은 1, 세 번쨰 탭은 2 ....
        // 위치번호를 안주면 0 -> 첫 번쨰 탭이 화면에 보여짐
        // setCurrentTabByTag(mThirdTab.getTag());
        // -> 텝의 아이디로 화면에 보여줌
        
    }

    private void myLog(String msg) {
        Log.v(TAG, msg);
    }
}
