package com.project.aliya.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;
import com.project.aliya.R;
import com.project.aliya.activity.MainActivity;
import com.project.aliya.activity.ProductActivity;
import com.project.aliya.base.adapter.BaseAdapter;
import com.project.aliya.model.content.ModelCategory;
import com.project.aliya.model.content.ModelProduct;
import com.project.aliya.model.request.RequestLogin;
import com.project.aliya.model.request.RequestSearchProduct;
import com.project.aliya.utils.OnBottomReachedListener;
import com.project.aliya.utils.Validation;
import com.project.aliya.viewholder.VHListCategory;
import com.project.aliya.viewholder.VHListProductSearch;

import java.util.ArrayList;

import butterknife.BindView;

public class AdapterProductSearch extends BaseAdapter<ModelProduct> {
//    @BindView(R.id.search) EditText search;
    private ArrayList<ModelProduct> listItemCopy;

    OnBottomReachedListener onBottomReachedListener;

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

        this.onBottomReachedListener = onBottomReachedListener;
    }

    public AdapterProductSearch(ArrayList<ModelProduct> listItem) {
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
        View view = layoutInflater.inflate(R.layout.adapter_list_product, parent, false);
        VHListProductSearch vhListProductSearch = new VHListProductSearch(view);
        return vhListProductSearch;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (position == listItem.size() - 1){
//            onBottomReachedListener.onBottomReached(position);
//        }
        if (holder instanceof VHListProductSearch && listItem != null)
            ((VHListProductSearch) holder).setData(listItem.get(position));
    }



}
