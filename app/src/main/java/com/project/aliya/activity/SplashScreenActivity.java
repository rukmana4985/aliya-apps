package com.project.aliya.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.project.aliya.R;
import com.project.aliya.base.activity.BaseActivity;

import butterknife.ButterKnife;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (checkLogin()) {
                    startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                }
                else {
                    startActivity(new Intent(SplashScreenActivity.this,LoginActivity.class));
                }
                finish();
            }
        },4000);

    }

}

