package com.dongnao.eventbus;

import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2018/5/18.
 */

public class MyAppliocation extends Application {
    private static int i = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("david", "onCreate: "+(i++));
    }
}
