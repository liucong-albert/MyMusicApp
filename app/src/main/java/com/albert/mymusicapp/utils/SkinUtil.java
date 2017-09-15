package com.albert.mymusicapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017-08-17.
 */

public class SkinUtil {
    private SharedPreferences sp;
    private final String KEY = "skin";
    public static final int VALUE_SKIN_BLUE = 1;
    public static final int VALUE_SKIN_PURPLE = 2;

    //当前皮肤资源ID
    private int activity_bg;
    private int item_bg;
    private int textColor;

    public SkinUtil(Context context){
        sp = context.getSharedPreferences("mySkin", Context.MODE_PRIVATE);
        loadSkin();
    }

    private void loadSkin(){
        int currentSkin =  sp.getInt(KEY, VALUE_SKIN_BLUE);
        switch (currentSkin){
            case VALUE_SKIN_BLUE:
                setSkinBlue();
                break;
            case VALUE_SKIN_PURPLE:
                setSkinPurple();
                break;
        }
    }

    private void setSkinBlue(){

    }

    private void setSkinPurple(){

    }
}
