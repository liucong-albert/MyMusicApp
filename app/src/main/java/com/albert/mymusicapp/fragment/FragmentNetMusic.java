package com.albert.mymusicapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albert.mymusicapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017-08-15.
 */

public class FragmentNetMusic extends Fragment {
    private View mView;
    @BindView(R.id.reclcyclerview_musiclist)
    RecyclerView mMusicReclcyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if (mView == null){
            mView =  inflater.inflate(R.layout.fragment_item, container, false);
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

    }

}
