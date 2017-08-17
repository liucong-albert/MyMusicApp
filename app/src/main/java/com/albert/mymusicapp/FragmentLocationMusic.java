package com.albert.mymusicapp;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albert.mymusicapp.model.MusicBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017-08-15.
 */

public class FragmentLocationMusic extends Fragment {
    private View mView;
    private ArrayList<MusicBean> mMusicList = new ArrayList<>();
    private LocationMusicAdapter mAdapter;
    private   String[] mMusicInfo = new String[]{
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,       //歌曲名
            MediaStore.Audio.Media.ALBUM,       //专辑
            MediaStore.Audio.Media.DISPLAY_NAME, //显示的文件名
            MediaStore.Audio.Media.ARTIST,     //歌手
            MediaStore.Audio.Media.DURATION,   //时长
            MediaStore.Audio.Media.SIZE,       //长度
            MediaStore.Audio.Media.DATA,       //路径
    };
    @BindView(R.id.musiclist)
    RecyclerView musicRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if (mView == null){
            mView = inflater.inflate(R.layout.fragment_item, container, false);
        }
        ViewGroup parent= (ViewGroup) mView.getParent();
        if (parent!=null){
            parent.removeView(mView);
        }
        ButterKnife.bind(this,mView);
        init();
        return  mView;
    }
    private void init(){
        getLocationMusicList();
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
        musicRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new LocationMusicAdapter(getActivity(),mMusicList);
        musicRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 获取本地音乐列表
     */
    private void getLocationMusicList(){
        ContentResolver mResolver = getActivity().getContentResolver();
        Cursor mCursor = mResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,mMusicInfo,null,null,null);
        int mSize = mCursor.getCount();
        for (int i = 0 ; i < mSize ; i++){
            MusicBean musicBean = new MusicBean();
            if (!mCursor.moveToNext()){
                return;
            }
            long id = mCursor.getLong(0);
            String title = mCursor.getString(1);
            String album = mCursor.getString(2);
            String displayName = mCursor.getString(3);
            String artist = mCursor.getString(4);
            long duration = mCursor.getLong(5);
            long size = mCursor.getLong(6);
            String url = mCursor.getString(7);
            musicBean.setId(id);
            musicBean.setAlbum(album);
            musicBean.setArtist(artist);
            musicBean.setTitle(title);
            musicBean.setDisplayName(displayName);
            musicBean.setDuration(duration);
            musicBean.setSize(size);
            musicBean.setUrl(url);
            mMusicList.add(musicBean);
        }
    }
}
