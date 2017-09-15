package com.albert.mymusicapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.AttrRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.albert.mymusicapp.R;

/**
 * Created by Administrator on 2017-08-17.
 */

public class ToolBar extends LinearLayout {

    public ToolBar(Context context) {
        super(context);
    }

    public ToolBar(Context context , AttributeSet atr){
        super(context , atr);
        View view = LayoutInflater.from(context).inflate(R.layout.view_toolbar, this);
    }
}
