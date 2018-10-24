package com.project.aliya.base.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.project.aliya.R;
import com.project.aliya.base.callback.CallbackConnection;
import com.project.aliya.base.session.PersonalData;
import com.project.aliya.connection.ConnectionGet;
import com.project.aliya.connection.ConnectionPost;
import com.project.aliya.utils.UtilsLayout;


public class BaseActivity extends AppCompatActivity implements CallbackConnection {

    protected ConnectionGet connectionGet;
    protected ConnectionPost connectionPost;
    protected ProgressDialog progressDialog;
    protected UtilsLayout utilsLayout;


    public BaseActivity(){
        connectionGet   = new ConnectionGet();
        connectionPost  = new ConnectionPost();
        utilsLayout     = new UtilsLayout();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getResources().getString(R.string.content_progress));

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onSuccessNull() {

    }

    public void initFragment(Fragment classFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, classFragment);
        transaction.commit();
    }

    public boolean checkLogin() {
        return new PersonalData(this).getUserData() != null;
    }
}
