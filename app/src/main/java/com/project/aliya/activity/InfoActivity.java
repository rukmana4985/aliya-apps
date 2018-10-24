package com.project.aliya.activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.aliya.R;
import com.project.aliya.adapter.AdapterInfo;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.utils.OnBottomReachedListener;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends BaseActivity {


    @BindView(R.id.list)
    protected RecyclerView list;

    ResponseListProduct responseListProduct;
    AdapterInfo adapterInfo;

    Integer number = 1;
    Integer lastPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_info);
        ButterKnife.bind(this);

        list.setLayoutManager(new LinearLayoutManager(this));
        responseListProduct = new ResponseListProduct();
        loadNextPage();
    }


    private void loadNextPage(){
        if(number <= lastPage )
        connectionGet.getListInfo(progressDialog,this,number,this);
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseListInfo){
            ResponseListInfo responseListInfo = (ResponseListInfo) o;

            ArrayList<ModelInfo> responseListInfos =
                    new ArrayList<ModelInfo>(Arrays.asList(responseListInfo.getData()));
            if(number == 1){
                adapterInfo = new AdapterInfo(responseListInfos);
                adapterInfo.setOnBottomReachedListener(new OnBottomReachedListener() {
                    @Override
                    public void onBottomReached(int position) {

                        loadNextPage();
                    }
                });
                list.setAdapter(adapterInfo);
            } else {
                adapterInfo.addAll(responseListInfos);
            }
            number +=1;
            lastPage = responseListInfo.getLastPage();
        }
    }

}
