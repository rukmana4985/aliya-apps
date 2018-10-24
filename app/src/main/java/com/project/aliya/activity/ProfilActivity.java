package com.project.aliya.activity;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.project.aliya.R;
import com.project.aliya.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfilActivity extends BaseActivity {

    @BindView(R.id.webview)
    protected WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_penulis);
        ButterKnife.bind(this);

        webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                // TODO show you progress image
                super.onPageStarted(view, url, favicon);
                progressDialog = new ProgressDialog(ProfilActivity.this);
                progressDialog.setMessage("Mohon Tunggu...");
                progressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                // TODO hide your progress image
                super.onPageFinished(view, url);
                progressDialog.dismiss();
            }
        });
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://www.teddydiego.id");
    }
}
