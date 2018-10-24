package com.project.aliya.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.aliya.R;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.model.request.RequestUpdatePassword;
import com.project.aliya.model.response.ResponseUpdatePassword;
import com.project.aliya.utils.Validation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AkunActivity extends BaseActivity {

    @BindView(R.id.oldpassword)
    protected EditText oldpassword;

    @BindView(R.id.npassword)
    protected EditText npassword;

    @BindView(R.id.cpassword)
    protected EditText cpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.update)
    public void clickSignIn(View view) {
        if (Validation.checkLength(oldpassword, 1)) {
            if (Validation.checkPasswordSame(npassword, cpassword)) {
                RequestUpdatePassword requestUpdatePassword = new RequestUpdatePassword();
                requestUpdatePassword.setPasswordLama(utilsLayout.getBodyText(oldpassword));
                requestUpdatePassword.setPasswordBaru(utilsLayout.getBodyText(npassword));
                requestUpdatePassword.setPasswordBaruKonfirm(utilsLayout.getBodyText(cpassword));
                connectionPost.goUpdatePassword(progressDialog, requestUpdatePassword, this, this);
            }
        }
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseUpdatePassword) {
            ResponseUpdatePassword responseLogin = (ResponseUpdatePassword ) o;
            this.finish();
        }
    }
}
