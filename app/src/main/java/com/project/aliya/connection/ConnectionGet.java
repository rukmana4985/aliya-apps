package com.project.aliya.connection;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;

import com.project.aliya.base.callback.CallbackConnection;
import com.project.aliya.connection.service.ApiClient;
import com.project.aliya.connection.service.ApiConfig;
import com.project.aliya.fragment.ProductSearchFragment;
import com.project.aliya.model.response.ResponseChapter;
import com.project.aliya.model.response.ResponseDetailEbook;
import com.project.aliya.model.response.ResponseDetailInfo;
import com.project.aliya.model.response.ResponseListBonus;
import com.project.aliya.model.response.ResponseListCategory;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.model.response.ResponseListVideo;
import com.project.aliya.utils.IntentManager;
import com.project.aliya.utils.Util;
import com.project.aliya.utils.UtilsCodeCheck;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectionGet {

    protected Activity activity;

    protected UtilsCodeCheck utilsCodeCheck;
    protected IntentManager intentManager;
    protected Util util;

    public ConnectionGet() {
        utilsCodeCheck  = new UtilsCodeCheck();
        util            = new Util();
    }

    public void getCategory(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, final Activity cActivity){
        progressDialog.show();
        activity = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseListCategory> call = apiConfig.getCategory();
        call.enqueue(new Callback<ResponseListCategory>() {
            @Override
            public void onResponse(Call<ResponseListCategory> call, Response<ResponseListCategory> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }
            @Override
            public void onFailure(Call<ResponseListCategory> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    public void getDetailEbook(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, final Activity cActivity, Integer page) {
        progressDialog.show();
        activity = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseDetailEbook> call = apiConfig.getDetailEbook(page);
        call.enqueue(new Callback<ResponseDetailEbook>() {
            @Override
            public void onResponse(Call<ResponseDetailEbook> call, Response<ResponseDetailEbook> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }

            @Override
            public void onFailure(Call<ResponseDetailEbook> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    public void getListProduct(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, Integer brand_id, Activity cActivity) {
        progressDialog.show();
        activity = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseListProduct> call = apiConfig.getListProduct(brand_id);
        call.enqueue(new Callback<ResponseListProduct>() {
            @Override
            public void onResponse(Call<ResponseListProduct> call, Response<ResponseListProduct> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }

            @Override
            public void onFailure(Call<ResponseListProduct> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    public void getListBonus(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, final Activity cActivity) {
        progressDialog.show();
        activity = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseListBonus> call = apiConfig.getListBonus();
        call.enqueue(new Callback<ResponseListBonus>() {
            @Override
            public void onResponse(Call<ResponseListBonus> call, Response<ResponseListBonus> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }

            @Override
            public void onFailure(Call<ResponseListBonus> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    public void getListInfo(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, int page, final Activity cActivity) {
        progressDialog.show();
        activity = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseListInfo> call = apiConfig.getPagingInfo(page);
        call.enqueue(new Callback<ResponseListInfo>() {
            @Override
            public void onResponse(Call<ResponseListInfo> call, Response<ResponseListInfo> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }

            @Override
            public void onFailure(Call<ResponseListInfo> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    public void getDetailInfo(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, Integer id, final Activity cActivity){
        progressDialog.show();
        activity = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseDetailInfo> call = apiConfig.getDetailInfo(id);
        call.enqueue(new Callback<ResponseDetailInfo>() {
            @Override
            public void onResponse(Call<ResponseDetailInfo> call, Response<ResponseDetailInfo> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }
            @Override
            public void onFailure(Call<ResponseDetailInfo> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    public void getListProduct(ProgressDialog progressDialog, ProductSearchFragment productSearchFragment, FragmentActivity activity) {
    }
}
