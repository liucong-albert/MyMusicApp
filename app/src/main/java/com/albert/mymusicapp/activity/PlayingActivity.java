package com.albert.mymusicapp.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.albert.mymusicapp.BaseActivity;
import com.albert.mymusicapp.R;
import com.albert.mymusicapp.model.MusicBean;
import com.albert.mymusicapp.service.PlayMusicService;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liucon 2017-09-19.
 * 主要内容：
 */

public class PlayingActivity extends BaseActivity {
    private PlayMusicService mService;
    private ArrayList<MusicBean> mMusicList;
    private int currentMusicPosition = 0;

    @BindView(R.id.tv_currenttime)
    TextView mCurrentTime;
    @BindView(R.id.tv_totaltime)
    TextView mTotalTime;
    @BindView(R.id.img_playingact_playing)
    ImageView mPlaying;
    @BindView(R.id.seekBar)
    SeekBar mSeekBar;
    @OnClick(R.id.img_playingact_prev) void prev(){
        mService.prev();
    }
    @OnClick(R.id.img_playingact_playing) void play(){
        if (mService.isPlaying()){
            mService.pasu();
            mPlaying.setSelected(false);
        }else{
            handler.postDelayed(runnable,1000);
            mPlaying.setSelected(true);
            mService.play();
        }
    }
    @OnClick(R.id.img_playingact_next) void next(){
        mService.next();
    }
    @OnClick(R.id.img_playingact_musiclist) void showList(){

    }

    @Override
    protected void initView() {
        setContentView(R.layout.act_playing);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        mMusicList = (ArrayList<MusicBean>) bundle.getSerializable("data");
        currentMusicPosition = bundle.getInt("position");
        Intent intent = new Intent(this,PlayMusicService.class);
        intent.putExtras(bundle);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        init();
    }

    private void init() {
        mCurrentTime.setText("0");
        long musicTime = mMusicList.get(currentMusicPosition).getDuration() / 1000;
        String time = musicTime / 60 +":"+ musicTime % 60;
        mTotalTime.setText(""+time);
    }

    @Override
    protected void setSkin() {

    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((PlayMusicService.MyBinder) service).getService();
            mService.setData(mMusicList,currentMusicPosition);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mCurrentTime.setText(""+mService.getCurrentTime());
            mSeekBar.setProgress(mService.getSeekBarProgress());
            handler.postDelayed(runnable,1000);
        }
    };
}
