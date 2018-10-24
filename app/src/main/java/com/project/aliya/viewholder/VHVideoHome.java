package com.project.aliya.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.project.aliya.R;
import com.project.aliya.activity.DetailInfoActivity;
import com.project.aliya.activity.DetailVideoActivity;
import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.content.ModelVideo;
import com.squareup.picasso.Picasso;

public class VHVideoHome extends RecyclerView.ViewHolder  implements View.OnClickListener  {

    private TextView title, description;
    private ImageView image;
    private ModelVideo modelVideo;
    public VHVideoHome(View itemView) {
        super(itemView);
        title            = findView(R.id.title);
        description      = findView(R.id.description);
        image            = findView(R.id.image);
        itemView.setOnClickListener(this);
    }

    public void setData(ModelVideo data) {
        title.setText(data.getTitle());
        description.setText(data.getDescriptions());
        Picasso.get().load("http://img.youtube.com/vi/"+data.getUrl()+"/0.jpg")
                .into(image);
        modelVideo = data;
    }

    private <T extends View> T findView(int id) {
        return (T) itemView.findViewById(id);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), DetailVideoActivity.class);
        String stringInfo = (new Gson().toJson(modelVideo));
        intent.putExtra("video-ebook", stringInfo);
        view.getContext().startActivity(intent);
    }
}
