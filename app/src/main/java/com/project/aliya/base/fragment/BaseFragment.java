package com.project.aliya.base.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.project.aliya.R;
import com.project.aliya.base.callback.CallbackConnection;
import com.project.aliya.connection.ConnectionGet;
import com.project.aliya.connection.ConnectionPost;


public class BaseFragment extends Fragment implements CallbackConnection {

    protected ConnectionGet connectionGet;
    protected ConnectionPost connectionPost;

    protected ProgressDialog progressDialog;

    public BaseFragment(){
        connectionGet = new ConnectionGet();
        connectionPost = new ConnectionPost();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getResources().getString(R.string.content_progress));

    }

    public void initFragment(Fragment classFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content, classFragment);
        transaction.commit();
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onSuccessNull() {

    }

}
