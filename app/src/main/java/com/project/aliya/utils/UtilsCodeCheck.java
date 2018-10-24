package com.project.aliya.utils;

import android.app.Activity;
import android.app.ProgressDialog;

import com.google.gson.Gson;
import com.project.aliya.base.callback.CallbackConnection;
import com.project.aliya.model.ModelError;


import java.io.IOException;

import butterknife.internal.Utils;
import retrofit2.Response;

public class UtilsCodeCheck {

    protected Activity activity;

    protected IntentManager intentManager;

    protected Util util;

    public UtilsCodeCheck() {
        activity = new Activity();
        intentManager = new IntentManager();
        util = new Util();
    }

    public <E> void checkCodeGet(CallbackConnection callbackConnection, Response<E> o, ProgressDialog progressDialog, Activity cActivity) {
        activity = cActivity;
        switch (o.code()) {
            case 200:callbackConnection.onSuccess(o.body());break;
            case 203:showNotMatch(o);break;
            case 204:callbackConnection.onSuccessNull();break;
            case 403:util.showExpired(activity);break;
            case 400:showErrorValidate(o);break;
            case 409:util.showUnauthorized(activity,activity);break;
            default:showError(o);break;
        }
        progressDialog.dismiss();
    }

    public <E> void showNotMatch(Response<E> o) {
//        ModelError modelError = null;
//        modelError = new Gson().fromJson(String.valueOf(o.body()), ModelError.class);
        util.showDialogError(activity, "Terjadi kesalahan harap hubungi admin");
    }

    public <E> void showError(Response<E> o) {
//        ModelError modelError = null;
//        try {
////            modelError = new Gson().fromJson(o.errorBody().string(), ModelError.class);
//            Log.e("error message", o.errorBody().string());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        util.showDialogError(activity, modelError.getMessage());
        util.showDialogError(activity, "Terjadi kesalahan harap hubungi admin");
    }

    private <E> void showErrorValidate(Response<E> o) {
        ModelError modelError = null;
        String error = "";

        try {
            modelError = new Gson().fromJson(o.errorBody().string(), ModelError.class);
            if (modelError.getErrors() != null) {
                for (int i = 0; i < modelError.getErrors().length; i++) {
                    error = error + "- " + modelError.getErrors()[i] + "\n";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        util.showDialogError(activity, modelError.getMessage() + ":\n\n" + error);
    }
}
