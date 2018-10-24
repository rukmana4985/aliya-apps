package com.project.aliya.connection;

import android.app.Activity;
import android.app.ProgressDialog;

import com.project.aliya.base.callback.CallbackConnection;
import com.project.aliya.connection.service.ApiClient;
import com.project.aliya.connection.service.ApiConfig;
import com.project.aliya.model.request.RequestLogin;
import com.project.aliya.model.request.RequestSearchProduct;
import com.project.aliya.model.request.RequestUpdatePassword;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.model.response.ResponseLogin;
import com.project.aliya.model.response.ResponseUpdatePassword;
import com.project.aliya.utils.IntentManager;
import com.project.aliya.utils.Util;
import com.project.aliya.utils.UtilsCodeCheck;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectionPost{

    protected Activity activity;

    protected UtilsCodeCheck utilsCodeCheck;
    protected IntentManager intentManager;
    protected Util util;

    public ConnectionPost() {
        utilsCodeCheck  = new UtilsCodeCheck();
        util            = new Util();
    }

    public void goLogin(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, RequestLogin requestLogin, Activity cActivity) {
        progressDialog.show();
        activity = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseLogin> call = apiConfig.doLogin(requestLogin);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    public void goUpdatePassword(final ProgressDialog progressDialog, RequestUpdatePassword requestUpdatePassword, final CallbackConnection callbackConnection, final Activity cActivity) {
        progressDialog.show();
        activity    = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseUpdatePassword> loginCall = apiConfig.doUpdatePassword(requestUpdatePassword);
        loginCall.enqueue(new Callback<ResponseUpdatePassword>() {
            @Override
            public void onResponse(Call<ResponseUpdatePassword> call, Response<ResponseUpdatePassword> response) {
                utilsCodeCheck.checkCodeGet(callbackConnection, response, progressDialog,activity);
            }

            @Override
            public void onFailure(Call<ResponseUpdatePassword> call, Throwable t) {
                util.showDialogError(activity, t.getMessage());
                progressDialog.dismiss();

            }
        });
    }

    public void getProduct(final ProgressDialog progressDialog, final CallbackConnection callbackConnection, RequestSearchProduct requestSearchProduct, final Activity cActivity, int page) {
        progressDialog.show();
        activity    = cActivity;
        final ApiConfig apiConfig = ApiClient.getClient(activity).create(ApiConfig.class);
        Call<ResponseListProduct> loginCall = apiConfig.getPagingProduct(requestSearchProduct,page);
        loginCall.enqueue(new Callback<ResponseListProduct>() {
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
}
