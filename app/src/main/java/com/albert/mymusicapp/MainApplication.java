package com.albert.mymusicapp;

import android.app.Application;

import com.albert.mymusicapp.utils.SkinUtil;

/**
 * Created by Administrator on 2017-08-17.
 */

public class MainApplication extends Application {
    public static SkinUtil skinUtil;
    @Override
    public void onCreate() {
        super.onCreate();
        skinUtil = new SkinUtil(getApplicationContext());
    }
}
