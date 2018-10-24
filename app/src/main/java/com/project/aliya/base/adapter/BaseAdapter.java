package com.project.aliya.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.utils.OnBottomReachedListener;
import com.project.aliya.viewholder.VHEmpty;
import com.project.aliya.viewholder.VHLoad;

import java.util.ArrayList;

public class BaseAdapter<K> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected final ArrayList<K> listItem;

    protected final int EMPTY = 0;
    protected final int NON_EMPTY = 1;
    protected final int LOAD_MORE = 2;


    public BaseAdapter(ArrayList<K> listItem) {
        this.listItem = listItem;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case EMPTY:
                return createEmptyHolder(parent);
            case NON_EMPTY:
                return createHolder(parent, viewType);
            case LOAD_MORE:
                return loadMore(parent);
        }
        return null;
    }

    private RecyclerView.ViewHolder createEmptyHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_empty, parent, false);
        return new VHEmpty(view);
    }

    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return null;
    }

    private VHLoad loadMore(ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_load_more, parent, false);
        return new VHLoad(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public ArrayList<K> getListItem() {
        return listItem;
    }

    @Override
    public int getItemViewType(int position) {
        if (listItem != null) {
            if (listItem.size() != 0) {
                if (listItem.get(listItem.size() - 1) != null)
                    return NON_EMPTY;
                else
                    return LOAD_MORE;
            }
        } else {
            return EMPTY;
        }
        return EMPTY;
    }

    @Override
    public int getItemCount() {
        if (listItem != null && listItem.size() > 0) {
            return listItem.size();
        } else {
            return 1;
        }
    }

    public void add(K r) {
        listItem.add(r);
        notifyItemInserted(listItem.size() - 1);
    }

    public void addAll(ArrayList<K> ks) {
        int oldSize = listItem.size();
        listItem.addAll(ks);
        notifyItemRangeChanged(oldSize,ks.size());
        notifyDataSetChanged();
    }
}
