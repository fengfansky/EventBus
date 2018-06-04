package com.dongnao.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Subscribe
    public void send(View view)
    {
        Eventbus.getDefault().post(new Friend("david","1234"));
    }

}
