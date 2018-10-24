package com.project.aliya.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.base.session.PersonalData;
import com.project.aliya.base.session.SessionToken;
import com.project.aliya.model.request.RequestLogin;
import com.project.aliya.model.response.ResponseLogin;
import com.project.aliya.utils.Validation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.phonenumber)
    protected EditText phonenumber;

    @BindView(R.id.password)
    protected EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.signin)
    public void clickSignIn(View view) {
        signIn();
    }

    @OnClick(R.id.register)
    public void clickRegister(View view) {
        Uri uri = Uri.parse("https://terminalhrd.com/order/N5JC");
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @OnClick(R.id.forgot)
    public void clickForgot(View view) {
        Uri uri = Uri.parse("https://www.terminalhrd.com/site/forgot");
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }


    public void signIn() {
        if (Validation.checkLength(phonenumber, 1)) {
            if (Validation.checkLength(password, 1)) {
                RequestLogin requestLogin = new RequestLogin();
                requestLogin.setUsername(phonenumber.getText().toString());
                requestLogin.setPassword(password.getText().toString());
                String tokenFirebase = FirebaseInstanceId.getInstance().getToken();
                requestLogin.setDeviceId(tokenFirebase);
//                connectionPost.goLogin(progressDialog, this, requestLogin,this);

                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
            }
        }
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseLogin) {
            ResponseLogin responseLogin = (ResponseLogin) o;
//            new PersonalData(this).setUserData(new Gson().toJson(responseLogin, ResponseLogin.class));
//            new SessionToken(this).setToken(responseLogin.getToken());
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            this.finish();
        }
    }
}

