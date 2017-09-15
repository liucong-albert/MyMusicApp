package com.albert.mymusicapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.albert.mymusicapp.R;
import com.albert.mymusicapp.model.MusicBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-08-16.
 */

public class LocationMusicAdapter extends RecyclerView.Adapter<LocationMusicAdapter.MyHolder> {
    private Context mContext;
    private ArrayList<MusicBean>  mList;

    public LocationMusicAdapter(Context mContext,ArrayList<MusicBean> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.adapter_locationmusic,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        MusicBean musicBean = mList.get(position);
        holder.name.setText(""+musicBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView name;
        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_locationmusic_name);
        }
    }
}
