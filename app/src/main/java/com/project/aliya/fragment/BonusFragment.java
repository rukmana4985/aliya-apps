package com.project.aliya.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.adapter.AdapterListBonus;
import com.project.aliya.base.fragment.BaseFragment;
import com.project.aliya.model.response.ResponseListBonus;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BonusFragment extends BaseFragment {

    @BindView(R.id.list)
    RecyclerView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_bonus, container, false);
        ButterKnife.bind(this,view);
        init();
        return view;
    }

    public void init () {
        connectionGet.getListBonus(progressDialog, this, getActivity());
    }

    @Override
    public void onSuccess(Object o) {

        if (o instanceof ResponseListBonus){
            ResponseListBonus responseListBonuss = (ResponseListBonus) o;
            ArrayList<ResponseListBonus> responseListBonus = null;
            if (responseListBonuss.getData().length > 0){
                responseListBonus = new ArrayList<>(Arrays.asList(responseListBonuss.getData()));
            }
            list.setLayoutManager(new LinearLayoutManager(getActivity()));
            AdapterListBonus adapterListBonus = new AdapterListBonus(responseListBonus);
            list.setAdapter(adapterListBonus);
            return;
        }
    }
}
