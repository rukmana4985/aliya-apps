package com.project.aliya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.base.adapter.BaseAdapter;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.content.ModelVideo;
import com.project.aliya.utils.OnBottomReachedListener;
import com.project.aliya.viewholder.VHListInfo;
import com.project.aliya.viewholder.VHListVideo;

import java.util.ArrayList;

public class AdapterVideoEbook extends BaseAdapter<ModelVideo> {

    private ArrayList<ModelVideo> listItemCopy;

    OnBottomReachedListener onBottomReachedListener;

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

        this.onBottomReachedListener = onBottomReachedListener;
    }

    public AdapterVideoEbook(ArrayList<ModelVideo> listItem) {
        super(listItem);
        this.listItemCopy = new ArrayList<>();
        if(listItem != null){
            this.listItemCopy.addAll(listItem);
        }
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_list_video, parent, false);
        VHListVideo vhListVideo = new VHListVideo(view);
        return vhListVideo;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == listItem.size() - 1){
            onBottomReachedListener.onBottomReached(position);
        }
        if (holder instanceof VHListVideo && listItem != null)
            ((VHListVideo) holder).setData(listItem.get(position));
    }
}
