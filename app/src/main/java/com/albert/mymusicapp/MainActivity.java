package com.albert.mymusicapp;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.albert.mymusicapp.fragment.FragmentLocationMusic;
import com.albert.mymusicapp.fragment.FragmentNetMusic;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @OnClick(R.id.btn_locationmusic) void chooseLocationMusic(){
        changeView(1);
    }
    @OnClick(R.id.btn_netmusic) void chooseNetMusic(){
        changeView(2);
    }

    private FragmentNetMusic mNetMusic;
    private FragmentManager mManager;
    private FragmentLocationMusic locationMusic;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNetMusic = new FragmentNetMusic();
        locationMusic = new FragmentLocationMusic();
        mManager =  getSupportFragmentManager();
        changeView(1);
    }

    @Override
    protected void setSkin() {

    }

    private void changeView(int i){
        FragmentTransaction transaction = mManager.beginTransaction();
        switch (i){
            case 1:
                transaction.replace(R.id.content,locationMusic);
                break;
            case 2:
                transaction.replace(R.id.content,mNetMusic);
                break;
        }
        transaction.commit();
    }
}
