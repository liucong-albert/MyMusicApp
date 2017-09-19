package com.albert.mymusicapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.albert.mymusicapp.R;
import com.albert.mymusicapp.activity.PlayingActivity;
import com.albert.mymusicapp.model.MusicBean;

import java.util.ArrayList;

import butterknife.OnClick;

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
        final MusicBean musicBean = mList.get(position);
        holder.mName.setText(""+musicBean.getTitle());
        holder.mName.setSelected(true);
        holder.mArtist.setText(""+musicBean.getArtist());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,PlayingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data",musicBean);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView mName,mArtist;
        ImageView mMusicIcon;
        ImageButton mMore;
        RelativeLayout mRelativeLayout;
        public MyHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.tv_adapterlocationmusic_musicname);
            mArtist = (TextView) itemView.findViewById(R.id.tv_adapterlocationmusic_musicauthor);
            mMusicIcon = (ImageView) itemView.findViewById(R.id.img_adapterloactionmusic_musicicon);
            mMore = (ImageButton) itemView.findViewById(R.id.imgbtn_adapterlocationmusic_more);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.relay_adapterloactionmusic_contair);
        }
    }
}
