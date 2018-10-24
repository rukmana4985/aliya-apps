package com.project.aliya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.activity.AkunActivity;
import com.project.aliya.activity.DetailInfoActivity;
import com.project.aliya.activity.InfoActivity;
import com.project.aliya.activity.MainActivity;
import com.project.aliya.activity.ProfilActivity;
import com.project.aliya.adapter.AdapterCategoryHome;
import com.project.aliya.adapter.AdapterInfo;
import com.project.aliya.adapter.AdapterProductHome;
import com.project.aliya.adapter.AdapterVideoHome;
import com.project.aliya.base.fragment.BaseFragment;
import com.project.aliya.base.session.PersonalData;
import com.project.aliya.model.content.ModelCategory;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.content.ModelProduct;
import com.project.aliya.model.content.ModelVideo;
import com.project.aliya.model.request.RequestSearchProduct;
import com.project.aliya.model.response.ResponseChapter;
import com.project.aliya.model.response.ResponseDetailEbook;
import com.project.aliya.model.response.ResponseListCategory;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.model.response.ResponseListVideo;
import com.project.aliya.model.response.ResponseLogin;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.slider)
    Slider slider;

    @BindView(R.id.scroll)
    ScrollView scroll;

    @BindView(R.id.listproduct)
    RecyclerView listproduct;

    @BindView(R.id.listcategory)
    RecyclerView listcategory;

//    @BindView(R.id.searchproduct)
//    protected EditText searchproduct;




    AdapterProductHome adapterProductHome;
    AdapterCategoryHome adapterCategoryHome;
    List<Slide> slideList;

    ArrayList<ModelInfo> modelInfos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        searchproduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), ProductSearchActivity.class);
//                getActivity().startActivity(intent);
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        init();
        return view;
    }

    public void init() {
        RequestSearchProduct requestSearchProduct = new RequestSearchProduct();
        requestSearchProduct.setName("");
        requestSearchProduct.setName("");

        connectionPost.getProduct(progressDialog, this, requestSearchProduct, getActivity(),1);
        connectionGet.getCategory(progressDialog, this,  getActivity());
    }

    public void setSlider() {
        connectionGet.getListInfo(progressDialog,this,1,getActivity());
        slider.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailInfoActivity.class);
                String stringInfo = (new Gson().toJson(modelInfos.get(i)));
                intent.putExtra("info", stringInfo);
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseListProduct) {
            ResponseListProduct responseListProduct = (ResponseListProduct) o;
            ArrayList<ModelProduct> responseListProducts =
                    new ArrayList<ModelProduct>(Arrays.asList(responseListProduct.getData()));
            adapterProductHome = new AdapterProductHome(responseListProducts);
            listproduct.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

            listproduct.setAdapter(adapterProductHome);
            return;
        }
        if (o instanceof ResponseListCategory) {
            ResponseListCategory responseListCategory = (ResponseListCategory) o;
            ArrayList<ModelCategory> modelCategories =
                    new ArrayList<ModelCategory>(Arrays.asList(responseListCategory.getData()));
            adapterCategoryHome = new AdapterCategoryHome(modelCategories);
            listcategory.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

            listcategory.setAdapter(adapterCategoryHome);
            return;
        }
    }




}
