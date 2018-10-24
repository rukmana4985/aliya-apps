package com.project.aliya.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.aliya.R;
import com.project.aliya.adapter.AdapterVideoEbook;
import com.project.aliya.base.fragment.BaseFragment;
import com.project.aliya.model.content.ModelVideo;
import com.project.aliya.model.response.ResponseChapter;
import com.project.aliya.model.response.ResponseDetailEbook;
import com.project.aliya.model.response.ResponseListVideo;
import com.project.aliya.utils.OnBottomReachedListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class VideoFragment extends BaseFragment {

    @BindView(R.id.list)
    protected RecyclerView list;

    AdapterVideoEbook adapterVideoEbook;

    Integer number = 1;
    Integer lastPage = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_video, container, false);
        ButterKnife.bind(this,view);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadNextPage();
        return view;
    }

    private void loadNextPage(){
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ResponseListVideo){
            ResponseListVideo responseListVideo = (ResponseListVideo) o;

            ArrayList<ModelVideo> modelVideos =
                    new ArrayList<ModelVideo>(Arrays.asList(responseListVideo.getData()));
            if(number == 1){
                adapterVideoEbook = new AdapterVideoEbook(modelVideos);
                adapterVideoEbook.setOnBottomReachedListener(new OnBottomReachedListener() {
                    @Override
                    public void onBottomReached(int position) {
                        loadNextPage();
                    }
                });
                list.setAdapter(adapterVideoEbook);
            } else {
                adapterVideoEbook.addAll(modelVideos);
            }
            number +=1;
            lastPage = responseListVideo.getLastPage();
        }
    }

}
