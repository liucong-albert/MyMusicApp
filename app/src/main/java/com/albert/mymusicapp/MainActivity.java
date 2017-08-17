package com.albert.mymusicapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.btn_locationmusic) void chooseLocationMusic(){
        changeView(1);
    }
    @OnClick(R.id.btn_netmusic) void chooseNetMusic(){
        changeView(2);
    }
    @BindView(R.id.btn_netmusic)
    Button btnNetMusic;
    private FragmentNetMusic netMusic;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        netMusic = new FragmentNetMusic();
        manager =  getSupportFragmentManager();
        changeView(1);
    }
    private void changeView(int i){
        FragmentLocationMusic locationMusic = new FragmentLocationMusic();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (i){
            case 1:
                transaction.replace(R.id.content,locationMusic);
                break;
            case 2:
                transaction.replace(R.id.content,netMusic);
                break;
        }
        transaction.commit();
    }
}
