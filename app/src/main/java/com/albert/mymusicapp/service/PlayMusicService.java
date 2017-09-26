package com.albert.mymusicapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

import com.albert.mymusicapp.model.MusicBean;

import java.util.ArrayList;

/**
 * Created by liucon 2017-09-19.
 * 主要内容：
 */

public class PlayMusicService extends Service {
    private MediaPlayer mMediaPlayer;
    private ArrayList<MusicBean> mMusicList;
    private int currentMusicPosition = 0;
    private MusicBean mCurrentMusicBean;

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mMediaPlayer = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Bundle bundle =intent.getExtras();

        return super.onStartCommand(intent, flags, startId);
    }

    public void setData(ArrayList<MusicBean> mMusicList,int currentMusicPosition){
        this.mMusicList = mMusicList;
        this.currentMusicPosition = currentMusicPosition;
        mCurrentMusicBean = mMusicList.get(currentMusicPosition);
    }

    public void play() {
        try{
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(mCurrentMusicBean.getUrl());
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void stop() {
        mMediaPlayer.stop();
    }

    public void contiun() {
        mMediaPlayer.start();
    }

    public void pasu() {
        mMediaPlayer.pause();
    }

    public void prev(){
        if (currentMusicPosition == 0){
            return ;
        }
        currentMusicPosition--;
        play();
    }

    public void next(){
        if (currentMusicPosition == mMusicList.size()-1){
            return ;
        }
        currentMusicPosition++;
        play();
    }

    public boolean isPlaying(){
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()){
            return true;
        }
        return false;
    }

    public int getSeekBarProgress(){
        double s1 = mMediaPlayer.getCurrentPosition();
        double s2 = mCurrentMusicBean.getDuration();
        double currentProgress = s1/s2;
        return (int)(currentProgress*100);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null || mMediaPlayer.isPlaying()){
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
    }

   public class MyBinder extends Binder{
       public PlayMusicService getService(){
            return PlayMusicService.this;
        }

    }
}
