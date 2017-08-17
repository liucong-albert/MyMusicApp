package com.albert.mymusicapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017-08-15.
 */

public class FragmentNetMusic extends Fragment {
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if (mView == null){
            mView =  inflater.inflate(R.layout.fragment_item, container, false);
        }
        ViewGroup parent= (ViewGroup) mView.getParent();
        if (parent!=null){
            parent.removeView(mView);
        }
        return  mView;
    }
}
