package com.project.aliya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.base.adapter.BaseAdapter;
import com.project.aliya.model.content.ModelProduct;
import com.project.aliya.model.content.ModelVideo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.utils.OnBottomReachedListener;
import com.project.aliya.viewholder.VHListProduct;
import com.project.aliya.viewholder.VHProductHome;

import java.util.ArrayList;

public class AdapterProductHome extends BaseAdapter<ModelProduct> {

    private ArrayList<ModelProduct> listItemCopy;

    OnBottomReachedListener onBottomReachedListener;

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

        this.onBottomReachedListener = onBottomReachedListener;
    }

    public AdapterProductHome(ArrayList<ModelProduct> listItem) {
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
        View view = layoutInflater.inflate(R.layout.adapter_list_new_product_home, parent, false);
        VHProductHome vhProductHome = new VHProductHome(view);
        return vhProductHome;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (position == listItem.size() - 1){
//            onBottomReachedListener.onBottomReached(position);
//        }
        if (holder instanceof VHProductHome && listItem != null)
            ((VHProductHome) holder).setData(listItem.get(position));
    }
}
