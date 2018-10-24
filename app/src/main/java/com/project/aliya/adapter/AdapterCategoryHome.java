package com.project.aliya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.base.adapter.BaseAdapter;
import com.project.aliya.model.content.ModelCategory;
import com.project.aliya.utils.OnBottomReachedListener;
import com.project.aliya.viewholder.VHListCategory;

import java.util.ArrayList;

public class AdapterCategoryHome extends BaseAdapter<ModelCategory> {

    private ArrayList<ModelCategory> listItemCopy;

    OnBottomReachedListener onBottomReachedListener;

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

        this.onBottomReachedListener = onBottomReachedListener;
    }

    public AdapterCategoryHome(ArrayList<ModelCategory> listItem) {
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
        View view = layoutInflater.inflate(R.layout.adapter_list_category_home, parent, false);
        VHListCategory vhListCategory = new VHListCategory(view);
        return vhListCategory;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (position == listItem.size() - 1){
//            onBottomReachedListener.onBottomReached(position);
//        }
        if (holder instanceof VHListCategory && listItem != null)
            ((VHListCategory) holder).setData(listItem.get(position));
    }
}
