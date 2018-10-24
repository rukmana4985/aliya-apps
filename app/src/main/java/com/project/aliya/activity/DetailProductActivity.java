package com.project.aliya.activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.connection.ConnectionGet;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.content.ModelProduct;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailProductActivity extends BaseActivity {

    @BindView(R.id.name)
    protected TextView name;

    @BindView(R.id.subtitle)
    protected TextView subtitle;

    @BindView(R.id.description)
    protected TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        ButterKnife.bind(this);

        Intent i= getIntent();
        Gson gson = new Gson();
        String product = i.getStringExtra("product");

        ModelProduct modelProduct = gson.fromJson(product,ModelProduct.class);
//        Picasso.get().load(modelInfo.getImage())
//                .into(image);
        name.setText(modelProduct.getName());
        subtitle.setText(modelProduct.getSubtitle());
        description.setText(modelProduct.getDescription());

//        content.loadData(modelInfo.getContent(),"text/html; charset=utf-8","utf-8");
    }


}
