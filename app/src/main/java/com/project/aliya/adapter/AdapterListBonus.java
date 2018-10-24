package com.project.aliya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.base.adapter.BaseAdapter;
import com.project.aliya.model.response.ResponseListBonus;
import com.project.aliya.viewholder.VHListBonus;

import java.util.ArrayList;

/**
 * Created by faizf on 6/18/2017.
 */

public class AdapterListBonus extends BaseAdapter<ResponseListBonus> {


    public AdapterListBonus(ArrayList<ResponseListBonus> listItem) {
        super(listItem);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_list_bonus, parent, false);
        VHListBonus vhListBonus = new VHListBonus(view);
        return vhListBonus;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHListBonus && listItem != null)
            ((VHListBonus) holder).setData(listItem.get(position));
    }
}