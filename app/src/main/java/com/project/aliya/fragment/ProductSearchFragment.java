package com.project.aliya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.project.aliya.R;
import com.project.aliya.activity.ProductSearchActivity;
import com.project.aliya.adapter.AdapterCategory;
import com.project.aliya.adapter.AdapterProductSearch;
import com.project.aliya.base.fragment.BaseFragment;
import com.project.aliya.model.content.ModelCategory;
import com.project.aliya.model.content.ModelProduct;
import com.project.aliya.model.request.RequestLogin;
import com.project.aliya.model.request.RequestSearchProduct;
import com.project.aliya.model.response.ResponseListCategory;
import com.project.aliya.model.response.ResponseListProduct;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductSearchFragment extends BaseFragment {



    AdapterProductSearch adapterProductSearch;
    @BindView(R.id.list) RecyclerView list;
    @BindView(R.id.searchproduct) EditText searchproduct;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_search, container, false);
        ButterKnife.bind(this,view);
        connectionGet.getListProduct(progressDialog, this,  getActivity());
        return view;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseListProduct) {
            ResponseListProduct responseListProduct = (ResponseListProduct) o;
            ArrayList<ModelProduct> modelProducts =
                    new ArrayList<ModelProduct>(Arrays.asList(responseListProduct.getData()));
            adapterProductSearch = new AdapterProductSearch(modelProducts);
            list.setLayoutManager(new  GridLayoutManager(getActivity(), 2));

            list.setAdapter(adapterProductSearch);
            return;
        }
    }

    @OnClick(R.id.searchproduct)
    public void clickSearch(View view) {

        RequestSearchProduct requestSearchProduct = new RequestSearchProduct();
        requestSearchProduct.setName(searchproduct.getText().toString());
        connectionPost.getProduct(progressDialog, this, requestSearchProduct,getActivity(),1);
    }

    public void init () {
        RequestSearchProduct requestSearchProduct = new RequestSearchProduct();
        requestSearchProduct.setName("");
        connectionPost.getProduct(progressDialog, this, requestSearchProduct,getActivity(),1);

    }

}
