package com.project.aliya.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;

import com.project.aliya.R;
import com.project.aliya.adapter.AdapterInfo;
import com.project.aliya.adapter.AdapterProductSearch;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.fragment.BonusFragment;
import com.project.aliya.fragment.CategoryFragment;
import com.project.aliya.fragment.HomeFragment;
import com.project.aliya.fragment.OtherFragment;
import com.project.aliya.fragment.ProductSearchFragment;
import com.project.aliya.fragment.VideoFragment;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.content.ModelProduct;
import com.project.aliya.model.request.RequestSearchProduct;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.utils.BottomNavigationViewHelper;
import com.project.aliya.utils.OnBottomReachedListener;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductSearchActivity extends BaseActivity {

    @BindView(R.id.list)
    protected RecyclerView list;

    @BindView(R.id.search)
    protected EditText search;

    AdapterProductSearch adapterProductSearch;

    int number      = 1;
    int lastPage    = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
        ButterKnife.bind(this);


    }

    private void loadNextPage(){
        RequestSearchProduct requestSearchProduct = new RequestSearchProduct();
        requestSearchProduct.setName(search.getText().toString());
        if(number <= lastPage )
            connectionPost.getProduct(progressDialog,this,requestSearchProduct,this,number);
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseListInfo){
            ResponseListProduct responseListProduct = (ResponseListProduct) o;

            ArrayList<ModelProduct> modelProducts =
                    new ArrayList<ModelProduct>(Arrays.asList(responseListProduct.getData()));
            if(number == 1){
                adapterProductSearch = new AdapterProductSearch(modelProducts);
                adapterProductSearch.setOnBottomReachedListener(new OnBottomReachedListener() {
                    @Override
                    public void onBottomReached(int position) {

                        loadNextPage();
                    }
                });
                list.setAdapter(adapterProductSearch);
            } else {
                adapterProductSearch.addAll(modelProducts);
            }
            number +=1;
            lastPage = responseListProduct.getLastPage();
        }
    }
}
