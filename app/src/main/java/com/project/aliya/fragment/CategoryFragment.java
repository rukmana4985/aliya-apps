package com.project.aliya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.project.aliya.R;
import com.project.aliya.activity.MainActivity;
import com.project.aliya.activity.ProductSearchActivity;
import com.project.aliya.adapter.AdapterCategory;
import com.project.aliya.base.fragment.BaseFragment;
import com.project.aliya.model.content.ModelCategory;
import com.project.aliya.model.request.RequestUpdatePassword;
import com.project.aliya.model.response.ResponseListCategory;
import com.project.aliya.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryFragment extends BaseFragment {



    AdapterCategory adapterCategory;
    @BindView(R.id.list) RecyclerView list;
    @BindView(R.id.search) EditText search;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);
        connectionGet.getCategory(progressDialog, this,  getActivity());
        return view;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseListCategory) {
            ResponseListCategory responseListCategory = (ResponseListCategory) o;
            ArrayList<ModelCategory> modelCategories =
                    new ArrayList<ModelCategory>(Arrays.asList(responseListCategory.getData()));
            adapterCategory = new AdapterCategory(modelCategories);
            list.setLayoutManager(new  GridLayoutManager(getActivity(), 2));

            list.setAdapter(adapterCategory);
            return;
        }
    }

    @OnClick(R.id.search)
    public void clickSearch(View view) {
        Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
        getActivity().startActivity(intent);
    }

}
