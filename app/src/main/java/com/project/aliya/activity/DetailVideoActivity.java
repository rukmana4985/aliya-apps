package com.project.aliya.activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.adapter.AdapterVideoDetail;
import com.project.aliya.adapter.AdapterVideoEbook;
import com.project.aliya.adapter.AdapterVideoHome;
import com.project.aliya.base.activity.BaseActivity;
import com.project.aliya.base.callback.CallbackConnection;
import com.project.aliya.connection.ConnectionGet;
import com.project.aliya.model.content.ModelInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.project.aliya.model.content.ModelVideo;
import com.project.aliya.model.response.ResponseListVideo;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailVideoActivity extends YouTubeBaseActivity implements CallbackConnection {

    @BindView(R.id.youtube)
    protected YouTubePlayerView youTubePlayerView;


    @BindView(R.id.title)
    protected TextView title;

    @BindView(R.id.list)
    protected RecyclerView list;

    @BindView(R.id.description)
    protected TextView description;

    YouTubePlayer.OnInitializedListener onInitializedListener;

    public static final String API_KEY = "AIzaSyCo92Mbh2S3ezU2-r4Ea9wO-UEk-1KrTjc";

    ModelVideo modelVideo;

    AdapterVideoHome adapterVideoHome;

    AdapterVideoDetail adapterVideoDetail;
    protected ConnectionGet connectionGet;

    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_video);
        ButterKnife.bind(this);


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getResources().getString(R.string.content_progress));
        init();

    }

    protected void init() {
        Intent i= getIntent();
        Gson gson = new Gson();
        String video = i.getStringExtra("video-ebook");

        modelVideo = gson.fromJson(video,ModelVideo.class);
        title.setText(modelVideo.getTitle());
        description.setText(modelVideo.getDescriptions());
        setYouTubePlayerView();
        connectionGet = new ConnectionGet();

    }


    protected void setYouTubePlayerView() {
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo(modelVideo.getUrl());

                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize(API_KEY, onInitializedListener);


    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseListVideo) {
            ResponseListVideo responseListVideo = (ResponseListVideo) o;
            ArrayList<ModelVideo> responseListVideos =
                    new ArrayList<ModelVideo>(Arrays.asList(responseListVideo.getData()));
            adapterVideoDetail = new AdapterVideoDetail(responseListVideos);
            list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            list.setAdapter(adapterVideoDetail);
            return;
        }
    }

    @Override
    public void onSuccessNull() {

    }
}
