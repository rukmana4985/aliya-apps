package com.project.aliya.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.project.aliya.R;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.fragment.BonusFragment;
import com.project.aliya.fragment.CategoryFragment;
import com.project.aliya.fragment.HomeFragment;
import com.project.aliya.fragment.OtherFragment;
import com.project.aliya.fragment.VideoFragment;
import com.project.aliya.utils.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomnav)
    protected BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment(new HomeFragment());

        bottomnav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                initFragment(new HomeFragment());
                                break;

                            case R.id.category:
                                initFragment(new CategoryFragment());
                                break;
                            case R.id.video:
                                initFragment(new VideoFragment());

                                break;
                            case R.id.bonus:
                                initFragment(new BonusFragment());

                                break;
                            case R.id.other:
                                initFragment(new OtherFragment());

                                break;


                        }
                        return true;
                    }
                });
        BottomNavigationViewHelper.removeShiftMode(bottomnav);
    }
}
