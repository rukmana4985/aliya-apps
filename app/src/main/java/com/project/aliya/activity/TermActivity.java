package com.project.aliya.activity;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;

import com.project.aliya.R;
import com.project.aliya.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TermActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        ButterKnife.bind(this);
    }
}
