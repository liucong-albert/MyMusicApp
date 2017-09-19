package com.albert.mymusicapp.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.albert.mymusicapp.BaseActivity;
import com.albert.mymusicapp.R;
import com.albert.mymusicapp.model.MusicBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liucon 2017-09-19.
 * 主要内容：
 */

public class PlayingActivity extends BaseActivity {
    @BindView(R.id.img_playingact_prev)
    ImageView mPrev;
    @BindView(R.id.img_playingact_playing)
    ImageView mPlaying;
    @BindView(R.id.img_playingact_next)
    ImageView mNext;
    @BindView(R.id.img_playingact_musiclist)
    ImageView mMusicList;

    private MusicBean mMusicInfo;
    @Override
    protected void initView() {
        setContentView(R.layout.act_playing);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        mMusicInfo = (MusicBean) bundle.getSerializable("data");
    }

    @Override
    protected void setSkin() {

    }
}
