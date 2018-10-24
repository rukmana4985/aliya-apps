package com.project.aliya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.base.adapter.BaseAdapter;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.utils.OnBottomReachedListener;
import com.project.aliya.viewholder.VHListInfo;
import com.project.aliya.viewholder.VHListProduct;

import java.util.ArrayList;

public class AdapterInfo extends BaseAdapter<ModelInfo> {

    private ArrayList<ModelInfo> listItemCopy;

    OnBottomReachedListener onBottomReachedListener;

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

        this.onBottomReachedListener = onBottomReachedListener;
    }

    public AdapterInfo(ArrayList<ModelInfo> listItem) {
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
        View view = layoutInflater.inflate(R.layout.adapter_list_info, parent, false);
        VHListInfo vhListInfo = new VHListInfo(view);
        return vhListInfo;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == listItem.size() - 1){
            onBottomReachedListener.onBottomReached(position);
        }
        if (holder instanceof VHListInfo && listItem != null)
            ((VHListInfo) holder).setData(listItem.get(position));
    }
}
