package com.project.aliya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aliya.R;
import com.project.aliya.activity.AkunActivity;
import com.project.aliya.activity.InfoActivity;
import com.project.aliya.activity.ProfilActivity;
import com.project.aliya.activity.TermActivity;
import com.project.aliya.base.fragment.BaseFragment;
import com.project.aliya.dialog.LogoutDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_other, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.akun)
    public void clickAkun(View view) {
        Intent intent = new Intent(getActivity(), AkunActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.info)
    public void clickInfo(View view) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.profil)
    public void clickProfil(View view) {
        Intent intent = new Intent(getActivity(), ProfilActivity.class);
        startActivity(intent);
    }

//    @OnClick(R.id.tiket)
//    public void clickTiket(View view) {
//        Intent intent = new Intent(getActivity(), TiketActivity.class);
//        startActivity(intent);
//    }

    @OnClick(R.id.term)
    public void clickTerm(View view) {
        Intent intent = new Intent(getActivity(), TermActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.video)
    public void clickVideo(View view) {
    }

    @OnClick(R.id.logout)
    public void clickLogout(View view) {
        LogoutDialog.showLogout(getActivity());
    }
}
