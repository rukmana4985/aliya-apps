package com.project.aliya.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.adapter.AdapterInfo;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.utils.OnBottomReachedListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailInfoActivity extends BaseActivity {

    @BindView(R.id.title)
    protected TextView title;

    @BindView(R.id.image)
    protected ImageView image;

    @BindView(R.id.content)
    protected WebView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        ButterKnife.bind(this);

        Intent i= getIntent();
        Gson gson = new Gson();
        String info = i.getStringExtra("info");

        ModelInfo modelInfo = gson.fromJson(info,ModelInfo.class);
        Picasso.get().load(modelInfo.getImage())
                .into(image);
        title.setText(modelInfo.getTitle());
        content.loadData(modelInfo.getContent(),"text/html; charset=utf-8","utf-8");
    }


}
